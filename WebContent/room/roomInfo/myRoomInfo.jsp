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
	      str+="<br>��1-"+count+" <input type='text' name='tb1_"+count+"'>";

	      // �߰��� ��(�� �� HTML)  
	      var addedDiv = document.createElement("div"); // �� ����
	      addedDiv.id = "added_"+count; // �� Div�� ID �ο� (������ ����)
	      addedDiv.innerHTML  = str; // �� Div�ȿ� HTML����
	      addedFormDiv.appendChild(addedDiv); // ������ DIV�� ������ �� ����

	      count++;
	      document.r_registerform.count.value=count;
	      // ���� �������� ��� ���� �ѱ���� �����ϱ� ���� ���� ���� ī��Ʈ ����
	  }	 
	  function delForm(){
		  alert('del');
	            var addedFormDiv = document.getElementById("addedFormDiv");
	 				
	            if(count >1){ // ���� ���� �ΰ� �̻��̸�
	                       var addedDiv = document.getElementById("added_"+(--count));
	                       // ���������� ������ ���� ID�� ���� Div��ü�� ������
	                       addedFormDiv.removeChild(addedDiv); // �� ���� 
	            }else{ // ������ ���� �����ִٸ�
	                       document.r_registerform.reset(); // �� ���� ����
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
								<b>���͵�� ���</b> <br> <small>�⺻ ������ �Է��� �ּ���</small>
							</h3>

							<form method="post" name="r_registerform" action="">
							
								<div align="right" style="color: red">*�� �ʼ��׸��Դϴ�</div>
								<hr>
								<div class="form-group">
									<label for="rname">��Ҹ�</label><span style="color: red">*</span>
									<input type="text" class="form-control" id="rname" name="rname" placeholder="���� �̸��� �Է��ϼ���">
								</div>

								<div class="form-group">
									<label for="rweb">��������</label>
									<div class="row">
										<div class="col-lg-9">
											<input type="text" class="form-control" id="rweb" name="rweb" placeholder="�������� url�� �Է��ϼ���" style="margin-right: 5px; width: 750 px">
										</div>

										<div class="col-lg-3">
											<label class="form-check-label"></label>
											<input type="checkbox" class="form-check-input" value=""><small>Stadium ����ý����� �̿��մϴ�</small>
										</div>
									</div>
								</div>

								<div class="form-group">
									<label for="rsubti">���� �Ұ�</label><span style="color: red">*</span>
									<input type="text" class="form-control" id="rsubti" name="rsubti" placeholder="������ �� �ٷ� �Ұ��� �ּ���">
								</div>

								<div class="form-group">
									<label for="rdesc">�Ұ�</label>
									<textarea class="form-control" rows="5" id="rdesc" name="rdesc"></textarea>
								</div>

								<div class="form-group">
									<label for="addr2">��ġ</label><span style="color: red">*</span>
									<div class="row">
										<div class="col-lg-9">
										<input type="text" class="form-control" id="addr1" name="addr1" placeholder="�ּҰ˻�" style="margin-right: 5px; margin-bottom: 5px" class="form-control" readonly="readonly" /> 
										</div>
										<div class="col-lg-3">
										<input type="button" class="btn btn-warning" value="�˻�" onclick="javascript:openzip();" />
										</div>
									</div>
									<input type="text" class="form-control" id="addr2" name="addr2" placeholder="���ּ� �Է�">
								</div>
								<div class="form-group">
									<label for="email">��ǥ�̹���</label><span style="color: red">*</span>
									<input type="file" class="form-control" id="rimg" name="rimg">
								</div>

								<div class="form-group">
									<label for="email">���̹���<small>(���̹����� �ִ� n�����������մϴ�)</small></label>
									<input type="file" class="form-control" value="" name="upload[]" multiple>
								</div>

								
								<div class="form-group">								
									<label for="rTagInput">�����±� <small>�ִ� 5��</small></label><span style="color: red">*</span>
									<div class="row">
										<div class="col-lg-9">
											<input type="text" name="rTagInput" id="rTagInput" maxLength="10" placeholder="ex.#24�ð� #������ #����_3���ⱸ" class="form-control" style = "margin-bottom : 5px">
										</div>
										<div class="col-lg-3">
											<input type="button" class="btn btn-warning" value="�߰�" onclick="javascript:add_rtag();"/>
										</div>	
									</div>	
									<div class="row">
										<div class="col-lg-9">
										<input type="text" name="rTagprint" id="rTagprint" maxLength="10" placeholder="#24�ð� #������ #����_3���ⱸ" class="form-control" readonly = "readonly">
										</div>
									</div>
								</div>
								 
								<div class="form-group">
									<h5 class="pb-3">
										<b>���� ���� �� ���</b><br>
									</h5>
									<div class="form-inline">
										<div class="row">
											<div class="col-lg-2">
												<label for="indivisual_r_num">�̸�</label><span style="color: red">*</span>
											</div> 
											<div class="col-lg-8">
											<input type="hidden" name="count" value="0">
												<div id="addedFormDiv">
												<input type="text" class="form-control" id="indivisual_r_name" name="indivisual_r_name" placeholder="���ΰ��� �̸��� �Է����ּ���" style="margin-right: 5px">
												</div><BR>
											</div> 
											<div class="col-lg-2">
												<input type="button" class="btn btn-warning" value="�󼼵��" onclick="javascript:addForm();" data-toggle="modal" data-target="#myModal" />
											</div>
										</div>
									</div>
								</div>
								
								<hr />
								<div align="center">
									<input type="button" class="btn btn-primary btn-lg btn-block"  value="�����ϱ�" onclick="javascript:register();" />
										
									</div>
									
						           <input type="Button" value="����" onclick="javascript:delForm();"/>
						           <input type="Submit" value="�Ϸ�">
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
		          <h4 class="modal-title">�� �� ���� ���</h4>
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		        </div>
		        
		        <!-- Modal body -->
		        <div class="modal-body">
		        <form method="post" name="r_registerform" action="">
		          <div class="form-group">
									<label for="srname">��Ҹ�</label><span style="color: red">*</span>
									<input type="text" class="form-control" id="srname" name="srname" placeholder="���� ���� ���� �Է��ϼ���">
				  </div>
			  
				 	 <div align="center">
									<input type="button" class="btn" value="���" onclick="javascript:register();" />

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