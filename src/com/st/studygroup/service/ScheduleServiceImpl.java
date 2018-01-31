package com.st.studygroup.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.st.studygroup.dao.StudyGroupDaoImpl;
import com.st.studygroup.dao.StudyGroupScheduleDaoImpl;
import com.st.studygroup.model.StudyGroupScheduleDto;

public class ScheduleServiceImpl implements ScheduleService {
	
	private static ScheduleService scheduleService;
	
	static {
		scheduleService = new ScheduleServiceImpl();
	}
	
	private ScheduleServiceImpl() {}
	
	
	public static ScheduleService getScheduleService() {
		return scheduleService;
	}


	@Override
	public List<StudyGroupScheduleDto> scheduleList(int SNO) {
		
		return StudyGroupScheduleDaoImpl.getStudyGroupScheduleDao().scheduleList(SNO);
	}


	@Override
	public int registerSchedule(StudyGroupScheduleDto studyGroupScheduleDto) {
		return StudyGroupScheduleDaoImpl.getStudyGroupScheduleDao().registerSchedule(studyGroupScheduleDto);
	}


	@Override
	public List<StudyGroupScheduleDto> viewSchedule(int SNO, String date) {
		System.out.println("7");
		Map<String, String> map = new HashMap<String,String>();
		System.out.println("8");
		map.put("SNO", SNO+"");
		System.out.println("9");
		map.put("date", date+"");
		return StudyGroupScheduleDaoImpl.getStudyGroupScheduleDao().viewSchedule(map);
	}


	@Override
	public List<StudyGroupScheduleDto> viewTodaySchedule(int SNO) {
		return StudyGroupScheduleDaoImpl.getStudyGroupScheduleDao().viewTodaySchedule(SNO);
	}

}
