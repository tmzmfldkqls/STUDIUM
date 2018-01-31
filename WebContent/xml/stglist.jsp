<?xml version="1.0" encoding="EUC-KR"?>
<%@page import="com.st.studygroup.model.StudyGroupDto"%>
<%@ page language="java" contentType="text/xml; charset=EUC-KR" pageEncoding="EUC-KR" import="java.util.List,com.st.member.model.*" %>
<%
List<StudyGroupDto> list = (List<StudyGroupDto>) request.getAttribute("glist");
%>
<stglist>
<%
for(StudyGroupDto studyGroupDto : list) {
%>
<studygroup>
	<sno><%= studyGroupDto.getSNO() %></sno>
	<name><%= studyGroupDto.getS_NAME() %></name>
	<content><%= studyGroupDto.getS_CONTENT() %></content>
	<userid><%= studyGroupDto.getS_ID() %></userid>
	<bstatus><%= studyGroupDto.getS_BEING() %></bstatus>
	<hashtag><%= studyGroupDto.getS_TAG() %></hashtag>
	<status><%= studyGroupDto.getS_CURR_STATUS()%></status>
</studygroup>
<%
}
%>
</stglist>