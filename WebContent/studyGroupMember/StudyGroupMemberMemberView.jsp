<%@page import="com.st.studygroup.model.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/studygroupmain/studygroupmembersubnav.jsp"%>
<%
List<StudyGroupDto> klist = (List<StudyGroupDto>) request.getAttribute("klist");
%>
<script type="text/javascript" src="<%=root%>/js/httpRequest.js"></script>
<script type="text/javascript">
window.onload = function(){
	var url = "<%=root%>/gmc";
	var params = "act=memberapplymember";
	sendRequest(url, params, alist, "GET");
}

function alist(){
	if(httpRequest.readyState == 4){
		if(httpRequest.status == 200){
			var listxml = httpRequest.responseXML;
			makelist(listxml);
		}
	}
}

function makelist(data){
	var output="";
	var len = data.getElementsByTagName("groupmember").length;
	if(data != null){
		
		output +="<tr>";
		for(var j=0;j<len;j++){
			var mid = data.getElementsByTagName("mid")[j].firstChild.data;
			output +="<td name=>" + data.getElementsByTagName("mid")[j].firstChild.data +"</td>";
		}
		output +="</tr>";
	}else{
		output +="<tr>";
		output +="<td>등록된 멤버가 없습니다.</td>";
		output +="</tr>";
	}
	document.getElementById("alist").innerHTML = output;
}
</script>


<div class="member">
	<table class="table table-striped table-hover table-bordered table-sm">
		<thead>
			<tr>
				<th>스터디장</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th><%=klist.get(0).getS_ID()%></th>
			</tr>
		</tbody>
	</table>
	<table class="table table-striped table-hover table-bordered table-sm">
		<thead>
			<tr>
				<th>그룹멤버</th>
			</tr>
		</thead>
		<tbody id="alist"></tbody>
	
	
		
	</table>
</div>
</div>
</div>
<%@include file="/common/footer.jsp"%>