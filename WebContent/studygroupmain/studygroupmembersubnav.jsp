<%@page import="java.util.List"%>
<%@page import="com.st.studygroup.model.BoardListDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/studygroupmain/studygroupnav.jsp"%>
<%
List<BoardListDto> bdlist = (List<BoardListDto>) session.getAttribute("groupInfo");
%>
<script type="text/javascript">
function mvMemberGroupNotice(){
	document.location.href = "<%=root %>/bc?act=memberlistnotice";
}

function mvMemberBbs(SNO){
	document.location.href = "<%=root%>/bbs?act=mvmemberbbs";
}

function mvMemberSchedule(){
	document.location.href = "<%=root%>/groupschedule?act=mvmemberschedule";
}

function mvMemberViewMember(SNO){
	document.location.href = "<%=root%>/gmc?act=mvmemberviewmember";
}

function mvMemberOut(){
	document.location.href = "<%=root%>/gmc?act=mvmemberout";
}
</script>
<ul class="nav nav-tabs">
	<li class="nav-item"><a class="nav-link"
		href="javascript:mvMemberGroupNotice();">공지 사항</a></li>
	<li class="nav-item"><a class="nav-link"
		href="javascript:mvMemberViewMember('<%=bdlist.get(0).getSNO()%>');">그룹 멤버</a></li>
	<li class="nav-item"><a class="nav-link"
		href="javascript:mvMemberSchedule();">일 정</a></li>
	<li class="nav-item"><a class="nav-link"
		href="javascript:mvMemberBbs('<%=bdlist.get(1).getSNO()%>');">자 료 실</a></li>
	<li class="nav-item"><a class="nav-link"
		href="javascript:mvMemberOut();">회 원 탈 퇴</a></li>
</ul>


