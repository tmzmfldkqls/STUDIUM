<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/studygroupmain/studygroupsubnav.jsp"%>
<script type="text/javascript">
function writeArticle(){
	if(document.noticeWriteForm.subject.value =="") {
		alert("������ �Է��� �ּ���");
		return ;
	} else if(document.noticeWriteForm.content.value == ""){
			alert("������ �Է��� �ּ���");
			return ;
	} else {
		document.noticeWriteForm.action = "<%=root%>/bc";
		document.noticeWriteForm.submit();
		}
	}
	
function mvMyGroupContent(SNO){
	document.location.href = "<%=root %>/stgcontroll?act=mvmygroupcontent&SNO="+SNO;
}
</script>
<form method="post" act="" id="noticeWriteForm" name="noticeWriteForm">
	<input type="hidden" name="act" id="act" value="newarticle">
	
	<div class="table-responsive-sm">
		<table class="table">
			<thead>
				<tr>
					<th align="right"><label for="comment">�ۼ���:</label> <textarea
							class="form-control" rows="1" id="comment" readonly="readonly"><%=memberDto.getM_ID() %></textarea>
					<th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th><label for="comment">����:</label> <textarea
							class="form-control" rows="1" id="subject" name="subject"></textarea>
					<th>
				</tr>
				<tr>
					<th><label for="comment">����:</label> <textarea
							class="form-control" rows="5" id="content" name="content"></textarea>
					<th>
				</tr>
			</tbody>
		</table>
		<div align="center" style="padding-bottom: 2%;">
			<button type="button" class="btn btn-success" style="float: middle;"
				onclick="javascript:writeArticle(<%=bdlist.get(0).getSNO()%>);">���</button>
				
			<button type="button" class="btn btn-danger"
				onclick="javascript:mvMyGroupContent('<%=bdlist.get(0).getSNO()%>');">���</button>
		</div>
	</div>
</form>
</div>
</div>
<%@include file="/common/footer.jsp"%>