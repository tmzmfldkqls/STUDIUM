package com.st.studyroom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.st.alarm.model.AlarmDto;
import com.st.db.DBClose;
import com.st.db.DBConnection;
import com.st.member.model.MemberDto;
import com.st.studyroom.model.ReservationDto;
import com.st.studyroom.model.RmAlbDto;
import com.st.studyroom.model.StudyRoomDto;
import com.st.studyroom.model.StudySpaceDto;
import com.st.studyroom.model.ZipDto;

public class StudyRoomDaoImpl implements StudyRoomDao {

	private static StudyRoomDao studyRoomDao;
	
	static {
		studyRoomDao = new StudyRoomDaoImpl();
	}
	
	private StudyRoomDaoImpl() {}
	
	public static StudyRoomDao getStudyRoomDao() {
		return studyRoomDao;
	}
	@Override
	public int registerSpace(StudySpaceDto studySpaceDto , int mno, String id,int seq) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert	into space(mno,sp_id, sp_name,sp_scontent,sp_content,sp_tag,sp_img,sp_flag,sp_web,footprint,spno,sp_st,sp_date ) \n");
			sql.append("			values ( ?, ?, 	?,?,?,?,?, ?, ?, 0,?,'1',sysdate) \n");
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;			
			pstmt.setInt(++idx, mno);
			pstmt.setString(++idx,id);
			pstmt.setString(++idx, studySpaceDto.getSP_NAME());
			pstmt.setString(++idx, studySpaceDto.getSP_SCONTENT());
			pstmt.setString(++idx, studySpaceDto.getSP_CONTENT());
			
			pstmt.setString(++idx, studySpaceDto.getSP_TAG());
			//pstmt.setString(++idx, studySpaceDto.getSP_IMG());//이미지 완료 한 다음에 채워 넣을 자리
			pstmt.setString(++idx, "invalid");
			pstmt.setInt(++idx, studySpaceDto.getSP_FLAG());
			pstmt.setString(++idx, studySpaceDto.getSP_WEB());
			pstmt.setInt(++idx, seq);						
			cnt = pstmt.executeUpdate();
			pstmt.close();
			
			idx=0;
			StringBuffer sql2 = new StringBuffer();
			sql2.append("insert	into sp_add(spno,sp_si,sp_gugun,sp_dong,ap_bunji,sp_detail_addr,sp_geo) \n");
			sql2.append("			values (?,?,?,?,?,?,?) \n");		
			
