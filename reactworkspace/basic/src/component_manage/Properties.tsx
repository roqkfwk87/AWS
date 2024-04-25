import React from "react";

// Properties (속성)
// - 부모 컴포넌트(호출부)에서 자식 컴포넌트로  데이터를 전달하기 위한 *객체*
// - 부모 컴포넌트에서는 HTML과 동일한 방식 (속성명=데이터)로 전달
// - 자식 컴포넌트에서는 JS의 매개변수 방식으로 받음
// - 전달할 수 있는 데이터는 JS로 표현할 수 있는 모든 형태
// - 컴포넌트가 리렌더링되는 기준
// - Properties 부모 요소에서 자식 요소로 데이터 전송 O / 자식 요소에서 부모 요소로 데이터 전송 X

interface Props {
    title: string;
    content: string;
    // 물음표를 추가하면 적어도 되고 안 적어도 됨 (단, ?없을시 변수를 지정해뒀기에 쓰지 않으면 에러남)
    nickname?: string;
}

function Child({ title, content, nickname='비공개' }: Props) {

    // 자식요소에서 이렇게 키와 값이 생김 
    // props = {
    //     title: '제목1',
    //     content: '내용1'
    // }

    // const title = props.title;
    // const content = props.content;

    // props: Props에서 키값이다.
    // const {title, content} = props;

    return(
        <div>
            {/* props:Props인 상태였을 때는 props.title처럼 작성함 */}
            <h1>{title}</h1>
            <h4>{nickname}</h4>
            <p>{content}</p>
        </div>
    )

}

export default function Properties() {

    return (
        // 부모요소에서 title, content를 지정
        <>
        {/* interface에서 지정하지 않은 변수는 에러남 */}
            <Child title='제목1' content='내용1' nickname='로제' />
            <Child title='국제인구 이동' content='보도자료' />
            <Child title='외국인 지역별 통계' content='제가 못찾는 것일까요?' />
        </>
    );
}


