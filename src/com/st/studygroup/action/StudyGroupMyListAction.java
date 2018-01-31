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

public class StudyGroupMyListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		String path = "/main/login.jsp";
		List<StudyGroupDto> listMyArticle = StudyGroupServiceImpl.getStudyGroupService().listmyArticle(memberDto);
		if(listMyArticle != null) {
			request.setAttribute("listmyarticle", listMyArticle);
			path = "/studygroupmain/studygroupimake.jsp";
		}
		return path;
	}

}
