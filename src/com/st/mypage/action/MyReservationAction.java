package com.st.mypage.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.st.action.Action;
import com.st.member.model.MemberDto;
import com.st.mypage.service.MyPageServiceImpl;

public class MyReservationAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto)session.getAttribute("userInfo"); 
		int mno = memberDto.getMNO();
		
		List<Map<String,String>> list = MyPageServiceImpl.getMyPageService().myReservation(mno);
		
		request.setAttribute("reservationList", list);
		return "/room/mypage/myReservation.jsp";
	}

}
