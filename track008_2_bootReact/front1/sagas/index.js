// sagas/index.js
import {all,fork} from 'redux-saga/effects';

import authSaga from './authSaga';
import postSaga from './postSaga';
//ex) import commentSaga from './commentSaga';

export default function *rootSaga(){
    yield all([
        fork(authSaga) ,
        fork(postSaga) ,
        //ex) fork(commentSaga) ,
    ]);
}
// fork : 비동기 - 기다리지않음(다른일 할 수 있게 양보)
// call : 기다림(어떠한 일이 끝날때까지 기다리기)