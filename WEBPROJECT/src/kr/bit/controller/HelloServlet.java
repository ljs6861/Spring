package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.mem.Helper;

// JavaEE의 기본 골격 sevlect ★★★★★
public class HelloServlet extends HttpServlet {		// 서블릿 (웹에서 구동되는 100% 자바로된 웹프로그래밍)
	// JavaEE ->service, doGet, doPost
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		
		Helper h = new Helper();
		int sum=h.hap();
		// 구한 sum의 값을 요청한 클라이언트에게 응답해주면 된다.
		
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.print(sum);
		out.println("</body>");
		out.println("</html>");
		
	}
}

/* http://127.0.0:8000/wep/WEB-INF/classes/kr/bit.controller/HelloServlet
   1. WEB-INF 경로가 보안 디렉토리 이므로 접근불가
   2. /WEB-INF/classes/bit.controller/HelloServlet : 요청경로 길다.
   3.             "                                : 요청경로가 노출된다.
 */
