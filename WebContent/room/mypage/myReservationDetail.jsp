<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"
	import="java.util.*,com.st.studyroom.model.*,com.st.util.NullCheck"%>
<%@ include file="/common/header.jsp"%>
<%
	ReservationDto reservationDto = (ReservationDto)request.getAttribute("reservationDetail");	
%>
<style>
html, body {
	background-image: url(../roomInfo/re.jpg);
}
</style>

<script>
	function rsvDelete(date) {			
		
	var d = new Date();
	var today = d.getFullYear() +'-'+(d.getMonth() + 1) + '-' + d.getDate(); 
	alert(today);
	alert(date);
	if(date < today){
		var bool = confirm("해당 내역을 삭제하시겠습니까?")
			if(bool){
				document.rsvdeleteForm.action = "<%=root%>/mypage";
				document.rsvdeleteForm.submit();
			}
	}else{
		alert("예약 날짜가 지나지 않았습니다");
		}
		
	}
</script>
<div class="container" style="margin-top: 100px; margin-bottom: 150px;">
	<div class="row">
		<article class="box_form box_notice">
			<div class="heading">
				<h3>
					<strong>결제 안내</strong>
				</h3>
			</div>
			<div class="list_wrap">
				<p class="txt_notice refund">
				<p class="text-warning">
					<strong>해당웹은 결제를 지원하지 않습니다</strong>
				</p>
				<br> 이메일을 확인 후 호스트와 개별적으로 조정해 주세요
				</p>


			</div>
		</article>
	</div>
	<div class="row">
		<div class="table-responsive" style="width: 100%; overflow: auto">
			<table class="table" width="100%">
				<thead class="thead-dark">
					<tr>
						<th width="25%" align="center"><strong>예약 내역</strong></th>
						<th width="75%" style="text-align: right;"><strong><span
								class="badge badge-pill badge-warning">예약번호 : <%=reservationDto.getRMRNO()%>
							</span></strong></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>예약완료일자</td>
						<td><%=reservationDto.getRMR_DATE()%></td>
					</tr>

					<tr>
						<td>예약공간</td>
						<td><a href="">[<%=reservationDto.getSP_NAME()%>] - <%=reservationDto.getRM_NAME()%></a></td>
					</tr>

					<tr>
						<td>예약내용</td>
						<td><strong>사용 시작 : <%=reservationDto.getRMR_TIME_IN()%><br></strong>
							<strong>사용 종료 : <%=reservationDto.getRMR_TIME_OUT()%><br></strong></td>
					</tr>

					<tr>
						<td>사용인원</td>
						<td><%=reservationDto.getRMR_PERSON()%></td>
					</tr>

					<tr>
						<td>요청사항</td>
						<td><%=reservationDto.getRMR_CONTENT()%></td>
					</tr>

					<tr>
						<td>예약내역 삭제</td>
						<td>
							<form name = "rsvdeleteForm" id="rsvdeleteForm" method = "GET" action = "">
							<input type="hidden" name="act" id="act" value="rsvDelete">
							<input type="hidden" name="rmrno" id="rmrno" value="<%=reservationDto.getRMRNO()%>">
								<input type="button" name="rsv_delete" value="예약 내역 삭제" class="btn btn-block" onclick="javascript:rsvDelete('<%=reservationDto.getRMR_DATE()%>');">
							</form>
						</td>
					</tr>
				</tbody>
			</table>

			<table class="table" width="100%">
				<thead class="thead-dark">
					<tr>
						<th width="25%" align="center"><strong>예약자 정보</strong></th>
						<th width="75%" style="text-align: right;"></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>예약자ID</td>
						<td><%=reservationDto.getRMR_ID()%></td>
					</tr>
					<tr>
						<td>연락처</td>
						<td><%=NullCheck.nullToZero(reservationDto.getRMR_TEL())%></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><%=reservationDto.getRMR_EMAIL()%></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

<%@ include file="/common/footer.jsp"%>