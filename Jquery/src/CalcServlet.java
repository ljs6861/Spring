

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.bit.mem.MemberVO;


@WebServlet("/cs.do")
public class CalcServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int su1=Integer.parseInt(request.getParameter("su1"));
//		int su2=Integer.parseInt(request.getParameter("su2"));
//		int sum=0;
//		
//		for(int i=su1; i<=su2; i++){
//			sum+=i;
//		}
	//회원정보만 내려주니까 잠시 주석처리	
		
		
	
		MemberVO vo= new MemberVO();
		vo.setNum(1);
		vo.setIrum("이길동");
		vo.setAge(20);
		vo.setEmail("bit@com");
		vo.setIntro("자기소개");
		
		List<MemberVO> list= new ArrayList<MemberVO>();
		list.add(vo);
		list.add(vo);
		list.add(vo);
		list.add(vo);
		list.add(vo);
		
		//JSON 구조의  형태로 전송해주면 된다. [{ },{ },{ }, { }, { }]
		
		Gson g=new Gson();
		String json = g.toJson(list);
		
		response.setContentType("text/json;charset=utf-8");
		
		PrintWriter out= response.getWriter();
		out.print(json);
		//sucess: resultHtml(data)
	}

}
