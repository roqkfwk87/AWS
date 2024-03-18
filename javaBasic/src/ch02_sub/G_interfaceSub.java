package ch02_sub;

// G_Method를 따르지 않고 출력 값을 쓰고 싶어서 개인적인 메서드를 만들었음?
class InterfaceSub implements G_Message { // 사용하지 않는  G_Message에.java에메서드 1,2에 의존 당해서 컴파일러 에러가 남, 구현하고 싶지 않은데 구현해야 함
	// implements 인터페이스에서 데리고 올 때 쓰는 키워드 
	
	int method3 (int number) {
		System.out.println(G_Message.GREETING_MESSAGE);
		
		System.out.println(G_Message.GOOBYE_MESSAGE);
		return 3 + number;
	}
	
}


// 반드시 메서드 1, 2를 구현해야하는 메서드 => 추상메서드로 구현이 되어 있기 때문
// 다이아몬드 문제가 해결 (G_Message.java 에 method1, 2 적어둠)
public class G_interfaceSub implements G_Message, G_Method { // G_Method 에 메서드 1,2 가 있다면 요기도 반드시 있어야 함 
	
	// 이 클래스 내에서만 사용가능
	public void method1 () { // 인터페이스에 퍼블릭을 걸어둔 상태에서 G_Method를 불러오게 된 상태에서 void method1() 앞에 public을 붙이지 않으면 컴파일러에러가 남 
		System.out.println(G_Message.GREETING_MESSAGE);
		
		System.out.println(G_Message.GOOBYE_MESSAGE);
	}

	// 이 클래스는 지정을 해뒀기에 다른 곳에서도 사용가능 
	public void method2 () {
		System.out.println(G_Message.GREETING_MESSAGE);
		
		System.out.println(G_Message.GOOBYE_MESSAGE);
		
	}

}
	
	
// 시스템은 결합도가 낮아야 함 , 필요한 녀석들만 사용할 수 있게 해야함 



