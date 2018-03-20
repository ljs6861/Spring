

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
		MemberVO vo = new MemberVO(1,"나길동",20,"bit@empas.com","소개");
		
		//view page로 데이터를 전송해보자(display.jsp) : 3~5가지
		//1. forward 방법으로 (요청을 의뢰한 페이지에서만 상태를 유지한다.)
		
		//request.setAttribute("data", data);
		//RequestDispatcher rd=request.getRequestDispatcher("display.jsp");
		//rd.forward(request, response);   //---------------------${data}
	
		//Q) display.jsp, display2.jsp도 값을 가져갈수 있는 방법은?
		//2. 쿠키기법(★)
		
		Cookie c= new Cookie("data",data); //쿠키를 만들었다
		c.setMaxAge(60*60*24);  //24시간(유효기간 설정) --> 파일 쿠키
		response.addCookie(c);
		PrintWriter out =response.getWriter();
		out.print("set cookie~~");
		
	}

}
