package com.st.studyroom.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.st.action.Action;
import com.st.studyroom.model.ZipDto;
import com.st.studyroom.service.StudyRoomServiceImpl;
import com.st.util.PageMove;
import com.st.util.StringEncoder;

public class ZipsearchAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("����ġ �׼� ���� ����");
		String dong = StringEncoder.isoToEuc(request.getParameter("dong"));
//		System.out.println("�˻� �� : " + dong);
		List<ZipDto> list = StudyRoomServiceImpl.getStudyRoomService().zipSearch(dong);
//		System.out.println("�˻��� ���� : " + list.size());//�˻��� ���� : 129
		request.setAttribute("sdong", dong);
		request.setAttribute("ziplist", list);
		
		return "/room/roomInfo/zipsearch.jsp";
	}

}
