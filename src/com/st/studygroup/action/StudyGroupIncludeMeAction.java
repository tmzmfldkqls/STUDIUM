package com.st.studygroup.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.st.action.Action;
import com.st.member.model.MemberDto;
import com.st.studygroup.model.StudyGroupDto;
import com.st.studygroup.service.StudyGroupServiceImpl;

public class StudyGroupIncludeMeAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/main/login.jsp";
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if (memberDto != null) {
			List<StudyGroupDto> includeMeList = StudyGroupServiceImpl.getStudyGroupService().includeMeList(memberDto);
			if (includeMeList != null) {
				request.setAttribute("includemelist", includeMeList);
				path = "/studygroupmain/studygroupincludeme.jsp";
			}
		}
		return path;
	}

}
