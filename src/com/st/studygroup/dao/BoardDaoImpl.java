package com.st.studygroup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.st.db.DBClose;
import com.st.db.DBConnection;
import com.st.member.model.MemberDto;
import com.st.studygroup.model.BoardDto;
import com.st.studygroup.model.BoardListDto;
import com.st.studygroup.model.StudyGroupDto;

public class BoardDaoImpl implements BoardDao {
	
	private static BoardDao boardDao;
	
	static {
		boardDao = new BoardDaoImpl();
	}
	
	public static BoardDao getBoardDao() {
		return boardDao;
	}
	
	private BoardDaoImpl() {}
	
	@Override
	public int writeArticle(BoardDto boardDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();			
			sql.append("insert into board(WNO, BNO, W_ID, W_NAME, W_TITLE, W_CONTENT, W_DATE, W_CLICKNUM, W_STATUS) \n");
			sql.append("values(SEQ_WNO.NEXTVAL,  ?, ?, ?, ?, ?, sysdate, 1, 1) ");			
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;	
			pstmt.setInt(++idx, boardDto.getBNO());
			pstmt.setString(++idx, boardDto.getW_ID());
			pstmt.setString(++idx, boardDto.getW_NAME());
			pstmt.setString(++idx, boardDto.getW_TITLE());
			pstmt.setString(++idx, boardDto.getW_CONTENT());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}

	
	
	@Override
	public BoardDto viewArticle(int WNO) {
		BoardDto boardDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select WNO, BNO, W_ID, W_NAME, W_TITLE, W_CONTENT, W_DATE, W_CLICKNUM, W_STATUS \n");
			sql.append("from BOARD \n");
			sql.append("where WNO = ? \n");
			sql.append("AND W_STATUS = 1 ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, WNO);
			rs = pstmt.executeQuery();
			if(rs.next()){
				boardDto = new BoardDto();
				boardDto.setWNO(rs.getInt("WNO"));
				boardDto.setBNO(rs.getInt("BNO"));
				boardDto.setW_ID(rs.getString("W_ID"));
				boardDto.setW_NAME(rs.getString("W_NAME"));
				boardDto.setW_TITLE(rs.getString("W_TITLE"));
				boardDto.setW_CONTENT(rs.getString("W_CONTENT"));
				boardDto.setW_DATE(rs.getString("W_DATE"));
				boardDto.setW_CLICKNUM(rs.getInt("W_CLICKNUM"));
				boardDto.setW_STATUS(rs.getString("W_STATUS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return boardDto;
	}

	@Override
	public void deleteArticle(int WNO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update board \n");
			sql.append("set W_STATUS = 0 \n");
			sql.append("WHERE WNO = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, WNO);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
	}

	@Override
	public void modifyArticle(BoardDto boardDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update board \n");
			sql.append("set W_TITLE=?, W_CONTENT=? \n");
			sql.append("WHERE WNO = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, boardDto.getW_TITLE());
			pstmt.setString(2, boardDto.getW_CONTENT());
			pstmt.setInt(3, boardDto.getWNO());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		
	}

	@Override
	public List<BoardDto> noticelist(int SNO) {
		List<BoardDto> list = new ArrayList<BoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql =  new StringBuffer();
			sql.append("select B.WNO, B.BNO, B.W_ID, B.W_NAME, B.W_TITLE, B.W_CONTENT, B.W_DATE, B.W_CLICKNUM, B.W_STATUS, \n ");
			sql.append("		BL.BNO, BL.SNO, BL.BTNO \n");
			sql.append("from BOARD B, BD_LIS BL \n");
			sql.append("where BL.BTNO = 1 \n");
			sql.append("AND B.W_STATUS = 1 \n");
			sql.append("AND BL.BNO = B.BNO \n");
			sql.append("AND BL.SNO = ? \n");
			sql.append("order by B.WNO desc ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, SNO);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setWNO(rs.getInt("WNO"));
				boardDto.setBNO(rs.getInt("BNO"));
				boardDto.setSNO(rs.getInt("SNO"));
				boardDto.setW_ID(rs.getString("W_ID"));
				boardDto.setW_NAME(rs.getString("W_NAME"));
				boardDto.setW_TITLE(rs.getString("W_TITLE"));
				boardDto.setW_CONTENT(rs.getString("W_CONTENT"));
				boardDto.setW_DATE(rs.getString("W_DATE"));
				boardDto.setW_CLICKNUM(rs.getInt("W_CLICKNUM"));
				boardDto.setW_STATUS(rs.getString("W_STATUS"));
				list.add(boardDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return list;
	}
}
