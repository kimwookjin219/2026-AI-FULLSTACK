// reducers/authReducer.js
import { createSlice }  from "@reduxjs/toolkit";

//1. 초기화 상태 (공용)
const initialState={
    user: null ,     // 단건 조회된 사용자 정보
    accessToken: null, // ####
    loading: false,  // 로딩상태   
    error:   null,   // 에러메시지
    success: false,  // 성공여부 (insert 할때 - 회원가입 할때) 
};

//2. 상태변화
const authReducer=createSlice({
    name : "auth",
    initialState , 
    reducers : {
        // --- 회원 가입 ---
        signupRequest : (state)=>{
            state.loading = true;  
            state.error   = null;   
            state.success = false;  
        },

        signupSuccess : (state, action)=>{ 
            state.loading = false;  
            //state.user    = action.payload;  //가입된 회원정보저장 
            state.success = true;  
        },
        signupFailure : (state, action)=>{
            state.loading = false;  
            state.error   = action.payload;  // 오류메시지
           // state.success = false;  
        },

        // --- 상태 초기화 ---
        resetUserState: (state)=>{
            state.loading = false;  
            state.error   = null;   
            state.success = false;  
        } , 

        // --- 로그인 ( JWT 기반 user 정보 관리 ) ---
        loginRequest : (state)=>{
            state.loading = true;
            state.error   = null;
        },
        loginSuccess : (state,action)=>{
            state.loading = false;
            state.user    = action.payload.user || null; // #### Map<String, Object> key   - .user로 수정
            state.accessToken = action.payload.accessToken || null; // #### Map<String, Object> key - . accessToken
            // boot에서 넘겨주는 값
            //  return ResponseEntity.ok(Map.of(
            //      "accessToken", accessToken,
            //      "user", user
            // ));
        },
        loginFailure : (state,action)=>{
            state.loading = false;
            state.error   = action.payload;
            state.user    = null;
        },
        // --- 토큰 재발급 ResponseEntity<Map<String, Object>> ---
        refreshTokenRequest : (state)=>{
            state.loading = true;
            
        },
        refreshTokenSuccess : (state,action)=>{
            state.loading = false;
            state.accessToken = action.payload?.accessToken || null;
        },
        refreshTokenFailure : (state,action)=>{
            state.loading = false;
            state.error = action.payload.error;
        },

        // --- 로그아웃 ---
        logoutRequest : (state)=>{
            state.loading = true;
            //state.error   = null;
        },
        logoutSuccess : (state)=>{
            state.loading = false;
            state.error   = null;
            state.user    = null;
            state.accessToken = null; // ####
            state.success = false;
        },
        logoutFailure : (state,action)=>{
            state.loading = false;
            state.error   = action.payload;
        },

        // --- 닉네임 변경 ---
        updateNicknameRequest : (state)=>{
            state.loading = true;
            //state.error   = null;
        },
        updateNicknameSuccess : (state,action)=>{
            state.loading = false;
            state.user    = action.payload;
            state.success = true;
        },
        updateNicknameFailure : (state,action)=>{
            state.loading = false;
            state.error   = action.payload;
        },
        
        // --- 프로필 이미지 변경 ---
        updateProfileImageRequest : (state)=>{
            state.loading = true;
            //state.error   = null;
        },
        updateProfileImageSuccess : (state,action)=>{
            state.loading = false;
            state.user    = action.payload || null;
        },
        updateProfileImageFailure : (state,action)=>{
            state.loading = false;
            state.error   = action.payload;
        },
        // --- 유저추가(마이페이지) ResponseEntity<UserResponseDto> ---
        loadUserRequest:(state)=>{
            state.loading = true;
        },
        loadUserSuccess:(state,action)=>{
            state.loading = false;
            state.user = action.payload || null;
        },
        loadUserFailure:(state,action)=>{
            state.loading = false;
            state.error = action.payload;
            state.user = null; // 추가 해주면 좋음 (유저 초기화)
        },

    },
});
//3.  action
export const {signupRequest , signupSuccess , signupFailure, resetUserState,
             loginRequest, loginSuccess, loginFailure,
             refreshTokenRequest, refreshTokenSuccess, refreshTokenFailure,
             logoutRequest, logoutSuccess, logoutFailure,
             updateNicknameRequest, updateNicknameSuccess, updateNicknameFailure,
             updateProfileImageRequest, updateProfileImageSuccess, updateProfileImageFailure,
             loadUserRequest, loadUserSuccess, loadUserFailure
} = authReducer.actions;
//4.  export
export default  authReducer.reducer;