package com.st.mypage.service;

import java.util.List;
import java.util.Map;

import com.st.member.model.MemberDto;
import com.st.mypage.dao.MyPageDaoImpl;
import com.st.studyroom.dao.StudyRoomDaoImpl;
import com.st.studyroom.model.ReservationDto;
import com.st.studyroom.model.StudyRoomDto;
import com.st.studyroom.model.StudySpaceDto;

public class MyPageServiceImpl implements MyPageService{

	private static MyPageService myPageService;
	
	static {
		myPageService = new MyPageServiceImpl();
	}
	
	private MyPageServiceImpl() {}
	
	public static  MyPageService getMyPageService() {
		return myPageService;
	}

	@Override
	public int updateProfile(MemberDto memberDto) {
		int cnt;
		System.out.println("호출됨");
		cnt = MyPageDaoImpl.getMyPageDao().updateProfile(memberDto);
		return cnt;
	}
	//내 예약 보기
	@Override
	public List<Map<String,String>> myReservation(int mno) {
		
		return MyPageDaoImpl.getMyPageDao().myReservation(mno);
	}

	@Override
	public ReservationDto myReservationDetail(int rmrno) {
		
		return MyPageDaoImpl.getMyPageDao().myReservationDetail(rmrno);
	}

	@Override
	public int reservationDelete(int rmrno) {
		
		return MyPageDaoImpl.getMyPageDao().reservationDelete(rmrno);
	}

	@Override
	public List<StudySpaceDto> myRoomList(int mno) {
		
		return  MyPageDaoImpl.getMyPageDao().myRoomList(mno);
	}

	@Override
	public List<StudyRoomDto> getRooms(int spno) {
		
		return  MyPageDaoImpl.getMyPageDao().getRooms(spno);
	}
}
