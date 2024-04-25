// 중복확인 코드 
const ID = 'userIdentity';
const PASSWORD = 'P!ssw0rd';
const EMAIL = 'email@email.com';
const AUTH_NUMBER = '1010';

// 아이디, 패쓰워드, 패쓰워드 확인, 이메일, 인증번호 입력
let id = '', password = '', passwordCheck = '', email = '', authNumber = '';
// id는 pattern 검사가 없기 때문에 isDuplicate로만 지정가능
// 이메일과 비밀번호는 Pattern이 존재하기 때문에 각각 지정하여 패턴을 확인함  
// false(같으면 안되는 상황), true(같아야 하는 상황)으로 지정 
let isDuplicate = true, isPasswordPattern = false, isEqualPassword = false, isEmail = false, isDuplicateEmail = true, isEqualAuthNumber = false;

// const(상수지정)
// idInputElement(html id=""를 나타냄)에 document(=html)에서 id="id"를 가져오는 함수(getElementById)를 사용하여'id'를 할당
const idInputElement = document.getElementById('id');
// passwordInputElement(html password=""를 나타냄)에 document(=html)에서 id="password"를 가져오는 함수(getElementById)를 사용하여'password'를 할당
const passwordInputElement = document.getElementById('password');
// passwordCheckInputElement(html password-check=""를 나타냄)에 document(=html)에서 id="password"-check"를 가져오는 함수(getElementById)를 사용하여'password-check'를 할당
const passwordCheckInputElement = document.getElementById('password-check');
// emailInputElement(html email=""를 나타냄)에 document(=html)에서 id="email"를 가져오는 함수(getElementById)를 사용하여'email'를 할당
const emailInputElement = document.getElementById('email');
// authNumberInputElement(html auth-number=""를 나타냄)에 document(=html)에서 id="auth-number"를 가져오는 함수(getElementById)를 사용하여'auth-number'를 할당
const authNumberInputElement = document.getElementById('auth-number');

// checkDuplicateButtonElement(중복확인 버튼)에 html에서 id함수를 사용하여 check-duplication-button를 할당
const checkDuplicateButtonElement = document.getElementById('check-duplication-button');
// checkEmailButtonElement(이메일 인증 버튼)에 html에서 id함수를 사용하여 check-email-button'를 할당
const checkEmailButtonElement = document.getElementById('check-email-button');
// checkAuthNumberButtonElement(인증확인 버튼)에 html에서 id함수를 사용하여 check-auth-number-button를 할당
const checkAuthNumberButtonElement = document.getElementById('check-auth-number-button');

// 
const idMessageElement = document.getElementById('id-message');
const passwordMessageElement = document.getElementById('password-message');
const passwordCheckMessageElement = document.getElementById('password-check-message');
const emailMessageElement = document.getElementById('email-message');
const authNumberMessageElement = document.getElementById('auth-number-message');

const signUpButtonElement = document.getElementById('sign-up-button');
const signInLinkElement = document.getElementById('sign-in-link');

function onIdInputHandler (event) {
    id = event.target.value;
    isDuplicate = true;

    if (id) checkDuplicateButtonElement.className = 'input-primary-button';
    else checkDuplicateButtonElement.className = 'input-disable-button';
}

function onPasswordInputHandler (event) {
    password = event.target.value;

    // 비밀번호 패턴을 정규식으로 영문자와 숫자를 반드시 포함한 상태로 8~13자로 지정
    const passwordReg = /^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{8,13}$/;
    // 비밀번호 변수에 들어있는 값이 비밀번호 패턴과 일치한지 확인
    isPasswordPattern = passwordReg.test(password);

    // 비밀번호 패턴이 일치하지 않을 때

    if (!isPasswordPattern) {
        // passwordMessage 요소의 클래스명을 input-message error로 바꿈
        passwordMessageElement.className = 'input-message error';
        // passwordMessage 요소의 텍스트를 영문, 숫자를 혼용하여 8 ~13자 입력해주세요로 바꿈 
        passwordMessageElement.textContent = '영문, 숫자를 혼용하여 8 ~ 13자 입력해주세요';
        return;
    }
    // 비밀번호 패턴이 일치할 경우에만 아래 코드가 실행 

    // passwordMessage 요소의 클래스명을 input-message로 바꾼다.
    passwordMessageElement.className = 'input-message';
    // passwordMessage 요소의 텍스트를 빈문자열로 바꿈
    passwordMessageElement.textContent = '';
}

