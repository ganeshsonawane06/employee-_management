package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping(path="/employee")
public class EmpController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private ObjectMapper mapper;

	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody(required = true) Employee employee, HttpServletRequest request) throws JsonProcessingException {
		//String user = request.getHeader("user");
		//employee.setCreatedBy(user);
		//employee.setUpdateBy(user);
		return mapper.writeValueAsString(employeeService.addEmployee(employee));
	}

	@GetMapping(path = "/getAllEmployee")
	public String getAllEmployees() throws JsonProcessingException {

		return mapper.writeValueAsString(employeeService.getAllEmployee());
	}

	@PostMapping(path = "/updateEmployee")
	public String updateEmployee(@RequestBody(required = true) Employee employee, HttpServletRequest request) throws JsonProcessingException {
		String user = request.getHeader("user");
		if(employee.getCreatedBy() == null)
			employee.setCreatedBy(user);
		employee.setUpdateBy(user);
		return mapper.writeValueAsString(employeeService.updateEmployee(employee));
	}

	@GetMapping(value = "/getEmployeeById")
	public String getEmployeeById(@RequestParam(name = "employeeId", required = true) long employeeId)
			throws JsonProcessingException {

		return mapper.writeValueAsString(employeeService.getEmployee(employeeId));
	}

	@GetMapping(path = "/deleteEmployee")
	public String deleteEmployee(@RequestParam(name = "employeeId", required = true) long employeeId)
			throws JsonProcessingException {

		return mapper.writeValueAsString(employeeService.deleteEmployee(employeeId));
	}

}
