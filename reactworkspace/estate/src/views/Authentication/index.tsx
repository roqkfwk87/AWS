import React, { ChangeEvent, useState } from 'react'
import './style.css';

import SignInBackground from 'assets/image/sign-in-background.png';
import SignUpBackground from 'assets/image/sign-up-background.png';
import InputBox from 'components/Inputbox/Index';

//                    type                    //
type AuthPage = 'sign-in' | 'sign-up';

//                    interface                    //
interface SnsContainerProps {
  title: string;
}

//                    component                    //
function SnsContainer({title}: SnsContainerProps) {

  //                    event handler                    //
  // kako, naver를 포함
  const onSnsButtonClickHandler = (type: 'kakao' | 'naver') => {
    alert(type);
  };

   //                    render                    //
  return (
  <div className='authentication-sns-container'>
    <div className='sns-container-title label'>{title}</div>
    <div className='sns-button-container'>
      {/* 매개변수를 받아오지 않겠다, snsbutton구분을 위해 각각 지정해줌 */}
      <div className='sns-button kakao-button' onClick={() => onSnsButtonClickHandler('kakao')}></div>
      <div className='sns-button naver-button' onClick={() =>onSnsButtonClickHandler('naver')}></div>
    </div>
  </div>
  );

}

//                    interface                    //
interface Props {
  // 함수의 타입을 정할 때는 =>을 사용 (공식? 보기)
  // 함수의 반환타입이 없는 상태 void
  onLinkClickHandler: () =>  void
}

//                    component                    //
function SignIn({ onLinkClickHandler }: Props) {

   //                    state                    //
  const [id, setId] = useState<string>('');
  const [password, setPassword] = useState<string>('');

  const [message, setMessage] = useState<string>('');

   //                    event handler                    //
  const onIdChangeHandler= (event: ChangeEvent<HTMLInputElement>) => {
    setId(event.target.value);
    setMessage('');
  };

  const onPasswordChangeHandler= (event: ChangeEvent<HTMLInputElement>) => {
    setPassword(event.target.value);
    setMessage('');
  };

  const onSignInButtonClickHandler = () => {
    const ID = 'service123';
    const PASSWORD = 'qwer1234'

    const isSuccess = id === ID && password === PASSWORD;
    if (isSuccess) {
      setId('');
      setPassword('');
      alert('로그인 성공');
    }
    else {
      setMessage('로그인 정보가 일치하지 않습니다.');
    }

  };

  //                    render                    //
  return(
    <div className='authentication-contents'>
      <div className='authentication-input-container'>
        <InputBox label='아이디' type='text' value={id} placeholder='아이디를 입력해주세요' onChangeHandler={onIdChangeHandler} />

        <InputBox label='비밀번호' type='password' value={password} placeholder='비밀번호를 입력해주세요' onChangeHandler={onPasswordChangeHandler} message={message} error/>
      </div>
      <div className='authentication-button-container'>
        <div className='primary-button full-width' onClick={onSignInButtonClickHandler}>로그인</div>
        {/* 회원가입을 눌렀을 때 onLinkClickHandler이 실행되야 함 */}
        <div id="sign-up-link" className="text-link" onClick={onLinkClickHandler}>회원가입</div>
      </div>
      <div className='short-divider'></div>
      <SnsContainer title="SNS 로그인" />
    </div>
  );
}

