package kr.co.bit;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.bit.model.MemoMybatisDAO;
import kr.bit.model.MemoVO;

@Controller
public class MemoController {

	@Inject
	private MemoMybatisDAO dao;

	@RequestMapping("/mList")
	public String memoList(Model model) throws ServletException, IOException {

		// MemoDAO dao=new MemoDAO();
		List<MemoVO> list = dao.memoList();

		model.addAttribute("list", list);

		// String nextPage="/WEB-INF/memo/memoList.jsp";
		return "memoList";
	}

	@RequestMapping("/mContent")
	public String memoContent(Model model, int mnum) throws ServletException, IOException {

		// MemoDAO dao=new MemoDAO();
		MemoVO vo = dao.memoContent(mnum); // 4 --> [mnum,mname,mcontent]
		model.addAttribute("vo", vo);

		return "memoContent";
	}

	@RequestMapping("/mDelete")
	public String memoDelete(int mnum) throws ServletException, IOException {

		// MemoDAO dao = new MemoDAO();
		int cnt = dao.memoDelete(mnum);

		String nextPage = null;

		// response.sendRedirect("mList.mo");
		nextPage = "redirect:/mList";

		return nextPage; // 참이면 redirect로 거짓이면 null

	}

	@RequestMapping("/mInsertForm")
	public String memoInsertForm() throws ServletException, IOException {

		// String nextPage="memoInsert";

		return "memoInsert";
	}

	@RequestMapping("/mInsert")
	public String memoInsert(MemoVO vo) throws ServletException, IOException {

		// MemoDAO dao=new MemoDAO();

		int cnt = dao.memoInsert(vo);

		String nextPage = null;

		// response.sendRedirect("mList.mo"); // sendRedirect는 다시가기
		nextPage = "redirect:/mList";

		return nextPage;
	}

	@RequestMapping("/mUpdateForm")
	public String memoUpdateForm(Model model, int mnum) throws ServletException, IOException {

		// MemoDAO dao = new MemoDAO();
		MemoVO vo = dao.memoContent(mnum);
		model.addAttribute("vo", vo);
		// ${vo.mnum}
		// RequestDispatcher
		// rd=request.getRequestDispatcher("memo/memoUpdate.jsp");
		// rd.forward(request, response);

		// String nextPage="/WEB-INF/memo/memoUpdate.jsp";
		return "memoUpdate";

	}

	@RequestMapping("/mUpdate")
	public String memoUpdate(MemoVO vo) throws ServletException, IOException {

		// MemoDAO dao= new MemoDAO();
		int cnt = dao.memoUpdate(vo);

		String nextPage = null;

		// response.sendRedirect("mList.mo");
		nextPage = "redirect:/mList";

		return nextPage;
	}

}
