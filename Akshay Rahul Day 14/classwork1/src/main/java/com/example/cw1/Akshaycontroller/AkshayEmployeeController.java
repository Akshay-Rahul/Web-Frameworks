package com.example.cw1.controller;

import com.example.cw1.model.AkshayEmployee;
import com.example.cw1.service.AkshayEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class AkshayEmployeeController {
    private final AkshayEmployeeService employeeService;

    public AkshayEmployeeController(AkshayEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<AkshayEmployee> createEmployee(@RequestBody AkshayEmployee employee) {
        AkshayEmployee createdEmployee = employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

    @GetMapping
    public ResponseEntity<List<AkshayEmployee>> getAllEmployees() {
        List<AkshayEmployee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<AkshayEmployee> getEmployeeById(@PathVariable Long employeeId) {
        Optional<AkshayEmployee> employee = employeeService.getEmployeeById(employeeId);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

