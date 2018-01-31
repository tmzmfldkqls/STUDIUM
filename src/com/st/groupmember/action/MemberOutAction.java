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
import com.st.studygroup.service.GroupMemberServiceImpl;

public class MemberOutAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/main/login.jsp";
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if (memberDto != null) {
			List<BoardListDto> bdlist = (List<BoardListDto>) session.getAttribute("groupInfo");
			int SNO = bdlist.get(0).getSNO();
			int MNO = memberDto.getMNO();
			int cnt = GroupMemberServiceImpl.getGroupMemberService().memberout(MNO,SNO);
			if (cnt != 0) {
				path = "/stgcontroll?act=mvgroup";
			}
		}
		return path;
	}

}
