<%@page import="java.util.List,com.st.studygroup.model.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/studygroupmain/studygroupnav.jsp"%>
<script type="text/javascript">
function mvMyGroupContent(SNO){
	document.location.href = "<%=root %>/stgcontroll?act=mvmygroupcontent&SNO="+SNO;
}
</script> 
<%
System.out.println("�������ѱ׷��̾�");
List<StudyGroupDto> list = (List<StudyGroupDto>) request.getAttribute("listmyarticle");
System.out.println(list);
%>
<style>
tr:nth-child(odd){
	background:white;
}

tr:nth-child(even){
	background:lightgray;
}
</style>

<!-- #######################���͵� �׷� ����Ʈ ���̺�######################### -->
<table class="table  table-hover table-bordered table-sm">
	<thead class="thead-dark">
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
			<td><a href="javascript:mvMyGroupContent(<%=studyGroupDto.getSNO()%>);"><%=studyGroupDto.getS_NAME()%></a></td>
			<td><%=studyGroupDto.getS_ID()%></td>
			<td><%=studyGroupDto.getS_PERSON()%>�� / <%=studyGroupDto.getS_MAXPERSON()%>��</td>
			<td><%=studyGroupDto.getS_CURR_STATUS()%> / <%=studyGroupDto.getS_BEING()%></td>
		</tr>
		<%
		}
		}else{
		%>
		<tr>
		<td colspan="5">�ش� ���̵��� ���͵� �׷��� �����ϴ�</td>
		</tr>
		<%
		}
		%>
	</tbody>
</table>



</div>
</div>
</div>

<%@ include file="/common/footer.jsp"%>