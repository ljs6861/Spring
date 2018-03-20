package kr.bit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemoDAO;
import kr.bit.model.MemoVO;

public class MemoController {	//POJO의 형태  <--interface(x)

	// mList.mo -----▼
	//@RequestMapping("/mList.mo")
public String memoList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemoDAO dao=new MemoDAO();
		List<MemoVO> list=dao.memoList();
		
		request.setAttribute("list", list);
		
		// memoList.jsp --> forward(요청의뢰)
//		RequestDispatcher rd=request.getRequestDispatcher("memo/memoList.jsp");
//		rd.forward(request, response);
		String nextPage="/WEB-INF/memo/memoList.jsp";
		return nextPage;
		
	}

	
// mInsert.mo -----▼
//@RequestMapping("/mInsert.mo")
public String memoInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	request.setCharacterEncoding("euc-kr");
	
	String mname=request.getParameter("mname");
	String mcontent=request.getParameter("mcontent");
	
	MemoVO vo=new MemoVO(mname, mcontent);
	MemoDAO dao=new MemoDAO();
	int cnt=dao.memoInsert(vo);
	String nextPage=null;
	
	if(cnt>0){
		//response.sendRedirect("mList.mo"); // sendRedirect는 다시가기
		nextPage="redirect:mList.mo";
	}
	return nextPage;
}



}
