package com.roqkfwk.basic.service.implement;

import org.springframework.http.ResponseEntity;

import com.roqkfwk.basic.dto.request.student.PostStudentRequestDto;
import com.roqkfwk.basic.service.StudentService;

public class StudentServiceImplement implements StudentService {

    @Override
    public ResponseEntity<String> postStudent(PostStudentRequestDto dto) {
        return null;
    }
}
