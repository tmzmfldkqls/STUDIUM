package com.st.studygroup.service;

import java.util.List;

import com.st.studygroup.dao.BbsDaoImpl;
import com.st.studygroup.model.BbsGroupDto;

public class BbsServiceImpl implements BbsService {
	
	private static BbsService bbsService;
	
	static {
		bbsService = new BbsServiceImpl();
	}
	
	private BbsServiceImpl() {}
	
	
	public static BbsService getBbsService() {
		return bbsService;
	}



	@Override
	public List<BbsGroupDto> bbsList(int SNO) {
		System.out.println("누나누나의" + SNO);
		return BbsDaoImpl.getBbsDao().bbsList(SNO);
	}


	@Override
	public int upLoad(BbsGroupDto bbsGroupDto) {
		int cnt = BbsDaoImpl.getBbsDao().upLoad(bbsGroupDto);
		return cnt;
	}


	@Override
	public BbsGroupDto downLoad(String fileName) {
		return BbsDaoImpl.getBbsDao().downLoad(fileName);
	}

	
}
