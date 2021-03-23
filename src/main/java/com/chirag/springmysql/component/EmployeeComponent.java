package com.chirag.springmysql.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chirag.springmysql.entities.Employee;
import com.chirag.springmysql.entities.LoginModel;
import com.chirag.springmysql.servicesimpl.EmployeeService;

@RestController
public class EmployeeComponent {

	@Autowired
	EmployeeService employeeService;

	@PostMapping(value = "/employee")
	public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {

		employeeService.createEmployee(employee);
		return new ResponseEntity<Object>("Successfully Saved", HttpStatus.OK);
	}

	@GetMapping(value = "/employee/{id}")
	public ResponseEntity<Object> getEmployee(@PathVariable Long id) {

		Employee employee = employeeService.getEmployeeById(id);
		return new ResponseEntity<Object>(employee, HttpStatus.OK);
	}

	@PutMapping(value = "/employee")
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee) {

		employeeService.updateEmployee(employee);
		return new ResponseEntity<Object>("Successfully Updated", HttpStatus.OK);
	}

	@DeleteMapping(value = "/employee/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable Long id) {

		employeeService.deleteEmployee(id);
		return new ResponseEntity<Object>("Successfully Deleted", HttpStatus.OK);
	}
	
	@GetMapping(value = "/employee")
	public ResponseEntity<Object> getEmployees() {

		List<Employee> list = employeeService.getEmployees();
		return new ResponseEntity<Object>(list, HttpStatus.OK);
	}
	
	@PostMapping(value = "/employees")
	public ResponseEntity<Object> findEmployee(@RequestBody LoginModel loginModel) {

		Employee list = employeeService.findEmployee(loginModel.getFirstName(),loginModel.getLastName());
		return new ResponseEntity<Object>(list, HttpStatus.OK);
	}
	
	@PostMapping(value = "/emailFromEmployee")
	public ResponseEntity<Object> emailFromEmployee(@RequestBody LoginModel loginModel) {

		String email = employeeService.findEmployee(loginModel.getFirstName());
		return new ResponseEntity<Object>(email, HttpStatus.OK);
	}
}
