package com.chirag.springmysql.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chirag.springmysql.entities.Employee;
import com.chirag.springmysql.repositories.EmployeeRepository;
import com.chirag.springmysql.services.IEmployeeService;


@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public void createEmployee(Employee employee) {

		employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(long id) {
		
		return employeeRepository.getOne(id);
	}

	@Override
	public void updateEmployee(Employee employee) {
		
		employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(long id) {
		employeeRepository.deleteById(id);
	}
	
	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findEmployee(String firstName,String lastName) {
		return employeeRepository.findEmployee(firstName,lastName);
	}

	@Override
	public String findEmployee(String firstName) {
		return employeeRepository.findEmployee(firstName);
	}
}
