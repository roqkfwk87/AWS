package ch02;

// 다형성 : 하나의 표현이 여러가지 형태로 나타낼 수 있는 것

// 오버로드(오버로딩) : 같은 클래스 내에서 메서드의 이름으로 여러개의 메서드를 정의할 수 있도록 하는 것  
// 오버라이드(오버라이딩) : 자손 클래스에서 조상 클래스에 정의된 메서드를 재정의 하는 것  

class Human1 {
	String name;
	int age;
}

class Developer1 extends Human1{
	String position;
}

class FootballPlayer1 extends Human1 implements FootballPlay {
	int goal;

	@Override
	public void Kick() {
		
	}
	
}

interface FootballPlay {
	public abstract void Kick ();
}


public class H_Polymorphism {

	public static void main(String[] args) {
		
		Human1 human1 = new Human1();
		
		Developer1 developer1 = new Developer1();
		FootballPlayer1 footballPlayer1 = new FootballPlayer1();
		
		// 업캐스팅 : 하위클래스 객체를 상위 클래스의 참조변수에 담을 수 있도록 변환하는 것 
		// 			인터페이스 구현 클래스를 구현한 인터페이스의 타입 참조변수로 담을 수 있도록 하는 것 
		
		// 참조 변수 만듦 (Human1 human2/3)
		Human1 human2 = new Developer1();
		Human1 human3 = new FootballPlayer1();
		
		FootballPlay football = new FootballPlayer1(); // implements FootballPlay 를 해서 이렇게 작성 가능 
		// FootballPlay 가 FootballPlayer1한테 Kick이 있는지 물어봄 
		
		
		// 다운캐스팅 : 업캐스팅된 객체를 다시 원래의 타입의 참조변수에 담을 수 있도록 변환하는 것 
//		human2.position = ""; // 내 시야에 보이지 않기에 사용할 수 없음 , 실제로는 존재하고 있음
//		Developer1 developer2 = (Developer1) human2; // 기능을 사용하기 위해서 강제로 담아버림 
//		developer2.position = ""; // 사용가능해짐
	
		
		// 캡처 2번 사진 참고
		FootballPlayer1 fp = new FootballPlayer1();
		fp.name = "홍길동";
		fp.age = 30;
		fp.goal = 55;
		
		System.out.println(fp); // ch02.FootballPlayer1@515f550a
		System.out.println(fp.name); // 홍길동
		System.out.println(fp.goal); // 55
	
		// 캡처 3번 사진 참고 
		Human1 hm = fp; // fp를 hm에다가 집어넣음 
		System.out.println(hm); // ch02.FootballPlayer1@515f550a
		System.out.println(hm.name); // 홍길동
//		System.out.println(hm.goal); // 내가 보는 시야가 다시 좁아졌기 때문에 실행을 할 수 없음 
//		hm.Kick(); // 시야에서 사라졌기 때문에 사용 X
		
		FootballPlayer1 fpp = (FootballPlayer1) hm; // 강제 시야를 다시 넓혀버림
		System.out.println(fpp); // ch02.FootballPlayer1@515f550a
		System.out.println(fpp.name); // 홍길동
		System.out.println(fpp.goal); // 55
		
		// 주의해야 할 점 
		Human1 hmm = new Human1();
		Developer1 dev = (Developer1) hmm; // 원래 있던 시야범위를 강제로 Developer1시야를 가지게 해서 시야를 넓혀서 시야가 추가가 됨 
		
		dev.position = "포지션";
		System.out.println(dev.position); // 출력결과 : 에러 
	}

}


//업캐스팅 : 자식 클래스의 캐스팅을 부모 클래스에 담아주는 것
//다운캐스팅 : 부모 클래스의 캐스팅을 자식 클래스에 담아주는 것
//강제로 진행해 버림 
// 인터페이스 참조 타입임 



// G_interface.java 클래스 생성을 받아들이 수 있음 
// 어떻게 가능한가?
// 설명
// 휴먼의 있는 데이터에서 String position을 붙임



































