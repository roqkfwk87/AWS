package ch02;

// 기타 제어자(비접근 제어자) : 접근 제어와 무관하게 동작을 제어하는 것
// final 제어자 : 
// - 클래스 : final 제어자가 붙은 클래스는 확장(상속)할 수 없음
// - 메서드 : final 제어자가 붙은 메서드는 오버라이드할 수 없음 
// - 변수 : final 제어자가 붙은 변수는 재할당할 수 없음 
final class FinalModifier1 {
	int variable;
}

//class subModifier1 extends FinalModifier1 { //class에 final을 붙이면 확장할 수 없다.
//	
//}

class FinalModifier2 {
	
	final void method () {}
	
}

class SubModifier2 extends FinalModifier2 {
	
//	void method () {} // final 메소드를 붙이지 않은 것은 오버라이딩을 할 수 없다.
	
}

class FinalModifier3 {
	
	final int variable = 10;
	
	void method () {
//		variable = 20; final로 값을 할당해줬기 때문 
	}
	
}

// static 제어자 :
// - 메서드 : static 제어자가 붙은 메서드는 인스턴스 생성없이 클래스로 바로 호출 가능
// - 변수 : static 제어자가 붙은 변수는 인스턴스 생성없이 클래스로 바로 접근 가능 
class staticModifier {
	
	static int variable;
	
	static void method () {};
	
}

// 제어자의 조합 
class Combination {
	
	// public + static + final (주로 사용)// 쓰고 싶은 메시지를 저장하여 사용?, 자주사용되는 조합이다.
	public static final int NUMBER = 10; 
	
	// 메서드에서 private + final (사용 X)
	private final void method () {} // 작성은 가능, private 상태에서는 final을 붙일 의미가 없다.
	
	// 메서드에서 private + abstract X (서로 상충) // 외부에서 접근 불가, 단, 반드시 오버라이드를 해야함 말이 안됨
	// 클래스와 메서드에서 final + abstract X (서로 상충) 
	 
	
	
}


public class D_Modifier {

	public static void main(String[] args) {
		staticModifier.variable = 0;
		staticModifier.method();

	}

}


// 메서드에서 final을 사용하면 오버라이드를 할 수 없다.








