package com.st.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.st.factory.StudyRoomActionFactory;
import com.st.util.PageMove;

/**
 * Servlet implementation class MyPageController
 */
@WebServlet("/mypage")
public class MyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String root = request.getContextPath();
		
		String act = request.getParameter("act");		
		System.out.println("새로운 mypageController  act === " + act);
		String path = "/main/main.jsp";
		
		if("mvedit".equals(act)) {
			
			path = "/room/mypage/EditProfile.jsp";
			PageMove.redirect(request, response, path);
			
		}else if("edit".equals(act)) {
			
			path = StudyRoomActionFactory.getMyProfileEditAction().execute(request, response);
			PageMove.redirect(request, response, path);
				
		}else if("mypageMain".equals(act)){
			
			path = StudyRoomActionFactory.getMyRoomListAction().execute(request, response);
			PageMove.forward(request, response, path);
			
		}else if("mvroomedit".equals(act)){
			
//			path = StudyRoomActionFactory.getMyRoomListAction().execute(request, response);
//			PageMove.forward(request, response, path);
			
		}else if("mvRoomSchedule".equals(act)){
			System.out.println("마이 룸 스케줄");
			//가게별 방+일정 페이지로 넘어감
			path = StudyRoomActionFactory.getMoveMyroomScheduleAction().execute(request, response);
			PageMove.forward(request, response, path);	
			
		}else if("myReservation".equals(act)){
			
			path = StudyRoomActionFactory.getMyReservationAction().execute(request, response);
			PageMove.forward(request, response, path);
			
		}else if("myReservationDetail".equals(act)){
			
			path = StudyRoomActionFactory.getReservationDetailAction().execute(request, response);
			PageMove.forward(request, response, path);
			
		}else if("rsvDelete".equals(act)){
			System.out.println("ac");
			path = StudyRoomActionFactory.getReservationDeleteAction().execute(request, response);
			System.out.println(path);
			PageMove.forward(request, response, path);
			
		} else{
			PageMove.redirect(request, response, path);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}

}
