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
import com.st.member.model.MemberDto;
import com.st.studygroup.model.BoardDto;
import com.st.studygroup.model.BoardListDto;
import com.st.studygroup.model.StudyGroupApplyDto;
import com.st.studygroup.model.StudyGroupDto;

public class StudyGroupDaoImpl implements StudyGroupDao {
	
	private static StudyGroupDao studyGroupDao;
	
	static {
		studyGroupDao = new StudyGroupDaoImpl();
	}
	
	public static StudyGroupDao getStudyGroupDao() {
		return studyGroupDao;
	}
	
	private StudyGroupDaoImpl() {}
	

	public List<StudyGroupDto> listarticle(Map<String, String> map) {
		List<StudyGroupDto> list = new ArrayList<StudyGroupDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			try {
				conn = DBConnection.makeConnection();
				StringBuffer sql = new StringBuffer();
				
				sql.append("select b.* \n");
				sql.append("from ( \n");
				sql.append("		select rownum rn, a.* \n");
				sql.append("		from ( \n");
				sql.append("				select SNO, MNO, S_ID, S_NAME, S_CONTENT, S_TAG, S_MEMBER, S_PERSON, S_MAXPERSON, \n");
				sql.append(" 						DECODE(S_CURR_STATUS, '0','모집중','모집완료') S_CURR_STATUS, \n");
				sql.append(" 						DECODE(S_BEING, '0','대기중', '1','진행중','2','완료') S_BEING \n");
				sql.append("				from STG \n");
				String word = map.get("word");
				if(!word.isEmpty()) {
					sql.append("			where S_TAG like '%'||?||'%' \n");
				}
				sql.append("				order by SNO desc");
				sql.append("                ) a \n");
				sql.append("         where rownum <=  ?  \n");
				sql.append("	 ) b \n");
				sql.append(" where b.rn > ?  \n");
				pstmt = conn.prepareStatement(sql.toString());
				int idx = 0;
				if(!word.isEmpty()) {
					pstmt.setString(++idx, word);
				}
				pstmt.setString(++idx, map.get("end"));
				pstmt.setString(++idx, map.get("start"));
				rs = pstmt.executeQuery();
				while (rs.next()) {
					StudyGroupDto studyGroupDto = new StudyGroupDto();
					studyGroupDto.setSNO(rs.getInt("SNO"));
					studyGroupDto.setMNO(rs.getInt("MNO"));
					studyGroupDto.setS_ID(rs.getString("S_ID"));
					studyGroupDto.setS_NAME(rs.getString("S_NAME"));
					studyGroupDto.setS_CONTENT(rs.getString("S_CONTENT"));
					studyGroupDto.setS_TAG(rs.getString("S_TAG"));
					studyGroupDto.setS_MEMBER(rs.getString("S_MEMBER"));
					studyGroupDto.setS_PERSON(rs.getInt("S_PERSON"));
					studyGroupDto.setS_MAXPERSON(rs.getInt("S_MAXPERSON"));
					studyGroupDto.setS_CURR_STATUS(rs.getString("S_CURR_STATUS"));					
					studyGroupDto.setS_BEING(rs.getString("S_BEING"));
					list.add(studyGroupDto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBClose.close(conn, pstmt, rs);
			}
		return list;
	}

	@Override
	public int registerStudyGroup(StudyGroupDto studygroupDto) {
		/*CURR_STATUS = 0. 진행중 1. 완료 2.삭제
		 *BEING = 0.진행중 1.종료
		 */
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.makeConnection();
			conn.setAutoCommit(false);
			StringBuffer sql = new StringBuffer();
			sql.append("insert into STG(SNO, MNO, S_ID, S_NAME, S_CONTENT, S_TAG, S_MEMBER, S_PERSON, S_MAXPERSON, S_CURR_STATUS, S_BEING, S_DATE) \n");
			sql.append("	values(SEQ_SNO.NEXTVAL, ?, ?, ?, ?, ?, '', 1, ?, 0, 0, sysdate) \n");
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			pstmt.setInt(++idx, studygroupDto.getMNO());
			pstmt.setString(++idx, studygroupDto.getS_ID());
			pstmt.setString(++idx, studygroupDto.getS_NAME());
			pstmt.setString(++idx, studygroupDto.getS_CONTENT());
			pstmt.setString(++idx, studygroupDto.getS_TAG());
			pstmt.setInt(++idx, studygroupDto.getS_MAXPERSON());
			pstmt.executeUpdate();
			pstmt.close();
			conn.commit();
			
			StringBuffer sql2 = new StringBuffer();
			sql2.append("insert into BD_LIS(BNO, SNO, BTNO) \n");
			sql2.append("	values(SEQ_BNO.NEXTVAL, SEQ_SNO.CURRVAL, 1) \n");
			pstmt = conn.prepareStatement(sql2.toString());			
			pstmt.executeUpdate();
			pstmt.close();
			
			StringBuffer sql1 = new StringBuffer();
			sql1.append("	insert into BD_LIS(BNO, SNO, BTNO) \n");
			sql1.append("	values(SEQ_BNO.NEXTVAL,SEQ_SNO.CURRVAL, 2) \n");
			pstmt = conn.prepareStatement(sql1.toString());
			pstmt.executeUpdate();
			conn.commit();
			
			
			cnt = 1;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
				cnt=0;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}

	@Override
	public List<StudyGroupDto> listmyArticle(MemberDto memberDto) {
		List<StudyGroupDto> list = new ArrayList<StudyGroupDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select SNO, MNO, S_ID, S_NAME, S_CONTENT, S_TAG, S_MEMBER, S_PERSON, S_MAXPERSON,DECODE(S_CURR_STATUS, '0','모집중','1','모집완료') S_CURR_STATUS, DECODE(S_BEING, '0','대기중', '1','진행중','2','완료') S_BEING \n");
			sql.append("from STG \n");
			sql.append("where S_ID = ? \n");
			sql.append("order by SNO desc");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, memberDto.getM_ID());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				StudyGroupDto studyGroupDto = new StudyGroupDto();
				studyGroupDto.setSNO(rs.getInt("SNO"));
				studyGroupDto.setMNO(rs.getInt("MNO"));
				studyGroupDto.setS_ID(rs.getString("S_ID"));
				studyGroupDto.setS_NAME(rs.getString("S_NAME"));
				studyGroupDto.setS_CONTENT(rs.getString("S_CONTENT"));
				studyGroupDto.setS_TAG(rs.getString("S_TAG"));
				studyGroupDto.setS_MEMBER(rs.getString("S_MEMBER"));
				studyGroupDto.setS_PERSON(rs.getInt("S_PERSON"));
				studyGroupDto.setS_MAXPERSON(rs.getInt("S_MAXPERSON"));
				studyGroupDto.setS_CURR_STATUS(rs.getString("S_CURR_STATUS"));
				studyGroupDto.setS_BEING(rs.getString("S_BEING"));
				list.add(studyGroupDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<BoardListDto> myGroupContent(int SNO) {
		List<BoardListDto> list = new ArrayList<BoardListDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql =  new StringBuffer();
			sql.append("select BNO, SNO, BTNO \n ");
			sql.append("  from BD_LIS \n");
			sql.append(" where SNO = ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, SNO);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardListDto boardListDto = new BoardListDto();
				boardListDto.setBNO(rs.getInt("BNO"));
				boardListDto.setSNO(rs.getInt("SNO"));
				boardListDto.setBTNO(rs.getInt("BTNO"));
				list.add(boardListDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return list;
	}

	@Override
	public StudyGroupDto viewGroupContent(int SNO) {
		StudyGroupDto studyGroupDto = new StudyGroupDto();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select SNO, MNO, S_ID, S_NAME, S_CONTENT, S_TAG, S_MEMBER, S_PERSON, S_MAXPERSON, DECODE(S_CURR_STATUS, '0','모집중','1','모집완료') S_CURR_STATUS, DECODE(S_BEING, '0','대기중', '1','진행중','2','완료') S_BEING \n");
			sql.append("from STG \n");
			sql.append("where SNO = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, SNO);
			System.out.println(SNO);
			rs = pstmt.executeQuery();
			if(rs.next()){
				studyGroupDto.setSNO(rs.getInt("SNO"));
				studyGroupDto.setMNO(rs.getInt("MNO"));
				studyGroupDto.setS_ID(rs.getString("S_ID"));
				studyGroupDto.setS_NAME(rs.getString("S_NAME"));
				studyGroupDto.setS_CONTENT(rs.getString("S_CONTENT"));
				studyGroupDto.setS_TAG(rs.getString("S_TAG"));
				studyGroupDto.setS_MEMBER(rs.getString("S_MEMBER"));
				studyGroupDto.setS_PERSON(rs.getInt("S_PERSON"));
				studyGroupDto.setS_MAXPERSON(rs.getInt("S_MAXPERSON"));
				studyGroupDto.setS_CURR_STATUS(rs.getString("S_CURR_STATUS"));
				studyGroupDto.setS_BEING(rs.getString("S_BEING"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return studyGroupDto;
	}

	@Override
	public List<BoardDto> notice(int SNO) {
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
			sql.append("AND SNO = ? \n");
			sql.append("AND  B.W_STATUS = 1");
			sql.append("AND BL.BNO = B.BNO \n");
			sql.append("ORDER BY B.WNO DESC ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, SNO);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setWNO(rs.getInt("WNO"));
				boardDto.setBNO(rs.getInt("BNO"));
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
	
	@Override
	public void modifyStudyGroup(StudyGroupDto studyGroupDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update stg \n");
			sql.append("set S_NAME=?, S_CONTENT = ?, S_TAG = ?, S_ID = ?, S_MAXPERSON = ?,  \n");
			System.out.println("SPERSON>>>>>" + studyGroupDto.getS_PERSON());
			System.out.println("MAXPERSON>>>>>>" + studyGroupDto.getS_MAXPERSON());
			if(studyGroupDto.getS_PERSON() < studyGroupDto.getS_MAXPERSON()) {
				sql.append(" S_CURR_STATUS = '0', \n");
			} else {
				sql.append(" S_CURR_STATUS = '1', \n");
			}
			sql.append("		S_BEING = ? \n");
			sql.append("WHERE SNO = ?");
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			pstmt.setString(++idx, studyGroupDto.getS_NAME());
			pstmt.setString(++idx, studyGroupDto.getS_CONTENT());
			pstmt.setString(++idx, studyGroupDto.getS_TAG());
			pstmt.setString(++idx, studyGroupDto.getS_ID());
			pstmt.setInt(++idx, studyGroupDto.getS_MAXPERSON());
			pstmt.setString(++idx, studyGroupDto.getS_BEING());
			pstmt.setInt(++idx, studyGroupDto.getSNO());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}

	}

	@Override
	public int studyGroupApply(StudyGroupApplyDto studyGroupApplyDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into STG_AP(APNO, MNO, SNO, AP_ID, AP_CONTENT, AP_STATUS) \n");
			sql.append("	values(SEQ_APNO.NEXTVAL, ?, ?, ?, ?, 1) \n");
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			pstmt.setInt(++idx, studyGroupApplyDto.getMNO());
			pstmt.setInt(++idx, studyGroupApplyDto.getSNO());
			pstmt.setString(++idx, studyGroupApplyDto.getAP_ID());
			pstmt.setString(++idx, studyGroupApplyDto.getAP_CONTENT());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}

	@Override
	public List<StudyGroupDto> includeMeList(MemberDto memberDto) {
		List<StudyGroupDto> list = new ArrayList<StudyGroupDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			System.out.println("111111111111111");
			StringBuffer sql = new StringBuffer();
			System.out.println("2222222222");
			sql.append("select STG.SNO, STG.MNO, STG.S_ID, STG.S_NAME, STG.S_CONTENT, STG.S_TAG, \n");
			sql.append(" 		STG.S_MEMBER, STG.S_PERSON, STG.S_MAXPERSON, \n");
			sql.append(" 		DECODE(STG.S_CURR_STATUS, '0', '모집중', '1', '모집완료') S_CURR_STATUS, \n");
			sql.append(" 		DECODE(STG.S_BEING, '0', '대기중', '1', '진행중', '2', '완료') S_BEING, \n");
			sql.append(" 		STM.SMNO, STM.SNO, STM.MNO \n");
			sql.append("from STG STG, STG_MM STM \n");
			sql.append("where STG.SNO = STM.SNO \n");
			sql.append("and STM.MNO = ? \n");
			sql.append("order by STG.SNO desc ");
			System.out.println("444444444444444");
			pstmt = conn.prepareStatement(sql.toString());
			System.out.println("33333333333333");
			pstmt.setInt(1, memberDto.getMNO());
			System.out.println("555555555555");
			rs = pstmt.executeQuery();
			System.out.println("666666666666666");
				while (rs.next()) {
					System.out.println("777777777777777");
					StudyGroupDto studyGroupDto = new StudyGroupDto();
					studyGroupDto.setSNO(rs.getInt("SNO"));
					studyGroupDto.setMNO(rs.getInt("MNO"));
					studyGroupDto.setS_ID(rs.getString("S_ID"));
					studyGroupDto.setS_NAME(rs.getString("S_NAME"));
					studyGroupDto.setS_CONTENT(rs.getString("S_CONTENT"));
					studyGroupDto.setS_TAG(rs.getString("S_TAG"));
					studyGroupDto.setS_MEMBER(rs.getString("S_MEMBER"));
					studyGroupDto.setS_PERSON(rs.getInt("S_PERSON"));
					studyGroupDto.setS_MAXPERSON(rs.getInt("S_MAXPERSON"));
					if (rs.getInt("S_PERSON") == rs.getInt("S_MAXPERSON")) {
						studyGroupDto.setS_CURR_STATUS("1");
					} else {
						studyGroupDto.setS_CURR_STATUS(rs.getString("S_CURR_STATUS"));
					}
					studyGroupDto.setS_BEING(rs.getString("S_BEING"));
					list.add(studyGroupDto);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}
	
	

}
