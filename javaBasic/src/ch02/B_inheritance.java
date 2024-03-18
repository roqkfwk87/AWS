package ch02;

// 상속 : 객체지향 프로그래밍의 특성 중 하나
// 원래 존재하던 클래스를 확장하여 재사용할 수 있도록 하는 것
// 코드 중복을 제거하고 확장성을 높일 수 있음
// extends 키워드를 사용하여 확장
// 클래스 + 
// class SubClass extends SuperClass {} 

class Human {
	String name;
	int age;
	
	void sleep () {
		System.out.println(name + "가 잠을 주무십니다."); // 부모클래스를 바꾸면 자식 클래스도 바꿀 수 있다
	}
}

class Animal {
	String species;
	
	void sleep () {
		System.out.println("잠을 잡니다.");
	}
} 

// Java에서는 클래스의 단일 상속만 지원함
// 다이아몬드 문제를 방지하기 위함 
// 다이아몬드 문제 : 다중 상속을 했을 때 발생하는 메서드 호출의 모호성 
// 아래 코드에서 extends Human, Animal' 형태로 다중 상속을 할 수 없음 
class Teacher extends Human {
	String course;
	
	void teach () {
		System.out.println(name + "가 " + course + "를 가르칩니다.");
	}
}

class Developer extends Human {
	String position;
	
	void develop () {
		System.out.println(name + "가 " + position + " 개발을 합니다.");
	}
}

// 모든 클래스는 'object'라고하는 최상위 클래스를 반드시 상속받도 있음 // 기억하기 

public class B_inheritance {

	public static void main(String[] args) {
		
		Human human1 = new Human();
		human1.name = "홍길동";
		human1.age = 0;
		human1.sleep();
		
		Teacher teacher1 = new Teacher(); // Human의 기능과 teacher 기능을 함께 가지게 됨 
		teacher1.name = "김철수";
		teacher1.age = 10;
		teacher1.course = "국어";
		teacher1.sleep();
		teacher1.teach();
		
//		Object
		
		Developer developer1 = new Developer();
		developer1.name = "이영희";
		developer1.age = 20;
		developer1.position = "백엔드";
		developer1.sleep();
		developer1.develop();
		
		
	}

}

// 상속을 2개 받을 수 있다면 (상속은 1클래스당 1개만 받을 수 있음) 
// Teacher 가 가지고 있는 것 
//: name age species course 
//: sleep(Human) sleep(Animal) teach()
// 컴퓨터 입장에서는 휴먼인지 동물인지 어떤 sleep을 들고 와야하는지 모르는 상태를 다이아몬드 상황이라 함 
// 이런 문제를 해결하는 방법이 단일상속이다 

//  public void eat() // 이 부분이 선언부
//{
//  중괄호 부분이 구현부 
//	}


