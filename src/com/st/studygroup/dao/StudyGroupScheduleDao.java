package com.st.studygroup.dao;

import java.util.List;
import java.util.Map;

import com.st.studygroup.model.StudyGroupScheduleDto;

public interface StudyGroupScheduleDao {
	
	List<StudyGroupScheduleDto> scheduleList(int SNO);
	int registerSchedule(StudyGroupScheduleDto studyGroupScheduleDto);
	List<StudyGroupScheduleDto> viewSchedule(Map<String, String> map);
	List<StudyGroupScheduleDto> viewTodaySchedule(int SNO);

}
