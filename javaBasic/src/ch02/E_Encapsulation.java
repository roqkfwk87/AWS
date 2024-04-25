package ch02;

// 캡슐화 : 멤버 변수(속성)와 메서드를 묶어서 변수에 대한 조작을 메서드를 통해서만 할 수 있도록 하는 것
// 정보 은닉과 데이터 보호, 데이터 무결성을 보장할 수 있음
class FootballPlayerB {
	private String name; // private로 선언하면 외부에서 변경이 불가능함 
	private String birth;
	private String team;
	private int goal;

	
	FootballPlayerB(String name, String birth, String team, int goal) { // 초기화를 하기 위해서 생성자가 필요함 
		this.name = name;
		this.birth = birth; // 생일은 무조건 바뀌지 않는다. setter은 무조건 바뀌지 않은 값은 선언하지 않는다. 
		this.team = team;
		this.goal = goal;
	}
	
	String getName () { // getter 메서드
		return this.name;
	} 

	String getBirth () {
		return this.birth;
	}
	
	String getTeam () {
		return this.team;
	}
	
	int getGoal () {
		return this.goal;
	}
	
	void setName (String name) { // setter 메서드 
		this.name = name;
	}
	
	void setTeam (String team) {
		this.team = team;
	}
	
	void setGoal (int goal) {
		if (goal < 0) return; // 0미만의 수를 넣을 수 없음 
		this.goal = goal;
	}

	class FootballPlayerC {
		private String name; 
		private String birth;
		private String team;
		private int goal;
		
		FootballPlayerC(String name, String birth, String team, int goal) {
//			super();  Object를 받아옴 따로 선언해두지 않으면 이클립스 내에서 기본 생성자를 만든다. 
			this.name = name;
			this.birth = birth;
			this.team = team;
			this.goal = goal;
		}
		
		String getName() {
			return name;
		}
		void setName(String name) {
			this.name = name;
		}
		String getTeam() {
			return team;
		}
		void setTeam(String team) {
			this.team = team;
		}
		int getGoal() {
			return goal;
		}
		void setGoal(int goal) {
			this.goal = goal;
		}
		String getBirth() {
			return birth;
		}
	
	}
	
}

public class E_Encapsulation {

	public static void main(String[] args) {
		
		FootballPlayerB son = new FootballPlayerB("손흥민", "920000", "토트넘 홋스퍼", 0);
//		son.name = "손흥민";
//		son.team = "토트넘 홋스퍼";
//		son.goal = 0;
		
	
		son.setGoal(-1); // 정확하지 않은 값을 막을 수 있다. 0보다 작은 값은 리턴한다 했기에 -1값은 출력되지 않음 
		
		System.out.println(son.getName()); // 메서드를 사용함 
		System.out.println(son.getBirth());
		System.out.println(son.getTeam());
		System.out.println(son.getGoal());
		

	}
}

// 하나의 이름으로 여러개 기능을 다룬 것 => 다형성을 이용한 것 (오버로딩 / 오버라이딩)
// 캡슐화 : 데이터의 무결성 유지
// 장점 : 테이터 은닉, 유지 보수성, 데이터 보호(가장 큼)
// default가 저장되어 있으면 public을 선언해봤자 의미가 없음 
// 자바에서 초기화란 선언한 객체에 최초로 값을 넣어주는 것
// 이유 : 메소드 영역에서 선언할 경우에는 자동으로 값이 할당되지 않기 때문에 에러가 발생해서 그렇다
// 클래스 영역에서 선언 -> 변수만 선언하면 오류 안 나옴, 메소드 영역에서 선언 -> 변수만 선언하면 오류 남
// 무결성 : 결정이 없다 이 데이터안에 정확한 값이 들어가 있다는 것 
// setter을 안 쓰는 무결성은 변경되지 않았다라는 무결성 
// 어떤 이유로 캡슐화를 쓰는지 알면된다. 
// 수요일 시험 문제 2문제 1. 객체 한개 배웠던 객체지향 특성들 상속 / 캡슐화 / 다형성(오버로딩, 오버라이딩) / 추상화를 전부다 섞어서 하나의 리스트로 만들수 있게 시험출제 됨  
// 2. 객체 안 써도 되는 단순한 로직문제 스위치 제외 전부 다 쓰임 

// 추상화 클래스 2개 분류 - 1. 객체(드라마, 축구) 2. 기능에 대한 집합 (트라이앵글math)
// 추상 클래스를 상속받은 메소드는 반드시 오버라이딩을 해야 함

