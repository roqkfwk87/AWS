package ch02;


// GalaxyPhone 
// 제조사 : (maker - String)
// 모델명 : (modelName - String)
// 소유자 : (owner - String)
// 전화번호 : (telNumber - String)
// 전원상태 : (power - boolean)

// 전원버튼누름 : onPower - power 상태를 부정
// 전화걸기 : call - power가 true일 때 "(상대 전화번호)로 전화를 겁니다." 출력
// 긴급전화걸기 : - emergency - "112로 전화를 겁니다." 출력
// 휴대전화정보보기 : getInfomation - power가 true일 때 
// 
// ===== (전화번호) =====
// 제조사 : (제조사)
// 모델명 : (모델명)
// 소유자 : (소유자)
// 
// 출력 

class GalaxyPhone  {
	static String maker;
	String modelName;
	String owner;
	String telNumber;
	boolean power;

	void onPower () {
		power = !power;
	}
	
	void call (String totelNumber) {
		if (!power) return; // power 자체의 true / false가 포함되어 있음 
		System.out.println(totelNumber + "로 전화를 겁니다.");
	}
	
	static void emergency () {
		System.out.println("112로 전화를 겁니다.");
	}
	
	void getInfomation () {
		if (!power) return;
		System.out.println("=====" + telNumber + "=====");
		System.out.println("제조사 : " + maker);
		System.out.println("모델명 : " + modelName);
		System.out.println("소유자 : " + owner);
	}
}

// Drama
// 방송사 : (brodcastingCompany - String)
// 제목 : (title - String)
// 배우 : (actors - String[]) 
// 장르 : (genre - String)
// 시청률 : (ViewerRatings - double)
// 부작 : (series - int)

// 정보보기 : getInfomation
// ===== (title) =====
// 방송사 : (brodcastingCompany)
// 장르 : (genre)
// 부작 : (series) 부작
// 시청률 : (ViewerRatings)%
// 배우 : (actor), (actor), (actor), ...             전지현, 김수현, 박해진, 유인나 


class Drama {
	String brodcastingCompany;
	String title;
	String[] actors;
	String genre;
	double ViewerRatings;
	int series;
	
	void getInfomation () { 
		System.out.println("=====" + title + "=====");
		System.out.println("방송사 : " + brodcastingCompany);
		System.out.println("장르 : " + genre);
		System.out.println("부작 : " + series + "부작");
		System.out.println("시청률 : " + ViewerRatings + "%");
		System.out.print("배우 : "); // 배우가 찍히고 쭉 연결하기 위해서 print로 입력
		for (int index = 0; index < actors.length; index++) {
//			System.out.print(actors[index]);
			// {"A", "B", "C"}
//			if (index < actors.length -1) System.out.println(", "); // actors.length의 앞까지 ", "을 찍어야 하기 때문에 -1을 사용한다
			// index < actors.length -1 
			// true면 actors[index] + ", " / false면 actors[index]
			String actor = index < actors.length -1 ? actors[index] + ", " : actors[index];
			System.out.print(actor);
		}
		System.out.println("");
	}
}

// TriangleMath
// 빗변 구하기 - getHypotenuse 
// 둘레 구하기 - getCircumference
// sin 구하기 - getSin
// cos 구하기 - getCos
// tan 구하기 - getTan

class TriangleMath { // 속성이 없는 상태 
	
	// static final double PI = 3.14; // 상수인데 스테틱이 되는 것 
	
	// 인스턴스 메소드 
	static double getHypotenuse (int bottom, int height) {
		if (bottom <= 0 || height <= 0) return 0; // 조건이 충족시 0값을 반환한다.
//		if (!(bottom > 0 && height > 0)) // 이 방법도 있다, 0보다 크다의 부정값으로 음수가 나옴  
		double result = Math.pow(bottom, 2)+ Math.pow(height, 2); // Math.pow(bottom, 2) bottom = 무엇을 제곱할 건지 2 = 몇 번을 할 건지 
		if (bottom <= 0 || height <= 0) return 0;
		return Math.sqrt(result);
		
	}
	
