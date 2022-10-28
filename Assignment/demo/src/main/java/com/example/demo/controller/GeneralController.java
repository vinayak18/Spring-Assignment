package com.example.demo.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;

@RestController
@RequestMapping("/home")
@EnableAutoConfiguration
public class GeneralController {
	@GetMapping("/getUserName")
	public String getUserName(@RequestParam String name) {
		return "Happy Learning "+name;
	}
	@GetMapping("/getEmployeeDetails")
	public Employee getEmployeeDetails() {
		Employee emp = new Employee();
		emp.setEmpId("1");
		emp.setEmpName("Vinayak Saraf");
		emp.setDesignation("Engineer");
		emp.setLocation("Kolkata");
		return emp;
	}
	
	@GetMapping("/getEmployeeFromUser")
	public Employee getEmployeeFromUser(@RequestBody Employee emp) {
		System.out.println("Employee Details from User - ");
		System.out.println(emp);
		return emp;
	}
}
