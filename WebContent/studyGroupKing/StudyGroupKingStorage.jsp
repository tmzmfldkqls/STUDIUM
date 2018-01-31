<%@page import="com.st.studygroup.model.BbsGroupDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/studygroupmain/studygroupsubnav.jsp"%>
<%
List<BbsGroupDto> list = (List<BbsGroupDto>) request.getAttribute("bbsList");
%>
<script type="text/javascript">
function uploadFile(){
	if(document.getElementById("inputContent").value == ""){
		alert("���� ������ ������ �ۼ����ּ���");
		return;
	}else if(document.getElementById("exampleInputFile").value == ""){
		alert("���ε��� ������ ������ �ּ���");
		return;
	}else{
		document.getElementById("uploadFile").action = "<%=root%>/fileUpload";
		document.getElementById("uploadFile").submit();
	}
}
</script>


<div class="storage">
	<table class="table table-striped table-hover table-bordered table-sm">
		<thead>
			<tr>
				<th>���̵�</th>
				<th>�����̸�</th>
				<th>���ϳ���</th>
				<th>�ٿ�ε�</th>
				<th>���ε�Ƚð�</th>
				<th>����</th>
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
				<td><button type="button" class="btn btn-danger">����</button></td>
			</tr>
		</tbody>

		<%
		}
	}else{
		%>
		<tr>
			<td colspan="6">��ϵ� �ڷᰡ �����ϴ�.</td>
		</tr>
		<%
	}
		%>
	</table>
	<div align="center" style="padding-bottom: 2%;">
		<button type="button" class="btn btn-success" style="float: middle;"
			data-toggle="modal" data-target="#myModal">�� ��</button>
	</div>
	
<form id="uploadFile" name="uploadFile" method="post" action="" enctype="multipart/form-data">
	<input type="hidden" name="act" id="act" value="">
	<input type="hidden" name="fileContent" id="fileContent" value="">
	<div class="modal" id="myModal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">���� ���ε�</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close"></button>

				</div>
				<div class="modal-body">
					<div class="form-group">
						<label class="col-form-label" for="inputDefault">���ϳ���</label> <input
							type="text" class="form-control" id="inputContent" name="fileContent"
							placeholder="���� ������ �Է��� �ּ���">
					</div>
					<div class="form-group">
						<label for="exampleInputFile">���ε� �� ����</label> <input
							type="file" name="uploadfile" class="form-control-file" id="exampleInputFile"
							aria-describedby="fileHelp"> <small id="fileHelp"
							class="form-text text-muted">���ϸ��� 10�ڰ� ���� �������ϴ�.</small>
					</div>
				</div>
				<div class="modal-footer">
					<a href= "javascript:uploadFile();"><button type="button" class="btn btn-primary">Upload File</button></a>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	</form>

</div>
</div>
</div>
</div>
<%@include file="/common/footer.jsp"%>