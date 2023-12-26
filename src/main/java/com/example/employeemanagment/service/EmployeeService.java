package com.example.employeemanagment.service;

import com.example.employeemanagment.DTO.EmployeeDTO;
import com.example.employeemanagment.entity.Employee;
import com.example.employeemanagment.entity.EmployeeAdditionalInfo;
import com.example.employeemanagment.repository.DepartmentRepository;
import com.example.employeemanagment.repository.EmployeeAdditionalInfoRepository;
import com.example.employeemanagment.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeAdditionalInfoRepository employeeAdditionalInfoRepository;

    public Employee findBy(long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Запись не найдена"));
    }
    public List<Employee> readListEntityDb() {
        return employeeRepository.findAll();
    }

    public ResponseEntity<?> createEntityDb(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setSurname(employeeDTO.getSurname());
        employee.setDepartments(departmentRepository.findById(employeeDTO.getIdDepartments()).get());
        EmployeeAdditionalInfo employeeAdditionalInfo = new EmployeeAdditionalInfo();
        employeeAdditionalInfo.setEmployees(employee);
        employeeAdditionalInfoRepository.save(employeeAdditionalInfo);
        employeeRepository.save(employee);
        return ResponseEntity.ok("Данные сотрудника успешно добавлены");
    }

    public Employee readEntityDb(Long id) {
        return findBy(id);
    }

    public ResponseEntity<String> updateEntityDb(Long id, EmployeeDTO employeeDTO) {
        Employee employee = findBy(id);
        employee.setName(employeeDTO.getName());
        employee.setSurname(employeeDTO.getSurname());
        return ResponseEntity.ok("Данные сотрудника успешно обновлены");
    }

    public ResponseEntity<String> deleteEntityDb(Long id) {
        try {
            employeeRepository.deleteById(id);
            return ResponseEntity.ok("Сотрудник успешно удален");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ошибка при удалении сотрудника");
        }
    }



}
