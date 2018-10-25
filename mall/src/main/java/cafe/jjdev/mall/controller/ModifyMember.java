package cafe.jjdev.mall.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ModifyMember")
public class ModifyMember extends HttpServlet {
	
	// 수정 폼으로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 확인
		// MemberDao.selectMember()
		// forward
	}

	// 수정 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 확인
		// MemberDao.updateMember()
		// 로그아웃으로 redirect
	}

}
