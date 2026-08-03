// pages/index.js
import React,{useEffect, useState} from 'react'; // 이벤트 변경 감지, useState (변수 변경)
import { Spin } from 'antd'; 
import { useSelector,useDispatch } from 'react-redux'; // 전역상태, 스토어 알림
import { fetchPostsRequest, updatePostRequest, deletePostRequest } from '../reducers/postReducer';
import PostList from '../components/PostList';
import EditPostModal from '../components/EditPostModal';

export default function Home(){
    const dispatch = useDispatch();
    //1. 유저정보 가져오기 - state.auth
    const {user} = useSelector((state)=>state.auth);
    //2. 게시글 가져오기 - state.post
    const {posts, loading, error} = useSelector((state)=>state.post); 
    
    // 수정모달 : isEditModalVisible, setIsEditModalVisible
    const [isEditModalVisible, setIsEditModalVisible] = useState(false);
    // 수정할 글 : editPost , setEditPost
    const [editPost, setEditPost] = useState(null);
    
    // 수정기능 : handleEditSubmit
    const handleEdit = (post)=>{
        setEditPost(post); // 수정글 셋팅
        setIsEditModalVisible(true); // 수정화면 보이기
    };

    const handleEditSubmit = (values)=>{
        dispatch(updatePostRequest({ postId: editPost.id , dto: {content:values.content} }) ); // 수정기능 후
        setIsEditModalVisible(false); // 화면 안보이기
        setEditPost(null);
    };

    // 삭제기능
    const handleDelete = (postId)=>{
        dispatch(deletePostRequest(postId)); // 해당 글번호
    };

    // 페이지가 처음 뜰때 게시글 조회 액션 - dispatch
    useEffect(()=>{
        dispatch(fetchPostsRequest());
    }, [dispatch]);

    //////////
    return (
        <>
            <PostList 
                posts={posts} 
                handleEdit={handleEdit}
                handleDelete={handleDelete}
            />
            <EditPostModal 
                visible={isEditModalVisible}
                onCancel={()=> setIsEditModalVisible(false)}
                editPost={editPost}
                onSubmit={handleEditSubmit}
            />
        </>
    );
}
// npm run dev