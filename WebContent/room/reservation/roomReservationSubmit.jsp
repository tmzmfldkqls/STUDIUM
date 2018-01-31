<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="java.util.List,com.st.studyroom.model.*, org.json.simple.parser.JSONParser,org.json.simple.JSONObject,org.json.simple.parser.ParseException,org.json.simple.JSONArray"%>
<%@ include file="/common/header.jsp"%>
<script type="text/javascript" src="<%=root%>/js/httpRequest.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<%
	//���õ� �濡 ���� ���� ����Ʈ
	List<ReservationDto> list = (List<ReservationDto>)request.getAttribute("reservationList");
	//���õ� �� ��ȣ
	int rmnoForRsv = (Integer)session.getAttribute("rmnoForRsv");
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
			<div class = "col-12" align = center>h</div>
	</div>
	<div class = "row" style = "margin-bottom: 4%" >
			<div class = "col-12" align = center><h3 class="display-3"><strong>Reservation</strong></h1></div>
	</div>

	<div class="row">
		<div class="col-lg-6" style="padding: 3%">
			<form id = "resvationform"name="resvationform" action="" method="POST">
<input type="hidden" name="act" value="roomrsv">
				<div ng-app="myApp" ng-controller="MyCtrl" class="container">
					<br>
<div rm-datepicker ng-model="oDate1" rm-config="rmConfig1">
<input type="hidden" id="selected" name="selected" value="{{oDate1 | date: 'yyyy-MM-dd'}}">
</div>
					<div class="form-group" align="left">
						<label for="startTime">�����۽ð�</label><span style="color: red">*</span>
						<input  type="text" class="form-control" id="startTime"  name="startTime" readonly = "readonly">
					</div>
					<div class="form-group" align="left">
						<label for="endTime">�������ð�</label><span style="color: red">*</span>
						<input type="text" class="form-control" id="endTime" name="endTime" readonly = "readonly">
					</div>
					<br>
					<div class="form-group" align="left">
						<label for="rweb">�����ο�</label> <span style="color: red">*</span>
						<input type="number" class="form-control" id="numberOf" name="numberOf" placeholder="" min = "0">
					</div>
					<div class="form-group" align="left">
						<label for="rweb">������ e-mail</label> 
						<input type="text" class="form-control" id="email" name="email" value="<%=memberDto.getM_EMAIL()%>">
		
					</div>
					<div class="form-group" align="left">
						<label for="tel">������ ����ó</label><span style="color: red">*</span> 
						<input type="text" class="form-control" id="tel" name="tel" value="<%=memberDto.getM_TEL()%>">
					</div>
					<div class="form-group" align="left">
						<label for="comment">��û����</label>
						<textarea class="form-control" rows="5" name = "comment" id="comment"></textarea>
					</div>
					<input type="button" class="btn btn-primary btn-lg btn-block" value="����Ϸ�" onclick="javascript:ReservationSubmit();">
				</div>
			</form>
		</div>
		<div class="col-lg-6" style="padding: 3%">	
			<div id = 'rsvlist'></div>
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
     
	 function check(date){
	 var selectDate = date;
	
	 var param = "act=showlist&"+"date=" + selectDate + "&selectedRoom="+<%=rmnoForRsv%>;
	 sendRequest("<%=root%>/aJaxController",param, receiveResult, "GET");
 	}
     
	 function selectTime(start_time,end_time){
	 
		 document.resvationform.startTime.value = start_time;
		 document.resvationform.endTime.value = end_time;
	 }
	 
	 function receiveResult() {
		if(httpRequest.readyState == 4) {
			if(httpRequest.status == 200) {
			var o1 = JSON.parse(httpRequest.responseText);
			var size = o1.rsvlist.length;
			var html = "<div class=\"table-responsive\" style=\"width:100%; height:900px; overflow:auto\">";
			var start_time=""
			var end_time="";
			var printing_time="";
			var i_forEnd;
				html += "<table  class=\"table\" width = \"100%\" ><thead class=\"thead-dark\"><tr><th width = \"25%\" align=\"center\"  >�ð���</th><th width = \"75%\" align=\"center\">���೻��</th></tr></thead>"
				
				for(var i=1 ; i<= 48 ; i++){//i�� ���� ���۽ð����� ������ �ð����� ������ ��
					
					//����, ��� �ð� ���� �κ�. ��� �࿡ ���� end�� start ����. 
					i_forEnd = i+<%=session.getAttribute("usingTime")%> - 1;//������ �ð��� ���� i(������ �࿡ ����)
	
					if(i%2 == 0){
						start_time = Math.floor((i-1)/2) +":30" +" - "+ i/2 +":00";	
						printing_time = start_time;	
					}else{
						start_time = Math.floor((i-1)/2) +":00" +" - "+ (i-1)/2 +":30";
						printing_time = start_time;	
					}
					if(i_forEnd %2 == 0){			
						if(i_forEnd < 48)
							end_time = Math.floor((i_forEnd-1)/2) +":30" +" - "+ i_forEnd/2 +":00";
						else
							end_time = "23:30" +" - "+"24:00";
					}else{
						if(i_forEnd < 48)
							end_time = Math.floor((i_forEnd-1)/2) +":00" +" - "+ (i_forEnd-1)/2 +":30";
						else
							end_time = "23:30" +" - "+"24:00";
					}
					//�� td�� ���� flag �Ǻ�. 
					detect(printing_time,o1,size);					
					//���̺� ��� ���� �κ�
					if(flag == 0)
						html += "<tr><td>"+printing_time+"</td><td onClick=\"javascript:selectTime('"+start_time+"','"+end_time+"');\" style=\"cursor:pointer;\"></td></tr>";
					else
						html += "<tr name = \"unable\"><td>"+printing_time+"</td><td bgcolor=\"#ECE8EE\">����Ұ�</td></tr>";
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
						flag = 1;
				}
				if(o1.rsvlist[i].RMR_TIME_OUT == printing_time){					
					pre_flag = 1;
				}
			}
		}
	function ReservationSubmit(){
		document.resvationform.action = "<%=root%>/studyroom";
		document.resvationform.submit();	
	 }
</script>
<%@ include file="/common/footer.jsp"%>