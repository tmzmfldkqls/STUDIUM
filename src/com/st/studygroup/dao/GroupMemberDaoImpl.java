package com.st.studygroup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.st.db.DBClose;
import com.st.db.DBConnection;
import com.st.studygroup.model.StudyGroupApplyDto;
import com.st.studygroup.model.StudyGroupDto;
import com.st.studygroup.model.StudyGroupMemberDto;

public class GroupMemberDaoImpl implements GroupMemberDao {
	
	private static GroupMemberDao groupMemberDao;
	
	static {
		groupMemberDao = new GroupMemberDaoImpl();
	}
	
	public static GroupMemberDao getGroupMemberDao() {
		return groupMemberDao;
	}
	
	private GroupMemberDaoImpl() {}

	@Override
	public List<StudyGroupDto> studyGroupKing(int SNO) {
		List<StudyGroupDto> klist =  new ArrayList<StudyGroupDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql =  new StringBuffer();
			sql.append("SELECT S_ID \n"); 
			sql.append("FROM STG \n");
			sql.append("WHERE SNO = ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, SNO);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				StudyGroupDto studyGroupDto = new StudyGroupDto(); 
				studyGroupDto.setS_ID(rs.getString("S_ID"));
				klist.add(studyGroupDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		return klist;
	}


	@Override
	public List<StudyGroupApplyDto> studyGroupApply(int SNO) {
		List<StudyGroupApplyDto> alist = new ArrayList<StudyGroupApplyDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql =  new StringBuffer();
			sql.append("SELECT APNO, MNO, SNO, AP_ID, AP_CONTENT, AP_STATUS \n");
			sql.append("FROM STG_AP \n");
			sql.append("WHERE SNO = ? \n");
			sql.append("AND AP_STATUS = 1");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, SNO);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				StudyGroupApplyDto studyGroupApplyDto = new StudyGroupApplyDto();
				studyGroupApplyDto.setAPNO(rs.getInt("APNO"));
				studyGroupApplyDto.setMNO(rs.getInt("MNO"));
				studyGroupApplyDto.setSNO(rs.getInt("SNO"));
				studyGroupApplyDto.setAP_ID(rs.getString("AP_ID"));
				studyGroupApplyDto.setAP_CONTENT(rs.getString("AP_CONTENT"));
				studyGroupApplyDto.setAP_STATUS(rs.getString("AP_STATUS"));
				alist.add(studyGroupApplyDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		return alist;
	}

	@Override
	public List<StudyGroupMemberDto> studyGroupMember(int SNO) {
		List<StudyGroupMemberDto> mlist =  new ArrayList<StudyGroupMemberDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql =  new StringBuffer();
			sql.append("SELECT M.M_ID, STM.MNO \n"); 
			sql.append("FROM STG_MM STM, MEMBER M \n");
			sql.append("WHERE STM.SNO = ? \n");
			sql.append("AND STM.MNO = M.MNO ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, SNO);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				StudyGroupMemberDto studyGroupMemberDto = new StudyGroupMemberDto(); 
				studyGroupMemberDto.setM_ID(rs.getString("M_ID"));
				studyGroupMemberDto.setMNO(rs.getInt("MNO"));
				mlist.add(studyGroupMemberDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		return mlist;
	}

	@Override
	public int registerMember(StudyGroupMemberDto studyGroupMemberDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			conn.setAutoCommit(false);
			StringBuffer sql2 =  new StringBuffer();
			sql2.append("INSERT INTO STG_MM VALUES(SEQ_SMNO.NEXTVAL, ?, ?) \n");
			pstmt = conn.prepareStatement(sql2.toString());
			pstmt.setInt(1,studyGroupMemberDto.getSNO());
			pstmt.setInt(2,studyGroupMemberDto.getMNO());
			pstmt.executeUpdate();
			pstmt.close();
			conn.commit();
			
			StringBuffer sql1 =  new StringBuffer();
			sql1.append("UPDATE STG_AP \n");
			sql1.append("SET AP_STATUS = 0 \n");
			sql1.append("WHERE AP_ID = ? \n");
			sql1.append("AND SNO = ?");
			pstmt = conn.prepareStatement(sql1.toString());
			pstmt.setString(1, studyGroupMemberDto.getM_ID());
			pstmt.setInt(2, studyGroupMemberDto.getSNO());
			pstmt.executeUpdate();
			pstmt.close();
			conn.commit();
			
			StringBuffer sql3 =  new StringBuffer();
			sql3.append("UPDATE STG \n");
			sql3.append("SET S_PERSON = S_PERSON + 1 \n");
			sql3.append("WHERE SNO = ? ");
			sql3.append("AND S_PERSON < S_MAXPERSON");
			pstmt = conn.prepareStatement(sql3.toString());
			pstmt.setInt(1, studyGroupMemberDto.getSNO());
			pstmt.executeUpdate();
			conn.commit();
			
			StringBuffer sql4 = new StringBuffer();
			sql4.append("UPDATE STG \n");
			sql4.append("SET S_CURR_STATUS = \n");
			sql4.append("CASE \n");
			sql4.append("	WHEN S_PERSON = S_MAXPERSON \n");
			sql4.append("	THEN '1' \n");
			sql4.append("	END \n");
			sql4.append("WHERE SNO = ? ");
			pstmt = conn.prepareStatement(sql4.toString());
			pstmt.setInt(1, studyGroupMemberDto.getSNO());
			pstmt.executeUpdate();
			conn.commit();
			
			cnt = 1;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
				cnt=0;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}

	@Override
	public int memberout(Map<String, String> map) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.makeConnection();
			conn.setAutoCommit(false);
			StringBuffer sql =  new StringBuffer();
			sql.append("DELETE STG_MM \n");
			sql.append("WHERE MNO = ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1,map.get("MNO"));
			pstmt.executeUpdate();
			pstmt.close();
			conn.commit();
			
			StringBuffer sql3 =  new StringBuffer();
			sql3.append("UPDATE STG \n");
			sql3.append("SET S_PERSON = S_PERSON - 1 \n");
			sql3.append("WHERE SNO = ? ");
			pstmt = conn.prepareStatement(sql3.toString());
			pstmt.setString(1, map.get("SNO"));
			pstmt.executeUpdate();
			conn.commit();
			
			cnt = 1;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
				cnt=0;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}

	@Override
	public StudyGroupMemberDto studyGroupMemberCheck(int SNO) {
		StudyGroupMemberDto studyGroupMemberDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql =  new StringBuffer();
			sql.append("SELECT M.M_ID, STM.MNO \n"); 
			sql.append("FROM STG_MM STM, MEMBER M \n");
			sql.append("WHERE STM.SNO = ? \n");
			sql.append("AND STM.MNO = M.MNO ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, SNO);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				studyGroupMemberDto = new StudyGroupMemberDto();
				studyGroupMemberDto.setM_ID(rs.getString("M_ID"));
				studyGroupMemberDto.setMNO(rs.getInt("MNO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		return studyGroupMemberDto;
	}

	@Override
	public StudyGroupApplyDto studyGroupApplyMember(int SNO) {
		StudyGroupApplyDto studyGroupApplyDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql =  new StringBuffer();
			sql.append("SELECT AP_ID \n");
			sql.append("FROM STG_AP \n");
			sql.append("WHERE SNO = ? \n");
			sql.append("AND AP_STATUS = 1");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, SNO);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				studyGroupApplyDto = new StudyGroupApplyDto();
				studyGroupApplyDto.setAP_ID(rs.getString("AP_ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		return studyGroupApplyDto;
	}

	@Override
	public int refuseMember(Map<String, String> map) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql =  new StringBuffer();
			sql.append("UPDATE STG_AP \n");
			sql.append("SET AP_STATUS = 0 \n");
			sql.append("WHERE SNO = ? \n");
			sql.append("AND AP_ID = ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, map.get("SNO"));
			pstmt.setString(2, map.get("apid"));
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}
}
