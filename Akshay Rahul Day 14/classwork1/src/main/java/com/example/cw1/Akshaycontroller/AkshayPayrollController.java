package com.example.cw1.controller;

import com.example.cw1.model.AkshayPayroll;
import com.example.cw1.service.AkshayPayrollService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee/{employeeId}/payroll")
public class AkshayPayrollController {
    private final AkshayPayrollService payrollService;

    public AkshayPayrollController(AkshayPayrollService payrollService) {
        this.payrollService = payrollService;
    }

    @PostMapping
    public ResponseEntity<AkshayPayroll> createPayrollForEmployee(@PathVariable Long employeeId, @RequestBody AkshayPayroll payroll) {
        AkshayPayroll createdPayroll = payrollService.createPayroll(payroll);
        if (createdPayroll != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPayroll);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping
    public ResponseEntity<AkshayPayroll> getPayrollForEmployee(@PathVariable Long employeeId) {
        AkshayPayroll payroll = payrollService.getPayrollByEmployeeId(employeeId);
        if (payroll != null) {
            return ResponseEntity.ok(payroll);
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}
