package com.st.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.st.factory.MemberActionFactory;
import com.st.member.model.MemberDto;
import com.st.member.service.MemberServiceImpl;
import com.st.util.PageMove;
import com.st.util.StringEncoder;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		String path = "/main/login.jsp";
		if("memberregister".equals(act)) {
			path = MemberActionFactory.getMemberRegisterAction().execute(request, response);
			PageMove.forward(request, response, path);		
		}else if("login".equals(act)) {
			path = MemberActionFactory.getMemberLoginAction().execute(request, response);
			PageMove.redirect(request, response, path);
		}else if("findid".equals(act)) {
			path = MemberActionFactory.getMemberFindidAction().execute(request, response);
			PageMove.forward(request, response, path);
		}else if("findpwd".equals(act)) {
			path = MemberActionFactory.getMemberFindpwdAction().execute(request, response);
			PageMove.forward(request, response, path);
		}else if("mvroomsearch".equals(act)) {
			PageMove.redirect(request, response, "/main/room_search.jsp");
		}else if("idcheck".equals(act)) {
			String id = StringEncoder.isoToEuc(request.getParameter("id"));
			int idcount = MemberServiceImpl.getMemberService().idCheck(id);
			response.setContentType("text/plain;charset=EUC-KR");
			PrintWriter out = response.getWriter();
			out.println(idcount + "," + id);
		}else if("logout".equals(act)) {
			HttpSession session = request.getSession();
			session.removeAttribute("userInfo");
			PageMove.redirect(request, response, path);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}

}
