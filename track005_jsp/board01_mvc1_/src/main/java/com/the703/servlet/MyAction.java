package com.the703.servlet;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyAction
 */
@WebServlet("/MyAction")
public class MyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 로그인한 정보 가져오기 - session
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");

		
		//2. sql
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic","root","1234");
			PreparedStatement pstmt = conn.prepareStatement("select * from users where email=?");
			pstmt.setString(1,email);
			
			ResultSet rset = pstmt.executeQuery();
			
			if(rset.next()) {
				request.setAttribute("nickname", rset.getString("nickname") );
				request.setAttribute("email", rset.getString("email") );
				request.setAttribute("mobile", rset.getString("mobile") );
				request.setAttribute("udate", rset.getString("udate") );
				request.setAttribute("bip", rset.getString("bip") );
			}
			//3. mypage.jsp로 경로 넘기기
			request.getRequestDispatcher("mypage.jsp").forward(request, response);
			
		}catch(Exception e) { e.printStackTrace(); }	

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}
}
