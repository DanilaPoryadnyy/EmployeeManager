package com.example.employeemanagment.controller;

import com.example.employeemanagment.DTO.EmployeeAdditionalInfoDTO;
import com.example.employeemanagment.entity.EmployeeAdditionalInfo;
import com.example.employeemanagment.service.AdditionalInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company/employee")
@RequiredArgsConstructor
public class AdditionalInfoController {
    private final AdditionalInfoService additionalInfoService;
    @PutMapping("/info/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id,@RequestBody EmployeeAdditionalInfoDTO employeeAdditionalInfoDTO)
    {
        return additionalInfoService.updateEntityDb(id, employeeAdditionalInfoDTO);
    }

    @GetMapping("/info/{id}")
    public EmployeeAdditionalInfo getEmployee(@PathVariable Long id)
    {
        return additionalInfoService.readEntityDb(id);
    }
}
