package com.karate.Employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karate.Employee.dao.EmployeeRepository;
import com.karate.Employee.entity.Employee;
@Service
public class EmplyeeService {
	
	@Autowired 
	EmployeeRepository employeeRepository;
	
	
	public Employee save(Employee employee) {
		Employee employeel=new Employee();
		if(null!=employee.getEmp_name()){
			employeel.setEmp_name(employee.getEmp_name());
			employeel.setBlood_group(employee.getBlood_group());
			employeel.setAge(employee.getAge());
			employeel.setSalary(employee.getSalary());
			employeel.setManager(employee.getManager());
			employeel.setDepartment(employee.getDepartment());
			employeel.setTeam(employee.getTeam());
			employeel.setDepartment(employee.getDepartment());
			employeel.setGoals(employee.getGoals());
			employeel.setExperience(employee.getExperience());
		 return employeeRepository.save(employeel);
		}
		else
		throw new NullPointerException("Null pointer");
		
		
	}

}
