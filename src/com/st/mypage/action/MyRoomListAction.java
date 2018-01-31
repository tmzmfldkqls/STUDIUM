package com.st.mypage.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.st.action.Action;
import com.st.member.model.MemberDto;
import com.st.mypage.service.MyPageServiceImpl;
import com.st.studyroom.model.StudySpaceDto;
import com.st.studyroom.service.StudyRoomServiceImpl;
import com.st.util.StringEncoder;

public class MyRoomListAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		
		int  mno = memberDto.getMNO();
		List<StudySpaceDto> list = MyPageServiceImpl.getMyPageService().myRoomList(mno);
		request.setAttribute("spacelist", list);
		
		return "/room/mypage/myStudyroom.jsp";
	}

}
