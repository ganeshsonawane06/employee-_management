package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.entity.EmployeeResponse;
import com.employee.repository.EmployeeRepo;
import com.employee.utils.Utils;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;

	public EmployeeResponse addEmployee(Employee employee) {
		EmployeeResponse response = new EmployeeResponse();
		try {
			Employee saved_emp = employeeRepo.save(employee);
			
			response.setEmployee(saved_emp);
			response.setMessage(Utils.CONST_SUCCESS);
			
			return response;
		} catch (Exception e) {
			response.setMessage("Please provide valid employee details ! Error:: "+e.getMessage());
			return response;
		}
	}
	
	public EmployeeResponse getAllEmployee() {
		EmployeeResponse response =  new EmployeeResponse();
		List<Employee> employeeList = (List<Employee>) employeeRepo.findAll();
		response.setEmployees(employeeList);
		
		return response;
	}
	
	public EmployeeResponse deleteEmployee(long employeeId) {
		EmployeeResponse response =  new EmployeeResponse();
		try {
			employeeRepo.deleteById(employeeId);
	
			response.setMessage("Employee having ID "+employeeId+" deleted successfully.");
			
			return response;
		} catch (Exception e) {
			response.setMessage("Invalid employee ID ! Error:: "+e.getMessage());
			return response;
		}
	}
	
	public EmployeeResponse updateEmployee(Employee employee) {
		EmployeeResponse response =  new EmployeeResponse();
		try {
			if (employee.getEmployeeId() == 0) {
				response.setMessage("Please provide employee ID !");
			} else {
				Employee saved_emp = employeeRepo.save(employee);
				response.setEmployee(saved_emp);
				response.setMessage(Utils.CONST_SUCCESS);
			}
			
			return response;
		} catch (Exception e) {
			response.setMessage("Unable to update employee ! Error:: "+e.getMessage());
			return response;
		}
	}
	
	public EmployeeResponse getEmployee(long employeeId) {
		EmployeeResponse response =  new EmployeeResponse();
		try {
			Employee employee = employeeRepo.findById(employeeId).get();
			response.setEmployee(employee);
			
			return response;
		} catch (Exception e) {
			response.setMessage("Invalid employee ID ! Error:: "+e.getMessage());
			return response;
		}
	}
	
}
