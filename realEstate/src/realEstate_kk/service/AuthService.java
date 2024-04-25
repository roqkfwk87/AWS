package realEstate_kk.service;

import realEstate_kk.dto.request.CheckIdRequestDto;
import realEstate_kk.dto.request.SendCodeRequestDto;
import realEstate_kk.dto.response.CheckIdResponseDto;
import realEstate_kk.dto.response.SendCodeResponseDto;

public interface AuthService {

	CheckIdResponseDto checkId(CheckIdRequestDto dto);
	SendCodeResponseDto sendCode(SendCodeRequestDto dto);
	
}
