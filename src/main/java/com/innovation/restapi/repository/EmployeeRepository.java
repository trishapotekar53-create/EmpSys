package com.innovation.restapi.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.innovation.restapi.model.Employee;

@Repository
@Qualifier("empRepo")
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	
	
}
