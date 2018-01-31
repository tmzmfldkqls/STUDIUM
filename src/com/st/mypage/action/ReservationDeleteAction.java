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

public class ReservationDeleteAction  implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int rmrno = Integer.parseInt(request.getParameter("rmrno"));
		
		int cnt = MyPageServiceImpl.getMyPageService().reservationDelete(rmrno);
		
		
		if(cnt != 0)
			return "/mypage?act=mypageMain";
		else{
			return "/room/mypage/error.jsp";
		}
	}

}
