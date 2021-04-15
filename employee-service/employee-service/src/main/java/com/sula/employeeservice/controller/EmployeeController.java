package com.sula.employeeservice.controller;

import com.sula.employeeservice.exception.ResourceNotFoundException;
import com.sula.employeeservice.entity.Employee;
import com.sula.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/employees/{id}")
    public Employee getAllEmployeeById(@PathVariable Long id){
        Employee employee= employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No Such Employee"));
        //Employee employee= employeeRepository.findById(id).get();
        //Employee employee= employeeRepository.getOne(id);
        return ResponseEntity.ok(employee).getBody();
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee empData){
        Employee employee= employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No Such Employee"));
        employee.setEmailId(empData.getEmailId());
        employee.setFirstName(empData.getFirstName());
        employee.setLastName(empData.getLastName());
        Employee UpdatedEmployee=employeeRepository.save(employee);
        return ResponseEntity.ok(employee);
    }

   /* @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id){
        Employee employee= employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No Such Employee"));
        employeeRepository.delete(employee);
        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }*/

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/employees/{id}")
    public Map<String,Boolean> deleteEmployee(@PathVariable Long id){
        Employee employee= employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No Such Employee"));
        employeeRepository.delete(employee);
        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response).getBody();
    }

}
