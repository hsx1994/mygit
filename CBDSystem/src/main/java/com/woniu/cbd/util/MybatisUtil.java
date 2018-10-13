package com.woniu.cbd.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 类名：MybatisUtil 作用：MybatisUtil相关工具包装
 * 
 * @author wt
 *
 */
public class MybatisUtil {

	/**
	 * 产生工厂对象
	 * 
	 * @return
	 */
	public static SqlSessionFactory getSqlSessionFactory() {
		SqlSessionFactory fa = null;
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			fa = (SqlSessionFactory) context.getBean("sqlSessionFactory");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return fa;
	}

	/**
	 * 产生sqlsession对象
	 * 
	 * @return
	 */
	public static SqlSession getSession() {
		SqlSession session = getSqlSessionFactory().openSession();
		return session;
	}

	/**
	 * 
	 * @param boo
	 *            boo:true 自动提交事务
	 * @return
	 */
	public static SqlSession getSession(boolean boo) {
		SqlSession session = getSqlSessionFactory().openSession(boo);
		return session;
	}

}
