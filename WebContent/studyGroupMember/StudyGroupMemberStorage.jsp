<%@page import="com.st.studygroup.model.BbsGroupDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/studygroupmain/studygroupmembersubnav.jsp"%>
<%
List<BbsGroupDto> list = (List<BbsGroupDto>) request.getAttribute("bbsList");
%>
<div class="storage">
	<table class="table table-striped table-hover table-bordered table-sm">
		<thead>
			<tr>
				<th>���̵�</th>
				<th>�����̸�</th>
				<th>���ϳ���</th>
				<th>�ٿ�ε�</th>
				<th>���ε�Ƚð�</th>
			</tr>
		</thead>
		<%
	int size = list.size();
	if(size != 0){
		for(BbsGroupDto bbsGroupDto : list){
	%>
		<tbody>
			<tr>
				<td><%=bbsGroupDto.getF_ID()%></td>
				<td><%=bbsGroupDto.getF_NAME()%></td>
				<td><%=bbsGroupDto.getF_CONTENT()%></td>
				
				<td>
				<a href="<%= root %>/fileDownload?fileName=<%=bbsGroupDto.getF_NAME()%>"><button type="button" class="btn btn-success"
						style="float: middle;">�ٿ�ε�</button></a></td>
				<td>
				<div class="progress">
						<div class="progress-bar progress-bar-striped progress-bar-animated"
							role="progressbar" aria-valuenow="75" aria-valuemin="0"
							aria-valuemax="100" style="width: 75%"></div>
					</div></td>
			</tr>
		</tbody>

		<%
		}
	}else{
		%>
		<tr>
			<td colspan="5">��ϵ� �ڷᰡ �����ϴ�.</td>
		</tr>
		<%
	}
		%>
	</table>
</div>
</div>
</div>
</div>
<%@include file="/common/footer.jsp"%>