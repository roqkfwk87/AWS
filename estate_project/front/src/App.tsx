import React from 'react';
import './App.css';
import { Route, Routes } from 'react-router';
import { AUTH_PATH, LOCAL_PATH, QNA_DETAIL_PATH, QNA_PATH, QNA_UPDATE_PATH, QNA_WRITE_PATH, RATIO_PATH, SERVICE_PATH } from './constant';
import Authentication from './views/Authentication';
import ServiceContainer from './views/NotFound';
import Local from './layouts/ServiceContainer';
import Ratio from './views/service/Ratio';
import QnaList from './views/service/qna/QnaList';
import QnaWrite from './views/service/qna/QnaWrite';
import QnaDetail from './views/service/qna/QnaDetail';
import QnaUpdate from './views/service/qna/QnaUpdate';
import NotFound from './views/NotFound';

function App() {
  return (
    <Routes>
      <Route path={AUTH_PATH} element={<Authentication />} />
      <Route path={SERVICE_PATH} element={<ServiceContainer />}>
        <Route path={LOCAL_PATH} element={<Local />} />
        <Route path={RATIO_PATH} element={<Ratio />} />
        <Route path={QNA_PATH} >
          <Route index element={<QnaList />} />
          {/* write : 지정되어 있는 상태이기에 가장 먼저 적어줌 */}
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