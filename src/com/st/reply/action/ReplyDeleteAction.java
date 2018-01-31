package com.st.reply.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.st.action.Action;
import com.st.studygroup.model.ReplyDto;
import com.st.studygroup.service.ReplyServiceImpl;

public class ReplyDeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int WNO = Integer.parseInt(request.getParameter("WNO"));
		int RNO = Integer.parseInt(request.getParameter("RNO"));
		System.out.println("WNO>>>>>" + WNO + "RNO>>>>>>"+RNO);
		
		if(WNO!=0 && RNO!=0) {
			ReplyServiceImpl.getReplyService().replyDelete(WNO, RNO);
		}
		List<ReplyDto> list = ReplyServiceImpl.getReplyService().replyList(WNO);
		request.setAttribute("replylist", list);
		return "/reply/reply.jsp";
	}

}
