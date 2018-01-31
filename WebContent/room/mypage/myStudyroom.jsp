<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.List,com.st.studyroom.model.*"%>    
    
<%@ include file="/common/header.jsp"%>
<%
	List<StudySpaceDto> list = (List<StudySpaceDto>) request.getAttribute("spacelist");
%>  
<style> 
  .carousel-inner{
      width: 100%;
      height: 100%;
  }
 </style>
 <script>
 function checkSchedule(spno){
	 
	 document.myRoom.spno.value = spno;	 
	 document.myRoom.action = "<%=root%>/mypage";
	 document.myRoom.submit();
	
 }
 </script>
<div class="container">
	<div class = "row" style = "margin-bottom: 4%" >
			<div class = "col-12" align = center></div>
	</div>
	<div class = "row" style = "margin-bottom: 4%" >
			<div class = "col-12" align = center><h3 class="display-3"><strong>Reservation</strong></h3></div>
	</div>
			<br> <br>
	<form name = "myRoom" id = "myRoom" method = "post" action = "">
			<%
				if(list.size() == 0){
					
			%>
			<div class="row" style="margin-bottom: 4%">
				<div class="col-12">
					<div class="card" width = "100%" height = "30%">
						<img class="card-img-top" src="<%=root%>/img/unable.jpg" style="width: 100%">
						<div class="card-body" align = center>
							 <h1 class="card-title" align = center><strong>조회할 수 있는 studyRoom이 없습니다</strong></h1>
						</div>
					</div>
				</div>
			</div>
			<%
				}
				else if(list.size()>1){			
					System.out.println("스터디룸 넘버는"+list.get(0).getSPNO());
			%>
				
			<%
					int k=0;
						for(int i=0;i<(list.size()/2);i++)
					{
			%>
							<div class="row" style="margin-bottom: 4%">
							<%
										for(int j=0;j<2;j++)
									{
							%>
										<div class="col-6">
											<div class="card" width="100%" height="30%">
												<img class="card-img-top" src="<%=root%>/room/upload/<%=list.get(k).getSP_IMG()%>"style="width: 100%; height: 350px">
												<div class="card-body">
													<input type="button" class="btn btn-primary btn-lg btn-block"
														value="<%=list.get(k).getSP_NAME()%> 예약 보러 가기"
														onclick="javascript:checkSchedule(<%=list.get(k++).getSPNO()%>);">
												</div>
											</div>
										</div>
			<%		
				}
			%>
					</div>	
			<%		
					}
				}else{
			%>
						<div class="row" style="margin-bottom: 4% ; text-align : center;">
						<div class="col"></div>
							<div class="col-6"  style=" display: inline-block;">
								<div class="card" height="30%">
									<img class="card-img-top"
										src="<%=root%>/room/upload/<%=list.get(0).getSP_IMG()%>"
										style="width: 100%; height: 150px">
									<div class="card-body">
										<input type="button" class="btn btn-primary btn-lg btn-block"
											value="<%=list.get(0).getSP_NAME()%> 예약 보러 가기"
											onclick="javascript:checkSchedule(<%=list.get(0).getSPNO()%>);">
									</div>
								</div>
							</div>
						<div class="col"></div>
			<%
			}
		%>
					</div>
					
			<input type="hidden" name = "spno" value="">
			<input type="hidden" name = "act" value="mvRoomSchedule">
		</form>
	</div>
	<%@ include file="/common/footer.jsp"%>