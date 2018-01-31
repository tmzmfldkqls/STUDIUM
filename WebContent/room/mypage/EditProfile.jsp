<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.st.member.model.MemberDto"%>
    
<%@ include file="/common/header.jsp"%>

<head>
<script>

function updatePf() {

		if(document.getElementById("password").value == ""){
			alert("�н����带 �Է��ϼ���");
			return;
		}else if(document.getElementById("passwordck").value == ""){
			alert("�ߺ�üũ�� �������ּ���");
			return;
		}else if(document.getElementById("email").value == ""){
			alert("�̸����� �Է��ϼ���");
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
								<b style = "margin-bottom : 5%"><%=memberDto.getM_ID()%> ��</b> <br> <small>������ ������ �ʿ��ϽŰ���?</small>
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
							      <small id="Help" class="form-text text-muted">�����ִ� �о߸� enter �ϼ���</small>
							    </div>
															
								<hr />
								<div class = "row">
									<div class = "col">
										<button type="button" class="btn btn-danger btn-lg btn-block"  onclick="javascript:updatePrfl();">Ż��</button>
									</div>
									<div class = "col">
										<button type="button" class="btn btn-primary btn-lg btn-block" onclick="javascript:updatePf();">����</button>														
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