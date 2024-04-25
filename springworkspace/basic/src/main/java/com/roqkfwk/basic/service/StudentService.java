package com.roqkfwk.basic.service;

import org.springframework.http.ResponseEntity;

import com.roqkfwk.basic.dto.request.student.PatchStudentRequestDto;
import com.roqkfwk.basic.dto.request.student.PostStudentRequestDto;
import com.roqkfwk.basic.dto.request.student.SignInRequestDto;

public interface StudentService {
    ResponseEntity<String> postStudent(PostStudentRequestDto dto);
    ResponseEntity<String> patchStudent(PatchStudentRequestDto dto);
    ResponseEntity<String> deleteStudent(Integer StudentNumber);
    ResponseEntity<String> signIn(SignInRequestDto dto);
}
