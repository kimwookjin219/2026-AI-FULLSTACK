<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@include file="./inc/header.jsp" %>
    <!-- content -->
    <section class="container my-5">
        <h3>MultiBoard</h3>
            <table class="table table-striped table-bordered table-hover table-light">
                <caption> BOARD 목록 </caption>
                <thead>
                    <tr>
                        <th scope="col">NO</th>
                        <th scope="col">TITLE</th>
                        <th scope="col">WRITER</th>
                        <th scope="col">DATE</th>
                        <th scope="col">HIT</th>
                    </tr>
                </thead>
                
                <tbody>
					<%
					try{
						Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
						String url = "jdbc:mysql://localhost:3306/mbasic";
						String id = "root" , pass = "1234";
						//String sql1 = "select count(*) from mvcboard1 order by bno desc";
						String sql = "select b.* ,(select count(*) from mvcboard1) `cnt`  from mvcboard1 b order by bno desc";
						//                      sql 구문 안에 sql 구문 : 서브쿼리
						Class.forName("com.mysql.cj.jdbc.Driver");
						conn = DriverManager.getConnection(url,id,pass);
						pstmt = conn.prepareStatement(sql);
			            pstmt = conn.prepareStatement(sql , 
			                       ResultSet.TYPE_SCROLL_INSENSITIVE, 
			                       ResultSet.CONCUR_READ_ONLY);

						rset = pstmt.executeQuery(); // 표
						//1) 먼저 전체글 갯수 출력
						int cnt = -1;
						//줄
						if(rset.next()){							
							cnt = rset.getInt("cnt"); //칸
							rset.beforeFirst();       //다시 처음으로 표부터 처리
						} 
						//2) 						
						while(rset.next()){ //줄
							out.print("<tr><td>"+ cnt-- 
							          +"</td><td><a href='detail.jsp?bno="+ rset.getInt("bno") +"'>"
									  + rset.getString("btitle") 
							          +"</a></td><td>"+ rset.getString("bname") 
							          +"</td><td>"+ rset.getString("bdate") 
							          +"</td><td>"+ rset.getInt("bhit") +"</td></tr>"); //칸
						}
						if(rset!=null) { rset.close(); }
						if(pstmt!=null) { pstmt.close(); }
						if(conn!=null) { conn.close(); }
					}catch(Exception e){ e.printStackTrace(); }
					%>
                </tbody>
            </table>
            <div class="text-end">
                <a href="write.jsp" title="글쓰기 폼" class="btn btn-primary">글쓰기</a>
            </div>
    </section>

<%@include file="./inc/footer.jsp" %>
    <!-- Q1 HEADER - NAVBAR 좋아하는 배경색상 -->
    <!-- Q2 FOOTER - copyrights 넣고 배경색상 / 글자중앙 -->

<!-- board1.html  -->
<!-- boot + enter         -->