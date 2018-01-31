<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@ include file="/common/header.jsp"%>

<script>
	function openzip(){
		;
	}
	function register(){
		;
	}
	function indivisualRgst(){
		
		;
	}
	function add_rtag(){
		
		;
	}
	var count = 0;
	
	function addForm(){
		  var addedFormDiv = document.getElementById("addedFormDiv");
	      
	      var str = "";
	      str+="<br>값1-"+count+" <input type='text' name='tb1_"+count+"'>";

	      // 추가할 폼(에 들어갈 HTML)  
	      var addedDiv = document.createElement("div"); // 폼 생성
	      addedDiv.id = "added_"+count; // 폼 Div에 ID 부여 (삭제를 위해)
	      addedDiv.innerHTML  = str; // 폼 Div안에 HTML삽입
	      addedFormDiv.appendChild(addedDiv); // 삽입할 DIV에 생성한 폼 삽입

	      count++;
	      document.r_registerform.count.value=count;
	      // 다음 페이지에 몇개의 폼을 넘기는지 전달하기 위해 히든 폼에 카운트 저장
	  }	 
	  function delForm(){
		  alert('del');
	            var addedFormDiv = document.getElementById("addedFormDiv");
	 				
	            if(count >1){ // 현재 폼이 두개 이상이면
	                       var addedDiv = document.getElementById("added_"+(--count));
	                       // 마지막으로 생성된 폼의 ID를 통해 Div객체를 가져옴
	                       addedFormDiv.removeChild(addedDiv); // 폼 삭제 
	            }else{ // 마지막 폼만 남아있다면
	                       document.r_registerform.reset(); // 폼 내용 삭제
	            }
	  }
</script>
	<div class="py-5" style="background-image: url(&quot;./re.jpg&quot;);">

		<div class="container"  style = "margin-top:45px;">
			<div class="row">
				<div class="col-md-12" id="book">
					<div class="card">
						<div class="card-body p-5">
							<h3 class="pb-3" align="center">
								<b>스터디룸 등록</b> <br> <small>기본 정보를 입력해 주세요</small>
							</h3>

							<form method="post" name="r_registerform" action="">
							
								<div align="right" style="color: red">*는 필수항목입니다</div>
								<hr>
								<div class="form-group">
									<label for="rname">장소명</label><span style="color: red">*</span>
									<input type="text" class="form-control" id="rname" name="rname" placeholder="공간 이름을 입력하세요">
								</div>

								<div class="form-group">
									<label for="rweb">웹페이지</label>
									<div class="row">
										<div class="col-lg-9">
											<input type="text" class="form-control" id="rweb" name="rweb" placeholder="웹페이지 url을 입력하세요" style="margin-right: 5px; width: 750 px">
										</div>

										<div class="col-lg-3">
											<label class="form-check-label"></label>
											<input type="checkbox" class="form-check-input" value=""><small>Stadium 예약시스템을 이용합니다</small>
										</div>
									</div>
								</div>

								<div class="form-group">
									<label for="rsubti">한줄 소개</label><span style="color: red">*</span>
									<input type="text" class="form-control" id="rsubti" name="rsubti" placeholder="공간을 한 줄로 소개해 주세요">
								</div>

								<div class="form-group">
									<label for="rdesc">소개</label>
									<textarea class="form-control" rows="5" id="rdesc" name="rdesc"></textarea>
								</div>

								<div class="form-group">
									<label for="addr2">위치</label><span style="color: red">*</span>
									<div class="row">
										<div class="col-lg-9">
										<input type="text" class="form-control" id="addr1" name="addr1" placeholder="주소검색" style="margin-right: 5px; margin-bottom: 5px" class="form-control" readonly="readonly" /> 
										</div>
										<div class="col-lg-3">
										<input type="button" class="btn btn-warning" value="검색" onclick="javascript:openzip();" />
										</div>
									</div>
									<input type="text" class="form-control" id="addr2" name="addr2" placeholder="상세주소 입력">
								</div>
								<div class="form-group">
									<label for="email">대표이미지</label><span style="color: red">*</span>
									<input type="file" class="form-control" id="rimg" name="rimg">
								</div>

								<div class="form-group">
									<label for="email">상세이미지<small>(상세이미지는 최대 n개까지가능합니다)</small></label>
									<input type="file" class="form-control" value="" name="upload[]" multiple>
								</div>

								
								<div class="form-group">								
									<label for="rTagInput">공간태그 <small>최대 5개</small></label><span style="color: red">*</span>
									<div class="row">
										<div class="col-lg-9">
											<input type="text" name="rTagInput" id="rTagInput" maxLength="10" placeholder="ex.#24시간 #스낵바 #구디역_3번출구" class="form-control" style = "margin-bottom : 5px">
										</div>
										<div class="col-lg-3">
											<input type="button" class="btn btn-warning" value="추가" onclick="javascript:add_rtag();"/>
										</div>	
									</div>	
									<div class="row">
										<div class="col-lg-9">
										<input type="text" name="rTagprint" id="rTagprint" maxLength="10" placeholder="#24시간 #스낵바 #구디역_3번출구" class="form-control" readonly = "readonly">
										</div>
									</div>
								</div>
								 
								<div class="form-group">
									<h5 class="pb-3">
										<b>내부 공간 상세 등록</b><br>
									</h5>
									<div class="form-inline">
										<div class="row">
											<div class="col-lg-2">
												<label for="indivisual_r_num">이름</label><span style="color: red">*</span>
											</div> 
											<div class="col-lg-8">
											<input type="hidden" name="count" value="0">
												<div id="addedFormDiv">
												<input type="text" class="form-control" id="indivisual_r_name" name="indivisual_r_name" placeholder="내부공간 이름을 입력해주세요" style="margin-right: 5px">
												</div><BR>
											</div> 
											<div class="col-lg-2">
												<input type="button" class="btn btn-warning" value="상세등록" onclick="javascript:addForm();" data-toggle="modal" data-target="#myModal" />
											</div>
										</div>
									</div>
								</div>
								
								<hr />
								<div align="center">
									<input type="button" class="btn btn-primary btn-lg btn-block"  value="수정하기" onclick="javascript:register();" />
										
									</div>
									
						           <input type="Button" value="삭제" onclick="javascript:delForm();"/>
						           <input type="Submit" value="완료">
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- The Modal -->
		  <div class="modal fade" id="myModal">
		    <div class="modal-dialog modal-lg">
		      <div class="modal-content">
		      
		        <!-- Modal Header -->
		        <div class="modal-header">
		          <h4 class="modal-title">방 상세 정보 등록</h4>
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		        </div>
		        
		        <!-- Modal body -->
		        <div class="modal-body">
		        <form method="post" name="r_registerform" action="">
		          <div class="form-group">
									<label for="srname">장소명</label><span style="color: red">*</span>
									<input type="text" class="form-control" id="srname" name="srname" placeholder="내부 공간 명을 입력하세요">
				  </div>
			  
				 	 <div align="center">
									<input type="button" class="btn" value="취소" onclick="javascript:register();" />

					</div>					
				  </form>				
						
		        </div>
		        
		        <!-- Modal footer -->
		        <div class="modal-footer">
		          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		        </div>
		      </div>
		    </div>
		  </div>
<%@ include file="/common/footer.jsp"%>