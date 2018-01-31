<?xml version="1.0" encoding="EUC-KR"?>
<%@page import="java.util.*"%>
<%@page import="com.st.studygroup.model.*"%>
<%@ page language="java" contentType="text/xml; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%
List<StudyGroupScheduleDto> slist = (List<StudyGroupScheduleDto>) request.getAttribute("slist");
%>
		<slist>
<%

for(StudyGroupScheduleDto studyGroupScheduleDto : slist){
%>
 <StudyGroupSchedule>
			<stno><%=studyGroupScheduleDto.getSTNO()%></stno>
			<sno><%=studyGroupScheduleDto.getSNO()%></sno>
			<stDateIn><%=studyGroupScheduleDto.getST_DATE_IN()%></stDateIn>
			<stDateOUT><%=studyGroupScheduleDto.getST_DATE_OUT()%></stDateOUT>
			<stContent><%=studyGroupScheduleDto.getST_CONTENT()%></stContent>
			<stName><%=studyGroupScheduleDto.getST_NAME()%></stName>
</StudyGroupSchedule>

<%
	}

%>



		</slist>
