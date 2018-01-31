package com.st.studygroup.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.st.action.Action;
import com.st.member.model.MemberDto;
import com.st.studygroup.model.StudyGroupApplyDto;
import com.st.studygroup.service.StudyGroupServiceImpl;
import com.st.util.StringEncoder;

public class StudyGroupApplyAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/main/login.jsp";
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		String id = memberDto.getM_ID();
		int SNO = Integer.parseInt(request.getParameter("SNO"));
		StudyGroupApplyDto studyGroupApplyDto = new StudyGroupApplyDto();
		studyGroupApplyDto.setAP_ID(memberDto.getM_ID());
		studyGroupApplyDto.setMNO(memberDto.getMNO());
		studyGroupApplyDto.setSNO(SNO);
		studyGroupApplyDto.setAP_CONTENT(request.getParameter("introduce"));
		int cnt = StudyGroupServiceImpl.getStudyGroupService().studyGroupApply(studyGroupApplyDto);
		if(cnt != 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('스터디 신청이 완료되었습니다.');history.go(-2);</script>");
			out.flush(); 
		}
		return path;
	}
}
