package com.biru.altimetrik.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.biru.altimetrik.model.Employee;

@Service
public interface EmployeeService {

	public List<Employee> findAll();
	public Optional<Employee> findById(int id);
	public void deleteById(int id);
	public Employee createNewEmployee(Employee emp);
	
	
}