//                    component                    //
// SingIn / SignUp은 배치 순서의 차이 
function SignUp({onLinkClickHandler}: Props) {
  
//                    state                    //
  const [id, setId] = useState<string>('');
  const [password, setPassword] = useState<string>('');
  const [passwordCheck, setPasswordCheck] = useState<string>('');
  const [email, setEmail] = useState<string>('');
  const [authNumber, setAuthNumber] = useState<string>('');

  const [idButtonStatus, setIdButtonStatus] = useState<boolean>(false);
  const [emailButtonStatus, setEmailButtonStatus] = useState<boolean>(false);
  const [authNumberButtonStatus, setAutnNumberuttonStatus] = useState<boolean>(false);

  const [isIdCheck, setIdCheck] = useState<boolean>(false);
  const [isPasswordPattern, setPasswordPattern] = useState<boolean>(false);
  const [isEqualPassword, setEqualPassword] = useState<boolean>(false);
  const [isEmailCheck, setEmailCheck] = useState<boolean>(false);
  const [isAuthNumberCheck, setAuthNumberCheck] = useState<boolean>(false);

  const [idMessage, setIdMessage] = useState<string>('');
  const [passwordMessage, setpasswordMessage] = useState<string>('');
  const [passwordCheckMessage, setpasswordCheckMessage] = useState<string>('');
  const [emailMessage, setemailMessage] = useState<string>('');
  const [authNumberMessage, setauthNumberMessage] = useState<string>('');

  const [isIdError, setIdError] = useState<boolean>(false);
  const [isEmailError, setEmailError] = useState<boolean>(false);
  const [isAuthNumberError, setAuthNumberError] = useState<boolean>(false);

  const isSignUpActive = isIdCheck && isEmailCheck && isAuthNumberCheck && password && passwordCheck && isPasswordPattern && isEqualPassword;
  // primary-button full-width / disable-button full-width
  const signUpButtonClass = isSignUpActive ? 'primary-button full-width' : 'disable-button full-width';
  // 방법2 const signUpButtonClass = (isSignUpActive ? 'primary' : 'disable') + '-button full-width';
  // const signUpButtonClass = `${isSignUpActive ? 'primary' : 'disable'}-button full-width`;

  //                    event handler                    //
  const onIdChangeHandler = (event: ChangeEvent<HTMLInputElement>) => {
    // value를 넣어서 정상적인 작동을 하게 함 
    const {value} = event.target;
    // 이 상태는(빈칸으로 인해) 한 칸씩 밀리는 상황 (setId(event.target.value), id!=='' 상태)
    setId(value);
    setIdButtonStatus(value !== '');
    setIdCheck(false);
    setIdMessage('');
  };

  const onPasswordChangeHandler = (event: ChangeEvent<HTMLInputElement>) => {
    const {value} = event.target;
    setPassword(value);

    const passwordPattern = /^(?=.*[a-zA-Z])(?=.*[0-9]).{8,13}$/;
    const isPasswordPattern = passwordPattern.test(value);
    setPasswordPattern(isPasswordPattern);

    const passwordMessage = isPasswordPattern ? '' : value ? '영문, 숫자를 혼용하여 8 ~ 13자 입력해주세요.' : '';
    setpasswordMessage(passwordMessage);

    const isEqualPassword = passwordCheck === value;
    setEqualPassword(isEqualPassword);

    const passwordCheckMessage = isEqualPassword ? '' : passwordCheck?  '비밀번호가 일치하지 않습니다.' : '';
    setpasswordCheckMessage(passwordCheckMessage);
  };


  // 비밀번호 확인
  const onPasswordCheckChangeHandler = (event: ChangeEvent<HTMLInputElement>) => {
    const { value } = event.target;
    setPasswordCheck(value);

    const isEqualPassword = password === value;
    setEqualPassword(isEqualPassword);

    const passwordCheckMessage = 
        isEqualPassword ? '' : 
        value ? '비밀번호가 일치하지 않습니다.' : '';
    setpasswordCheckMessage(passwordCheckMessage);
  };


  const onEmailChangeHandler = (event: ChangeEvent<HTMLInputElement>) => {
    const {value} = event.target;
    setEmail(value);
    setEmailButtonStatus(value !== '');
    setEmailCheck(false);
    setemailMessage('');
  };

  const onAuthNumberChangeHandler = (event: ChangeEvent<HTMLInputElement>) => {
    const {value} = event.target;
    setAuthNumber(value);
    setAutnNumberuttonStatus(value !== '');
    setAuthNumberCheck(false);
    setauthNumberMessage('');
  };

  const onIdButtonClickHandler = () => {
    if (!idButtonStatus) return;

    const idCheck =id !== 'admin';
    setIdCheck(idCheck);
    setIdError(!idCheck);

    const idMessage = idCheck ? '사용 가능한 아이디입니다.' : '이미 사용중인 아이디입니다.';
    setIdMessage(idMessage);
  };

  const onEmailButtonClickHandler = () => {
    if (!emailButtonStatus) return;

    const emailPattern = /^[a-zA-Z0-9]*@([-.]?[a-zA-Z0-9])*\.[a-zA-Z]{2,4}$/;
    const isEmailPattern = emailPattern.test(email);
    setEmailCheck(isEmailPattern);
    setEmailError(!isEmailPattern);

    const emailMessage = isEmailPattern ? '인증번호가 전송 되었습니다.' : '이메일 형식이 아닙니다.';
    setemailMessage(emailMessage);
  };


  const onAuthNumberButtonClickHandler = () => {
    if (!authNumberButtonStatus) return;
    const authNumberCheck = authNumber === '1234'; 
    setAuthNumberCheck(authNumberCheck)
    setAuthNumberError(!authNumberCheck);

    const authNumberMessage = authNumberCheck ? '인증번호가 확인되었습니다.' : '인증번호가 일치하지 않습니다.';
    setauthNumberMessage(authNumberMessage);

  };

  // 회원가입 버튼 
  const onSignUpButtonClickHandler = () => {
    if (!isSignUpActive) return;
      alert('회원가입');
  };


  //                    render                    //
  return(
    <div className='authentication-contents'>
      <SnsContainer title="SNS 회원가입" />
      <div className='short-divider'></div>
      <div className='authentication-input-container'>

        <InputBox label='아이디' type='text' value={id} placeholder='아이디를 입력해주세요' onChangeHandler={onIdChangeHandler} 
        buttonTitle='중복확인' buttonStatus={idButtonStatus} onButtonClickHandler={onIdButtonClickHandler}  message={idMessage} error={isIdError} />
        
        <InputBox label='비밀번호' type='password' value={password} placeholder='비밀번호를 입력해주세요' 
        onChangeHandler={onPasswordChangeHandler} message={passwordMessage} error />
        
        <InputBox label='비밀번호 확인' type='password' value={passwordCheck} placeholder='비밀번호를 입력해주세요' 
        onChangeHandler={onPasswordCheckChangeHandler} message={passwordCheckMessage} error />
        
        <InputBox label='이메일' type='text' value={email} placeholder='이메일을 입력해주세요' onChangeHandler={onEmailChangeHandler} 
        buttonTitle='이메일 인증' buttonStatus={emailButtonStatus} onButtonClickHandler={onEmailButtonClickHandler} message={emailMessage} error={isEmailError}/>
        
        {
        isEmailCheck && 
        <InputBox label='인증번호' type='text' value={authNumber} placeholder='인증번호 4자리를 입력해주세요' onChangeHandler={onAuthNumberChangeHandler} 
        buttonTitle='인증 확인' buttonStatus={authNumberButtonStatus} onButtonClickHandler={onAuthNumberButtonClickHandler} message={authNumberMessage} error={isAuthNumberError} />
        }
      </div>
      <div className='authentication-button-container'>
        <div className={signUpButtonClass} onClick={onSignUpButtonClickHandler}>회원가입</div>
        <div id="sign-up-link" className="text-link" onClick={onLinkClickHandler}>로그인</div>
      </div>
    </div>
  );
}

