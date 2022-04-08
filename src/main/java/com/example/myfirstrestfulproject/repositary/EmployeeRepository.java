package com.example.myfirstrestfulproject.repositary;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.myfirstrestfulproject.entity.Employee;

@Repository
public class EmployeeRepository {
	
	private List<Employee> empList = new LinkedList<>();
	
	public void saveEmployee(Employee emp) {
		if(emp != null)
			empList.add(emp);
		else
			System.out.println("Error while saving details.");
	}
	
	public Employee getEmployeeDetails(int id) {
		Optional<Employee> empOptional = empList.stream().filter(emp -> emp.getId() == id).findFirst();
		if(empOptional.isPresent())
			return empOptional.get();
		else 
			return new Employee();
	}
	
	public List<Employee> getAllEmp() {
		return empList;

	}

}