			pstmt = conn.prepareStatement(sql2.toString());	
			pstmt.setInt(++idx, seq);
			pstmt.setString(++idx, studySpaceDto.getSP_SI());
			pstmt.setString(++idx, studySpaceDto.getSP_GUGUN());
			pstmt.setString(++idx, studySpaceDto.getSP_DONG());
			pstmt.setString(++idx, studySpaceDto.getAP_BUNJI());
			pstmt.setString(++idx, studySpaceDto.getSP_DETAIL_addr());
			pstmt.setString(++idx, studySpaceDto.getSP_GEO());
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}

	@Override
	public int registerRoom(List<StudyRoomDto> list, int sp_seq) {
		int cnt = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				conn = DBConnection.makeConnection();
				StringBuffer sql = new StringBuffer();
				StringBuffer sql2 = new StringBuffer();
				
				
				sql.append("insert all \n");
				int len = list.size();
				for(int i=0;i<len;i++){
					sql.append("into room(rm_no,spno,rm_name,rm_conv,rm_min_person,rm_min_time,rm_price,rm_caution,rm_holi,rm_tel,rm_max_person,rm_st)\n");
					sql.append("values(SEQ_RM_NO.nextval+"+i+",?,?,?,?,?,?,?,'holly',?,?,'1') \n");//i 만큼 큰 값을 집어 넣은 다음
				}
				sql.append("select *\n");
				sql.append("from dual\n");
				pstmt = conn.prepareStatement(sql.toString());
				
				int idx=0;
				for(int i=0;i<len;i++){
					pstmt.setInt(++idx,sp_seq);
					pstmt.setString(++idx,list.get(i).getRM_NAME());
					pstmt.setString(++idx,list.get(i).getRM_CONV());
					pstmt.setInt(++idx,list.get(i).getRM_MIN_PERSON());
					pstmt.setString(++idx,list.get(i).getRM_MIN_TIME());
					pstmt.setInt(++idx,list.get(i).getRM_PRICE());
					pstmt.setString(++idx,list.get(i).getRM_CAUTION());
					pstmt.setString(++idx,list.get(i).getRM_TEL());
					pstmt.setInt(++idx,list.get(i).getRM_MAX_PERSON());				
				}	
				cnt = pstmt.executeUpdate();

				//시퀀스 값 증가시켜주기
				sql2.append("select seq_rm_no.nextval from dual");
				if(len == 1)
					;//리스트가 1이면 아귀가 자동으로 맞음
				else 
					for(int i=0;i<len-1;i++){
						pstmt = conn.prepareStatement(sql2.toString());
						pstmt.executeUpdate();
					}
					

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBClose.close(conn, pstmt);
			}
			
			return cnt;
	}

	@Override
	public int registerImg(RmAlbDto rmAlbDto) {
		
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			StringBuffer sql2 = new StringBuffer();
			
			sql.append("insert into rm_alb\n");
			sql.append("(ino,spno,i_status,origin_img,save_img,savefolder)\n");
			sql.append("values(seq_ino.nextval,?,'1',?,?,?)\n");
			pstmt = conn.prepareStatement(sql.toString());
			
			int idx = 0;
			pstmt.setInt(++idx, rmAlbDto.getSPNO());
			pstmt.setString(++idx, rmAlbDto.getORIGIN_IMG());
			pstmt.setString(++idx, rmAlbDto.getSAVE_IMG());
			pstmt.setString(++idx, rmAlbDto.getSAVEFOLDER());
			cnt = pstmt.executeUpdate();
			pstmt.close();
			
			sql2.append("update space set sp_img= ? where spno = ?");
			idx=0;
			pstmt = conn.prepareStatement(sql2.toString());
			pstmt.setString(++idx,rmAlbDto.getSAVEFOLDER() + "/" +rmAlbDto.getSAVE_IMG());
			pstmt.setInt(++idx, rmAlbDto.getSPNO());

			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		
		return cnt;
	}
	@Override
	public int registerImgList(List<RmAlbDto> list) {
		
		System.out.println("리스트이미지dao 호출됨 "+list.get(0).getORIGIN_IMG());
		
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
			
			try {
				conn = DBConnection.makeConnection();
				StringBuffer sql = new StringBuffer();
				StringBuffer sql2 = new StringBuffer();
				
				
				sql.append("insert all \n");
				int len = list.size();
				for(int i=0;i<len;i++){
					sql.append("into rm_alb(ino,spno,i_status,origin_img,save_img,savefolder)\n");
					sql.append("values(SEQ_INO.nextval+"+i+",?,?,?,?,?) \n");//i 만큼 큰 값을 집어 넣은 다음
				}
				sql.append("select *\n");
				sql.append("from dual\n");
				pstmt = conn.prepareStatement(sql.toString());
				
				int idx=0;
				for(int i=0;i<len;i++){
					pstmt.setInt(++idx,list.get(i).getSPNO());
					pstmt.setString(++idx,list.get(i).getI_STATUS());
					pstmt.setString(++idx,list.get(i).getORIGIN_IMG());
					pstmt.setString(++idx,list.get(i).getSAVE_IMG());
					pstmt.setString(++idx,list.get(i).getSAVEFOLDER());				
						
				}	
				cnt = pstmt.executeUpdate();

				//시퀀스 값 증가시켜주기
				sql2.append("select seq_ino.nextval from dual");
				if(len == 1)
					;//리스트가 1이면 아귀가 자동으로 맞음
				else 
					for(int i=0;i<len-1;i++){
						pstmt = conn.prepareStatement(sql2.toString());
						pstmt.executeUpdate();
					}
					

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBClose.close(conn, pstmt);
			}
			return cnt;
	}

	@Override
	public List<RmAlbDto> pickImages(int spno) {
		
		List<RmAlbDto> list = new ArrayList<RmAlbDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select savefolder,save_img\n");
			sql.append("from rm_alb\n");
			sql.append("where spno = ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;			

			pstmt.setInt(++idx, spno);
            rs = pstmt.executeQuery();
			while(rs.next()) {
				RmAlbDto rmAlbDto = new RmAlbDto();
				rmAlbDto.setSAVE_IMG(rs.getString("save_img"));
				rmAlbDto.setSAVEFOLDER(rs.getString("savefolder"));
				
				list.add(rmAlbDto);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}
	
	@Override
	public List<StudyRoomDto> pickSpace(int spno) {
		
		List<StudyRoomDto> list = new ArrayList<StudyRoomDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select s.sp_flag,s.sp_content,s.sp_name,s.sp_web, r.rm_name,r.rm_conv,r.rm_min_time,r.rm_price,r.rm_holi,r.rm_tel,r.rm_max_person,r.rm_no \n");
			sql.append("from room r, space s \n");
			sql.append("where r.spno = s.spno and s.spno = ? \n");
			sql.append("order by r.rm_no desc\n");
			
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;			

			pstmt.setInt(++idx, spno);
            rs = pstmt.executeQuery();
			while(rs.next()) {
				StudyRoomDto studyRoomDto = new StudyRoomDto();
				studyRoomDto.setSP_FLAG(rs.getInt("sp_flag"));
				studyRoomDto.setSP_SCONTENT(rs.getString("sp_content"));
				studyRoomDto.setSP_NAME(rs.getString("sp_name"));
				
				studyRoomDto.setRM_NAME(rs.getString("rm_name"));
				studyRoomDto.setSP_WEB(rs.getString("sp_web"));
				
				studyRoomDto.setRM_CONV(rs.getString("rm_conv"));
				studyRoomDto.setRM_MIN_TIME(rs.getString("rm_min_time"));
				studyRoomDto.setRM_PRICE(rs.getInt("rm_price"));
				studyRoomDto.setRM_HOLI(rs.getString("rm_holi"));
				
				studyRoomDto.setRM_TEL(rs.getString("rm_tel"));
				studyRoomDto.setRM_MAX_PERSON(rs.getInt("rm_max_person"));
				studyRoomDto.setRM_NO(rs.getInt("rm_no"));
				list.add(studyRoomDto);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<ZipDto> zipSearch(String dong) {
		List<ZipDto> list = new ArrayList<ZipDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			String sql = "";
			sql += "select  zipcode, \r\n" + 
					"		si, gugun, dong, nvl(bunji, ' ') bunji\r\n" + 
					"from zip\r\n" + 
					"where dong like ?||'%'";//dong + "%"
			pstmt = conn.prepareStatement(sql);//conn.createStatement();
			pstmt.setString(1, dong);
			rs = pstmt.executeQuery();//stmt.executeUpdate(sql);
			while(rs.next()) {
				ZipDto zipDto = new ZipDto();
				zipDto.setZIPCODE(rs.getString("zipcode"));
				zipDto.setSI(rs.getString("si"));
				zipDto.setGUGUN(rs.getString("gugun"));
				zipDto.setDONG(rs.getString("dong"));
				zipDto.setBUNJI(rs.getString("bunji"));
				
				list.add(zipDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}
	
	@Override
	public List<StudySpaceDto> selectlist(Map<String, String> map) {
		
		  List<StudySpaceDto> list = new ArrayList<StudySpaceDto>();
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      try {
	    	  
	         conn = DBConnection.makeConnection();
	         StringBuffer sql = new StringBuffer();
	         sql.append("select s.spno,s.sp_img,s.sp_scontent,a.address \n");
	         sql.append(" from space s, (\n");
	         sql.append("		select sp_si||sp_gugun||sp_dong||sp_detail_addr as address, spno\n");
	         sql.append("		from sp_add\n");
	         sql.append("		) a\n");
	         sql.append("where s.spno = a.spno\n");
	         String word = map.get("word");
	         if(word != null && !word.trim().isEmpty()) {
	            String key = map.get("key");
	            if("address".equals(key)) {
	            	sql.append(" and a.address like '%'||?||'%'");
	            }else if("tag".equals(key)) {	
	            	sql.append(" and s.sp_tag like '%'||?||'%'");
	            }else if("sp_name".equals(key)) {	
	            	sql.append(" and s.sp_name like '%'||?||'%'");
	            }
	         }
	         
			 pstmt = conn.prepareStatement(sql.toString());
			 
			 if(word != null && !word.trim().isEmpty()){
				 pstmt.setString(1, word);
			 }
			 rs = pstmt.executeQuery();
			 while(rs.next()) {
			        	 StudySpaceDto studySpaceDto = new StudySpaceDto();
							
							studySpaceDto.setSP_SCONTENT(rs.getString("sp_scontent"));
							studySpaceDto.setSP_IMG(rs.getString("sp_img"));
							studySpaceDto.setSPNO(rs.getInt("spno"));
							
							list.add(studySpaceDto);
			         }
	      	}catch (SQLException e) {
	 			e.printStackTrace();
	 		} finally {
	 			DBClose.close(conn, pstmt, rs);
	 		}
	 		return list;
	}

	@Override
	public List<ReservationDto> reservationlist(int rmnoForRsv, String date) {

		  List<ReservationDto> list = new ArrayList<ReservationDto>();
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      try {   	  
	         conn = DBConnection.makeConnection();
	         StringBuffer sql = new StringBuffer();

	         sql.append("select  rmr_date_in,  rmr_date_out, rmr_time_in,rmr_time_out ,rm_no,rmrno \n");
	         sql.append(" from rm_res\n");
	         sql.append("where rm_no = ?  and  (\n");
	         sql.append("to_char(rmr_date_in,'yyyy-mm-dd') = ? OR\n");	     
	         sql.append("to_char(rmr_date_out,'yyyy-mm-dd') = ? )\n");	
			 pstmt = conn.prepareStatement(sql.toString());
			
		
			 pstmt.setInt(1, rmnoForRsv);
			 pstmt.setString(2, date);
			 pstmt.setString(3, date);
			 rs = pstmt.executeQuery();

			 while(rs.next()) {
				 ReservationDto reservationDto = new ReservationDto();
							
				 reservationDto.setRMR_DATE_IN(rs.getString("rmr_date_in"));
				 reservationDto.setRMR_DATE_OUT(rs.getString("rmr_date_out"));
				 reservationDto.setRMR_TIME_IN(rs.getString("rmr_time_in"));
				 reservationDto.setRMR_TIME_OUT(rs.getString("rmr_time_out"));
				 reservationDto.setRMRNO(rs.getInt("rmrno"));
				 list.add(reservationDto);
			         }
	      	}catch (SQLException e) {
	 			e.printStackTrace();
	 		} finally {
	 			DBClose.close(conn, pstmt, rs);
	 		}
	 		return list;
	}
	@Override
	public int roomReservation(ReservationDto reservationDto) {
		
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			StringBuffer sql2 = new StringBuffer();
			
			sql.append("insert into rm_res\n");
			sql.append("(rmrno,rm_no,mno,rmr_id,rmr_price,rmr_person,rmr_date_in,rmr_date_out,rmr_time_in,rmr_time_out,rmr_tel,rmr_email,rmr_date,rmr_content)\n");
			sql.append("values(seq_rmrno.nextval,?,?,?,?,?,to_date(?,'yy-mm-dd'),to_date(?,'yy-mm-dd'),?,?,?,?,sysdate,?)\n");
			pstmt = conn.prepareStatement(sql.toString());

			int idx = 0;
	
			pstmt.setInt(++idx, reservationDto.getRM_NO());
			pstmt.setInt(++idx, reservationDto.getMNO());
			pstmt.setString(++idx, reservationDto.getRMR_ID());
			pstmt.setInt(++idx, reservationDto.getRMR_PRICE());
			pstmt.setInt(++idx, reservationDto.getRMR_PERSON());
			pstmt.setString(++idx, reservationDto.getRMR_DATE_IN());
			pstmt.setString(++idx, reservationDto.getRMR_DATE_OUT());
			pstmt.setString(++idx, reservationDto.getRMR_TIME_IN());
			pstmt.setString(++idx, reservationDto.getRMR_TIME_OUT());
			pstmt.setString(++idx, reservationDto.getRMR_TEL());
			
			pstmt.setString(++idx, reservationDto.getRMR_EMAIL());
			pstmt.setString(++idx, reservationDto.getRMR_CONTENT());
			
			cnt = pstmt.executeUpdate();
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}	
		return cnt;
	}


}