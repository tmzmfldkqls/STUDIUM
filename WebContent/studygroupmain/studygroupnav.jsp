<%@page import="com.st.studygroup.model.StudyGroupDto"%>
<%@page import="com.st.studygroup.service.StudyGroupServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/common/header.jsp"%>
<%
int pg = NullCheck.nullToOne(request.getParameter("pg"));
String word = StringEncoder.isoToEuc(request.getParameter("word"));
System.out.println("studyGroupnavbar.jsp>>>>> word : " + word);
System.out.println("studyGroupnavbar.jsp>>>>> pg : " + pg);
%>
<style>
html, body {
	width: 100%;
	height: 100%;
	margin: 0;
}
</style>
<script>
function stSearch() {
	if(document.getElementById("word").value == ""){
		alert("�˻�� �Է��ϼ���");
	}
	document.getElementById("searchForm").action = "<%=root%>/stgcontroll";
	document.getElementById("searchForm").submit();
}
</script>
<link rel="stylesheet" href="<%=root%>/css/studygroupmain.css">
<form id="commonForm" name="commonForm" method="get" action="">
<input type="hidden" id="cact" name="act" value ="">
<input type="hidden" id="cpg" name="pg" value ="">
<input type="hidden" id="cword" name="word" value ="">
</form>
<!--####################### �� ��� div####################### -->
<div class="studygroupbody">
	<!-- #######################�׺�� div####################### -->
	<div class="studygroupbodynav">

		<!-- #######################���͵� �׷� ���̹�######################### -->
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark" >			
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarColor02" aria-controls="navbarColor02"
				aria-expanded="false" aria-label="Toggle navigation">				
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarColor02">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item" ><a
						class="nav-link" href="<%=root %>/stgcontroll?act=mvgroup&pg=1">���͵� �׷� ����Ʈ <span class="sr-only"></span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="<%=root %>/stgcontroll?act=mvmygroup">���͵� �׷� ����</a></li>
					<li class="nav-item"><a class="nav-link" href="<%=root %>/stgcontroll?act=mvincludeme">���� ���� �׷�</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="<%=root%>/stgcontroll?act=mvregisterstg">���͵� �׷� ���</a></li>
				</ul>
				<form class="form-inline my-2 my-lg-0" id="searchForm" name="searchForm" method="get" action="" >
				<input type="hidden" id="act" name="act" value="mvgroup">
				<input type="hidden" id="pg" name="pg" value="1">	
					<input class="form-control mr-sm-2" type="text"
						placeholder="Search" id="word" name="word">
					<button class="btn btn-secondary my-2 my-sm-0" type="submit" "onkeypress="javascript:if(event.keyCode == 13) {stSearch();}"" >�˻�</button>
				</form>
			</div>
		</nav>

		<!-- #######################���͵� �׷� ����Ʈ ���̺� div######################### -->
		<div class="tableback"
			style="background-color: white; overflow: hidden; height: auto; margin-bottom: 5%;">
		
