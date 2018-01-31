package com.st.studygroup.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.st.action.Action;
import com.st.studygroup.model.StudyGroupApplyDto;
import com.st.studygroup.model.StudyGroupDto;
import com.st.studygroup.model.StudyGroupMemberDto;
import com.st.studygroup.service.GroupMemberServiceImpl;
import com.st.studygroup.service.StudyGroupServiceImpl;

public class StudyGroupViewAction implements Action {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/main/login.jsp";
		int SNO = Integer.parseInt(request.getParameter("SNO"));
		
		if(SNO != 0) {
			StudyGroupDto studyGroupDto = StudyGroupServiceImpl.getStudyGroupService().viewGroupContent(SNO);
			StudyGroupMemberDto studyGroupMemberDto = GroupMemberServiceImpl.getGroupMemberService().studyGroupMemberCheck(SNO);
			StudyGroupApplyDto studyGroupApplyDto = GroupMemberServiceImpl.getGroupMemberService().studyGroupApplyMember(SNO);
			if(studyGroupMemberDto == null) {
				studyGroupMemberDto = new StudyGroupMemberDto();
				studyGroupMemberDto.setM_ID(" ");
				studyGroupMemberDto.setMNO(0);
			}
			if(studyGroupApplyDto == null) {
				studyGroupApplyDto = new StudyGroupApplyDto();
				studyGroupApplyDto.setAP_ID(" ");
			}
			System.out.println(">>>>" + studyGroupMemberDto.getM_ID());
			System.out.println(">>>>" + studyGroupMemberDto.getMNO());
			System.out.println(">>>>" + studyGroupApplyDto.getAP_ID());
			
			request.setAttribute("membercheck", studyGroupMemberDto);
			request.setAttribute("viewgroup", studyGroupDto);
			request.setAttribute("applyMember", studyGroupApplyDto);
			path = "/studygroupmain/studygroupok.jsp";
		}
		return path;
	}

}
