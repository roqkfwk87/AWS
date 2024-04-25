package ch02;

// Drama2
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


class Drama2 {
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

class TriangleMath2 { // 속성이 없는 상태 
	
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


public class A_Example2 {

	public static void main(String[] args) {
		
		Drama2 star = new Drama2();
		star.brodcastingCompany = "SBS";
		star.title = "별에서 온 그대";
		star.actors = new String[] {"전지현", "김수현", "박해진", "유인나"};
		star.genre = "로맨스";
		star.ViewerRatings = 28.1;
		star.series = 21;
		
		star.getInfomation();
		
		TriangleMath2 triangleMath = new TriangleMath2();
		double bit = triangleMath.getHypotenuse(3, 4);
		System.out.println(bit);	
		
//		System.out.println(TriangleMath.PI);
//		TriangleMath.PI = 0.0;
		
		// 단일책임원칙이 지켜지지 않은 경우 - 삼각형에 관한 설명에서 PI는 분류를 잘 못 들어간 것이다 
		
		
	}

}







