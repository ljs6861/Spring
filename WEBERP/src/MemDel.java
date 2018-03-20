

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.mem.MemberDAO;
import kr.bit.mem.MemberVO;

@WebServlet("/memDel")
// ?num=1
public class MemDel extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		int num= Integer.parseInt(request.getParameter("num"));
		
		
		MemberDAO dao= new MemberDAO();
		int cnt=dao.memDel(num);
		
		
		if(cnt>0){
//			out.println("succescc!!");
			response.sendRedirect("memList");
			
		}else{
			throw new ServletException("fail!!");
		}
	}

}
