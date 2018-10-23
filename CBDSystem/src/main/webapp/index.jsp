<%@ PAGE LANGUAGE="JAVA" CONTENTTYPE="TEXT/HTML; CHARSET=UTF-8"
	PAGEENCODING="UTF-8"%>
<%@ TAGLIB URI="HTTP://JAVA.SUN.COM/JSP/JSTL/CORE" PREFIX="C"%>
<!-- 引入时间插件MY97DATEPICKE中的WDATEPICKER.JS文件 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 TRANSITIONAL//EN" "HTTP://WWW.W3.ORG/TR/HTML4/LOOSE.DTD">

<DIV ID="SHOW">
	<HTML>
<HEAD>
<META HTTP-EQUIV="CONTENT-TYPE" CONTENT="TEXT/HTML; CHARSET=UTF-8">
<TITLE>车位展示</TITLE>
<LINK TYPE="TEXT/CSS" HREF="/CBDSYSTEM/CSS/CSS1.CSS" REL="STYLESHEET" />
<SCRIPT TYPE="TEXT/JAVASCRIPT" SRC="/CBDSYSTEM/JS/JQUERY-1.9.1.MIN.JS"></SCRIPT>
<SCRIPT TYPE="TEXT/JAVASCRIPT" SRC="/CBDSYSTEM/JS/JS.JS"></SCRIPT>
<SCRIPT LANGUAGE="JAVASCRIPT" TYPE="TEXT/JAVASCRIPT"
	SRC="/CBDSYSTEM/JS/DATEUTIL/WDATEPICKER.JS"></SCRIPT>
