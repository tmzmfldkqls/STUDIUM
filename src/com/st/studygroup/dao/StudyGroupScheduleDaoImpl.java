package com.st.studygroup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.st.db.DBClose;
import com.st.db.DBConnection;
import com.st.studygroup.model.BbsGroupDto;
import com.st.studygroup.model.StudyGroupScheduleDto;

public class StudyGroupScheduleDaoImpl implements StudyGroupScheduleDao {
	
	private static StudyGroupScheduleDao studyGroupScheduleDao;
	
	static {
		studyGroupScheduleDao = new StudyGroupScheduleDaoImpl();
	}
	
	public static StudyGroupScheduleDao getStudyGroupScheduleDao() {
		return studyGroupScheduleDao;
	}
	
	private StudyGroupScheduleDaoImpl() {}
	
	

	@Override
	public List<StudyGroupScheduleDto> scheduleList(int SNO) {
		List<StudyGroupScheduleDto> list = new ArrayList<StudyGroupScheduleDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql =  new StringBuffer();
			sql.append("select ST.STNO, ST.SNO, ST.ST_DATE_IN, ST.ST_DATE_OUT, ST.ST_TIME_IN, ST.ST_TIME_OUT, ST.ST_CONTENT, ST.ST_NAME, \n ");
			sql.append("		STG.SNO, STG.MNO, STG.S_ID, STG.S_NAME, STG.S_CONTENT, STG.S_TAG, STG.S_MEMBER, STG.S_PERSON, STG.S_MAXPERSON, STG.S_CURR_STATUS, STG.S_BEING \n");
			sql.append("from ST, STG \n");
			sql.append("where ST.SNO = ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, SNO);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				StudyGroupScheduleDto studyGroupScheduleDto = new StudyGroupScheduleDto();
				studyGroupScheduleDto.setSTNO(rs.getInt("STNO"));
				studyGroupScheduleDto.setSNO(rs.getInt("SNO"));
				studyGroupScheduleDto.setST_DATE_IN(rs.getString("ST_DATE_IN"));
				studyGroupScheduleDto.setST_DATE_OUT(rs.getString("ST_DATE_OUT"));
				studyGroupScheduleDto.setST_TIME_IN(rs.getString("ST_TIME_IN"));
				studyGroupScheduleDto.setST_TIME_OUT(rs.getString("ST_TIME_OUT"));
				studyGroupScheduleDto.setST_CONTENT(rs.getString("ST_CONTENT"));
				studyGroupScheduleDto.setST_NAME(rs.getString("ST_NAME"));
				list.add(studyGroupScheduleDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public int registerSchedule(StudyGroupScheduleDto studyGroupScheduleDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql =  new StringBuffer();
			sql.append("INSERT INTO ST(STNO, SNO, ST_DATE_IN, ST_DATE_OUT, ST_CONTENT, ST_NAME) \n");
			sql.append("VALUES (SEQ_STNO.NEXTVAL, ?, ?, ?, ?, ?) \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, studyGroupScheduleDto.getSNO());
			pstmt.setString(2, studyGroupScheduleDto.getST_DATE_IN());
			pstmt.setString(3, studyGroupScheduleDto.getST_DATE_OUT());
			pstmt.setString(4, studyGroupScheduleDto.getST_CONTENT());
			pstmt.setString(5, studyGroupScheduleDto.getST_NAME());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(conn, pstmt);
		}
		
		return cnt;
	}

	@Override
	public List<StudyGroupScheduleDto> viewSchedule(Map<String, String> map) {
		List<StudyGroupScheduleDto> slist = new ArrayList<StudyGroupScheduleDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT STNO, SNO, ST_DATE_IN, ST_DATE_OUT, ST_CONTENT, ST_NAME \n");
			sql.append("FROM ST \n");
			sql.append("WHERE SNO = ? \n");
			sql.append("AND ST_DATE_IN = ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, map.get("SNO"));
			pstmt.setString(2, map.get("date"));
			rs = pstmt.executeQuery();

			while(rs.next()) {
				StudyGroupScheduleDto studyGroupScheduleDto = new StudyGroupScheduleDto();
				studyGroupScheduleDto.setSTNO(rs.getInt("STNO"));
				studyGroupScheduleDto.setSNO(rs.getInt("SNO"));
				studyGroupScheduleDto.setST_DATE_IN(rs.getString("ST_DATE_IN"));
				studyGroupScheduleDto.setST_DATE_OUT(rs.getString("ST_DATE_OUT"));
				studyGroupScheduleDto.setST_CONTENT(rs.getString("ST_CONTENT"));
				studyGroupScheduleDto.setST_NAME(rs.getString("ST_NAME"));
				slist.add(studyGroupScheduleDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return slist;
	}

	@Override
	public List<StudyGroupScheduleDto> viewTodaySchedule(int SNO) {
		List<StudyGroupScheduleDto> slist = new ArrayList<StudyGroupScheduleDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT STNO, SNO, ST_DATE_IN, ST_DATE_OUT, ST_CONTENT, ST_NAME \n");
			sql.append("FROM ST \n");
			sql.append("where ST_DATE_IN = TO_CHAR(sysdate,'YYYY-MM-DD') \n");
			sql.append("and SNO = ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, SNO);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				StudyGroupScheduleDto studyGroupScheduleDto = new StudyGroupScheduleDto();
				studyGroupScheduleDto.setSTNO(rs.getInt("STNO"));
				studyGroupScheduleDto.setSNO(rs.getInt("SNO"));
				studyGroupScheduleDto.setST_DATE_IN(rs.getString("ST_DATE_IN"));
				studyGroupScheduleDto.setST_DATE_OUT(rs.getString("ST_DATE_OUT"));
				studyGroupScheduleDto.setST_CONTENT(rs.getString("ST_CONTENT"));
				studyGroupScheduleDto.setST_NAME(rs.getString("ST_NAME"));
				slist.add(studyGroupScheduleDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return slist;
	}

}
