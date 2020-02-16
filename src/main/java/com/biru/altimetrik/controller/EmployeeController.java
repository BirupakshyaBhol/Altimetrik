package com.biru.altimetrik.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.biru.altimetrik.model.Employee;
import com.biru.altimetrik.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired 
	EmployeeService employeeService;
	
	@GetMapping(value="/findAll")
	public @ResponseBody Object findAll() {
		Map<String,Object> response= new HashMap<String, Object>();
		List<Employee> list= new ArrayList<Employee>();
		list=employeeService.findAll();
		if(!list.isEmpty()) {
			response.put("status","sucess");
			response.put("Employee", list);
		}
		else {
			response.put("status","failed");
		}
		return response;
	}
	
	@PostMapping(value="/createEmployee",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		if( employeeService.createNewEmployee(employee)!=null) {
			return new ResponseEntity<Employee>(HttpStatus.CREATED);
		}
		return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Employee> delete(@PathVariable int id){
		if(employeeService.findById(id)!=null) {
			employeeService.deleteById(id);
			return new ResponseEntity<Employee>(HttpStatus.OK);
		}
		return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
	}


}
