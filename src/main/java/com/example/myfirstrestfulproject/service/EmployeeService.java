package com.example.myfirstrestfulproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myfirstrestfulproject.entity.Employee;
import com.example.myfirstrestfulproject.repositary.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	public void save(Employee emp) throws Exception {
		System.out.println("Inside save method of service class");
		if(emp == null) {
			throw new Exception("Emp data is null, please provide exact data.");
		}
		empRepo.saveEmployee(emp);
		// sendEmail
	}
	
	public Employee getEmployee(int id) throws Exception {
		System.out.println("Inside getEmployee method of service class");
		if(id == 0) {
			throw new Exception("Id could not be 0. Please provide correct id.");
		}
		return empRepo.getEmployeeDetails(id);
	}
	
	public List<Employee> getAllEmployees() {
		return empRepo.getAllEmp();
	}
	
	// Controller class -> Service class -> Repositary class -> Database (MongoDB or HQL or SQL)

}
