package com.st.studyroom.schedule.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.st.action.Action;
import com.st.studyroom.model.ReservationDto;
import com.st.studyroom.service.StudyRoomServiceImpl;

public class StudyRoomScheduleListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int rmnoForRsv = Integer.parseInt(request.getParameter("selectedRoom"));
		
		String date = request.getParameter("date");
		List<ReservationDto> list = StudyRoomServiceImpl.getStudyRoomService().reservationlist(rmnoForRsv,date);
		
		JSONObject json = new JSONObject();
	    JSONArray jarray = new JSONArray();
	    
	    for(ReservationDto reservationDto : list){
	         JSONObject rmr = new JSONObject();
	         
	         rmr.put("RMR_DATE_IN", reservationDto.getRMR_DATE_IN());
	         rmr.put("RMR_DATE_OUT", reservationDto.getRMR_DATE_OUT());
	         rmr.put("RMR_TIME_IN", reservationDto.getRMR_TIME_IN());
	         rmr.put("RMR_TIME_OUT", reservationDto.getRMR_TIME_OUT());
	         rmr.put("RMRNO", reservationDto.getRMRNO());

	         jarray.add(rmr);
	      }
	      json.put("rsvlist", jarray);
	      System.out.println("스터디룸스케줄리스트액션" + json.toJSONString());
	      request.setAttribute("rsvList", list);
	      return json.toJSONString();
	}

	
}
