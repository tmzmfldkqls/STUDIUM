<?xml version="1.0" encoding="EUC-KR"?>
<%@page import="java.util.*"%>
<%@page import="com.st.studygroup.model.*"%>
<%@ page language="java" contentType="text/xml; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%
   List<StudyGroupApplyDto> alist = (List<StudyGroupApplyDto>) request.getAttribute("alist");
   List<StudyGroupMemberDto> mlist = (List<StudyGroupMemberDto>) request.getAttribute("mlist");
   %>
		<alist>
<%
for(StudyGroupApplyDto studyGroupApplyDto : alist){
%>
			<applymember>
					<apno><%=studyGroupApplyDto.getAPNO()%></apno>
					<mno><%=studyGroupApplyDto.getMNO()%></mno>
					<sno><%=studyGroupApplyDto.getSNO()%></sno>
					<apid><%=studyGroupApplyDto.getAP_ID()%></apid>
					<apcontent><%=studyGroupApplyDto.getAP_CONTENT()%></apcontent>
					<apstatus><%=studyGroupApplyDto.getAP_STATUS()%></apstatus>
			</applymember>
<%
}

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



