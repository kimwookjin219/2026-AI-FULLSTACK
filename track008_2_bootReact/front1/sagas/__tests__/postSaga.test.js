// sagas/__tests__/authSaga.test.js
// call - 동기 - 제너레이터함수(function*) 일시 중단 후 결과물 받기 / fork(비동기)
// put - redux(전역상태관리) 액션처리
import { call,put } from 'redux-saga/effects';
import axios from 'axios';

import {fetchPostsRequest, fetchPostsSuccess, fetchPostsFailure,                // 전체글
              fetchPostDetailRequest, fetchPostDetailSuccess, fetchPostDetailFailure, // 상세글
              createPostRequest, createPostSuccess, createPostFailure, // 글쓰기
              updatePostRequest, updatePostSuccess, updatePostFailure, // 글수정
              deletePostRequest, deletePostSuccess, deletePostFailure, // 글삭제
              resetPostState // 초기화
} from '../../reducers/postReducer';

import {fetchPosts, fetchPostDetail, createPost, updatePost, deletePost} from '../postSaga';

jest.mock('axios');

describe('post Saga', ()=>{
    afterEach(()=>{ jest.clearAllMocks() }); // afterEach - 
    // --- 전체 게시글 조회 ---
    it('fetchPosts Success',()=>{
        //1. 화면 요청
        const generator = fetchPosts(fetchPostsRequest());
        expect(generator.next().value.type).toBe('CALL');
        //2. 결과물 받기
        const mockData = [{ id: 1, content: 'post 1' }];
        const putStep = generator.next({data:mockData}).value;
        //3. 결과물 확인
        expect(putStep).toEqual(put(fetchPostsSuccess(mockData)));
    });

    // --- 단건조회 ---
    it('fetchPostDetail success', () => {
        const generator = fetchPostDetail(fetchPostDetailRequest(1));
        
        expect(generator.next().value.type).toBe('CALL');
        
        const mockData = { id: 1, content: 'detail' };
        const putStep = generator.next({ data: mockData }).value;
        
        expect(putStep).toEqual(put(fetchPostDetailSuccess(mockData)));
    });
 
    // it('fetchPostsPaged success', () => {
    //     const payload = { start: 0, end: 10 };
    //     const generator = fetchPostsPaged(fetchPostsPagedRequest(payload));
        
    //     expect(generator.next().value.type).toBe('CALL');
        
    //     const mockData = [{ id: 10 }, { id: 11 }];
    //     const putStep = generator.next({ data: mockData }).value;
        
    //     expect(putStep).toEqual(put(fetchPostsPagedSuccess(mockData)));
    // });
    
    // --- 글쓰기 ---
    it('createPost success', () => {
        const payload = { content: 'new' };
        const generator = createPost(createPostRequest(payload));
        
        expect(generator.next().value.type).toBe('CALL');
        
        const mockData = { id: 10, content: 'new' };
        const putStep = generator.next({ data: mockData }).value;
        
        expect(putStep).toEqual(put(createPostSuccess(mockData)));
    });
    
    // --- 글수정 ---
    it('updatePost success', () => {
        const payload = { id: 10, content: 'updated' };
        const generator = updatePost(updatePostRequest(payload));
        
        expect(generator.next().value.type).toBe('CALL');
        
        const putStep = generator.next({ data: payload }).value;
        
        expect(putStep).toEqual(put(updatePostSuccess(payload)));
    });
    
    // --- 글삭제 ---
    it('deletePost success', () => {
        const generator = deletePost(deletePostRequest(1));
        
        expect(generator.next().value.type).toBe('CALL');
        
        const putStep = generator.next().value;
        
        expect(putStep).toEqual(put(deletePostSuccess(1)));
    });

});