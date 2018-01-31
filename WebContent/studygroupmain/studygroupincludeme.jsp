<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="java.util.*"%>
<%@ include file="/studygroupmain/studygroupnav.jsp"%>
<script type="text/javascript">
function mvincludemegroup(SNO){
	document.location.href = "<%=root %>/stgcontroll?act=mvincludemegroup&SNO="+SNO;
}
</script> 
<%
List<StudyGroupDto> includeMeList = (List<StudyGroupDto>) request.getAttribute("includemelist");
System.out.println(">>>>>>>>>" + includeMeList);
%>

<!-- #######################���͵� �׷� ����Ʈ ���̺�######################### -->
<table class="table  table-hover table-bordered table-sm">
	<thead class="thead-dark">
		<tr>
			<th style="width: 110px;">�� ��ȣ</th>
			<th>���͵� �׷��</th>
			<th style="width: 110px;">�׷��� ���̵�</th>
			<th style="width:130px;">�����ο�/�����ο�</th>
			<th style="width: 130px;">�׷� ����</th>
		</tr>
	</thead>
	<tbody>
	<%
	int size = includeMeList.size();
	if(size != 0){
	for(StudyGroupDto studyGroupDto : includeMeList){
		
		%>
			<tr>
				<td><%=studyGroupDto.getSNO()%></td>
				<td><a href="javascript:mvincludemegroup(<%=studyGroupDto.getSNO()%>);"><%=studyGroupDto.getS_NAME()%></a></td>
				<td><%=studyGroupDto.getS_ID()%></td>
				<td><%=studyGroupDto.getS_PERSON()%>�� / <%=studyGroupDto.getS_MAXPERSON()%>��</td>
				<td><%=studyGroupDto.getS_CURR_STATUS()%> / <%=studyGroupDto.getS_BEING()%></td>
			</tr>
			<%
			}
			}else{
			%>
			<tr>
				<td colspan="5">���Ե� ���͵� �׷��� �����ϴ�</td>
			</tr>
			<%
			}
			%>
		</tbody>
</table>


</div>
</div>
</div>

<%@include file="/common/footer.jsp"%>