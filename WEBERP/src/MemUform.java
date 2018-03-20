

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.mem.MemberDAO;
import kr.bit.mem.MemberVO;


@WebServlet("/memUform")
public class MemUform extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int num= Integer.parseInt(request.getParameter("num"));
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.memView(num);
		
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out=response.getWriter();
		
		out.println("<html>");
		out.println("<head><title>ȸ�� �󼼺���</title></head>");
		out.println("<body>");
		
		out.println("<form action='memUpdate' method='post'>");
		out.println("<input type='hidden' name='num' value='"+vo.getNum()+"'/>");
		
		out.println("<table border='1' witdh='500px'>");
		
		out.println("<tr>");
		out.println("<td ����='100px'>��ȣ</td>");
		out.println("<td>"+vo.getNum()+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>�̸�</td>");
		out.println("<td>"+vo.getIrum()+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>����</td>");
		out.println("<td><input type='text' name='age' value='"+vo.getAge()+"'/></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>�̸���</td>");
		out.println("<td><input type='text' name='email' value='"+vo.getEmail()+"'/></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>�ڱ�Ұ�</td>");
		out.println("<td><textarea rows='7' cols='50' name='intro'>" +vo.getIntro()+"</textarea></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td colspan='2'>");
		out.println("<input type='submit' value='����'/>");
		out.println("<a href='memList'>���</a>");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

}
