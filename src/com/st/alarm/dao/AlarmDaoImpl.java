package com.st.alarm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.st.alarm.model.AlarmDto;
import com.st.db.DBClose;
import com.st.db.DBConnection;
import com.st.studyroom.dao.StudyRoomDao;
import com.st.studyroom.dao.StudyRoomDaoImpl;

public class AlarmDaoImpl implements AlarmDao{
	
	private static AlarmDao alarmDao;
	
	static {
		alarmDao = new AlarmDaoImpl();
	}
	
	private AlarmDaoImpl() {}
	
	public static AlarmDao getAlarmDao() {
		return alarmDao;
	}
	
	
	@Override
	public int reservationAlarmPair(AlarmDto alarm_to_host, AlarmDto alarm_to_user,int rmno) {
	
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			StringBuffer sql2 = new StringBuffer();
			
			//관리자가 호스트에게
			sql.append("insert into alarm(ano,mno,a_content,a_type,a_sendmno) \n");
			sql.append("values           (seq_ano.nextval ,(\n");
			sql.append("                                    select s.mno from space s, room r \n");
			sql.append("                                    where s.spno = r.spno\n");
			sql.append("                                    and rm_no = ?\n");
			sql.append("                                    ), ? , ? , (\n");
			sql.append("                                                select mno \n");
			sql.append("                                                from member \n");
			sql.append("                                                where m_status=9 And rownum = 1) \n");
			sql.append("                                                )\n");
			
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
		
			pstmt.setInt(++idx, rmno);
			pstmt.setString(++idx, alarm_to_host.getA_content());
			pstmt.setString(++idx, alarm_to_host.getA_type());			
			cnt = pstmt.executeUpdate();
			pstmt.close();
			
			//관리자가 유저에게
			sql2.append("insert into alarm(ano,mno,a_content,a_type,a_sendmno) \n");
			sql2.append("values           (seq_ano.nextval ,? \n");
			sql2.append("                                    , ? , ? , ( \n");
			sql2.append("                                                select mno \n");
			sql2.append("                                                from member \n");
			sql2.append("                                                where m_status=9 And rownum = 1) \n");
			sql2.append("                                                )\n");
			
			pstmt = conn.prepareStatement(sql2.toString());
			idx = 0;
			
			pstmt.setInt(++idx, alarm_to_user.getMno());
			pstmt.setString(++idx, alarm_to_user.getA_content());
			pstmt.setString(++idx, alarm_to_user.getA_type());	
			
			cnt = pstmt.executeUpdate();
			pstmt.close();
			System.out.println("알람성공");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}	
		return cnt;
	}

}
