package com.example.employeemanagment.repository;

import com.example.employeemanagment.entity.EmployeeAdditionalInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeAdditionalInfoRepository extends JpaRepository<EmployeeAdditionalInfo, Long> {
}