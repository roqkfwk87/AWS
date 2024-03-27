package com.roqkfwk.basic.service;

import org.springframework.http.ResponseEntity;

import com.roqkfwk.basic.dto.request.student.PostStudentRequestDto;

public interface StudentService {
    ResponseEntity<String> postStudent(PostStudentRequestDto dto);
}
