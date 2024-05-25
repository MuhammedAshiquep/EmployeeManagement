package com.ash.serviceIMPL;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
//import org.springframework.data.domain.Page;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Service;

import com.ash.model.Department;
import com.ash.repository.DepartmentRepo;
import com.ash.services.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
    private DepartmentRepo departmentRepository;

	@Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

	@Override
    public Optional<Department> updateDepartment(Long id, Department departmentDetails) {
        return departmentRepository.findById(id).map(department -> {
            department.setName(departmentDetails.getName());
            department.setCreationDate(departmentDetails.getCreationDate());
            department.setDepartmentHead(departmentDetails.getDepartmentHead());
            return departmentRepository.save(department);
        });
    }

	@Override
    public boolean deleteDepartment(Long id) {
        if (departmentRepository.existsById(id) && departmentRepository.findById(id).get().getEmployees().isEmpty()) {
            departmentRepository.deleteById(id);
            return true;
        }
        return false;
    }

	@Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

	@Override
    public Optional<Department> getDepartment(Long id) {
        return departmentRepository.findById(id);
    }
//	@Override
//	public List<Department> getAllDepartments(Pageable pageable) {
//		return null;
//	}

//	@Override
//	public List<Department> getAllDepartments() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public Page<Department> findAll(org.springframework.data.domain.Pageable pageable) {
//		// TODO Auto-generated method stub
//		return null;
//	}
		
}
