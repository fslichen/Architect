package com.evolution.util.reflectUtil;

public class AnotherClass {
	public String anyMethod(String string) {
		System.out.println(string);
		return string;
	}
	
	public String anyMethod(String string0, String string1) {
		String combinedString = string0 + " " + string1;
		System.out.println(combinedString);
		return combinedString;
	}
	
	public String anyMethod(String string0, String string1, String string2) {
		String combinedString = string0 + " " + string1 + " " + string2;
		System.out.println(combinedString);
		return combinedString;
	}
}
