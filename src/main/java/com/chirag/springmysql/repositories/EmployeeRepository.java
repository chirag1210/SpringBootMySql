package com.chirag.springmysql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.chirag.springmysql.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
   
    @Query("select c from Employee c where c.firstName=?1 and c.lastName=?2")
	Employee findEmployee(String firstName,String lastName);
    
    @Query("select c.email from Employee c where c.firstName=?1")
   	String findEmployee(String firstName);
}