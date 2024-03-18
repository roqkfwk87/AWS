package ch01;

import java.util.Scanner;

public class C_Operator {

	public static void main(String[] args) {
		
		// 연산자
		int a = 15;
		int b = 7;
		double c = 15.0;
		double d = 7.0;
		
		int intResult;
		double doubleResult;
		
		// 산술연산자 : 사칙연산 작업 숫자 데이터에 대해서 연산을 수행 
		
		// 더하기 : +
		// 좌항에 우항을 더한 값을 반환 
		intResult = a + b; // 22
		doubleResult = c + d; // 22.0
		
		doubleResult = a + b;
		intResult = (int) (c + d); //double -> int (X) 형변환을 해줘야 함 
		
		// 정수 + 실수 = 실수 
		// intResult는 정수이므로 계산 X
		doubleResult = a + d;
		
		// 빼기: -
		// 좌항에 우항을 뺀 값을 반환 
		intResult = a - b; // 8
		doubleResult = c - d; // 8.0
		
		// 정수 - 실수 = 실수 
		doubleResult = a - d; 
		
		// 곱하기 : *
		// 좌항에 우항을 곱한 결과를 반환 
		intResult = a * b; // 105
		doubleResult = c * d; // 105.0
		
		// 정수 - 실수 = 실수 
		doubleResult = a * d; 
		
		// 나누기 : /
		// 좌항에 우항을 나눈 결과를 반환 
		// 정수 나누기 정수의 결과는 실수부가 버려짐
		intResult = a / b; // 2 
		System.out.println(intResult);
		doubleResult = c / d; // 2.142857142857143
		System.out.println(doubleResult);
		
		// 정수 - 실수 = 실수 
		doubleResult = a / d; 
		System.out.println(doubleResult); // 2.142857142857143
		
		// 나머지 : %
		// 좌항에 우항을 나눈 나머지를 반환 
		intResult = a % b; // 1
		doubleResult = c % d; // 1.0
		
		// 정수 - 실수 = 실수 
		doubleResult = a % d; 
		System.out.println(doubleResult); // 1.0
		
		// 증감 연산자
		// 피연산자의 값을 1 증가 혹은 감소 
		// 증가 연산자 : ++
		// 감소 연산자 : --
		int number = 5;
		intResult = ++number + 5; // 11 전체 수식을 처리하기 전에 적용(먼저 증가) number값이 6으로 증가한 후 연산함 
		intResult = number++ + 5; // 10 전체 수식의 처리가 끝난 다음 적용(후에 증가) 5 + 5 = 10 연산은 10이후 number값을 찍으면 증가하였기에 6이 됨
		System.out.println(intResult); 
		
		// 대입 연산자 : 좌항에 우항을 할당 
		
		// 일반 대입 연산자 : =
		// 상수에 초기화를 할때를 제외하고 좌항이 반드시 변수이어야 함
		// 좌항에 우항을 할당 
		number = 10; 
		
		// 복합 대입 연산자 : 산술연산= 
		// 좌항에 사용되는 변수는 반드시 초기화가 되어 있어야 함
		// 좌항에는 변경 가능한 일반 변수가 와야함 (상수 불가능)
		// 좌항에 우항을 연산한 결과를 좌항에 할당 
		number += 10; // number = number + 10; // 20
		number -= 7; // number = number - 7 // ;13
		
		number *= (7 - 5);
		System.out.println(number); // 26
		
//		int number1;
//		number1 += 10;
		
		// 비교 연산자 : 좌항과 우항을 비교하여 그 결과를 논리값으로 반환
		boolean booleanResult;
		
		// 같다, 다르다 연산 
		// == : 좌항과 우항이 같으면 true, 다르면 false
		// != : 좌항과 우항이 다르면 true, 같으면 false 
		booleanResult = a == b;
		System.out.println(booleanResult); // false
		booleanResult = a != b; 
		System.out.println(booleanResult); // true
		
		String string = "Hello";
		booleanResult = string == "Hello";
		 System.out.println(booleanResult); //true
		
		// 작다, 작거나 같다 연산
		// < : 좌항이 우항보다 작으면 true, 같거나 크면 false
		// <= : 좌항이 우항보다 작거나 같으면 true, 크면 false
		booleanResult = a < c;
		System.out.println(booleanResult); // false
		booleanResult = a <= c;
		System.out.println(booleanResult); // true

		// 크다, 크거나 같다 연산
		// < : 좌항이 우항보다 크면 true, 같거나 작으면 false
		// <= : 좌항이 우항보다 크거나 같으면 true, 작으면 false
		booleanResult = a > c;
		System.out.println(booleanResult); // false
		booleanResult = a >= c;
		System.out.println(booleanResult); // true
		
		// 논리 연산자 : 피연산자가 모두 논리형태로 논리 값을 조합하는 것
		// && : AND 연산 - 좌항과 우항이 모두 true이면 true, 하나라도 false면 false
		booleanResult = false && false;
		System.out.println(booleanResult);  // false
		System.out.println(booleanResult); // false
		
		// || : OR연산 - 좌향과 우향 중 하나라도 true면 true, 모두 false면 false
		booleanResult = true &&  true;
		System.out.println(booleanResult); // true
		booleanResult = a < b || c > d;
		System.out.println(booleanResult); // true
		
		// a : 15, b : 7
		booleanResult = (a < b) && (a > ++b); // 논리연산자 앞이 false이기에 뒤에 수식은 인식을 하지 않는다.
		System.out.println(booleanResult);
		System.out.println(b); // 7 인식을 했을 경우 8이 나와야 함
		
		booleanResult = (a > b) && (a < ++b); // 논리연산자 앞이 true이기에 뒤에 수식을 인식 함
		System.out.println(booleanResult); //
		System.out.println(b); // 인식을 하여 8이 나옴
		
		booleanResult = (a > b) || (a > ++b); // 앞이 true이기에 뒤를 인식하지 않음
		System.out.println(booleanResult);
		System.out.println(b); // 8 인식을 했을 경우 9가 나와야 함
		
		booleanResult = (a < b) || (a > ++b); // 앞이 false이기에 뒤를 인식함
		System.out.println(booleanResult);
		System.out.println(b); // 인식을 하여 9가 나옴
		
		// 삼항 연산자 : 간단한 조건에 따라 결과를 반환하는 연산자
		// 조건(논리식) ? 참일때결과 : 거짓일때결과 
		Scanner scanner = new Scanner(System.in);
		System.out.println("나이 : ");
		
		int age = scanner.nextInt();
		
		String stringResult = age > 19 ? "성인" : "미성년자";
		System.out.println(stringResult);
		
		
		
		
		
		
		
		
	}

}
