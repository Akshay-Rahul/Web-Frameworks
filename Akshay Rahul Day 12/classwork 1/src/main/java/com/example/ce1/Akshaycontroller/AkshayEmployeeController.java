package com.example.ce1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ce1.model.AkshayEmployee;
import com.example.ce1.service.AkshayEmployeeService;

@RestController
public class AkshayEmployeeController {
    @Autowired
    AkshayEmployeeService employeeService;

    @PostMapping("/employee")
    public AkshayEmployee setMethod(@RequestBody AkshayEmployee employee)
    {
        return employeeService.setEmployee(employee);
    }

    @GetMapping("/employees-inner-join")
    public List<AkshayEmployee> getInnerMethod()
    {
        return employeeService.getInnerEmployee();
    }

    @GetMapping("/employees-left-outer-join")
    public List<AkshayEmployee> getLeftMethod()
    {
        return employeeService.getLeftOuterEmployee();
    }
}
