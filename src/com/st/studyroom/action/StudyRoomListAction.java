package com.st.studyroom.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.st.action.Action;
import com.st.studyroom.model.StudySpaceDto;
import com.st.studyroom.service.StudyRoomServiceImpl;
import com.st.util.StringEncoder;

public class StudyRoomListAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		String key = StringEncoder.isoToEuc(request.getParameter("key"));
		String  word = StringEncoder.isoToEuc(request.getParameter("word"));
		
		List<StudySpaceDto> list = StudyRoomServiceImpl .getStudyRoomService().spacelist(key,word);
		
		request.setAttribute("spacelist", list);
		
		return "/room/main/room_main.jsp";
	}

}
