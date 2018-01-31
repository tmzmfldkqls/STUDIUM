package com.st.bbs.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.st.action.Action;
import com.st.studygroup.model.BbsGroupDto;
import com.st.studygroup.model.BoardListDto;
import com.st.studygroup.service.BbsServiceImpl;

public class BbsListAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<BoardListDto> bdlist = (List<BoardListDto>) session.getAttribute("groupInfo");
		int SNO = bdlist.get(1).getSNO();
		String path = "/main/login.jsp";
		List<BbsGroupDto> list = BbsServiceImpl.getBbsService().bbsList(SNO);
		if(list != null) {
			request.setAttribute("bbsList", list);
			path = "/studyGroupKing/StudyGroupKingStorage.jsp";
		}
		return path;
	}

}
