<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"
	import="java.util.List,com.st.studyroom.model.StudyRoomDto,java.util.ArrayList"%>
<%@ include file="/common/header.jsp"%>
<script type="text/javascript" src="<%=root%>/js/httpRequest.js"></script>
<script type="text/javascript">
var idx_room = 0;

	function register(){

		//��ȿ���˻�
		if(document.getElementById("sp_name").value == "") {
			alert("��Ҹ��� �Է��ϼ���");
			return;
		}else if(document.getElementById("rm_name1").value == ""){
			alert("�� ������ �ּ� �ϳ� �̻� �Է��ϼž� �մϴ�");
			return;
		}else if(document.getElementById("rm_name1") == null){
			alert("�� ������ �ּ� �ϳ� �̻� �Է��ϼž� �մϴ�");
			return;
		}else{
			document.sp_registerform.action = "<%=root%>/studyroom";
			document.sp_registerform.submit();
		}
	}
	function createRoom(){
		if(document.getElementById("rm_name").value== ""){
			alert("��� ���� �Է��� �ּ���");
			return;
		}else if(document.getElementById("rm_conv").value == ""){
			alert("��� ���� �Է��� �ּ���");
			return;
		}else if(document.getElementById("rm_tel").value == ""){
			alert("��� ���� �Է��� �ּ���");
			return;
		}else if(document.getElementById("rm_caution").value == ""){
			alert("��� ���� �Է��� �ּ���");
			return;
		}else if(document.getElementById("rm_max_person").value == ""){
			alert("��� ���� �Է��� �ּ���");
			return;
		}else if(document.getElementById("rm_min_person").value == ""){
			alert("��� ���� �Է��� �ּ���");
			return;
		}else if(document.getElementById("rm_name").value== null){
			alert("���ΰ����� �ݵ�� �ϳ� �̻� ����ؾ� �մϴ�");
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
				var txt = httpRequest.responseText;//���ΰ�����
				document.getElementById("rm_name" + idx_room).value = txt;
			}
		}else {
			document.getElementById("viewresult").innerHTML = "<img src=\"/ajaxtest/img/loading.gif\" width=\"50\">";
		}
	}	
//////���� ���� ���� ����	
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
			rbtn.setAttribute("value", "����");
			rbtn.setAttribute("class", "btn btn-danger");
			rbtn.setAttribute("onclick", "javascript:removeRoom('" + idx_room + "');");
			
		
		col1div.appendChild(ainput);
		col2div.appendChild(rbtn);
		
		itemdiv.appendChild(rowdiv);
		
		var roomdiv = document.getElementById("roomdiv");//�̰� ���� ���� ��Ҷ� ��Ī ��Ű�� ��
		roomdiv.appendChild(itemdiv);
	}

	function removeRoom(idx_room) {
		
		var roomdiv = document.getElementById("roomdiv");//create �Ǿ��� ��ġ�� div����
		roomdiv.removeChild(document.getElementById("roomdetail" + idx_room));//�� �� �ϳ��� ���� ��ǲ�±װ� �� ��������?
		
	}
	function openzip() {
		window.open("<%=root%>/studyroom?act=mvzip", "zip", "width=600,height=350,top=200,left=200,location=no,status=no,titlebar=no,toolbar=no,resizable=no,scrollbars=yes");
	}
