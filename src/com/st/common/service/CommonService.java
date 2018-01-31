package com.st.common.service;

import com.st.util.PageNavigation;

public interface CommonService {
	
	int selectSPNO();//only updates seq!!!!
	PageNavigation makePageNavigation(int pg, String word, int studygroupsize);
}