//                    component                    //
// Authentication 여기에서 소문자가 되면 인식을 못함
// Authentication 안에 onSignInButtonClickHandler를 선언하면 매개변수를 선언해주지 않고도 사용할 수 있음 (단, 코드 두번 선언과 복잡성 때문에 밖에다가 선언해두는 것이 좋다.)
export default function Authentication() {

  //                    state                    //
  // 외부에 선언시 동작을 할 수 없음 (use가 붙은 함수를 훅함수라 하는데 반드시 컴포넌트 바로 밑에 있어야 함)
  const [page, setPage] = useState<AuthPage>('sign-in');

   //                    event handler                    //
  // () => 매개변수 비어있는 상태
  const onLinkClickHandler = () => {
    // page상태가 sign-in이면 상태를 sign-up으로 바꿀 것이다.
    if (page === 'sign-in') setPage('sign-up');
    else setPage('sign-in');
  }

  //                    constant                    //
  // page == sign-in이면 signIn을 내보내고 있는 상태
  const AuthenticationContents = page == 'sign-in' ? <SignIn onLinkClickHandler={onLinkClickHandler} /> : <SignUp onLinkClickHandler={onLinkClickHandler} />

  // signIn, signUp 이미지 삼항연산자로 지정해 줌
  const imageBoxStyle = { backgroundImage: `url(${page === 'sign-in' ? SignInBackground : SignUpBackground})` };
  
   //                    render                    //
  return( 
    <div id="authentication-wrapper">
      {/* 위에서 지정한 삼항연산자를 style={}안에 넣어줌 */}
      <div className="authentication-image-box" style={ imageBoxStyle }></div>
      <div className='authentication-box'>
        <div className='authentication-container'>
          <div className='authentication-title h1'>{'임대 주택 가격 서비스'}
          </div>
          {AuthenticationContents}
        </div>
      </div>
  </div>
  );
}

