package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemoMybatisDAO;
import kr.bit.model.MemoVO;
public class MemoInsertController implements Controller {
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		
		String mname=request.getParameter("mname");
		String mcontent=request.getParameter("mcontent");
		
		MemoVO vo=new MemoVO(mname, mcontent);
		vo.setMname(mname);
		vo.setMcontent(mcontent);
		
		MemoMybatisDAO  dao=new MemoMybatisDAO();
		
		int cnt=dao.memoInsert(vo);
		
		String nextPage=null;
		
		if(cnt>0){
			//response.sendRedirect("mList.mo"); // sendRedirect는 다시가기
			nextPage="redirect:mList.mo";
		}
		return nextPage;
	}
}
