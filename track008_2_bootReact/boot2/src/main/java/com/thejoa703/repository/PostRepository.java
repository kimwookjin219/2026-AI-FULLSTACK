package com.thejoa703.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.Post;

@Repository                                     // Entity , PK(자료형)
public interface PostRepository extends JpaRepository<Post, Long>{
	List<Post> findByDeletedFalse(); // List<Post> - 결과가 여러개일때 : List
	
	// 해쉬태그 이름으로 게시글 검색 → findBy (해쉬태그 이름으로 : List<Hashtag> hashtags 필드 name)
	List<Post> findByHashtags_NameAndDeletedFalse(String name);
	
	// 비교 - 결과 값이 1개거나 없을때(null) - Optional
	// Optional<AppUser> findByEmail(String email);
	@Query(
			value="SELECT * FROM ( " +
	                "SELECT p.*, ROWNUM AS rnum " +
	                "FROM (SELECT * FROM POSTS WHERE DELETED = 0 ORDER BY CREATED_AT DESC) p " + 
	                ") " +
	                "WHERE rnum BETWEEN :start AND :end",
			nativeQuery = true
			)
	List<Post> findPostsWithPaging(@Param("start") int start, @Param("end") int end);
	
	// 특정 유저가 좋아요한 게시글
	@Query(value= "\"SELECT * FROM ( \" +\r\n"
			+ "                     \"SELECT p.*, ROWNUM AS rnum \" +\r\n"
			+ "                     \"FROM ( \" +\r\n"
			+ "                     \"   SELECT po.* \" +\r\n"
			+ "                     \"   FROM POSTS po \" +\r\n"
			+ "                     \"   WHERE po.ID IN ( \" +\r\n"
			+ "                     \"       SELECT DISTINCT pl.POST_ID \" +\r\n"
			+ "                     \"       FROM POST_LIKES pl \" +\r\n"
			+ "                     \"       WHERE pl.APP_USER_ID = :userId \" +\r\n"
			+ "                     \"   ) AND po.DELETED = 0 \" +  \r\n"
			+ "                     \"   ORDER BY po.CREATED_AT DESC \" +  \r\n"
			+ "                     \") p \" +\r\n"
			+ "                     \") \" +\r\n"
			+ "                     \"WHERE rnum BETWEEN :start AND :end\"", 
			nativeQuery = true)
	List<Post> findLikedPostsWithPaging(@Param("userId") Long userId, @Param("start") int start, @Param("end") int end);
	// 내가 쓴 글 + 내가 리트위한 글 (합쳐서 조회)
	@Query(value= "\"SELECT * FROM ( \" +\r\n"
			+ "                     \"SELECT p.*, ROWNUM AS rnum \" +\r\n"
			+ "                     \"FROM ( \" +\r\n"
			+ "                     \"   SELECT po.ID, po.CONTENT, po.CREATED_AT, po.DELETED, po.UPDATED_AT, po.APP_USER_ID \" +  \r\n"
			+ "                     \"   FROM POSTS po \" +\r\n"
			+ "                     \"   WHERE po.APP_USER_ID = :userId AND po.DELETED = 0 \" +\r\n"
			+ "                     \"   UNION ALL \" +\r\n"
			+ "                     \"   SELECT po.ID, po.CONTENT, po.CREATED_AT, po.DELETED, po.UPDATED_AT, po.APP_USER_ID \" + \r\n"
			+ "                     \"   FROM POSTS po \" +\r\n"
			+ "                     \"   WHERE po.ID IN ( \" +\r\n"
			+ "                     \"       SELECT DISTINCT r.ORIGINAL_POST_ID \" +\r\n"
			+ "                     \"       FROM RETWEETS r \" +\r\n"
			+ "                     \"       WHERE r.APP_USER_ID = :userId \" +\r\n"
			+ "                     \"   ) AND po.DELETED = 0 \" +\r\n"
			+ "                     \"   ORDER BY CREATED_AT DESC \" +  \r\n"
			+ "                     \") p \" +\r\n"
			+ "                     \") \" +\r\n"
			+ "                     \"WHERE rnum BETWEEN :start AND :end\"",
			nativeQuery = true)
	List<Post> findMyPostsAndRetweetsWithPaging(@Param("userId") Long userId, @Param("start") int start, @Param("end") int end);
}

/* (1) 사용할 수 있는 기본 SQL
	1. CREATE : save       - insert into posts (컬럼1,컬럼2,...) values (?,?,...)
	2. READ   : findAll    - select * from posts
				findById   - select * from posts where id=?
	3. UPDATE : save       - update 테이블명 set 컬럼=? where id=?
	4. DELETE : deleteById - delete from posts where id=?
	
(2) 삭제된 게시글 찾기 findBy필드명 
(3) 복잡한 sql - @Query -> @Param 써야함
                
*/