package com.the703.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response); //로그인 폼으로
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 데이터 넘겨받기
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String email = request.getParameter("email");
		String bpass = request.getParameter("bpass");
		PrintWriter out = response.getWriter();     // 출력 구문
		HttpSession session = request.getSession(); //HttpSession - 서버에 저장
		//2. sql처리 ( 드 커 프 리)
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic","root","1234");
			PreparedStatement pstmt = conn.prepareStatement("select count(*) cnt from users where email=? and bpass=?");
			int find = -1;
			
			pstmt.setString(1, email);
			pstmt.setString(2, bpass);
			
			ResultSet rset = pstmt.executeQuery();
			
			if(rset.next()) {
				find = rset.getInt("cnt"); // 아이디와 비밀번호가 같은 유저는 1명
				//3. 해당화면으로 넘기기
				if(find==1) {
					session.setAttribute("email",email); 
					out.println("<script> alert('로그인성공!'); location.href='MyAction';</script>");
				}				
			}
			else { 
				out.println("<script> alert('다시 입력해주세요!'); history.go(-1); </script>");
			}
			
			if(rset!=null) { rset.close(); }
			if(pstmt!=null) { pstmt.close(); }
			if(conn!=null) { conn.close(); }
		}catch(Exception e) { e.printStackTrace(); }
		
		
	}

}
