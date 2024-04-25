/*
    암묵적 형변환
*/

/*
    문자열 타입으로 형변환
    - +연산자를 사용할 때 좌항과 우항 중 하나라도 문자열이 존재하면 
    문자열이 아닌 항을 문자열로 변경하여 연결 연산함
*/
console.log(1 + '1'); // 11


console.log('==============================');

/*
    숫자 타입으로 형변환
    - +연산자를 제외한 나머지 산술 연산 혹은 대소 비교 연산에 대하여
    좌, 우항 중 하나라도 숫자가 존재하면 숫자가 아닌 항을 숫자 타입으로 변경하여 연산을 진행 
*/
console.log('1' - 0); // 1


console.log('==============================');

/*
    불리언 타입으로 형변환
    - '', 0, NaN, null, undefined는 false, 그 이외의 데이터에 대해서는 true로 변경하여 연산을 진행 
*/
// 값이 false로 인식되어 실행 되지 않음
if (null) console.log('null'); 
// not null로 true이기 때문에 실행
if (!null) console.log('not null'); // not null


console.log('==============================');

/*
    명시적 형변환
*/

/*
    문자열 타입으로 형변환
    - String 클래스 생성자를 new 연산자 없이 사용
    - 데이터.toString()
    - 데이터 + "
*/
console.log(String(10)) // 10
console.log(typeof String(10)) // string 

console.log((10).toString()) // 10
console.log(typeof(10).toString()); // string

console.log('==============================');

/*
    숫자 타입으로 형변환
    - Number 클래스의 생성자를 new 연산자 없이 사용
    - 문자열일 경우 .parselnt(), .parseFloat() 메서드 사용 가능
    - + 단항연산자 사용가능
*/
// false는 불리언 값이며, 숫자로 변환될 때 0으로 변환
console.log(Number(false)); // 0
// 0이 출력되므로 타입은 number가 됨
console.log(typeof Number(false)); // number

// parseInt() 문자열을 정수로 변환
console.log(parseInt('10')); // 10
console.log(typeof Number(false)); // number

// pareseFloat() 문자열을 실수로 변환 
console.log(parseFloat('10.8')); // 10.8
console.log(typeof parseFloat('10.8')); // number
// false를 사용하면 NaN이 반환됨 (NaN은 number임)
// console.log(typeof parseFloat(false)); // number

console.log('==============================');

/*
    불리언 타입으로 형변환
    - Boolean 클래스의 생성자를 new 연산자 없이 사용
    - !! 사용 가능
*/
// '', 0, NaN, null, undefined는 false 이므로 이 외에 값은 true로 출력 
// '문자열'비어있지 않은 문자열이므로 true를 출력
console.log(Boolean('문자열')); // true
// '!!'는 불리언 값을 강제로 변환하는 방법
console.log(!!'문자열'); // true


console.log('==============================');

/*
    단축 평가 
    - 논리 연산자는 논리 결과를 결정한 피연산자의 결과를 그대로 반환 
    - true && data => data
    - false && data => false
    - true || data => true
    - false || data => data
*/
console.log('홍길동'||false); // 홍길동

