package com.st.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.st.db.DBClose;
import com.st.db.DBConnection;
import com.st.member.model.MemberDto;
import com.st.studyroom.model.ReservationDto;
import com.st.studyroom.model.StudyRoomDto;
import com.st.studyroom.model.StudySpaceDto;

public class MyPageDaoImpl implements MyPageDao {

   private static MyPageDao myPageDao;
   
   static {
      myPageDao = new MyPageDaoImpl();
   }
   
   private MyPageDaoImpl() {}
   
   public static MyPageDao getMyPageDao() {
      return myPageDao;
   }
   
   @Override
   public int updateProfile(MemberDto memberDto) {
      Connection conn = null;
      PreparedStatement pstmt = null;
      int cnt = 0;
      try {
         conn = DBConnection.makeConnection();
         StringBuffer sql = new StringBuffer();
         sql.append("update member \n");
         sql.append("set (m_pass,m_email,m_name,m_tel,m_tag) = (select ?,?,?,?,?from dual) \n");
         sql.append("where mno = ?");
         pstmt = conn.prepareStatement(sql.toString());
         
         pstmt.setString(1, memberDto.getM_PASS());
         pstmt.setString(2, memberDto.getM_EMAIL());
         pstmt.setString(3, memberDto.getM_NAME());
         pstmt.setString(4, memberDto.getM_TEL());
         pstmt.setString(5, memberDto.getM_TAG());
         pstmt.setInt(6, memberDto.getMNO());
         
         cnt = pstmt.executeUpdate();
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         DBClose.close(conn, pstmt);
      }
      return cnt;   
   }
   @Override
   public List<Map<String, String>> myReservation(int mno) {
      
      List<Map<String, String>> list = new ArrayList<Map<String, String>>();
      
       Connection conn = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         try {        
            conn = DBConnection.makeConnection();
            StringBuffer sql = new StringBuffer();

            sql.append("select b.rmrno, b.rmr_price,TO_CHAR(b.rmr_date_in, 'YYYY-MM-DD') rmr_date_in,b.sp_img,b.sp_name,b.rm_name\n");
            sql.append("from member,\n");
            sql.append("      (\n");
            sql.append("         select rmr.rmrno, rmr.mno,rmr.rmr_price,rmr.rmr_date_in,a.sp_img,a.sp_name,a.rm_name\n");
            sql.append("         from rm_res rmr,\n");
            sql.append("               (\n");
            sql.append("                  select s.sp_img, r.rm_no,s.sp_name,r.rm_name\n");
            sql.append("                   from space s , room r\n");
            sql.append("                   where s.spno = r.spno\n");
            sql.append("                ) a\n");
            sql.append("         where a.rm_no = rmr.rm_no\n");
            sql.append("      ) b\n");
            sql.append("where member.mno = b.mno\n");
            sql.append("AND\n");
            sql.append("member.mno = ?\n");
            
          pstmt = conn.prepareStatement(sql.toString());
         
      
          pstmt.setInt(1, mno);
          rs = pstmt.executeQuery();

          while(rs.next()) {
             Map<String, String> map = new HashMap<String,String>();//널 포인터를 피하기 위해 여기서 해 줬음
                     
             map.put("sp_img", rs.getString("sp_img"));   
             map.put("rmr_price", rs.getString("rmr_price"));
             map.put("rmr_date_in", rs.getString("rmr_date_in"));
             map.put("rmrno", rs.getString("rmrno"));
             map.put("sp_name", rs.getString("sp_name"));
             map.put("rm_name", rs.getString("rm_name"));
             
             list.add(map);
                  }
            }catch (SQLException e) {
             e.printStackTrace();
          } finally {
             DBClose.close(conn, pstmt, rs);
          }
          return list;

   }

