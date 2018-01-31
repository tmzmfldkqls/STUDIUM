<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="java.util.List,com.st.studyroom.model.*, org.json.simple.parser.JSONParser,org.json.simple.JSONObject,org.json.simple.parser.ParseException,org.json.simple.JSONArray"%>
<%@ include file="/common/header.jsp"%>
<script type="text/javascript" src="<%=root%>/js/httpRequest.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<%
List<StudyRoomDto> list = (List<StudyRoomDto>)request.getAttribute("pickedrooms");
%>

<br>
<br>
<link
	href='https://fonts.googleapis.com/css?family=Roboto:400,500,300,700'
	rel='stylesheet' type='text/css'>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel='stylesheet' type='text/css'
	href='<%=root%>/room/calendar/dist/rm-datepicker.css'>

<div class="container" style="margin-bottom: 5%">

	<div class = "row" style = "margin-bottom: 4%" >
			<div class = "col-12" align = center><h3 class="display-3"><strong>My StudyRoom</strong></h1></div>
	</div>
		
	<div class="row">
		<div class="col-lg-6" style="padding: 3%">
			<form id="resvationform" name="resvationform" action="" method="POST">
<input type="hidden" id="selected" name="selected" value="{{oDate1 | date: 'yyyy-MM-dd'}}">
				<div ng-app="myApp" ng-controller="MyCtrl" class="container">
					<br>
					<div rm-datepicker ng-model="oDate1" rm-config="rmConfig1">
					</div>					
				</div>
			</form>
			<div id='rsvlist'></div>
		</div>
		<div class="col-lg-6" style="padding: 3%">
			<table class="table" width="100%">
				<thead class="thead-dark">
					<tr>
						<th width="100%" align="center"> [<%=list.get(0).getSP_NAME()%>]</th>
					</tr>
				</thead>
				<tbody>
					
				<%
					for (int i = 0; i < list.size(); i++) {
				%>
					<tr>
						<td>
						   <div class="radio">
    						 <label><input type="radio" name = "room" onclick="javascript:selectedRmno(<%=list.get(i).getRM_NO()%>)"><%=list.get(i).getRM_NAME()%></label>
    						</div>					
						</td>
					</tr>
				<%
					 	}
				%>
						
				</tbody>
			</table>
			
			<div id='rsvdetail'></div>
			</div>
		</div>
	</div>
