### ■1. 복습문제
- 1. css(1)
1. 배경 : 
2. 글자 : 
3. 글자크기 : 
4. 정렬 : 
5. 밑줄 : 
6. 글꼴 : 
7. 굵게 : 
8. 가로 : 
9. 바깥쪽 여백 : 
10. 안쪽 여백 : 
11. 선 : 
12. 둥근모서리 : 
13. 그림자효과 : 

- 2. java
  1. 자바의 자료형 분류(   /   )
  2. 기본형 : 값
    2-1 논리형 : 예) boolean  - true/false (1byte)   
    2-2 정수형 :  
    2-3 실수형 :  
    2-4 문자형 :
  3. 자동형변환은 (  boolean  )  빼고  (  
    byte < short / char < int < long < float < double
    ) 기본형


- 3. java [실습]
패키지명 : com.company.java003_ex
클래스명 : CastingEx001
출력내용 :  Scanner이용해서 나누기 프로그램만들기 
   숫자입력1>  _입력받기  10   ( ☆자료형을 int )
   숫자입력2>  _입력받기  3     ( ☆자료형을 int )              
   
   10 / 3 = 3.33

주어진조건 : 
      //변수
      int num1, num2;
      double result;
      Scanner scanner = new Scanner(System.in);

---

### ■2. Todo1: CSS기본

- 6. CSS(2) 내부적용 / id vs class

1. block vs line
Q) a 태그에 margin적용 X, text-align 적용X, width X

display block    박스 (갈치냄비)               - width o , 줄바꿈 o
         예) div , p , pre
          
display inline   박스 안의 내용물 (국물,무,갈치) - width x(△) , 줄바꿈 x
         예) img , a , span , strong

- 7. CSS(2) 내부적용 / id vs class
css 적용방법
1) 인라인 스타일 - 태그 안에 직접 적용 

```html
<p style="color : red;">color</p>

```
2) 내부 스타일 시트 - head 안에 style을 사용해 작성

```html
<style> p{ color : red; } </style>
```

3) 외부 스타일 시트

---

### ■3. Todo2: java 자료형2 

---

### ■4. 복습문제 
> 정리문제 (1)
1. 배경을 파란색으로 설정하는 속성은?            background-color:blue;
2. 글자색상을 빨간색으로 지정하는 속성은?         color:red;
3. 글자 크기를 20px로 지정하는 속성은?          font-size:20px;
4. 글자를 가운데 정렬하는 속성은?               text-align:center;
5. 글자에 밑줄을 추가하는 속성은?               text-decoration:none;
6. 글꼴을 Arial로 지정하는 속성은?              font-family:'Arial';
7. 글자를 굵게 표시하는 속성은?                 font-weight:20px;
8. 요소의 가로 길이를 300px로 지정하는 속성은?    width:300px;
9. 요소의 바깥쪽 여백을 10px로 지정하는 속성은?   margin:10px;
10. 요소의 안쪽 여백을 15px로 지정하는 속성은?    padding:15px;
11. 요소에 1px 실선 테두리를 추가하는 속성은?     text-decoration:1px;
12. 모서리를 둥글게 10px로 만드는 속성은?        border-radius:10px;
13. 그림자 효과를 추가하는 속성은?               box-shadow:0 0 1px rgba(0,0,0,0.5);
14. 천천히 움직이는 장면전환효과를 주는 속성은?    transition : all 1.5s

> 정리문제 (2)
15.  가로 사이즈 지정가능한것은 block   /    inline        둘 다 가능
16.  a태그에 margin-top 줄수   o   /   x     없다!
17.  css 적용방법 3가지 (  인라인 / 내부   / 외부   )
18.  css 적용 내부적용방법은 ( head  ) 태그안에 ( style  ) 태그 적용해서 사용

> 정리문제 (3)
1.  연산자의 우선순위를 적으시오. 
  ()          값         →       비교      →        조건         →     대입
  () ++ -- + - * / %        >  <  !=  ==       &&   ||  ?:            =

2.  다음오류 해결
short sh1 = 1 , sh2=2;
short result = sh1 + sh2;  →  short result = (short)(sh1 + sh2);

3. 필수조건
q1-1 int형 변수 x가 3보다 크고 10보다 작을때 true인 조건식 
  System.out.println( x>3 && x<10 );

q1-2 char형 변수 ch가 'a' 또는 'A'일때   true인 조건식    
  System.out.println( ch=='a' || ch=='A' );

q1-3 char형 변수 ch가 숫자('0'~'9')일때   true인 조건식   
  System.out.println( ch>='0' && ch<='9');  
  
q1-4 char형 변수 ch가 영문자(대문자 또는 소문자) 일때   true인 조건식
  System.out.println( ch>='A' && ch<='Z' || ch>='a' && ch<='z' );