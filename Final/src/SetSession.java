

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.bit.mem.MemberVO;

@WebServlet("/ss")
public class SetSession extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// ó�� ��û�̳�? �ι��� ��û�̳�?
		// HEADER�� --> [SESSIONID =32���� ����������]
		
		HttpSession session =request.getSession();
		System.out.println(session.getId());
		System.out.println(session.getCreationTime());
		System.out.println(session.getMaxInactiveInterval());
		MemberVO vo = new MemberVO(1, "���浿", 30, "bit@empas.com","�Ұ�");
		
		session.setAttribute("vo", vo);
		// �ٸ� ���� jsp���� ���������ϰ� �ʹ�.?
		// display4.jsp
		// forward / redirect
		//	response.sendRedirect("display4.jsp");
		RequestDispatcher rd =request.getRequestDispatcher("display4.jsp");
		rd.forward(request, response);
	}

}
