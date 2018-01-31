package com.st.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.st.db.DBClose;
import com.st.db.DBConnection;
import com.st.studyroom.dao.StudyRoomDao;
import com.st.studyroom.dao.StudyRoomDaoImpl;

public class CommonDaoImpl implements CommonDao{

private static  CommonDao  commonDao;
	
	static {
		 commonDao = new  CommonDaoImpl();
	}
	
	private  CommonDaoImpl() {}
	
	public static  CommonDao getCommonDao() {
		return  commonDao;
	}
	
	@Override
	public int selectSPNO() {
		
		int sp_no=-1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.makeConnection();
			String sql = "";
			sql += "select SEQ_SPNO.nextval from dual";
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery(sql);
			
			if(rs.next())
				sp_no = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		System.out.println(sp_no);
		return  sp_no;
	}

	@Override
	public void updateLNUM(int mno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update member \n");
			sql.append("set M_LNUM = M_LNUM + 1 \n");
			sql.append("where MNO = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, mno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
	}

	@Override
	public int getTotalGroupCount(String word) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT COUNT(SNO) \n");
			sql.append("FROM STG \n");
			if(!word.isEmpty()) {
				sql.append("where S_TAG LIKE '%'||?||'%' ");
			}
			pstmt = conn.prepareStatement(sql.toString());
			if(!word.isEmpty())
				pstmt.setString(1, word);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return cnt;
	}

}
