package com.st.studygroup.dao;

import java.util.List;

import com.st.studygroup.model.BbsGroupDto;

public interface BbsDao {
	
	List<BbsGroupDto> bbsList(int SNO);
	int upLoad(BbsGroupDto bbsGroupDto);
	BbsGroupDto downLoad(String fileName);

}
