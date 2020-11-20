package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class MainController {
	
	@Autowired
	EmployeeService employeeService;	

	@GetMapping("/registerEmployee")
	public String getRegistrationForm() { 
		return "employeeRegForm";   
	}
	
	@PostMapping("/addEmployee")
	public String addEmployee(@ModelAttribute Employee employee, Model model) { 
		Integer id = employeeService.addEmployee(employee);
		model.addAttribute("message", "Employee Created with Id:" + id);
		return "employeeRegForm";
	}
	
	/*
	 * @GetMapping("/getEmployees") public String getEmployees(Model model) {
	 * List<Employee> employees = employeeService.getAllEmployees();
	 * model.addAttribute("empList", employees); return "EmployeeList"; }
	 */
	/**
	 * fetch employees data using pagination.
	 * @PageableDefault used to set default pagination values when not passed in request.
	 * @param model
	 * @return
	 */
	@GetMapping("/getEmployees")
	public String getEmployees(@PageableDefault(page = 0, size = 2) Pageable pageable, Model model) { 
		
		Page<Employee> employeePage = employeeService.getAllEmployees(pageable);
		model.addAttribute("page", employeePage);
		model.addAttribute("empList", employeePage.getContent());
		return "EmployeeList";
	}
	
	/**
	 * Delete Operation with Exception handling.
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/DeleteEmployee")
	public String deleteEmployee(@RequestParam Integer id, Model model) { 
		
		if(!employeeService.employeeExistByID(id)) {
			throw new EmployeeNotFoundException("Employee not exists with id " + id);
		}
		
		employeeService.deleteEmployee(id);
		return "redirect:getEmployees";
	}
	
}
