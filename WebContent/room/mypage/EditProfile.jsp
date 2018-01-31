<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.st.member.model.MemberDto"%>
    
<%@ include file="/common/header.jsp"%>

<head>
<script>

function updatePf() {

		if(document.getElementById("password").value == ""){
			alert("패스워드를 입력하세요");
			return;
		}else if(document.getElementById("passwordck").value == ""){
			alert("중복체크를 진행해주세요");
			return;
		}else if(document.getElementById("email").value == ""){
			alert("이메일을 입력하세요");
			return;
		}else{
			document.profileEdit.action = "<%= root %>/mypage";
			document.profileEdit.submit();
		}
	}
</script>
</head>
<body>
	<div class="py-5" style="background-image: url(&quot;<%=root%>/img/background.jpg&quot;);">

		<div class="container" style="margin-top : 5%">
			<div class="row">
				<div class="col-md-12" id="book">
					<div class="card">
						<div class="card-body p-5">
							<h3 class="pb-3" align="center">
								<b style = "margin-bottom : 5%"><%=memberDto.getM_ID()%> 님</b> <br> <small>프로필 수정이 필요하신가요?</small>
							</h3>
							
							<form method="post" id = "profileEdit" name="profileEdit" action="">
							
							<input type="hidden" name="act" value="edit">
								<hr>
								<div class="form-group">
									<label for="password"><h5><strong>PASSWORD</strong></h5></label>
									<input type="text" class="form-control" id="password" name="password" value="<%=memberDto.getM_PASS()%>">
								</div>
								
								<div class="form-group">
									<label for="passwordck"><h5><strong>PASSWORD CHECK</strong></h5></label>
									<input type="text" class="form-control" id="passwordck" name="passwordck" placeholder="check again">
								</div>
								
								<div class="form-group">
									<label for="email"><h5><strong>NAME</strong></h5></label>
									<input type="text" class="form-control" id="name" name="name" value="<%=memberDto.getM_NAME()%>">
								</div>
								
								<div class="form-group">
									<label for="email"><h5><strong>E-MAIL</strong></h5></label>
									<input type="text" class="form-control" id="email" name="email" value="<%=memberDto.getM_EMAIL()%>">
								</div>

								<div class="form-group">
							      <label for="tag"><h5><strong>HashTag</strong></h5></label>
							      <input type="text" class="form-control" id="tag" name = "tag"aria-describedby="Help" value="<%=memberDto.getM_TAG()%>">
							      <small id="Help" class="form-text text-muted">관심있는 분야를 enter 하세요</small>
							    </div>
															
								<hr />
								<div class = "row">
									<div class = "col">
										<button type="button" class="btn btn-danger btn-lg btn-block"  onclick="javascript:updatePrfl();">탈퇴</button>
									</div>
									<div class = "col">
										<button type="button" class="btn btn-primary btn-lg btn-block" onclick="javascript:updatePf();">수정</button>														
									</div>
								</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	
<%@ include file="/common/footer.jsp"%>