package com.employee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;

@Repository
@Component
public interface EmployeeRepo extends CrudRepository<Employee, Long> {

}
