package com.st.studyroom.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.st.member.model.MemberDto;
import com.st.studyroom.dao.StudyRoomDaoImpl;
import com.st.studyroom.model.ReservationDto;
import com.st.studyroom.model.RmAlbDto;
import com.st.studyroom.model.StudyRoomDto;
import com.st.studyroom.model.StudySpaceDto;
import com.st.studyroom.model.ZipDto;

public class StudyRoomServiceImpl implements StudyRoomService {
	
	private static StudyRoomService studyRoomService;
	
	static {
		studyRoomService = new StudyRoomServiceImpl();
	}
	private StudyRoomServiceImpl() {}
	
	public static StudyRoomService getStudyRoomService() {
		return studyRoomService;
	}

	//메인을 위해 뿌리기
	@Override
	public List<StudySpaceDto> spacelist(String key, String word) {	
		Map<String,String> map = new HashMap<String, String>();
		map.put("key", key);
		map.put("word", word);
		return StudyRoomDaoImpl.getStudyRoomDao().selectlist(map);
	}
	//공간등록
	@Override
	public int spaceRegister(StudySpaceDto studySpaceDto,int mno, String id,int seq) {		
		return StudyRoomDaoImpl.getStudyRoomDao().registerSpace(studySpaceDto ,mno,id,seq);
	}
	//방등록
	@Override
	public int roomRegister(List<StudyRoomDto> list, int sp_seq) {
		return StudyRoomDaoImpl.getStudyRoomDao().registerRoom(list,sp_seq);
	}
	//예약 페이지1을 위해 공간과 그에 딸린 정보 갖고 오기
		@Override
		public List<StudyRoomDto> pickSpace(int spno) {
			
			return StudyRoomDaoImpl.getStudyRoomDao().pickSpace(spno);
	}
	//대표이미지 등록
	@Override
	public int imgRegister(RmAlbDto rmAlbDto) {		
		return StudyRoomDaoImpl.getStudyRoomDao().registerImg(rmAlbDto);
	}
	//상세 이미지 등록
	@Override
	public int imgListRegister(List<RmAlbDto> list) {	
		return StudyRoomDaoImpl.getStudyRoomDao().registerImgList(list);
	}

	@Override
	public List<RmAlbDto> pickImages(int spno) {
		return StudyRoomDaoImpl.getStudyRoomDao().pickImages(spno);

	}

	@Override
	public List<ZipDto> zipSearch(String dong) {
		return StudyRoomDaoImpl.getStudyRoomDao().zipSearch(dong);
	}

	//날짜,방번호 이용하여 해당 방에 대한 예약 리스트 뽑아오기
		@Override
		public List<ReservationDto> reservationlist(int rmnoForRsv, String date) {
			return StudyRoomDaoImpl.getStudyRoomDao().reservationlist(rmnoForRsv,date);
		}
		@Override
		public int roomReservation(ReservationDto reservationDto) {	
			return StudyRoomDaoImpl.getStudyRoomDao().roomReservation(reservationDto);
	}
}
