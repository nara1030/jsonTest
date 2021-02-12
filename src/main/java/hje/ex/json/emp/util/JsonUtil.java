package hje.ex.json.emp.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

@Component
public class JsonUtil {
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	public static final <T> T readValue(String json, Class<T> clazz) {
		try {
			return objectMapper.readValue(json, clazz);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static final <T> List<T> toList(Object obj, Class<T> clazz) {
		return objectMapper.convertValue(obj, TypeFactory.defaultInstance().constructCollectionType(List.class, clazz));
	}
	
	public static final String writeValue(Object obj) {
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
