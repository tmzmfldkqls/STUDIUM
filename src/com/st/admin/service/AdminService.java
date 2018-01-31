package com.st.admin.service;

import java.util.List;
import java.util.Map;

import com.st.member.model.MemberDto;
import com.st.studygroup.model.StudyGroupDto;
import com.st.studyroom.model.StudyRoomDto;
import com.st.studyroom.model.StudySpaceDto;

public interface AdminService {
	
	List<MemberDto> listMember(String key, String word);
	List<StudySpaceDto> listSpace(String key, String word);
	int updatemember(String status);
	List<StudySpaceDto> dashSpace();
	List<MemberDto> dashMember();
	List<Map> memberChart();
	List<Map> loginChart();
	List<StudyRoomDto> addressList();
	List<StudyGroupDto> listStudygroup(String key, String word);
	void updateStat(int num, String stat, String no);
	void updateTag(int num, String tag, String no);
	List<StudyGroupDto> dashGroup();
}
