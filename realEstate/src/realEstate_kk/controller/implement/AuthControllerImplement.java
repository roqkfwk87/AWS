package realEstate_kk.controller.implement;

import realEstate_kk.controller.AuthController;
import realEstate_kk.dto.request.CheckIdRequestDto;
import realEstate_kk.dto.request.SendCodeRequestDto;
import realEstate_kk.dto.response.CheckIdResponseDto;
import realEstate_kk.dto.response.SendCodeResponseDto;
import realEstate_kk.interfaces.Code;
import realEstate_kk.service.AuthService;

public class AuthControllerImplement implements AuthController {
	
	private AuthService authService;
	
	public AuthControllerImplement (AuthService authService) {
		this.authService = authService;
	}
	

	@Override
	public CheckIdResponseDto checkId(CheckIdRequestDto request) {
		boolean validId = request.validId();
		if (!validId) return new CheckIdResponseDto(Code.VF , null);
		
		CheckIdResponseDto response = authService.checkId(request);
		return response;
	}

	
	@Override
	public SendCodeResponseDto sendcode(SendCodeRequestDto request) {
		boolean valid = request.validEmail();
		if (!valid) return new SendCodeResponseDto(Code.VF, null);
		
		SendCodeResponseDto response = authService.sendCode(request);
		return response;
	}

}
