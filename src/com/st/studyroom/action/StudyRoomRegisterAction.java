package com.st.studyroom.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.st.action.Action;
import com.st.member.model.MemberDto;
import com.st.studyroom.model.StudyRoomDto;
import com.st.studyroom.model.StudySpaceDto;
import com.st.studyroom.service.StudyRoomServiceImpl;
import com.st.util.StringEncoder;

public class StudyRoomRegisterAction implements Action{


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		
		int spno = (int) request.getAttribute("spno");//컨트롤러에서 생성된 값이 넘어 오는것. 
		
		StudySpaceDto studySpaceDto  = new StudySpaceDto();
		
		studySpaceDto.setSP_CONTENT(request.getParameter("sp_content"));
		studySpaceDto.setSP_ID(memberDto.getM_ID());
		studySpaceDto.setSP_NAME(request.getParameter("sp_name"));
		studySpaceDto.setSP_SCONTENT(request.getParameter("sp_scontent"));
		studySpaceDto.setSP_TAG(request.getParameter("sp_tag"));
		System.out.println(studySpaceDto.getSP_TAG());
		studySpaceDto.setMNO(memberDto.getMNO());
		studySpaceDto.setSP_IMG("temp");
		studySpaceDto.setSP_WEB(request.getParameter("sp_web"));
		studySpaceDto.setFOOTPRINT(0);
		if("on".equals(request.getParameterValues("sp_flag")[0])){
			studySpaceDto.setSP_FLAG(1);
		}else{ 
			studySpaceDto.setSP_FLAG(0);
		}
		
		studySpaceDto.setSP_SI(request.getParameter("si"));
		studySpaceDto.setSP_GUGUN(request.getParameter("gugun"));
		studySpaceDto.setSP_DONG(request.getParameter("dong"));
		studySpaceDto.setAP_BUNJI(request.getParameter("bunji"));
		studySpaceDto.setSP_DETAIL_addr(request.getParameter("addr2"));
		System.out.println("GEO : " + request.getParameter("geo") );
		studySpaceDto.setSP_GEO(request.getParameter("geo"));
		int cnt1 = StudyRoomServiceImpl.getStudyRoomService().spaceRegister(studySpaceDto,memberDto.getMNO() , memberDto.getM_ID(), spno);

		@SuppressWarnings("unchecked")
		List<StudyRoomDto> list = (List<StudyRoomDto>)request.getAttribute("roomList");
		
		int cnt2 = StudyRoomServiceImpl.getStudyRoomService().roomRegister(list, spno);
		
		if(cnt1 * cnt2 != 0){			
			return "/room/roomInfo/register_img.jsp";
		}else{
			session.invalidate();
			return "/main/login.jsp";
		}
	}

}
