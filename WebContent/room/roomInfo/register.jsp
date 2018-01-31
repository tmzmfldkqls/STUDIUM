<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"
	import="java.util.List,com.st.studyroom.model.StudyRoomDto,java.util.ArrayList"%>
<%@ include file="/common/header.jsp"%>
<script type="text/javascript" src="<%=root%>/js/httpRequest.js"></script>
<script type="text/javascript">
var idx_room = 0;

	function register(){

		//유효성검사
		if(document.getElementById("sp_name").value == "") {
			alert("장소명을 입력하세요");
			return;
		}else if(document.getElementById("rm_name1").value == ""){
			alert("방 정보는 최소 하나 이상 입력하셔야 합니다");
			return;
		}else if(document.getElementById("rm_name1") == null){
			alert("방 정보는 최소 하나 이상 입력하셔야 합니다");
			return;
		}else{
			document.sp_registerform.action = "<%=root%>/studyroom";
			document.sp_registerform.submit();
		}
	}
	function createRoom(){
		if(document.getElementById("rm_name").value== ""){
			alert("모든 란을 입력해 주세요");
			return;
		}else if(document.getElementById("rm_conv").value == ""){
			alert("모든 란을 입력해 주세요");
			return;
		}else if(document.getElementById("rm_tel").value == ""){
			alert("모든 란을 입력해 주세요");
			return;
		}else if(document.getElementById("rm_caution").value == ""){
			alert("모든 란을 입력해 주세요");
			return;
		}else if(document.getElementById("rm_max_person").value == ""){
			alert("모든 란을 입력해 주세요");
			return;
		}else if(document.getElementById("rm_min_person").value == ""){
			alert("모든 란을 입력해 주세요");
			return;
		}else if(document.getElementById("rm_name").value== null){
			alert("내부공간은 반드시 하나 이상 등록해야 합니다");
			return;
		}else{
			var list = new Array;
			list[0] = document.getElementById("rm_name").value;
			list[1] = document.getElementById("rm_conv").value;
			list[2] =  document.getElementById("rm_tel").value;
			list[3] =  document.getElementById("rm_price").value;
			list[4] =  document.getElementById("rm_caution").value;
			list[5] =  document.getElementById("rm_max_person").value;
			list[6] =  document.getElementById("rm_min_person").value;
					
			sendRequest("<%=root%>/aJaxController", list, receiveResult, "POST");
		}
	}
	function receiveResult() {
		if(httpRequest.readyState == 4) {
			if(httpRequest.status == 200) {
				javascript:appendRoom();
				var txt = httpRequest.responseText;//내부공간명
				document.getElementById("rm_name" + idx_room).value = txt;
			}
		}else {
			document.getElementById("viewresult").innerHTML = "<img src=\"/ajaxtest/img/loading.gif\" width=\"50\">";
		}
	}	
//////내부 공간 받을 예정	
	function appendRoom() {
		
		idx_room++;
		var itemdiv = document.createElement("div");//<div></div>
			itemdiv.setAttribute("id", "roomdetail" + idx_room);//<div id="i1"></div>
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
			ainput.setAttribute("name", "rm_name");
			ainput.setAttribute("id", "rm_name" + idx_room);
			ainput.setAttribute("type", "text");
			ainput.setAttribute("class", "form-control");
			ainput.setAttribute("maxlength", "150");
			ainput.setAttribute("readonly", "readonly");
			
		var rbtn = document.createElement("input");
			rbtn.setAttribute("type", "button");
			rbtn.setAttribute("value", "삭제");
			rbtn.setAttribute("class", "btn btn-danger");
			rbtn.setAttribute("onclick", "javascript:removeRoom('" + idx_room + "');");
			
		
		col1div.appendChild(ainput);
		col2div.appendChild(rbtn);
		
		itemdiv.appendChild(rowdiv);
		
		var roomdiv = document.getElementById("roomdiv");//이거 갖다 넣을 장소랑 매칭 시키는 줄
		roomdiv.appendChild(itemdiv);
	}

	function removeRoom(idx_room) {
		
		var roomdiv = document.getElementById("roomdiv");//create 되었던 위치의 div명임
		roomdiv.removeChild(document.getElementById("roomdetail" + idx_room));//이 줄 하나로 내부 인풋태그가 다 지워지나?
		
	}
	function openzip() {
		window.open("<%=root%>/studyroom?act=mvzip", "zip", "width=600,height=350,top=200,left=200,location=no,status=no,titlebar=no,toolbar=no,resizable=no,scrollbars=yes");
	}
