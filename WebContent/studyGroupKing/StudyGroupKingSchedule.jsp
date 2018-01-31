<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="java.util.*,com.st.studygroup.model.*"%>
<%@ include file="/studygroupmain/studygroupsubnav.jsp"%>
<link rel='stylesheet prefetch'
	href='http://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css'>
<link href='http://fonts.googleapis.com/css?family=Lato'
	rel='stylesheet' type='text/css'>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
<link
	href='https://fonts.googleapis.com/css?family=Roboto:400,500,300,700'
	rel='stylesheet' type='text/css'>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--<link rel='stylesheet' type='text/css'-->
<!--href='http://fian.my.id/Waves/static/waves.min.css?v=0.7.4'>-->
<link rel='stylesheet' type='text/css'
	href='<%=root%>/css/rm-datepicker.css'>
<script type="text/javascript" src="<%=root%>/js/httpRequest.js"></script>
<%
	List<StudyGroupScheduleDto> list = (List<StudyGroupScheduleDto>) request.getAttribute("scheduleList");
%>
<style>
.calendar {
	padding-right: 15px;
	padding-left: 15px;
	padding-top: 15px;
	padding-bottom: 15px;
	margin-top: auto;
	margin-bottom: auto;
	margin-right: auto;
	margin-left: auto;
}

.progress{
	
	margin-top: 15px;
	margin-bottom: 15px;
	margin-right: auto;
	margin-left: auto;
}
</style>
<script type="text/javascript">

window.onload = function(){
	var url = "<%=root%>/groupschedule";
	var params = "act=todayschedule";
	sendRequest(url, params, slist, "GET");
}

function mvRegister(){
	document.location.href="<%=root%>/groupschedule?act=mvregister";
	}


function check(date){
	 var selectDate = date;
	 var param ="act=viewSchedulelist&date=" + selectDate;
	 sendRequest("<%=root%>/groupschedule", param, slist, "GET");
	}

	function slist() {
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				var listxml = httpRequest.responseXML;
				makelist(listxml);
			}
		}
	}

	function makelist(data) {
		var output = "";
		var len = data.getElementsByTagName("StudyGroupSchedule").length;
			for (var i = 0; i < len; i++) {
				var stDateIn = data.getElementsByTagName("stDateIn")[i].firstChild.data;
				var stContent = data.getElementsByTagName("stContent")[i].firstChild.data;
				var stName = data.getElementsByTagName("stName")[i].firstChild.data;
				output += "<tr>";
				output += "<td width=\"10%\"><label for=\"comment\">일정이름:</label></td>";
				output += "</tr>";
				output += "<tr>";
				output += "<td width=\"10%\"><textarea class=\"form-control\" rows=\"2\" id=\"comment\" readonly=\"readonly\">" + data.getElementsByTagName("stName")[i].firstChild.data + "</textarea></td>";
				output += "</tr>";
				output += "<tr>";
				output += "<td width=\"10%\"><label for=\"comment\">일정내용:</label></td>";
				output += "</tr>";
				output += "<tr>";
				output += "<td width=\"10%\"><textarea class=\"form-control\" rows=\"5\" id=\"comment\" readonly=\"readonly\">" + data.getElementsByTagName("stContent")[i].firstChild.data + "</textarea></td>";
				output += "</tr>";
				output += "<div class=\"progress\">";
				output += "<div class=\"progress-bar bg-success\" role=\"progressbar\" style=\"width: 100%\" aria-valuenow=\"25\" aria-valuemin=\"0\" aria-valuemax=\"100\"></div>";
				output += "</div>";
			}

		document.getElementById("slist").innerHTML = output;
	}
	
	
</script>
<div ng-app="myApp" ng-controller="MyCtrl" class="calendar">
	<div class="row">

		<div class="col-md-6">
			<div rm-datepicker ng-model="oDate1" rm-config="rmConfig1">
				<input type="hidden" id="selected" name="selected"
					value="{{oDate1 | date: 'yyyy-MM-dd'}}">
			</div>
		</div>
		<div class="col-md-6" id="content">
			<label for="demo">날짜:</label>
			<textarea class="form-control" rows="2"
				readonly="readonly">{{oDate1 | date: 'yyyy-MM-dd'}}</textarea>
			<!-- <div>{{oDate1 | date: 'yyyy-MM-dd'}}</div> -->
				<div class="progress">
  					<div class="progress-bar bg-success" role="progressbar" style="width: 100%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
				</div>
			<table>
				<tbody id="slist"></tbody>
			</table>
			<br>
			<button type="button" class="btn btn-success btn-lg"
				onclick="javascript:mvRegister();">일정등록하기</button>
		</div>
	</div>
	<!--<input rm-datepicker type="text" ng-model="oDate2" rm-config="rmConfig2">-->
	<!--<button data-ng-click="clearInput()">Clear Input</button>-->
</div>

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.min.js"></script>
<!--<script src="http://fian.my.id/Waves/static/waves.min.js?v=0.7.4"></script>-->
<script src="<%=root%>/js/rm-datepicker1.js"></script>
<!--<script src="<%=root%>/js/rm-datepicker.min.js"></script>-->
<script>
	var app = angular.module("myApp", [ "rmDatepicker" ]);

	/* Datepicker global configuration */
	app.config([ "rmDatepickerConfig", function(rmDatepickerConfig) {
		rmDatepickerConfig.mondayStart = true;
		rmDatepickerConfig.initState = "month";

	} ]);
</script>
<script>
	(function() {

		var app = angular.module("myApp");

		var MyCtrl = function($scope) {

			/* Datepicker local configuration */
			$scope.rmConfig1 = {
				mondayStart : false,
				initState : "month", /* decade || year || month */
				maxState : null,
				minState : "month",
				decadeSize : 12,
				monthSize : 42, /* "auto" || fixed nr. (35 or 42) */
				min : new Date('2000-11-21'),
				max : new Date('2023-11-21'),
				format : "yyyy-MM-dd" /* https://docs.angularjs.org/api/ng/filter/date */

			};

			$scope.rmConfig2 = {
				format : "d MMM yyyy"
			};

			$scope.oDate1 = new Date();
			$scope.oDate2 = null;
			$scope.clearInput = function() {
				$scope.oDate2 = null;
			}
		};
		app.controller("MyCtrl", [ '$scope', MyCtrl ]);

	}());

	// Init waves (OPTIONAL) :)
	// window.onload = Waves.init();
</script>
<script>
	//$(document).ready(function() {
	//		$(".container").click(function() {
	//		var x = $(".row #calendar");
	//			x.animate({
	//			left : '250px'
	//		}, "slow");
	//		$(".row #content").fadeIn(2000);
	//		});
	//	});
	//
	//$(document).ready(function() {
	//	$(".row #calendar #calendar_content").click(function() {

	//	});
	//	});
</script>



</div>
</body>
</div>
</div>
</div>
<%@include file="/common/footer.jsp"%>