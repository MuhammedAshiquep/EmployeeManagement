package com.ash.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ash.model.Department;
import com.ash.services.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	
	 @Autowired
	    private DepartmentService departmentService;

	    @PostMapping
	    public Department createDepartment(@RequestBody Department department) {
	        return departmentService.createDepartment(department);
	    }

	    @PutMapping("/{id}")
	    public Optional<Department> updateDepartment(@PathVariable Long id, @RequestBody Department departmentDetails) {
	        return departmentService.updateDepartment(id, departmentDetails);
	    }

	    @DeleteMapping("/{id}")
	    public boolean deleteDepartment(@PathVariable Long id) {
	        return departmentService.deleteDepartment(id);
	    }

	    @GetMapping("/get/{id}")
	    public List<Department> getAllDepartments() {
	        return departmentService.getAllDepartments();
	    }

	    @GetMapping("/{id}")
	    public Optional<Department> getDepartment(@PathVariable Long id) {
	        return departmentService.getDepartment(id); 
	    }
}
