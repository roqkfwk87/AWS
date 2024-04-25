package ch02;

// 클래스 : 공통된 속성과 기능을 하나로 정의해둔 것 
// [접근제어자] class 클래스명 { 속성, 기능 }
// 클래스를 선언할 때는 클래스 외부에서 선언 
class ExampleClass1 {
	// 속성 : 클래스가 가질수 있는 정보나 상태
	// 일반적으로 변수로 표현
	
	// 인스턴스 변수
	// 각 인스턴스마다 독립적으로 값을 가지는 변수 
	int attribute1; // 정수 속성을 가진 인스턴스 변수
	double attribute2; // 실수 속성을 가진 인스턴스 변수 
	
	// 클래스 변수(스테틱 변수, 정적 변수)
	// 해당 클래스로 생성된 모든 인스턴스가 공유하는 변수 
	// 속성 앞에 static 키워드를 사용하여 지정할 수 있음 
	static int staticAttribute; // 스테틱 변수 정수타입
	
	// 기능 : 클래스가 가질수 있는 행동이나 작업 (메서드)
	// 클래스로 생성된 객체를 통해서 호출 가능 
	// [접근제어자 일반제어자] 반환타입 메서드명 (매개변수타입 매개변수명[, ...])
	// { 메서드 기능 구현 }
	
	// 매개변수 : O, 반환값 : O
	int method1 (int arg1, int atg2) {
		// 기능 구현 
		// 반환타입이 void가 아니면 반드시 return으로 결과를 반환해야 함
		return 0; // 같은 타입으로 반환 정수 - 정수(return0), 실수 - 실수(return0.0)
	}
	
	// 매개변수 : X, 반환값 : O
	int method2 () {
		return 0;
	}
	
	// 매개변수 : O, 반환값 : X
	void method3 (int arg1) {
		// void에서의 return은 강제로 메서드를 종료하기 위해 사용
		return;
	}
	
	// 매개변수 : X, 반환값 : X
	void method4 () {                      
		System.out.println(attribute1);
		System.out.println(staticAttribute);
		
		method2();
		statiMethod();
	}
	
	// 클래스 메서드(스테틱 메서드, 정적 메서드)
	// 모든 인스턴스가 공유하는 메서드
	// 반환타입 앞에 static 키워드를 붙여서 사용
	static void statiMethod() {
		// static 메서드에서는 instance 변수 접근 및 instance 메서드 호출이 불가
		// System.out.println(attribute1);
		System.out.println(staticAttribute);
		
		// method2(); // 스테틱으로 지정된 곳에서 사용할 수 없음 
//		statiMethod(); - static void statiMethod() { System.out.println(staticAttribute);} 계속 불러와서 무한루프가 됨 
	}

	// 생성자 : 클래스의 인스턴스를 생성하는 순간에 호출되는 메서드
	// 클래스와 같은 이름을 가지고 있고, 반환타입이 존재하지 않음
	// 클래스명 ([매개변수, ...]) { 인스턴스가 생성될때 할 작업 } 

	// 1)
	//	ExampleClass1 () {
//		System.out.println("ExampleClass1 인스턴스 생성!!");
//		attribute1= 99;
//		attribute2= -99.99;
		
	ExampleClass1 (int attribute1, double arg2) { // 매개변수를 넣어주면 좀 더 보기 편함
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
	ExampleClass1 () {
		this.attribute1 = 99;
		this.attribute2 = -99.99;
		
	}
	
	// 생성자 내부에서만 부를 수 있다 (앞뒤가 맞지 않아서 외부에서는 불러오기 X) 
	ExampleClass1 (int attribute1) {
		this(attribute1, -99.99); // 생성자 
// 1)	this.attribute1 = attribute1;
//		this.attribute2 = -99.99;
	
	}
	
	
}

// 축구선수 (FootballPlayer)
// 이름 (name - String)
// 포지션 (position - String)
// 생년월일 (birth - String) # int로 표현 못하는 수식이 있기에 int로 정의할 수 없음 
// 키 (height - double) 
// 몸무게 (weight - double)
// 국적 (country - String)
// 주발 (mainFoot - String)
// 팀 (team - String) 
// 골 (goal - int)
// 어시스트 (assist - int)
// 경고수 (foul - int)

// 잠자기 	(sleep) - 작업 : "(취침시간) ~ (기상시간)까지 취침" 출력 
// 밥먹기 	(eat) - 작업 : "음식 먹음" 출력
// 훈련하기	(train) - 작업 : 훈련!!" 출력
// 경기결과내기	(setGameResult) - 작업 : 골, 어시스트, 경고수 속성 변경 
// 이적하기 	(moveTeam) - 작업 : 팀 변경 

// 내부에 있는 데이터만으로는 작업할 수 없다 

class FootballPlayerA {
	String name;
	String position;
	String birth;
	double height;
	double weghit;
	String country;
	String mainFoot;
	String team;
	int goal;
	int assist;
	int foul;
	
