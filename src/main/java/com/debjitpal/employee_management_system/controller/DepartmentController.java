package com.debjitpal.employee_management_system.controller;

import com.debjitpal.employee_management_system.entity.Department;
import com.debjitpal.employee_management_system.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {

    @Autowired
    private final DepartmentService departmentService;

    // GET all departments
    @GetMapping
    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartment();
    }

    // GET a department by ID
    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id){
        return departmentService.getDepartmentById(id);
    }

    // POST a new department
    @PostMapping
    public Department createDepartment(@RequestBody Department department){
        return departmentService.createDepartment(department);
    }

    // PUT / update a new department
    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department departmentDetails){
        return departmentService.updateDepartment(id, departmentDetails);
    }

    // PATCH update on existing department
    @PatchMapping("/{id}")
    public Department patchDepartment(Long id, String name){
        return departmentService.patchDepartment(id, name);
    }

    // DELETE a department
    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartmentById(id);
    }

}
