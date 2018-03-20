

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

										  //    ↓ irum, age, email, intro
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//form에서 넘어온 한글정보를 깨지지않게 하는 작업을 먼저 해야한다.
		request.setCharacterEncoding("euc-kr");  // ★
		
		
		//form에서 넘어온 parameter를 받는 작업
		String irum=request.getParameter("irum");
		int age=Integer.parseInt(request.getParameter("age"));
		String email=request.getParameter("email");
		String intro=request.getParameter("intro");
		//MemberVO에 담아주자(묶어주자)
		
		MemberVO vo=new MemberVO();
		
		vo.setIrum(irum);
		vo.setAge(age);
		vo.setEmail(email);
		vo.setIntro(intro);
		
		//DataBase에 저장 해보자 : Model과 연동(MemberDAO)
		
		
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
