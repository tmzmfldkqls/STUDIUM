<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- �� ���� -->

<form name = "selectForm" id = "selectForm" action = "" method = "GET">
<input type = "hidden" name = "act" value = "mvroomrsv">
<input type = "hidden" name = "spnoForRsv" value = "<%=spnoForRsv%>">

						<!-- ���ڵ�� ���� -->
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
									  				<h3 style = "display : inline"><small class = "text-primary"><strong>���� </strong></small></h3>
									  				</div>
									  				<div class="col-lg-9">
													<h3 class="text-muted" style = "display : inline ;  text-decoration: underline;"> <small><%=list.get(i).getRM_PRICE()%></small></h3>
									  				</div>
									  			</div>

									  			<div class="row">
								  					<div class="col-lg-3">
									  				<h3 style = "display : inline"><small class = "text-primary"><strong>�ִ��ο� </strong></small></h3>
									  				</div>
									  				<div class="col-lg-9">
													<h3 class="text-muted" style = "display : inline ;  text-decoration: underline;"> <small><%=list.get(i).getRM_MAX_PERSON()%></small></h3>
									  				</div>
									  			</div>
									  			
									  			<div class="row">
								  					<div class="col-lg-3">
									  				<h3 style = "display : inline"><small class = "text-primary"><strong>�����ð�</strong></small></h3>
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
									  				<h3 style = "display : inline"><small class = "text-primary"><strong>���ǽü� </strong></small></h3>
									  				</div>
									  				<div class="col-lg-9">
														<h3 class="text-muted" style = "display : inline ">
															<div class="row" >
																	<div class="col-lg-6">
																		<i class="fa" style="font-size:23px " onclick="javascript: make_disabled();">������ &#xf2dc; </i>
																	</div>
																	
																	<div class="col-lg-6">
																		<i class="fa" style="font-size:23px">������ &#xf0f4;</i>
																	</div>
															</div>
															
															<div class="row">
																<div class="col-lg-6">
																	<i class="fa" style="font-size:23px">����/�μ�� &#xf02f; </i>
																</div>
																<div class="col-lg-6">
																	<i class="fa" style="font-size:23px">�ѽ� &#xf1ac;</i>
																</div>
															</div>
														
															<div class="row">
																<div class="col-lg-6">
																	<i class="material-icons" style="font-size:23px">�ֹ� &#xeb47;</i>
																</div>
																<div class="col-lg-6">
																	<i class="fa" style="font-size:23px">����� &#xf2c7;</i>
																</div>
															</div>
															
															<div class="row">
																<div class="col-lg-6">
																	<i class="fa" style="font-size:23px">���߹��� &#xf073; </i>
																</div>
																<div class="col-lg-6">
																	<i class="material-icons" style="font-size:23px">���� &#xe54f;</i>
																</div>
															</div>											
															
															<div class="row">
																<div class="col-lg-6">
																	<i class="fa" style="font-size:23px">���η�Ŀ &#xf023;</i>
																</div>
																<div class="col-lg-6">
																	<i class="fa" style="font-size:23px">�����ü� &#xf2cd;</i>
																</div>
															</div>
															
															<div class="row">
																<div class="col-lg-6">
																	<i class="material-icons" style="font-size:23px">ȭ��Ʈ����&#xf109;</i>
																</div>
																<div class="col-lg-6">
																	<i class="fa" style="font-size:23px">��������  &#xf1eb;</i>
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

							<!-- ��� ���� �� �� �Ʒ� �� ����� �� -->		
						<br>
						<br>
						<div class="form-group">
      						<label for="using_time"><h3><small><strong>��� �ð�</strong></h3></label>
     						<select class="form-control form-control-lg" id ="using_time" name = "using_time" style="width:100%" onchange="javascript:timeSelect();">
							    <%
							    	int v = 0 ;
							    	while(v++ != 48){
							    		if(v%2 != 0){ 			
							    %>
							   			 <option value="<%=v%>" ><%=v*30/60%>�ð�<%=v*30%60%>��</option>	 
								<%
																		
							    		}else{
								%>
										<option value="<%=v%>"><%=v*30/60%>�ð�</option>
								<% 
							    		}
							    	}
							    %>
							</select>
    					</div>
								
						</div>

						<!-- ���ڵ�� �� -->
						<hr>
						<br>
						<div style="text-align : right ; display : inline" id = total_price>									
						</div>
						<br>
						<br>
						<div align="center">					
									<input type="button" class="btn btn-primary btn-lg btn-block"  value="�����Ϸ� ����" onclick="javascript:moveReservation();" />				
						</div>
					</form>
				<!-- �� �� -->