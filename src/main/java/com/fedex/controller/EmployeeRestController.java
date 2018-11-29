package com.fedex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fedex.entity.Employee;
import com.fedex.service.EmployeeService;

@RestController
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/api/employees")
	public List<Employee> getEmployees() {
		List<Employee> employees = employeeService.retrieveEmployees();
		return employees;
		
	}
	
	@GetMapping("/api/employee/{employeeId}")
	public Employee getEmployee(@PathVariable(name="employeeId")Long employeeId) {
		return employeeService.getEmployee(employeeId);
	}
	
	@GetMapping("/api/employee/salary/{employeeId}")
	public int getEmployeeSalary(@PathVariable(name="employeeId")Long employeeId) {
		return employeeService.getSalary(employeeId);
	}
	
	@PostMapping("/api/employees")
	public void saveEmployee(Employee employee){
		employeeService.saveEmployee(employee);
		System.out.println("Employee Saved Successfully");

	}
	
	@DeleteMapping("/api/employees/{employeeId}")
	public void deleteEmployee(@PathVariable(name="employeeId")Long employeeId){
		employeeService.deleteEmployee(employeeId);
		System.out.println("Employee Deleted Successfully");
	
	}

	@PutMapping("/api/employees/{employeeId}")
	public void updateEmployee(@RequestBody Employee employee,
			@PathVariable(name="employeeId")Long employeeId){
		Employee emp = employeeService.getEmployee(employeeId);
		if(emp != null){
			employeeService.updateEmployee(employee);
		}

	}
	
}