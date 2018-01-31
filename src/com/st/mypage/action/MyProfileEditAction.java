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
		//���� ���
		
		if(memberDto != null) {
			
			memberDto.setM_PASS(request.getParameter("password"));
			memberDto.setM_NAME(request.getParameter("name"));
			memberDto.setM_EMAIL(request.getParameter("email"));
			memberDto.setM_TAG(request.getParameter("tag"));
			memberDto.setM_TEL(request.getParameter("password"));
			//�ϴ� ��� Dto �� ������ ��� ��
			//mno���� ������ �͵��� ������ memberDto �ȿ� session �����ϸ鼭 �ڵ����� �� ���� 
			
			int cnt = MyPageServiceImpl.getMyPageService().updateProfile(memberDto);
			
			if(cnt!=0){
				//�ϴ� room_main���� ���Դ� �� ���µ� ���߿� ok ������ ���� ������ �ű�� ������ ��.
				path = "/main/main.jsp";
			}else{
				session.invalidate();
				path = "/main/login.jsp";
			}
		}
		
		return path;
	}

}
