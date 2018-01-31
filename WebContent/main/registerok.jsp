<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.st.member.model.MemberDto"%>
<%@ include file="/common/header.jsp" %>
<%
	MemberDto mem = (MemberDto) request.getAttribute("userInfo");
%>

<div>&nbsp;</div>
<div>&nbsp;</div>
<div class="jumbotron container mx-auto mt-5 pt-5">
<div align="center"><h1><%= mem.getM_NAME() %>님이<br><%= mem.getM_ID()%> 로 등록하셨습니다.<br> 환영합니다. </h1></div>
<center><a href="<%=root%>/main/login.jsp"><button type="button" class="btn btn-secondary mt-3">로그인하러 가기</button></a></center>
</div>
<%@ include file="/common/footer.jsp" %>