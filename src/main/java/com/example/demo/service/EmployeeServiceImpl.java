package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepository;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Integer addEmployee(Employee employee) {
		employee.setDa(employee.getEsal() * 0.1);
		employee.setHra(employee.getEsal() * 0.2);
		return employeeRepository.save(employee).getEid();
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public void deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public Boolean employeeExistByID(Integer id) {
		return employeeRepository.existsById(id);
	}

	/**
	 * fetch employees data using pagination
	 */
	@Override
	public Page<Employee> getAllEmployees(Pageable pageable) {
		return employeeRepository.findAll(pageable);
	}
	

}
