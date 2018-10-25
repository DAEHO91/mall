package cafe.jjdev.mall.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cafe.jjdev.mall.service.Member;
import cafe.jjdev.mall.service.MemberDao;
@WebServlet("/addMember")
public class AddMember extends HttpServlet{
	MemberDao memberDao;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/addMember.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member = new Member();
		memberDao = new MemberDao();
		int level = 0;
		member.setId((String)request.getParameter("id"));
		member.setPw((String)request.getParameter("pw"));
		if(request.getParameter("level")=="包府磊") {
			//1老矫 包府磊
			level = 1;
		}		
		member.setLevel(level);
		int row = memberDao.insertMember(member);
		response.sendRedirect(request.getContextPath()+"/login");
	}
}
