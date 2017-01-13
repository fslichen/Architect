package com.evolution.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectUtil {
	private static Object getFieldInstance(Object classInstance, String fieldName) {
		try {
			Field field = classInstance.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			Object fieldInstance = field.get(classInstance);
			if (fieldInstance != null) {
				return fieldInstance;
			} else {
				return field.getType().newInstance();
			}
		} catch (Exception e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T runFieldInstance(Object instance, String fieldName, String methodName, Class<T> clazz, Object... parameters) {
		Object fieldInstance = getFieldInstance(instance, fieldName);
		Method[] methods = fieldInstance.getClass().getDeclaredMethods();
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				try {
					return (T) method.invoke(fieldInstance, parameters);
				} catch (Exception e) {}
			}
		}
		return null;
	}
	
	public static <T> Object runFieldInstance(Object instance, String fieldName, String methodName, Object... parameters) {
		return runFieldInstance(instance, fieldName, methodName, Object.class, parameters);
	}
}
