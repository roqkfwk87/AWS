/*
    제너릭 : 
    - 선언 시점이 아니라 컴파일 시점에 타입을 명시하여 하나의 타입이 아닌 여러 타입을 사용할 수 있도록 하는 기법
    - 코드 안전성, 재사용성을 높일 수 있음 
*/

interface Person<T> {
    name: string;
// any로 찍을시 모든 데이터를 가질 수 있음
    data: T;
}

const person: Person<string> = {
    name: '홍길동',
    data: '김철수'
}

// data의 타입을 string
person.data;

const func = <T>(name: string, data:T) => {
    const result: Person<T> = {name, data};
    return result;
}

const person1 = func('김철수', '홍길동');
const person2 = func('이영희', 20);

// any로 지정시 data의 타입은 any (지정할 의미가 없다)
person2.data


console.log('==================================================');