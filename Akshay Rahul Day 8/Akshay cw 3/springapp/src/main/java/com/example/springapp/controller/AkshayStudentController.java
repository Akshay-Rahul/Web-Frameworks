package com.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.springapp.model.AkshayStudent;
import com.example.springapp.service.AkshayStudentService;

@RestController
public class AkshayStudentController {
    @Autowired
    private AkshayStudentService studentService;

    @PostMapping("/api/student")
    public ResponseEntity<AkshayStudent> post(@RequestBody AkshayStudent student) {
        if (studentService.post(student)) {
            return new ResponseEntity<>(student, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/student/markGreaterThan/{marks}")
    public ResponseEntity<List<AkshayStudent>> getGreater(@PathVariable int marks) {
        List<AkshayStudent> list = studentService.getGreater(marks);
        if (list.size() > 0) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/student/markLessThan/{marks}")
    public ResponseEntity<List<AkshayStudent>> getLesser(@PathVariable int marks) {
        List<AkshayStudent> list = studentService.getLesser(marks);
        if (list.size() > 0) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
