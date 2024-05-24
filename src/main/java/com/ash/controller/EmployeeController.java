package com.ash.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ash.model.Employee;
import com.ash.serviceIMPL.EmployeeServiceImpl;


@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired 
	private EmployeeServiceImpl empservice;
	
	@GetMapping("/home")
   public String homepage() {
	   
	   return "welcome to Employee Management";
	   		
   }
	@PostMapping("/addEmp")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
	{
		Employee emp = empservice.addEmployee(employee);
		return new  ResponseEntity<Employee>(emp,HttpStatus.CREATED);
		
	}
	@DeleteMapping("/removeEmp/(Id)")
	public ResponseEntity<String> removeEmployee(@PathVariable int id)
    {
	empservice.removeEmployee(id);
	
	return  new  ResponseEntity<String>("Remove Successfully", HttpStatus.ACCEPTED);
    }
   @GetMapping("/findEmp/(Id)")
   public ResponseEntity<Optional<Employee>> findEmployeeById(@PathVariable int id)
   { 
   Optional<Employee> emps = empservice.findEmpById(id);
   
   return new ResponseEntity<Optional<Employee>>(emps,HttpStatus.ACCEPTED);
   }
   
   @GetMapping("/all")
   public ResponseEntity<List<Employee>> listofEmployees()
   {
  
   List<Employee> lEmp = empservice.getAllEmployee();

   return new ResponseEntity<List<Employee>>(lEmp, HttpStatus.ACCEPTED);
   
   }
   }