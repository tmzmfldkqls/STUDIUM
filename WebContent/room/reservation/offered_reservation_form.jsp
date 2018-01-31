<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- 폼 시작 -->

<form name = "selectForm" id = "selectForm" action = "" method = "GET">
<input type = "hidden" name = "act" value = "mvroomrsv">
<input type = "hidden" name = "spnoForRsv" value = "<%=spnoForRsv%>">

						<!-- 아코디언 시작 -->
						<div id="accordion">	
						<%
							for(int i=0;i<list.size();i++){
						%>				
								<div class="card">
									<div class="card-header" onclick = "javascript:roomSelect('<%=list.get(i).getRM_PRICE()%>')">
										<label for="<%=list.get(i).getRM_NO()%>">			
										<input type='radio'name='selectedRoom' id = "<%=list.get(i).getRM_NO()%>" value="<%=list.get(i).getRM_NO()%>"> 										
										<a class="card-link" data-toggle="collapse" data-parent="#accordion" href="#<%=list.get(i).getRM_NO()*2%>">  
											<%=list.get(i).getRM_NAME()%>
										</a>
										</label>
									
									</div>				
									<div id="<%=list.get(i).getRM_NO()*2%>" class="collapse">
										<div class="card-body">

								  				<div class="row">
								  					<div class="col-lg-3">
									  				<h3 style = "display : inline"><small class = "text-primary"><strong>가격 </strong></small></h3>
									  				</div>
									  				<div class="col-lg-9">
													<h3 class="text-muted" style = "display : inline ;  text-decoration: underline;"> <small><%=list.get(i).getRM_PRICE()%></small></h3>
									  				</div>
									  			</div>

									  			<div class="row">
								  					<div class="col-lg-3">
									  				<h3 style = "display : inline"><small class = "text-primary"><strong>최대인원 </strong></small></h3>
									  				</div>
									  				<div class="col-lg-9">
													<h3 class="text-muted" style = "display : inline ;  text-decoration: underline;"> <small><%=list.get(i).getRM_MAX_PERSON()%></small></h3>
									  				</div>
									  			</div>
									  			
									  			<div class="row">
								  					<div class="col-lg-3">
									  				<h3 style = "display : inline"><small class = "text-primary"><strong>단위시간</strong></small></h3>
									  				</div>
									  				<div class="col-lg-9">
													<h3 class="text-muted" style = "display : inline ;  text-decoration: underline;"><small><%=list.get(i).getRM_MIN_TIME()%></small></h3>
									  				</div>
									  			</div>
									  			
									  			<div class="row">
								  					<div class="col-lg-3">
								  					 &nbsp;
								  					</div>
									  				<div class="col-lg-9">
									  				&nbsp;
									  				</div>
									  			</div>
									  			
									  			<div class="row">
								  					<div class="col-lg-3">
									  				<h3 style = "display : inline"><small class = "text-primary"><strong>편의시설 </strong></small></h3>
									  				</div>
									  				<div class="col-lg-9">
														<h3 class="text-muted" style = "display : inline ">
															<div class="row" >
																	<div class="col-lg-6">
																		<i class="fa" style="font-size:23px " onclick="javascript: make_disabled();">에어컨 &#xf2dc; </i>
																	</div>
																	
																	<div class="col-lg-6">
																		<i class="fa" style="font-size:23px">스낵바 &#xf0f4;</i>
																	</div>
															</div>
															
															<div class="row">
																<div class="col-lg-6">
																	<i class="fa" style="font-size:23px">복사/인쇄기 &#xf02f; </i>
																</div>
																<div class="col-lg-6">
																	<i class="fa" style="font-size:23px">팩스 &#xf1ac;</i>
																</div>
															</div>
														
															<div class="row">
																<div class="col-lg-6">
																	<i class="material-icons" style="font-size:23px">주방 &#xeb47;</i>
																</div>
																<div class="col-lg-6">
																	<i class="fa" style="font-size:23px">난방기 &#xf2c7;</i>
																</div>
															</div>
															
															<div class="row">
																<div class="col-lg-6">
																	<i class="fa" style="font-size:23px">연중무휴 &#xf073; </i>
																</div>
																<div class="col-lg-6">
																	<i class="material-icons" style="font-size:23px">주차 &#xe54f;</i>
																</div>
															</div>											
															
															<div class="row">
																<div class="col-lg-6">
																	<i class="fa" style="font-size:23px">개인로커 &#xf023;</i>
																</div>
																<div class="col-lg-6">
																	<i class="fa" style="font-size:23px">샤워시설 &#xf2cd;</i>
																</div>
															</div>
															
															<div class="row">
																<div class="col-lg-6">
																	<i class="material-icons" style="font-size:23px">화이트보드&#xf109;</i>
																</div>
																<div class="col-lg-6">
																	<i class="fa" style="font-size:23px">와이파이  &#xf1eb;</i>
																</div>
															</div>
														</h3>
									  				</div>
									  			</div>
										</div>
									</div>
								</div>
						<%
							}
						%>

							<!-- 기능 구현 시 이 아래 건 지우면 됨 -->		
						<br>
						<br>
						<div class="form-group">
      						<label for="using_time"><h3><small><strong>사용 시간</strong></h3></label>
     						<select class="form-control form-control-lg" id ="using_time" name = "using_time" style="width:100%" onchange="javascript:timeSelect();">
							    <%
							    	int v = 0 ;
							    	while(v++ != 48){
							    		if(v%2 != 0){ 			
							    %>
							   			 <option value="<%=v%>" ><%=v*30/60%>시간<%=v*30%60%>분</option>	 
								<%
																		
							    		}else{
								%>
										<option value="<%=v%>"><%=v*30/60%>시간</option>
								<% 
							    		}
							    	}
							    %>
							</select>
    					</div>
								
						</div>

						<!-- 아코디언 끝 -->
						<hr>
						<br>
						<div style="text-align : right ; display : inline" id = total_price>									
						</div>
						<br>
						<br>
						<div align="center">					
									<input type="button" class="btn btn-primary btn-lg btn-block"  value="예약하러 가기" onclick="javascript:moveReservation();" />				
						</div>
					</form>
				<!-- 폼 끝 -->