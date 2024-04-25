package realEstate_kk;

import java.util.Scanner;

import realEstate_kk.controller.AuthController;
import realEstate_kk.controller.implement.AuthControllerImplement;
import realEstate_kk.dto.request.CheckIdRequestDto;
import realEstate_kk.dto.request.SendCodeRequestDto;
import realEstate_kk.dto.response.CheckIdResponseDto;
import realEstate_kk.dto.response.SendCodeResponseDto;
import realEstate_kk.interfaces.Code;
import realEstate_kk.repository.EmailAuthenticationRepository;
import realEstate_kk.repository.UserRepository;
import realEstate_kk.repository.implement.EmailAuthenticationRepositoryImplement;
import realEstate_kk.repository.implement.UserRepositoryImplement;
import realEstate_kk.service.AuthService;
import realEstate_kk.service.implement.AuthServiceImplement;

// ** 꼭 기억하기 **
// Controller (package / interface) : 입력과 출력을 담당하는 요소 
// Service (package / interface) : 실제 비즈니스 로직 (연산)
// Repository (package / interface) : 데이터베이스 연결과 관련된 직업 

// DTO (Data Transfer Object) : 데이터 전송을 위한 객체
// Entity : 데이터 베이스의 테이블을 자바 클래스로 표현한 객체 


public class App {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		
		UserRepository userRepository = new UserRepositoryImplement();
		EmailAuthenticationRepository emailAuthenticationRepository = new EmailAuthenticationRepositoryImplement();
		AuthService authService = new AuthServiceImplement(userRepository, emailAuthenticationRepository);
		AuthController authController = new AuthControllerImplement(authService);
		
		while (true) {
			System.out.print("1. 회원가입 / 2. 로그인 / 3. 게시물 작성 / 4. 게시물 보기 / 5. 종료 :");
			String input = scanner.nextLine();
			
			if (input.equals("1")) {
				// 1. 아이디 중복확인
				System.out.print("아이디 : ");
				String id = scanner.nextLine();
				
				CheckIdRequestDto checkIdRequest = new CheckIdRequestDto();
				checkIdRequest.setId(id);
				
				CheckIdResponseDto checkIdRsponse = authController.checkId(checkIdRequest);
				Code code = checkIdRsponse.getCode();
				
				if (code == Code.DI) {
					System.out.println("중복된 아이디입니다.");
					continue;
				}
				
				if (code == Code.DBE) {
					System.out.println("데이터베이스 에러입니다.");
					continue;
				}
				
				if (code == Code.VF) {
					System.out.println("잘못된 입력입니다.");
					continue;
				}
				
				System.out.println("사용 가능한 아이디입니다.");
				
				System.out.print("비밀번호 : ");
				String password = scanner.nextLine();
				System.out.print("비밀번호 확인 : ");
				String passwordCheck = scanner.nextLine();
				
				// 2. 이메일 인증 코드 전송
				System.out.print("이메일 : ");
				String email = scanner.nextLine();
				
				SendCodeRequestDto sendCodeRequest = new SendCodeRequestDto();
				sendCodeRequest.setEmail(email);
				
				SendCodeResponseDto sendCodeResponse = authController.sendcode(sendCodeRequest);
				code = sendCodeResponse.getCode();
				
				if (code == Code.VF) {
					System.out.println("잘못된 입력입니다.");
					continue;
					
				}
				
				if (code == Code.DE) {
					System.out.println("중복된 이메일 입니다.");
					continue;
					
				}
				
				if (code == Code.DBE) {
					System.out.println("데이터베이스 에러입니다.");
					continue;
					
				}
				
				System.out.println(sendCodeResponse.getData());
				
				// 3. 이메일 인증 처리 
				
				
				// 4. 회원가입 처리 
				
				
			}
			if (input.equals("2")) System.out.println("로그인");
			if (input.equals("3")) System.out.println("게시물 작성");
			if (input.equals("4")) System.out.println("게시물 보기");
			if (input.equals("5")) break;
	
		}

		System.out.println("프로그램 종료");

	
	}

}


// app 자바를 만드는 과정

// ------------------------------------------
// controller 생성 -> Service -> Repository
// 아래에 DTO, Entity 생성 
// ------------------------------------------ 자바 내부에 있음 

// DTO로 보내고 검증 후 완료 X 반환 완료 O 넘어감
// 리포지토리에서 데이터 베이스로 넘겨주고 처리 후 다시 넘겨줌
// 서비스로 작업을 하다가 필요한 데이터가 있으면 리포지한테 넘겨주고 확인 완료 후 
// 컨트롤ㄹ로 넘겨서 컨트롤이 앱 화면으로 넘겨줌 
//사용자로부터 받은 아이디가 중복되는지를 확인기 위한 쿼리들을 유저리포지토리임플리먼츠에서 확인 

// 아이디 중복 확인

// 입력 : 아이디  

// 출력 : 

// 성공
// 실패 
// - 중복된 아이디 
// - 데이터베이스 에러 

// 프로세스 : 
// - user 테이블에서 입력받은 아이디로 조회한 결과가 존재하면 중복, 존재하지 않으면 사용가능 






















