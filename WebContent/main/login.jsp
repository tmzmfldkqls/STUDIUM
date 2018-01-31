<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	String root = request.getContextPath();

	String saveid="";
	String checkid="";
	
	Cookie cookie[] = request.getCookies();
	if(cookie != null) {
		int len = cookie.length;
		for(int i=0; i<len; i++) {
			saveid = cookie[i].getValue();
			checkid = " checked=\"checked\"";
			break;
		}
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="<%=root%>/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
<style type="text/css">
html, body {
	margin: 0;
	width: 100%;
	height: 100%;
}

#signuppanel {
	padding: 50px;
	display: none;
}
#idfindpanel {
	padding: 50px;
	display: none;
}
#pwdfindpanel {
	padding: 50px;
	display: none;
}
</style>
<script type="text/javascript" src="<%=root%>/js/httpRequest.js"></script>
<script type"text/javascript">
var idflag=false;
function register() {
	if(document.memberform.name.value == "") {
		alert("이름을 입력하세요!!!!");
		return;
	}else if(!idflag) {
		alert("아이디를 확인하세요!!!!");
		alert(idflag);
		return;
	}else if(document.memberform.email.value == "") {
		alert("이메일을 입력하세요!!!!");
		return;
	}else if(document.memberform.tel.value == "") {
		alert("전화번호를 입력하세요!!!!");
		return;
	}else if(document.memberform.hashtag.value == "") {
		alert("헤쉬테그를 입력하세요!!!!");
		return;
	}else if(document.memberform.joinpass.value == "") {
		alert("패스워드를 입력하세요!!!!");
		return;
	}else if(document.memberform.joinpass.value != document.memberform.pwdcheck.value) {
		alert("패스워드를 확인하세요!!!!");
		return;
	}else {
		document.memberform.action = "<%= root %>/member";
		document.memberform.submit();
	}
}
function login() {
	if(document.loginform.id.value == "") {
		alert("아이디를 확인하세요!!!!");
		return;
	}else {
		document.loginform.action = "<%= root %>/member";
		document.loginform.submit();
	}
}


function findId() {
	if(document.findidform.name.value == "") {
		alert("이름을 확인하세요!!!!");
		return;
	}else if(document.findidform.tel.value == "") {
		alert("전화번호를 확인하세요!!!!");
		return;
	}else {
		document.findidform.action = "<%= root %>/member";
		document.findidform.submit();
	}
}
function findpwd() {
	if(document.findpwdform.id.value == "") {
		alert("아이디를 확인하세요!!!!");
		return;
	}else if(document.findpwdform.email.value == "") {
		alert("이메일을 확인하세요!!!!");
		return;
	}else {
		
		document.findpwdform.action = "<%= root %>/member";
		document.findpwdform.submit();
	}
}
var idchresult;
function idcheck() {
   idchresult = document.getElementById("idchresult");
   var sid = document.getElementById("joinid").value;
   var len = sid.length;
   if(len < 4 || len > 16) {  
      idchresult.innerHTML = "<font color='gray'>아이디는 4자리이상 16자리이하입니다.";
   }else {
      var params = "act=idcheck&id=" + sid;
      sendRequest("<%= root %>/member",params,idcheckResult,"GET");
   }
}

function idcheckResult() {
   if(httpRequest.readyState == 4) {
      if(httpRequest.status == 200) {
         var txt = httpRequest.responseText;
         var result = txt.split(",");
         var idcount = parseInt(result[0]);
         var searchid = result[1];
         var resultText = "";
         if(idcount == 0) {
            idflag = true;
            resultText = "<font color='blue'><b>" + searchid + "</b></font>는 사용 가능합니다.";
         }else {
            idflag = false;
            resultText = "<font color='red'><b>" + searchid + "</b></font>는 사용 불가능합니다.";
         }      
         idchresult.innerHTML = resultText;
      }
   } 
}
	$(document).ready(function() {
		$("#signup").click(function() {
			$("#signuppanel").slideToggle("slow");
			$("#loginpanel").hide();
		});
		$("#idfind").click(function() {
			$("#idfindpanel").slideToggle("slow");
			$("#loginpanel").hide();
		});
		$("#pwdfind").click(function() {
			$("#pwdfindpanel").slideToggle("slow");
			$("#loginpanel").hide();
		});
		$("#s_closebtn").click(function() {
			$("#signuppanel").hide();
			$("#loginpanel").show();
		});
		$("#if_closebtn").click(function() {
			$("#idfindpanel").hide();
			$("#loginpanel").show();
		});
		$("#pf_closebtn").click(function() {
			$("#pwdfindpanel").hide();
			$("#loginpanel").show();
		});
	});

$(document).ready(function(){
	$("#myModal").modal('show');
	$('#myModal').modal({
		backdrop: 'static'
	});
});

