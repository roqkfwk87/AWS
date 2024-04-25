package ch02;

// 생성자 메소드 
class ExampleClass99 {
	
	int attribute1;
	double attribute2;
	
	static int staticAttribute;
		
	ExampleClass99 (int arg1, double arg2) { 
			
			System.out.println("ExampleClass99 인스턴스 생성!!");
			
			this.attribute1 = arg1; // attribute1을 넣을 시 위의 attribute1으로 가게 
			this.attribute2 = arg2;
			
		}
		ExampleClass99() {
			this.attribute1 = 99;
			this.attribute2 = -99.99;
		}
	
		ExampleClass99(int attribute1) {
			this(attribute1, -99.99);
			this.attribute1 = attribute1;
			this.attribute2 = -99.99;
		}
}




public class create {

	public static void main(String[] args) {
		
		ExampleClass99 instance1 = new ExampleClass99(0, 0); 
		ExampleClass99 instance2 = new ExampleClass99(0, 0);
		
		instance1.attribute1 = 10;
		instance1.attribute2 = 3.14;
		System.out.println(instance1.attribute1);
		System.out.println(instance1.attribute2);
		System.out.println(instance2.attribute1);
		System.out.println(instance2.attribute2);
		
		ExampleClass99.staticAttribute = 99;
		instance1.staticAttribute = 100;
		System.out.println(instance1.staticAttribute);
		System.out.println(instance2.staticAttribute);
		
		
		ExampleClass99 instance3 = new ExampleClass99(99, -99.99);
		System.out.println(instance3.attribute1);
		System.out.println(instance3.attribute2);
		ExampleClass99 instance4 = new ExampleClass99(999, 99.99);
		System.out.println(instance4.attribute1);
		System.out.println(instance4.attribute2);

	}

}