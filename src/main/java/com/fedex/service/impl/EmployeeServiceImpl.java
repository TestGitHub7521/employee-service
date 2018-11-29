package com.fedex.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fedex.dao.EmployeeDao;
import com.fedex.entity.Employee;
import com.fedex.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	
	public List<Employee> retrieveEmployees() {
		
		return employeeDao.retrieveEmployees();
	}

	
	public Employee getEmployee(Long employeeId) {
		
		return employeeDao.getEmployee(employeeId);
	}

	
	public void saveEmployee(Employee employee) {
		
		employeeDao.saveEmployee(employee);

	}

	
	public void deleteEmployee(Long employeeId) {
		
		employeeDao.deleteEmployee(employeeId);

	}

	
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);

	}
	
	public int getSalary(Long employeeId){
		return employeeDao.getSalary(employeeId);
	}

}
