<%@page import="com.st.studygroup.model.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="/studygroupmain/studygroupsubnav.jsp"%>
<%
List<StudyGroupDto> klist = (List<StudyGroupDto>) request.getAttribute("klist");
%>
<script type="text/javascript" src="<%=root%>/js/httpRequest.js"></script>
<script type="text/javascript">
window.onload = function(){
	var url = "<%=root%>/gmc";
	var params = "act=applymember";
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
	if(data != ""){
		
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
	
	var len1 = data.getElementsByTagName("applymember").length;
	if(data != ""){
		output +="<h3>받은 신청</h3>";
		output +="<table class=\"table table-striped table-hover table-bordered table-sm\">";
		output +="<tr>";
		output +="<th>아이디</th>";
		output +="<th>자기소개</th>";
		output +="<th colspan=\"2\">상태</th>";
		output +="</tr>";
		
	
		for(var i=0;i<len1;i++){
			var apid = data.getElementsByTagName("apid")[i].firstChild.data;
			var apcontent = data.getElementsByTagName("apcontent")[i].firstChild.data;
			var MNO = data.getElementsByTagName("mno")[i].firstChild.data;
			output +="<tr>";
			output +="<td name=>" + data.getElementsByTagName("apid")[i].firstChild.data +"</td>";
			output +="<td>" + data.getElementsByTagName("apcontent")[i].firstChild.data + "</td>";
			output +="<td><div align=\"center\"><button type=\"button\" class=\"btn btn-success\" style=\"float: middle;\" onclick=\"javascript:accept('" + apid + "',"+ MNO +");\">수락</button>";
			output +="<button type=\"button\" class=\"btn btn-danger\" onclick=\"javascript:refuse('" + apid + "');\">거절</button>";
			output +="</div>";
			output +="</td>";
			output +="</tr>";
		}
	}else{
			output +="<tr>";
			output +="<td colspan=\"4\">그룹신청을한 아이디가 존재하지 않습니다.</td>";
			output +="</tr>";
	}
	document.getElementById("alist").innerHTML = output;
}

function accept(apid,MNO){
	var url = "<%=root%>/gmc";
	var params = "act=acceptmember&apid="+apid+"&MNO="+MNO;
	sendRequest(url, params, alist, "GET");
}

function refuse(apid){
	var url = "<%=root%>/gmc";
	var params = "act=refusemember&apid="+apid;
	if (confirm("정말 거절하시겠습니까??") == true){   
		sendRequest(url, params, alist, "GET");
	}else{   
	    return;
	}
	
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
