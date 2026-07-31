// pages/posts/new.js
//1. import
import { Card, Button, Input, Form, message } from "antd";
import { useSelector,useDispatch } from "react-redux"; // 전역정보 , 이벤트 발생
import { useEffect } from "react";
import { useRouter } from "next/router"; // 화면이동
import { createPostRequest } from "../../reducers/postReducer"; // 액션

//2. export + 부품
export default function NewPostPage(){
    //1. 글정보(state.post) / 유저정보(state.user) 가져오기(useSelector : 전역정보) Q2.
    const router = useRouter();
    const dispatch = useDispatch();
    const {loading, error} = useSelector((state)=>state.post); // 글정보
    //유저정보
    const {user} = useSelector((state)=>state.auth);

    //2. 게시글 작성 (dispatch(createPostRequest(dto)) : 이벤트 발생알림) Q3.
    const onFinish = (values)=>{
        const dto = {
            userId: 38,//user.id ,
            content: values.content
        }
        dispatch(createPostRequest(dto));
        message.success("게시글 작성 완료!");
        router.push("/");
    };

    // 글쓰고 나면 / 메인페이지


    ////////////////////////////////Q1. view
    return (
        <div style={{maxWidth:600 , margin: "0 auto"}}>
            <Card title="게시글 작성">
                <Form layout="vertical" onFinish={onFinish}>
                    <Form.Item
                        label="내용"
                        name="content" 
                        hasFeedback
                        rules={[ {required: true, message:'내용을 입력하세요.'} ]}                      
                    >
                        <Input.TextArea rows={4} placeholder="게시글 내용을 입력하세요."/>
                    </Form.Item>

                    <Button type="primary" htmlType="submit" loading={loading}>
                        게시글 작성
                    </Button>
                    {error && <p style={{color:"red"}}>{error}</p>}
                </Form>
            </Card>
        </div>
    );
}