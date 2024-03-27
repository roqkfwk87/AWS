package com.roqkfwk.basic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roqkfwk.basic.dto.request.student.PostStudentRequestDto;

@RestController
@RequestMapping("/student")
public class StudentController {
    
    @PostMapping("/")
    public ResponseEntity<?> postStudent(
        @RequestBody PostStudentRequestDto requestBody
    ) {
        return null;
    }

    // UPDATE 
    @PatchMapping("/")
    public ResponseEntity<?> patchStudent() {
        return null;
    }

   // DELETE
    @DeleteMapping("/{studentNumber}")
    public ResponseEntity<?> deleteStudent(
        @PathVariable("studentNumber") Integer studentNumber
    ) {
        return null;
    }
