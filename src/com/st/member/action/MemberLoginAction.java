package com.st.member.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.st.action.Action;
import com.st.common.dao.CommonDaoImpl;
import com.st.member.model.MemberDto;
import com.st.member.service.MemberService;
import com.st.member.service.MemberServiceImpl;

public class MemberLoginAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/main/login.jsp";
		String root = request.getContextPath();
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		MemberDto memberDto = MemberServiceImpl.getMemberService().login(id, pass);
		if(memberDto != null ) {
			String idsv = request.getParameter("idsv");
			if("saveid".equals(idsv)) {
				Cookie cookie = new Cookie("nid_sid",id);
				cookie.setPath(root);
				cookie.setMaxAge(60 * 60 * 24 * 365 * 50);
				response.addCookie(cookie);
			} else {
				Cookie cookie[] = request.getCookies();
                if(cookie != null){
                   int len = cookie.length;
                   for(int i=0; i<len; i++){
                      if("nid_sid".equals(cookie[i].getName())){
                         cookie[i].setMaxAge(0);
//                         cookie[i].setPath(root);
                         response.addCookie(cookie[i]);
                         break;
                      }
                   }
                }
			}
			CommonDaoImpl.getCommonDao().updateLNUM(memberDto.getMNO());
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", memberDto);
			System.out.println("status : " + memberDto.getM_STATUS());
			
			path = "/main/main.jsp";
			
		} else {
			path = "/main/loginfail.jsp";
		}
		return path;
	}

}
