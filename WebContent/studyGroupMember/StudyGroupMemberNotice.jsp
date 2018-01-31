<%@page import="com.st.studygroup.model.BoardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/studygroupmain/studygroupmembersubnav.jsp"%>
<%
List<BoardDto> list = (List<BoardDto>) request.getAttribute("enternotice");
%>
<script>
function mvmembernoticecontent(WNO){
	document.location.href ="<%=root%>/bc?act=mvmembernoticecontent&WNO=" + WNO;
}

</script>
<div class="notice">
	<table class="table table-striped table-hover table-bordered table-sm">
		<thead>
			<tr>
				<th>��ȣ</th>
				<th>����</th>
				<th>�۾���</th>
				<th>�ۼ���</th>
			</tr>
		</thead>
		<%
		int size = list.size();
		if (size != 0) {
			for (BoardDto boardDto : list) {				
		%>
		<tbody>
			<tr>
			<tr>
				<td width="10%"><%=boardDto.getWNO() %></td>
				<td><a href="javascript:mvmembernoticecontent('<%=boardDto.getWNO() %>');"><%=boardDto.getW_TITLE() %></a></td>
				<td width="10%"><%=boardDto.getW_ID() %></td>
				<td width="10%"><%=boardDto.getW_DATE() %></td>
			</tr>
		</tbody>
		<%
			}
		} else {
		%>
		<tbody>
		<tr>
			<td colspan="4">�ۼ��� ���������� �����ϴ�</td>
		</tr>
		</tbody>
		<%
			}
			
		%>
	</table>
</div>
	
</div>
</div>
</div>
</div>
<%@include file="/common/footer.jsp"%>