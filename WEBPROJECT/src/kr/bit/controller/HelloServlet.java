package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.mem.Helper;

// JavaEE�� �⺻ ��� sevlect �ڡڡڡڡ�
public class HelloServlet extends HttpServlet {		// ���� (������ �����Ǵ� 100% �ڹٷε� �����α׷���)
	// JavaEE ->service, doGet, doPost
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		
		Helper h = new Helper();
		int sum=h.hap();
		// ���� sum�� ���� ��û�� Ŭ���̾�Ʈ���� �������ָ� �ȴ�.
		
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.print(sum);
		out.println("</body>");
		out.println("</html>");
		
	}
}

/* http://127.0.0:8000/wep/WEB-INF/classes/kr/bit.controller/HelloServlet
   1. WEB-INF ��ΰ� ���� ���丮 �̹Ƿ� ���ٺҰ�
   2. /WEB-INF/classes/bit.controller/HelloServlet : ��û��� ���.
   3.             "                                : ��û��ΰ� ����ȴ�.
 */
