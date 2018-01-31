<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/common/admin_header.jsp"%>
<link rel="stylesheet" href="<%=root%>/css/sb-admin-2.css">
<script type="text/javascript" src="<%=root%>/js/httpRequest.js"></script>
<script type="text/javascript">
window.onload = function() {
	dashlist();
}
function dashlist() {
	var params = "act=dashlist";
	sendRequest("<%= root%>/admin", params, viewlist, "GET");
	}

	function viewlist() {
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				var listxml = httpRequest.responseXML; // mlist받아옴
				makelist1(listxml);
				makelist(listxml);
				makelist2(listxml);
			}
		}
	}

	function makelist1(listxml) {
		var div = document.getElementById("dslist");
		var len = listxml.getElementsByTagName("space").length;
		for (var i = 0; i < len; i++) {
			var al = makealert1(listxml.getElementsByTagName("space")[i]);
			div.appendChild(al);
		}
	}
	function makealert1(space) {
		var scontent = space.getElementsByTagName("scontent")[0].firstChild.data;
		var name = space.getElementsByTagName("name")[0].firstChild.data;
		var nametxtNode = document.createTextNode(name);
		var scontenttxtNode = document.createTextNode(scontent);
		var btn = makebutton();
		var al = document.createElement("div");
		al.setAttribute("class", "alert alert-success alert-dismssable");
		al.appendChild(btn);
		al.appendChild(nametxtNode);
		al.appendChild(document.createTextNode("공간 "));
		al.appendChild(scontenttxtNode);
		al.appendChild(document.createTextNode("."));
		return al;
	}

	function makelist(listxml) {
		var div = document.getElementById("dmlist");
		var len = listxml.getElementsByTagName("member").length;
		for (var i = 0; i < len; i++) {
			var al = makealert(listxml.getElementsByTagName("member")[i]);
			div.appendChild(al);
		}
	}
	function makealert(member) {
		var userid = member.getElementsByTagName("userid")[0].firstChild.data;
		var name = member.getElementsByTagName("name")[0].firstChild.data;
		var nametxtNode = document.createTextNode(name);
		var useridtxtNode = document.createTextNode(userid);
		var btn = makebutton();
		var al = document.createElement("div");
		al.setAttribute("class", "alert alert-success alert-dismssable");
		al.appendChild(btn);
		al.appendChild(nametxtNode);
		al.appendChild(document.createTextNode("님이 "));
		al.appendChild(useridtxtNode);
		al.appendChild(document.createTextNode("로 회원가입했습니다."));
		return al;
	}

	function makelist2(listxml) {
		var div = document.getElementById("dglist");
		var len = listxml.getElementsByTagName("studygroup").length;
		for (var i = 0; i < len; i++) {
			var al = makealert2(listxml.getElementsByTagName("studygroup")[i]);
			div.appendChild(al);
		}
	}
	function makealert2(studygroup) {
		var scontent = studygroup.getElementsByTagName("content")[0].firstChild.data;
		var name = studygroup.getElementsByTagName("name")[0].firstChild.data;
		var nametxtNode = document.createTextNode(name);
		var scontenttxtNode = document.createTextNode(scontent);
		var btn = makebutton();
		var al = document.createElement("div");
		al.setAttribute("class", "alert alert-success alert-dismssable");
		al.appendChild(btn);
		al.appendChild(nametxtNode);
		al.appendChild(document.createTextNode("그룹 "));
		al.appendChild(scontenttxtNode);
		al.appendChild(document.createTextNode("."));
		return al;
	}	

	function makebutton() {
		var btn = document.createElement("button");
		btn.setAttribute("type", "button");
		btn.setAttribute("class", "close");
		btn.setAttribute("data-dismiss", "alert");
		btn.setAttribute("aria-hidden", "true");
		btn.appendChild(document.createTextNode("x"));
		return btn;
	}
</script>
<div id="wrapper">
	<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-6 pt-4">
			<div class="panel panel-default">
				<div class="panel-heading">오늘 회원가입 현황</div>
				<!-- /.panel-heading -->
				<div id="dmlist" class="panel-body"></div>
				<!-- .panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-6 -->
		<div class="col-lg-6 pt-4">
			<div class="panel panel-default">
				<div class="panel-heading">오늘 공간 현황</div>
				<!-- /.panel-heading -->
				<div id="dslist" class="panel-body"></div>
				<!-- .panel-body -->
			</div>
			<!-- /.panel -->
		</div>
	</div>
		<div class="row">
		<!-- /.col-lg-6 -->
			<div class="col-lg-6 pt-4">
				<div class="panel panel-default">
					<div class="panel-heading">오늘 그룹 현황</div>
				<!-- /.panel-heading -->
					<div id="dglist" class="panel-body"></div>
				<!-- .panel-body -->
				</div>
			<!-- /.panel -->
			</div>
		<!-- /.col-lg-6 -->
		</div>
	</div>
</div>
<!-- /.col-lg-8 -->



<%@ include file="/common/admin_footer.jsp" %>
