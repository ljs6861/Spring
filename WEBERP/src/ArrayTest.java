

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/at")
public class ArrayTest extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] f= {"사과","바나나","오렌지","포도","귤"};
		//forward ->요청 의뢰
		request.setAttribute("f",f);
		RequestDispatcher rd = request.getRequestDispatcher("view03.jsp");//${f}
		
		rd.forward(request,response );
	}

}
