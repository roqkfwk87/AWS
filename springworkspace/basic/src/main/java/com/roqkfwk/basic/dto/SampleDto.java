package com.roqkfwk.basic.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SampleDto {
    // 캡슐화를 위해 private 사용 (외부에서 접근 X)
    // private String userId;
    // private String userPassword;

// Request Body 로 받는 데이터에 대한 유효성 검사를 validation 의존성을 추가 해야함 

    // 해당 속성을 null이 올 수 없도록 지정
    @NotNull            
    private String notNull;

    // 문자열일 경우 null 또는 빈 문자열이 올 수 없도록 지정
    @NotEmpty       
    private String notEmpty;

    // 문자열일 경우 null 또는 빈 문자열 또는 공백으로된 문자열이 올 수 없도록 지정
    @NotBlank       
    private String notBlank;

    
    // 문자열일 경우 문자열 길이의 최소 최대를 지정 (null 값이면 검사 안함)
    @Length(min=5, max=10)
    @NotNull
    private String length;

    // Request Body로 받아오는 데이터는 Wrapper 클래스 타입으로 데이터를 받는 것이 좋음
    @NotNull
    // NotEmpty, NotBlank는 문자열에서만 유효함
    // @NotEmpty @NotBlank : 타입 mismatch
    private Integer requiredInt;

    // 최댓값과 최솟값을 지정 
    @Max (100)
    @Min (0)
    @NotNull
    private Integer maxMin;
    
    @NotNull
    // 최대 최소 범위를 지정
    @Range(min=0, max=100)
    private Integer range;

    @NotEmpty
    // 문자열이 이메일 형식인지 확인 
    @Email
    private String email;

    // 정규식을 이용해 문자열의 패턴 검사를 진행
    // 전화번호, 이메일, url, 주민등록번호, 비밀번호 영어로만된 문자열, 한글로만된 문자열, 숫자로만 된 문자열
    // email@email.com | email@email.co.kr
    @Pattern(regexp = "^[a-zA-Z0-9]*@([-.]?[a-zA-Z0-9])*\\.[a-zA-Z]{2,4}$")
    private String emailPattern;

}

// https://www.wrapuppro.com/programing/view/MIw5kPB3ao2YJVx (대한민국 패스워드 정규식)

// http 응답코드
// 100 - 정보응답
// 200 - 성공응답
// 300 - 리다이렉션 메시지(응답이 주어짐)
// 400 - 클라이언트 에러 응답(우리 문제)(400, 404를 가장 많이 봄)
// 500 - 서버 에러 응답(서버 문제)(500, 502를 가장 많이 보게 될 듯)

