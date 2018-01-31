package com.st.reply.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.st.action.Action;
import com.st.member.model.MemberDto;
import com.st.studygroup.model.BoardListDto;
import com.st.studygroup.model.ReplyDto;
import com.st.studygroup.service.ReplyService;
import com.st.studygroup.service.ReplyServiceImpl;

public class ReplyWriteAction implements Action{

//	private int rno; --> 댓글번호 --> seq
//	private int mno; --> 회원번호
//	private int bno; --> 게시판번호
//	private int wno; -->	 글 번호
//	private String rid; -->	댓글작성자아이디
//	private String r_content; --> 댓글내용
//	private String r_date; --> 댓글작성날짜
//	private String r_status; --> 댓글상태
	
		@Override
		public String execute(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			HttpSession session = request.getSession();
			MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
			List<BoardListDto> boardListDto = (List<BoardListDto>) session.getAttribute("groupInfo");
			 String path = "/main/login.jsp";
			 String act = "";
			if(memberDto != null) {
				int WNO = Integer.parseInt(request.getParameter("WNO"));
				ReplyDto replyDto = new ReplyDto();		
				replyDto.setMno(memberDto.getMNO());
				replyDto.setBno(boardListDto.get(0).getBNO());
				replyDto.setWno(WNO);
				replyDto.setRid(memberDto.getM_ID());
				replyDto.setR_content(request.getParameter("rcontent"));				
				int cnt = ReplyServiceImpl.getReplyService().replyWrite(replyDto);
				if (cnt != 0) {
			         request.setAttribute("replylist", replyDto);
			         path = "/reply?act=listReply";
			      }				
			}
			return path;
		}

}
