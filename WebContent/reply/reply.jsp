<?xml version="1.0" encoding="EUC-KR"?>
<%@ page language="java" contentType="text/xml; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.st.studygroup.model.ReplyDto, java.util.List"%>
<%
List<ReplyDto> list = (List<ReplyDto>) request.getAttribute("replylist");
%>
<replylist>
<%
for(ReplyDto replyDto : list) {
%>
	<reply>
		<rno><%=replyDto.getRno()%></rno>
		<rid><%=replyDto.getRid()%></rid>
		<r_content><%=replyDto.getR_content()%></r_content>
		<r_date><%=replyDto.getR_date()%></r_date>	
		
	</reply>
<%
}
%>
</replylist>