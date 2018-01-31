<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/studygroupmain/studygroupsubnav.jsp"%>
<link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css'>
<link rel="stylesheet" href="<%=root%>/css/groupSchedule.css">
<link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
<link href='https://fonts.googleapis.com/css?family=Roboto:400,500,300,700' rel='stylesheet' type='text/css'>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<!--<link rel='stylesheet' type='text/css'>-->
<!--href='http://fian.my.id/Waves/static/waves.min.css?v=0.7.4'>-->
<link rel='stylesheet' type='text/css' href='<%=root%>/css/rm-datepicker.css'>
<style>
.register {
    padding-right: 50px;
	padding-left: 50px;
	padding-top: 50px;
	padding-bottom : 50px;
	margin-top: auto;
	margin-bottom:auto;
	margin-right: auto;
	margin-left: auto
}

.rows {
    padding-right: 15px;
	padding-left: 15px;
	padding-top: 15px;
	padding-bottom : 15px;
}
</style>
<script type="text/javascript">
function registerSchedule(){
	if(document.registerScheduleForm.date.value ==""){
		alert("날짜를 선택해주세요");
		return;
	}else if(document.registerScheduleForm.scheduleName.value == ""){
		alert("일정이름을 입력해 주세요");
		return;
	}else if(document.registerScheduleForm.scheduleContent.value == ""){
		alert("일정 내용을 입력해 주세요");
		return;
	}
	document.registerScheduleForm.action="<%=root%>/groupschedule";
	document.registerScheduleForm.submit();
}


</script>
<form method="post" act="" id="registerScheduleForm" name="registerScheduleForm">
	<input type="hidden" name="act" id="act" value="registerschedule">
<div ng-app="myApp" ng-controller="MyCtrl" class="register">
	<div class="rows">
	<label for="comment">날짜:</label>
	<input rm-datepicker type="text" name ="date" ng-model="oDate2" value="oDate2" rm-config="rmConfig2">
    <button data-ng-click="clearInput()">새로고침</button>
     </div>
     <div class="rows">
    <label for="comment">일정이름:</label>
			<textarea class="form-control" rows="2" name="scheduleName"></textarea>
			<br> 
			<label for="comment">일정내용:</label>
			<textarea class="form-control" rows="5" name="scheduleContent"></textarea>
			<br><br>
			<button type="button" class="btn btn-success btn-lg" onclick="javascript:registerSchedule();">등록</button>
			<button type="button" class="btn btn-danger btn-lg" onclick="location.href='#'">취소</button>
   </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.min.js"></script>
<!--<script src="http://fian.my.id/Waves/static/waves.min.js?v=0.7.4"></script>-->
<script src="<%=root%>/js/rm-datepicker.js"></script>
<!--<script src="<%=root%>/js/rm-datepicker.min.js"></script>-->
<script>

var app = angular.module("myApp", ["rmDatepicker"]);

/* Datepicker global configuration */
app.config(["rmDatepickerConfig", function (rmDatepickerConfig) {
    rmDatepickerConfig.mondayStart = true;
    rmDatepickerConfig.initState = "month";
}]);

</script>
<script>

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
        
        $scope.oDate1 = new Date().toString();
        $scope.oDate2 = null;
        $scope.clearInput = function(){
            $scope.oDate2 = null;
        }
    };
    app.controller("MyCtrl", ['$scope', MyCtrl]);
}());

//Init waves (OPTIONAL) :)
//window.onload = Waves.init();

</script>
</body>
</div>
</div>
</div>
<%@include file="/common/footer.jsp"%>