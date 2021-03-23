package com.chirag.springmysql.services;

import java.util.List;

import com.chirag.springmysql.entities.Employee;

public interface IEmployeeService {

	public void createEmployee(Employee employee);

	public Employee getEmployeeById(long id);

	public void updateEmployee(Employee employee);

	public void deleteEmployee(long id);

	public List<Employee> getEmployees();

	public Employee findEmployee(String firstName,String lastName);
	
	public String findEmployee(String firstName);

}
