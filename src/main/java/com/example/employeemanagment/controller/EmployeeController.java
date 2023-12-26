package com.example.employeemanagment.controller;

import com.example.employeemanagment.DTO.EmployeeDTO;
import com.example.employeemanagment.entity.Employee;
import com.example.employeemanagment.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        return employeeService.readListEntityDb();
    }

    @PostMapping("/employee")
    public ResponseEntity<?> createEmployee(
            @RequestBody EmployeeDTO employeeDTO
    ){
        return employeeService.createEntityDb(employeeDTO);
    }

    @GetMapping("/employee/{id}")
    public Employee readEmployee(
            @PathVariable Long id
    ){
        return employeeService.readEntityDb(id);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEntityDb(id);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, EmployeeDTO employeeDTO)
    {
        return employeeService.updateEntityDb(id, employeeDTO);
    }
}
