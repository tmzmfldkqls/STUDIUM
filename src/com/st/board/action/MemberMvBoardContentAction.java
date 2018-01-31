package com.st.board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.st.action.Action;
import com.st.studygroup.model.BoardDto;
import com.st.studygroup.service.BoardServiceImpl;

public class MemberMvBoardContentAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/main/login.jsp";
		int WNO = Integer.parseInt(request.getParameter("WNO"));
		if(WNO != 0) {
			BoardDto boardDto = BoardServiceImpl.getBoardService().viewArticle(WNO);
			request.setAttribute("viewboardcontent", boardDto);
			path = "/studyGroupMember/StudyGroupMemberNoticeContent.jsp";
		}
		return path;
	}

}
