<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="java.util.List,com.st.studyroom.model.StudyRoomDto,java.util.ArrayList"%>
<%@ include file="/common/header.jsp"%>
<script type="text/javascript" src="<%=root%>/js/httpRequest.js"></script>
<script type="text/javascript">
function register_img(){
		//유효성검사
		if(document.getElementById("sp_img").value == "") {
			alert("대표 이미지를 입력해주세요");
			return;
		}else if(document.getElementById("detail_img1").value == "") {
			alert("상세 이미지는 반드시 하나 이상 입력해주세요");
			return;
		}else if(document.getElementById("detail_img1") == null) {
			alert("상세 이미지는 반드시 하나 이상 입력해주세요");
			return;
		}else{
			document.sp_registerform.action = "<%=root%>/register";
			document.sp_registerform.submit();
		}
	}	
	var idx_picture = 0;
	//사진 등록해서 추가할 것
	function appendItem() {
		
		idx_picture++;
		var itemdiv = document.createElement("div");//<div></div>
		itemdiv.setAttribute("id", "detail_img_div" + idx_picture);//<div id="i1"></div>
		itemdiv.setAttribute("name", "detail_img_name");
		itemdiv.setAttribute("style", "margin-bottom:2%;");
		
		var rowdiv = document.createElement("div");
		rowdiv.setAttribute("class", "row");
		var col1div = document.createElement("div");
		col1div.setAttribute("class", "col-lg-11");
		var col2div = document.createElement("div");
		col2div.setAttribute("class", "col-lg-1");
	
		rowdiv.appendChild(col1div);
		rowdiv.appendChild(col2div);
	
		
		var ainput = document.createElement("input");//<input></input>
		ainput.setAttribute("name", "detail_img" + idx_picture);
		ainput.setAttribute("id", "detail_img" + idx_picture);
		ainput.setAttribute("type", "file");
		ainput.setAttribute("class", "form-control");
		ainput.setAttribute("maxlength", "150");

		var rbtn = document.createElement("input");
		rbtn.setAttribute("type", "button");
		rbtn.setAttribute("value", "삭제");
		rbtn.setAttribute("onclick", "javascript:removeItem('" + idx_picture + "');");
		rbtn.setAttribute("class", "btn btn-danger");

		col1div.appendChild(ainput);
		col2div.appendChild(rbtn);
		
		itemdiv.appendChild(rowdiv);

		var answerdiv = document.getElementById("answerdiv");
		answerdiv.appendChild(itemdiv);
	}

	function removeItem(idx_picture) {
		alert(idx_picture);
		var answerdiv = document.getElementById("answerdiv");
		answerdiv.removeChild(document.getElementById("detail_img_div" + idx_picture));
	}
</script>
		<div class="container" style="margin-top : 5%">
			<div class="row">
				<div class="col-md-12">
							<h1 align="center">
								<b>스터디룸 등록</b> <br> <small>이미지를 입력해주세요</small>
							</h1>
<!---------------------------------------------------------여기서부터 폼 시작 -------------------------------------------->
<!---------------------------------------------------------여기서부터 폼 시작 --------------------------------------------->
<!---------------------------------------------------------여기서부터 폼 시작 --------------------------------------------->
<!---------------------------------------------------------여기서부터 폼 시작 --------------------------------------------->
<!---------------------------------------------------------여기서부터 폼 시작 --------------------------------------------->

<form method="post" name="sp_registerform" action="" enctype="multipart/form-data"><!-- enctype="multipart/form-data" 생략 -->
<input type = "hidden" name = "act" value = "roomrgst">
								<div align="right" style="color: red">대표이미지와 상세이미지는 반드시 하나 이상 등록해주세요!</div>
								<hr>
								
								<div class="form-group">
									<label for="sp_img" class="font-weight-bold">대표이미지</label>
									<input type="file" class="form-control" id="sp_img" name="sp_img">
								</div>

								<div class="form-group">
									<div class="row">
										<div class="col-lg-11" style = "margin-bottom : 2%">
											<label for="i_path" class="font-weight-bold">상세이미지<small>(상세 이미지는 최대 15개까지 가능합니다)</small></label>
										</div>
										<div class="col-lg-1">
												<input type="button" class="btn btn-primary" value="추가" onclick="javascript:appendItem();">
										</div>	
									</div>
									
									<div class="row">
										<div id="answerdiv" class="col-lg-12"></div>		
									</div>

								</div>					 
						
								<hr />
								<div align="center" style = "margin-bottom : 4%">
									<input type="button" class="btn btn-secondary" value="취소" />
									<input type="button" class="btn btn-primary" value="저장" onclick="javascript:register_img();" />
									
								</div>		
</form>
<!---------------------------------------------------------여기까지 폼 종료 --------------answerdiv 에서 사진 받는걸론------------------------------>

							</div>
						</div>
					</div>
<%@ include file="/common/footer.jsp"%>