   @Override
   public ReservationDto myReservationDetail(int rmrno) {
      
      ReservationDto reservationDto = new ReservationDto();      
      Connection conn = null;
       PreparedStatement pstmt = null;
       ResultSet rs = null;
        
         try {        
            conn = DBConnection.makeConnection();
            StringBuffer sql = new StringBuffer();

               sql.append("select rmr.rmr_id,rmr.rmrno , TO_CHAR(rmr.rmr_date, 'YYYY-MM-DD') rmr_date ,  rmr.rmr_time_in , rmr.rmr_time_out , TO_CHAR(rmr.rmr_date_in, 'YYYY-MM-DD') rmr_date_in ,rmr.rmr_tel, rmr.rmr_email, \n");
               sql.append("       rmr.rmr_price, rmr.rmr_person, rmr.rmr_content  , a.sp_name , a.sp_web, a.rm_name\n");
               sql.append("from rm_res rmr,  (\n");
               sql.append("         select s.sp_name,s.sp_web, r.rm_name, r.rm_no\n");
               sql.append("         from space s, room r\n");
               sql.append("         where s.spno = r.spno\n");
               sql.append("        ) a\n");
               sql.append("where rmr.rm_no = a.rm_no\n");
               sql.append("and\n");
               sql.append("rmr.rmrno = ?\n")   ;
            
          pstmt = conn.prepareStatement(sql.toString());      
      
          pstmt.setInt(1, rmrno);
          rs = pstmt.executeQuery();

          if(rs.next()) {
            reservationDto.setRMR_CONTENT(rs.getString("rmr_content"));
            reservationDto.setRMR_DATE(rs.getString("rmr_date"));
            reservationDto.setRMR_DATE_IN(rs.getString("rmr_date_in"));
            reservationDto.setRMR_PERSON(rs.getInt("rmr_person"));
            reservationDto.setRMR_PRICE(rs.getInt("rmr_price"));
            reservationDto.setRMR_TEL(rs.getString("rmr_tel"));
            reservationDto.setRMR_EMAIL(rs.getString("rmr_email"));
            reservationDto.setRMR_TIME_IN(rs.getString("rmr_time_in"));
            reservationDto.setRMR_TIME_OUT(rs.getString("rmr_time_out"));
            reservationDto.setRMRNO(rs.getInt("rmrno"));
            reservationDto.setSP_NAME(rs.getString("sp_name"));
            reservationDto.setRM_NAME(rs.getString("rm_name"));
            reservationDto.setRMR_ID(rs.getString("rmr_id"));
            
                  }
            }catch (SQLException e) {
             e.printStackTrace();
          } finally {
             DBClose.close(conn, pstmt, rs);
          }
          return reservationDto;
   }

   @Override
   public int reservationDelete(int rmrno) {
      
      int cnt = 0;
       Connection conn = null;
        PreparedStatement pstmt = null;
      
        try {
            conn = DBConnection.makeConnection();
            StringBuffer sql = new StringBuffer();
            sql.append("delete from rm_res \n");
            sql.append("where rmrno = ?");
            pstmt = conn.prepareStatement(sql.toString());
            
            pstmt.setInt(1, rmrno);
            
            cnt = pstmt.executeUpdate();
            
         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            DBClose.close(conn, pstmt);
         }
      return cnt;
   }

   @Override
   public List<StudySpaceDto> myRoomList(int mno) {
      
        List<StudySpaceDto> list = new ArrayList<StudySpaceDto>();
         Connection conn = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         
         try {
            
            conn = DBConnection.makeConnection();
            StringBuffer sql = new StringBuffer();
            sql.append("select sp_img, sp_name,spno \n");
            sql.append(" from space \n");
            sql.append("where mno = ?\n");
            
          pstmt = conn.prepareStatement(sql.toString());

          pstmt.setInt(1, mno);          
          rs = pstmt.executeQuery();
          
          while(rs.next()) {
                     StudySpaceDto studySpaceDto = new StudySpaceDto();
                     
                     studySpaceDto.setSP_NAME(rs.getString("sp_name"));
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
   public List<StudyRoomDto> getRooms(int spno) {

        List<StudyRoomDto> list = new ArrayList<StudyRoomDto>();
         Connection conn = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         
         try {
            
            conn = DBConnection.makeConnection();
            StringBuffer sql = new StringBuffer();
            sql.append("select r.rm_name,s.sp_name,r.rm_no   \n");
            sql.append(" from room r, space s \n");
            sql.append("where r.spno = s.spno\n");
            sql.append("and \n");
            sql.append("s.spno = ? \n");
            
          pstmt = conn.prepareStatement(sql.toString());

          pstmt.setInt(1, spno);          
          rs = pstmt.executeQuery();
          
          while(rs.next()) {
             StudyRoomDto studyRoomDto = new StudyRoomDto();
             studyRoomDto.setRM_NAME(rs.getString("rm_name"));      
             studyRoomDto.setSP_NAME(rs.getString("sp_name"));
             studyRoomDto.setRM_NO(rs.getInt("rm_no"));
              list.add(studyRoomDto);
                  }
            }catch (SQLException e) {
             e.printStackTrace();
          } finally {
             DBClose.close(conn, pstmt, rs);
          }
          return list;
   }

}