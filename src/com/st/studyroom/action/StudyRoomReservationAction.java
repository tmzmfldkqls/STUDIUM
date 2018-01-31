package com.st.studyroom.action;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.st.action.Action;
import com.st.alarm.dao.AlarmDaoImpl;
import com.st.alarm.model.AlarmDto;
import com.st.member.model.MemberDto;
import com.st.studyroom.model.ReservationDto;
import com.st.studyroom.service.StudyRoomServiceImpl;
import jdk.nashorn.internal.ir.RuntimeNode.Request;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class StudyRoomReservationAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto)session.getAttribute("userInfo");
		
		Integer temp_rmno = (Integer)session.getAttribute("rmnoForRsv");
		int price =(Integer)session.getAttribute("price");		
		int rmno = 0;
		
		if(temp_rmno != null){
			rmno = temp_rmno;
		}
		//예약 디티오 세팅
		ReservationDto reservationDto = new ReservationDto();		
		reservationDto.setMNO(memberDto.getMNO());
		reservationDto.setRMR_CONTENT(request.getParameter("comment"));
		reservationDto.setRM_NO(rmno);
		//reservationDto.setRMR_DATE(rMR_DATE);dao에서 sysdate 할거임
		reservationDto.setRMR_DATE_IN(request.getParameter("selected"));
		reservationDto.setRMR_DATE_OUT(request.getParameter("selected"));//
		reservationDto.setRMR_EMAIL(request.getParameter("email"));
		reservationDto.setRMR_ID(memberDto.getM_ID());
		reservationDto.setRMR_PERSON(Integer.parseInt(request.getParameter("numberOf")));
		
		reservationDto.setRMR_PRICE(price);
		reservationDto.setRMR_TEL(request.getParameter("tel"));
		reservationDto.setRMR_TIME_IN(request.getParameter("startTime"));
		reservationDto.setRMR_TIME_OUT(request.getParameter("endTime"));
		//reservationDto.setRMRNO(rMRNO);dao에서
		
		//알람 디티오 세팅
		AlarmDto alarm_to_host = new AlarmDto();
		AlarmDto alarm_to_user = new AlarmDto();
		
		//관리자가 호스트한테
		alarm_to_host.setA_content(memberDto.getM_ID() + "로부터 새 예약이 들어왔습니다\n"+
									request.getParameter("selected") + " 일자 "  +  request.getParameter("startTime") +"부터 "+request.getParameter("endTime")+"까지\n"+
									"자세한 사항은 MyStudyRoom 을 확인하세요");
		//alarm_to_host.setA_sendmno(a_sendmno);DB에서 서브쿼리 써서 관리자 찾아서 넣을거야
		alarm_to_host.setA_type("1");
		//alarm_to_host.setAno(ano);
		//alarm_to_host.setMno(mno);DB에서 서브쿼리 써서 호스트 찾아서 넣을거야
		
		//호스트가 유저한테
		alarm_to_user.setA_content("예약이 완료 되었습니다! 자세한 사항은 MyReservation을 통해 확인하세요");
		//alarm_to_user.setA_sendmno(a_sendmno);DB에서 서브쿼리 써서 호스트 찾아서 넣을거야
		alarm_to_user.setA_type("1");
		//alarm_to_user.setAno(ano);
		alarm_to_user.setMno(memberDto.getMNO());
				
		int cnt1 = StudyRoomServiceImpl.getStudyRoomService().roomReservation(reservationDto);
		int cnt2 = AlarmDaoImpl.getAlarmDao().reservationAlarmPair(alarm_to_host,alarm_to_user,rmno);
		
		session.removeAttribute("rmnoForRsv");
		session.removeAttribute("price");
		session.removeAttribute("usingTime");
		
		return "/mypage?act=myReservation";
	}
	

}
