package com.st.studygroup.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.st.action.Action;
import com.st.studygroup.model.BoardListDto;
import com.st.studygroup.model.StudyGroupDto;
import com.st.studygroup.service.StudyGroupServiceImpl;

public class StudyGroupMoveModifyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/main/login.jsp";
		int SNO = Integer.parseInt(request.getParameter("SNO"));
		if(SNO != 0) {
			StudyGroupDto studyGroupDto = StudyGroupServiceImpl.getStudyGroupService().viewGroupContent(SNO);
			request.setAttribute("modifyviewgroup", studyGroupDto);
			System.out.println("modifyviewgroup SNO >>>>>" + studyGroupDto.getSNO());
			path = "/studyGroupKing/studygroupmodify.jsp?studyGroupDto"+studyGroupDto;
		}
		return path;
	}

}
