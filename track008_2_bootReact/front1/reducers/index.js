// reducers/index.js
import {combineReducers} from "@reduxjs/toolkit";
import authReducer from './authReducer';
import postReducer from './postReducer';

const rootReducer = combineReducers({
    auth: authReducer ,  // state.auth로 활용가능하게 하는것
    post: postReducer ,  // state.post
});

export default rootReducer;