</script>
</head>
<body>
	<div class="h-100 w-100"
		style="background-image: url(&quot;https://thumbs.dreamstime.com/z/time-to-study-school-tools-around-blackboard-background-46060556.jpg&quot;);">
		<div class="container mt-0">
		
				
			<center>
		
					<!-- The Modal -->
					<div class=" modal fade" id="myModal" >
						<div class="modal-dialog">
							<div id="loginpanel">
								<div class="jumbotron modal-content p-0"
									style="background-color: #e9ecef;">		
									<!-- Modal Header -->
									<div class="modal-header align-self-center">
										<center>
											<h4 class="modal-title">
												<i class="fa fa-child"></i> LOGIN
											</h4>
											<br>
											<h5>Studium에 오신걸 환영합니다.</h5>
										</center>
									</div>
									<!-- Modal body -->
									<div class=" modal-body">

										<div class="p-1">
											<form name="loginform" method="post" action="">
												<input type="hidden" id="act" name="act" value="login">
												<input type="id" class="form-control" id="loginid" name="id"
													placeholder="ID" value="<%= saveid %>"> 
												<input type="password"
													class="form-control mt-1" id="loginpass" name="pass" placeholder="password">
												<div class="form-check mt-1">
													<label class="form-check-label"> <input
														class="form-check-input" type="checkbox" id="idsv" name="idsv" value="saveid" <%= checkid %> /> 아이디 저장
													</label>
												</div>
											</form>
										</div>
										<button type="button"
												class="btn btn-secondary mr-1" onclick="javascript:login();">LOGIN</button>
										<div id="loginresult"></div>
										<ul class="mt-1 p-0">
											<a id="idfind" >Forgot ID?</a>
											<a id="pwdfind">Forgot PWD?</a>
										</ul>
										아이디가 없으신가요?<i class="fa fa-frown-o"></i><a id="signup">Signup</a>
									</div>

									<!-- Modal footer -->


								</div>
							</div>

							<div id="signuppanel">			
								<div class="jumbotron modal-content p-0"
									style="background-color: #e9ecef;">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal" id="s_closebtn">
										<i class="fa fa-close"></i>
									</button>

									<!-- Modal Header -->
									<div class="modal-header align-self-center pb-0">
										<center>
											<h4 class="modal-title">
												<i class="fa fa-user-plus"></i> SIGNUP
											</h4>
											<br>
											<h5>Studium에 오신걸 환영합니다.</h5>
										</center>
									</div>
									<!-- Modal body -->
									<div class=" modal-body pt-0">
										<div class="p-1">
											<form name= "memberform" class="mt-3" method="post" action="">
												<input type="hidden" name="act" id="act" value="memberregister">
												<input type="text" class="form-control mt-1" name="name" id="name" placeholder="이름">					
												<input type="text" class="form-control mt-1" name="id" id="joinid" placeholder="ID" onkeyup="javascript:idcheck();"> 
												<div class="mt-0" id="idchresult"></div>
												<input type="password" class="form-control mt-1" name="pass" id="joinpass" placeholder="password">
												<input type="password" class="form-control mt-1" id="pwdcheck" placeholder="check password">
												<input type="text" class="form-control mt-1" id="email"	name="email" placeholder="email">
												<input type="text" class="form-control mt-1" id="tel" name="tel" placeholder="tel">
												<input type="text" class="form-control mt-1" id="hashtag" name="hashtag" placeholder="hashtag">
											</form>
										</div>
										<button type="button" class="btn btn-secondary mt-3" onclick="javascript:register();">등록</button>
									</div>
								</div>
							</div>
							<div id="idfindpanel">
								
								<div class="jumbotron modal-content p-0"
									style="background-color: #e9ecef;">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal" id="if_closebtn">
										<i class="fa fa-close"></i>
									</button>

									<!-- Modal Header -->
									<div class="modal-header align-self-center pb-0">
										<center>
											<h4 class="modal-title">
												<i class="fa fa-unlock-alt"></i> Forgot ID?
											</h4>
											<br>
											<h5>이름하고 전화번호를 적어주세요!</h5>
										</center>
									</div>
									<!-- Modal body -->
									<div class=" modal-body pt-0">

										<div class="p-1">
											<form id="findidform" name="findidform" class="mt-3" action="">
												<input type="hidden" id="act" name="act" value="findid">
												<input type="text" class="form-control" id="name" name="name"
													placeholder="이름"><br> <input type="text"
													class="form-control mt-1" id="tel" name="tel" placeholder="tel"><br>
												
											</form>
										</div>
										<button type="button"
												class="btn btn-secondary mt-3" onclick="javascript:findId();">찾기</button>
									</div>

									<!-- Modal footer -->


								</div>
							</div>
							<div id="pwdfindpanel">
								
								<div class="jumbotron modal-content p-0"
									style="background-color: #e9ecef;">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal" id="pf_closebtn">
										<i class="fa fa-close"></i>
									</button>

									<!-- Modal Header -->
									<div class="modal-header align-self-center pb-0">
										<center>
											<h4 class="modal-title">
												<i class="fa fa-unlock-alt"></i> Forgot PWD?
											</h4>
											<br>
											<h5>아이디하고 가입하신 메일을 적어주세요!</h5>
										</center>
									</div>
									<!-- Modal body -->
									<div class=" modal-body pt-0">

										<div class="p-1">
											<form id="findpwdform" name="findpwdform" class="mt-3" action="">
												<input type="hidden" id="act" name="act" value="findpwd">
												<input type="text" class="form-control" id="id" name="id"
													placeholder="ID"><br> 
												<input type="text"
													class="form-control mt-1" id="email" name="email" placeholder="email"><br>
												
											</form>
										</div>
										<button type="button"
												class="btn btn-secondary mt-3" onclick="javascript:findpwd();">찾기</button>
									</div>

									<!-- Modal footer -->


								</div>
							</div>
						</div>
					</div>
				</center>
			</center>
		</div>

	</div>

</body>
</html>
