import React, { useEffect } from 'react';
import './App.css';
import { Route, Routes, useNavigate } from 'react-router';
import { AUTH_ABSOLUTE_PATH, AUTH_PATH, LOCAL_ABSOLUTE_PATH, LOCAL_PATH, QNA_DETAIL_PATH, QNA_PATH, QNA_UPDATE_PATH, QNA_WRITE_PATH, RATIO_PATH, SERVICE_PATH } from './constant';
import Authentication from './views/Authentication';
import ServiceContainer from './views/NotFound';
import Local from './layouts/ServiceContainer';
import Ratio from './views/service/Ratio';
import QnaList from './views/service/qna/QnaList';
import QnaWrite from './views/service/qna/QnaWrite';
import QnaDetail from './views/service/qna/QnaDetail';
import QnaUpdate from './views/service/qna/QnaUpdate';
import NotFound from './views/NotFound';
import { useCookies } from 'react-cookie';

// component: root 경로 컴포넌트 // 
function Index () {

  //          state               //
  // cookie 등록?
  const [cookies] = useCookies();
  
  //          function               //
  const navigator = useNavigate();

  //          effect              //
  useEffect(() => {
    const accessToken = cookies.accessToken;
    // 로그인이 되어 있는 상태
    if (accessToken) navigator(LOCAL_ABSOLUTE_PATH);
    // 로그인이 되어 있지 않은 상태
    else navigator(AUTH_ABSOLUTE_PATH);
  }, []);

  //          render               //
  return <></>;
}

// component: Application 컴포넌트
function App() {

  //   render   //
  return (
    <Routes>
      <Route index element={<Index />} />
      <Route path={AUTH_PATH} element={<Authentication />} />
      <Route path={SERVICE_PATH} element={<ServiceContainer />}>
        <Route path={LOCAL_PATH} element={<Local />} />
        <Route path={RATIO_PATH} element={<Ratio />} />
        <Route path={QNA_PATH} >
          <Route index element={<QnaList />} />
          <Route path={QNA_WRITE_PATH} element={<QnaWrite />} />
          <Route path={QNA_DETAIL_PATH} element={<QnaDetail />} />
          <Route path={QNA_UPDATE_PATH} element={<QnaUpdate />} />
        </Route>
      </Route>
      <Route path='*' element={<NotFound />} />
    </Routes>
  );
}


export default App;

// 폴더 구조 
// - authentication (로그인, 회원가입)
// - service 
//     - locale (지역 평균)
//     - ratio (비율 계산)
//     - qna (QnA 리스트)
//         - :boardNumber (QnA 상세보기)
//         - write (QnA 작성) -> 지정이 되어 있는 상태를 가장 먼저 적어둠
//         - update/:boardNumber (QnA 수정)

// postman 주소
// localhost:3000/service/qna/1
// localhost:3000/service/qna/2

// -> boardNumber로 읽을 것이나 write로 읽은 것이냐에 대한 문제가 생김 
// localhost:3000/service/qna/write