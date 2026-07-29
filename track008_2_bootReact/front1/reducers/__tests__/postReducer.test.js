// __tests__/postReducer.test.js
import postReducer, {
              fetchPostsRequest, fetchPostsSuccess, fetchPostsFailure,
              fetchPostDetailRequest, fetchPostDetailSuccess, fetchPostDetailFailure,
              createPostRequest, createPostSuccess, createPostFailure,
              updatePostRequest, updatePostSuccess, updatePostFailure,
              deletePostRequest, deletePostSuccess, deletePostFailure,
              resetPostState
} from '../postReducer';

describe('post', ()=>{
    const initialState={  // spring - controller 리턴값 확인해서 구성
        posts : [] , // 전체 게시글 목록
        currentPost: null , // 단건 조회된 상세 게시글
        loading: false, 
        error: null,
        success: false,
    };

    it('fetchPostsRequest & fetchPostsSuccess', ()=>{ //fetchPostsRequest, fetchPostsSuccess
        let state = postReducer(initialState, fetchPostsRequest());
        //1. fetchPostsRequest() 실행 - 인자없음
        //2. 리듀서 툴킷 - {type: fetchPostsRequest , payload : undefined} 객체 만들기
        //3. 리듀서 fetchPostsRequest: (state , action)=>{} 액션 받아서 처리
        // action = {type: fetchPostsRequest , payload : undefined} 
        expect(state.loading).toBe(true);

        const posts = [{id:1 , content: '첫번째 글'}];
        state = postReducer(initialState, fetchPostsSuccess(posts));

        expect(state.loading).toBe(false);
        expect(state.posts).toEqual(posts);
        expect(state.success).toBe(true);
    });

    // fetchPostDetailSuccess - 게시글 조회
    it('fetchPostDetailSuccess', ()=>{ 
        const post = {id:1 , content: '첫번째 글'};
        const state = postReducer(initialState, fetchPostDetailSuccess(post));

        expect(state.loading).toBe(false);
        expect(state.currentPost).toEqual(post);
        expect(state.success).toBe(true);
    });

    // createPostSuccess - 글쓰기
    it('createPostSuccess', ()=>{ 
        const newPost = {id:3 , content: '새 글'};
        const state = postReducer(initialState, createPostSuccess(newPost));

        expect(state.loading).toBe(false);
        expect(state.posts[0]).toEqual(newPost);
        expect(state.success).toBe(true);
    });

    // updatePostSuccess - 글수정
    it('updatePostSuccess', ()=>{ 
        const prev = { ...initialState , posts:[{id:3 , content: '새 글'}]};
        const updated = {id:3 , content: '수정 후'}; // 서버에서 받아온 값

        const state = postReducer(prev, updatePostSuccess(updated));

        expect(state.posts[0].content).toBe('수정 후');
        expect(state.currentPost).toEqual(updated);
    });

    // deletePostSuccess - 글삭제
    it('deletePostSuccess', ()=>{ 
        const prev = { ...initialState , posts:[{id:1 , content: '새 글'}]};
        const state = postReducer(prev, deletePostSuccess(1));

        expect(state.posts).toHaveLength(0); // toHaveLength(?) - 게시글 수가 몇개인지
        // expect(state.posts.length).toBe(0);
        expect(state.success).toBe(true);
    });
    //deletePostSuccess: (state , action)=>{ 
    //     state.loading = false;
    //     // 삭제된 게시글의 id받아서 목록에서 제외
    //     state.posts   = state.posts.filter(post=>  post.id !== action.payload);   
    //     state.success = true;
    // },

    // resetPostState - 초기화
    it('resetPostState', ()=>{ 
        const prev = { ...initialState , loading:true, error:'error', success:true};
        const state = postReducer(prev, resetPostState());

        expect(state.loading).toBe(false);
        expect(state.error).toBeNull();
        expect(state.success).toBe(false);
    });
    
});
// npm test postReducer