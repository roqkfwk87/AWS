package com.roqkfwk.basic.controller;

import javax.management.Query;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.roqkfwk.basic.dto.SampleDto;

import jakarta.validation.Valid;

// 인스턴스를 생성해서 사용함? 
@RestController
// HTTP * localhost:4000/request-data/** 
@RequestMapping("/request-data")
public class RequestDataController {
    
    // @RequestParam() : 
    // GET, DELETE처럼 URL로 데이터를 전송하는 메서드에서 Query String으로 지정된 데이터를 가져오기 위해 사용 
    
    // 클라이언트 입장에서 데이터를 보내줌 - 데이터를 매개변수로 받아옴 
    // Query String 형태로 'http://localhost:4000/request-data/request-param?userId=qwer&userName=gildong'으로 받고 싶다.
    // HTTP GET localhost:4000/request-data/request-param
    @GetMapping("/request-param")
    public String getRequestParam(
    // http://localhost:4000/request-data/request-param?userId=qwer&userName=gildong (?뒤부터 읽음)
    // userId 받아오기(String userId 쪽에 userId로 설정한 qwer이 들어옴)
    @RequestParam(name="userId") String userId,
    // userName 받아오기 
    // required = false '필수가 아니다'로 지정가능 
    // 필수가 아닌 값이 들어가면 null로 지정됨 / 문자가 아닌 값은 0이 들어감 
    @RequestParam(name="userName", required = false) String userName, 
    // 1) 값을 지정하지 않으면 뒤에 오는 매개변수와 이름이 동일한 값을 찾음 
    // 1) 동일 이름이 url에 없으면 에러가 남
    // 2) http://localhost:4000/request-data/request-param?userId=qwer&userAge=ten
    // 2) 타입이 원하는 형태가 아니라서 에러가 남 
    @RequestParam() int userAge
    ) {
        return "사용자 아이디 : " + userId +" /사용자 이름 : " + userName + " / 사용자 나이 : " + userAge;
    }
    
    // @PathVariable() : 
    // 모든 HTTP 메서드에서 URL의 특정 패턴에 따라서 데이터를 추출하는 방식 

    // HTTP DELETE localhost:4000/request-data/path-variable
    @DeleteMapping({
        // 여러개 지정시 {} 표시
        "/path-variable/{age}/{name}",
        "/path-variable/{age}"
    })
    // http://localhost:4000/request-data/path-variable/10 (postman할 때 delete 메소드이기에 delete로 고쳐주고 적음)
    // path-variable 특정 부분을 찾아서 뽑아옴
    // age는 10을 받도록 해야 읽을 수가 있음 
    public String deletePathVariable(
        @PathVariable("age") Integer age,
        @PathVariable(name="name", required = false) String name
        
    ) {
        return "사용자 나이 : " + age + "/ 사용자 이름 :" + name;
    }

    // 데이터를 읽도록 만듦
    // HTTP PATCH localhost:4000/request-data/patch/{userName}/update
    // http://localhost:4000/request-data/patch/gildong/update (patch로 입력)
    @PatchMapping("/patch/{userName}/update")
    public String patchUpdate(
        @PathVariable("userName") String userName
    ){
        return "사용자 이름 : " + userName;
    }
    // 참고
    /*게시물 1 
    (보기/삭제/수정 - [일반 유저/소유 팀/작성자]) 있는 경우
    GET board/{boardNumber}/normal
    GET board/{boardNumber}/team
    GET board/{boardNumber}/writer 이런 형태로 작성함 */

    //!***** 주의
    // URL 패턴으로 데이터를 받아오는 방식을 썼을 때 
    // 겹치는 패턴이 존재하는지 잘 확인해야 함 
    // localhost:4000/request-data/get/get
    @GetMapping("/{value}/get")
    public String getPathVariable1(
        @PathVariable("value") String value
    ){
        return "getPathVariable1";
    }
        
    @GetMapping("/get/{value}")
    public String getPathVariable2(
        @PathVariable("value") String value
    ){
        return "getPathVariable2";
    }

    // @RequestBody() : 
    // - POST, PATCH, PUT 처럼 RequestBody로 데이터를 전송하는 메서드에서 데이터를 가져오기 위해 사용
    
    // @PostMapping("/post")
    // public String post(
        // @RequestBody String text
        // SampleDto 클래스를 인스턴스로 가져오기 
    //     @RequestBody SampleDto dto 
    // ) {
    //     return "전송한 데이터 :" + dto.toString();
    // }
    // 전송한 데이터 :SampleDto(userId=qwer, userPassword=P!ssw0rd) 


    // HTTP POST localhost:4000/request-data/post
    @PostMapping("/post")
    public String post(
        // @RequestBody String text
        // @Valid : 해당 payload에 대해서 유효성 검사를 실시하도록 함
        @RequestBody @Valid SampleDto dto
    ) {
        return "전송한 데이터 : " + dto.toString();
    }
    
}






