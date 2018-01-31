package com.st.mypage.service;

import java.util.List;
import java.util.Map;

import com.st.member.model.MemberDto;
import com.st.studyroom.model.ReservationDto;
import com.st.studyroom.model.StudyRoomDto;
import com.st.studyroom.model.StudySpaceDto;

public interface MyPageService {


	int updateProfile(MemberDto memberDto);//������ �ٲٴ� dao ȣ��
	List<Map<String,String>> myReservation(int mno);//������ ����
	ReservationDto myReservationDetail(int rmrno);
	int reservationDelete(int rmrno);
	List<StudySpaceDto> myRoomList(int mno);
	List<StudyRoomDto> getRooms(int spno);
}
