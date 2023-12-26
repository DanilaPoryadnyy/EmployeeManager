package com.example.employeemanagment.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Data
public class EmployeeDTO {
    private String name;
    private String surname;
    private Long idDepartments;
}
