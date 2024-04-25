package com.example.board.dto.request.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatchNicknameRequestDto {
    
    @NotBlank
    private String email;
    @NotBlank
    private String nickname;

}

// PATCH /api/v1/user/nickname 닉네임 수정
// patch 파일을 만들어 줌 
// Request에서 email / nickname을 적음 