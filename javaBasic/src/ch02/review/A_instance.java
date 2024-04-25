package ch02.review;

// Class ExamplClass {} //이미 정의된 class여서 사용할 수 없음 


public class A_instance {

	public static void main(String[] args) {
		
		// 객체(인스턴스) : 클래스에 정의된 대로 만들어진 독립적인 실체 
		// 클래스로 '생성'하는 작업이 이루어짐
		// new 연산자를 사용하여 생성 - new 클래스명() 
		ExampleClass instance = new ExampleClass(); // instance라는 이름의 참조 변수를 선언한 것 //new ExampleClass() 인스턴스 변수를 선언한 것 // 인스턴스 변수안에 참조변수가 선언됨 
		
		
		// 참조 : 아래 코드는 변수를 선언
		int number;
		ExampleClass example;
		
		// 참조 : 아래 코드가 인스턴스
		new ExampleClass();
		
		// 인스턴스의 변수와 메서드 접근 혹은 호출 : 인스턴스 변수 / 인스턴스.메서드()
		instance.instanceVariable = 0;
		instance.instanceMethod();
		new ExampleClass().instanceVariable = 0; // new ExampleClass() 인스턴스여서 수식은 가능하나 주소가 담겨 있지 않다.
		
		// 참조 아래 코드는 인스턴스가 복사된것이 아니라 인스턴스의 주소가 복사되어 할당 되는 것 
		ExampleClass anotherInstance = instance; 
	
	
	}

}



