package cafe.jjdev.mall.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ModifyMember")
public class ModifyMember extends HttpServlet {
	
	// ���� ������ �̵�
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// �α��� Ȯ��
		// MemberDao.selectMember()
		// forward
	}

	// ���� �׼�
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// �α��� Ȯ��
		// MemberDao.updateMember()
		// �α׾ƿ����� redirect
	}

}
