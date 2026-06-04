package com.the703.dao;

import java.util.List;

import com.the703.dto.BoardDto;

@Mapper
public interface BoardMapper {
	public int insert(BoardDto dto);
	public int update(BoardDto dto);
	public int delete(int bno);
	public List<BoardDto> selectAll();
	public BoardDto select(int bno);
}
/*
mysql> desc mvcboard2;
+----------+---------------+------+-----+-------------------+-------------------+
| Field    | Type          | Null | Key | Default           | Extra             |
+----------+---------------+------+-----+-------------------+-------------------+
| bno      | int           | NO   | PRI | NULL              | auto_increment    |
| bname    | varchar(20)   | NO   |     | NULL              |                   |
| bpass    | varchar(50)   | NO   |     | NULL              |                   |
| btitle   | varchar(1000) | NO   |     | NULL              |                   |
| bcontent | text          | NO   |     | NULL              |                   |
| bdate    | timestamp     | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
| bhit     | int           | NO   |     | 0                 |                   |
| bip      | varchar(50)   | NO   |     | NULL              |                   |
+----------+---------------+------+-----+-------------------+-------------------+
8 rows in set (0.00 sec)

(해당번호의 글읽기,글수정,삭제)
insert : insert into mvcboard2 (bname,bpass,btitle,bcontent,bip) values(#{bname},#{bpass},#{btitle},#{bcontent},#{bip} )
read : select * from mvcboard2 order by bno desc
	   select * from mvcboard2 where bno = #{bno}
update : update mvcboard2 set btitle=#{btitle}, bcontent=#{bcontent} where bno=#{bno}
delete : delete from mvcboard2 where bno=#{bno}

*/