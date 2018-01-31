<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="java.util.List,com.st.studyroom.model.*,java.lang.*"%>

<%@ include file="/common/header.jsp"%>
<%
		List<StudyRoomDto> list = (List<StudyRoomDto>)request.getAttribute("picked");
		List<RmAlbDto> imgList  = (List<RmAlbDto>)request.getAttribute("pickedImg");
		int spnoForRsv = (Integer)session.getAttribute("spnoForRsv");
%> 
<script type="text/javascript" src="<%=root%>/js/httpRequest.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	var price;
	var timeValue;
	var selected_time;
	
	function moveReservation(){
		//유효성검사
		if(!$(':input:radio[name=selectedRoom]:checked').val()) {
    		alert("방이 선택되지 않았습니다.");
    		return ;
		}else{
			document.selectForm.action = "<%=root%>/studyroom";
			document.selectForm.submit();
		}
	}
	function roomSelect(selected){
	
		price = selected;	  
	    // select element에서 선택된 option의 value가 저장된다.
	    
		var params = "price=" +price + "&timeValue=" +timeValue; 	  
		sendRequest("<%=root%>/aJaxController",params, calcResult, "GET");
	}
	function timeSelect(){
		  
		  selected_time = document.getElementById("using_time");	     
		  timeValue = selected_time.options[selected_time.selectedIndex].value;//n*price의 n
		 
		  var params = "price=" +price + "&timeValue=" +timeValue; 	  
		  sendRequest("<%=root%>/aJaxController",params, calcResult, "GET");
	}
	function calcResult(){
		if(httpRequest.readyState == 4) {
			if(httpRequest.status == 200) {				
				var txt = httpRequest.responseText;//pink,이름
				var html = "<h3 style = \"display : inline\"><p class=\"text-primary\" style = \"display : inline\">&#8361</p></h3>";
					html += "<h3 align=\"center\" style = \"display : inline\"><small  align=\"center\" class=\"text-muted\">" + txt+"</small></h3><br>";
				document.getElementById("total_price").innerHTML = html;
				
			}	
		}  
	}
	function make_disabled(){
		//이프문 돌려서 디비에 해당 편의시설이 있나 없나 확인 한 후 
//		alert("호출됨");
		$(this).attr('style',' text-decoration: line-through;!important');
		}
	
function likeit(){
		
		
		
		}
</script>
 <meta name="viewport" content="width=device-width, initial-scale=1">

  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
  
<style>
  .carousel-inner img {
      width: 100%;
      height: 100%;
  }
.row { margin-bottom: 5px;
	  margin-top: 5px;
	 }
	 
.disabled {
   color: darkgrey;
   background-color: grey;
   text-decoration: line-through;
}
</style>	

<div style="margin-top: 150px">
	<div class="container" style = "margin-top: 5%;margin-bottom: 5%">
	
		<div class="row">
			<div class="col-md-6">
				<div id="detailIMG" class="carousel slide" data-ride="carousel">
					
					 <!-- Indicators -->
					  <ul class="carousel-indicators">
    					<li data-target="#detailIMG" data-slide-to="0" class="active"></li>
    				  <%
					  	for(int i=1;i<imgList.size()-1;i++){
					  %>
    					<li data-target="#detailIMG" data-slide-to="<%=i%>"></li>
    				  <%
					  	}
					  %>
  					  </ul>
  					  
					  <!-- The slideshow -->
					  <div class="carousel-inner">
					    <div class="carousel-item active">
					      <img src="<%=root%>/room/upload/<%=imgList.get(0).getSAVEFOLDER()%>/<%=imgList.get(0).getSAVE_IMG()%>" alt="사진이 없습니다"  width="1100" height="500">
					    </div>
					  <%
					  	for(int i=1;i<imgList.size()-1;i++){
					  %>
					    <div class="carousel-item">
					      <img src="<%=root%>/room/upload/<%=imgList.get(i).getSAVEFOLDER()%>/<%=imgList.get(i).getSAVE_IMG()%>" alt="사진이 없습니다"  width="1100" height="500">
					    </div>
					  <%
					  	}
					  %>
					  </div>					
						
					  <!-- Left and right controls -->
					  <a class="carousel-control-prev" href="#detailIMG" data-slide="prev">
					    <span class="carousel-control-prev-icon"></span>
					  </a>
					  <a class="carousel-control-next" href="#detailIMG" data-slide="next">
					    <span class="carousel-control-next-icon"></span>
					  </a>
						
				</div>
			</div>
			<div class="col-md-6">
				<div class="container">			
						<div >
						<h2><b><%=list.get(0).getSP_NAME()%></b><a class="btn btn-link"  href="#" onClick="likeit(); return false;">
							<i class="material-icons" style="font-size:50px; color : red" >pets</i>
						</a></h2>
						
						</div>
					<div>
			  				<h3><small><strong>Visit WebPage<br><br><p class = "text-primary"><a href="http://<%=list.get(0).getSP_WEB()%>"><%=list.get(0).getSP_WEB()%></a></p></strong></small></h3>
			  				<hr>
			  		</div>
	  				<h3><small><strong>Note:</strong> 결제는 <strong>호스트와 개별적으로</strong> 상의해주세요</p></small></h3>
	  				<br>
					<br>
	  				<!--기능구현시 룸 등록시 예약 여기서 하겠다고 했으면 offered_reservation_form.jsp 로 보내고-->
	  				<!-- 룸 등록시 예약 offered_reservation_form.jsp 로 보내고-->
	  				<!-- 룸 등록시 예약 contact_host_form.jsp 로 보내고-->
	  				<%
	  					if(list.get(0).getSP_FLAG() == 1){ 
	  				%>
  						<%@ include file="/room/reservation/offered_reservation_form.jsp"%>
  					<%
	  					}else{
	  				%>
  						<%@ include file="/room/reservation/contact_host_form.jsp"%>
  					<%
  						}
  					%>
				</div>
			</div>
			
		</div>
	</div>
</div>
<%@ include file="/common/footer.jsp"%>