package com.roqkfwk.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicApplication.class, args);
	}

}

//Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured. (데이터랑 유저아이디를 찾지 못해서 실행 X)