
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.mem.MemberDAO;
import kr.bit.mem.MemberVO;

@WebServlet("/memList")
public class MemList extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// member table���� ��üȸ�� ����Ʈ�� ������ ����.
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.memList();

		// ��ü����Ʈ�� HTML�� ������ �ؼ� ���������� ===> JSP
		// �����ϱ����� ���䵥���Ϳ� �ִ� �ѱ۱��� ����
		
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>ȸ�� ����Ʈ</title><head>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<tr>");
			out.println("<td>��ȣ</td>");
			out.println("<td>�̸�</td>");
			out.println("<td>����</td>");
			out.println("<td>�̸���</td>");
			out.println("<td>�ڱ�Ұ�</td>");
		out.println("</tr>");
		for(MemberVO vo: list){
			out.println("<tr>");
				out.println("<td>"+ vo.getNum()+ "</td>");
				out.println("<td><a href='memView?num="+vo.getNum()+"'>"+vo.getIrum()+"</a></td>");
				out.println("<td>"+ vo.getAge()+ "</td>");
				out.println("<td>"+ vo.getEmail()+ "</td>");
				out.println("<td>"+ vo.getIntro()+ "</td>");
				out.println("<td><a href='memDel?num="+vo.getNum()+"'>����</a></td>");
			out.println("</tr>");
		}
		
		out.println("<tr>");
		out.println("<td colspan ='5'>");
		out.println("<a href='member.html'>ȸ������</a>");
		out.println("</td>");
		out.println("</tr>");
		
		
		out.println("</table>");
		out.println("</body>");
		out.println("</html");
	}

}
