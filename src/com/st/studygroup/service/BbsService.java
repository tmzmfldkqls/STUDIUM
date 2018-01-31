package com.st.studygroup.service;

import java.util.List;

import com.st.studygroup.model.BbsGroupDto;

public interface BbsService {
	
	List<BbsGroupDto> bbsList(int SNO);
	int upLoad(BbsGroupDto bbsGroupDto);
	BbsGroupDto downLoad(String fileName);
}
