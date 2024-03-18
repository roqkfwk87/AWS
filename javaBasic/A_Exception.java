package ch03;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.InputMismatchException;
import java.util.Scanner;

// 예외 : 프로그램 실행 중에 발생할 수 있는 예상치 못한 상황
// 에러와의 차이는 에러가 발생하면 프로그램이 실행조자 되지 않지만,
// 예외는 실행은 됨 
// 에러는 개발자가 직접 처리하기 힘든 경우가 대부분이고 예외는 개발자가 직접 처리할 수 있음 

// 예외처리 : try catch 구문을 통해서 처리 가능
// try { 예외가 발생할 가능성이 있는 구문 }
// catch ( 예외클래스 예외인스턴스 ) { 특정 예외가 발생할 때 실행할 구문 }
public class A_Exception {
	
	// throw를 통해서 호출부에 예외러치에 대한 강제성 부여
	private void throwException() throws Exception { 
		// throw를 통해서 강제로 예외를 발생 
		throw new NullPointerException("널포인터 제외"); // Exception in thread "main" java.lang.NullPointerException: 널포인터 제외
	}

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// 발생할 수 있는 예외
		// - 사용자가 정수를 입력하지 않았을 때
		// - 사용자가 0을 입력했을 때
		
		try {
			int number = scanner.nextInt(); // 정수 X 인 경우 Exception in thread "main" java.util.InputMismatchException at ch03.A_Exception.main(A_Exception.java:18)
			System.out.println(18 / number); // 0인 경우 Exception in thread "main" java.lang.ArithmeticException:/ by zero at ch03.A_Exception.main(A_Exception.java:19)
		
		
		}catch (ArithmeticException exception) {
			System.out.println("수학적 예외가 발생했습니다."); // 0인 경우 예외처리 
		}catch (InputMismatchException exception) {
			System.out.println("옳지 못한 입력을 하였습니다."); // 정수X인 경우 예외처리 
		}finally { // finally를 이용한 예외처리 방법 3
			// finally로 예외가 발생하든 안하든 실행할 코드를 작성 
			// 자원의 반환처리를 대부분 finally 에서 작업 
			scanner.close();
			System.out.println("Scanner 자원을 반환했습니다.");
		}
		
//		catch (Exception exception) { // 예외처리 방법 2
//			System.out.println("예외가 발생했습니다.");
//		}
		
		A_Exception instance = new A_Exception(); 
		
//		instance.throwException(); // 강제로 부여 해서 아래 코드 완성시킴
		try {
			instance.throwException();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		System.out.println("프로그램이 정상적으로 종료되었습니다.");
		
		
	}
}

