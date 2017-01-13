package com.evolution.util.reflectUtil;

import org.junit.Test;

import com.evolution.util.ReflectUtil;

public class ReflectUtilTest {
	private AnyClass anyClass;
	
	private AnotherClass anotherClass = new AnotherClass();
	
	@Test
	public void test() {
		ReflectUtil.runFieldInstance(this, "anyClass", "anyMethod", "Hello", "World");
		String combinedString = ReflectUtil.runFieldInstance(this, "anotherClass", "anyMethod", String.class, "How", "Are", "You");
		System.out.println(combinedString);
	}
}
