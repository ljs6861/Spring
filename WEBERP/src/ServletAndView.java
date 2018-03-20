

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
		vo.setIrum("���浿");
		vo.setAge(30);
		vo.setEmail("bit@empas.com");
		vo.setIntro("�ڱ�Ұ�");
		
		// content.jsp���� ���� HTML�� ������.
		request.setAttribute("vo", vo);  //vo�� �����ؼ� request�� set����.
		RequestDispatcher rd =request.getRequestDispatcher("content.jsp"); //��=rd
		rd.forward(request, response);
	}

}
