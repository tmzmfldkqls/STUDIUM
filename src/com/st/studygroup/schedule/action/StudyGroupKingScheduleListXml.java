package com.st.studygroup.schedule.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.st.action.Action;
import com.st.member.model.MemberDto;
import com.st.studygroup.model.BoardListDto;
import com.st.studygroup.model.StudyGroupScheduleDto;
import com.st.studygroup.service.ScheduleServiceImpl;

public class StudyGroupKingScheduleListXml implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		List<BoardListDto> bdlist = (List<BoardListDto>) session.getAttribute("groupInfo");
		String path = "/main/login.jsp";
		if(memberDto != null) {
			int SNO = bdlist.get(0).getSNO();
			String date = request.getParameter("date");
			List<StudyGroupScheduleDto> slist = ScheduleServiceImpl.getScheduleService().viewSchedule(SNO, date);
			if(slist.size() == 0) {
				StudyGroupScheduleDto b = new StudyGroupScheduleDto();
				b.setSNO(0);
				b.setSTNO(0);
				b.setST_DATE_IN(" ");
				b.setST_DATE_OUT(" ");
				b.setST_CONTENT(" ");
				b.setST_NAME(" ");
				slist.add(b);
			}
			request.setAttribute("slist",slist);
			path = "/studyGroupKing/StudyGroupKingScheuleXml.jsp";
		}
		return path;
	}

}
