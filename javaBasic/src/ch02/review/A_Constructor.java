package ch02.review;

class ConstructorClass {
	
	// 글로벌 변수(지역변수) - 내부 지역
	int instanceVariable1;
	double instanceVariable2;
	
	// 생성자 : 클래스의 인스턴스를 생성할 때 호출되는 메서드 
	// 생성시에 실행할 코드를 구현한 메서드, 일반적으로 인스턴스 변수 초기화 작업에 사용
	// 생성자를 개발자가 직접 작성하지 않으면 자바가 기본 생성자를 자동으로 생성 
	
	// 규칙
	// 1. 클래스명과 동일한 이름을 가져야함
	// 2. 반환타입을 지정하지 않음 
	// 3. 인스턴스 생성 후에 사용할 수 없음 // 의존성 내부에서 주입상태일 때 외부에서 주입이 불가하기 때문에 인스턴스 생성 후는 외부에서 매개변수가 들어오는 것이기 때문에 생성자가 더 이상 사용불가 상태가 됨 
	ConstructorClass () {
		// 아래와 같은 상황을 '의존성을 내부에서 주입한다'라고 함
		// 의존성을 내부에서 주입하는 상황은 지양해야 함 
		this.instanceVariable1 = 10;
		this.instanceVariable2 = 9.9;
		
	}
	
	// 생성자도 메서드이기 때문에 오버로딩이 가능 
	ConstructorClass (int instanceVariable1) {
		// this : 현재 인스턴스 혹은 클래스를 가리키는 키워드
		// 글로벌 위치(지역변수)에 있는 변수 혹은 메서드를 지징할 때 사용 
		this.instanceVariable1 = instanceVariable1;
		
	}
	
	ConstructorClass (int instanceVariable1, double instanceVariable2) {
		// this() : 현재 클래스의 다른 생성자를 호출하는 키워드
		this(instanceVariable1);
		this.instanceVariable2 = instanceVariable2;
	}
}

public class A_Constructor {

	public static void main(String[] args) {
		
		// 생성자 사용
		ConstructorClass instance1 = new ConstructorClass();
		ConstructorClass instance2 = new ConstructorClass(1);
		ConstructorClass instance3 = new ConstructorClass(1, 1.1);
		
		System.out.println(instance1.instanceVariable1); // 10
		System.out.println(instance1.instanceVariable2); // 9.9
		System.out.println(instance2.instanceVariable1); // 1
		System.out.println(instance3.instanceVariable1); // 1
		System.out.println(instance3.instanceVariable2); // 1.1
	

	}

}

// 생성자는 인스턴스가 생성될 때 호출되는 인스턴스 초기화 매서드 이다.
// 인스턴스 초기화란 인스턴스 변수들을 초기화하는 것 
// 모든 클래스에는 반드시 하나 이상의 생성자가 정의되어 있어야 함 
// 생성자는 클래스 내에 선언되며, 구조도 메서드와 유사하지만 리턴값이 없다는 점이 차이점
// 생성자의 조건 : 생성자의 이름은 클래스의 이름과 같아야 하고 리턴값이 없다
// 생성자도 메서드이기 때문에 리턴값이 없다는 void를 붙여야 하지만, 모든 생성자가 리턴값이 없으므로 void를 생략할 수 있다.
// 연산자 new 가 인스턴스를 생성하는 것이지 생성자가 인스턴스를 생성하는 것이 아니다.

