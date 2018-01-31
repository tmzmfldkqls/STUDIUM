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
import com.st.studygroup.model.StudyGroupApplyDto;
import com.st.studygroup.model.StudyGroupMemberDto;
import com.st.studygroup.service.GroupMemberServiceImpl;

public class GroupMemberApplyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/main/login.jsp";
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if (memberDto != null) {
			List<BoardListDto> bdlist = (List<BoardListDto>) session.getAttribute("groupInfo");
			int SNO = bdlist.get(0).getSNO();
			System.out.println(">>>>"+ SNO);
			List<StudyGroupApplyDto> alist = GroupMemberServiceImpl.getGroupMemberService().studyGroupApply(SNO);
			List<StudyGroupMemberDto> mlist = GroupMemberServiceImpl.getGroupMemberService().studyGroupMember(SNO);
			if (alist != null) {
				request.setAttribute("alist", alist);
				request.setAttribute("mlist", mlist);
				path = "/studyGroupKing/StudyGroupKingApplyMemberView.jsp";
			}
		}
		return path;
	}
}
