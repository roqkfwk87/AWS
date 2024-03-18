package ch02_sub;

// ch02에 선언된 AccessModifier 클래스는 
// 접근 제어자가 default이기 때문에 외부 패키지에서 import가 불가능
// import ch02.AccessModifier;

// ch02에 선언된 C_AccessModifier 클래스는
// 접근 제어자가 public 이기 때문에 외부 패키지에서 import가 가능 
import ch02.C_AccessModifier; 

class SubClass extends C_AccessModifier {
	
	void method () {
		super.protectedVariable = 0;
	}
}

public class C_AccessModifierSnb {
	
	public static void main(String[] args) {
		
		C_AccessModifier instance = new C_AccessModifier();
		
		// C_AccessModifier 클래스와 privateVariable 필드는
		// 접근 제어자가 private이기 때문에 외부 클래스에서 접근이 불가능
//		instance.privateVariable = 0;
		
		// C_AccessModifier 클래스와 defaultVariable 필드는
		// 접근 제어자가 default이기 때문에 외부 패키지에서는 접근이 불가능
//		instance.defaultVariable = 0;
		
		// C_AccessModifier 클래스의 protectedVariable 필드는
		// 접근 제어자가 protected이기 때문에 외부 패키지에서는 접근이 불가능
		// 단, C_AccessModifier 클래스를 확장한 클래스에서는 접근이 가능 
//		instance.protectedVariable = 0;
		
		// C_AccessModifier 클래스의 publicVariable 필드는
		// 접근 제어자가 public이기 때문에 외부 패키지에서는 접근이 가능
		instance.publicVariable = 0;
		
//		instnace.a = 0; // 정의되지 않아서 생기는 컴파일러 에러 
		
		
	}

}
















//import ch02.AccessModifier; 볼 수 없는 상태 , 다른 패키지에 있어서 접근을 할 수가 없다.
// 그래서 import ch02.C_AccessModifier; 바꿔준다.
// instnace.a = 0; // 완전히 없다. 정의되지 않았다. instnace cannot be resolved to a variable