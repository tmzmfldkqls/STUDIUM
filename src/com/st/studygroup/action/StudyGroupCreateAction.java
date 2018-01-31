package com.st.studygroup.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.st.action.Action;
import com.st.member.model.MemberDto;
import com.st.member.service.MemberServiceImpl;
import com.st.studygroup.model.StudyGroupDto;
import com.st.studygroup.service.StudyGroupServiceImpl;
import com.st.util.StringEncoder;

/*
pstmt.setInt(++idx, studygroupDto.getMNO());
pstmt.setString(++idx, studygroupDto.getS_ID());
pstmt.setString(++idx, studygroupDto.getS_NAME());
pstmt.setString(++idx, studygroupDto.getS_CONTENT());
pstmt.setString(++idx, studygroupDto.getS_TAG());
pstmt.setString(++idx, studygroupDto.getS_MEMBER());
pstmt.setInt(++idx, studygroupDto.getS_PERSON());
pstmt.setInt(++idx, studygroupDto.getS_MAXPERSON());
pstmt.setString(++idx, studygroupDto.getS_CURR_STATUS());
pstmt.setString(++idx, studygroupDto.getS_BEING());
*/

public class StudyGroupCreateAction implements Action {
   public String execute(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
	   System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>"+request.getParameter("stgname"));
      HttpSession session = request.getSession();
      MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
      int pg = Integer.parseInt(request.getParameter("pg"));
      String word = StringEncoder.isoToEuc(request.getParameter("word"));
      String path = "/main/login.jsp";
      String act = "mvgroup";
      StudyGroupDto studyGroupDto = new StudyGroupDto();
      studyGroupDto.setMNO(memberDto.getMNO());
      studyGroupDto.setS_ID(memberDto.getM_ID());
      studyGroupDto.setS_NAME(request.getParameter("stgname"));
      studyGroupDto.setS_CONTENT(request.getParameter("introGroup"));
      studyGroupDto.setS_TAG(request.getParameter("hashTagGroup"));
      studyGroupDto.setS_MAXPERSON(Integer.parseInt(request.getParameter("maxMember")));

      
      int cnt = StudyGroupServiceImpl.getStudyGroupService().registerStudyGroup(studyGroupDto);
      if (cnt != 0) {
         request.setAttribute("listarticle", studyGroupDto);
         path = "/stgcontroll?act=" + act + "&pg=" + pg + "&word=" + word;
      }
      return path;
   }

}