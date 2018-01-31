package com.st.studygroup.schedule.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.st.action.Action;
import com.st.studygroup.model.BoardListDto;
import com.st.studygroup.model.StudyGroupScheduleDto;
import com.st.studygroup.service.ScheduleServiceImpl;

public class StudyGroupScheduleListAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<BoardListDto> bdlist = (List<BoardListDto>) session.getAttribute("groupInfo");
		String path = "/main/login.jsp";
		int SNO = bdlist.get(0).getSNO();
		List<StudyGroupScheduleDto> list = ScheduleServiceImpl.getScheduleService().scheduleList(SNO);
		System.out.println("ActionList =======" + list);
		if(list != null) {
			request.setAttribute("scheduleList", list);
			path = "/studyGroupKing/StudyGroupKingSchedule.jsp?SNO="+SNO;
		}
		return path;
	}

}
