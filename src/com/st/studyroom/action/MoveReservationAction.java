package com.st.studyroom.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.st.action.Action;
import com.st.studyroom.model.*;
import com.st.studyroom.service.StudyRoomServiceImpl;
import com.st.util.NullCheck;

public class MoveReservationAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int spno = NullCheck.nullToZero((request.getParameter("spno")));
		
		HttpSession session = request.getSession();
		session.setAttribute("spnoForRsv", spno);
		
		if(spno != 0) {
			List<StudyRoomDto> list = StudyRoomServiceImpl.getStudyRoomService().pickSpace(spno);	
			request.setAttribute("picked", list);
			
			List<RmAlbDto> imgList = StudyRoomServiceImpl.getStudyRoomService().pickImages(spno);
			request.setAttribute("pickedImg", imgList);
			
			if(list !=null){
				return "/room/reservation/roomReservation.jsp";
			}
		}
		return "/main/login.jsp";
	}

}
