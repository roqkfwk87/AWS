/*
    변수 : 데이터를 저장하는 공간에 이름을 부여한 것 
    - var, let, const 키워드를 사용하여 선언
*/
// 자바스크립트는 CamelCase를 이용하여 사용
var varVariable;
let letVariable;
// const는 변수를 선언해야 에러가 뜨지 않음 
const constVariable = 10;


/*
    변수의 중복 선언 : var 키워드로 선언한 변수는 중복 가능 선언 가능 
*/
var age = 23;
var age = 30;

// let로 선언한 변수는 중복 선언 불가능 
let address = '부산시';
// let address = '울산시';


/*
    동적 타이핑 : 변수의 타입이 데이터가 할당된 순간에 데이터의 타입에 따라 결정됨 
*/
var variable = 10;
// console,console.log(typeof variable);
variable = '10';
// console,console.log(typeof variable);

/*
    호이스팅 : var 키워드나  function 키워드로 선언한 변수 혹은 함수에 대해서 스코프가 최상위로 옮겨지는 것
    - 변수 생성 3 단계
    - 선언 단계 : 변수를 등록하는 단계 (스코프가 가능해짐)
    - 초기화 단계 : 변수에 undefined가 할당됨 
    - 할당 단계 : undefined에 할당한 실제값이 할당됨 
*/
// ReferenceError: x is not defined (x값이 선언되어 있지 않다고 알려줌)
// 파일 전체를 읽음 > 읽는 순간에 변수가 선언되었다고 인식 함 > console.log(x)에서 x가 선언되었다고 인식함
// console.log(x);
// x를 선언해 줌
// x = 10을 읽지 않음 
var x = 10;
if (true) {
    // 블록 내부에서 x = 99가 같은 라인으로 선언되어 99로 인식함
    var x = 99;
}
// 호이스팅으로 인한 문제 - var만 가지는 문제
// console.log(x);

/*
    var 키워드로 선언한 변수는 블록 레벨 스코프가 아닌 함수 레벨 스코프를 가짐 
    - 함수 레벨 스코프 : 함수 내에서 선언된 변수는 함수 안에서 사용 가능, 함수 밖에선 사용 불가능 
    - 블록 레벨 스코프 : 코드 블록 내에서 선언된 변수는 코드 블럭 안에서 사용 가능, 코드 블럭 밖에선 사용 불가능 
*/

/*
    var 키워드로 선언된 변수의 문제점
    1. 함수 레벨 스코프
        - 모든 변수가 전역 변수로 선언 됨 
    2. var 키워드 없이도 생성 가능 
        - 의도하지 않은 변수 생성 
    3. 중복 선언 가능
        - 의도하지 않은 변수 변경
    4. 호이스팅 
        - 선언전에 사용가능 

    - 이러한 문제를 해결하기 위해 ES6+ 부터는 let, const 키워드로 변수를 선언 
*/

// 초기화되기 전에는 사용할 수 없음 
// console.log(y);
let y = 10;
if (true) {
    let y = 99;
}
// 10이 출력 됨 
console.log(y);

// console로 출력할 때 node를 하기 위한 값으로 파일 명.js로 붙여서 실행함 