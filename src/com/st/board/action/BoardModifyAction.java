package com.st.board.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.st.action.Action;
import com.st.member.model.MemberDto;
import com.st.studygroup.model.BoardDto;
import com.st.studygroup.model.BoardListDto;
import com.st.studygroup.service.BoardServiceImpl;

public class BoardModifyAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/main/login.jsp";
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		List<BoardListDto> bdlist = (List<BoardListDto>) session.getAttribute("groupInfo");
		int WNO = Integer.parseInt(request.getParameter("WNO"));
		BoardDto boardDto = new BoardDto();
		boardDto.setWNO(WNO);
		boardDto.setBNO(bdlist.get(0).getBNO());
		boardDto.setSNO(bdlist.get(0).getSNO());
		boardDto.setW_ID(memberDto.getM_ID());
		boardDto.setW_NAME(memberDto.getM_NAME());
		boardDto.setW_TITLE(request.getParameter("subject"));
		boardDto.setW_CONTENT(request.getParameter("content"));
		if(WNO != 0) {
			BoardServiceImpl.getBoardService().modifyArticle(boardDto);
			path = "/bc?act=listnotice";
		}
		return path;
	}

}
