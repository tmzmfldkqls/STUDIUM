package com.st.studygroup.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.st.action.Action;
import com.st.studygroup.model.BoardListDto;
import com.st.studygroup.model.StudyGroupDto;
import com.st.studygroup.service.StudyGroupServiceImpl;

public class StudyGroupModifyAction implements Action{

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      String path = "/main/login.jsp";
      int SNO = Integer.parseInt(request.getParameter("SNO"));
      StudyGroupDto studyGroupDto = new StudyGroupDto();   
      if(SNO != 0) {
         studyGroupDto.setS_NAME(request.getParameter("SNAME"));
         studyGroupDto.setS_CONTENT(request.getParameter("SCONTENT"));
         studyGroupDto.setS_TAG(request.getParameter("STAG"));
         studyGroupDto.setS_PERSON(Integer.parseInt(request.getParameter("sperson")));
         studyGroupDto.setS_MAXPERSON(Integer.parseInt(request.getParameter("maxMember")));
         studyGroupDto.setS_ID(request.getParameter("SID"));
         studyGroupDto.setSNO(SNO);
         studyGroupDto.setS_BEING(request.getParameter("stStatus"));
         StudyGroupServiceImpl.getStudyGroupService().modifyStudyGroup(studyGroupDto);
         request.setAttribute("groupInfo", studyGroupDto);
         
         path = "/stgcontroll?act=mvmygroup&studyGroupDto="+studyGroupDto;
      }
      return path;
   }

}