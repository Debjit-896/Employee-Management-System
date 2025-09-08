package com.debjitpal.employee_management_system.controller;

import com.debjitpal.employee_management_system.entity.Employee;
import com.debjitpal.employee_management_system.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    @Autowired
    private final EmployeeService employeeService;

    // GET all employees
    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    // GET an employees by ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getAllEmployeeById(id);
    }

    // POST / create a new employees
    @PostMapping
    public Employee createEmployee(Employee employee){
        return employeeService.createEmployee(employee);
    }

    // PUT / update an employees
    @PutMapping("/{id}")
    public Employee updateEmployee(Long id, Employee employee){
        return employeeService.updateEmployee(id, employee);
    }

    // PATCH to update an employee's department
    @PatchMapping
    public Employee patchEmployee(Long id, String position){
        return employeeService.patchEmployee(id, position);
    }

    // DELETE an employees
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
    }
}
