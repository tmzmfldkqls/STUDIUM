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
		var bool = confirm("�ش� ������ �����Ͻðڽ��ϱ�?")
			if(bool){
				document.rsvdeleteForm.action = "<%=root%>/mypage";
				document.rsvdeleteForm.submit();
			}
	}else{
		alert("���� ��¥�� ������ �ʾҽ��ϴ�");
		}
		
	}
</script>
<div class="container" style="margin-top: 100px; margin-bottom: 150px;">
	<div class="row">
		<article class="box_form box_notice">
			<div class="heading">
				<h3>
					<strong>���� �ȳ�</strong>
				</h3>
			</div>
			<div class="list_wrap">
				<p class="txt_notice refund">
				<p class="text-warning">
					<strong>�ش����� ������ �������� �ʽ��ϴ�</strong>
				</p>
				<br> �̸����� Ȯ�� �� ȣ��Ʈ�� ���������� ������ �ּ���
				</p>


			</div>
		</article>
	</div>
	<div class="row">
		<div class="table-responsive" style="width: 100%; overflow: auto">
			<table class="table" width="100%">
				<thead class="thead-dark">
					<tr>
						<th width="25%" align="center"><strong>���� ����</strong></th>
						<th width="75%" style="text-align: right;"><strong><span
								class="badge badge-pill badge-warning">�����ȣ : <%=reservationDto.getRMRNO()%>
							</span></strong></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>����Ϸ�����</td>
						<td><%=reservationDto.getRMR_DATE()%></td>
					</tr>

					<tr>
						<td>�������</td>
						<td><a href="">[<%=reservationDto.getSP_NAME()%>] - <%=reservationDto.getRM_NAME()%></a></td>
					</tr>

					<tr>
						<td>���೻��</td>
						<td><strong>��� ���� : <%=reservationDto.getRMR_TIME_IN()%><br></strong>
							<strong>��� ���� : <%=reservationDto.getRMR_TIME_OUT()%><br></strong></td>
					</tr>

					<tr>
						<td>����ο�</td>
						<td><%=reservationDto.getRMR_PERSON()%></td>
					</tr>

					<tr>
						<td>��û����</td>
						<td><%=reservationDto.getRMR_CONTENT()%></td>
					</tr>

					<tr>
						<td>���೻�� ����</td>
						<td>
							<form name = "rsvdeleteForm" id="rsvdeleteForm" method = "GET" action = "">
							<input type="hidden" name="act" id="act" value="rsvDelete">
							<input type="hidden" name="rmrno" id="rmrno" value="<%=reservationDto.getRMRNO()%>">
								<input type="button" name="rsv_delete" value="���� ���� ����" class="btn btn-block" onclick="javascript:rsvDelete('<%=reservationDto.getRMR_DATE()%>');">
							</form>
						</td>
					</tr>
				</tbody>
			</table>

			<table class="table" width="100%">
				<thead class="thead-dark">
					<tr>
						<th width="25%" align="center"><strong>������ ����</strong></th>
						<th width="75%" style="text-align: right;"></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>������ID</td>
						<td><%=reservationDto.getRMR_ID()%></td>
					</tr>
					<tr>
						<td>����ó</td>
						<td><%=NullCheck.nullToZero(reservationDto.getRMR_TEL())%></td>
					</tr>
					<tr>
						<td>�̸���</td>
						<td><%=reservationDto.getRMR_EMAIL()%></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

<%@ include file="/common/footer.jsp"%>