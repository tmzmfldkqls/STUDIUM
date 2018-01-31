package com.st.studygroup.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.st.factory.StudyGroupActionFactory;
import com.st.util.PageMove;


@WebServlet("/gmc")
public class GroupMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/main/login.jsp";
		String act = request.getParameter("act");
		if("mvmymember".equals(act)) {
			System.out.println(">>>>>>>>"+act);
			path = StudyGroupActionFactory.getGroupMemberListAction().execute(request, response);
			PageMove.forward(request, response, path);
		}else if("applymember".equals(act)) {
			System.out.println(">>>>>>>>"+act);
			path = StudyGroupActionFactory.getGroupMemberApplyAction().execute(request, response);
			PageMove.forward(request, response, path);
		}else if("acceptmember".equals(act)) {
			System.out.println(">>>>>>>>"+act);
			path = StudyGroupActionFactory.getGroupMemberAcceptAction().execute(request, response);
			PageMove.forward(request, response, path);
		}else if("mvmemberviewmember".equals(act)) {
			System.out.println(">>>>>>>>"+act);
			path = StudyGroupActionFactory.getMemberGroupListAction().execute(request, response);
			PageMove.forward(request, response, path);
		}else if("memberapplymember".equals(act)) {
			System.out.println(">>>>>>>>"+act);
			path = StudyGroupActionFactory.getMemberGroupMemberViewAction().execute(request, response);
			PageMove.forward(request, response, path);
		}else if("mvmemberout".equals(act)) {
			System.out.println(">>>>>>>>"+act);
			path = StudyGroupActionFactory.getMemberMoveOut().execute(request, response);
			PageMove.forward(request, response, path);
		}else if("memberout".equals(act)) { 
			System.out.println(">>>>>>>>"+act);
			path = StudyGroupActionFactory.getMemberOutAction().execute(request, response);
			PageMove.redirect(request, response, path);
		}else if("refusemember".equals(act)) { 
			System.out.println(">>>>>>>>"+act);
			path = StudyGroupActionFactory.getGroupMemberRefuseMemberAction().execute(request, response);
			PageMove.forward(request, response, path);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}

}
