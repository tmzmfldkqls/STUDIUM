package com.st.groupmember.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.st.action.Action;
import com.st.member.model.MemberDto;
import com.st.studygroup.model.BoardListDto;
import com.st.studygroup.model.StudyGroupApplyDto;
import com.st.studygroup.model.StudyGroupDto;
import com.st.studygroup.model.StudyGroupMemberDto;
import com.st.studygroup.service.GroupMemberServiceImpl;
import com.st.studygroup.service.StudyGroupServiceImpl;

public class GroupMemberListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/main/login.jsp";
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if (memberDto != null) {
			List<BoardListDto> bdlist = (List<BoardListDto>) session.getAttribute("groupInfo");
			int SNO = bdlist.get(0).getSNO();
			List<StudyGroupDto> klist = GroupMemberServiceImpl.getGroupMemberService().studyGroupKing(SNO);
			
			if (klist != null) {
				request.setAttribute("klist", klist);
				path = "/studyGroupKing/StudyGroupKingMemberView.jsp";
			}
		}
		return path;
	}

}
