package realEstate_kk.service.implement;

import java.util.Random;

import realEstate_kk.dto.request.CheckIdRequestDto;
import realEstate_kk.dto.request.SendCodeRequestDto;
import realEstate_kk.dto.response.CheckIdResponseDto;
import realEstate_kk.dto.response.SendCodeResponseDto;
import realEstate_kk.interfaces.Code;
import realEstate_kk.repository.EmailAuthenticationRepository;
import realEstate_kk.repository.UserRepository;
import realEstate_kk.repository.implement.UserRepositoryImplement;
import realEstate_kk.service.AuthService;



public class AuthServiceImplement implements AuthService {

	private UserRepository userRepository;
	private EmailAuthenticationRepository emailAuthenticationRepository;
	
	public AuthServiceImplement (UserRepository userRepository, EmailAuthenticationRepository emailAuthenticationRepository) {
		this.userRepository = userRepository;
		this.emailAuthenticationRepository = emailAuthenticationRepository;
	}
	
	
	
	@Override
	public CheckIdResponseDto checkId(CheckIdRequestDto dto) {
	
		CheckIdResponseDto result = new CheckIdResponseDto();
		
		try {
			
			String id = dto.getId();
			
			boolean existedId = userRepository.existsById(id);
			
			if (existedId) result.setCode(Code.DI);
			else result.setCode(Code.SU);
			
		} catch (Exception exception) {
			exception.printStackTrace();
			result.setCode(Code.DBE);
			
		}
		return result; 
	}
	
	
	@Override
	public SendCodeResponseDto sendCode(SendCodeRequestDto dto) {
		SendCodeResponseDto result = new SendCodeResponseDto();
		
		try {
			
			String email = dto.getEmail();
			String authenticationCode = randomString();
			
			boolean existedEmail = emailAuthenticationRepository.existsByEmail(email);
			if (existedEmail) {
				result.setCode(Code.DE);
				return result;
			}
			
			emailAuthenticationRepository.save(email, authenticationCode);
			result.setCode(Code.SU);
			result.setData(authenticationCode);
			
		} catch (Exception exception) {
			exception.printStackTrace();
			result.setCode(Code.DBE);
		}
		
		return result;
	}
	
	
	private String randomString() {
		
		char[] randomString = new char[4];
		
		Random random = new Random();
		
		for (int index = 0; index < 4; index++) {
			randomString[index] = (char) (random.nextInt(26) + 65);
			
		}
		
		return new String(randomString);
			
	

	
	
	}


}





