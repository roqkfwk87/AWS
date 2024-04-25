package com.roqkfwk.basic.service.implement;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.roqkfwk.basic.dto.request.student.PatchStudentRequestDto;
import com.roqkfwk.basic.dto.request.student.PostStudentRequestDto;
import com.roqkfwk.basic.dto.request.student.SignInRequestDto;
import com.roqkfwk.basic.entity.StudentEntity;
import com.roqkfwk.basic.repository.StudentRepository;
import com.roqkfwk.basic.service.StudentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImplement implements StudentService {

    private final StudentRepository studentRepository;

    // PasswordEncoder 인터페이스 : 
    // - Spring Security에서 제공해주는 비밀번호를 안전하에 관리하고 검증하도록 도움을 주는 인터페이스
    // - String encode(평문패스워드) : 평문 패스워드를 암호화해서 반환함 
    // - boolean matches(평문패스워드, 암호화된패스워드) : 평문 패스워드와 암호화된 패스워드가 같은지 비교 결과를 반환 
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResponseEntity<String> postStudent(PostStudentRequestDto dto) {

        // 패스워드 암호화 작업
        String password = dto.getPassword();
        String encodedPassword = passwordEncoder.encode(password);

        dto.setPassword(encodedPassword);

        // CREATE (SQL : INSERT)
        // 1. Entity 클래스의 인스턴스 생성
        // 2. 생성한 인스턴스를 repository.save() 메서드로 저장
        StudentEntity studentEntity = new StudentEntity(dto);
        // save() : 저장 및 수정 (덮어쓰기)
        StudentEntity savedEntity = studentRepository.save(studentEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body("성공!");
    }

    @Override
    public ResponseEntity<String> patchStudent(PatchStudentRequestDto dto) {

        Integer studentNumber = dto.getStudentNumber();
        String address = dto.getAddress();

        // 0. student 테이블에 해당하는 Prmary key를 가지는 레코드가 존재하는지 확인 
        boolean isExistedStudent = studentRepository.existsById(studentNumber);
        if (!isExistedStudent) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("존재하지 않는 학생입니다. 김유진 바보 어디에서 수정했는지 모르겠지 ~~ ?!?!?");

        // 1. student 클래스로 접근 (StudentRepository 사용)
        StudentEntity studentEntity = studentRepository.
        // 2. dto.studentNumber에 해당하는 인스턴스를 검색
        findById(studentNumber).get();
        // 3. 검색된 인스턴스의 address 값을 dto.address로 변경
        studentEntity.setAddress(address);
        // 4. 변경한 인스턴스를 데이터베이스에 저장 
        // repository.save()는 레코드를 생성할 때 쓰이지만 수정할 때도 동일하게 사용됨 
        studentRepository.save(studentEntity);

        return ResponseEntity.status(HttpStatus.OK).body("성공!");
    }

    @Override
    public ResponseEntity<String> deleteStudent(Integer StudentNumber) {

        studentRepository.deleteById(StudentNumber);
        
        return ResponseEntity.status(HttpStatus.OK).body("성공");
    }

    @Override
    public ResponseEntity<String> signIn(SignInRequestDto dto) {
        
        try {

            Integer studentNumber = dto.getStudentNumber();
            StudentEntity studentEntity = studentRepository.findByStudentNumber(studentNumber);

            if (studentEntity == null)
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("오류");
                
                // 사용자가 입력한 패스워드와 암호화된 패스워드가 매치되는지 확인 
                String password = dto.getPassword();
                String encodePassword = studentEntity.getPassword();
                
                boolean isEqualPassword = passwordEncoder.matches( password, encodePassword);
                // false인 경우 비밀번호 불일치
                if (!isEqualPassword) 
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("비밀번호 불일치");

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("오류");
        }

        return ResponseEntity.status(HttpStatus.OK).body("성공");
    }
    
}