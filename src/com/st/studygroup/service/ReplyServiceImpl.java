package com.st.studygroup.service;

import java.util.List;

import com.st.studygroup.dao.ReplyDaoImpl;
import com.st.studygroup.model.ReplyDto;

public class ReplyServiceImpl implements ReplyService {
	
	private static ReplyService replyService;
	
	public static ReplyService getReplyService() {
		return replyService;
	}

	static {
		replyService = new ReplyServiceImpl();
	}
	
	private ReplyServiceImpl() {}
	
	

	@Override
	public int replyWrite(ReplyDto replyDto) {
		return ReplyDaoImpl.getReplyDao().replyWrite(replyDto);
	}



	@Override
	public List<ReplyDto> replyList(int WNO) {
		return ReplyDaoImpl.getReplyDao().replyList(WNO);
	}



	@Override
	public void replyDelete(int WNO, int RNO) {
		 ReplyDaoImpl.getReplyDao().replyDelete(WNO, RNO);
		
	}

}
