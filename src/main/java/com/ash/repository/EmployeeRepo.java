package com.ash.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ash.model.Employee;

public interface EmployeeRepo extends JpaRepository <Employee, Integer> {

}
