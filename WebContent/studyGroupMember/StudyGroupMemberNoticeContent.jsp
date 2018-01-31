<%@page import="com.st.studygroup.model.BoardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/studygroupmain/studygroupmembersubnav.jsp"%>
<%
	BoardDto boardDto = (BoardDto) request.getAttribute("viewboardcontent");
%>
<script type="text/javascript" src="<%=root%>/js/httpRequest.js"></script>
<script>
function mvMyGroupContent(){
	document.location.href = "<%=root%>/stgcontroll?act=mvmygroupcontent";
}

function replyWrite(WNO) {
	var rcontent = document.getElementById("rcontent").value;
	document.getElementById("rcontent").value = "";
	if(rcontent != "") {
		var url = "<%=root%>/reply";
		var params = "act=replyWrite&WNO=" + WNO + "&rcontent=" + rcontent;
		sendRequest(url, params, replyList, "POST");
		
	}
}

function replyList() {
	if(httpRequest.readyState == 4) {
		if(httpRequest.status == 200) {
			var listxml = httpRequest.responseXML;
			makelist(listxml);
		}
	}
}


function makelist(data) {
	var output = "";
	var len = data.getElementsByTagName("reply").length;
	for(var i=0;i<len;i++) {
		var rid = data.getElementsByTagName("rid")[i].firstChild.data;
		var r_content = data.getElementsByTagName("r_content")[i].firstChild.data;
		var r_date = data.getElementsByTagName("r_date")[i].firstChild.data;
		
		output += "<tr height=\"26\">";
		output += "	<td width=\"10%\" style=\"padding-left: 14px\">" + data.getElementsByTagName("rid")[i].firstChild.data + "</td>";
		output += "	<td style=\"padding-left: 14px\">" + data.getElementsByTagName("r_content")[i].firstChild.data;
		output += "	</td>";
		output += "	<td width=\"10%\" style=\"padding-left: 14px\">" + data.getElementsByTagName("r_date")[i].firstChild.data + "</td>";
		output += "</tr>";
		output += "<tr>";
		output += "	<td class=\"bg_board_title_02\" colspan=\"3\" height=\"1\"";
		output += "		style=\"overflow: hidden; padding: 0px\"></td>";
		output += "</tr>";
	}
	document.getElementById("replyList").innerHTML = output;
}

window.onload = function() {
	var url = "<%=root%>/reply";
	var params = "act=listReply&WNO=<%=boardDto.getWNO()%>";
		sendRequest(url, params, replyList, "GET");
	}
</script>

<form id="modifyForm" name="modifyForm" method="post"
	style="padding: 30px;">
	<div class="table-responsive-sm">
		<table class="table">
			<thead>
				<tr>
					<th align="right"><label for="comment">�ۼ���:</label> <textarea
							class="form-control" rows="1" id="comment" readonly="readonly"><%=memberDto.getM_ID()%></textarea>
					<th>
				</tr>
			</thead>
			<tr>
				<th><label for="comment">����: </label> <textarea
						class="form-control" rows="5" id="subject" name="subject"><%=boardDto.getW_TITLE()%></textarea>
				</th>
			</tr>

			<tr>
				<th><label for="comment">����: </label>
				<textarea class="form-control" rows="5" id="content" name="content"><%=boardDto.getW_CONTENT()%></textarea>
					<div align="center" style="margin: 2%;">
						<button type="button" class="btn btn-success"
							onclick="javascript:mvMyGroupContent();">�ڷΰ���</button>
					</div></th>
			</tr>
		</table>
	</div>
</form>

<table class="table">
	<tr>
		<th>
			<!-- *******************************��� ���� �ޱ�******************************** -->
			<div>
				<br>
				<textarea placeholder="����� �Է��ϼ���." class="form-control" rows="5"
					id="rcontent" name="rcontent"></textarea>
				<br>
				<button type="button" class="btn btn-info" align="right"
					onclick="javascript:replyWrite('<%=boardDto.getWNO()%>');">��۴ޱ�</button>
			</div>
			
		</th>
	</tr>

	<tr>
		<!-- *******************************��� ���� ����******************************** -->
		<td><label for="reply">��� : </label>

			<table border="0" cellpadding="5" cellspacing="0" width="100%">
				<tbody id="replyList"></tbody>
			</table>
		
		</td>
	</tr>
</table>
</div>
</div>
</div>
</div>
<%@include file="/common/footer.jsp"%>
