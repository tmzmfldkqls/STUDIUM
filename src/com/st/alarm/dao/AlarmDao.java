package com.st.alarm.dao;

import com.st.alarm.model.AlarmDto;

public interface AlarmDao {
	int reservationAlarmPair(AlarmDto alarm_to_host, AlarmDto alarm_to_user,int rmno);
}
