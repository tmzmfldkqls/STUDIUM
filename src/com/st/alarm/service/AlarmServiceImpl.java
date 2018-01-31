package com.st.alarm.service;

import com.st.alarm.dao.AlarmDaoImpl;
import com.st.alarm.model.AlarmDto;
import com.st.studyroom.service.StudyRoomService;




public class AlarmServiceImpl implements AlarmService{
	
private static AlarmService alarmService;
	
	static {
		alarmService = new AlarmServiceImpl();
	}
	private AlarmServiceImpl() {}
	
	public static AlarmService getAlarmService(){
		return alarmService;
	}


	@Override
	public int reservationAlarmPair(AlarmDto alarm_to_host, AlarmDto alarm_to_user,int rmno) {		
		return AlarmDaoImpl.getAlarmDao().reservationAlarmPair(alarm_to_host,alarm_to_user,rmno);
	}


}
