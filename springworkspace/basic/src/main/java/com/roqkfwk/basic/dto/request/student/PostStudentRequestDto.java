package com.roqkfwk.basic.dto.request.student;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostStudentRequestDto {
    @NotBlank
    private String name;

    @NonNull
    @Min(0)
    // int를 하고 notnull을 하면 안됨
    private Integer age;

    @NotBlank
    private String address;

    @NonNull
    private Boolean graduation;

    @NotBlank
    private String password;

}
