package com.example.myfirstrestfulproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.myfirstrestfulproject.constant.Constants;
import com.example.myfirstrestfulproject.entity.Employee;
import com.example.myfirstrestfulproject.service.EmployeeService;

@RestController
@RequestMapping("/api.v1/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	/*
	 * Final URL:
	 * http://localhost:8080/api.v1/employee/save
	 */
	@PostMapping("/save")
	private String createEmployee(@RequestBody Employee employee) {
		String message = Constants.MSG_SUCCESS;
		try {
			empService.save(employee);
		} catch (Exception e) {
			message = e.getMessage();
		}
		
		return message;
	}
	
	/*
	 * http://localhost:8080/api.v1/employee?id=10
	 */
	@GetMapping("/")
	private List<Employee> getEmployee() {
		return empService.getAllEmployees();
	}
	
	/*
	 * pass the id with in URL
	 * http://localhost:8080/api.v1/employee/10/data
	 */
	@GetMapping("/{id}")
	private Employee getEmp(@PathVariable("id") String id) {
		int empId = Integer.valueOf(id);
		try {
			return empService.getEmployee(empId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Employee();
	}

	
	/*
	 * http://localhost:8080/api.v1/employee/update
	 */
	@PutMapping("/update")
	private String updateEmployee(@RequestParam String id) {
		return "Employee details has been successfully updated.";
	}
	
	/*
	 * http://localhost:8080/api.v1/employee/delete
	 */
	@DeleteMapping("/delete")
	private String deleteEmployee(@RequestParam String id) {
		return "Employee details has been successfully deleted.";
	}
	
	/*
	 * 
	 * URL: http://localhost:8080/api.v1/employee/patch/1.6/version-update
	 */
	@PatchMapping("/patch/{version}/version-update")
	private String updateApiVersion(@PathVariable String version) {
		return "Employee API version has been udpated to -" + version;

	}

}
