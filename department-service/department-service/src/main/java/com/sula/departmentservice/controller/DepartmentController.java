package com.sula.departmentservice.controller;

import com.sula.departmentservice.entity.Department;
import com.sula.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/")
    public List<Department> getDepartments(){
        return departmentService.getDepartments();
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable Long id){
        return departmentService.findDepartmentById(id);
    }
}
