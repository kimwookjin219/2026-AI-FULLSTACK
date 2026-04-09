### ■1. 복습문제

-1. 
1) 적응할 수 있는 능력
2) 

html
css
js + jquery + ajax
react

oracle/mysql
mybatis
jpa

java
jsp
spring
spring boot

---

### ■2. CSS

```
선택자 : 
- 일반태그 선택자 : p
- 아이디 선택자 : #id
- 클래스 선택자 : .class
- 가상 선택자 :   :hover, :first-child , :last-child
```
layout

1. float
2. position
3. display

---

### ■3. JAVA - CONTROL - Switch

- 제어문은 개발자가 원하는 방향으로 변경할 수 있도록 도와줌.

2. 종류
    조건문 : if, switch
    반복문 : fot, while, do while
    제어키워드 : break, continue

---

### ■4.  복습문제

■ 1. html + css
```
    1. 레이아웃잡는방법은? (   float  ,   position    ,  display    )
    2. box를 왼쪽, 오른쪽에 붙이는 방법은?                         .box { float:left; }   .box { float:right; }
    3. 다음박스를 왼쪽 오른쪽에 배치하려고 한다. 들어가야하는 코드는?
    <style>
      .left{ float:left; }     .right{ float:right; }    .clear{  clear:both;  }
    </style>
    <div class="box">
      <div class="left">LEFT</div>
      <div class="right">RIGHT</div>
      <div class="clear">안따라갈려고</div>
    </div>

    4. 다음li를 왼쪽으로 붙이려고한다. 코드는?
    
     clear:both가 없을때  overflow:hidden;
     불릿기호 없애기 : list-style:none;

    <style>
      ul{ overflow:hidden; padding:10px; }    li{ float:left; }
    </style>
    <ul>
      <li>ONE </li><li>TWO</li><li>THREE</li>
    </ul>

    5. 내가 원하는 위치에 top, right, bottom, left 속성을 줘서 원하는 위치에 배치하는 방법은?
     - 부모박스에  (  relative  )코드를 사용해   기준점을 잡고
     - 자식콘텐츠로  (   absolute  )를 사용해 배치한다.

    6.  스크롤할 때 상단에 계속 붙어 있도록 만드는 방법은?  position:sticky; top:0;
```    

■ 2. java
```
1. if버젼에 해당하는 다음에 연결해서 문제를 작성하시오.
    문자를 한개 입력받아 a이면 apple , b이면 banana, c이면 coconut
    char a ='\u0000';
    Scanner sc = new Scanner(System.in);

    System.out.print("a,b,c 중 하나 입력>");  a=sc.next().charAt(0);

    if(a=='a'){ System.out.println("apple"); }
    else if(a=='b') { System.out.println("banana"); }
    else if(a=='c') { System.out.println("coconut"); }

2. switch버젼에 해당하는 다음에 연결해서 문제를 작성하시오.
    문자를 한개 입력받아 a이면 apple , b이면 banana, c이면 coconut

    char ch='\u0000';
    Scanner scanner =new Scanner(System.in);

    System.out.println("a,b,c 중에 입력 > ");  
    ch = scanner.next().charAt(0);

    switch{
      case 'a': System.out.println("apple");
      case 'b': System.out.println("banana");
      case 'c': System.out.println("coconut");
    }
    
3. for, while, do while 버젼으로  문제를 풀으시오!  
     1  2  3  4  5
  for(int i=1; i<=5; i++) { System.out.print(i+"\t"); }

  int i=1;
  while(i<=5) { System.out.print(i+"\t"); i++; }

  int i=1;
  do { System.out.print(i+"\t"); i++; }
  while(i<=5);


```

