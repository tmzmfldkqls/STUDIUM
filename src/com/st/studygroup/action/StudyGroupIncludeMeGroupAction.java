package com.st.studygroup.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.st.action.Action;
import com.st.studygroup.model.BoardDto;
import com.st.studygroup.model.BoardListDto;
import com.st.studygroup.service.StudyGroupServiceImpl;

public class StudyGroupIncludeMeGroupAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/main/login.jsp";
		int SNO = Integer.parseInt(request.getParameter("SNO"));
		List<BoardListDto> bdlist= StudyGroupServiceImpl.getStudyGroupService().myGroupContent(SNO);
		List<BoardDto> list = StudyGroupServiceImpl.getStudyGroupService().notice(SNO);
		if(bdlist != null && list != null) {
			HttpSession session = request.getSession();
			session.setAttribute("groupInfo",bdlist);
			request.setAttribute("enternotice", list);
			path = "/studyGroupMember/StudyGroupMemberNotice.jsp";
		}
		return path;
	}
}
