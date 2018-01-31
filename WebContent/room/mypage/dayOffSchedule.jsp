<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/common/header.jsp"%>
<br>
<br>
<br>
<br>

<div class="container">

	<div class="row">
		<div class="col-lg-9" >
			
			<div id='calendar'>
				<%@ include file="./calendar.jsp"%>
			</div>
		</div>
	
		
		<div class="col-lg-3" >
			<div id='calendar'>
				여기 이제 일정이 오게 됨
			</div>
		</div>
	</div>
</div>

<%@ include file="/common/footer.jsp"%>