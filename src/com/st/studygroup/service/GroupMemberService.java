package com.st.studygroup.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.st.studygroup.model.StudyGroupApplyDto;
import com.st.studygroup.model.StudyGroupDto;
import com.st.studygroup.model.StudyGroupMemberDto;

public interface GroupMemberService {
	
	List<StudyGroupDto> studyGroupKing(int SNO);
	List<StudyGroupMemberDto> studyGroupMember(int SNO);
	List<StudyGroupApplyDto> studyGroupApply(int SNO);
	int registerMember(StudyGroupMemberDto studyGroupMemberDto);
	int memberout(int MNO, int SNO);
	StudyGroupMemberDto studyGroupMemberCheck(int SNO);
	StudyGroupApplyDto studyGroupApplyMember(int SNO);
	int refuseMember(String apid, int SNO);
}
