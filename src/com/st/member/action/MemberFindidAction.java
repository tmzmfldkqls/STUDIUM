package com.st.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.st.action.Action;
import com.st.member.model.MemberDto;
import com.st.member.service.MemberServiceImpl;
import com.st.util.StringEncoder;

public class MemberFindidAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/main/login.jsp";
		String name = StringEncoder.isoToEuc(request.getParameter("name"));
		String tel = request.getParameter("tel");
		MemberDto memberDto = MemberServiceImpl.getMemberService().findid(name, tel);
		if(memberDto != null) {
			request.setAttribute("userInfo", memberDto);
			path = "/main/findid.jsp";
		}else {
			System.out.println("≥Œ¿Ã¥Ÿ~~");
		}
		return path;
	}

}
