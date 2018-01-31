package com.st.admin.dao;

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
import com.st.member.model.MemberDto;
import com.st.studygroup.model.StudyGroupDto;
import com.st.studyroom.model.StudyRoomDto;
import com.st.studyroom.model.StudySpaceDto;

/**
 * @author jungseungho
 *
 */
public class AdminDaoImpl implements AdminDao {
	
	private static AdminDao adminDao;
	
	static {
		adminDao = new AdminDaoImpl();
	}
	
	public static AdminDao getAdminDao() {
		return adminDao;
	}

	private AdminDaoImpl() {}

	@Override
	public List<MemberDto> listMember(Map<String, String> map) {
		List<MemberDto> list = new ArrayList<MemberDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select mno, m_name, m_email, DECODE(m_status,'1','회원','0','탈퇴회원','9','관리자') m_status, m_tel, m_tag, m_id, m_date \n");
			sql.append("from member \n");
			String word = map.get("word");
			String date = map.get("date");
			if(!date.isEmpty()) {
				sql.append("where TO_CHAR(m_date,'yyyymmdd') = ? ");
			}
			if(!word.trim().isEmpty()) {
				String key = map.get("key");
				if("m_tag".equals(key)) {
					
					sql.append("where M_TAG like '%'||?||'%' "); 
				} else {
					sql.append("where "+key +"= ? ");
				}
			}	
			pstmt = conn.prepareStatement(sql.toString());
			if(!date.isEmpty()) {
				pstmt.setString(1, date);
			}
			if(!word.trim().isEmpty()) {
				pstmt.setString(1, word);
			}
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberDto memberDto = new MemberDto();
				memberDto.setMNO(rs.getInt("mno"));
				memberDto.setM_ID(rs.getString("m_id"));
				memberDto.setM_NAME(rs.getString("m_name"));
				memberDto.setM_EMAIL(rs.getString("m_email"));
				memberDto.setM_TAG(rs.getString("m_tag"));
				memberDto.setM_TEL(rs.getString("m_tel"));
				memberDto.setM_STATUS(rs.getString("m_status"));
				list.add(memberDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		return list;
	}

	@Override
	public List<Map> memberChart() {
		List<Map> list = new ArrayList<Map>();
		Map<String,String> map = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select TO_CHAR(M_DATE,'YYYY') M_date, count(mno) \n");
			sql.append("from member \n");
			sql.append("GROUP by TO_CHAR(M_DATE,'YYYY') ");
			sql.append("ORDER BY M_date DESC ");
			pstmt = conn.prepareStatement(sql.toString());			
			rs = pstmt.executeQuery();			
			while(rs.next()) {
				map = new HashMap<String, String>();
				map.put("year", rs.getString(1));
				map.put("count", rs.getInt(2)+"");
				list.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		return list;
	}

	@Override
	public List<Map> loginChart() {
		List<Map> list = new ArrayList<Map>();
		Map<String,String> map = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select M_ID, M_LNUM \n");
			sql.append("from member \n");		
			pstmt = conn.prepareStatement(sql.toString());			
			rs = pstmt.executeQuery();			
			while(rs.next()) {
				map = new HashMap<String, String>();
				map.put("id", rs.getString(1));
				map.put("count", rs.getInt(2)+"");
				list.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		return list;
	}
	@Override
	public List<StudyRoomDto> addressList() {
		List<StudyRoomDto> list = new ArrayList<StudyRoomDto>();
		StudyRoomDto studyRoomDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();	
			sql.append("SELECT spa.spno, spa.sp_dong, sp.sp_name, sp_scontent, sp_tag, sp_geo \n");
			sql.append("from SP_ADD spa, SPACE sp \n");
			sql.append("WHERE spa.spno = sp.spno ");
			pstmt = conn.prepareStatement(sql.toString());			
			rs = pstmt.executeQuery();			
			while(rs.next()) {
				studyRoomDto = new StudyRoomDto();
				studyRoomDto.setSPNO(rs.getInt(1));
				studyRoomDto.setSP_DONG(rs.getString(2));
				studyRoomDto.setSP_NAME(rs.getString(3));
				studyRoomDto.setSP_SCONTENT(rs.getString(4));
				studyRoomDto.setSP_TAG(rs.getString(5));
				studyRoomDto.setSP_GEO(rs.getString(6));
				list.add(studyRoomDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		return list;
	}

	@Override
	public List<StudySpaceDto> listSpace(Map<String, String> map) {
		List<StudySpaceDto> list = new ArrayList<StudySpaceDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT spno, sp_name,sp_scontent,sp_content,sp_tag,footprint,sp_web,DECODE(sp_st,'1','등록중','0','삭제') sp_st, sp_date \n");
			sql.append("from space \n");
			String word = map.get("word");
			String date = map.get("date");
			if(!date.isEmpty()) {
				sql.append("where TO_CHAR(sp_date,'yyyymmdd') = ? ");
			}
			if(!word.trim().isEmpty()) {
				String key = map.get("key");
				if("sp_tag".equals(key)) {
					
					sql.append("where sp_TAG like '%'||?||'%' "); 
				} else {
					sql.append("where "+key +"= ? ");
				}
			}	
			pstmt = conn.prepareStatement(sql.toString());
			if(!date.isEmpty()) {
				pstmt.setString(1, date);
			}
			if(!word.trim().isEmpty()) {
				pstmt.setString(1, word);
			}
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				StudySpaceDto studySpaceDto = new StudySpaceDto();
				studySpaceDto.setSPNO(rs.getInt("spno"));
				studySpaceDto.setSP_NAME(rs.getString("sp_name"));
				studySpaceDto.setSP_SCONTENT(rs.getString("sp_scontent"));
				studySpaceDto.setSP_TAG(rs.getString("sp_tag"));
				studySpaceDto.setFOOTPRINT(rs.getInt("footprint"));
				studySpaceDto.setSP_WEB(rs.getString("sp_web"));
				studySpaceDto.setSP_ST(rs.getString("sp_st"));
				list.add(studySpaceDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		return list;
	}

	@Override
	public List<StudyGroupDto> listStudygroup(Map<String, String> map) {
		List<StudyGroupDto> list = new ArrayList<StudyGroupDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT sno, s_name,s_content,s_tag,s_id,DECODE(S_BEING,'0','대기','1','진행','2','완료') S_BEING, DECODE(S_CURR_STATUS,'1','모집완료','0','모집중') S_CURR_STATUS, s_date \n");
			sql.append("from stg \n");
			String word = map.get("word");
			String date = map.get("date");
			if(!date.isEmpty()) {
				sql.append("where TO_CHAR(s_date,'yyyymmdd') = ? ");
			}
			if(!word.trim().isEmpty()) {
				String key = map.get("key");
				if("s_tag".equals(key)) {
					
					sql.append("where s_TAG like '%'||?||'%' "); 
				} else {
					sql.append("where "+key +"= ? ");
				}
			}	
			pstmt = conn.prepareStatement(sql.toString());
			if(!date.isEmpty()) {
				pstmt.setString(1, date);
			}
			if(!word.trim().isEmpty()) {
				pstmt.setString(1, word);
			}
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				StudyGroupDto studyGroupDto = new StudyGroupDto();
				studyGroupDto.setSNO(rs.getInt("sno"));
				studyGroupDto.setS_NAME(rs.getString("s_name"));
				studyGroupDto.setS_CONTENT(rs.getString("s_content"));
				studyGroupDto.setS_TAG(rs.getString("s_tag"));
				studyGroupDto.setS_ID(rs.getString("S_ID"));
				studyGroupDto.setS_BEING(rs.getString("S_BEING"));
				studyGroupDto.setS_CURR_STATUS(rs.getString("S_CURR_STATUS"));
				list.add(studyGroupDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		return list;
	}

	@Override
	public void updateMemStat(int mno, String stat) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update member \n");
			sql.append("set m_status = ? \n");
			sql.append("where mno = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, stat);
			pstmt.setInt(2, mno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		
	}

	@Override
	public void updateMemTag(int num, String tag) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update member \n");
			sql.append("set m_tag = ? \n");
			sql.append("where mno = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, tag);
			pstmt.setInt(2, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		
	}

	@Override
	public void updateSpStat(int num, String stat) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update space \n");
			sql.append("set sp_st = ? \n");
			sql.append("where spno = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, stat);
			pstmt.setInt(2, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		
	}

	@Override
	public void updateSpTag(int num, String tag) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update SPACE \n");
			sql.append("set sp_tag = ? \n");
			sql.append("where spno = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, tag);
			pstmt.setInt(2, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		
	}

	@Override
	public void updateStgStat(int num, String stat) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update stg \n");
			sql.append("set s_curr_status = ? \n");
			sql.append("where sno = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, stat);
			pstmt.setInt(2, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
	}
	

	@Override
	public void updateBStgStat(int num, String stat) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update stg \n");
			sql.append("set s_being = ? \n");
			sql.append("where sno = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, stat);
			pstmt.setInt(2, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		
	}
	
	@Override
	public void updateStgTag(int num, String tag) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update stg \n");
			sql.append("set s_tag = ? \n");
			sql.append("where sno = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, tag);
			pstmt.setInt(2, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		
	}

}
