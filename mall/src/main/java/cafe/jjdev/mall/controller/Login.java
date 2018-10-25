package cafe.jjdev.mall.controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cafe.jjdev.mall.service.MemberDao;

@WebServlet("/login")
public class Login extends HttpServlet {
	private MemberDao memberDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("loginMember") == null) {
			System.out.println("login.jsp forward");
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);;
		} else {
			System.out.println("로그인중입니다 ... ");
			response.sendRedirect("/index");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// boolean MemberDao.login(Member) 
		boolean isLogin = false; 
		if(isLogin) {
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", null);
			response.sendRedirect("/index");
		} else {
			response.sendRedirect("/login");
		}
	}
}
