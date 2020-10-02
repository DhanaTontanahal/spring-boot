package com.zemoso.blogservice.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

	private JsonUtils() {

	}

	public static String mapToJson(Object object) {
		String str = null;
		try {
			str = new ObjectMapper().writeValueAsString(object);
		} catch (Exception e) {

		}
		return str;
	}

}
