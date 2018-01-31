package com.st.studyroom.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.st.action.Action;
import com.st.studyroom.model.RmAlbDto;
import com.st.studyroom.model.StudyRoomDto;
import com.st.studyroom.service.StudyRoomServiceImpl;
import com.st.util.NullCheck;

public class MoveReservationDetailAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int rmno = NullCheck.nullToZero((request.getParameter("selectedRoom")));
		
		HttpSession session = request.getSession();
		session.setAttribute("rmnoForRsv", rmno);

		return "/room/reservation/roomReservationSubmit.jsp";
	}

}
