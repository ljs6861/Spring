package kr.bit.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemoDAO;
import kr.bit.model.MemoVO;
public class MemoUpdateFormController implements Controller {
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int mnum=Integer.parseInt(request.getParameter("mnum"));
		MemoDAO dao = new MemoDAO();
		MemoVO vo=dao.memoContent(mnum);
		request.setAttribute("vo", vo);
															// ${vo.mnum}
		//RequestDispatcher rd=request.getRequestDispatcher("memo/memoUpdate.jsp");
		//rd.forward(request, response);
		
		String nextPage="/WEB-INF/memo/memoUpdate.jsp";
		return nextPage;
		
	}
}
