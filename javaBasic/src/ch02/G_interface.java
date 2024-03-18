package ch02;

// 인터페이스 : 클래스가 구현해야만하는 메서드들을 선언하는 참조 타입
// 인터페이스의 모든 변수는 public static final 형태가 와야함 
// 인터페이스의 모든 메서드는 public abstract 형태가 와야함 (default나 static 메서드가 올 수 있음)
// 인터페이스는 다중 구현이 가능 

// 접근제어자 interface 인터페이스명 { ... }
// 넓이 공식 
// 삼각형 넓이 구하기 - Double 밑변, Double 높이 -> Double 삼각형 넓이 // 어떤 타입의 무슨 형태가 나오는지 파악하기
// 정사각형 넓이 구하기 - Double 변 -> Double 정사각형넓이 
// 직사각형 넓이 구하기 - Double 밑변, Double 높이 -> Double 직사각형 넓이
// 원넓이 구하기 -  Double 반지름 -> Double 원넓이 // 변하지 않고 고정적인 데이터는 제외시켜 준다. 

interface AreaCalculation {
	
	public static final double PI = 3.14; // 상수의 값을 고정해두기 위해서 public static final 형태를 사용함 
	
	public abstract double getTriangleArea (double bottom, double height); 
	public abstract double getSquareArea (double side);	
	public abstract double getRectangleArea (double bottom, double height);
	public abstract double getCircleArea (double radius);	
	
}

// 인터페이스는 implements 키워드를 이용해서 클래스에 구현해야함 // 인터페이스는 인스턴스를 만들 수 없음 
class MyMath implements AreaCalculation {

	@Override
	public double getTriangleArea(double bottom, double height) {
		return bottom * height / 2;
	}

	@Override
	public double getSquareArea(double side) {
		return side * side; 
	}
	
	@Override
	public double getRectangleArea(double bottom, double height) {
		return bottom * height;
	}

	@Override
	public double getCircleArea(double radius) {
		return radius * radius * PI;
	}

} 

class MyMathV2 implements AreaCalculation {

	@Override
	public double getTriangleArea(double bottom, double height) {
		return bottom * height / 2;
	}

	// side를 변경 시킴 
	@Override
	public double getSquareArea(double side) {
		return Math.pow(side, 2);
	}

	@Override
	public double getRectangleArea(double bottom, double height) {
		return bottom * height;
	}

	@Override
	public double getCircleArea(double radius) {
		return radius * radius * PI;
	}

}  


public class G_interface {
	
	public static void main(String[] args) {
		
		AreaCalculation instance = new MyMathV2(); // 코드에 대한 안전성을 보장할 수 있다. ]
		// 인터페이스(AreaCalculation) MyMath()와 MyMathV2가 앞에 인터페이스를 사용하기에 참조하기 편하기 위해서 고정시키고 new 뒤에만 변경 시킴 
	
	}

}


// 변수에도 타입이 있고 클래스에도 타입이 있다.
// 그냥 클래스 형태면 추상클래스 기능을 이용하면 인터페이스를 이용하는 것이 좋다
