package com.st.studygroup.service;

import java.util.List;

import com.st.member.model.MemberDto;
import com.st.studygroup.model.BoardDto;
import com.st.studygroup.model.BoardListDto;
import com.st.studygroup.model.StudyGroupApplyDto;
import com.st.studygroup.model.StudyGroupDto;

public interface StudyGroupService {
	List<StudyGroupDto> listArticle(int pg, String word);
	int registerStudyGroup (StudyGroupDto studygroupDto);
	List<StudyGroupDto> listmyArticle(MemberDto memberDto);
	List<BoardListDto> myGroupContent(int SNO);
	StudyGroupDto viewGroupContent(int SNO);
	List<BoardDto> notice(int SNO);
	void modifyStudyGroup(StudyGroupDto studyGroupDto);
	int studyGroupApply(StudyGroupApplyDto studyGroupApplyDto);
	List<StudyGroupDto> includeMeList(MemberDto memberDto);
	
}
