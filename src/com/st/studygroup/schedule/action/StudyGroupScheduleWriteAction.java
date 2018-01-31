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

public class StudyGroupScheduleWriteAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/main/login.jsp";
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		List<BoardListDto> bdlist = (List<BoardListDto>) session.getAttribute("groupInfo");
		if(memberDto != null) {
			StudyGroupScheduleDto studyGroupScheduleDto = new StudyGroupScheduleDto();
			studyGroupScheduleDto.setST_DATE_IN(request.getParameter("date"));
			studyGroupScheduleDto.setST_DATE_OUT(request.getParameter("date"));
			studyGroupScheduleDto.setSNO(bdlist.get(0).getSNO());
			studyGroupScheduleDto.setST_NAME(request.getParameter("scheduleName"));
			studyGroupScheduleDto.setST_CONTENT(request.getParameter("scheduleContent"));
			int cnt = ScheduleServiceImpl.getScheduleService().registerSchedule(studyGroupScheduleDto);
			if(cnt != 0) {
				request.setAttribute("registerSchedule", studyGroupScheduleDto);
				path = "/groupschedule?act=mvmygroupschedule";
			}
		}
		return path;
	}

}
