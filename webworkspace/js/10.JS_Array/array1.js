/*
    배열 : 여러 데이터를 하나의 변수로 저장할 때 사용 
*/

/*
    배열 리터럴 : 
    - 0개 이상의 값을 쉼표로 구분하여 []로 묶어 표현 
    - 배열[인덱스]로 요소에 접근 가능, 단, 존재하지 않는 인덱스에 접근하면 undefined 반환 
    - 자바스크립트 배열 각 요소의 데이터 타입이 서로 달라도 됨 
*/
const emptyArray = [];
console.log(emptyArray[2]); // undefined (2번 인덱스가 존재하지 않음)

const numbers = [1, 2, 3, 4, '5'];
console.log(numbers); // [ 1, 2, 3, 4, '5' ]

const funcs = [
    function () {console.log('함수1')},
    function () {console.log('함수2')}
];
console.log(funcs); // [ [Function (anonymous)], [Function (anonymous)] ]
// 0번째 인덱스에 있는 함수를 호출하겠다.
funcs[0](); // 함수1

console.log('==============================');

/*
    배열의 요소 추가
    - 배열[인덱스] = 값:요소 추가 가능, 순서를 생각할 필요는 없음 
    - 뛰어 넘은 인덱스의 값에는 empty item이 추가됨 
*/
const emptyArray2 = [];
emptyArray2[2] = 10;

console.log(emptyArray2[0]); // undefined
// 0, 1은 값이 없어 2개의 empty items가 출력되고 2번 인덱스의 10의 값이 있기 때문에 10이 출력됨 
console.log(emptyArray2); // [ <2 empty items>, 10 ]

console.log('==============================');

/*
    배열의 요소 삭제
    - delete 연산자를 사용하여 제거 가능 
*/
// 2번 인덱스를 삭제
delete emptyArray2[2];
// 인덱스의 값이 없기 때문에 3개의 empty items로 출력됨 
console.log(emptyArray2); // [ <3 empty items> ]

console.log('==============================');

/*
    배열의 순회
    - for-in 문을 사용하여 index 값을 가지고 순회 가능 
*/
const fruits = ['apple', 'banana', 'melon'];
// 일반 for문
for (let index = 0; index < fruits.length; index++) {
    console.log(fruits[index]); // apple banana melon
}

// for-in문을 사용 
// 실행이 끝나면 const index가 사라지고 다시 반복할 때 const index가 생성됨
for (const index in fruits) {
    // item 값을 변경하는 작업에는 in이 적합함 
    console.log(fruits[index]); // apple banana melon
}

console.log('==============================');

/*
    - for-in 순회 방식은 index를 사용하여 한번 더 작업해야 하기 때문에 요소를 읽어들이는 순회에는 적합하지 않을 수 있음 
    - forEach 메서드 혹은 for-of 문을 사용
*/
for (const item of fruits) {
    // item 값이 들어옴 
    console.log(item); // apple banana melon
}

fruits.forEach(function (item, index) {
    console.log(`index:${index}, item:${item}`); // index:0, item:apple index:1, item:banana index:2, item:melon
});

console.log('==============================');

/*
    배열의 길이 : 배열.length
*/


console.log('==============================');

/*
    배열 메서드
*/

/*
    indexOf(element) : 
    - 배열에서 매개변수로 전달된 요소를 검색하여 해당 인덱스를 반환
    - 배열에 요소가 존재하지 않으면 -1을 반환 
*/
console.log(fruits.indexOf('banana')); // 1 (1번 인덱스에 존재)
console.log(fruits.indexOf('orange')); // -1 (존재하지 않기 때문)

console.log('==============================');

/*
    includes(element) : 
    - 배열에 매개변수로 전달된 요소가 존재하면 true, 존재하지 않으면 false를 반환 
*/
console.log(fruits.includes('banana')); // true
console.log(fruits.includes('orange')); // false

console.log('==============================');

/*
    push(element) : 
    - 배열의 마지막 인덱스에 요소를 추가하고 변경된 길이를 반환 
*/
console.log(fruits, fruits.length) // [ 'apple', 'banana', 'melon' ] 3
console.log(fruits.push('orange')); // 4
console.log(fruits) // [ 'apple', 'banana', 'melon', 'orange' ]

console.log('==============================');

/*
    pop() : 
    - 배열의 마지막 인덱스 요소를 제거하고 제거한 요소를 반환 
*/
console.log(fruits.pop()); // orange
// orange가 삭제되고 출력 
console.log(fruits); // [ 'apple', 'banana', 'melon' ]

console.log('==============================');

/*
    shift() : 
    - 배열의 첫번째 요소를 제거하고 제거한 요소를 반환 
*/
console.log(fruits.shift()); // apple
console.log(fruits); // [ 'banana', 'melon' ]

console.log('==============================');

/*
    reverse() :
    - 배열의 순서를 역전 
*/
// [ 'banana', 'melon' ] 에서 배열의 순서가 바뀜 
console.log(fruits.reverse()); // [ 'melon', 'banana' ]
console.log(fruits); // [ 'melon', 'banana' ]

console.log('==============================');

/*
    concat(array or item) : 
    - 매개변수로 전달된 값들을 해당 배열의 마지막 요소 뒤에 연결하여 새로운 배열을 반환 
*/
const newFruits = fruits.concat(['apple', 'orange']);
// 추가된 형태
console.log(newFruits); // [ 'melon', 'banana', 'apple', 'orange' ]
// 기본형태는 남아 있음 
console.log(fruits); // [ 'melon', 'banana' ]

console.log('==============================');

/*
    slice(start, end) : 
    - start에 해당하는 인덱스부터 end에 해당하는 인덱스 앞까지 복사하여 반환 
*/
// start 1번 banana에서 end orange 앞인 apple이 반환됨 
console.log(newFruits.slice(1, 3)); // [ 'banana', 'apple' ]
console.log(newFruits); // [ 'melon', 'banana', 'apple', 'orange' ]

console.log('==============================');

/*
    splice(start, eleteCount, items...) :
    - 배열의 요소를 제거하고 제거한 위치에 요소를 갈아끼운 배열을 반환 
*/
// console.log(newFruits.splice(2, 1)); // [ 'apple' ]
// console.log(newFruits); // [ 'melon', 'banana', 'orange' ]
console.log(newFruits.splice(2, 1, 'peach')); // [ 'apple' ]
// apple이 반환이 되고 이 위치에 peach가 들어옴 
console.log(newFruits); // [ 'melon', 'banana', 'peach', 'orange' ]

// 원본 배열의 영향을 미치는 함수가 있고 그렇지 않은 함수가 있음
// 배열의 순서를 역전시키는 함수는 원본 배열의 영향을 미침 
