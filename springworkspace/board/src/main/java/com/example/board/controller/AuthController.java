package com.example.board.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.dto.request.auth.SignUpRequestDto;
import com.example.board.dto.response.ResponseDto;
import com.example.board.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

// JSON 형태의 Response body를 반환하기 위한 Controller임을 명시하는 어노테이션
@RestController
// HTTP 요청과 컨트롤러 클래스 혹은 메서드를 매핑하기 위해 사용되는 어노테이션
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
// 필수 멤버변수들을 매개변수로 받는 생성자를 작성해주는 어노테이션 
public class AuthController {

    private final AuthService authService;
    
    // RequestMapping 기능을 POST Method에 한정시켜 안정성과 가독성을 높이기 위한 어노테이션
    @PostMapping("/sign-up")
    public ResponseEntity<ResponseDto> signUp(
        // RequestBody : Post, Put, Patch Method에서 요청시 데이터를 전송받는 방식
        @RequestBody @Valid SignUpRequestDto requestBody
    ) {
        // ResponseEntity : Response의 헤더, 응답 코드, 상태 및 데이터를 포함하여 반환할 수 있도록 해주는 클래스
        ResponseEntity<ResponseDto> response = authService.signUp(requestBody);
        return response;
    }

}