package com.st.admin.dao;

import java.util.List;
import java.util.Map;

import com.st.member.model.MemberDto;
import com.st.studygroup.model.StudyGroupDto;
import com.st.studyroom.model.StudyRoomDto;
import com.st.studyroom.model.StudySpaceDto;

public interface AdminDao {
	
	List<MemberDto> listMember(Map<String,String> map);
	List<StudySpaceDto> listSpace(Map<String,String> map);
	List<Map> memberChart();
	List<Map> loginChart();
	List<StudyRoomDto> addressList();
	List<StudyGroupDto> listStudygroup(Map<String, String> map);
	void updateMemStat(int mno, String stat);
	void updateMemTag(int num, String tag);
	void updateSpStat(int num, String stat);
	void updateSpTag(int num, String tag);
	void updateStgStat(int num, String stat);
	void updateStgTag(int num, String tag);
	void updateBStgStat(int num, String stat);
}
