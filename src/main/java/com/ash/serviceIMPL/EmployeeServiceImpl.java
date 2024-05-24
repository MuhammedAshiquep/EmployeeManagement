package com.ash.serviceIMPL;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ash.model.Employee;
import com.ash.repository.EmployeeRepo;
import com.ash.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private  EmployeeRepo employeeRepo;
   
   
    @Override
    public Employee addEmployee(Employee employee) 
    {
    	
    	Employee emp =employeeRepo.save(employee);
    	return emp;
    }
    @Override
    public String removeEmployee(int id)
    {
    	employeeRepo.deleteById(id);
        return "deleted data successfully";
    }
    @Override
    public Optional<Employee> findEmpById(int id) 
    {
    	 
    	Optional <Employee> emp = employeeRepo.findById(id);
    	
    	if(emp.isPresent()) {
    	return emp;
     }else {
     
    	return null;
     }
    }
    @Override
    public List<Employee> getAllEmployee(){
    	List<Employee> empList = employeeRepo.findAll();
    	return empList;
    }
	@Override
	public String updateEmployee(int id) {
		Optional<Employee> emp = employeeRepo.findById(id);
		
		if(emp.isPresent()) {
			Employee emps = new Employee();
			employeeRepo.save(emps);
			return "updated successfully";
			}else {
			return "Employee not found";
				
	}
		
	}
	@Override
	public String updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}
	
    }