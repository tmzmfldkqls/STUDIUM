package com.st.groupmember.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.st.action.Action;
import com.st.member.model.MemberDto;
import com.st.studygroup.model.BoardListDto;
import com.st.studygroup.model.StudyGroupDto;
import com.st.studygroup.model.StudyGroupMemberDto;
import com.st.studygroup.service.GroupMemberServiceImpl;

public class GroupMemberAcceptAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/main/login.jsp";
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if (memberDto != null) {
			List<BoardListDto> bdlist = (List<BoardListDto>) session.getAttribute("groupInfo");
			StudyGroupMemberDto studyGroupMemberDto = new StudyGroupMemberDto();
			studyGroupMemberDto.setSNO(bdlist.get(0).getSNO());
			studyGroupMemberDto.setM_ID(request.getParameter("apid"));
			studyGroupMemberDto.setMNO(Integer.parseInt(request.getParameter("MNO")));
			int cnt = GroupMemberServiceImpl.getGroupMemberService().registerMember(studyGroupMemberDto);
			if (cnt != 0) {
				request.setAttribute("mlist", studyGroupMemberDto);
				path = "/gmc?act=applymember";
			}
		}
		return path;
	}

}
