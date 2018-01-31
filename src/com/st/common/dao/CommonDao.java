package com.st.common.dao;

import java.util.Map;

public interface CommonDao {

	public int selectSPNO();
	public void updateLNUM(int mno);
	int getTotalGroupCount(String word);
}
