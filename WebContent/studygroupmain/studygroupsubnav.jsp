<%@page import="java.util.List"%>
<%@page import="com.st.studygroup.model.BoardListDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/studygroupmain/studygroupnav.jsp"%>
<%
List<BoardListDto> bdlist = (List<BoardListDto>) session.getAttribute("groupInfo");
%>
<script type="text/javascript">

function mvMyGroupNotice(){
	document.location.href = "<%=root %>/bc?act=listnotice";
}

function mvMyGroupBbs(SNO){
	document.location.href = "<%=root%>/bbs?act=mvmygroupbbs";
}

function mvMyGroupSchedule(){
	document.location.href = "<%=root%>/groupschedule?act=mvmygroupschedule";
}

function mvMyGroupMember(SNO){
	document.location.href = "<%=root%>/gmc?act=mvmymember";
	
}

function mvMyGroupModify(SNO){
	document.location.href = "<%=root %>/stgcontroll?act=mvmygroupmodify&SNO=" + SNO;
}

</script>
<ul class="nav nav-tabs ">
	<li class="nav-item"><a class="nav-link"
		href="javascript:mvMyGroupNotice();">���� ����</a></li>
	<li class="nav-item"><a class="nav-link"
		href="javascript:mvMyGroupMember('<%=bdlist.get(0).getSNO()%>');">�׷� ���</a></li>
	<li class="nav-item"><a class="nav-link"
		href="javascript:mvMyGroupSchedule();">�� ��</a></li>
	<li class="nav-item"><a class="nav-link"
		href="javascript:mvMyGroupBbs('<%=bdlist.get(1).getSNO()%>');">�� �� ��</a></li>
	<li class="nav-item"><a class="nav-link"
		href="javascript:mvMyGroupModify('<%=bdlist.get(0).getSNO()%>');">�� �� �� ��</a></li>
</ul>
