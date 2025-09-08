package com.debjitpal.employee_management_system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private String name;
    private String email;
    private Double salary;
    private String position;

    // Relationship mapping
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
