<?xml version="1.0" encoding="EUC-KR"?>
<%@ page language="java" contentType="text/xml; charset=EUC-KR" pageEncoding="EUC-KR" import="java.util.List,com.st.member.model.*" %>
<%
List<MemberDto> list = (List<MemberDto>) request.getAttribute("dmlist");
%>
<memberlist>
<%
for(MemberDto memberDto : list) {
%>
<member>
	<mno><%= memberDto.getMNO() %></mno>
	<userid><%= memberDto.getM_ID() %></userid>
	<name><%= memberDto.getM_NAME() %></name>
	<email><%= memberDto.getM_EMAIL() %></email>
	<tel><%= memberDto.getM_TEL() %></tel>
	<hashtag><%= memberDto.getM_TAG() %></hashtag>
	<status><%= memberDto.getM_STATUS() %></status>
</member>
<%
}
%>
</memberlist>