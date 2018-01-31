package com.st.studygroup.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.st.factory.StudyGroupActionFactory;
import com.st.studygroup.model.StudyGroupDto;
import com.st.util.NullCheck;
import com.st.util.PageMove;
import com.st.util.StringEncoder;

@WebServlet("/stgcontroll")
public class StudyGroupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		String path = "/main/login.jsp";
		
		if("mvgroup".equals(act)) {
			int pg = Integer.parseInt(request.getParameter("pg"));
			String word = StringEncoder.isoToEuc(request.getParameter("word"));
			String queryString = "pg=" + pg + "&word=" + StringEncoder.urlFormat(word);
			path = StudyGroupActionFactory.getStudyGroupListAction().execute(request, response);
			path += "?" + queryString;
			PageMove.forward(request, response, path);
		}else if("mvmygroup".equals(act)){
			path = StudyGroupActionFactory.getStudyGroupMyListAction().execute(request, response);
			PageMove.forward(request, response, path);
		}else if("stgregister".equals(act)){
			path = StudyGroupActionFactory.getStudyGroupCreateAction().execute(request, response);
			PageMove.forward(request, response, path);
		}else if("mvmygroupcontent".equals(act)){
			path = StudyGroupActionFactory.getStudyGroupMyGroupContentAction().execute(request, response);
			PageMove.forward(request, response, path);
		}else if("viewgroupcontent".equals(act)){
			int pg = Integer.parseInt(request.getParameter("pg"));
			String word = StringEncoder.isoToEuc(request.getParameter("word"));
			path = StudyGroupActionFactory.getStudyGroupViewAction().execute(request, response);
			PageMove.forward(request, response, path);
		}else if("groupnum".equals(act)){
			path = StudyGroupActionFactory.getStudyGroupViewAction().execute(request, response);
			PageMove.forward(request, response, path);
		}else if("mvmygroupmodify".equals(act)) {
			path = StudyGroupActionFactory.getStudyGroupMoveModifyAction().execute(request, response);
			PageMove.forward(request, response, path);
		}else if("modifygroup".equals(act)) {
			path = StudyGroupActionFactory.getStudyGroupModifyAction().execute(request, response);
			PageMove.forward(request, response, path);
		}else if("studygroupapply".equals(act)) {
			path = StudyGroupActionFactory.getStudyGroupApplyAction().execute(request, response);
		}else if("mvincludeme".equals(act)) {
			path = StudyGroupActionFactory.getStudyGroupIncludeMeAction().execute(request, response);
			PageMove.forward(request, response, path);
		}else if("mvincludemegroup".equals(act)) {
			path = StudyGroupActionFactory.getStudyGroupIncludeMeGroupAction().execute(request, response);
			PageMove.forward(request, response, path);
		}else if("mvregisterstg".equals(act)) {
			path = "/studygroupmain/studygroupregister.jsp";
			PageMove.forward(request, response, path);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}

}
