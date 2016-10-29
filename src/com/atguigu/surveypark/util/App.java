package com.atguigu.surveypark.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class App {
	
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		StringBuffer sb = new StringBuffer();
		char[] chars = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		String src = "abc";
		byte[] bytes = src.getBytes();
		MessageDigest MD = MessageDigest.getInstance("MD5");
		byte[] targ =  MD.digest(bytes);
		for(byte b: targ){
			sb.append(chars[(b >> 4 ) & 0x0F]);
			sb.append(chars[b & 0x0F]);
		}
		System.out.println(sb.toString());
	}
}
