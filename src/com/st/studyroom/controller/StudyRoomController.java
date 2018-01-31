package com.st.studyroom.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.st.common.service.CommonServiceImpl;
import com.st.factory.StudyRoomActionFactory;
import com.st.studyroom.model.StudyRoomDto;
import com.st.studyroom.model.ZipDto;
import com.st.util.NullCheck;
import com.st.util.PageMove;
import com.st.util.StringEncoder;

@WebServlet("/studyroom")
public class StudyRoomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int spno;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String root = request.getContextPath();
		String act = request.getParameter("act");
		System.out.println("StudyroomController  act === " + act);
		String path = "/main/login.jsp";
		String queryString = "?spno=" + request.getParameter("spno");//방 셀렉하고 두번째 상세 페이지로 넘어갈 때 쿼리에 붙여줄 것
		
		if("rmain".equals(act)) {
			
			path = StudyRoomActionFactory.getStudyRoomListAction().execute(request, response);
			PageMove.forward(request, response, path);
		} else if("mvroomrgst".equals(act)) {
			
			path = "/room/roomInfo/register.jsp";
			PageMove.forward(request, response, path);	
			
		} else if("roomrgst".equals(act)) {//
			spno= CommonServiceImpl.getCommonService().selectSPNO();//리퀘스트 객체로부터 받아오는 값이 아님을 생각
			request.setAttribute("roomList",aJaxController.list);	
			request.setAttribute("spno",spno);
			path = StudyRoomActionFactory.getStudyRoomRegisterAction().execute(request, response);	//should check the path first. have to distinguish if user submitted or not  			
			//이 경우 유저는 반드시 방을 하나 이상 등록한 상태여야 하므로 자바스크립트로 유효성 검사 해 줘야 함
			
			PageMove.forward(request, response, path);
		} 
		else if("mvrsv".equals(act)) {	
			//메인에서 방 선택하는 페이지로 넘아
			path = StudyRoomActionFactory.getMoveReservationAction().execute(request, response);
			path += queryString;//두번째 예약 페이지로 넘어가는 것.
			PageMove.forward(request, response, path);	
			
		}else if("mvroomrsv".equals(act)) {
			//방 선택 페이지에서 날짜별 일정있는 페이지로 넘어감
			path = StudyRoomActionFactory.getMoveReservationDetailAction().execute(request, response);
			PageMove.forward(request, response, path);		
			
		}else if("roomrsv".equals(act)) {
			path = StudyRoomActionFactory.getStudyRoomReservationAction().execute(request, response);
			PageMove.forward(request, response, path);	
		}else if("mvzip".equals(act)) {
			PageMove.redirect(request, response, "/room/roomInfo/zipsearch.jsp");
			
		}else if("zipsearch".equals(act)){		
			path = StudyRoomActionFactory.getZipsearchAction().execute(request, response);
			PageMove.forward(request, response, path);
		} else {
			PageMove.redirect(request, response, path);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request,response);
		
	}
}