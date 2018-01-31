<%@page import="com.st.member.model.MemberDto"%>
<%@page import="com.st.studygroup.model.StudyGroupDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/studygroupmain/studygroupnav.jsp"%>

<script type="text/javascript">

function groupWriteArticle(){
	if(document.getElementById("inputLarge").value == "") {
		alert("스터디 그룹명을 입력하세요.");
		return;
	}else if(document.getElementById("introGroup").value == ""){
		alert("스터디 그룹 소개를 입력하세요.");
		return;
	}else if(document.getElementById("hashTagGroup").value == ""){
		alert("스터디 그룹 해쉬태그를 입력하세요.");
		return;
	}else{
		document.getElementById("stgwriteForm").action = "<%=root%>/stgcontroll";
		document.getElementById("stgwriteForm").submit();
		}
	}
</script>

<!--######################### 그룹 등록 템플릿########################## -->
<form id="stgwriteForm" name="stgwriteForm" method="post"
	style="padding: 30px;">

	<input type="hidden" name="act" value="stgregister">
	<input type="hidden" name="pg" value="1">
	<input type="hidden" name="word" value="">

	<fieldset>
		<legend>스터디 그룹 등록</legend>
		<div class="form-group">
			<label class="col-form-label col-form-label-lg" for="inputLarge">스터디
				그룹명</label> <input class="form-control form-control-lg" type="text"
				id="inputLarge" name="stgname">
		</div>
		<div class="form-group">
			<fieldset>
				<label class="control-label" for="readOnlyInput">스터디 그룹장 아이디</label>
				<input class="form-control" id="readOnlyInput" type="text"
					value="<%=memberDto.getM_ID()%>" readonly="">
			</fieldset>
		</div>
		<div class="form-group">
			<label for="exampleSelect1">총 인원</label> <select class="form-control"
				name="maxMember" id="maxMember">
				<option value="2">2명</option>
				<option value="3">3명</option>
				<option value="4">4명</option>
				<option value="5">5명</option>
				<option value="6">6명</option>
				<option value="7">7명</option>
				<option value="8">8명</option>
				<option value="9">9명</option>
				<option value="10">10명</option>
			</select>
		</div>
		<div class="form-group">
			<label for="exampleTextarea">스터디 그룹 소개</label>
			<textarea class="form-control" id="introGroup" name="introGroup"
				rows="3"></textarea>
		</div>
		<div class="form-group">
			<label for="exampleTextarea">#해쉬태그 등록</label>
			<textarea class="form-control" id="hashTagGroup" name="hashTagGroup"
				rows="3"></textarea>
		</div>
		<div align="center">
			<button type="button" class="btn btn-success" style="float: middle;"
				onclick="javascript:groupWriteArticle();">등록</button>
			<button type="button" class="btn btn-danger"
				onclick="location.href='<%=root %>/stgcontroll?act=mvgroup&pg=1&word='">취소</button>
		</div>
	</fieldset>
</form>

</div>
</div>
</div>


<%@ include file="/common/footer.jsp"%>