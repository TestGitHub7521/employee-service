package com.fedex.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fedex.dao.EmployeeDao;
import com.fedex.entity.Employee;
import com.fedex.repository.EmployeeRepository;

@Service
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> retrieveEmployees() {
		
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

	
	public Employee getEmployee(Long employeeId) {
		
		Optional<Employee> optEmp =employeeRepository.findById(employeeId);
		return optEmp.get();
	}
	
	public int getSalary(Long employeeId) {
		
		Optional<Employee> optEmp =employeeRepository.findById(employeeId);
		return optEmp.get().getSalary().intValue();
	}


	
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	
	public void deleteEmployee(Long employeeId) {
		employeeRepository.deleteById(employeeId);
	}

	
	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);

	}

}
