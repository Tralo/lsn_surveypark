package com.atguigu.surveypark.util;

import java.security.MessageDigest;
/**
 * 数据工具类
 */
public class DataUtil {
	/**
	 * 使用md5算法进行加密
	 */
	public static String md5(String src) {
		try {
			StringBuffer sb = new StringBuffer();
			char[] chars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
					'B', 'C', 'D', 'E', 'F' };
			byte[] bytes = src.getBytes();
			MessageDigest MD = MessageDigest.getInstance("MD5");
			byte[] targ = MD.digest(bytes);
			for (byte b : targ) {
				sb.append(chars[(b >> 4) & 0x0F]);
				sb.append(chars[b & 0x0F]);
			}
			return sb.toString();
		} catch (Exception e) {
		}
		return null;
	}

}
