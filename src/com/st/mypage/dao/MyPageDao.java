package com.st.mypage.dao;

import java.util.List;
import java.util.Map;

import com.st.member.model.MemberDto;
import com.st.studyroom.model.ReservationDto;
import com.st.studyroom.model.StudyRoomDto;
import com.st.studyroom.model.StudySpaceDto;

public interface MyPageDao {

	int updateProfile(MemberDto memberDto);
	List<Map<String,String>> myReservation(int mno);//내예약리스트뽑아올것
	ReservationDto myReservationDetail(int rmrno);
	int reservationDelete(int rmrno);
	List<StudySpaceDto> myRoomList(int mno);
	List<StudyRoomDto> getRooms(int spno);
}
