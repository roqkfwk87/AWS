package ch02;

class ExampleClass2 {
	static int number = 3;
	double doubleNumber;
	
	Sample1 method() {
		Sample1 sample = new Sample1();
		sample.data = -456;
		return sample;
	}
	
	static void staticMethod() {
		
	}



}

class Sample1 {
	int data;
	
	Sample1 () {}
	Sample1 (Sample1 sample) {
		this.data = sample.data;
	}

}

// 하나의 스레드이다.
public class A_JVM {

	public static void main(String[] args) {
		
		ExampleClass2 instance1 = new ExampleClass2(); 
		ExampleClass2 instance2 = new ExampleClass2();
		
		Sample1 sample = new Sample1(); 
		sample.data = 8;
		
		int number = 0;
		instance1.doubleNumber = 9.9;
		
		sample = instance1.method(); 
		
		System.out.println(sample.data); // -456
		
		int number2 = number; // number를 number2에 복사되서 들어감 
		number2++; // number2 1증가 시킴 
		System.out.println(number); // 0
		System.out.println(number2); // 1
		
		Sample1 sample2 = sample; // sample2에다가 sample을 복사해서 넣음 
		sample2.data++; // smaple2를 1증가 시킴 
		System.out.println(sample.data); // -455
		System.out.println(sample2.data); // -455
		
		Sample1 sample3 = new Sample1(sample); // new연산자를 쓰는 순간에 또다른 smaple data가 생성됨 생성되는 순간에 외부에 있는 sample1 값이 실행되고 sample을 받아옴 
		System.out.println(sample.data);  // -455
		System.out.println(sample3.data); // -455
		
		sample3.data++;
		System.out.println(sample.data);  // -455
		System.out.println(sample3.data); // -454 //새롭게 생성된 smaple3로 인식을 받고 있어서 +1 증가 시킴 
		
		
		
	}

}


//원본은 살아있기 때문에 복사본이 지워진다해도 상관X
// 매개변수가 나오든 들어가든 전부 복사되서 나온다. 원본은 따로 있다. 
// 메서드라는 작업이 arg를 1증가시키게 한다 
// 주소가 복사된 것이지 인스턴스가 복사된 것은 아니다. 
// 참조변수에는 다른 공간이 들어간다 




