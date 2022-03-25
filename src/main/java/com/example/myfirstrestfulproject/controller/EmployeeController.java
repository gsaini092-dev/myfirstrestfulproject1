package com.example.myfirstrestfulproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api.v1/employee")
public class EmployeeController {
	
	/*
	 * Final URL:
	 * http://localhost:8080/api.v1/employee/save
	 */
	@PostMapping("/save")
	private String createEmployee() {
		return "Employee has been created.";
	}
	
	/*
	 * http://localhost:8080/api.v1/employee
	 */
	@GetMapping("/")
	private String getEmployee(@RequestParam String id) {
		return "This id is belongs to Venu Gopal";
	}
	
	/*
	 * pass the id with in URL
	 * http://localhost:8080/api.v1/employee/123
	 */
	@GetMapping("/{id}")
	private String getEmp(@PathVariable("id") String id) {
		return "This id is belongs to Venu Gopal [USING DIFFRENT METHOD]";
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
