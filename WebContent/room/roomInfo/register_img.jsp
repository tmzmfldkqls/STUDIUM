<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="java.util.List,com.st.studyroom.model.StudyRoomDto,java.util.ArrayList"%>
<%@ include file="/common/header.jsp"%>
<script type="text/javascript" src="<%=root%>/js/httpRequest.js"></script>
<script type="text/javascript">
function register_img(){
		//��ȿ���˻�
		if(document.getElementById("sp_img").value == "") {
			alert("��ǥ �̹����� �Է����ּ���");
			return;
		}else if(document.getElementById("detail_img1").value == "") {
			alert("�� �̹����� �ݵ�� �ϳ� �̻� �Է����ּ���");
			return;
		}else if(document.getElementById("detail_img1") == null) {
			alert("�� �̹����� �ݵ�� �ϳ� �̻� �Է����ּ���");
			return;
		}else{
			document.sp_registerform.action = "<%=root%>/register";
			document.sp_registerform.submit();
		}
	}	
	var idx_picture = 0;
	//���� ����ؼ� �߰��� ��
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
		rbtn.setAttribute("value", "����");
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
								<b>���͵�� ���</b> <br> <small>�̹����� �Է����ּ���</small>
							</h1>
<!---------------------------------------------------------���⼭���� �� ���� -------------------------------------------->
<!---------------------------------------------------------���⼭���� �� ���� --------------------------------------------->
<!---------------------------------------------------------���⼭���� �� ���� --------------------------------------------->
<!---------------------------------------------------------���⼭���� �� ���� --------------------------------------------->
<!---------------------------------------------------------���⼭���� �� ���� --------------------------------------------->

<form method="post" name="sp_registerform" action="" enctype="multipart/form-data"><!-- enctype="multipart/form-data" ���� -->
<input type = "hidden" name = "act" value = "roomrgst">
								<div align="right" style="color: red">��ǥ�̹����� ���̹����� �ݵ�� �ϳ� �̻� ������ּ���!</div>
								<hr>
								
								<div class="form-group">
									<label for="sp_img" class="font-weight-bold">��ǥ�̹���</label>
									<input type="file" class="form-control" id="sp_img" name="sp_img">
								</div>

								<div class="form-group">
									<div class="row">
										<div class="col-lg-11" style = "margin-bottom : 2%">
											<label for="i_path" class="font-weight-bold">���̹���<small>(�� �̹����� �ִ� 15������ �����մϴ�)</small></label>
										</div>
										<div class="col-lg-1">
												<input type="button" class="btn btn-primary" value="�߰�" onclick="javascript:appendItem();">
										</div>	
									</div>
									
									<div class="row">
										<div id="answerdiv" class="col-lg-12"></div>		
									</div>

								</div>					 
						
								<hr />
								<div align="center" style = "margin-bottom : 4%">
									<input type="button" class="btn btn-secondary" value="���" />
									<input type="button" class="btn btn-primary" value="����" onclick="javascript:register_img();" />
									
								</div>		
</form>
<!---------------------------------------------------------������� �� ���� --------------answerdiv ���� ���� �޴°ɷ�------------------------------>

							</div>
						</div>
					</div>
<%@ include file="/common/footer.jsp"%>