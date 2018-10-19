package com.woniu.cbd.util;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Md5Hash;

public class Md5pwdUtil {

//	/**
//	 * base64加密
//	 * @param str
//	 * @return
//	 */
//	public static String encBase64(String str){
//		return Base64.encodeToString(str.getBytes());
//	}
//	
//	/**
//	 * base64解密
//	 * @param str
//	 * @return
//	 */
//	public static String decBase64(String str){
//		return Base64.decodeToString(str);
//	}
	
	/**
	 * Md5加密
	 * @param str
	 * @param salt
	 * @return
	 */
	public static String md5(String str,String salt){
		return new Md5Hash(str,salt).toString();
	}
	
	public static void main(String[] args) {
//		String password="123456";
//		System.out.println("Base64加密："+Md5pwdUtil.encBase64(password));
//		System.out.println("Base64解密："+Md5pwdUtil.decBase64(Md5pwdUtil.encBase64(password)));
//		System.out.println("Md5加密："+Md5pwdUtil.md5(password, "superAdmin"));
	}
}