	// 오버로딩 : 과적해서 초과하다, 같은 이름의 메서드를 여러 개 가지면서 매개변수의 유형과 개수를 다르게 하는 방법을 의미
	static double getCircumference(int height, int bottom, int hypotenuse) {	
		if (bottom <= 0 || height <= 0 ||  hypotenuse <= 0) return 0;
		return height + bottom + hypotenuse; 
		
	}
	
	static double getSin(int height, int hypotenuse) {
		if (hypotenuse<= 0 || height <= 0) return 0;
		return height / hypotenuse;
	}
	
	static double getCos(int bottom, int hypotenuse) {
		if (bottom <= 0 || hypotenuse <= 0) return 0;
		return bottom / hypotenuse;
	}
	
	static double getTan(int height, int bottom) {
		if (bottom <= 0 || height <= 0) return 0;
		return height / bottom;
	}

}


public class A_Example {

	public static void main(String[] args) {
		GalaxyPhone s23 = new GalaxyPhone();
		GalaxyPhone s24 = new GalaxyPhone();

		GalaxyPhone.maker = "LG";
		
		// s23.maker = "SAMSUNG";
		s23.modelName = "S23";
		s23.owner = "홍길동";
		s23.telNumber = "010-1234-5678";
		s23.power = false;
		
		// s24.maker = "SAMSUNG";
		s24.modelName = "S24";
		s24.owner = "김철수";
		s24.telNumber = "010-5678-1234";
		s24.power = false;
		GalaxyPhone.emergency();
		
		s23.onPower(); // 휴대폰 전화를 킨 상황 
		s23.getInfomation();
		s23.emergency();
		
		s24.onPower(); // 휴대폰 전화를 킨 상황 
		s24.getInfomation();
		s24.emergency();
		
		
		Drama star = new Drama();
		star.brodcastingCompany = "SBS";
		star.title = "별에서 온 그대";
		star.actors = new String[] {"전지현", "김수현", "박해진", "유인나"};
		star.genre = "로맨스";
		star.ViewerRatings = 28.1;
		star.series = 21;
		
		star.getInfomation();
		
		TriangleMath triangleMath = new TriangleMath();
		double bit = triangleMath.getHypotenuse(3, 4);
		System.out.println(bit);	
		
//		System.out.println(TriangleMath.PI);
//		TriangleMath.PI = 0.0;
		
		// 단일책임원칙이 지켜지지 않은 경우 - 삼각형에 관한 설명에서 PI는 분류를 잘 못 들어간 것이다 
		
		
	}

}

// static 설명
// = 이 적혀 있어야 할당, 없는 경우 구조만 되어 있음
//="", s23= / s24= new로 만들어 줌 

// s23= new		//	maker =""
				//	modelName =""
				//	owner =""
				//	telNumber =""
				//	power =""

// s23.maker= SAMSUNG을 가르키고 있다.	
// maker ="SAMSUNG" 지정

//maker ="SAMSUNG"
//modelName =""
//owner =""
//telNumber =""
//power =""

// 이 상태로 바뀜 
// maker ="" - 메모리 공간에 할당이 됨 
// static을 만들게 되면 
// GalaxyPhone.maker = SAMSUNG 이 만들어짐 

// static이 만들어지지 않은 애들이 
// S23= /s24= New로 만들어짐 	//modelName =""
							//owner =""
							//telNumber =""
							//power =""
// 이 클래스에서 maker가 선언되어 빠지게 됨 

// s23.maker가 위에는 없기 때문에 처음 만들어뒀던 클래스로 이동하여 maker ="SAMSUNG" 저장된 곳을 찾게 됨 
// s23.maker를 LG로 바꾸게 된다면 maker ="SAMSUNG"이 바뀐것이다. 


// 한 객체에 대해서 속성을 파악하여 데이터를 만듦

// 그냥 변수는 ()가 필요없다. str.변수
// 메서드는 ()가 필요하다. 메서드()이미로 ()보고 메서드를 판단함 str.메서드()






