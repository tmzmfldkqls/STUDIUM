package com.st.studygroup.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.st.factory.StudyGroupActionFactory;
import com.st.util.PageMove;


@WebServlet("/reply")
public class ReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		String path = "/main/login.jsp";
		if("replyWrite".equals(act)){
			path = StudyGroupActionFactory.getReplyWriteAction().execute(request, response);
			PageMove.forward(request, response, path);
		}else if("listReply".equals(act)){
			System.out.println("COntroller WNO======"+request.getParameter("WNO"));
			path = StudyGroupActionFactory.getReplyListAction().execute(request, response);
			PageMove.forward(request, response, path);
		}else if("replyDelete".equals(act)){
			path = StudyGroupActionFactory.getReplyDeleteAction().execute(request, response);
			PageMove.forward(request, response, path);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
