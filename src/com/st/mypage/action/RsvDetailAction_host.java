package com.st.mypage.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.st.action.Action;
import com.st.mypage.service.MyPageServiceImpl;
import com.st.studyroom.model.ReservationDto;

public class RsvDetailAction_host implements Action {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		int rmrno = Integer.parseInt(request.getParameter("rmrno"));
		ReservationDto reservationDto = MyPageServiceImpl.getMyPageService().myReservationDetail(rmrno);
		

		request.setAttribute("reservationDetail", reservationDto);
		
		return null;
	}

}