</script>
	<div class="container" style="margin-top: 5%">
	<div class="row" style="margin-bottom: 2%">
		<div class="col-12" align=center>
			<h1 align="center">
				<strong>���͵�� ���</strong><br>
				<small>�⺻ ������ �Է��� �ּ���</small>
			</h1>
			
		</div>
	</div>

	<div class="row">
			<div class="col-md-12" id="book">		
						<!---------------------------------------------------------���⼭���� �� ���� -------------------------------------------->
						<!---------------------------------------------------------���⼭���� �� ���� --------------------------------------------->
						<!---------------------------------------------------------���⼭���� �� ���� --------------------------------------------->
						<!---------------------------------------------------------���⼭���� �� ���� --------------------------------------------->
						<!---------------------------------------------------------���⼭���� �� ���� --------------------------------------------->

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
									<!-- enctype="multipart/form-data" ���� -->
									<input type="hidden" name="act" value="roomrgst"> <input
										type="hidden" id="si" name="si" value=""> <input
										type="hidden" id="gugun" name="gugun" value=""> <input
										type="hidden" id="dong" name="dong" value=""> <input
										type="hidden" id="bunji" name="bunji" value=""> <input
										type="hidden" id="geo" name="geo" value="">

									<h5 style="margin-bottom: 3%;" class="font-weight-bold">
										���� ���<br>
									</h5>

									<div class="form-group">
										<label for="sp_name" class="font-weight-bold">��Ҹ�</label><span
											style="color: red">*</span> <input type="text"
											class="form-control" id="sp_name" name="sp_name"
											placeholder="���� �̸��� �Է��ϼ���">
									</div>

									<div class="form-group">
										<label for="sp_web" class="font-weight-bold">��������</label> <input
											type="text" class="form-control" id="sp_web" name="sp_web"
											placeholder="�������� url�� �Է��ϼ���"
											style="margin-right: 5px; width: 750 px">
										<div style="text-align: right;">
											<label class="form-check-label"></label> <input
												type="checkbox" class="form-check-input" id="sp_flag"
												name="sp_flag" checked><small>Stadium ����ý�����
												�̿��մϴ�</small>
										</div>
									</div>

									<div class="form-group">
										<label for="sp_scontent" class="font-weight-bold">����
											�Ұ�</label><span style="color: red">*</span> <input type="text"
											class="form-control" id="sp_scontent" name="sp_scontent"
											placeholder="������ �� �ٷ� �Ұ��� �ּ���">
									</div>

									<div class="form-group">
										<label for="sp_content" class="font-weight-bold">�Ұ�</label>
										<textarea class="form-control" rows="5" id="sp_content"
											name="sp_content"></textarea>
									</div>

									<div class="form-group">
										<label for="addr" class="font-weight-bold">��ġ</label><span style="color: red">*</span>
										<div class="row">
											<div class="col-lg-11">
												<input type="text" class="form-control" id="addr1"
													name="addr1" placeholder="�ּҰ˻�"
													style="margin-right: 5px; margin-bottom: 5px"
													class="form-control" readonly="readonly" />
											</div>

											<div class="col-lg-1">
												<input type="button" class="btn btn-primary" value="�˻�"
													onclick="javascript:openzip();" />
											</div>
										</div>
										<input type="text" class="form-control" id="addr2"
											name="addr2" placeholder="���ּ� �Է�">
									</div>

									<div class="form-group">
										<label for="sp_tag" class="font-weight-bold">�����±� <small>�ִ�
												5��</small></label><span style="color: red">*</span>
										<div class="row">
											<div class="col-lg-9">
												<input type="text" name="sp_tag" id="sp_tag" maxLength="45"
													placeholder="ex.#24�ð� #������ #����_3���ⱸ" class="form-control"
													style="margin-bottom: 5px">
											</div>
										</div>
									</div>
									<div class="form-group " style="margin-top: 5%;">
										<div style="display: inline-block;margin-bottom: 3%">
											<h5 style="margin-bottom: 3%;">
												<b>���� ���� ���</b> 
												<input type="button" class="btn btn-primary" value="�󼼵��" data-toggle="modal" data-target="#myModal" />
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
													class="btn btn-secondary" value="���" /></a> <input
													type="button" class="btn btn-primary" value="����"
													onclick="javascript:register();" />
	
											</div>
									</div>
								</form>

							</td>
						</tr>
					</tbody>
				</table>


				<!---------------------------------------------------------������� �� ���� --------------answerdiv ���� ���� �޴°ɷ�------------------------------>
						<!---------------------------------------------------------������� �� ���� --------------------------------------------->
						<!---------------------------------------------------------������� �� ���� --------------------------------------------->
						<!---------------------------------------------------------������� �� ���� --------------------------------------------->
						<!---------------------------------------------------------������� �� ���� --------------------------------------------->

					</div>
				</div>
			</div>
<!---------------------------------------------------------���⼭���� ��� --------------------------------------------->
<!---------------------------------------------------------���⼭���� ���--------------------------------------------->
<!-- The Modal -->
<div class="modal fade" id="myModal">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">�� �� ���� ���</h4>

			</div>

			<!-- Modal body -->
			<div class="modal-body">

				<form method="post" name="rm_detailForm" action="">
					<input type="hidden" name="act" value="rgstDetail">
					<div class="form-group">


						<label for="rm_name" class="font-weight-bold">���ΰ��� �̸�</label><span style="color: red">*</span> 
						<input type="text" class="form-control" id="rm_name" name="rm_name" placeholder="�̸��� �Է����ּ���"> 
						
						<label for="rm_conv" class="font-weight-bold"> ���ǽü�</label><span style="color: red">*</span>
						<input type="text" class="form-control" id="rm_conv" name="rm_conv" placeholder="����Ǿ� �ִ� ��ǰ�� Ŭ���ϼ���"> 
						
						<label for="rm_tel" class="font-weight-bold">��ȭ��ȣ</label><span style="color: red">*</span> 
						<input type="number" class="form-control" id="rm_tel" name="rm_tel" placeholder="��ǥ��ȭ">

						<label for="rm_price" class="font-weight-bold">����</label>
						<span style="color: red">*</span> 
						<input type="number" class="form-control" id="rm_price" name="rm_price" placeholder="����/�ð�"> 
						
						<label for="rm_caution" class="font-weight-bold">���� ����</label><span style="color: red">*</span>
						<input type="text" class="form-control" id="rm_caution" name="rm_caution" placeholder="���ǻ����� �Է����ּ���"> 
						
						<label for="rm_max_person" class="font-weight-bold">�ִ�����ο�</label><span style="color: red">*</span> 
						<input type="number" class="form-control" id="rm_max_person" name="rm_max_person" placeholder="�ִ�����ο��� �������ּ���"> 
						
						<label for="rm_min_person" class="font-weight-bold">�ּҼ����ο�</label><span style="color: red">*</span>
						<input type="number" class="form-control" id="rm_min_person" name="rm_min_person" placeholder="�ּҼ����ο��� �������ּ���">
					</div>

					<div align="center">
						<input type="button" class="btn btn-secondary" value="���"
							data-dismiss="modal" /> <input type="button"
							class="btn btn-primary" value="����" data-dismiss="modal"
							onclick="javascript:createRoom(); "/>
					</div>
				</form>

			</div>
		</div>
	</div>
</div>

<%@ include file="/common/footer.jsp"%>