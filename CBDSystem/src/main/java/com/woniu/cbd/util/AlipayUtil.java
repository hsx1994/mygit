package com.woniu.cbd.util;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.demo.trade.config.Configs;
import com.alipay.demo.trade.model.ExtendParams;
import com.alipay.demo.trade.model.GoodsDetail;
import com.alipay.demo.trade.model.builder.AlipayTradePrecreateRequestBuilder;
import com.alipay.demo.trade.model.builder.AlipayTradeQueryRequestBuilder;
import com.alipay.demo.trade.model.result.AlipayF2FPrecreateResult;
import com.alipay.demo.trade.model.result.AlipayF2FQueryResult;
import com.alipay.demo.trade.service.AlipayTradeService;
import com.alipay.demo.trade.service.impl.AlipayTradeServiceImpl;
import com.alipay.demo.trade.utils.ZxingUtils;
import com.woniu.cbd.bean.OrderBean;

public class AlipayUtil {
	public static String getQRcode(HttpServletRequest request,OrderBean order){
		String image = null;
		
		Log log = LogFactory.getLog("trade_precreate");

	    if(order.getId()!=0){
	        // 一定要在创建AlipayTradeService之前设置参数
	        Configs.init("zfbinfo.properties");
	        AlipayTradeService tradeService = new AlipayTradeServiceImpl.ClientBuilder().build();

	        // (必填) 商户网站订单系统中唯一订单号，64个字符以内，只能包含字母、数字、下划线，
	        // 需保证商户系统端不能重复，建议通过数据库sequence生成，
	        String outTradeNo = String.valueOf(order.getId());

	        // (必填) 订单标题，粗略描述用户的支付目的。如“喜士多（浦东店）消费”
	        String subject = "CBDSystem车位租赁支付";

	        // (必填) 订单总金额，单位为元，不能超过1亿元
	        // 如果同时传入了【打折金额】,【不可打折金额】,【订单总金额】三者,则必须满足如下条件:【订单总金额】=【打折金额】+【不可打折金额】
	        String totalAmount = String.valueOf(order.getPay());

	        // (可选) 订单不可打折金额，可以配合商家平台配置折扣活动，如果酒水不参与打折，则将对应金额填写至此字段
	        // 如果该值未传入,但传入了【订单总金额】,【打折金额】,则该值默认为【订单总金额】-【打折金额】
	        String undiscountableAmount = request.getParameter("undiscountableAmount");

	        // 卖家支付宝账号ID，用于支持一个签约账号下支持打款到不同的收款账号，(打款到sellerId对应的支付宝账号)
	        // 如果该字段为空，则默认为与支付宝签约的商户的PID，也就是appid对应的PID
	        String sellerId = "";

	        // 订单描述，可以对交易或商品进行一个详细地描述，比如填写"购买商品2件共15.00元"
	        String body = "购买商品2件共15.00元";

	        // 商户操作员编号，添加此参数可以为商户操作员做销售统计
	        String operatorId = "test_operator_id";

	        // (必填) 商户门店编号，通过门店号和商家后台可以配置精准到门店的折扣信息，详询支付宝技术支持
	        String storeId = "test_store_id";

	        // 业务扩展参数，目前可添加由支付宝分配的系统商编号(通过setSysServiceProviderId方法)，详情请咨询支付宝技术支持
	        ExtendParams extendParams = new ExtendParams();
	        extendParams.setSysServiceProviderId("2088100200300400500");

	        // 支付超时，定义为120分钟
	        String timeoutExpress = "120m";

	        // 商品明细列表，需填写购买商品详细信息，
	        List<GoodsDetail> goodsDetailList = new ArrayList<GoodsDetail>();
	        // 创建一个商品信息，参数含义分别为商品id（使用国标）、名称、单价（单位为分）、数量，如果需要添加商品类别，详见GoodsDetail
	   

	       // AlipayTradePrecreateContentBuilder builder = new AlipayTradePrecreateContentBuilder()
	        		
	        AlipayTradePrecreateRequestBuilder builder =new AlipayTradePrecreateRequestBuilder()
	                .setSubject(subject)
	                .setTotalAmount(totalAmount)
	                .setOutTradeNo(outTradeNo)
	                .setUndiscountableAmount(undiscountableAmount)
	                .setSellerId(sellerId)
	                .setBody(body)
	                .setOperatorId(operatorId)
	                .setStoreId(storeId)
	                .setExtendParams(extendParams)
	                .setTimeoutExpress(timeoutExpress)
//	              .setNotifyUrl("http://www.test-notify-url.com")//支付宝服务器主动通知商户服务器里指定的页面http路径,根据需要设置
	                .setGoodsDetailList(goodsDetailList);

	        AlipayF2FPrecreateResult result = tradeService.tradePrecreate(builder);
	        switch (result.getTradeStatus()) {
	            case SUCCESS:
	                log.info("支付宝预下单成功: )");

	                AlipayTradePrecreateResponse res = result.getResponse();

	                String basePath = request.getSession().getServletContext().getRealPath("/");
	                String fileName = String.format("images%sqr-%s.png", File.separator, res.getOutTradeNo());
	                String filePath = new StringBuilder(basePath).append(fileName).toString();

	                image =fileName;
	                ZxingUtils.getQRCodeImge(res.getQrCode(), 256, filePath);
	                break;

	            case FAILED:
	                log.error("支付宝预下单失败!!!");
	                break;

	            case UNKNOWN:
	                log.error("系统异常，预下单状态未知!!!");
	                break;

	            default:
	                log.error("不支持的交易状态，交易返回异常!!!");
	                break;
	        }
	        
	    }
		return image;
	}
	
	public static String QueryState(HttpServletRequest request,int orderId){
		String payState = null;
		Log log = LogFactory.getLog("trade_query");

		if(orderId!=0){
			// 一定要在创建AlipayTradeService之前设置参数
			Configs.init("zfbinfo.properties");

			AlipayTradeService tradeService = new AlipayTradeServiceImpl.ClientBuilder().build();

			// (必填) 商户订单号，通过此商户订单号查询当面付的交易状态
			String outTradeNo = String.valueOf(orderId);
	        AlipayTradeQueryRequestBuilder builder = new AlipayTradeQueryRequestBuilder()
	        		.setOutTradeNo(outTradeNo);
			AlipayF2FQueryResult result = tradeService.queryTradeResult(builder);
			switch (result.getTradeStatus()) {
				case SUCCESS:
					log.info("查询返回该订单支付成功: )");

					AlipayTradeQueryResponse resp = result.getResponse();

					log.info(resp.getTradeStatus());
					payState = resp.getTradeStatus();
					log.info(resp.getFundBillList());
					break;

				case FAILED:
					log.error("查询返回该订单支付失败!!!");
					break;

				case UNKNOWN:
					log.error("系统异常，订单支付状态未知!!!");
					break;

				default:
					log.error("不支持的交易状态，交易返回异常!!!");
					break;
			}
		}
		return payState;
	}
}
