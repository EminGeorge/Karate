package com.karate.Employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karate.Employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{


}
