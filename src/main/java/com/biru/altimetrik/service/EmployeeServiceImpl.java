package com.biru.altimetrik.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biru.altimetrik.dao.EmployeeRepository;
import com.biru.altimetrik.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> findById(int id) {
		return employeeRepository.findById(id);
	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);		
	}

	@Override
	public Employee createNewEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}

	
}
