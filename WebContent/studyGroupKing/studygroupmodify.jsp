<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/studygroupmain/studygroupsubnav.jsp"%>
<%
StudyGroupDto studyGroupDto = (StudyGroupDto) request.getAttribute("modifyviewgroup"); 
%>
<script>
function studygroupmodify(SNO){
	if(<%= studyGroupDto.getS_PERSON()%> > parseInt(document.getElementById("maxMember").value)){
		alert("현재인원이 더 많습니다");
		return;
	}
	document.getElementById("stmodifyform").action = "<%=root%>/stgcontroll?SNO=" + SNO;
	document.getElementById("stmodifyform").submit();
}
function mvMyGroupContent(SNO){
	document.location.href = "<%=root %>/stgcontroll?act=mvmygroupcontent&SNO="+SNO;
}
</script>

			<!--######################### 그룹 등록 템플릿########################## -->
			<form method="post" style="padding: 30px;" id="stmodifyform" name="stmodifyform">
			<input type="hidden" name="act" value="modifygroup">
			<input type="hidden" name="sperson" value="<%=studyGroupDto.getS_PERSON()%>">
				<fieldset>
					<legend>스터디 그룹 수정</legend>
					<div class="form-group">
						<label class="col-form-label col-form-label-lg" for="inputLarge">스터디 그룹명</label> 
							<input class="form-control form-control-lg" type="text" id="SNAME" name="SNAME" value="<%=studyGroupDto.getS_NAME()%>">
					</div>
					<div class="form-group">
						<fieldset>
							<label class="control-label" for="readOnlyInput">스터디 그룹장 아이디</label> 
								<input class="form-control" id="SID" name="SID" type="text" placeholder="java2" readonly="readonly" 
								value="<%=studyGroupDto.getS_ID()%>">
						</fieldset>
					</div>
					<div class="form-group">
						<label for="exampleSelect"> 총 인원</label> 
						<select class="form-control" name="maxMember" id="maxMember">
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
						<label for="exampleSelect">상태 변경</label> 
						<select class="form-control" name="stStatus" id="stStatus">
							<option value="0">대기중</option>
							<option value="1">진행중</option>
							<option value="2">완료</option>							
						</select>
					</div>
					<div class="form-group">
						<label for="exampleTextarea" >스터디 그룹 소개</label>
						<textarea class="form-control" id="SCONTENT" name="SCONTENT" rows="3"><%=studyGroupDto.getS_CONTENT()%></textarea>
					</div>
					<div class="form-group">
						<label for="exampleTextarea">#해쉬태그 등록</label>
						<textarea class="form-control" id="STAG" name="STAG" rows="3"><%=studyGroupDto.getS_TAG()%></textarea>
					</div>
					<div align="center">
						<button type="button" class="btn btn-success"
							style="float: middle;" onclick="javascript:studygroupmodify(<%=bdlist.get(0).getSNO()%>);">수정하기</button>
						<button type="button" class="btn btn-danger" onclick="javascript:mvMyGroupContent('<%=bdlist.get(0).getSNO()%>');">취소</button>
					</div>
				</fieldset>
			</form>



		</div>
	</div>
</div>


<%@ include file="/common/footer.jsp"%>