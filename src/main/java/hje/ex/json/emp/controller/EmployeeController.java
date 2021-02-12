package hje.ex.json.emp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hje.ex.json.emp.dto.EmployeeDto;
import hje.ex.json.emp.util.JsonUtil;
import hje.ex.json.emp.util.Result;

@Controller
@RequestMapping(value = "/emp")
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	private static List<EmployeeDto> empList = new ArrayList<EmployeeDto>();
	
	@RequestMapping(value = "/list1", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getEmployeeList1() {
		Result result = new Result();
		result.setData("emps", empList);
		
		return result.getResult(); // {"emps":null}
	}
	
	@RequestMapping(value = "/list2", method = RequestMethod.GET)
	@ResponseBody
	public String getEmployeeList2() {
		Result result = new Result();
		result.setData("emps", empList);
		
		return JsonUtil.writeValue(result); // {"result":{"emps":null}}
	}
	
	@RequestMapping(value = "/add1", method = RequestMethod.POST, headers={"content-type=application/json"})
	@ResponseBody
	public void insertEmployee1(@RequestBody EmployeeDto employeeDto) {
		logger.debug("employeeDto is '{}'", employeeDto);
		empList.add(employeeDto);
		logger.debug("===== empList start =====");
		for(EmployeeDto emp : empList) {
			logger.debug("emp is '{}'", emp);
		}
		logger.debug("===== empList end   =====");
	}
	
	@RequestMapping(value = "/add2", method = RequestMethod.POST, headers={"content-type=application/json"})
	public String insertEmployee2(@RequestBody EmployeeDto employeeDto) {
		logger.debug("employeeDto is '{}'", employeeDto);
		empList.add(employeeDto);
		logger.debug("===== empList start =====");
		for(EmployeeDto emp : empList) {
			logger.debug("emp is '{}'", emp);
		}
		logger.debug("===== empList end   =====");
		return "redirect:/emp/list1";
	}
}
