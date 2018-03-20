

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.mem.MemberVO;


@WebServlet("/ct")
public class CookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.String
		String data = "bitcocom";
		
		// 2.Object Data
		MemberVO vo = new MemberVO(1,"���浿",20,"bit@empas.com","�Ұ�");
		
		//view page�� �����͸� �����غ���(display.jsp) : 3~5����
		//1. forward ������� (��û�� �Ƿ��� ������������ ���¸� �����Ѵ�.)
		
		//request.setAttribute("data", data);
		//RequestDispatcher rd=request.getRequestDispatcher("display.jsp");
		//rd.forward(request, response);   //---------------------${data}
	
		//Q) display.jsp, display2.jsp�� ���� �������� �ִ� �����?
		//2. ��Ű���(��)
		
		Cookie c= new Cookie("data",data); //��Ű�� �������
		c.setMaxAge(60*60*24);  //24�ð�(��ȿ�Ⱓ ����) --> ���� ��Ű
		response.addCookie(c);
		PrintWriter out =response.getWriter();
		out.print("set cookie~~");
		
	}

}
