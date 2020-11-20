package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.Employee;

public interface EmployeeService {

	public Integer addEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();
	
	public void deleteEmployee(Integer id);
	
	public Boolean employeeExistByID(Integer id);
	
	public Page<Employee> getAllEmployees(Pageable pageable);
	
}
