<%@page import="com.st.util.PageNavigation"%>
<%@page import="com.st.studygroup.model.StudyGroupDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/studygroupmain/studygroupnav.jsp"%>

<%
List<StudyGroupDto> list = (List<StudyGroupDto>) request.getAttribute("listarticle");
PageNavigation navigator = (PageNavigation) request.getAttribute("navigator");
%>
<script type="text/javascript">
function viewGroupContent(SNO,pg,word){
	document.location.href = "<%=root %>/stgcontroll?act=viewgroupcontent&SNO="+SNO + "&pg=" + pg + "&word=" + word;
}
</script>
<style>
tr:nth-child(odd){
	background:white;
}

tr:nth-child(even){
	background:lightgray;
}
</style>
<!-- #######################���͵� �׷� ����Ʈ ���̺�######################### -->

<form method="get" id="mainGroupForm" name="mainGroupForm">

<table class="table  table-hover table-bordered table-sm"  >
	<thead class="thead-dark" >
		<tr>
			<th style="width:110px;">�� ��ȣ</th>
			<th>���͵� �׷��</th>
			<th style="width:110px;">�׷��� ���̵�</th>
			<th style="width:130px;">�����ο�/�����ο�</th>
			<th style="width:130px;">�׷� ����</th>
		</tr>
	</thead>
	<tbody>
	<%
	int size = list.size();
	if(size != 0){
		for(StudyGroupDto studyGroupDto : list){
	
	%>
		<tr>
			<td><%=studyGroupDto.getSNO()%></td>
			<td><a href="javascript:viewGroupContent('<%=studyGroupDto.getSNO()%>','<%=pg %>','<%=word%>');"><%=studyGroupDto.getS_NAME()%></a></td>
			<td><%=studyGroupDto.getS_ID()%></td>
			<td><%=studyGroupDto.getS_PERSON()%>�� / <%=studyGroupDto.getS_MAXPERSON()%>��</td>
			<td><%=studyGroupDto.getS_CURR_STATUS()%> / <%=studyGroupDto.getS_BEING()%></td>
		</tr>
		<%
		}
		}else{
		%>
		<tr>
		<td colspan="5">������ ���͵� �׷��� �����ϴ�</td>
		</tr>
		<%
		}
		%>
	</tbody>
</table>
<div>
	<table  width="100%" align="center" style="margin-left:40px;">
		<tr>
			<td><%=navigator.getNavigator()%></td>
		</tr>
	</table>
</div>

</form>
</div>
</div>
</div>

<%@ include file="/common/footer.jsp"%>