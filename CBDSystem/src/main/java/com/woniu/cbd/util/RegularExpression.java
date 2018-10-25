package com.woniu.cbd.util;

public class RegularExpression {
		//1.	国际电话号码验证
		//		以数字或+开头 
		//		后面的必须是数字长度在 12 到 13
		public static boolean testTel(String tel) {
			String regex = "^1(3[0-9]|5[0-35-9]|77|8[0-9]|47)\\d{8}$";
			return tel.matches(regex);
		}
		//2.	注册电子邮箱验证
		//			邮箱地址必须包含@字符
		//			邮箱@的左边必须以字母, 下划线, 数字开头, 且必须有一个
		//			邮箱@的左边除了开头字母其他的可以是字母, 下划线, 数字， 点号 . 小杠 -
		//			邮箱@的右边必须有 . 点号
		//			在 @ 和 . 之间必须以字母, 下划线, 数字开头, 且除了开头字母其他的可以是字母, 下划线, 数字， 点号 . 小杠 -
		//			在 . 点号后面至少有一个 字母, 下划线, 数字开头
		public static boolean testEmail(String email) {
			String regex = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$";
			return email.matches(regex);
		}

		//	身份证验证
		//	身份证号码必须为15位或18位数字
		public static boolean testIdentity(String identity) {
			String regex = "^((1[1-5])|(2[1-3])|(3[1-7])|(4[1-6])|(5[0-4])|(6[1-5])|71|(8[12])|91)\\d{4}(((((19|20)((\\d{2}(0[13-9]|1[012])(0[1-9]|[12]\\d|30))|(\\d{2}(0[13578]|1[02])31)|(\\d{2}02(0[1-9]|1\\d|2[0-8]))|(([13579][26]|[2468][048]|0[48])0229)))|20000229)\\d{3}(\\d|X|x))|(((\\d{2}(0[13-9]|1[012])(0[1-9]|[12]\\d|30))|(\\d{2}(0[13578]|1[02])31)|(\\d{2}02(0[1-9]|1\\d|2[0-8]))|(([13579][26]|[2468][048]|0[48])0229))\\d{3}))$";
			return identity.matches(regex);
		}

		//3.	论坛注册用户名验证
		//		必须以字母开头
		//		只能包括 字母 , 下划线 , 数字
		//		长度必须在6 到 10 之间
		public static boolean checkUsername(String username) {
			//String regex="[a-zA-Z][0-9a-zA-Z_]{5,9}";
			//String regex="[a-zA-Z][\\da-zA-Z_]{5,9}";// \d  要转成 \\d
			String regex = "^[a-zA-Z][a-zA-Z0-9_]*$";
			return username.matches(regex);
		}

		//密码（6-16位数字和字母的组合）：^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$
		public static boolean testPassword(String pass) {
			String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$";
			return pass.matches(regex);
		}
}