</div>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.min.js"></script>
<script src="<%=root%>/room/calendar/src/scripts/rm-datepicker.js"></script>
<script>

    var app = angular.module("myApp", ["rmDatepicker"]);

    /* Datepicker global configuration */
    app.config(["rmDatepickerConfig", function (rmDatepickerConfig) {
        rmDatepickerConfig.mondayStart = true;
        rmDatepickerConfig.initState = "month";
    }]);
    (function () {

        var app = angular.module("myApp");

        var MyCtrl = function ($scope) {

            /* Datepicker local configuration */
            $scope.rmConfig1 = {
                mondayStart: false,
                initState: "month", /* decade || year || month */
                maxState: null,
                minState: "month",
                decadeSize: 12,
                monthSize: 42, /* "auto" || fixed nr. (35 or 42) */
                min: new Date('2000-11-21'),
                max: new Date('2023-11-21'),
                format: "yyyy-MM-dd" /* https://docs.angularjs.org/api/ng/filter/date */
            };

            $scope.rmConfig2 = { format: "yyyy-MM-dd" };
            $scope.oDate1 = new Date();
            $scope.oDate2 = null;
            $scope.clearInput = function(){
                $scope.oDate2 = null;
            }
            
            $scope.rmConfig3 = { format: "yyyy-MM-dd" };
            $scope.oDate3 = new Date();
            $scope.oDate4 = null;
            $scope.clearInput2 = function(){
                $scope.oDate4 = null;
            }
        };
        app.controller("MyCtrl", ['$scope', MyCtrl]);
    }());

    // Init waves (OPTIONAL) :)
    // window.onload = Waves.init();
    
    
     var flag=0;//0�̸� ���� �����ϰ�, 1�̸� ���� �Ұ����ϰ�
     var pre_flag=0;//1�̸� �ٷ� �� tr�� printing_time �� out_time�� ��ġ�Ѵٴ� ��.    
     var room_number=-1;//�� �ƹ��͵� ���� �ȵ��� ��.
	 var rsv_count= -1
	 function selectedRmno(rmno){
    	 room_number = rmno;
	 }
     ///���� ������ ���� ��
	 function selectRsvForDelete(rmrno){		 
		 var param = "act=showRsvDetail&"+"rmrno=" + rmrno;
		 sendRequest("<%=root%>/aJaxController",param, receiveRsvDetail, "GET");
	 }
	 function receiveRsvDetail() {
			if(httpRequest.readyState == 4) {
				if(httpRequest.status == 200) {
					var listxml = httpRequest.responseXML;
					makePanel(listxml);						
				}
			}	
		 }z
	 function makePanel(listxml) {
		
		 var rmrno = listxml.getElementsByTagName("rmrno")[0].firstChild.data;
		 var sp_name = listxml.getElementsByTagName("sp_name")[0].firstChild.data
		 var rm_name = listxml.getElementsByTagName("rm_name")[0].firstChild.data
		 
		 var rmr_id = listxml.getElementsByTagName("rmr_id")[0].firstChild.data;
		 var rmr_date = listxml.getElementsByTagName("rmr_date")[0].firstChild.data
		 var rmr_date_in = listxml.getElementsByTagName("rmr_date_in")[0].firstChild.data
		 
		 var rmr_time = listxml.getElementsByTagName("rmr_time")[0].firstChild.data;
		 var rmr_email = listxml.getElementsByTagName("rmr_email")[0].firstChild.data
		 var rmr_tel = listxml.getElementsByTagName("rmr_tel")[0].firstChild.data
		 
		 var rmr_price = listxml.getElementsByTagName("rmr_price")[0].firstChild.data;
		 var rmr_person = listxml.getElementsByTagName("rmr_person")[0].firstChild.data
		 var rmr_content = listxml.getElementsByTagName("rmr_content")[0].firstChild.data
		
		 var html = "<div class=\"table-responsive\" style=\"width:100%;overflow:auto\">";

			 html += "<table  class=\"table\" width = \"100%\" ><thead class=\"thead-dark\"><tr><th width = \"25%\" align=\"center\"  ></th><th width = \"75%\" align=\"center\"></th></tr></thead>"
			 html += "<tr><td>�����ȣ</td><td>"+ rmrno+"</td></tr>";
			 html += "<tr><td>�����̸�</td><td>"+ sp_name+"</td></tr>";
			 html += "<tr><td>���ΰ����̸�</td><td>"+ rm_name+"</td></tr>";
			 
			 html += "<tr><td>������ID</td><td>"+ rmr_id+"</td></tr>";
			 html += "<tr><td>��������</td><td>"+ rmr_date+"</td></tr>";
			 html += "<tr><td>�������</td><td>"+ rmr_date_in+"</td></tr>";
			 
			 html += "<tr><td>���ð�</td><td>"+ rmr_time+"</td></tr>";
			 html += "<tr><td>������ �̸���</td><td>"+ rmr_email+"</td></tr>";
			 html += "<tr><td>������ ����ó</td><td>"+ rmr_tel+"</td></tr>";
			 
			 html += "<tr><td>�ݾ�</td><td>"+ rmr_price+"</td></tr>";
			 html += "<tr><td>�����ο�</td><td>"+ rmr_person+"</td></tr>";
			 html += "<tr><td>��û����</td><td>"+ rmr_content+"</td></tr>";
			 html += "<tr><td colspan = \"2\"><button type=\"button\" class=\"btn btn-outline-primary btn-block\" onclick=\"location.href='<%=root%>/mypage?act=rsvDelete&rmrno="+rmrno+"'\">�������</button></td></tr>";
			 html +="</div>"
			 html +="</table>";
			 document.getElementById("rsvdetail").innerHTML = html;
	 }
	//������ ���� ��
	 function check(date){
		 rsv_count=-1;
		 if(room_number != -1){
		 	 var selectDate = date;	 
			 var param = "act=showlist&"+"date=" + selectDate + "&selectedRoom="+room_number;
			 sendRequest("<%=root%>/aJaxController",param, receiveResult, "GET");
		 }else{
			 alert("������ Ȯ���� studyroom�� ���� �������ּ���");
		 }
 		}  
	 function receiveResult() {
		if(httpRequest.readyState == 4) {
			if(httpRequest.status == 200) {
			var o1 = JSON.parse(httpRequest.responseText);
			
			var rmrArray = [];
			for(var i=0 ; i<o1.rsvlist.length ; i++){					
					rmrArray[i] = o1.rsvlist[i].RMRNO;
			}
			var size = o1.rsvlist.length; 
			var html = "<div class=\"table-responsive\" style=\"width:100%; height:400px; overflow:auto\">";
			var printing_time="";
				html += "<table  class=\"table\" width = \"100%\" ><thead class=\"thead-dark\"><tr><th width = \"25%\" align=\"center\"  >�ð���</th><th width = \"75%\" align=\"center\">���೻��</th></tr></thead>"
			
				for(var i=1 ; i<= 48 ; i++){//i�� ���� ���۽ð����� ������ �ð����� ������ ��
					
					//����, ��� �ð� ���� �κ�. ��� �࿡ ���� end�� start ����. 
					if(i%2 == 0){

						printing_time = Math.floor((i-1)/2) +":30" +" - "+ i/2 +":00";	
					}else{
						printing_time = Math.floor((i-1)/2) +":00" +" - "+ (i-1)/2 +":30";	
					}
					//�� td�� ���� flag �Ǻ�. 
					detect(printing_time,o1,size);	
					var rmrno = -1;
					if(rsv_count != -1){
						rmrno = o1.rsvlist[rsv_count].RMRNO;
					}
					//���̺� ��� ���� �κ�
					if(flag == 0)
						html += "<tr><td>"+printing_time+"</td><td></td></tr>";
					else{							
								html += "<tr name = \"unable\"><td>"+printing_time+"</td><td onclick=\"javascript:selectRsvForDelete(" + rmrno +");\" style=\"cursor:pointer;\" bgcolor=\"#ECE8EE\">��������</td></tr>";
						}
					}
				
				html +="</div>"
				html +="</table>";

				document.getElementById("rsvlist").innerHTML = html;
			}
		}	
	 }
	 
	function detect(printing_time, o1,size){
			for(var i=0;i<size;i++){
				if(pre_flag == 1){
					flag=0;
					pre_flag =0;
				}
				if(o1.rsvlist[i].RMR_TIME_IN == printing_time){
						rsv_count++;
						flag = 1;	
				}
				if(o1.rsvlist[i].RMR_TIME_OUT == printing_time){					
					pre_flag = 1;
				}
			}
		}
</script>
<%@ include file="/common/footer.jsp"%>