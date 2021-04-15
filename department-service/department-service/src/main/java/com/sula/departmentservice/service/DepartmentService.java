package com.sula.departmentservice.service;

import com.sula.departmentservice.entity.Department;
import com.sula.departmentservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long id) {
        return departmentRepository.findByDepartmentId(id);
    }

    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }
}
