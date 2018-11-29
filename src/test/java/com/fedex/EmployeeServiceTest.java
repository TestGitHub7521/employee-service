package com.fedex;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.fedex.dao.EmployeeDao;
import com.fedex.entity.Employee;
import com.fedex.service.EmployeeService;
import com.fedex.service.impl.EmployeeServiceImpl;

import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {
	
	@MockBean
	EmployeeDao employeeDao;
	@Autowired
	EmployeeServiceImpl employeeService;
	
	/*private Employee employee;*/
	
	/*@Before
	public void before() {
		employee = new Employee();
		employee.setName("Pankaj");
		employee.setDepartment("ground");
		employee.setSalary(3500);

	}*/
	
	@Test
	public void getTestEmployeeSalary() {
		when(employeeDao.getSalary(Mockito.anyLong())).thenReturn(2500);
		assertEquals(2500,employeeService.getSalary(Mockito.anyLong()));
	}
	
	@Test
	public void getTestEmployee() {
		when(employeeDao.getEmployee(Mockito.anyLong())).thenReturn(new Employee("employee1",1200,"ground"));
		assertNotNull(employeeService.getEmployee(Mockito.anyLong()));
	}


}
