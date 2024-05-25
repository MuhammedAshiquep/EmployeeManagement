package com.ash.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
  
	private String name;
	private LocalDate creationDate;

	@OneToOne
	@JoinColumn(name = "department_head_id")
	private Employee departmentHead;

    @OneToMany(mappedBy = "department")
	private List<Employee> employees;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public Employee getDepartmentHead() {
		return departmentHead;
	}

	public void setDepartmentHead(Employee departmentHead) {
		this.departmentHead = departmentHead;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", creationDate=" + creationDate + ", departmentHead="
				+ departmentHead + ", employees=" + employees + "]";
	}

	public Department(Long id, String name, LocalDate creationDate, Employee departmentHead, List<Employee> employees) {
		super();
		this.id = id;
		this.name = name;
		this.creationDate = creationDate;
		this.departmentHead = departmentHead;
		this.employees = employees;
	}

	public Department() {
		super();
	}
	
	

}
