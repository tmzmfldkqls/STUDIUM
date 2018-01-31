package com.st.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.st.db.DBClose;
import com.st.db.DBConnection;
import com.st.member.model.MemberDto;

public class MemberDaoImpl implements MemberDao {

	
	private static MemberDao memberDao;
	
	static {
		memberDao = new MemberDaoImpl();
	}
	
	
	public static MemberDao getMemberDao() {
		return memberDao;
	}


	private MemberDaoImpl() {}
	
	
	@Override
	public int registerMember(MemberDto memberDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into member( MNO, M_ID, M_PASS, M_NAME, M_TEL, M_EMAIL, M_TAG, M_DATE, M_STATUS, M_LNUM) \n");
			sql.append("values(SEQ_MNO.NEXTVAL, ?, ?, ?, ?, ?, ?, sysdate, 1, 0)");			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, memberDto.getM_ID());
			pstmt.setString(2, memberDto.getM_PASS());
			pstmt.setString(3, memberDto.getM_NAME());
			pstmt.setString(4, memberDto.getM_TEL());
			pstmt.setString(5, memberDto.getM_EMAIL());
			pstmt.setString(6, memberDto.getM_TAG());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}


	@Override
	public MemberDto login(Map<String, String> map) {
		MemberDto memberDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select MNO, M_ID, M_PASS, M_NAME, M_TEL, M_EMAIL, M_TAG, M_DATE, M_STATUS \n");
			sql.append("from member \n");
			sql.append("where M_ID = ? AND M_PASS = ? AND (M_STATUS= 1 OR M_STATUS= 9) ");		
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, map.get("userid"));
			pstmt.setString(2, map.get("userpwd"));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberDto = new MemberDto();
				memberDto.setMNO(rs.getInt("MNO"));
				memberDto.setM_ID(rs.getString("M_ID"));
				memberDto.setM_NAME(rs.getString("M_NAME"));
				memberDto.setM_PASS(rs.getString("M_PASS"));
				memberDto.setM_EMAIL(rs.getString("M_EMAIL"));
				memberDto.setM_TEL(rs.getString("M_TEL"));
				memberDto.setM_TAG(rs.getString("M_TAG"));
				memberDto.setM_STATUS(rs.getString("M_STATUS"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			memberDto = null;
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		return memberDto;
	}


	@Override
	public MemberDto findid(Map<String, String> map) {
		MemberDto memberDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select MNO, M_ID, M_PASS, M_NAME, M_TEL, M_EMAIL, M_TAG, M_DATE, M_STATUS \n");
			sql.append("from member \n");
			sql.append("where M_NAME = ? AND M_TEL = ? ");		
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, map.get("username"));
			pstmt.setString(2, map.get("usertel"));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberDto = new MemberDto();
				memberDto.setMNO(rs.getInt("MNO"));
				memberDto.setM_ID(rs.getString("M_ID"));
				memberDto.setM_NAME(rs.getString("M_NAME"));
				memberDto.setM_PASS(rs.getString("M_PASS"));
				memberDto.setM_EMAIL(rs.getString("M_EMAIL"));
				memberDto.setM_TEL(rs.getString("M_TEL"));
				memberDto.setM_TAG(rs.getString("M_TAG"));
				memberDto.setM_STATUS(rs.getString("M_STATUS"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			memberDto = null;
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		return memberDto;
	}


	@Override
	public MemberDto findpwd(Map<String, String> map) {
		MemberDto memberDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select MNO, M_ID, M_PASS, M_NAME, M_TEL, M_EMAIL, M_TAG, M_DATE, M_STATUS \n");
			sql.append("from member \n");
			sql.append("where M_ID = ? AND M_EMAIL = ? ");		
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, map.get("userid"));
			pstmt.setString(2, map.get("useremail"));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberDto = new MemberDto();
				memberDto.setMNO(rs.getInt("MNO"));
				memberDto.setM_ID(rs.getString("M_ID"));
				memberDto.setM_NAME(rs.getString("M_NAME"));
				memberDto.setM_PASS(rs.getString("M_PASS"));
				memberDto.setM_EMAIL(rs.getString("M_EMAIL"));
				memberDto.setM_TEL(rs.getString("M_TEL"));
				memberDto.setM_TAG(rs.getString("M_TAG"));
				memberDto.setM_STATUS(rs.getString("M_STATUS"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			memberDto = null;
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return memberDto;
	}


	@Override
	public void updatepwd(int mno, String tmppwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update member \n");
			sql.append("set M_PASS = ? \n");
			sql.append("where MNO = ? ");		
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, tmppwd );
			pstmt.setInt(2, mno);
			cnt = pstmt.executeUpdate();
			if(cnt != 0) {
				System.out.println("업데이트 성공!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		
	}


	@Override
	public int idCheck(String id) {
		int idcount = 1;
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      
	      try {
	         conn = DBConnection.makeConnection();
	         String sql = "";
	         sql += "select count(m_id) \n";
	         sql += "from member \n";
	         sql += "where m_id = ?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, id);
	         rs = pstmt.executeQuery();
	         rs.next();
	         idcount = rs.getInt(1);
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally { 
	         DBClose.close(conn, pstmt, rs);
	      }
	      return idcount;
	}

}
