package com.st.studygroup.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.st.factory.StudyGroupActionFactory;
import com.st.member.model.MemberDto;
import com.st.studygroup.model.BoardListDto;
import com.st.util.PageMove;

@WebServlet("/bc")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		String path = "/main/login.jsp";
		
		if("mvmygroupnoticeregister".equals(act)) {
			path = "/studyGroupKing/StudyGroupKingNoticeRegister.jsp";
			PageMove.forward(request, response, path);
		}else if("newarticle".equals(act)) {
			path = StudyGroupActionFactory.getBoardWriteAction().execute(request, response);
			PageMove.forward(request, response, path);
		}else if("mvmygroupnoticecontent".equals(act)) {
			path = StudyGroupActionFactory.getBoardViewAction().execute(request, response);
			PageMove.forward(request, response, path);
		} else if("mygroupnoticecontentdelete".equals(act)) {
			path = StudyGroupActionFactory.getBoardDeleteAction().execute(request, response);
			PageMove.forward(request, response, path);
		} else if("mygroupcontentmodify".equals(act)) { 
			path = StudyGroupActionFactory.getBoardModifyAction().execute(request, response);
			PageMove.forward(request, response, path);
		}else if("listnotice".equals(act)) {
			path = StudyGroupActionFactory.getBoardListAction().execute(request, response);
			PageMove.forward(request, response, path);
		}else if("memberlistnotice".equals(act)) {
			path = StudyGroupActionFactory.getMemberBoardListAction().execute(request, response);
			PageMove.forward(request, response, path);
		}else if("mvmembernoticecontent".equals(act)) {
			path = StudyGroupActionFactory.getMemberMvBoardContentAction().execute(request, response);
			PageMove.forward(request, response, path);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}

}
