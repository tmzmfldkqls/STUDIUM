package com.st.studyroom.dao;
import java.util.List;
import java.util.Map;

import com.st.alarm.model.AlarmDto;
import com.st.member.model.MemberDto;
import com.st.studyroom.model.ReservationDto;
import com.st.studyroom.model.RmAlbDto;
import com.st.studyroom.model.StudyRoomDto;
import com.st.studyroom.model.StudySpaceDto;
import com.st.studyroom.model.ZipDto;

public interface StudyRoomDao {

	List<StudySpaceDto> selectlist(Map<String,String> map);//where key = word
	int registerSpace(StudySpaceDto studySpaceDto,  int mno, String id, int seq);
	int registerRoom(List<StudyRoomDto> list, int sp_seq);
	int registerImg(RmAlbDto rmAlbDto);
	
	int registerImgList(List<RmAlbDto> list);
	
	List<StudyRoomDto> pickSpace(int spno);
	List<RmAlbDto> pickImages(int spno);
	
	List<ZipDto> zipSearch(String dong);
	List<ReservationDto> reservationlist(int rmnoForRsv, String date);
	int roomReservation(ReservationDto reservationDto);
}
