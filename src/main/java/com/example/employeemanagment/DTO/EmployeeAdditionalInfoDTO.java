package com.example.employeemanagment.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
public class EmployeeAdditionalInfoDTO {
    private String address;
    private String email;
}
