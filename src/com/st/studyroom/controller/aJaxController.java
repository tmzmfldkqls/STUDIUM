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
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.st.common.service.CommonServiceImpl;
import com.st.factory.StudyRoomActionFactory;
import com.st.studyroom.model.ReservationDto;
import com.st.studyroom.model.StudyRoomDto;
import com.st.util.PageMove;


@WebServlet("/aJaxController")
public class aJaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static List<StudyRoomDto> list = new ArrayList<StudyRoomDto>();	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.setContentType("text/plain;charset=EUC-KR");
		PrintWriter out = response.getWriter();
		String act = request.getParameter("act");
		System.out.println("ajax act ===" + act);
		
		if("showlist".equals(act)){
			//날짜별 스케줄 보기
			//제이슨.toString 담김
			String rsvList = StudyRoomActionFactory.getStudyRoomScheduleListAction().execute(request, response);			
			out.print(rsvList);		

		}else if("showRsvDetail".equals(act)){
			//예약 내역 보이기		
			//reservationDetail 에 디테일 정보 담겨져 있음
			StudyRoomActionFactory.getRsvDetailAction_host().execute(request, response);
			ReservationDto reservationDto = (ReservationDto)request.getAttribute("reservationDetail"); 
			PageMove.forward(request, response, "/room/mypage/rsvDetailxml.jsp");
				
		}else{
			String time  = request.getParameter("timeValue");
			String price = request.getParameter("price");
			
			int total_price  = Integer.parseInt(price)*Integer.parseInt(time);
			out.print(Integer.parseInt(price)*Integer.parseInt(time));
			
			HttpSession session = request.getSession();
			session.setAttribute("usingTime", time);
			session.setAttribute("price", total_price);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		//룸 등록에만 씁니다
		if(request.getParameterNames().hasMoreElements()){
			StudyRoomDto studyRoomDto = new StudyRoomDto();
			int idx = 0;			
			System.out.println(request.getParameterNames().nextElement());
			studyRoomDto.setRM_NAME(request.getParameterNames().nextElement().split(",")[idx++]);		
			studyRoomDto.setRM_CONV(request.getParameterNames().nextElement().split(",")[idx++]);
			studyRoomDto.setRM_TEL(request.getParameterNames().nextElement().split(",")[idx++]);
			studyRoomDto.setRM_PRICE(Integer.parseInt(request.getParameterNames().nextElement().split(",")[idx++]));
			studyRoomDto.setRM_CAUTION(request.getParameterNames().nextElement().split(",")[idx++]);	
			studyRoomDto.setRM_MAX_PERSON(Integer.parseInt(request.getParameterNames().nextElement().split(",")[idx++]));
			studyRoomDto.setRM_MIN_PERSON(Integer.parseInt(request.getParameterNames().nextElement().split(",")[idx++]));				
			studyRoomDto.setRM_MIN_TIME("30");			
			
			response.setContentType("text/plain;charset=EUC-KR");
			PrintWriter out = response.getWriter();
			out.print(studyRoomDto.getRM_NAME());
			
			list.add(studyRoomDto);
			}
		}
	}

