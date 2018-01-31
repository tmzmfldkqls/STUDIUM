<?xml version="1.0" encoding="EUC-KR"?>
<%@ page language="java" contentType="text/xml; charset=EUC-KR" pageEncoding="EUC-KR" import="java.util.List,com.st.member.model.*,com.st.studyroom.model.*,com.st.studygroup.model.*" %>
<%
List<MemberDto> dmlist = (List<MemberDto>) request.getAttribute("dmlist");
List<StudySpaceDto> dslist = (List<StudySpaceDto>) request.getAttribute("dslist");
List<StudyGroupDto> dglist = (List<StudyGroupDto>) request.getAttribute("dglist");
%>
<dashlist>
<%
for(MemberDto memberDto : dmlist) {
%>
<member>
	<mno><%= memberDto.getMNO() %></mno>
	<userid><%= memberDto.getM_ID() %></userid>
	<name><%= memberDto.getM_NAME() %></name>
</member>
<%
}
%>
<%
for(StudySpaceDto studySpaceDto : dslist) {
%>
<space>
	<spno><%= studySpaceDto.getSPNO() %></spno>
	<name><%= studySpaceDto.getSP_NAME() %></name>
	<scontent><%= studySpaceDto.getSP_SCONTENT() %></scontent>
</space>
<%
}
%>
<%
for(StudyGroupDto studyGroupDto : dglist) {
%>
<studygroup>
	<sno><%= studyGroupDto.getSNO() %></sno>
	<name><%= studyGroupDto.getS_NAME() %></name>
	<content><%= studyGroupDto.getS_CONTENT() %></content>
</studygroup>
<%
}
%>

</dashlist>