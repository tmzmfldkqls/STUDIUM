<%@page import="com.st.member.model.MemberDto"%>
<%@page import="com.st.studygroup.model.StudyGroupDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/studygroupmain/studygroupnav.jsp"%>

<script type="text/javascript">

function groupWriteArticle(){
	if(document.getElementById("inputLarge").value == "") {
		alert("���͵� �׷���� �Է��ϼ���.");
		return;
	}else if(document.getElementById("introGroup").value == ""){
		alert("���͵� �׷� �Ұ��� �Է��ϼ���.");
		return;
	}else if(document.getElementById("hashTagGroup").value == ""){
		alert("���͵� �׷� �ؽ��±׸� �Է��ϼ���.");
		return;
	}else{
		document.getElementById("stgwriteForm").action = "<%=root%>/stgcontroll";
		document.getElementById("stgwriteForm").submit();
		}
	}
</script>

<!--######################### �׷� ��� ���ø�########################## -->
<form id="stgwriteForm" name="stgwriteForm" method="post"
	style="padding: 30px;">

	<input type="hidden" name="act" value="stgregister">
	<input type="hidden" name="pg" value="1">
	<input type="hidden" name="word" value="">

	<fieldset>
		<legend>���͵� �׷� ���</legend>
		<div class="form-group">
			<label class="col-form-label col-form-label-lg" for="inputLarge">���͵�
				�׷��</label> <input class="form-control form-control-lg" type="text"
				id="inputLarge" name="stgname">
		</div>
		<div class="form-group">
			<fieldset>
				<label class="control-label" for="readOnlyInput">���͵� �׷��� ���̵�</label>
				<input class="form-control" id="readOnlyInput" type="text"
					value="<%=memberDto.getM_ID()%>" readonly="">
			</fieldset>
		</div>
		<div class="form-group">
			<label for="exampleSelect1">�� �ο�</label> <select class="form-control"
				name="maxMember" id="maxMember">
				<option value="2">2��</option>
				<option value="3">3��</option>
				<option value="4">4��</option>
				<option value="5">5��</option>
				<option value="6">6��</option>
				<option value="7">7��</option>
				<option value="8">8��</option>
				<option value="9">9��</option>
				<option value="10">10��</option>
			</select>
		</div>
		<div class="form-group">
			<label for="exampleTextarea">���͵� �׷� �Ұ�</label>
			<textarea class="form-control" id="introGroup" name="introGroup"
				rows="3"></textarea>
		</div>
		<div class="form-group">
			<label for="exampleTextarea">#�ؽ��±� ���</label>
			<textarea class="form-control" id="hashTagGroup" name="hashTagGroup"
				rows="3"></textarea>
		</div>
		<div align="center">
			<button type="button" class="btn btn-success" style="float: middle;"
				onclick="javascript:groupWriteArticle();">���</button>
			<button type="button" class="btn btn-danger"
				onclick="location.href='<%=root %>/stgcontroll?act=mvgroup&pg=1&word='">���</button>
		</div>
	</fieldset>
</form>

</div>
</div>
</div>


<%@ include file="/common/footer.jsp"%>