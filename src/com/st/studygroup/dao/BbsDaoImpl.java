package com.st.studygroup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.st.db.DBClose;
import com.st.db.DBConnection;
import com.st.studygroup.model.BbsGroupDto;
import com.st.studygroup.model.BoardDto;

public class BbsDaoImpl implements BbsDao {
	
	private static BbsDao bbsDao;
	
	static {
		bbsDao = new BbsDaoImpl();
	}
	
	public static BbsDao getBbsDao() {
		return bbsDao;
	}
	
	private BbsDaoImpl() {}
	

	@Override
	public List<BbsGroupDto> bbsList(int SNO) {
		List<BbsGroupDto> list = new ArrayList<BbsGroupDto>();
		System.out.println("¿ÂÁ¶°³ : " + SNO);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql =  new StringBuffer();
			sql.append("select BD.FNO, BD.BNO, BD.F_ID, BD.F_CONTENT, BD.F_NAME, BD.F_PATH, BD.F_DATE, BD.F_STATUS, \n ");
			sql.append("		BL.BNO, BL.SNO, BL.BTNO \n");
			sql.append("from BD_FILE BD, BD_LIS BL \n");
			sql.append("where BL.BTNO = 2 \n");
			sql.append("AND BD.BNO = BL.BNO \n");
			sql.append("AND BL.SNO = ? \n");
			sql.append("order by BD.FNO desc \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, SNO);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BbsGroupDto bbsGroupDto = new BbsGroupDto();
				bbsGroupDto.setFNO(rs.getInt("FNO"));
				bbsGroupDto.setBNO(rs.getInt("BNO"));
				bbsGroupDto.setF_ID(rs.getString("F_ID"));
				bbsGroupDto.setF_NAME(rs.getString("F_NAME"));
				bbsGroupDto.setF_PATH(rs.getString("F_PATH"));
				bbsGroupDto.setF_CONTENT(rs.getString("F_CONTENT"));
				bbsGroupDto.setF_DATE(rs.getString("F_DATE"));
				bbsGroupDto.setF_STATUS(rs.getString("F_STATUS"));
				list.add(bbsGroupDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public int upLoad(BbsGroupDto bbsGroupDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into BD_FILE(FNO, BNO, F_ID, F_CONTENT, F_NAME, F_PATH, F_DATE, F_STATUS) \n");
			sql.append("	values(SEQ_FNO.nextval, ?, ?, ?, ?, ?, SYSDATE, 1) \n");
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			pstmt.setInt(++idx, bbsGroupDto.getBNO());
			pstmt.setString(++idx, bbsGroupDto.getF_ID());
			pstmt.setString(++idx, bbsGroupDto.getF_CONTENT());
			pstmt.setString(++idx, bbsGroupDto.getF_NAME());
			pstmt.setString(++idx, bbsGroupDto.getF_PATH());
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
	public BbsGroupDto downLoad(String fileName) {
		BbsGroupDto bbsGroupDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql =  new StringBuffer();
			sql.append("select BD.FNO, BD.BNO, BD.F_ID, BD.F_CONTENT, BD.F_NAME, BD.F_PATH, BD.F_DATE, BD.F_STATUS \n ");
			sql.append("from BD_FILE BD, BD_LIS BL \n");
			sql.append("where BL.BTNO = 2 \n");
			sql.append("AND BD.F_NAME = ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, fileName);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bbsGroupDto = new BbsGroupDto();
				bbsGroupDto.setFNO(rs.getInt("FNO"));
				bbsGroupDto.setBNO(rs.getInt("BNO"));
				bbsGroupDto.setF_ID(rs.getString("F_ID"));
				bbsGroupDto.setF_NAME(fileName);
				bbsGroupDto.setF_PATH(rs.getString("F_PATH"));
				bbsGroupDto.setF_CONTENT(rs.getString("F_CONTENT"));
				bbsGroupDto.setF_DATE(rs.getString("F_DATE"));
				bbsGroupDto.setF_STATUS(rs.getString("F_STATUS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(conn, pstmt, rs);
		}

		return bbsGroupDto;
	}

}
