package com.test.springboot.hibernate.common.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtil {
	
	public static <T> String POJO2JSON(T object) {

		try {

			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(object);
			
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} 
		
		return null;
	}
	
	public static String Map2JSON(Map<String, String> map, boolean prettyPrint) {

		try {

			ObjectMapper mapper = new ObjectMapper();

			// convert map to JSON string
			if(!prettyPrint)
				return mapper.writeValueAsString(map);
			else
				return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
			
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} 
		
		return null;
	}
	
	public static Map<String, String> JSON2Map(String json) {

		try {

			ObjectMapper mapper = new ObjectMapper();

			// convert JSON string to Map
			return mapper.readValue(json, new TypeReference<Map<String, String>>(){});
			
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return null;
	}
	
	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<>();
		map.put("name", "john");
		map.put("city", "banglore");
		map.put("country", "india");
		
		String str = JSONUtil.Map2JSON(map, false);
		System.out.println(str);
		
		String str1 = JSONUtil.Map2JSON(map, true);
		System.out.println(str1);
		
		Map<String, String> map1 = JSONUtil.JSON2Map(str1);
		System.out.println(map1);
		
	}
	
	

}
