<?xml version="1.0" encoding="EUC-KR"?>
<%@page import="java.util.*"%>
<%@page import="com.st.studygroup.model.*"%>
<%@ page language="java" contentType="text/xml; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%
   List<StudyGroupMemberDto> mlist = (List<StudyGroupMemberDto>) request.getAttribute("mlist");
   %>
		<alist>
<%
for(StudyGroupMemberDto studyGroupMemberDto : mlist){
%>

			<groupmember>
					<smno><%=studyGroupMemberDto.getSMNO()%></smno>
					<sno><%=studyGroupMemberDto.getSNO()%></sno>
					<mno><%=studyGroupMemberDto.getMNO()%></mno>
					<mid><%=studyGroupMemberDto.getM_ID()%></mid>
			</groupmember>
			
<%
}
%>
		</alist>



