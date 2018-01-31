package com.st.studygroup.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.st.member.model.MemberDto;
import com.st.studygroup.dao.StudyGroupDaoImpl;
import com.st.studygroup.model.BoardDto;
import com.st.studygroup.model.BoardListDto;
import com.st.studygroup.model.StudyGroupApplyDto;
import com.st.studygroup.model.StudyGroupDto;
import com.st.util.BoardConstance;


public class StudyGroupServiceImpl implements StudyGroupService {
	
	
	private static StudyGroupService studyGroupService;
	
	static {
		studyGroupService = new StudyGroupServiceImpl();
	}
	
	private StudyGroupServiceImpl() {}
	
	
	public static StudyGroupService getStudyGroupService() {
		return studyGroupService;
	}


	@Override
	public List<StudyGroupDto> listArticle(int pg, String word) {
		int end = pg * BoardConstance.BOARD_LIST_SIZE;
		int start = end - BoardConstance.BOARD_LIST_SIZE;
		Map<String, String> map = new HashMap<String,String>();
		map.put("start", start + "");
		map.put("end", end + "");
		map.put("word", word);
		return StudyGroupDaoImpl.getStudyGroupDao().listarticle(map);
	}


	@Override
	public int registerStudyGroup(StudyGroupDto studygroupDto) {
		
		return  StudyGroupDaoImpl.getStudyGroupDao().registerStudyGroup(studygroupDto);

	}


	@Override
	public List<StudyGroupDto> listmyArticle(MemberDto memberDto) {
		
		return StudyGroupDaoImpl.getStudyGroupDao().listmyArticle(memberDto);
	}


	@Override
	public List<BoardListDto> myGroupContent(int SNO) {
		return StudyGroupDaoImpl.getStudyGroupDao().myGroupContent(SNO);
	}


	@Override
	public StudyGroupDto viewGroupContent(int SNO) {
		
		return StudyGroupDaoImpl.getStudyGroupDao().viewGroupContent(SNO);
	}


	@Override
	public List<BoardDto> notice(int SNO) {
		return StudyGroupDaoImpl.getStudyGroupDao().notice(SNO);
	}
	

	@Override
	public void modifyStudyGroup(StudyGroupDto studyGroupDto) {
		StudyGroupDaoImpl.getStudyGroupDao().modifyStudyGroup(studyGroupDto);
		
	}


	@Override
	public int studyGroupApply(StudyGroupApplyDto studyGroupApplyDto) {
		return StudyGroupDaoImpl.getStudyGroupDao().studyGroupApply(studyGroupApplyDto);
	}


	@Override
	public List<StudyGroupDto> includeMeList(MemberDto memberDto) {
		return StudyGroupDaoImpl.getStudyGroupDao().includeMeList(memberDto);
	}
	
	
	
}
