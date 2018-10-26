package cafe.jjdev.mall.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cafe.jjdev.mall.service.Member;
import cafe.jjdev.mall.service.MemberDao;

@WebServlet("/GetMember")
public class GetMember extends HttpServlet {
       
	private MemberDao memberDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GetMember 메서드 실행  Getmember.java");
		HttpSession session = request.getSession();

		
		if(session.getAttribute("loginMember") == null) {
			response.sendRedirect(request.getContextPath()+"/login");
		}else {
			memberDao = new MemberDao();
			Member member = memberDao.selectMember((String)session.getAttribute("loginMember"));
		
			request.setAttribute("member", member);
			request.getRequestDispatcher("WEB-INF/jsp/getMember.jsp").forward(request, response);
		}
	}
}
