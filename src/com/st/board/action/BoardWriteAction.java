package com.st.board.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.st.common.service.CommonServiceImpl;
import com.st.member.model.MemberDto;
import com.st.studygroup.model.BoardDto;
import com.st.studygroup.model.BoardListDto;
import com.st.studygroup.service.BoardService;
import com.st.studygroup.service.BoardServiceImpl;
import com.st.action.Action;

public class BoardWriteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		List<BoardListDto> bdlist = (List<BoardListDto>) session.getAttribute("groupInfo");
		String path = "/main/login.jsp";
		BoardDto boardDto = new BoardDto();
		boardDto.setSNO(bdlist.get(0).getSNO());
		boardDto.setBNO(bdlist.get(0).getBNO());
		boardDto.setMNO(memberDto.getMNO());
		boardDto.setW_ID(memberDto.getM_ID());
		boardDto.setW_NAME(memberDto.getM_NAME());
		boardDto.setW_TITLE(request.getParameter("subject"));
		boardDto.setW_CONTENT(request.getParameter("content"));

		int cnt = BoardServiceImpl.getBoardService().writeArticle(boardDto);
		if (cnt != 0) {
			path = "/bc?act=listnotice";
		} 
		return path;

	}

}
