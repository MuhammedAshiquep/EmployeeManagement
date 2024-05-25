package com.ash.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ash.model.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {

}
