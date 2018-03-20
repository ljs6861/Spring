

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/sc")
public class SessionCookieTest extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션 쿠키 : 브라우져 캐시메모리에 저장
		String id="bit";
		
		Cookie c= new Cookie("id",id);
		c.setMaxAge(-1); // 세션쿠키(지속시간이없는 쿠키)--->HttpSession
		response.addCookie(c);
		
		PrintWriter out =response.getWriter();
		out.print("set cookie~~");
	}

}
