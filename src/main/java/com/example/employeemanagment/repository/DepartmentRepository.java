package com.example.employeemanagment.repository;

import com.example.employeemanagment.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Departments, Long> {
}