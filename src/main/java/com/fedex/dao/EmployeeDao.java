package com.fedex.dao;

import java.util.List;

import com.fedex.entity.Employee;

public interface EmployeeDao {
	
	public List<Employee> retrieveEmployees();
	
	public Employee getEmployee(Long employeeId);
	
	public void saveEmployee(Employee employee);
	
	public void deleteEmployee(Long employeeId);
	
	public void updateEmployee(Employee employee);
	
	public int getSalary(Long employeeId);


}
