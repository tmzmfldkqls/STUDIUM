<?xml version="1.0" encoding="EUC-KR"?>
<%@page import="java.util.*"%>
<%@page import="com.st.studygroup.model.*"%>
<%@ page language="java" contentType="text/xml; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%
List<StudyGroupScheduleDto> mslist = (List<StudyGroupScheduleDto>) request.getAttribute("mslist");
System.out.println("slist size" + mslist.size());
System.out.println("<>>>>>>><>>><>><>><" + mslist.get(0).getST_DATE_IN());
System.out.println("<>>>>>>><>>><>><>><" + mslist.get(0).getST_DATE_IN());
System.out.println("<>>>>>>><>>><>><>><" + mslist.get(0).getST_CONTENT());
System.out.println("<>>>>>>><>>><>><>><"+ mslist.get(0).getST_NAME());
%>

		<mslist>
<%

for(StudyGroupScheduleDto studyGroupScheduleDto : mslist){
%>
 <MemberStudyGroupSchedule>
			<stno><%=studyGroupScheduleDto.getSTNO()%></stno>
			<sno><%=studyGroupScheduleDto.getSNO()%></sno>
			<stDateIn><%=studyGroupScheduleDto.getST_DATE_IN()%></stDateIn>
			<stDateOUT><%=studyGroupScheduleDto.getST_DATE_OUT()%></stDateOUT>
			<stContent><%=studyGroupScheduleDto.getST_CONTENT()%></stContent>
			<stName><%=studyGroupScheduleDto.getST_NAME()%></stName>
</MemberStudyGroupSchedule>

<%
	}

%>



		</mslist>
