package ch01;

public class B_DataType {

	public static void main(String[] args) {
		
		// 기본형 데이터 타입
		// 정수형 데이터 타입 : 실수부가 없는 정수를 나타냄
		// byte : 1byte(8bit)의 크기를 가지는 정수형 데이터 타입
		// -128 ~ 127
		byte byte1 = 127;
		// byte byte2 = 128; // 값을 초과하였기에 컴파일러 에러가 남
		
		// short : 2byte(16bit)의 크기를 가지는 정수형 데이터 타입
		// -32768 ~ 32767
		short short1 = 32767;
		// short short1 = 32768;
		
		// int : 4byte(32bit)의 크기를 가지는 정수형 데이터 타입
		// -2147483648 ~ 2147483647
		int int1 = 2_147_483_647;
		// int int1 = 2_147_483_648; 

		// long : 8byte(64bit)의 크기를 가지는 정수형 데이터 타입
		// -9223372036854775808 ~ 9223372036854775807
		long long1 = 2_147_483_648L; //L(l)을 붙여서 사용
		
		// 실수형 데이터 타입 : 실수부를 가지는 데이터 타입 
		// float : 4byte(32bit)의 크기를 가지는 실수형 데이터 타입 
		// 소수점 6-7 자리에서 오차가 발생
		float float1 = 3.1415926535F; //F(f)를 붙여 사용
		System.out.println(float1);
		
		// double : 8byte(64bit)의 크기를 가지는 실수형 데이터 타입
		// 소수점 15-17 자리에서 오차가 발생
		double double1 = 3.1415926535;
		System.out.println(double1);
		
		// 문자형 데이터 타입 : 문자 하나를 저장할 수 있는 데이터 타입
		// char : 2byte(16bit)의 크기를 가지는 문자형 데이터 타입
		// 0 ~ 65535 까지
		char char1 = 'a'; //작은 따옴표(문자열)로 표시
		char char2 = 97;
		System.out.println(char1);
		System.out.println(char2);
		
		// 논리형 데이터 타입 : 참과 거짓 값을 가지는 데이터 타입
		// boolean : 1byte(8bit)의 크기를 가지는 논리형 데이터 타입
		// true, false
		boolean boolean1 = true;
		boolean boolean2 = false;
		
		// 형변환 : 데이터 타입이 서로 다른 변수를 옮겨 닮는 거 
		
		// 자동 형변환 (묵시적 형변환) : 작은 데이터 타입의 변수를 큰 데이터 타입의 변수에 옮겨 닮을 때 발생
		int number = 10;
		long longNumber = number;
		
		// 강제 형변환 (명시적 형변환) : 큰 데이터 타입의 변수를 작은 데이터 타입의 변수에 롬겨 닮을 때 발생 
		// 할당하고자 하는 큰 데이터 타입 변수 앞에 (작은 데이터타입)을 붙여줌 
		number = (int) longNumber;
		
		number = 256;
		byte byteNumber = (byte) number;
		System.out.println(byteNumber); // 데이터 손실
		
		short shortNumber = 97;
		char character = 97; 
		
		// shortNumber = character;
		
		int intNumber = 100;
		float floatNumber = 100;
		// intNumber = floatNumber;
		
		int age1 = 10, age2 = 20, age3 = 33, age4, age5;
		
		// 배열 : 동일한 타입의 변수를 묶어 저장하는 컨테이너 
		// new 연산자를 이용해서 생성을 해야함
		// 한번 생성된 배열의 크기는 변경할 수 없음 
		
		// 선언
		// 데이터타입[] 변수명(배열명); 
		
		// 생성
		// 변수명 = new 데이터타입[크기];
		
		int[] numbers; 
		numbers = new int[5];
		System.out.println(numbers);
		
		// 변수에 담겨져 있는 것은 주소 (numbers = 변수) , *배열 부분 반드시 기억하기 
		int[] numbers2 = {1, 2, 3, 4, 5}; // 초기화
		int[] numbers3 = new int[] {1, 2, 3, 4, 5}; // 생성과 동시에 초기화 
		System.out.println(numbers2);
		System.out.println(numbers3);
		
		// 배열의 요소에 접근할 때는 '인덱스' 사용 
		// 인덱스는 0번부터 시작 마지막 인덱스는 길이 -1번 
		int item = numbers2[0];
		System.out.println(item);
		item = numbers[0]; // 자동생성시 0으로 기본 생성 (초기설정X)
		System.out.println(item);
		numbers[0] = 99;
		System.out.println(item);
		item = numbers[0]; 
		System.out.println(item);
		
		System.out.println("==============================================================");
		System.out.println("==============================================================");
		System.out.println("==============================================================");
		
		// 인덱스 범위를 초과하는 인덱스에 접근할 시 예외발생 
		// System.out.println(numbers[5]); // 인덱스 5번은 존재하지 않아 에러남
		
		// 기본형 데이터 
	    // 참조형 데이터(변수가 가지고 있는 주소의 위치 참조) 
		
		// numbers : {99, 0, 0, 0, 0} X [I@36aa7bc2 O (주소가 들어가 있음)
		System.out.println(numbers);
		
		numbers2 = numbers;
		// numbers2 : {99, 0, 0, 0, 0} X, [I@36aa7bc2 O 
		System.out.println(numbers2);
		
		numbers[4] = -99;
		// numbers : {99, 0, 0, 0, -99}
		// numbers : {99, 0, 0, 0, -99}
//		System.out.println(numbers2[4]); // -99 
		
		int number1 = 0;
		int number2 = number1;
		number1 = -99;
		System.out.println(number1);
		System.out.println(number2);
		
		char[] chars1 = {'a', 'p', 'p', 'l', 'e'}; // 배열은 사이즈 변경이 안됨 
		System.out.println(chars1);
		
		// String: 문자열을 표현하는데 사용되는 참조형 데이터 타입 
		// 문자열을 다루는데 유용한 여러가지 기능을 제공해주고 있음 
		String string1 = "apple";
		
		// String의 주요 기능
		String statement = "  My name is ironman  ";
		
		// 1. 문자열 결합
		// + 혹은 concat(문자열)으로 두 문자열을 연결할 수 있음
		System.out.println(statement + "!!!");
		System.out.println(statement.concat("???"));
		
		// 2. 문자열 비교
		// equals(문자열) : 두 문자열이 동등한지 비교
		// compareTo(문자열) : 두 문자열이 사전순으로 비교 
		// compareToIgnoreCase(문자열) : 대소문자 구분없이 사전순으로 비교 
		System.out.println(statement.equals("My name is hulk")); // false 
		System.out.println(statement.equals("  My name is ironman  ")); // true
		System.out.println(statement.compareTo("apple")); 
		System.out.println(statement.compareToIgnoreCase("apple")); 
		
		// 3. 문자열 길이 
		// length() : 문자열의 길이를 반환(결과 도출) 
		System.out.println(statement.length()); // 22
		
		// 4. 문자열 변환 
		// toUpperCase() : 모든 문자를 대문자로 변경
		// toLowerCase() : 모든 문자를 소문자로 변경
		// trim() : 문자열의 앞뒤 공백을 모두 제거 
		System.out.println(statement.toUpperCase());
		System.out.println(statement.toLowerCase());
		System.out.println(statement.trim());
		
		// 5. 문자열 찾기
		// indexOf(문자열) : 찾고자하는 문자열의 처음 찾은 위치의 인덱스 번호를 반환 
		// lastIndexOf(문자열) : 찾고자하는 문자열의 마지막으로 찾은 위치의 인덱스 번호를 반환 
		statement = "내가 그린 기린 그림은 잘 그린 기린 그림이고 네가 그린 기린 그림은 잘못 그린 기린 그림이다.";
		System.out.println(statement.indexOf("그림"));
		System.out.println(statement.indexOf("하마"));
		System.out.println(statement.lastIndexOf("그림"));
		System.out.println(statement.lastIndexOf("하마"));
		
		// 6. 부분 문자열 
		// substring(시작인덱스), substring(시작인덱스, 종료인덱스) : 문자열을 원하는 크기만큼 추출 
		System.out.println(statement.substring(48));
		System.out.println(statement.substring(3, 10));
		
		// null : 아직 어떠한 값도 지정되지 않은 상태
		String string2 = null;
//		System.out.println(string2.substring(48)); // 값이 지정되어 있지 않아 에러가 남 
		
		
		// 컴퓨터는 위에서 아래로 좌항에서 우항으로 흐른다
		
		
	}
}