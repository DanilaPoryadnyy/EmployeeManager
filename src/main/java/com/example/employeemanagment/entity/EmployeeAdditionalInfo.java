package com.example.employeemanagment.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employee_additional_info")
public class EmployeeAdditionalInfo {
    @Id
    @Column(name = "employee_id", nullable = false)
    private Integer id;

    @JsonIgnoreProperties({"hibernateLazyInitializer"})
    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employees;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "email", length = 50)
    private String email;

}