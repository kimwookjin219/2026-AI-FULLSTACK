// sagas/authSaga.js
import { all, call, put, takeLatest} from  'redux-saga/effects';
import  axios  from  'axios';
import {signupRequest , signupSuccess , signupFailure, resetUserState,
             loginRequest, loginSuccess, loginFailure,
             logoutRequest, logoutSuccess, logoutFailure,
             updateNicknameRequest, updateNicknameSuccess, updateNicknameFailure,
             updateProfileImageRequest, updateProfileImageSuccess, updateProfileImageFailure
} from '../reducers/authReducer';

const USER_API_BASE = 'http://localhost:8080/auth';

// ---  회원가입  POST  /api/users ---
// POST : http://localhost:8080/auth/signup
export  const  signupApi = ( formData )=> axios.post(  `${USER_API_BASE}/signup` , formData , {
    headers: {"Content-Type": "multipart/form-data"}
}  ); // /api/users
//■2.  signup(action) - action.payload 사용자가 입력한 값 (회원정보)
export  function*   signup(action){
    // action = { type: auth/signupRequest, payload: { email:'1@1' , password:'1'} }
    try{
        const result = yield  call( signupApi,  action.payload  );  //■3.  result.data
        yield  put(signupSuccess(result.data)); // 처리결과 put
    }catch(err){
        yield  put(signupFailure(err.response?.data?.message || err.message));
    }
}

// ---  로그인  ---
// POST : /auth/login
export  const  loginApi = ( payload )=> axios.post( `${USER_API_BASE}/login`,payload );
//■2) 
export function*  login( action ){
    // {email: '1@1', password: '1', provider: 'local'} - action.payload
    // action = {type:user/fetchUserRequest , payload:1}
    try{
        const result = yield call(loginApi , action.payload);  //■3) 
        yield put(  loginSuccess( result.data ) );
    }catch(err){
        yield put(  loginFailure( err.response?.data?.message || err.message ) );
    }
}

// ---  로그아웃  ---
// POST : /auth/logout     넘겨줄 데이터 X
export  const  logoutApi = (  )=> axios.post( `${USER_API_BASE}/logout` );
//■2) 
export function*  logout(  ){
    // {email: '1@1', password: '1', provider: 'local'} - action.payload
    // action = {type:user/fetchUserRequest , payload:1}
    try{
        yield call(logoutApi);  //■3) 
        yield put(  logoutSuccess( ) );
    }catch(err){
        yield put(  logoutFailure( err.response?.data?.message || err.message ) );
    }
}

// ---  닉네임 수정  ---
// PATCH : /auth/{userId}/nickname      , params를 통해서 닉네임 넘기기
export  const  updateNicknameApi = ( {userId, nickname} )=> axios.patch( `${USER_API_BASE}/${userid}/nickname`,null,{
    params:{nickname},
} );
//■2) 
export function*  updateNickname( action ){
    // {email: '1@1', password: '1', provider: 'local'} - action.payload
    // action = {type:user/fetchUserRequest , payload:1}
    try{
        const result = yield call(updateNicknameApi , action.payload);  //■3) 
        yield put(  updateNicknameSuccess( result.data ) );
    }catch(err){
        yield put(  updateNicknameFailure( err.response?.data?.message || err.message ) );
    }
}

// ---  프로필 이미지 수정  ---
// PATCH : /auth/{userId}/profile-image , formData
export  function  updateProfileImageApi( {userId, file} ){ 

    const formData = new FormData();
    formData.append("ufile",file);

    return axios.patch( `${USER_API_BASE}/${userid}/profile-image`,formData,{
           headers:{"Content_Type":"multipart/form-data"}
        });

}
//■2) 
export function*  updateProfileImage( action ){
    // {email: '1@1', password: '1', provider: 'local'} - action.payload
    // action = {type:user/fetchUserRequest , payload:1}
    try{
        const result = yield call(updateProfileImageApi , action.payload);  //■3)  
        yield put(  updateProfileImageSuccess( result.data ) );
    }catch(err){
        yield put(  updateProfileImageFailure( err.response?.data?.message || err.message ) );
    }
}

//■1.takeLatest( signupRequest.type , signup) :  takeLatest - 요청이 여러번, 가장마지막발생요청 처리
//■1) takeLatest : 여러번요청와도 1번만
function* watchSignup(){               yield  takeLatest( signupRequest.type             , signup);  } 
function* watchLogin(){                yield  takeLatest( loginRequest.type              , login );   }
function* watchLogout(){               yield  takeLatest( logoutRequest.type             , logout );   }
function* watchUpdateNickname(){       yield  takeLatest( updateNicknameRequest.type     , updateNickname );   }
function* watchUpdateProfileImage(){   yield  takeLatest( updateProfileImageRequest.type , updateProfileImage );   }

export default  function * authSaga(){
    yield all([
        call(watchSignup),
        call(watchLogin),
        call(watchLogout),
        call(watchUpdateNickname),
        call(watchUpdateProfileImage),
    ]);
}
 
