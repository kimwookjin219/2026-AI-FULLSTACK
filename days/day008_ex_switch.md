### ■1. Todo


---


### ■2. Todo1. CSS기본
- 7. css(3) 가상선택자

```
선택자 : 
- 일반태그 선택자 : p
- 아이디 선택자 : #id
- 클래스 선택자 : .class
- 가상 선택자 :   :hover, :first-child , :last-child
```

- [ ] 1. css 정리파일확인 

---

### ■3. Todo2. java CONTROL - SWITCH
- 제어문은 개발자가 원하는 방향으로 변경할 수 있도록 도와줌.

2. 종류
    조건문 : if, switch
    반복문 : fot, while, do while
    제어키워드 : break, continue

---

1. BANK 지난시간에 작성내용

2. 
    국어점수는 0~100 사이만 입력받게
    영어점수는 0~100 사이만 입력받게
    수학점수는 0~100 사이만 입력받게

    학번 입력 > std111
    국어점수 입력 > 100
    영어점수 입력 > 100
    수학점수 입력 > 99

---

■1. html + css

  1. css 선택자 - 태그선택자  <>
                아이디선택자  #
                클래스선택자  .
                가상선택자      : 예  :hover, :first-child
  2. 내부적용을 이용해서 다음 css를 적으시오. 
      h1 중앙정렬, 글자색상 : #34495e, 아래쪽여백 : 40px 
          h1{ text-align: center; color: #34495e ;    margin-bottom : 40px }
  
  3. 여러개의 div태그에 .portfolio라는 클래스를 적용하고  
    각각의 배경을다르게 설정하려고 한다.  .p1은 배경 red,    .p2는 gold 
    html 설정에 css를 적용하는 코드를 적으시오
    ``` 
    <head>
      <style>
      .p1 { background-color : red; }
      .p2 { background-color : gold; }
      </style>
    </head>
      <div class="portfolio p1"><p></p></div>
      <div class="portfolio p2"><p></p></div>
    ```
  
  4.    .portfolio마우스를 올렸을때    확대 + 회전 + 밝기 + 그림자 강조  css를 적으시오.
                               transform : scale(1.5) rotate(-0.5deg);
                               filter: brightness(1.05);
                               box-shadow: 0 0 5px rgda(0,0,0,0.8);
  5.   가상선택자의 종류는? 
    5-1.   마우스를 올렸을때              :hover
    5-2.   부모안에서 첫번째 자식요소      :first-child
    5-3.   부모안에서 마지막 자식요소      :last-child

  6.   .portfolio ul태그의 첫번째 li를 선택해서 좋아하는 배경색으로 넣기 
  .portfolio ul li:first-child { background-color:red; }

■2.  java

1. if 버젼
    1을 입력받으면 1이다   / 2를 입력받으면 2이다 / 3을 입력받으면 3이다.

    if(a==1) { 1이다. }
    else if(a==2) { 2이다. }
    else if(a==3) { 3이다. }

2. switch 버젼
    위의 내용을 switch 버젼으로 
  switch(a){
    case 1: 1이다. break;
    case 2: 2이다. break;
    case 3: 3이다. break;
  }

3. 다음 무한반복을 빠져나오는 코드를 적으시오
      int a = -1;
      
      for(;;){ 
         System.out.println("빠져나오실래요?  0이면 종료");
         a = scanner.nextInt();
         if(a==0) { break; }
      }
출처: https://hi-sally03915.tistory.com/1954 [:DB:DBIG:티스토리]


