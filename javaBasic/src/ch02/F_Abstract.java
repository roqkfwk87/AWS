package ch02;

// 추상 클래스 : 추상 메서드를 포함할 수 있는 클래스 
// 추상 클래스 자체로 인스턴스를 생성할 수 없음, 반드시 추상클래스를 상속한 하위 클래스로 인스턴스를 생성해야 함 
// abstract class 추상클래스명 {  }

// 추상 메서드 : 선언부만 존재하고 구현부는 존재하지 않는 메서드
// 반드시 추상 클래스를 상속받은 하위 클래스에서 오버라이딩 해서 구현해야 함
// abstract 반환타입 추상메서드명 (매개변수);

// player
// 이름 : 문자열
// 종족 : 문자열
// 성별 : 문자열 
// 경험치 : 정수 

// 대화 - 입력 : (메시지 - 문자열) / 출력 : void 
// 사냥 - 입력 : (수치 - 정수) / 출력 : (경험치 - 정수)

abstract class Player {
	String name;
	String special;
	String gender;
	int experience;

	// 추상클래스에서도 생성자를 만들 수는 있지만
	// 하위클래스에서 호출하는 용도로만 사용 
	Player(String name, String special, String gender, int experience) { // 셍성자를 만들었음 (source - 제너레이트 유징 필드)
		super();
		this.name = name;
		this.special = special;
		this.gender = gender;
		this.experience = experience;
	}

	// 반드시 이 형태로만 사용해야 함 final
	final void chat (String message) { // 모든 직업들이 이 기능만을 사용하게 하여 변경못하게 하는 것 : final을 사용함 
		System.out.println(this.name + ": " + message);
	}
	
	// final가 완전 상충 abstract (변경해야 함?)
	abstract double hunt (int figure);

}

class Dealer extends Player { // Player(추상 메서드를 포함하고 있는 추상클래스)를 상속받으면 추상 메서드를 구현해야 하는데 구현하지 않으면 컴파일러 에러가 남
	
	Dealer(String name, String special, String gender, int experience) { // 소스 - 제너레이드 유징 슈퍼 클래스 
		super(name, special, gender, experience);
		// TODO Auto-generated constructor stub
	}
	
	double hunt (int figure) { // 구현했기 때문에 컴파일러 에러가 없어짐
		System.out.println(figure + "만큼의 공격을 했습니다.");
		this.experience += (figure * 0.8);  // 경험치가 누적되기 때문에 복합대입연산자 사용
		return this.experience;

	}


}

class Tanker extends Player {

	Tanker(String name, String special, String gender, int experience) {
		super(name, special, gender, experience);
		// TODO Auto-generated constructor stub
	}

	@Override
	double hunt(int figure) {
		System.out.println(figure + "만큼의 공격을 받습니다.");
		this.experience += figure;
		return this.experience;
	}

}

public class F_Abstract {

	public static void main(String[] args) {
		
		// Player player 빨간줄이 안 그어진 이유는 변수의 타입으로는 쓸 수 있다 (기억하기) 
		// 추상클래스는 인스턴스를 생성할 수 없음 
		// Player player = new Player("이름", "인간", "성별", 0); 
		// new Player(생성자 부분에 그어져 있는 상태 -> 생성자로 못 쓴다. 인스턴스를 사용할 수 없다.) 은 추상 클래스로 완성이 되지 않아 컴파일러 에러가 남, 
		// 추상클래스를 여기서 사용할 수는 없지만 생성자를 만들 수는 있다.
	
		// 반드시 추상 클래스를 상속하여 구현한 하위클래스로 인스턴스를 생성 
		Dealer dealer = new Dealer("이름", "인간", "성별", 0); // class Player 값 입력  
		
		
		
	}

}


// 코드 중복을 줄이고 싶어서 상속을 사용하는 것이지 무조건은 아니다
// 캡슐화도 무결성을 줄이기 위해서 사용 
// 메소드는 리턴값이 필요한데 생성자도 메서드인데 리턴값을 적지 않는 이유는 :
// 생성자는 무슨일이 있어도 인스턴스를 반환하기 때문에 리턴값을 적을 필요가 없다.



