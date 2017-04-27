package me.cmnt.util;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Util {

	/**
	 * 获得系统当前时间
	 * @return
	 */
	public static String getCurrentTime() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		return f.format(date);
	}
	
}
