package com.st.alarm.service;

import com.st.alarm.model.AlarmDto;

public interface AlarmService {
	
	int reservationAlarmPair(AlarmDto alarm_to_host, AlarmDto alarm_to_user, int rmno);


}
