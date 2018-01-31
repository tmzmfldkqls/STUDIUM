package com.st.mypage.service;

import java.util.List;
import java.util.Map;

import com.st.member.model.MemberDto;
import com.st.studyroom.model.ReservationDto;
import com.st.studyroom.model.StudyRoomDto;
import com.st.studyroom.model.StudySpaceDto;

public interface MyPageService {


	int updateProfile(MemberDto memberDto);//프로필 바꾸는 dao 호출
	List<Map<String,String>> myReservation(int mno);//내예약 보기
	ReservationDto myReservationDetail(int rmrno);
	int reservationDelete(int rmrno);
	List<StudySpaceDto> myRoomList(int mno);
	List<StudyRoomDto> getRooms(int spno);
}