</script>
	<div class="container" style="margin-top: 5%">
	<div class="row" style="margin-bottom: 2%">
		<div class="col-12" align=center>
			<h1 align="center">
				<strong>스터디룸 등록</strong><br>
				<small>기본 정보를 입력해 주세요</small>
			</h1>
			
		</div>
	</div>

	<div class="row">
			<div class="col-md-12" id="book">		
						<!---------------------------------------------------------여기서부터 폼 시작 -------------------------------------------->
						<!---------------------------------------------------------여기서부터 폼 시작 --------------------------------------------->
						<!---------------------------------------------------------여기서부터 폼 시작 --------------------------------------------->
						<!---------------------------------------------------------여기서부터 폼 시작 --------------------------------------------->
						<!---------------------------------------------------------여기서부터 폼 시작 --------------------------------------------->

				<table class="table" width="100%">
					<thead class="thead-dark">
						<tr>
							<th width="100%" align="center"></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								<form method="post" name="sp_registerform" action="">
									<!-- enctype="multipart/form-data" 생략 -->
									<input type="hidden" name="act" value="roomrgst"> <input
										type="hidden" id="si" name="si" value=""> <input
										type="hidden" id="gugun" name="gugun" value=""> <input
										type="hidden" id="dong" name="dong" value=""> <input
										type="hidden" id="bunji" name="bunji" value=""> <input
										type="hidden" id="geo" name="geo" value="">

									<h5 style="margin-bottom: 3%;" class="font-weight-bold">
										공간 등록<br>
									</h5>

									<div class="form-group">
										<label for="sp_name" class="font-weight-bold">장소명</label><span
											style="color: red">*</span> <input type="text"
											class="form-control" id="sp_name" name="sp_name"
											placeholder="공간 이름을 입력하세요">
									</div>

									<div class="form-group">
										<label for="sp_web" class="font-weight-bold">웹페이지</label> <input
											type="text" class="form-control" id="sp_web" name="sp_web"
											placeholder="웹페이지 url을 입력하세요"
											style="margin-right: 5px; width: 750 px">
										<div style="text-align: right;">
											<label class="form-check-label"></label> <input
												type="checkbox" class="form-check-input" id="sp_flag"
												name="sp_flag" checked><small>Stadium 예약시스템을
												이용합니다</small>
										</div>
									</div>

									<div class="form-group">
										<label for="sp_scontent" class="font-weight-bold">한줄
											소개</label><span style="color: red">*</span> <input type="text"
											class="form-control" id="sp_scontent" name="sp_scontent"
											placeholder="공간을 한 줄로 소개해 주세요">
									</div>

									<div class="form-group">
										<label for="sp_content" class="font-weight-bold">소개</label>
										<textarea class="form-control" rows="5" id="sp_content"
											name="sp_content"></textarea>
									</div>

									<div class="form-group">
										<label for="addr" class="font-weight-bold">위치</label><span style="color: red">*</span>
										<div class="row">
											<div class="col-lg-11">
												<input type="text" class="form-control" id="addr1"
													name="addr1" placeholder="주소검색"
													style="margin-right: 5px; margin-bottom: 5px"
													class="form-control" readonly="readonly" />
											</div>

											<div class="col-lg-1">
												<input type="button" class="btn btn-primary" value="검색"
													onclick="javascript:openzip();" />
											</div>
										</div>
										<input type="text" class="form-control" id="addr2"
											name="addr2" placeholder="상세주소 입력">
									</div>

									<div class="form-group">
										<label for="sp_tag" class="font-weight-bold">공간태그 <small>최대
												5개</small></label><span style="color: red">*</span>
										<div class="row">
											<div class="col-lg-9">
												<input type="text" name="sp_tag" id="sp_tag" maxLength="45"
													placeholder="ex.#24시간 #스낵바 #구디역_3번출구" class="form-control"
													style="margin-bottom: 5px">
											</div>
										</div>
									</div>
									<div class="form-group " style="margin-top: 5%;">
										<div style="display: inline-block;margin-bottom: 3%">
											<h5 style="margin-bottom: 3%;">
												<b>내부 공간 등록</b> 
												<input type="button" class="btn btn-primary" value="상세등록" data-toggle="modal" data-target="#myModal" />
											</h5>
										</div>
										<!-- ---------------------------------------------------------------------------------- -->
										<div class="row">
											<div class="col-lg-12">
												<div id="roomdiv"></div>
											</div>
										</div>
										<!-- --------------------------------------------------------------------------------------- -->
											<div align="center">
												<a href="<%=root%>/main/main.jsp"><input type="button"
													class="btn btn-secondary" value="취소" /></a> <input
													type="button" class="btn btn-primary" value="저장"
													onclick="javascript:register();" />
	
											</div>
									</div>
								</form>

							</td>
						</tr>
					</tbody>
				</table>


				<!---------------------------------------------------------여기까지 폼 종료 --------------answerdiv 에서 사진 받는걸론------------------------------>
						<!---------------------------------------------------------여기까지 폼 종료 --------------------------------------------->
						<!---------------------------------------------------------여기까지 폼 종료 --------------------------------------------->
						<!---------------------------------------------------------여기까지 폼 종료 --------------------------------------------->
						<!---------------------------------------------------------여기까지 폼 종료 --------------------------------------------->

					</div>
				</div>
			</div>
