<?xml version="1.0" encoding="EUC-KR"?>
<%@ page language="java" contentType="text/xml; charset=EUC-KR" pageEncoding="EUC-KR" import="java.util.List,com.st.studyroom.model.*" %>
<%
List<StudyRoomDto> list = (List<StudyRoomDto>) request.getAttribute("alist");
%>
<addresslist>
<%
for(StudyRoomDto studyRoomDto : list) {
%>
<address>
	<spno><%= studyRoomDto.getSPNO() %></spno>
	<dong><%= studyRoomDto.getSP_DONG() %></dong>
	<name><%= studyRoomDto.getSP_NAME() %></name>
	<scontent><%= studyRoomDto.getSP_SCONTENT() %></scontent>
	<tag><%= studyRoomDto.getSP_TAG() %></tag>
	<geo><%= studyRoomDto.getSP_GEO() %></geo>
</address>
<%
}
%>
</addresslist>