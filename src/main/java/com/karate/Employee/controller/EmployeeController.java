package com.karate.Employee.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.karate.Employee.dao.EmployeeRepository;
import com.karate.Employee.entity.Employee;
import com.karate.Employee.service.EmplyeeService;

@RestController
public class EmployeeController {
	@Autowired 
	EmployeeRepository employeeRepository;
	@Autowired
	EmplyeeService employeeService;

	
	@GetMapping("/employee")
	public List<Employee> index(){
		return employeeRepository.findAll();
	}
	@PostMapping("/employee")
	public Employee create(@RequestBody Map<String, String> body){
		Employee employee=new Employee();
		employee.setEmp_name(body.get("emp_name"));
		employee.setAge(Integer.parseInt(body.get("age")));
		employee.setBlood_group(body.get("blood_group"));
		employee.setDepartment(body.get("department"));
		employee.setExperience(body.get("experience"));
		employee.setGoals(body.get("goals"));
		employee.setManager(body.get("manager"));
		employee.setTeam(body.get("team"));
		employee.setSalary(Integer.parseInt(body.get("salary")));
		return	employeeService.save(employee);
	}
	@DeleteMapping("employee/{id}")
	public boolean delete(@PathVariable String id){
		int employeeId = Integer.parseInt(id);
		employeeRepository.deleteById(employeeId);
		return true;
	}
	@GetMapping("/employee/{id}")
	public Optional<Employee> show(@PathVariable String id){
		int employeeId = Integer.parseInt(id);
		return employeeRepository.findById(employeeId);
	}
}
