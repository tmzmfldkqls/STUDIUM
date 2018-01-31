package com.st.board.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.st.action.Action;
import com.st.studygroup.model.BoardDto;
import com.st.studygroup.model.BoardListDto;
import com.st.studygroup.service.BoardServiceImpl;
import com.st.studygroup.service.StudyGroupServiceImpl;

public class BoardListAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/main/login.jsp";
		HttpSession session = request.getSession();
		List<BoardListDto> bdlist = (List<BoardListDto>) session.getAttribute("groupInfo");
		int SNO = bdlist.get(0).getSNO();
		List<BoardDto> list = BoardServiceImpl.getBoardService().noticelist(SNO);
		if (list != null) {
			
			request.setAttribute("enternotice", list);
			path = "/studyGroupKing/StudyGroupKingNotice.jsp";
		}
		return path;
	}
}
