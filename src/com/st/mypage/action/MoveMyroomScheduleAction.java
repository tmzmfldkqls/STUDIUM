package com.st.mypage.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.st.action.Action;
import com.st.mypage.service.MyPageServiceImpl;
import com.st.studyroom.model.RmAlbDto;
import com.st.studyroom.model.StudyRoomDto;
import com.st.studyroom.service.StudyRoomServiceImpl;
import com.st.util.NullCheck;

public class MoveMyroomScheduleAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int spno = NullCheck.nullToZero((request.getParameter("spno")));
		
		if(spno != 0) {
			List<StudyRoomDto> list = MyPageServiceImpl.getMyPageService().getRooms(spno);	
			request.setAttribute("pickedrooms", list);			
		
		if(list !=null){
				return "/room/mypage/roomSchedule.jsp";
			}
		}
		return "/main/login.jsp";
	}

}
