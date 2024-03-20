package com.roqkfwk.basic.dto;

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
    private String userId;
    private String userPassword;
}
