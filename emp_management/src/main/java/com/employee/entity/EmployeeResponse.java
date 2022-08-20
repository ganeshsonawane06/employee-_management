package com.employee.entity;

import java.util.List;
import java.util.Objects;

public class EmployeeResponse {
	private String message;
	private Employee employee;
	private List<Employee> employees;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "EmployeeResponse [message=" + message + ", employee=" + employee + ", employees=" + employees + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(employee, employees, message);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeResponse other = (EmployeeResponse) obj;
		return Objects.equals(employee, other.employee) && Objects.equals(employees, other.employees)
				&& Objects.equals(message, other.message);
	}

}
