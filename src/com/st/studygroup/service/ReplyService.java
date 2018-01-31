package com.st.studygroup.service;

import java.util.List;


import com.st.studygroup.model.ReplyDto;

public interface ReplyService {
	int replyWrite (ReplyDto replyDto);
	List<ReplyDto> replyList(int WNO);
	void replyDelete (int WNO, int RNO);
}
