package hje.ex.json.emp.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Result {
	private Map<String, Object> resultMap = new HashMap<String, Object>();
	
	public void setData(String id, Object data) {
		resultMap.put(id, data);
	}
	
	public Map<String, Object> getResult() {
		return resultMap;
	}
}
