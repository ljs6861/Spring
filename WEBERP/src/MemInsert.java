

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.mem.MemberDAO;
import kr.bit.mem.MemberVO;


@WebServlet("/memInsert")
public class MemInsert extends HttpServlet {

										  //    �� irum, age, email, intro
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//form���� �Ѿ�� �ѱ������� �������ʰ� �ϴ� �۾��� ���� �ؾ��Ѵ�.
		request.setCharacterEncoding("euc-kr");  // ��
		
		
		//form���� �Ѿ�� parameter�� �޴� �۾�
		String irum=request.getParameter("irum");
		int age=Integer.parseInt(request.getParameter("age"));
		String email=request.getParameter("email");
		String intro=request.getParameter("intro");
		//MemberVO�� �������(��������)
		
		MemberVO vo=new MemberVO();
		
		vo.setIrum(irum);
		vo.setAge(age);
		vo.setEmail(email);
		vo.setIntro(intro);
		
		//DataBase�� ���� �غ��� : Model�� ����(MemberDAO)
		
		
		MemberDAO dao= new MemberDAO();
		int cnt=dao.memInsert(vo);
		PrintWriter out = response.getWriter();
		
		if(cnt>0){
//			out.println("succescc!!");
			response.sendRedirect("memList");
			
		}else{
			out.println("fail");
		}
	}

}
