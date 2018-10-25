package com.woniu.cbd.test;

import org.junit.Test;

import com.woniu.cbd.util.Md5pwdUtil;

public class TestMain {


	@Test
	public void test() {
		System.out.println(Md5pwdUtil.md5("123456", "qwe123"));
	}
}
