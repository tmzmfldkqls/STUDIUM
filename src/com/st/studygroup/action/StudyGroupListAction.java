package com.st.studygroup.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.st.action.Action;
import com.st.common.service.CommonServiceImpl;
import com.st.member.model.MemberDto;
import com.st.studygroup.model.StudyGroupDto;
import com.st.studygroup.service.StudyGroupServiceImpl;
import com.st.util.BoardConstance;
import com.st.util.NullCheck;
import com.st.util.PageNavigation;
import com.st.util.StringEncoder;

public class StudyGroupListAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pg = NullCheck.nullToOne(request.getParameter("pg"));
		String word = StringEncoder.isoToEuc(request.getParameter("word"));
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		String path = "/main/login.jsp";
		List<StudyGroupDto> listArticle = StudyGroupServiceImpl.getStudyGroupService().listArticle(pg , word);
		PageNavigation navigation = CommonServiceImpl.getCommonService().makePageNavigation(pg, word, BoardConstance.BOARD_LIST_SIZE);
		navigation.setRoot(request.getContextPath());
		navigation.setWord(word);
		navigation.setNavigator();
		if(listArticle != null) {
			request.setAttribute("listarticle", listArticle);
			request.setAttribute("navigator", navigation);
			path = "/studygroupmain/studygroupmain.jsp";
		}
		return path;
	}

}
