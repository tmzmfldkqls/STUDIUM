<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.st.member.model.MemberDto"%>
<%@ include file="/common/header.jsp" %>
<%
	MemberDto mem = (MemberDto) request.getAttribute("userInfo");
%>

<div>&nbsp;</div>
<div>&nbsp;</div>
<div class="jumbotron container mx-auto mt-5 pt-5">
<div align="center"><h1><%= mem.getM_NAME() %>����<br><%= mem.getM_ID()%> �� ����ϼ̽��ϴ�.<br> ȯ���մϴ�. </h1></div>
<center><a href="<%=root%>/main/login.jsp"><button type="button" class="btn btn-secondary mt-3">�α����Ϸ� ����</button></a></center>
</div>
<%@ include file="/common/footer.jsp" %>