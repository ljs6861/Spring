

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

		// 처음 요청이냐? 두번쨰 요청이냐?
		// HEADER에 --> [SESSIONID =32자의 영숫자조합]
		
		HttpSession session =request.getSession();
		System.out.println(session.getId());
		System.out.println(session.getCreationTime());
		System.out.println(session.getMaxInactiveInterval());
		MemberVO vo = new MemberVO(1, "나길동", 30, "bit@empas.com","소개");
		
		session.setAttribute("vo", vo);
		// 다른 여러 jsp에서 가져가게하고 싶다.?
		// display4.jsp
		// forward / redirect
		//	response.sendRedirect("display4.jsp");
		RequestDispatcher rd =request.getRequestDispatcher("display4.jsp");
		rd.forward(request, response);
	}

}
