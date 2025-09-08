package com.debjitpal.employee_management_system.service;

import com.debjitpal.employee_management_system.entity.Department;
import com.debjitpal.employee_management_system.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Get all Department
    public List<Department> getAllDepartment(){
        return departmentRepository.findAll();
    }

    // Get Department by id
    public Department getDepartmentById(Long id){
        return departmentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Department with ID " + id + " not found."));
    }

    // Post / create new Department
    public Department createDepartment(Department department){
        return departmentRepository.save(department);
    }

    // Put / upadte department
    public Department updateDepartment(Long id, Department updateDepartment){
        Department department = getDepartmentById(id);
        department.setName(updateDepartment.getName());
        return departmentRepository.save(department);
    }

    // Patch department
    public Department patchDepartment(Long id, String name){
        Department department = getDepartmentById(id);
        department.setName(name);
        return departmentRepository.save(department);
    }

    // Delete Department
    public void deleteDepartmentById(Long id){
        departmentRepository.deleteById(id);
    }
}
