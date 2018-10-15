package com.woniu.cbd.util;

import java.util.Date;

public class DateUtil {
	
	public static double timeMinus(Date startTime,Date endTime) {
		long time = 0;
		if (endTime.compareTo(startTime)>=0) {
			time = endTime.getTime()-startTime.getTime();
		}else {
			time = startTime.getTime()-endTime.getTime();
		}
		double hours = Math.ceil((double)time/3600000);
		return hours;
	}
}
