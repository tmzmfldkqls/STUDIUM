<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/studygroupmain/studygroupmembersubnav.jsp"%>
<script type="text/javascript">
function studyGroupOut(){
	if (confirm("���� �̱׷��� Ż���Ͻðڽ��ϱ�??") == true){    
		document.location.href ="<%=root%>/gmc?act=memberout";
	}else{   
	    return;
	}
}
</script>
<center>
	<div class="notice">
	<h1>���� �� �׷��� Ż�� �Ͻðڽ��ϱ�?</h1>
		<div align="center" style="margin-top:2%; margin-bottom:2%;">
	
	<button type="button" class="btn btn-danger"
		onclick="javascript:studyGroupOut();">Ż��</button>
</div>
	</div>
</center>
</div>
</div>
</div>
<%@include file="/common/footer.jsp"%>