import React from 'react'

// 리스트 렌더링 : 
// - JSX 내부에서 반복적으로 렌더링하는 요소에 대해 반복 처리 
// - JSX 안에서는 for 혹은 while과 같은 반복문을 사용할 수 없음
// - 리스트의 각종 메서드를 활용 

interface Human {
    name : string;
    age : number;
    job : string;
}

function ListItem ({name, age, job} : Human) {
    
    return (
        <div>
            <h1>이름 : {name}</h1>
            <h4>나이 : {age}</h4>
            <h4>직업 : {job}</h4>
        </div>
    )
}

export default function ListRendering() {

    const humans: Human[] = [
        // name="홍길동" age={20} job="학생"를 하나로 표현 시켜주기 위해서는 객체로 표현 함 
        {name: '홍길동', age: 20, job: '학생'}, 
        {name: '김철수', age: 30, job: '개발자'}, 
        {name: '이영희', age: 27, job: '경찰'}, 
        {name: '김민수', age: 12, job: '학생'}
    ];

    const students = humans.filter(item => item.job === '학생');

    {/* {humans.map((item, index) => {
        return <ListItem name={item.name} age={item.age} job={item.job} />
    })}; => void, undefined */}

    {/* {humans.map((item, index) => {
        return <ListItem name={item.name} age={item.age} job={item.job} />
    })}; => [ListItem, ListItem, ListItem, ListItem] */}

    // - JSX에 리스트 고급 함수를 사용할 때 결과를 반환하는 함수를 사용해야 함
    // - forEach X -> map O
    // - 특정 조건에 해당하는 요소만 출력하고 싶으면 filter 메서드를 응용해서 사용 

    // - 완전 단순한 반복(횟수 반복)을 사용할 땐 반복하고자하는 횟수의 길이를 가지는 배열을 생성해서 해당 배열로 반복작업 
    
    // 길이가 3개인 배열
    const count = new Array(3).fill(0);
    return (
        <>
            {/* 배열을 JSX에 반환하면 배열의 각 요소를 하나씩 꺼내와서 렌더링 */}
            {/* {['요소1', '요소2', '요소3']} */}

            {/* const humans로 표현해둠 */}
            {/* <ListItem name="홍길동" age={20} job="학생" />
            <ListItem name="김철수" age={30} job="개발자" />
            <ListItem name="이영희" age={27} job="경찰" />
            <ListItem name="김민수" age={12} job="학생" /> */}

            {humans.map((item, index) => {
                // return <ListItem name={item.name} age={item.age} job={item.job}/> 아래와 같은 의미 
                return <ListItem key={index} {...item} /> 
            })}

            {/* index, {return} {} 삭제 가능 */}
            {humans.map((item) => <ListItem key={item.name} {...item} />)}
            {/* 직업이 학생인 값만 반환하기 때문에 홍길동과 김민수만 출력 */}
            {students.map((item) => <ListItem key={item.name} {...item} />)}
            {count.map(item => <h1 key={item}>반복 아이템</h1>)}

        </>
    );
}

// forEach - for문 대신에 사용, 결과값을 반환하지 않음 