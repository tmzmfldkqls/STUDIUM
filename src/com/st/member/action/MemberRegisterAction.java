package com.st.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.st.action.Action;
import com.st.member.model.MemberDto;
import com.st.member.service.MemberServiceImpl;
import com.st.util.PageMove;

public class MemberRegisterAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = "/main/login.jsp";
		MemberDto memberDto = new MemberDto();
		memberDto.setM_ID(request.getParameter("id"));
		memberDto.setM_NAME(request.getParameter("name"));
		memberDto.setM_PASS(request.getParameter("pass"));
		memberDto.setM_EMAIL(request.getParameter("email"));
		memberDto.setM_TEL(request.getParameter("tel"));
		memberDto.setM_TAG(request.getParameter("hashtag"));
		int cnt = MemberServiceImpl.getMemberService().registerMember(memberDto);
		if(cnt !=0 ) {
			request.setAttribute("userInfo", memberDto);
			path = "/main/registerok.jsp";
		}			
		return path;
	}

}