<!---------------------------------------------------------여기서부터 모달 --------------------------------------------->
<!---------------------------------------------------------여기서부터 모달--------------------------------------------->
<!-- The Modal -->
<div class="modal fade" id="myModal">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">방 상세 정보 등록</h4>

			</div>

			<!-- Modal body -->
			<div class="modal-body">

				<form method="post" name="rm_detailForm" action="">
					<input type="hidden" name="act" value="rgstDetail">
					<div class="form-group">


						<label for="rm_name" class="font-weight-bold">내부공간 이름</label><span style="color: red">*</span> 
						<input type="text" class="form-control" id="rm_name" name="rm_name" placeholder="이름을 입력해주세요"> 
						
						<label for="rm_conv" class="font-weight-bold"> 편의시설</label><span style="color: red">*</span>
						<input type="text" class="form-control" id="rm_conv" name="rm_conv" placeholder="구비되어 있는 물품을 클릭하세요"> 
						
						<label for="rm_tel" class="font-weight-bold">전화번호</label><span style="color: red">*</span> 
						<input type="number" class="form-control" id="rm_tel" name="rm_tel" placeholder="대표전화">

						<label for="rm_price" class="font-weight-bold">가격</label>
						<span style="color: red">*</span> 
						<input type="number" class="form-control" id="rm_price" name="rm_price" placeholder="가격/시간"> 
						
						<label for="rm_caution" class="font-weight-bold">주의 사항</label><span style="color: red">*</span>
						<input type="text" class="form-control" id="rm_caution" name="rm_caution" placeholder="주의사항을 입력해주세요"> 
						
						<label for="rm_max_person" class="font-weight-bold">최대수용인원</label><span style="color: red">*</span> 
						<input type="number" class="form-control" id="rm_max_person" name="rm_max_person" placeholder="최대수용인원을 선택해주세요"> 
						
						<label for="rm_min_person" class="font-weight-bold">최소수용인원</label><span style="color: red">*</span>
						<input type="number" class="form-control" id="rm_min_person" name="rm_min_person" placeholder="최소수용인원을 선택해주세요">
					</div>

					<div align="center">
						<input type="button" class="btn btn-secondary" value="취소"
							data-dismiss="modal" /> <input type="button"
							class="btn btn-primary" value="저장" data-dismiss="modal"
							onclick="javascript:createRoom(); "/>
					</div>
				</form>

			</div>
		</div>
	</div>
</div>

<%@ include file="/common/footer.jsp"%>