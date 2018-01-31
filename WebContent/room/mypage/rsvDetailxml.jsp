<?xml version="1.0" encoding="EUC-KR"?>

<%@ page language="java" contentType="text/xml; charset=EUC-KR"
    pageEncoding="EUC-KR" import = "java.util.List, com.st.studyroom.model.*"%>
    
 <%
	ReservationDto reservationDto = (ReservationDto)request.getAttribute("reservationDetail"); 
 %>

	<rsvDetail>
		<rmrno><%=reservationDto.getRMRNO()%></rmrno>
		<sp_name><%=reservationDto.getSP_NAME()%></sp_name>
		<rm_name><%=reservationDto.getRM_NAME()%></rm_name>
		
		<rmr_id><%=reservationDto.getRMR_ID()%></rmr_id>
		<rmr_date><%=reservationDto.getRMR_DATE()%></rmr_date>
		<rmr_date_in><%=reservationDto.getRMR_DATE_IN()%></rmr_date_in>	
			
		<rmr_time><%=reservationDto.getRMR_TIME_IN() %> to <%=reservationDto.getRMR_TIME_OUT() %></rmr_time>		
		<rmr_email><%=reservationDto.getRMR_EMAIL() %></rmr_email>		
		<rmr_tel><%=reservationDto.getRMR_TEL() %></rmr_tel>		
		
		<rmr_price><%=reservationDto.getRMR_PRICE()%></rmr_price>		
		<rmr_person><%=reservationDto.getRMR_PERSON()%></rmr_person>		
		<rmr_content><%=reservationDto.getRMR_CONTENT()%></rmr_content>
	</rsvDetail>
