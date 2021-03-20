package com.chirag.springmysql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chirag.springmysql.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
   
	
}