function onPasswordCheckInputHandler (event) {
    passwordCheck = event.target.value;

    isEqualPassword = password === passwordCheck;
    if (!isEqualPassword) {
        passwordCheckMessageElement.className = 'input-message error';
        passwordCheckMessageElement.textContent = '비밀번호가 일치하지 않습니다.';
        return;
    }
    passwordCheckMessageElement.className = 'input-message';
    passwordCheckMessageElement.textContent = '';
}

function onEmailInputHandler (event) {
    email = event.target.value;
    isEmail = false;
    isDuplicateEmail = true;

    if (email) checkEmailButtonElement.className = 'input-primary-button';
    else checkEmailButtonElement.className = 'input-disable-button';
}

function onAuthNumberInputHandler (event) {
    authNumber = event.target.value;
    isEqualAuthNumber = false;

    if (authNumber) checkAuthNumberButtonElement.className = 'input-primary-button';
    else checkAuthNumberButtonElement.className = 'input-disable-button';
}

idInputElement.addEventListener('input', function (event) {
    onIdInputHandler(event);
    setSignUpButton();
});

passwordInputElement.addEventListener('input', function (event) {
    onPasswordInputHandler(event);
    setSignUpButton();
});

passwordCheckInputElement.addEventListener('input', function (event) {
    onPasswordCheckInputHandler(event);
    setSignUpButton();
});

emailInputElement.addEventListener('input', function (event) {
    onEmailInputHandler(event);
    setSignUpButton();
});

authNumberInputElement.addEventListener('input', function (event) {
    onAuthNumberInputHandler(event);
    setSignUpButton();
});

function onCheckDuplicateClickHandler (event) {
    if (!id) return;

    isDuplicate = id === ID;
    if (isDuplicate) {
        idMessageElement.className = 'input-message error';
        idMessageElement.textContent = '이미 사용중인 아이디 입니다.';
        return;
    }
    
    idMessageElement.className = 'input-message primary';
    idMessageElement.textContent = '사용 가능한 아이디 입니다.';
}

function onCheckEmailClickHandler (event) {
    if (!email) return;

    const emailReg = /^[a-zA-Z0-9]*@([-.]?[a-zA-Z0-9])*\.[a-zA-Z]{2,4}$/;
    isEmail = emailReg.test(email);
    if (!isEmail) {
        emailMessageElement.className = 'input-message error';
        emailMessageElement.textContent = '이메일 형식이 아닙니다.';
        return;
    }

    isDuplicateEmail = email === EMAIL;
    if (isDuplicateEmail) {
        emailMessageElement.className = 'input-message error';
        emailMessageElement.textContent = '이미 사용중인 이메일 입니다.';
        return;
    }

    emailMessageElement.className = 'input-message primary';
    emailMessageElement.textContent = '인증번호가 전송되었습니다.';

}

function onCheckAuthNumberClickHandler (event) {
    if (!authNumber) return;

    isEqualAuthNumber = authNumber === AUTH_NUMBER;
    if (!isEqualAuthNumber) {
        authNumberMessageElement.className = 'input-message error';
        authNumberMessageElement.textContent = '인증번호가 일치하지 않습니다.';
        return;
    }
    
    authNumberMessageElement.className = 'input-message primary';
    authNumberMessageElement.textContent = '인증번호가 확인되었습니다.';
}

checkDuplicateButtonElement.addEventListener('click', function (event) {
    onCheckDuplicateClickHandler(event);
    setSignUpButton();
});
checkEmailButtonElement.addEventListener('click', function (event) {
    onCheckEmailClickHandler(event);
    setSignUpButton();
});
checkAuthNumberButtonElement.addEventListener('click', function (event) {
    onCheckAuthNumberClickHandler(event);
    setSignUpButton();
});

function onSignInLinkClickHandler (event) {
    window.location.href = '../sign-in';
}

signInLinkElement.addEventListener('click', onSignInLinkClickHandler);

function setSignUpButton () {

    const isPrimaryButton = 
        id && password && passwordCheck && email && authNumber && 
        !isDuplicate && isPasswordPattern && isEqualPassword && isEmail && !isDuplicateEmail && isEqualAuthNumber;

    if (isPrimaryButton) signUpButtonElement.className = 'primary-button full-width';
    else signUpButtonElement.className = 'disable-button full-width';

}