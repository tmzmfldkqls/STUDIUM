<?xml version="1.0" encoding="EUC-KR"?>
<%@ page language="java" contentType="text/xml; charset=EUC-KR" pageEncoding="EUC-KR" import="java.util.List,com.st.studyroom.model.*" %>
<%
List<StudySpaceDto> list = (List<StudySpaceDto>) request.getAttribute("slist");
%>
<spacelist>
<%
for(StudySpaceDto studySpaceDto : list) {
%>
<space>
	<spno><%= studySpaceDto.getSPNO() %></spno>
	<name><%= studySpaceDto.getSP_NAME() %></name>
	<scontent><%= studySpaceDto.getSP_SCONTENT() %></scontent>
	<footprint><%= studySpaceDto.getFOOTPRINT()%></footprint>
	<tag> <%= studySpaceDto.getSP_TAG() %></tag>
	<web> <%= studySpaceDto.getSP_WEB() %></web>
	<status><%=studySpaceDto.getSP_ST()%></status>
</space>
<%
}
%>
</spacelist>