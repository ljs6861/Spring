

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.mem.MemberVO;


@WebServlet("/sw")
public class ServletAndView extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberVO vo = new MemberVO();
		vo.setNum(1);
		vo.setIrum("나길동");
		vo.setAge(30);
		vo.setEmail("bit@empas.com");
		vo.setIntro("자기소개");
		
		// content.jsp에서 응답 HTML을 만들자.
		request.setAttribute("vo", vo);  //vo를 연결해서 request에 set해줌.
		RequestDispatcher rd =request.getRequestDispatcher("content.jsp"); //비서=rd
		rd.forward(request, response);
	}

}
