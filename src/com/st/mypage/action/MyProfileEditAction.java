package com.st.mypage.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.st.action.Action;
import com.st.member.model.MemberDto;
import com.st.mypage.service.MyPageServiceImpl;

public class MyProfileEditAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = "";
		
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		//정보 등록
		
		if(memberDto != null) {
			
			memberDto.setM_PASS(request.getParameter("password"));
			memberDto.setM_NAME(request.getParameter("name"));
			memberDto.setM_EMAIL(request.getParameter("email"));
			memberDto.setM_TAG(request.getParameter("tag"));
			memberDto.setM_TEL(request.getParameter("password"));
			//일단 멤버 Dto 를 셋팅해 줘야 함
			//mno포함 나머지 것들은 어차피 memberDto 안에 session 대입하면서 자동으로 들어가 있음 
			
			int cnt = MyPageServiceImpl.getMyPageService().updateProfile(memberDto);
			
			if(cnt!=0){
				//일단 room_main으로 가게는 해 놓는데 나중에 ok 페이지 만든 다음에 거기로 연결할 것.
				path = "/main/main.jsp";
			}else{
				session.invalidate();
				path = "/main/login.jsp";
			}
		}
		
		return path;
	}

}
