<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.st.member.model.MemberDto"%>

<%@include file="/common/header.jsp" %>

<div>&nbsp;</div>
<div>&nbsp;</div>
<div class="jumbotron container mx-auto mt-5 pt-5">

<div align="center">
<%
if("1".equals(memberDto.getM_STATUS())) {
%>
<h1>비밀번호는 <%= memberDto.getM_EMAIL() %>에 임시비밀번호를 보냈습니다!<br> 확인하시고 다시 로그인해 주세요!. </h1>
<a href="<%=root%>/main/login.jsp"><button type="button" class="btn btn-secondary mt-3">로그인하러 가기</button></a>
<%
} else {
%>
<h1><%= memberDto.getM_ID()%>님의 아이디는<br> 탈퇴되었습니다.<br> 다시 회원가입해 주세요!. </h1>
<a href="<%=root%>/main/login.jsp"><button type="button" class="btn btn-secondary mt-3">회원가입하러 가기</button></a>
<%
}
%>
<%@ include file="/common/footer.jsp" %>