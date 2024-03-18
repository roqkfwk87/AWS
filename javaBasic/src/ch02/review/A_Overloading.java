package ch02.review;

class OverloadClass {
	
	// 오버로딩 : 하나의 클래스 내부에서 같은 이름의 메서드를 여러개 가질수 있도록 하는 것
	// 조건 : 
	// 1. 메서드의 이름이 같아야함
	// 2. 매개변수의 조합이 달라야함 (타입, 갯수, 타입의 순서)
	// 3. 반환타입과 매개변수의 이름은 오버로딩에 영향을 주지 않음 
	
	// 장점 : 
	// 1. 코드의 일관성과 가독성을 향상 
	// 2. 다형성 지원으로 코드의 확장성을 향상 
	void method() {}
	
	void method (int arg) {}

	void method (double arg) {}
	
	void method (int arg1, double arg2) {}
	
	void method (double arg1, int arg2) {}
	
	// 매개변수의 개수와 타입은 같고 리턴타입이 다른 경우는 오버로딩이 성립되지 않음
	// 오버로딩을 할 수 없는 것
//	int method() {} // 리턴값만 다른것은 오버로딩을 할 수 없다 void로 반환타입을 지정해두었는데 다른 타입인 int로 바꿀 수 없다
//	void method (int prarmeter) {} // int arg가 이미 매개변수가 같은 타입에다가 1개의 값을 가지고 있으므로 성립되지 않음
	
	
}


public class A_Overloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
