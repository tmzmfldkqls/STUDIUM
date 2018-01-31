package com.st.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.st.action.Action;
import com.st.member.model.MemberDto;
import com.st.member.service.MemberServiceImpl;
import com.st.util.MailSend;

public class MemberFindpwdAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/main/login.jsp";
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		MemberDto memberDto = MemberServiceImpl.getMemberService().findpwd(id, email);
		if(memberDto != null ) {
			System.out.println("memberDto memberemail: " + memberDto.getM_EMAIL());
			try {
				MailSend mail = new MailSend(memberDto.getM_EMAIL());
				MemberServiceImpl.getMemberService().updatepwd(memberDto.getMNO(), mail.getTmp_pwd());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("userInfo", memberDto);
			path = "/main/findpwd.jsp";
		}else {
			path = "/main/loginfail.jsp";
		}
		return path;
	}	

}
