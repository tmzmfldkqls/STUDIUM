package com.st.studygroup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.st.db.DBClose;
import com.st.db.DBConnection;
import com.st.studygroup.model.ReplyDto;

public class ReplyDaoImpl implements ReplyDao {
	
private static ReplyDao replyDao;
	
	public static ReplyDao getReplyDao() {
	return replyDao;
}

	static {
		replyDao = new ReplyDaoImpl();
	}
	
	
	
	private ReplyDaoImpl() {}
	

	@Override
	public int replyWrite(ReplyDto replyDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();			
			sql.append("insert into bd_rev(rno, mno, bno, wno, rid, r_content, r_date, r_status) \n");
			sql.append("values(SEQ_rno.NEXTVAL, ?, ?, ?, ?, ?, sysdate, 1) ");			
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;	
			pstmt.setInt(++idx, replyDto.getMno());
			pstmt.setInt(++idx, replyDto.getBno());
			pstmt.setInt(++idx, replyDto.getWno());
			pstmt.setString(++idx, replyDto.getRid());
			pstmt.setString(++idx, replyDto.getR_content());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}

	@Override
	public List<ReplyDto> replyList(int WNO) {
		List<ReplyDto> list = new ArrayList<ReplyDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select rno, rid, r_content, r_date \n");
			sql.append("from bd_rev \n");
			sql.append("where wno = ? \n");
			sql.append("order by rno desc \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, WNO);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReplyDto replyDto = new ReplyDto();
				replyDto.setRno(Integer.parseInt(rs.getString("rno")));
				replyDto.setRid(rs.getString("rid"));
				replyDto.setR_content(rs.getString("r_content"));
				replyDto.setR_date(rs.getString("r_date"));				
				list.add(replyDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}


	@Override
	public void replyDelete(int WNO, int RNO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("delete bd_rev \n");
			sql.append("where RNO = ? \n");
			sql.append("AND WNO = ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, RNO);
			pstmt.setInt(2, WNO);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
	}
		
	

}
