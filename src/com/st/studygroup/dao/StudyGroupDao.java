package com.st.studygroup.dao;

import java.util.List;
import java.util.Map;

import com.st.member.model.MemberDto;
import com.st.studygroup.model.BoardDto;
import com.st.studygroup.model.BoardListDto;
import com.st.studygroup.model.StudyGroupApplyDto;
import com.st.studygroup.model.StudyGroupDto;

public interface StudyGroupDao {
	List<StudyGroupDto> listarticle(Map<String, String> map);
	int registerStudyGroup(StudyGroupDto studygroupDto);
	List<StudyGroupDto> listmyArticle(MemberDto memberDto);
	List<BoardListDto> myGroupContent(int SNO);
	StudyGroupDto viewGroupContent(int SNO);
	List<BoardDto> notice(int SNO);
	void modifyStudyGroup(StudyGroupDto studygroupDto);
	int studyGroupApply(StudyGroupApplyDto studyGroupApplyDto);
	List<StudyGroupDto> includeMeList(MemberDto memberDto);
	
}
