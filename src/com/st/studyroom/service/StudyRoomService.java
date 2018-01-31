package com.st.studyroom.service;

import java.util.List;
import java.util.Map;

import com.st.member.model.MemberDto;
import com.st.studyroom.model.ReservationDto;
import com.st.studyroom.model.RmAlbDto;
import com.st.studyroom.model.StudyRoomDto;
import com.st.studyroom.model.StudySpaceDto;
import com.st.studyroom.model.ZipDto;

public interface StudyRoomService {
	List<StudySpaceDto> spacelist(String key, String word);//메인에 뿌리는 메소드
	int spaceRegister(StudySpaceDto studySpaceDto,int i, String id, int seq);
	int roomRegister(List<StudyRoomDto> list, int sp_seq);
	
	int imgRegister(RmAlbDto rmAlbDto);
	int imgListRegister(List<RmAlbDto> list);
	
	List<StudyRoomDto> pickSpace(int spno);
	List<RmAlbDto> pickImages(int spno);

	List<ZipDto> zipSearch(String dong);
	List<ReservationDto> reservationlist(int rmnoForRsv, String date);
	int roomReservation(ReservationDto reservationDto);	
}
