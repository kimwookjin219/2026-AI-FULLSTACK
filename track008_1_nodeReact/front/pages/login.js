import { useSelector , useDispatch } from "react-redux"; // store : 전역상태
import { useState , useEffect } from "react"; // react : 변경감지
import { useRouter } from "next/router"; // 경로 이동
import { LOG_IN_REQUEST } from "../reducers/user"; 

export default function LoginPage(){
    //1. 코드 
    // 초기화
    const dispatch = useDispatch();
    const router = useRouter();
    const {me, isLoading, error} = useSelector((state)=>state.user);

    // form 연결 
    const [email,setEmail] = useState('');       // email 변수, email셋팅 함수
    const [password,setPassword] = useState('');

    //1-1. 회원가입했다고하면 알림창 - http://localhost:3000/login?signUpSuccess=true
    useEffect(()=>{
        if(router.query.signUpSuccess == 'true'){ 
            alert('회원가입이 완료되었습니다. 로그인해주세요!');
            // 알림창 띄우고, 쿼리제거 / 새로고침해도 알림창이 다시 안뜨게
            //         주소표시창줄 , 주소표시창줄 감출 필요X  ,   
            router.replace('login',       undefined       , {shallow:true} ) 
         }
    } , [router.query]);
    //1-2. 로그인
    const onSubmit = (e)=>{
        e.preventDefault();

        if(!email.trim()){ alert('이메일을 입력해주세요.'); return; }
        if(!password.trim()){ alert('비밀번호를 입력해주세요.'); return; }

        dispatch({type: LOG_IN_REQUEST , data:{email,password}});
    };

    //1-3. 로그인 후 사용자 목록 페이지로 이동  
    useEffect(()=>{
        if(me) router.push('/users');    // replace : 주소표시창줄 바뀜 , history 추가X
                                         // push    : 주소표시창줄 바뀜 , history 추가O
    },[me,router]);

    //2. 뷰
    return (
        <div>
            <h3 className="container my-4">로그인</h3>
            <form className="w-50 mx-auto" onSubmit={onSubmit}>
                {/* 이메일 입력 */}
                <div className="mb-3">
                    <input type="email" className="form-control" placeholder="이메일" title="이메일입력"
                    value={email}
                    onChange={(e)=>{setEmail(e.target.value)}}/>
                </div>
                {/* 비밀번호 입력 */}
                <div className="mb-3">
                    <input type="password" className="form-control" placeholder="비밀번호" title="비밀번호입력"
                    value={password}
                    onChange={(e)=>{setPassword(e.target.value)}}/>
                </div>

                <div className="mb-3">
                    <button type="submit" className="btn btn-primary w-100" disabled={isLoading}>로그인</button>
                </div>
            </form>

            {/* 비밀번호 입력 */}
            {error && <div className="alert alert-danger mt-3">에러메세지 출력</div>}
        </div>
    );
}