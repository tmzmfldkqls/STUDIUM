<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/studygroupmain/studygroupmembersubnav.jsp"%>
<script type="text/javascript">
function studyGroupOut(){
	if (confirm("정말 이그룹을 탈퇴하시겠습니까??") == true){    
		document.location.href ="<%=root%>/gmc?act=memberout";
	}else{   
	    return;
	}
}
</script>
<center>
	<div class="notice">
	<h1>정말 이 그룹을 탈퇴 하시겠습니까?</h1>
		<div align="center" style="margin-top:2%; margin-bottom:2%;">
	
	<button type="button" class="btn btn-danger"
		onclick="javascript:studyGroupOut();">탈퇴</button>
</div>
	</div>
</center>
</div>
</div>
</div>
<%@include file="/common/footer.jsp"%>