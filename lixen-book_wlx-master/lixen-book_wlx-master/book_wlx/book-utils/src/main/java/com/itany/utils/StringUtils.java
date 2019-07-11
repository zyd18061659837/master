package com.itany.utils;

import java.util.UUID;

public class StringUtils {

	public static String rename(String fileName) {
		int lastDot = fileName.lastIndexOf(".");
		String suffix = fileName.substring(lastDot);
		return idGenerate() + suffix;
	}

	public static String idGenerate() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str){
		return str == null || "".equals(str);
	}



}
