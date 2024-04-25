package ch02;

class EXP {
	
	int attribute1; 
	double attribute2; 
	
	static int staticAttribute; 
	
	
	// 생성자 : 클래스의 인스턴스를 생성하는 순간에 호출되는 메서드
	// 클래스와 같은 이름을 가지고 있고, 반환타입이 존재하지 않음
	// 클래스명 ([매개변수, ...]) { 인스턴스가 생성될때 할 작업 } 

	// 1)
	//	ExampleClass1 () {
//		System.out.println("ExampleClass1 인스턴스 생성!!");
//		attribute1= 99;
//		attribute2= -99.99;
		
	EXP (int attribute1, double arg2) { // 매개변수를 넣어주면 좀 더 보기 편함
		System.out.println("ExampleClass1 인스턴스 생성!!"); 
		// 의존성이 내부에서 주입하는 형태
		// 속성 값이 생성 이전에 결정이 되었기 때문에 코드의 안전성이 저하 
//		attribute1= 99;
//		attribute2= -99.99;
		
		// 의존성을 외부에서 주입하는 형태
		// 속성 값이 생성 당시에 결정되기 때문에 코드의 안정성을 향상
		
//		int attribute1; // 12번 줄 위치
//		double attribute2; 
		this.attribute1= attribute1; // int attribute1;는 attribute1을 인식하고 있지 못하고 있기에 인식을 시켜주고 싶어 this.을 사용한다.
		// this 키워드 : 자기 인스턴스를 지칭
		this.attribute2= arg2; // double attribute1;요기 attribute1을 인식하고 있다. 동일한 이름이 아니어도 this.을 사용한다. 예시로 son.name = "손흥민";에서 son 대신에 this를 써준다.
//		this.statiMethod();
		
	}
	// 오버로딩 : 같은 클래스 내에서 같은 이름의 메서드를 여러개 작성할 수 있도록 하는 방법
	// 오버로딩 조건
	// 1. 메서드 이름을 중복해서 작성하지만(메서드 이름은 같아야 하지만) 매개변수의 타입 및 개수를 다르게 작성 
	// 2. 메서드의 반환타입과 메서드의 매개변수의 이름은 오버로딩에 영향을 미치지 않음 
	
	void overloadMethod() {
				
	}

	void overloadMethod(int arg) {

	}
	
	void overloadMethod(double arg) {

	}
	
	void overloadMethod(int arg1, double arg2) { // 매개변수의 조합 int, double

	}
	
//	void overloadMethod(double arg1, int arg2) { // 매개변수의 조합, double, int 순서가 다름 
//
//	}

//	int overloadMethod (double arg1, int arg2) {
//		return 0;	
//	}

//	void overloadMethod (double double1, int int1) { // 매개변수 이름이 같으면 오버로드가 적용이 안된다. 
//		
//	}

	
//int number;
//double number;
//- 2개가 중복되서 사용이 안되는 것처럼 
//Duplicate method overloadMethod(double, int) in type ExampleClass1 // 이것도 사용이 안됨 
//오버로딩 특징 외우기 (이해 어려움)	
	
	
	// 생성자도 메서드의 일종이기 때문에 오버로딩이 가능 
	// 생성자 내부에서만 부를 수 있다
	EXP () {
		this.attribute1 = 99;
		this.attribute2 = -99.99;
		
	}
	
	// 생성자 내부에서만 부를 수 있다 (앞뒤가 맞지 않아서 외부에서는 불러오기 X) 
	EXP (int attribute1) {
		this(attribute1, -99.99); // 생성자 
// 1)	this.attribute1 = attribute1;
//		this.attribute2 = -99.99;
	
	}
	
	
}



// 내부에 있는 데이터만으로는 작업할 수 없다 


public class  A_ClassAndObject2 {
	
	public static void main(String[] args) {
		
//		ExampleClass1 instance1 = new ExampleClass1(); 
//		ExampleClass1 instance2 = new ExampleClass1();
		
		ExampleClass1 instance1 = new ExampleClass1(0, 0); // 매개변수를 넣지 않았기 때문에 컴파일러 에러가 남, 자동완성 생성자가 없어져서 작동이 불가 
		ExampleClass1 instance2 = new ExampleClass1(0, 0);
		
		System.out.println(instance1);
		System.out.println(instance2);
		
		// 1)
//		ExampleClass1 instance3 = new ExampleClass1();
//		System.out.println(instance3.attribute1); // 99
//		System.out.println(instance3.attribute2); // -99.99 가 의존이 되어 있음
//		
//		ExampleClass1 instance4 = new ExampleClass1();
//		System.out.println(instance4.attribute1); // 99
//		System.out.println(instance4.attribute2); // -99.99 
//		instance4.attribute1 = 999;
//		instance4.attribute2 = 99.99;
		
//		ExampleClass1 instance3 = new ExampleClass1(); // 매개변수를 X이고 따로 attribute1 , 2 로 정의해둔게 내부의존성이다. 
//		attribute1= 99;
//		attribute2= -99.99;
		ExampleClass1 instance3 = new ExampleClass1(99, -99.99); // 매개변수를 외부로 넣는 것이 외부의존성 
		System.out.println(instance3.attribute1); // 99
		System.out.println(instance3.attribute2); // -99.99
		
		ExampleClass1 instance4 = new ExampleClass1(999, 99.99);
		System.out.println(instance4.attribute1); // 999
		System.out.println(instance4.attribute2); // 99.99 
		// instance4.attribute1 = 999;
		// instance4.attribute2 = 99.99;
		
		// BIP 의존성 역천의 원칙
		// 의존되어 있기에 이미 값이 결정되어 있다 
		
		ExampleClass1 instance5 = new ExampleClass1();
		System.out.println(instance5.attribute1); // 99
		System.out.println(instance5.attribute2); // -99.99
		
		ExampleClass1 instance6 = new ExampleClass1(100);
		System.out.println(instance6.attribute1); // 100
		System.out.println(instance6.attribute2); // -99.99
		
	}

}

//number; - 변수 
//number(); - 메소드
//Number(); - 생성자 (생성자도 메소드이다) 












