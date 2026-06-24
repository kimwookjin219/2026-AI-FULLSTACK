1. table - oracle (scott/tiger)
    1) 테이블 - sboard2
    2) 시퀀스 (숫자 자동 증가) - sboard2_seq
    SQL> desc  sboard2;
 이름                                         널?      유형
 ----------------------------------------- -------- ----------------------------
 ID                                        NOT NULL NUMBER
 APP_USER_ID                          NOT NULL NUMBER
 BTITLE                                   NOT NULL VARCHAR2(1000)
 BCONTENT                             NOT NULL CLOB
 BPASS                                   NOT NULL VARCHAR2(255)
 BFILE                                                   VARCHAR2(255)
 BHIT                                                    NUMBER
 BIP                                       NOT NULL VARCHAR2(255)
 CREATED_AT                                          DATE
2. dto
3. dao - mapper (mybatis)
    위의 테이블 보고
    1) CRUD
        insert :

            insert into sboard2(ID,APP_USER_ID,BTITLE,BCONTENT,BPASS,BFILE,BIP) values(sboard2_seq.nextval,1001,'title','bcontent','1111','1.png', '127.0.0.1');    

            insert into sboard2(ID,APP_USER_ID,BTITLE,BCONTENT,BPASS,BFILE,BIP) values(${id},${appUserId},${btitle},${bcontent},${bpass},${bfile},${bip})

        전체 select (페이징) :

            select * from sboard2 order by id desc

            -- mysql (oracle에서는 작동 안함)
            select * from sboard2 order by id desc limit 0,10;

            SELECT *
            FROM sboard2
            ORDER BY id DESC
            OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY;

            -- OFFSET 0 ROWS : 건너뛸 행의 개수 (0부터 시작)
            -- FETCH NEXT 10 ROWS ONLY : 가져올 행의 개수
            -- 최신글부터 10개 : 0,10 / 10,10 / 20,10

            select count(*) from sboard2;

            -- 11버전 이하
            select * from(
            select row_number() over(order by id desc)  as rnum, 
            id, app_user_id, btitle, bcontent, bpass, bfile, bip, bhit, created_at
            from  sboard2
            ) A  
            where  A.rnum  between  0  and 10;

        해당번호의 select :

            select * from sboard2 where id=${id}

            select * from sboard2 where id=1

        해당번호 조회수 올리기 :

            update sboard2 set bhit=bhit+1 where id=${id}

            update sboard2 set bhit=bhit+1 where id=1

        해당번호 업데이트 :

            update sboard2 set btitle=${btile}, bcontent=${bcontent}, bfile=${bfile} where id=${id}

            update sboard2 set btitle='new', bcontent='new', bfile='2.png' where id=1

        해당번호 삭제 :

            delete from sboard2 where id=${id}

            delete from sboard2 where id=1

    2) sboard2-mapper.xml

    3) sboard2Dao.java