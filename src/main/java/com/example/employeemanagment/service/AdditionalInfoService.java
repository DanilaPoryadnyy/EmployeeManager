package com.example.employeemanagment.service;

import com.example.employeemanagment.DTO.EmployeeAdditionalInfoDTO;
import com.example.employeemanagment.entity.EmployeeAdditionalInfo;
import com.example.employeemanagment.repository.EmployeeAdditionalInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdditionalInfoService {
    private final EmployeeAdditionalInfoRepository employeeAdditionalInfoRepository;

    public ResponseEntity<?> updateEntityDb(Long id, EmployeeAdditionalInfoDTO employeeAdditionalInfoDTO) {
        EmployeeAdditionalInfo employeeAdditionalInfo = employeeAdditionalInfoRepository.findById(id).get();
        employeeAdditionalInfo.setAddress(employeeAdditionalInfoDTO.getAddress());
        employeeAdditionalInfo.setEmail(employeeAdditionalInfoDTO.getEmail());
        employeeAdditionalInfoRepository.save(employeeAdditionalInfo);
        return ResponseEntity.ok("Данные сотрудника успешно добавлены");
    }
    public EmployeeAdditionalInfo readEntityDb(Long id) {
        EmployeeAdditionalInfo employeeAdditionalInfo = employeeAdditionalInfoRepository.findById(id).get();
        return employeeAdditionalInfo;
    }
}
