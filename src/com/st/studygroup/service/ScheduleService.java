package com.st.studygroup.service;

import java.util.List;

import com.st.studygroup.model.StudyGroupScheduleDto;

public interface ScheduleService {
	
	List<StudyGroupScheduleDto> scheduleList(int SNO);
	int registerSchedule(StudyGroupScheduleDto studyGroupScheduleDto);
	List<StudyGroupScheduleDto> viewSchedule(int SNO, String date);
	List<StudyGroupScheduleDto> viewTodaySchedule(int SNO);

}
