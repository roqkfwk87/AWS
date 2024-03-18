package ch03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class B_Package {

	public static void main(String[] args) {
		
		// Wrapper 클래스 : 기본형 데이터 타입을 참조형 데이터 타입으로 다룰 수 있도록 하는 클래스 
		// 일반적으로 기본형 데이터타입의 풀네임에 첫글자를 대문자로 지정하면 Wrapper 클래스가 됨 
		Integer wrapperInt = 10;
		Double wrapperDouble = 10.0;
		Boolean wrapperBoolean = false;
		String wrapperString = "String";
		
		// 자주 사용하는 기능
		// parse 메서드 : 문자열을 특정 타입으로 변환 
		int number = Integer.parseInt("123");
	
		// toString 메서드 : 특정 타입의 값을 문자열로 변환 
		String string = Integer.toString(123);

		// Collection Framework : java에서 데이터구조에 대한 표준화된 기법을 제공
		

		// List : 데이터를 저장할 때 중복 허용하고 순서가 존재함 
		List<Integer> arrayList; // Int[] arrayList; 와 같은 느낌이다. 
		//Integer를 넣으면 정수타입의 데이터를 만들 수 있음 
		// List<참조형 타입> arraylist 기본형이고 <>를 제너릭이라고 하는데 이 제너릭에는 참조형 타입만 올 수 있음
		
		// *ArrayList : List 중에서 내부 배열을 사용하여 인덱스를 사용한 검색이 빠름, 가장 많이 사용함 
		arrayList = new ArrayList<>(); // 배열 1개 생성
		System.out.println(arrayList);
		
		// LinkedList : 이중 연결 기법을 사용하여 추가, 삭제가 빠름 
		arrayList = new LinkedList<>();
		
		// add() : List에 요소를 추가
		// 주의할 사항 : 추가할 요소의 데이터 타입은 반드시 제너릭으로 지정한 타입으로만 지정 가능 
		arrayList.add(10); // add(요소) 가지고 있는 요소 사이즈만 만들 수 있기 때문에 지금 배열에서는 1개로만 만들 수 있음 
//		System.out.println(arrayList);
		// 배열 2개를 만들고 싶으면 arrayList.add(null); 값을 만들어서 배열2개에 요소1나가 추가된 상태로 만든다. 
//		arrayList.add("aaaa"); 
		// 제너릭 <>에 넣어둔 타입으로만 가능 // List<Integer> arrayList; 일 경우 에러 
		// List<Object> arrayList;라고 바꾸면 사용 가능 or 아무것도 안 넣은 경우 사용가능

		// get() : List의 특정 인덱스 요소에 접근 
		// List 인덱스 범위를 초과하는 인덱스를 지정할 수 없음 
		// 기본형 데이터타입의 변수로 반환값을 받을 경우 null 값을 받을 수 있음을 주의 // arrayList.add(null); - Exception in thread "main" java.lang.NullPointerException: 발생한다.
		int arrayElement = arrayList.get(0);
		 System.out.println(arrayElement); // 10
		
		arrayList.add(20);
		arrayList.add(30);
		System.out.println(arrayList);
	
		// set() : List의 특정 인덱스 요소를 변경
		// List 인덱스 범위를 초과하는 인덱스를 지정할 수 없음 
		arrayList.set(1, -99);
		System.out.println(arrayList);
		
		// remove() : List의 특정 요소를 삭제
		arrayList.remove(2); // 인덱스 번호로 지워야 함 // [10, -99]
		System.out.println(arrayList);
		
		// size(): List의 길이를 반환 
		System.out.println(arrayList.size());
		
		// Set : 데이터를 저장할 때 중복을 허용하지 않고 순서가 존재하지 않음 (집합)
		Set<String> set;
		
		// HashSet : 해싱 기법을 사용해서 검색 속도가 빠름
//		set = new HashSet<>();
		
		// TreeSet : 요소를 정렬해서 추가 
		set = new TreeSet<>();
		
		// add() : Set에 요소를 추가, 단, 동일한 요소가 이미 추가되어있다면 추가하지 않음 
		
//		set = new HashSet<>(); 경우
		set.add("Apple"); 
		System.out.println(set); // [Apple]
		set.add("Banana");
		System.out.println(set); // [Apple, Banana]
		set.add("Banana1");
		System.out.println(set); // [Banana1, Apple, Banana] // 순서가 막 나옴 
		
//		set.add("Banana"); // 중복된 값이어서 추가가 되지 않음 
//		System.out.println(set);
		
//		set = new TreeSet<>(); 경우
		set.add("Apple"); 
		System.out.println(set); // [Apple, Banana, Banana1]
		set.add("Banana");
		System.out.println(set); // [Apple, Banana, Banana1]
		set.add("Banana1");
		System.out.println(set); // [Apple, Banana, Banana1] 
		
		// remove() : Set에서 특정 요소를 제거 
		// 제거하고자 하는 요소가 없더라도 예외가 발생하지 않음 
		set.remove("Apple"); // 요소 값 Apple 제거, (인덱스로 제거X)
		set.remove("Apple1"); // Apple, Banana, Banana1 , 없는 요소는 단순히 처리하지 않음 
		System.out.println(set); // [Banana, Banana1]
		
		// contains() : Set에서 특정 요소가 존재하는지 확인 
		System.out.println(set.contains("Apple")); // false
		System.out.println(set.contains("Banana")); // true 
		
		// Map : 키와 값이 한쌍으로 이루어진 요소들의 집합, 키는 중복 불가능, 값은 중복 가능, 순서 없음 
		Map<String, String> map;
		// HashMap : 해싱기법으로 키의 검색 속도가 빠름 
//		map = new HashMap<>();
		
		// TreeMap : 키를 정렬하여 저장
		map = new TreeMap<>();
		
		// put() : Map에 키와 값을 추가 
		// 만약 동일한 키가 존재한다면 해당 키의 값을 변경 
		
//		map = new HashMap<>(); 경우
		map.put("Apple", "사과"); // {Apple=사과}
		System.out.println(map);
		map.put("Banana", "바나나"); // {Apple=사과, Banana=바나나}
		System.out.println(map);
		map.put("Apple", "링고"); // {Apple=링고, Banana=바나나}
		System.out.println(map);
		map.put("Banana1", "바나나"); // {Banana1=바나나, Apple=링고, Banana=바나나} // 정렬없이 출력 
		System.out.println(map);
		
//		map = new TreeMap<>(); 경우
		// 순서가 없음 
		map.put("Apple", "사과"); // {Apple=사과, Banana=바나나, Banana1=바나나}
		System.out.println(map);
		map.put("Banana", "바나나"); // {Apple=사과, Banana=바나나, Banana1=바나나}
		System.out.println(map);
		map.put("Apple", "링고"); // {Apple=링고, Banana=바나나, Banana1=바나나}
		System.out.println(map);
		map.put("Banana1", "바나나"); // {Apple=링고, Banana=바나나, Banana1=바나나}
		System.out.println(map);
		
		// get() : Map에서 특정 키를 가지는 요소를 반환 
		// 존재하지 않는 키로 검색할 경우 null로 반환
		System.out.println(map.get("Apple1")); // null
		
		// remove() : Map에서 특정 키를 가지는 요소를 제거
		// remove 작업에 성공하면 해당 키의 값을 반환 
		map.remove("Apple"); // {Banana=바나나, Banana1=바나나}
		map.remove("Apple1"); // {Banana=바나나, Banana1=바나나}
		System.out.println(map); 
		
		class Human {
			String name;
			String address;
			int age;
			
		}
		
		Human human1 = new Human();
		human1.name = "홍길동";
		human1.address = "부산광역시 진구";
		human1.age = 10;
		// name = "홍길동"
		// address = "부산광역시 진구"
		// age = 10
		
		Map<String, Object> human2 = new HashMap<>();
		// Object는 제약이 없음 
		human2.put("name", "홍길동");
		human2.put("address", "부산광역시 진구");
		human2.put("age", "열살"); 
		
		// 1 문제점 : 사용 혹은 추가할때 오타(실수)에 대한 가능성  
		human2.get("name");
		
		// 2. 문제점 : 타입의 안정성의 문제 
		Integer age = (Integer) human2.get("age");
		
		
	}

}

// int와 Integer 차이는 기본형과 참조형의 차이
// 참조형 변수는 null을 가질 수 있는 차이점이 있음


// 문자 하나의 들어가는 코드 - 유니코드 or 아스키코드 
// int number = Integer.parseInt("123");에 대한 아스키코드 찾아보고
// 3에 대한 아스키코드는 51임 
// "8"이라는 문자열이 있다 이것을 int로 바꾸고 싶다 했을 떄
// 8에 대한 아스키코드가 56이다. 라는 식으로 하면 됨 
// toString에 대한 문제가 나옴 
// 정수를 입력할 것인데 0을 초과하고 범위는 int범위 내에 있는 양의 정수를 입력할 것이고 그 녀석의 자리 수는 몇개이고 번호는 몇 번인가? 시험에 나옴 
// 1이상 20억이하? 입력된 자리의 정수는 몇자리 수고 각 자리의 숫자는 몇인가?
// 1234567890 10자리 수가 출력되고 각 자리수는 1의 자리 수는 0 10의 자리 수는 9 100의 자리수는 8 1000의 자리수는 7를 출력하는 방법 




