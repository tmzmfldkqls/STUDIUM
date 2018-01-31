<%@page import="java.util.List,com.st.studygroup.model.StudyGroupDto,com.st.studygroup.model.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/studygroupmain/studygroupnav.jsp"%>
<%
StudyGroupDto studyGroupDto = (StudyGroupDto) request.getAttribute("viewgroup");
StudyGroupMemberDto studyGroupMemberDto = (StudyGroupMemberDto) request.getAttribute("membercheck");
StudyGroupApplyDto studyGroupApplyDto = (StudyGroupApplyDto) request.getAttribute("applyMember");
%>
<script type="text/javascript">
function studyGroupApply(){
	if(document.getElementById("introduce").value == ""){
		alert("�ڱ�Ұ��� ������ �ۼ����ּ���");
	} else{
		document.getElementById("studyGroupApplyForm").action = "<%=root%>/stgcontroll?act=studygroupapply";
		document.getElementById("studyGroupApplyForm").submit();
	}
	
}
</script>
<form method="post" id="studyGroupApplyForm" name="studyGroupApplyForm" action = "" style="padding: 30px;">
<input type="hidden" name="act" id="act" value="studygroupapply">
<input type="hidden" name="SNO" id="SNO" value="<%=studyGroupDto.getSNO()%>">
			<!--######################### �׷� ��� ���ø�########################## -->
				<fieldset>
					<legend >���͵� �׷��</legend>
					<div class="form-group">
						<label class="col-form-label col-form-label-lg" for="inputLarge">���͵�
							�׷��</label> <input class="form-control form-control-lg" type="text"
							id="inputLarge" readonly="" value="<%=studyGroupDto.getS_NAME()%>">
					</div>
					<div class="form-group">
						<fieldset>
							<label class="control-label" for="readOnlyInput">���͵� �׷���
								���̵�</label> <input class="form-control" id="readOnlyInput" type="text"
								placeholder="java2" readonly="" value="<%=studyGroupDto.getS_ID()%>">
						</fieldset>
					</div>
					<div class="form-group">
						<label for="exampleTextarea">���͵� �׷� �Ұ�</label>
						<textarea class="form-control" id="exampleTextarea" rows="3" readonly=""><%=studyGroupDto.getS_CONTENT() %></textarea>
					</div>
					<div class="form-group">
						<label for="exampleTextarea">#�ؽ��±�</label>
						<textarea class="form-control" id="exampleTextarea" rows="3" readonly=""><%=studyGroupDto.getS_TAG()%></textarea>
					</div>
					
<%
if(!memberDto.getM_ID().equals(studyGroupDto.getS_ID()) && memberDto.getMNO() != studyGroupMemberDto.getMNO() && !memberDto.getM_ID().equals(studyGroupApplyDto.getAP_ID())){
%>
					<div class="form-group">
						<label for="exampleTextarea"> �ڱ� �Ұ�</label>
						<textarea class="form-control" id="introduce" name="introduce" rows="3" ></textarea>
					</div>
					<div align="center" style="float:left; margin-left:30%">
						<button type="button" class="btn btn-success" style="float:middle;" onclick="javascript:studyGroupApply();">��û�ϱ�</button>
					</div>
<%
}
%>
					<div align="center">
						<button type="button" class="btn btn-danger" onclick="location.href='<%=root%>/stgcontroll?act=mvgroup&pg=<%=pg%>&word=<%=word%>'">�ڷΰ���</button>
					</div>
				
				</fieldset>
			</form>
		</div>
	</div>
</div>


<%@ include file="/common/footer.jsp"%>