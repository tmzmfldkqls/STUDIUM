package com.st.studygroup.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.st.factory.StudyGroupActionFactory;
import com.st.util.PageMove;

@WebServlet("/groupschedule")
public class StudyGroupScheduleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		String path = "/main/login.jsp";
		if("mvmygroupschedule".equals(act)) {
			path = StudyGroupActionFactory.getStudyGroupScheduleListAction().execute(request, response);
			PageMove.forward(request, response, path);
		}else if("mvregister".equals(act)) {
			path = "/studyGroupKing/StudyGroupKingScheduleRegister.jsp";
			PageMove.redirect(request, response, path);
		}else if("registerschedule".equals(act)) { 
			System.out.println(">>>>>>>>"+ act);
			path = StudyGroupActionFactory.getStudyGroupScheduleWriteAction().execute(request, response);
			PageMove.forward(request, response, path);
		}else if("viewSchedulelist".equals(act)) {
			System.out.println(">>>>>>>>"+ act);
			path = StudyGroupActionFactory.getStudyGroupKingScheduleListXml().execute(request, response);
			PageMove.forward(request, response, path);
		}else if("mvmemberschedule".equals(act)) { 
			System.out.println(">>>>>>>>"+ act);
			path = StudyGroupActionFactory.getMemberStudyGroupScheduleListAction().execute(request, response);
			PageMove.forward(request, response, path);
		}else if("todayschedule".equals(act)) { 
			System.out.println(">>>>>>>>"+ act);
			path = StudyGroupActionFactory.getStudyGroupTodayScheduleListXml().execute(request, response);
			PageMove.forward(request, response, path);
		}else if("memberViewSchedulelist".equals(act)) { 
			System.out.println(">>>>>>>>"+ act);
			path = StudyGroupActionFactory.getMemberStudyGroupScheduleListXml().execute(request, response);
			PageMove.forward(request, response, path);
		}else if("membertodayschedule".equals(act)) { 
			System.out.println(">>>>>>>>"+ act);
			path = StudyGroupActionFactory.getMemberStudyGroupTodayScheduleListXml().execute(request, response);
			PageMove.forward(request, response, path);
		}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}

}
