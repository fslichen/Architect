package com.evolution.util;

import java.util.Map;

import org.junit.Test;

import com.evolution.entity.AnotherEntity;
import com.evolution.entity.AnyEntity;
import com.evolution.entity.LoginInfo;

public class PojoUtilTest {
//	@Test
	public void testMapAndPojo() {
		AnyEntity anyEntity = new AnyEntity();
		anyEntity.setName("Chen");
		anyEntity.setGender("M");
		AnotherEntity anotherEntity = new AnotherEntity();
		anotherEntity.setPhone("217-819-9008");
		anyEntity.setAnotherEntity(anotherEntity);
		Map<String, Object> map = PojoUtil.pojo2Map(anyEntity, Object.class);
		System.out.println(map);
		AnyEntity anyEntity0 = PojoUtil.map2Pojo(map, AnyEntity.class, "gender");
		System.out.println(anyEntity0);
	}
	
//	@Test
	public void testJson2Map() {
		Map<String, String> map = PojoUtil.json2Map("{\"name\" : \"Chen\"}", AnyEntity.class, String.class, "gender", "anotherEntity");
		System.out.println(map);
	}
	
	@Test
	public void testNullValueExists() {
		LoginInfo info = new LoginInfo();
		info.setHost("");
		info.setPort(12);
		System.out.println(PojoUtil.nullValueExists(info, "host", "port", "password"));
	}
}