	void sleep (String bedtime, String wakeUpTime) {
		System.out.println(bedtime + "~" + wakeUpTime + "까지 취침");
	}
	
	void eat (String food) {
		System.out.println(food + " 먹음");
	}

	void train () {
		System.out.println("훈련!!");
	}
	
	void setGameResult (int goalResult, int assistResult, int foulResult ) {
		// 복합대입연산자 사용
		goal += goalResult;
		assist += assistResult;
		foul += foulResult;
	}

	void moveTeam (String destinationTeam) {
		team = destinationTeam;
	}
	
	void printInfomation() {
		System.out.println("=============================================");
		System.out.println(name + "의 정보");
		System.out.println("포지션 : " + position);
		System.out.println("생년월일 : " + birth);
		System.out.println("키 : " + height);
		System.out.println("몸무게 : " + weghit);
		System.out.println("국적 : " + country);
		System.out.println("주발 : " + mainFoot);
		System.out.println("소속팀 : " + team);
		System.out.println("득점 : " + goal);
		System.out.println("도움 : " + assist);
		System.out.println("파울 : " + foul);
	}
	

}

public class  A_ClassAndObject {
	
	// 전역 필드 (전역 변수)
	// String team; // class 바로 아래 작성
	
	public static void main(String[] args) {
		// 지역 변수
		// String team; // 메서드 안에 작성 
		
		// 인스턴스 : 특정 클래스로 정의된 것을 실체화 한것 (객체) // 인스턴스 변수가 모아져 있는 것을 인스턴스라 한다.
		// 클래스명 참조변수명 = new 클래스명();
//		ExampleClass1 instance1 = new ExampleClass1(); 
//		ExampleClass1 instance2 = new ExampleClass1();
		
		ExampleClass1 instance1 = new ExampleClass1(0, 0); // 매개변수를 넣지 않았기 때문에 컴파일러 에러가 남, 자동완성 생성자가 없어져서 작동이 불가 
		ExampleClass1 instance2 = new ExampleClass1(0, 0);
		
		System.out.println(instance1);
		System.out.println(instance2);

		// 인스턴스가 가지고 있는 속성에 접근 방법
		// 인스턴스, 속성명;
		instance1.attribute1 = 10;
		instance1.attribute2 = 3.14;
		System.out.println(instance1.attribute1);
		System.out.println(instance1.attribute2);
		System.out.println(instance2.attribute1);
		System.out.println(instance2.attribute2);
		
		// 인스턴스가 가지고 있는 메서드 호출 방법
		// 인스턴스.메서드();
		// method 오류 파악 
		instance1.method1(1, 2); // 매개변수 O
		instance1.method2(); // 매개변수 X
		instance1.method3(0); // 매개변수 O
		instance1.method4(); // 매개변수 X
		
		FootballPlayerA son = new FootballPlayerA(); 
		FootballPlayerA lee = new FootballPlayerA(); 
		
		son.name = "손흥민";
		son.position = "공격수";
		son.birth = "920708";
		son.height = 183.0;
		son.weghit = 77.0;
		son.country = "대한민국";
		son.mainFoot = "오른발";
		son.team = "토트넘 홋스퍼 FC";
		son.goal = 0;
		son.assist = 0;
		son.foul = 0;
		
		lee.name = "이강인";
		lee.position = "미드필더";
		lee.birth = "010219";
		lee.height = 174.0;
		lee.weghit = 71.0;
		lee.country = "대한민국";
		lee.mainFoot = "왼발";
		lee.team = "파리 생제르명 FC";
		lee.goal = 0;
		lee.assist = 0;
		lee.foul = 0;
		
		System.out.println(son.name);
		System.out.println(lee.name);
		
		son.sleep("21:00", "06:00");
		son.eat("컵라면");
		son.train();
		
		son.setGameResult(1, 1, 0);
		son.moveTeam("아스날 FC");
	
		System.out.println(son.name + "의 정보");
		System.out.println("포지션 : " + son.position);
		System.out.println("생년월일 : " + son.birth);
		System.out.println("키 : " + son.height);
		System.out.println("몸무게 : " + son.weghit);
		System.out.println("국적 : " + son.country);
		System.out.println("주발 : " + son.mainFoot);
		System.out.println("소속팀 : " + son.team);
		System.out.println("득점 : " + son.goal);
		System.out.println("도움 : " + son.assist);
		System.out.println("파울 : " + son.foul);
		
		lee.setGameResult(0, 1, 2);
		
		System.out.println(lee.name + "의 정보");
		System.out.println("포지션 : " + lee.position);
		System.out.println("생년월일 : " + lee.birth);
		System.out.println("키 : " + lee.height);
		System.out.println("몸무게 : " + lee.weghit);
		System.out.println("국적 : " + lee.country);
		System.out.println("주발 : " + lee.mainFoot);
		System.out.println("소속팀 : " + lee.team);
		System.out.println("득점 : " + lee.goal);
		System.out.println("도움 : " + lee.assist);
		System.out.println("파울 : " + lee.foul);
	
		lee.moveTeam("수원 삼성");
		lee.printInfomation();
		
		son.printInfomation();
		
		// static 변수는 클래스로 직접 접근이 가능
		ExampleClass1.staticAttribute = 99; 
		// instance 변수와 메서드는 '반드시' 인스턴스를 생성하여 인스턴스로 접근 및 호출
		// ExampleClass1.attribute1 = 10;
		// ExampleClass1.method1(0, 0);
//		instance1.staticAttribute = 99;
		System.out.println(instance1.staticAttribute);
		System.out.println(instance2.staticAttribute);
		
		ExampleClass1.statiMethod();
		instance1.statiMethod();
		instance2.statiMethod();
		
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
		
		ExampleClass1 instance3 = new ExampleClass1(99, -99.99);
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


// parameters(매개변수)
// returnType(반환) 

// input은 외부에서 값이 와야지 처리할 수 있을 경우 사용 
// 메서드는 클래스 내부의 값으로 처리할 수 없을 경우 사용 
// 작업 결과가 내부 또는 외부로 나눌 수 있다 
// class 선언 이유 : 효율적인 프로그래밍을 하기 위해서 (중복 방지) 
// 인스턴스 변수(독립적으로 가지고 있는 변수로 인스턴스가 정의될 때 같이 할당이 됨) 와 스테틱 변수(클래스가 정의된 순간에 바로 메모리에 할당이 됨) 가 있음
// 스테틱 메서드에서는 인스턴스 변수를 사용할 수 없음 - 인스턴스변수는 인스턴스가 생성되야지 사용할 수 있기 때문에 

// ===========================================================

//변수는 사용하기 전에 무조건 초기화를 해야 함 
//
//초기화 작업 
//son.name = "손흥민";
//son.position = "공격수";
//son.birth = "920708";
//son.height = 183.0;
//...
//
//매번 사용하기 힘들기 때문에 메서드를 만들어서 사용함 
//printInfomation() -> 메서드
//* 메서드는 ()를 사용한다.
//
//초기화 이전에 하는 작업들을 생성자라는 메서드로 작업을 할 수 있음 
//
//생성자는 클래스명과 일치해야 한다.
//메서드는 반환값을 지정해 줄 필요가 없다. 무조건 반환되기 때문 
//
////매개변수를 받아주는 () 를 만들어주고
//// 위를 받아주는 {}을 만들어준다 
//ExampleClass1 (int arg1, double arg2) {
// 	System.out.println("생성!!");
//	attribute1 = arg1;
//	attribute2 = arg2;
//}
//
//attribute1 = 99는 99가 초기화된 상태로
//attribute2 = -99.99가 초기화된 상태로 사용해 주겠다.
//
//int arg1, double arg2 : 외부에서 받아서 사용하자라고 해서 만들어 준다.
//attribute1= 99 → attribute1 = arg1; 으로 만들어 준다.
//
//attribute1 = attribute1;
//컴퓨터는 가장 먼저 지정된 매개변수를 인식하기 때문에 앞에 만들어둔것 때문에 사용이 불가해짐
//그렇기에 this를 사용하여
//this.attribute1 = attribute1를 사용한다.  
//
//// 생성자를 만들어 줌 
//ExampleClass1 instance1 = new ExampleClass1();

//==========================================================

//number; - 변수 
//number(); - 메소드
//Number(); - 생성자 (생성자도 메소드이다) 












