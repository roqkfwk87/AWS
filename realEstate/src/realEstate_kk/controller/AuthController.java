package realEstate_kk.controller;

import realEstate_kk.dto.request.CheckIdRequestDto;
import realEstate_kk.dto.request.SendCodeRequestDto;
import realEstate_kk.dto.response.CheckIdResponseDto;
import realEstate_kk.dto.response.SendCodeResponseDto;

public interface AuthController {
	CheckIdResponseDto checkId (CheckIdRequestDto request);
	SendCodeResponseDto sendcode(SendCodeRequestDto request);
	
	
	
	
}



// request 입력 response 출력