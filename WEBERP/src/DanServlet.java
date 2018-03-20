
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.mem.MemberDAO;
import kr.bit.mem.MemberVO;


@WebServlet("/dan.do")
public class DanServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	

		int dan = Integer.parseInt(request.getParameter("dan"));

		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head><title>구구단</title></head>");
		out.println("<body>");
		out.println(dan+"단");
	

		out.println("<table border='1'>");
		for (int i = 0; i < 10; i++) {

			out.println("<tr>");
			out.println("<td>" + dan + "</td>");
			out.println("<td>" + "x" + "</td>");
			out.println("<td>" + i + "</td>");
			out.println("<td>" + "=" + "</td>");
			out.println("<td>" + dan * i + "</td>");
			out.println("</tr>");
		}

		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");

	}

}
