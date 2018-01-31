package com.st.common.service;

import com.st.common.dao.CommonDaoImpl;
import com.st.studyroom.dao.StudyRoomDaoImpl;
import com.st.studyroom.service.StudyRoomService;
import com.st.studyroom.service.StudyRoomServiceImpl;
import com.st.util.BoardConstance;
import com.st.util.PageNavigation;

public class CommonServiceImpl implements CommonService {

private static CommonService commonService;
	
	static {
		commonService = new CommonServiceImpl();
	}
	private CommonServiceImpl() {}
	
	public static CommonService getCommonService() {
		return commonService;
	}

	@Override
	public int selectSPNO() {		
		return CommonDaoImpl.getCommonDao().selectSPNO();
	}

	@Override
	public PageNavigation makePageNavigation(int pg, String word, int studygroupsize) {
		PageNavigation navigation = new PageNavigation();
		int pgsize = BoardConstance.PAGE_SIZE;
		navigation.setPageNo(pg);
		int totalGroupCount = CommonDaoImpl.getCommonDao().getTotalGroupCount(word);
		int totalPageCount = (totalGroupCount - 1) / studygroupsize + 1;
		navigation.setTotalPageCount(totalPageCount);
		navigation.setTotalArticleCount(totalGroupCount);
		navigation.setNowFirst(pg <= pgsize);
		navigation.setNowEnd(pg > (totalPageCount -1) / pgsize * pgsize);
		return navigation;
	}
	
	
}
