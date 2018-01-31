<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/studygroupmain/studygroupsubnav.jsp"%>
<%
StudyGroupDto studyGroupDto = (StudyGroupDto) request.getAttribute("modifyviewgroup"); 
%>
<script>
function studygroupmodify(SNO){
	if(<%= studyGroupDto.getS_PERSON()%> > parseInt(document.getElementById("maxMember").value)){
		alert("�����ο��� �� �����ϴ�");
		return;
	}
	document.getElementById("stmodifyform").action = "<%=root%>/stgcontroll?SNO=" + SNO;
	document.getElementById("stmodifyform").submit();
}
function mvMyGroupContent(SNO){
	document.location.href = "<%=root %>/stgcontroll?act=mvmygroupcontent&SNO="+SNO;
}
</script>

			<!--######################### �׷� ��� ���ø�########################## -->
			<form method="post" style="padding: 30px;" id="stmodifyform" name="stmodifyform">
			<input type="hidden" name="act" value="modifygroup">
			<input type="hidden" name="sperson" value="<%=studyGroupDto.getS_PERSON()%>">
				<fieldset>
					<legend>���͵� �׷� ����</legend>
					<div class="form-group">
						<label class="col-form-label col-form-label-lg" for="inputLarge">���͵� �׷��</label> 
							<input class="form-control form-control-lg" type="text" id="SNAME" name="SNAME" value="<%=studyGroupDto.getS_NAME()%>">
					</div>
					<div class="form-group">
						<fieldset>
							<label class="control-label" for="readOnlyInput">���͵� �׷��� ���̵�</label> 
								<input class="form-control" id="SID" name="SID" type="text" placeholder="java2" readonly="readonly" 
								value="<%=studyGroupDto.getS_ID()%>">
						</fieldset>
					</div>
					<div class="form-group">
						<label for="exampleSelect"> �� �ο�</label> 
						<select class="form-control" name="maxMember" id="maxMember">
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
						<label for="exampleSelect">���� ����</label> 
						<select class="form-control" name="stStatus" id="stStatus">
							<option value="0">�����</option>
							<option value="1">������</option>
							<option value="2">�Ϸ�</option>							
						</select>
					</div>
					<div class="form-group">
						<label for="exampleTextarea" >���͵� �׷� �Ұ�</label>
						<textarea class="form-control" id="SCONTENT" name="SCONTENT" rows="3"><%=studyGroupDto.getS_CONTENT()%></textarea>
					</div>
					<div class="form-group">
						<label for="exampleTextarea">#�ؽ��±� ���</label>
						<textarea class="form-control" id="STAG" name="STAG" rows="3"><%=studyGroupDto.getS_TAG()%></textarea>
					</div>
					<div align="center">
						<button type="button" class="btn btn-success"
							style="float: middle;" onclick="javascript:studygroupmodify(<%=bdlist.get(0).getSNO()%>);">�����ϱ�</button>
						<button type="button" class="btn btn-danger" onclick="javascript:mvMyGroupContent('<%=bdlist.get(0).getSNO()%>');">���</button>
					</div>
				</fieldset>
			</form>



		</div>
	</div>
</div>


<%@ include file="/common/footer.jsp"%>