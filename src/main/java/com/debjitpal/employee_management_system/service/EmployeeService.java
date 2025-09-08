package com.debjitpal.employee_management_system.service;

import com.debjitpal.employee_management_system.entity.Employee;
import com.debjitpal.employee_management_system.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    // Get all employees
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    // Get employee by id
    public Employee getAllEmployeeById(Long id){
        return employeeRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Employee not found with ID: " + id));
    }

    // Post/ create new employee
    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    // Put / update new employee
    public Employee updateEmployee(Long id, Employee updateEmployee){
        Employee employee = getAllEmployeeById(id);
        employee.setName(updateEmployee.getName());
        employee.setEmail(updateEmployee.getEmail());
        employee.setSalary(updateEmployee.getSalary());
        employee.setPosition(updateEmployee.getPosition());
        return employeeRepository.save(employee);
    }

    // Patch / update existing employee
    public Employee patchEmployee(Long id, String position){
        Employee employee = getAllEmployeeById(id);
        employee.setPosition(position);
        return employeeRepository.save(employee);
    }

    // Delete employee
    public void deleteEmployeeById(Long id){
        employeeRepository.deleteById(id);
    }


}
