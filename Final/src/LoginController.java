

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String pwd = request.getParameter("pwd");
		HttpSession session = request.getSession();
		if(id.equals("admin") && pwd.equals("admin")){
			// 회원인증에 성공했다는 표시를 해두어야한다.
			
			session.setAttribute("id",id);
			response.sendRedirect("main.jsp");
			
		}else{
			response.sendRedirect("login.html");
		}
	}

}
