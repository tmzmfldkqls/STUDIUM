<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.st.member.model.MemberDto"%>
<%@ include file="/common/header.jsp" %>

<div>&nbsp;</div>
<div>&nbsp;</div>
<div class="jumbotron container mx-auto mt-5 pt-5">

<div align="center">
<%
if("1".equals(memberDto.getM_STATUS())) {
%>
<h1><%= memberDto.getM_NAME() %>���� ���̵��<br>&lt;<%= memberDto.getM_ID() %>&gt;�Դϴ�.<br> �ٽ� �α����� �ּ���!. </h1>
<a href="<%=root%>/main/login.jsp"><button type="button" class="btn btn-secondary mt-3">�α����Ϸ� ����</button></a>
<%
} else {
%>
<h1><%= memberDto.getM_ID()%>���� ���̵��<br> Ż��Ǿ����ϴ�.<br> �ٽ� ȸ�������� �ּ���!. </h1>
<a href="<%=root%>/main/login.jsp"><button type="button" class="btn btn-secondary mt-3">ȸ�������Ϸ� ����</button></a>
<%
}
%>
</div>
</div>
<%@ include file="/common/footer.jsp" %>