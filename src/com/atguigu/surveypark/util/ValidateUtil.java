package com.atguigu.surveypark.util;

import java.util.Collection;

public class ValidateUtil {
	
	/**
	 * 判断是否为空
	 * @param src
	 * @return
	 */
	public static boolean isValid(String src){
		if(src == null || "".equals(src)){
			return false;
		}
		return true;
	}
	/**
	 * 判断集合的有效性
	 * @param col
	 * @return
	 */
	public static boolean isValid(Collection col){
		if(col == null || col.isEmpty()){
			return false;
		}
		
		return true;
	}
	
}
