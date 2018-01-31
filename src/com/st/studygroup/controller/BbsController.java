package com.st.studygroup.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.st.factory.StudyGroupActionFactory;
import com.st.util.NullCheck;
import com.st.util.PageMove;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Servlet implementation class BbsController
 */
@WebServlet("/bbs")
public class BbsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/main/login.jsp";
		String act = request.getParameter("act");
		 
		 
		if("mvmygroupbbs".equals(act)) {
			path = StudyGroupActionFactory.getBbsListAction().execute(request, response);
			PageMove.forward(request, response, path);
		}else if("mvmemberbbs".equals(act)) {
			path = StudyGroupActionFactory.getMemberBbsListAction().execute(request, response);
			PageMove.forward(request, response, path);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}

}
