<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.st.member.model.MemberDto" %>
<%
String root = request.getContextPath();

MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="<%= root %>/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="<%= root %>/css/thema_pulse.css">
<link rel="stylesheet" href="<%=root%>/css/footer.css">



<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
<script>
	$(document).ready(function() {
		$('[data-toggle="popover"]').popover();
	});
	function logout() {
		document.location.href = "<%= root %>/member?act=logout";
	}
</script>
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top mr-0 ml-0 p-0">
		<div class="container justify-content-between mr-4 ml-4" style="max-width: 1900px;">
			<a class="navbar-brand " href="<%= root %>/main/main.jsp"><b>STUDIUM</b></a>
			<div class="text-center">
				<ul class="navbar-nav-lg mt-3 pl-0" >
					<div class="btn-group">
						<button type="button"
							class="btn btn-primary dropdown-toggle dropdown-toggle-split"
							data-toggle="dropdown">
							<i class="material-icons" style="font-size: 21px;">person</i><span
								class="caret"></span>
						</button>
<%if(memberDto != null) { %>
						<div class="dropdown-menu">
							<a class="dropdown-item"
								href="<%= root %>/admin/admin_main.jsp">admin page</a> 
						</div>	
<%
}
%>
					</div>

					<div class="btn-group">
						<button type="button"
							class="btn btn-primary dropdown-toggle dropdown-toggle-split"
							data-toggle="dropdown">
							<i class="fa fa-bars" style="font-size:20px"></i><span class="caret"></span>
						</button>
<%if(memberDto != null) {  %>
						<div class="dropdown-menu">
							<a class="dropdown-item"
								href="<%= root %>/admin/admin_member.jsp">MEMBER</a> <a
								class="dropdown-item"
								href="<%= root %>/admin/admin_studyspace.jsp">STUDYROOM</a> <a
								class="dropdown-item"
								href="<%= root %>/admin/admin_studygroup.jsp">STUDY
								GROUP</a>
						</div>
<%
}
%>
					</div>
					<button class="btn btn-primary" type="button" onclick="javascript:logout();"><i class="fa fa-sign-out" style="font-size:20px"></i></button>
				</ul>
			</div>
		</div>
	</nav>
	<div>&nbsp;</div>
	<div>&nbsp;</div>
	<div>&nbsp;</div>
	  <%@ include file="/admin/admin_nav.jsp" %>