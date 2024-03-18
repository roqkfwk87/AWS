package ch02;

// 오버라이딩 : 하위 클래스에서 상위 클래스의 메서드를 재정의 하는 것 
// 규칙
// 1. 상위 클래스에서 선언된 메서드와 메서드 이름, 매개변수의 조합이 같아야 함
// 2. 상위 클래스에서 선언된 메서드가 final로 선언되면 재정의가 불가능 
// 3. 상위 클래스에서 선언된 메서드보다 더 좁은 범위의 접근 제어를 할 수 없음 

class SuperClass1 {
	
	int superInstanceVariable;
	
	SuperClass1 (int superInstanceVariable) {
		this.superInstanceVariable = superInstanceVariable;
	}
	
	void instanceMethod () {
		System.out.println("조상 클래스의 메서드입니다.");
	}
	
	
} 

class SubClass1 extends SuperClass1 {
	
//	void instanceMethod () { // 오버라이딩한 것 
//		System.out.println("SubClass1의 인스턴스 메서드입니다.");
//	}	
	
	// SuperClass1을 상속된 상태에서는 아래 메서드(1)를 가지고 있음 
	//(1) void instanceMathod () {...} 가지고 있는 상태에서
	
	// 'void instanceMethod ()' 메서드를 이미 가지고 있기 때문에
	// 아래 메서드는 'void instanceMethod ()' 메서드를 오버로드 한것 
	void instanceMethod (String string) {
			System.out.println(string);
		}
	
//	void instanceMathod (String string) {
//		System.out.println(string);
//	}
	
	// 부모 클래스에서 기본 생성자가 없다면 자식 클래스의 생성자에서
	// 반드시 부모 클래스의 생성자를 호출 해야함
	SubClass1() {
		// super() : 부모 클래스의 생성자를 호출하는 키워드 
		super(10);
	}
	
	
}

class SubClass2 extends SuperClass1 {
	
	SubClass2 (int superInstanceVariable) {
		super(superInstanceVariable);
		
	}
	
	// @Overrid : 컴파일러에게 아래에 오는 메서드가 오버라이드 메서드라는 것을 알려주는 것
	// 가독성 향상과 개발자의 실수를 방지할 수 있음 
	@Override 
	void instanceMethod () {
		// super 키워드 : 자손 클래스에서 조상클래스의 필드 혹은 메서드에 접근할 때 사용
		super.instanceMethod(); 
		System.out.println("SubClass2의 인스턴스 메서드입니다.");
	}
	
}


public class B_Overriding {

	public static void main(String[] args) {
		
		SuperClass1 instance1 = new SuperClass1(0); 
		SubClass1 instance2 = new SubClass1(); 
		SubClass2 instance3 = new SubClass2(50); 
		
//		instance1.instanceMethod();
//		instance2.instanceMethod();
		instance3.instanceMethod();
		
		System.out.println(instance1.superInstanceVariable); // 0
		System.out.println(instance2.superInstanceVariable); // 10
		System.out.println(instance3.superInstanceVariable); // 50
		

	}

}


// 오버로딩은 같은 클래스 내에서 매개변수 조건만 다르게 해서 같은 클래스를 만드는 것
// 오버라이딩 조상 클래스에서 만드는 것을 상속한 상태에서 한 개를 바꾸는 작업, 하위 클래스에서 상위 클래스를 상속받아 하위 클래스에서 재정의하는 것 
//폐쇄 원칙 
//사용 이유 : 코드가 안정적이지 않을 수도 있기 때문
//상속에서 오버라이딩으로 해결할 수 있음 
//정상적으로 작동하는 코드를 받아서 오버라이딩하여 새로 만들 수 있음 


