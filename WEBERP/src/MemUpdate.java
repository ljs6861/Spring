

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.mem.MemberDAO;
import kr.bit.mem.MemberVO;


@WebServlet("/memUpdate")
public class MemUpdate extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		request.setCharacterEncoding("euc-kr");  // ��
		
		
		//form���� �Ѿ�� parameter�� �޴� �۾�
//		String irum=request.getParameter("irum");
		int num=Integer.parseInt(request.getParameter("num"));
		int age=Integer.parseInt(request.getParameter("age"));
		String email=request.getParameter("email");
		String intro=request.getParameter("intro");
		//MemberVO�� �������(��������)
		
		MemberVO vo=new MemberVO();
		
		vo.setNum(num);
		vo.setAge(age);
		vo.setEmail(email);
		vo.setIntro(intro);
		
		MemberDAO dao = new MemberDAO();
		int cnt=dao.memUpdate(vo);
	
		
		if(cnt>0){

			response.sendRedirect("memList");
			
		}else{
			throw new ServletException("update fail!");
		}
		
	}

}