</HEAD>
<BODY ONLOAD="UPCURRENTPAGE(1)">
	<!-- <BODY > -->
	<DIV CLASS="HRADER" ID="HEADER">
		<DIV CLASS="TOP">
			<A HREF="LOGIN.HTML" STYLE="COLOR:#C94E13;">登录</A> <A HREF="REG.HTML">注册</A>
			<UL CLASS="TOPNAV">
				<!-- <LI><A HREF="ORDER.HTML">我的订单 </A></LI> -->

				<LI CLASS="SHOUCANGJIA"><A HREF="SHOUCANG.HTML">个人中心</A></LI>
				<!-- <LI CLASS="KEFUS"><A HREF="#">客服</A></LI> -->

				<DIV CLASS="CLEARS"></DIV>
			</UL>
		</DIV>
	</DIV>

	<DIV CLASS="MID">
		<H1 CLASS="LOGO" STYLE="TEXT-ALIGN:LEFT;">
			<A HREF="INDEX.HTML"><IMG
				SRC="/CBDSYSTEM/IMAGES/PARKING/IMAGES/LOGO.PNG" WIDTH="304"
				HEIGHT="74" /></A>
		</H1>
		<!--SUBBOX/-->
		<DIV CLASS="DING-GOU">
			<!--DING/-->
			<!-- <DIV CLASS="GOU">
				<A HREF="CAR.HTML"><IMG
					SRC="/CBDSYSTEM/IMAGES/PARKING/IMAGES/GOUWUCHE.JPG" WIDTH="126"
					HEIGHT="32" /></A>
			</DIV> -->
			<!--GOU/-->
			<DIV CLASS="CLEARS"></DIV>
		</DIV>
		<!--DING-GOU/-->
	</DIV>
	<DIV CLASS="NAVBOX NAVBG2">
		<UL CLASS="NAV">
			<LI><A HREF="/CBDSYSTEM/JSP/SHOWPARKINGSPACE.JSP">首页</A></LI>
			<!-- <LI><A HREF="BUY.HTML">个人中心</A></LI>
			<LI CLASS="NAVCUR"><A HREF="SELL.HTML">企业中心</A></LI>
			<LI><A HREF="VIP.HTML">CBD中心</A></LI>
			<LI><A HREF="XUANSHANG.HTML">注册</A></LI> -->
			<!-- <LI><A HREF="LUNTAN.HTML" CLASS="LUNTAN">论坛</A></LI> -->
			<!-- <LI><A HREF="HELP.HTML">帮助</A></LI> -->
			<DIV CLASS="CLEARS"></DIV>
		</UL>
		<!--NAV/-->
	</DIV>
	<!--NAVBOX/-->
	<FORM ACTION="#" METHOD="GET" CLASS="PRODINGZHI">
		<IMG SRC="/CBDSYSTEM/IMAGES/PARKING/IMAGES/TOP2.JPG" WIDTH="972"
			HEIGHT="200" />
		<SCRIPT>
			WINDOW._BD_SHARE_CONFIG = {
				"COMMON" : {
					"BDSNSKEY" : {},
					"BDTEXT" : "",
					"BDMINI" : "2",
					"BDMINILIST" : FALSE,
					"BDPIC" : "",
					"BDSTYLE" : "0",
					"BDSIZE" : "24"
				},
				"SHARE" : {}
			};
			WITH (DOCUMENT)
				0[(GETELEMENTSBYTAGNAME('HEAD')[0] || BODY)
						.APPENDCHILD(CREATEELEMENT('SCRIPT')).SRC = 'HTTP://BDIMG.SHARE.BAIDU.COM/STATIC/API/JS/SHARE.JS?V=89860593.JS?CDNVERSION='
						+ ~(-NEW DATE() / 36E5)];
		</SCRIPT>
		<TABLE CLASS="PRODSEL">


			<TR>
				<TH>
					<H3>按车位号查找：</H3>
				</TH>
				<FORM ACTION="/CBDSYSTEM/FINDBYNUM.DO" METHOD="POST">
					<TD>&NBSP;&NBSP;车位序号：<INPUT TYPE="TEXT" NAME="NUM" />&NBSP;&NBSP;&NBSP;
						<INPUT TYPE="SUBMIT" CLASS="QUEEN" />
					</TD>
				</FORM>

			</TR>

			<TR>
				<TH>
					<H3>按价格查找：</H3>
				</TH>
				<TD>&NBSP;&NBSP;价格区间：<INPUT TYPE="TEXT" />--<INPUT TYPE="TEXT" />&NBSP;元/小时&NBSP;&NBSP;
					<INPUT TYPE="SUBMIT" CLASS="QUEEN" />
				</TD>
			</TR>

			<TR>
				<TH>
					<H3>按时间查找：</H3>
				</TH>
				<TD>&NBSP;&NBSP;时间区间：<INPUT CLASS="WDATE" TYPE="TEXT"
					ONCLICK="WDATEPICKER({DATEFMT:'YYYY-MM-DD HH:MM:SS'})" />--&NBSP;<INPUT
					CLASS="WDATE" TYPE="TEXT"
					ONCLICK="WDATEPICKER({DATEFMT:'YYYY-MM-DD HH:MM:SS'})" />&NBSP;
					&NBSP; <INPUT TYPE="SUBMIT" CLASS="QUEEN" />
				</TD>
			</TR>




			<!--*****************************************************************************  -->
			<!-- <TR>
				<TH>
					<H3>高级功能</H3>
				</TH>
				<TD>
					<DIV CLASS="PROPOSITION">
						<UL CLASS="XUAN MOREHEIGHT">
							<LI><INPUT TYPE="CHECKBOX" /><A HREF="#">双卡双待</A></LI>
							<LI><INPUT TYPE="CHECKBOX" /><A HREF="#">高清视频</A></LI>
							<LI><INPUT TYPE="CHECKBOX" /><A HREF="#">WIFI</A></LI>
							<LI><INPUT TYPE="CHECKBOX" /><A HREF="#">前置摄像头</A></LI>
							<LI><INPUT TYPE="CHECKBOX" /><A HREF="#">电视播放</A></LI>
							<DIV CLASS="CLEARFIX"></DIV>
						</UL>
						XUAN/
						<SPAN CLASS="DUOXUAN"> 多选 </SPAN>
						DUOXUAN/
						<INPUT TYPE="IMAGE" SRC="/CBDSYSTEM/IMAGES/PARKING/IMAGES/QUEDING.PNG" CLASS="QUEEN2" />
					</DIV>
				</TD>
			</TR> -->


			<!-- ********************************************************************** -->
			<!-- <TR>
				<TD COLSPAN="2">
					<UL CLASS="XUAN2">
						<LI><A HREF="#">网络制式</A>
							<DIV CLASS="CHILXUAN">
								<DIV CLASS="CHILXBOX">
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项1</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项2</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项3</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项4</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项5</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项6</A>
									</DIV>
									<DIV CLASS="CLEARS"></DIV>
									<SPAN CLASS="DUOXUAN"> 多选 </SPAN>
									DUOXUAN/
									<INPUT TYPE="IMAGE" SRC="/CBDSYSTEM/IMAGES/PARKING/IMAGES/QUEDING.PNG" CLASS="QUEEN2" />
								</DIV>
								CHILXBOX
							</DIV>
							CHILXUAN/</LI>
						<LI><A HREF="#">摄像头像素</A>
							<DIV CLASS="CHILXUAN">
								<DIV CLASS="CHILXBOX">
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项1</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项2</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项3</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项4</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项5</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项6</A>
									</DIV>
									<DIV CLASS="CLEARS"></DIV>
									<SPAN CLASS="DUOXUAN"> 多选 </SPAN>
									DUOXUAN/
									<INPUT TYPE="IMAGE" SRC="/CBDSYSTEM/IMAGES/PARKING/IMAGES/QUEDING.PNG" CLASS="QUEEN2" />
								</DIV>
								CHILXBOX
							</DIV>
							CHILXUAN/</LI>
						<LI><A HREF="#">上市时间</A>
							<DIV CLASS="CHILXUAN">
								<DIV CLASS="CHILXBOX">
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项1</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项2</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项3</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项4</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项5</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项6</A>
									</DIV>
									<DIV CLASS="CLEARS"></DIV>
									<SPAN CLASS="DUOXUAN"> 多选 </SPAN>
									DUOXUAN/
									<INPUT TYPE="IMAGE" SRC="/CBDSYSTEM/IMAGES/PARKING/IMAGES/QUEDING.PNG" CLASS="QUEEN2" />
								</DIV>
								CHILXBOX
							</DIV>
							CHILXUAN/</LI>
						<LI><A HREF="#">显示屏尺寸</A>
							<DIV CLASS="CHILXUAN">
								<DIV CLASS="CHILXBOX">
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项1</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项2</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项3</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项4</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项5</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项6</A>
									</DIV>
									<DIV CLASS="CLEARS"></DIV>
									<SPAN CLASS="DUOXUAN"> 多选 </SPAN>
									DUOXUAN/
									<INPUT TYPE="IMAGE" SRC="/CBDSYSTEM/IMAGES/PARKING/IMAGES/QUEDING.PNG" CLASS="QUEEN2" />
								</DIV>
								CHILXBOX
							</DIV>
							CHILXUAN/</LI>
						<LI><A HREF="#">操控</A>
							<DIV CLASS="CHILXUAN">
								<DIV CLASS="CHILXBOX">
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项1</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项2</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项3</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项4</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项5</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项6</A>
									</DIV>
									<DIV CLASS="CLEARS"></DIV>
									<SPAN CLASS="DUOXUAN"> 多选 </SPAN>
									DUOXUAN/
									<INPUT TYPE="IMAGE" SRC="/CBDSYSTEM/IMAGES/PARKING/IMAGES/QUEDING.PNG" CLASS="QUEEN2" />
								</DIV>
								CHILXBOX
							</DIV>
							CHILXUAN/</LI>
						<LI><A HREF="#">外观</A>
							<DIV CLASS="CHILXUAN">
								<DIV CLASS="CHILXBOX">
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项1</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项2</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项3</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项4</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项5</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项6</A>
									</DIV>
									<DIV CLASS="CLEARS"></DIV>
									<SPAN CLASS="DUOXUAN"> 多选 </SPAN>
									DUOXUAN/
									<INPUT TYPE="IMAGE" SRC="/CBDSYSTEM/IMAGES/PARKING/IMAGES/QUEDING.PNG" CLASS="QUEEN2" />
								</DIV>
								CHILXBOX
							</DIV>
							CHILXUAN/</LI>
						<LI><A HREF="#">系统</A>
							<DIV CLASS="CHILXUAN">
								<DIV CLASS="CHILXBOX">
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项1</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项2</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项3</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项4</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项5</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项6</A>
									</DIV>
									<DIV CLASS="CLEARS"></DIV>
									<SPAN CLASS="DUOXUAN"> 多选 </SPAN>
									DUOXUAN/
									<INPUT TYPE="IMAGE" SRC="/CBDSYSTEM/IMAGES/PARKING/IMAGES/QUEDING.PNG" CLASS="QUEEN2" />
								</DIV>
								CHILXBOX
							</DIV>
							CHILXUAN/</LI>
						<LI><A HREF="#">屏幕色彩</A>
							<DIV CLASS="CHILXUAN">
								<DIV CLASS="CHILXBOX">
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项1</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项2</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项3</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项4</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项5</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项6</A>
									</DIV>
									<DIV CLASS="CLEARS"></DIV>
									<SPAN CLASS="DUOXUAN"> 多选 </SPAN>
									DUOXUAN/
									<INPUT TYPE="IMAGE" SRC="/CBDSYSTEM/IMAGES/PARKING/IMAGES/QUEDING.PNG" CLASS="QUEEN2" />
								</DIV>
								CHILXBOX
							</DIV>
							CHILXUAN/</LI>
						<LI><A HREF="#">分辨率</A>
							<DIV CLASS="CHILXUAN">
								<DIV CLASS="CHILXBOX">
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项1</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项2</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项3</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项4</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项5</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项6</A>
									</DIV>
									<DIV CLASS="CLEARS"></DIV>
									<SPAN CLASS="DUOXUAN"> 多选 </SPAN>
									DUOXUAN/
									<INPUT TYPE="IMAGE" SRC="/CBDSYSTEM/IMAGES/PARKING/IMAGES/QUEDING.PNG" CLASS="QUEEN2" />
								</DIV>
								CHILXBOX
							</DIV>
							CHILXUAN/</LI>
						<LI><A HREF="#">电池可拆卸</A>
							<DIV CLASS="CHILXUAN">
								<DIV CLASS="CHILXBOX">
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项1</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项2</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项3</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项4</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项5</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项6</A>
									</DIV>
									<DIV CLASS="CLEARS"></DIV>
									<SPAN CLASS="DUOXUAN"> 多选 </SPAN>
									DUOXUAN/
									<INPUT TYPE="IMAGE" SRC="/CBDSYSTEM/IMAGES/PARKING/IMAGES/QUEDING.PNG" CLASS="QUEEN2" />
								</DIV>
								CHILXBOX
							</DIV>
							CHILXUAN/</LI>
						<LI><A HREF="#">单卡双卡</A>
							<DIV CLASS="CHILXUAN">
								<DIV CLASS="CHILXBOX">
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项1</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项2</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项3</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项4</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项5</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项6</A>
									</DIV>
									<DIV CLASS="CLEARS"></DIV>
									<SPAN CLASS="DUOXUAN"> 多选 </SPAN>
									DUOXUAN/
									<INPUT TYPE="IMAGE" SRC="/CBDSYSTEM/IMAGES/PARKING/IMAGES/QUEDING.PNG" CLASS="QUEEN2" />
								</DIV>
								CHILXBOX
							</DIV>
							CHILXUAN/</LI>
						<LI><A HREF="#">手机内存</A>
							<DIV CLASS="CHILXUAN">
								<DIV CLASS="CHILXBOX">
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项1</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项2</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项3</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项4</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项5</A>
									</DIV>
									<DIV>
										<INPUT TYPE="CHECKBOX" /><A HREF="#">选项6</A>
									</DIV>
									<DIV CLASS="CLEARS"></DIV>
									<SPAN CLASS="DUOXUAN"> 多选 </SPAN>
									DUOXUAN/
									<INPUT TYPE="IMAGE" SRC="/CBDSYSTEM/IMAGES/PARKING/IMAGES/QUEDING.PNG" CLASS="QUEEN2" />
								</DIV>
								CHILXBOX
							</DIV>
							CHILXUAN/</LI>
						<DIV CLASS="CLEARFIX"></DIV>
					</UL>
					XUAN2/
				</TD>
			</TR> -->
		</TABLE>

		<!--PRODSEL/-->
		<!-- <DIV STYLE="HEIGHT:15PX;">&NBSP;</DIV>
		<UL CLASS="PROSELECT">
			<LI>综合</LI>
			<LI>销量 &DARR;</LI>
			<LI>评论 &DARR;</LI>
			<LI>价格 &DARR;</LI>
			<DIV CLASS="CLEARS"></DIV>
		</UL> -->




		<!--**********车位展示部分**********************************************************************************************-->
		<DIV ID="SHOWPARKING" CLASS="PHONEBOX">
			<C:FOREACH ITEMS="${ALL}" VAR="PARKING">
				<DL>
					<DT>
						<IMG SRC="${PARKING.IMG}" />
					</DT>
					<DD>
						<H3>价格：${PARKING.PRICE}元/小时</H3>
						<DIV CLASS="PHONEPARS">地址：${PARKING.ADDRESS}</DIV>
						<!--PHONEPAR/-->
						<!-- <DIV CLASS="XIAOLIANG">
						<SPAN CLASS="BLUE">157451条评价</SPAN> <SPAN CLASS="PAD">上海有货</SPAN>
					</DIV> -->
						<!--XIAOLIANG/-->
						<DIV CLASS="JIARU-SHOUCANG">
							<SPAN CLASS="JIARUCAR">收藏车位</SPAN> <SPAN CLASS="SHOUCANGCAR"><A
								HREF="/CBDSYSTEM/SHOWONE.DO?ID=${PARKING.ID}">查看详情</A></SPAN>
							<DIV CLASS="CLEARS"></DIV>
						</DIV>
						<!--JIARU-SHOUCANG/-->
					</DD>
				</DL>
			</C:FOREACH>

			<!-- ***************************************** 分页部分 *****************************************************-->
			<DIV CLASS="PAGE">
				<DIV CLASS="CONTENT-BOTTOM-PAGING">
					<A HREF="#" ONCLICK="UPCURRENTPAGE(${PAGING.LASTPAGE})">末页</A>
				</DIV>

				<DIV CLASS="CONTENT-BOTTOM-PAGING">
					<SCRIPT TYPE="TEXT/JAVASCRIPT">
				</SCRIPT>
					<C:IF TEST="${PAGING.HASNEXTPAGE}">
						<A TARGET="MAINFRAME" HREF="#"
							ONCLICK="UPCURRENTPAGE(${PAGING.NEXTPAGE})">下一页</A>
					</C:IF>
				</DIV>

				<DIV ID="PAGE" CLASS="CONTENT-BOTTOM-PAGING">
					<SPAN ID="CURRENTPAGE">${PAGING.PAGENUM}</SPAN>/<SPAN ID="TOLPAGE">${PAGING.PAGES}</SPAN>
				</DIV>
				<DIV CLASS="CONTENT-BOTTOM-PAGING">
					<C:IF TEST="${PAGING.HASPREVIOUSPAGE}">
						<A HREF="#" ONCLICK="UPCURRENTPAGE(${PAGING.PREPAGE})">上一页</A>
					</C:IF>
				</DIV>
				<DIV CLASS="CONTENT-BOTTOM-PAGING">
					<A HREF="#" ONCLICK="UPCURRENTPAGE(${PAGING.FIRSTPAGE})">首页</A>
				</DIV>
			</DIV>





			<DIV CLASS="CLEARS"></DIV>
		</DIV>
		<!--PHONEBOX/-->
	</FORM>
	<!--PRODINGZHI/-->
	<DIV CLASS="FOOTBOX">
		<DIV CLASS="FOOTERS">
			<DIV CLASS="FOOTERSLEFT">
				<A HREF="INDEX.HTML"><IMG
					SRC="/CBDSYSTEM/IMAGES/PARKING/IMAGES/FTLOGO.JPG" WIDTH="240"
					HEIGHT="64" /></A>
				<H3 CLASS="FTPHONE">400 000 0000</H3>
				<DIV CLASS="FTKE">
					客服 7X24小时(全年无休)<BR /> <SPAN>客服邮箱：KEFU@WEBQIN.NET </SPAN>
				</DIV>
				<!--FTKE/-->
			</DIV>
			<!--FOOTERSLEFT/-->
			<DIV CLASS="FOOTERSRIGHT">
				<UL>
					<LI CLASS="FTTITLE">新手指南</LI>
					<LI><A HREF="#">下单流程</A></LI>
					<LI><A HREF="#">会员计划</A></LI>
					<LI><A HREF="#">优惠规则</A></LI>
					<LI><A HREF="#">联系客服</A></LI>
					<LI><A HREF="#">常见问题</A></LI>
				</UL>
				<UL>
					<LI CLASS="FTTITLE">付款方式</LI>
					<LI><A HREF="#">在线支付</A></LI>
					<LI><A HREF="#">优惠券支付</A></LI>
					<LI><A HREF="#">现金支付</A></LI>
					<LI><A HREF="#">银行付款</A></LI>
				</UL>
				<UL>
					<LI CLASS="FTTITLE">订单服务</LI>
					<LI><A HREF="#">下单时效</A></LI>
					<LI><A HREF="#">下单超时</A></LI>
					<LI><A HREF="#">下单须知</A></LI>
					<LI><A HREF="#">查看订单</A></LI>
				</UL>
				<UL>
					<LI CLASS="FTTITLE">发票服务</LI>
					<LI><A HREF="#">发票申请</A></LI>
					<LI><A HREF="#">电子发票</A></LI>
					<LI><A HREF="#">纸质发票</A></LI>
					<LI><A HREF="#">补印发票</A></LI>
					<LI><A HREF="#">发票说明</A></LI>
				</UL>
				<UL>
					<LI CLASS="FTTITLE">特色服务</LI>
					<LI><A HREF="#">礼品卡</A></LI>
					<LI><A HREF="#">车位试用</A></LI>
					<LI><A HREF="#">车位中心</A></LI>
					<LI><A HREF="#">快速下单</A></LI>
					<LI><A HREF="#">推荐车位</A></LI>
				</UL>

				<DIV CLASS="CLEARS"></DIV>
			</DIV>
			<!--FOOTBOX/-->
			<
			<!-- DIV CLASS="FOOTER" STYLE="TEXT-ALIGN:LEFT;">
		<A HREF="#">关于我们</A> <A HREF="#">友情链接</A> <A HREF="#">版权声明</A> <A
			HREF="#">网站地图</A> <BR /> <SPAN>&COPY; 2014 UNQEZI 使用前必读 更多模板：<A
			HREF="HTTP://WWW.MYCODES.NET/" TARGET="_BLANK">源码之家</A></SPAN>
	</DIV> -->
			<!--FOOTER/-->

			<!-- 引入外部JS文件 -->
			<SCRIPT TYPE="TEXT/JAVASCRIPT"
				SRC="/CBDSYSTEM/JS/SHOWPARKINGSPACE.JS"></SCRIPT>
</BODY>
	</HTML>
</DIV>