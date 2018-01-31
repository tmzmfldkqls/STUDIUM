package com.st.studygroup.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.st.studygroup.dao.GroupMemberDaoImpl;
import com.st.studygroup.model.StudyGroupApplyDto;
import com.st.studygroup.model.StudyGroupDto;
import com.st.studygroup.model.StudyGroupMemberDto;

public class GroupMemberServiceImpl implements GroupMemberService {
	
	private static GroupMemberService groupMemberService;
	
	static {
		groupMemberService = new GroupMemberServiceImpl();
	}
	
	private GroupMemberServiceImpl() {}
	
	
	public static GroupMemberService getGroupMemberService() {
		return groupMemberService;
	}

	
	
	@Override
	public List<StudyGroupDto> studyGroupKing(int SNO) {
		return GroupMemberDaoImpl.getGroupMemberDao().studyGroupKing(SNO);
	}


	@Override
	public List<StudyGroupApplyDto> studyGroupApply(int SNO) {
		
		return GroupMemberDaoImpl.getGroupMemberDao().studyGroupApply(SNO);
	}


	@Override
	public List<StudyGroupMemberDto> studyGroupMember(int SNO) {
		return GroupMemberDaoImpl.getGroupMemberDao().studyGroupMember(SNO);
	}


	@Override
	public int registerMember(StudyGroupMemberDto studyGroupMemberDto) {
		return GroupMemberDaoImpl.getGroupMemberDao().registerMember(studyGroupMemberDto);
	}


	@Override
	public int memberout(int MNO, int SNO) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("MNO", MNO + "");
		map.put("SNO", SNO + "");
		int cnt = GroupMemberDaoImpl.getGroupMemberDao().memberout(map);
		return cnt;
	}


	@Override
	public StudyGroupMemberDto studyGroupMemberCheck(int SNO) {
		return GroupMemberDaoImpl.getGroupMemberDao().studyGroupMemberCheck(SNO);
	}


	@Override
	public StudyGroupApplyDto studyGroupApplyMember(int SNO) {
		return GroupMemberDaoImpl.getGroupMemberDao().studyGroupApplyMember(SNO);
	}


	@Override
	public int refuseMember(String apid, int SNO) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("apid", apid);
		map.put("SNO", SNO + "");
		return GroupMemberDaoImpl.getGroupMemberDao().refuseMember(map);
	}




	
	

}
