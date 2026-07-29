// reducers/authReducer.js
import {createSlice} from "@reduxjs/toolkit";

//1. 초기화 상태 (공용)
const initialState={
    user: null ,     // 단건 조회된 사용자 정보
    loading: false , // 로딩상태
    error: null ,    // 에러메세지
    success: false , // 성공여부
};

//2. 상태변화
const authReducer=createSlice({
    name: "user" ,
    initialState ,
    reducers: {
        // --- 회원가입 ---
        signupRequest : (state)=>{
            state.loading = true; // 로딩상태
            state.error = null;    // 에러메세지
            state.success = false; // 성공여부 
        },
        signupSuccess : (state, action)=>{
            state.loading = false; // 로딩상태
            state.user    = action.payload; // 가입된 회원정보 저장
            state.success = true; // 성공여부 
        },
        signupFailure : (state, action)=>{
            state.loading = false; // 로딩상태
            state.error   = action.payload; // 오류 메세지
            state.success = false; // 성공여부 
        },

        // --- 사용자 단건조회 ---
        fetchUserRequest : (state)=>{
            state.loading = true; // 로딩상태
            state.error = null;    // 에러메세지
            state.success = false; // 성공여부
        },
        fetchUserSuccess : (state, action)=>{
            state.loading = false; // 로딩상태
            state.user = action.payload;    // 에러메세지
            state.success = true; // 성공여부
        },
        fetchUserFailure : (state, action)=>{
            state.loading = false; // 로딩상태
            state.error = action.payload;    // 에러메세지
            state.success = false; // 성공여부
        },

        // --- 상태 초기화 ---
        resetUserState: (state)=>{
            state.loading = false; // 로딩상태
            state.error = null;    // 에러메세지
            state.success = false; // 성공여부
        },
    },
});
//3. action
export const {signupRequest, signupSuccess, signupFailure,
              fetchUserRequest, fetchUserSuccess, fetchUserFailure,
              resetUserState,
} = authReducer.actions;

//4. export
export default authReducer.reducer;