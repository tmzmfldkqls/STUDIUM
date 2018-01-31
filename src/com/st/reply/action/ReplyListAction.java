package com.st.reply.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.st.action.Action;
import com.st.studygroup.model.ReplyDto;
import com.st.studygroup.service.ReplyServiceImpl;

public class ReplyListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int WNO = Integer.parseInt(request.getParameter("WNO"));
		System.out.println("ACTION WNO======"+WNO);
		List<ReplyDto> list = ReplyServiceImpl.getReplyService().replyList(WNO);
		request.setAttribute("replylist", list);
		return "/reply/reply.jsp";
	}

}
