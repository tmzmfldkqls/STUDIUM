<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/admin_header.jsp"%>
<script type="text/javascript" src="<%=root%>/js/httpRequest.js"></script>
<link rel="stylesheet" href="<%=root%>/css/sb-admin-2.css">
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
window.onload = function() {
	logincount();
	
}
function logincount() {	
	var url = "<%= root%>/admin";
	var params = "act=loginchart";	
	sendRequest(url, params, drawChart, "GET");
}
google.charts.load("current", {packages:["corechart"]});
google.charts.setOnLoadCallback(drawChart);
function drawChart() {
	var data ;
	if(httpRequest.readyState == 4) {
		if(httpRequest.status == 200) {
			data = google.visualization.arrayToDataTable($.parseJSON(JSON.parse(JSON.stringify(httpRequest.responseText))));
		}
	} 

  var options = {
    title: '아이디별 접속수',
    pieHole: 0.5,
  };

  var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
  chart.draw(data, options);
}


</script>
<div id="wrapper">
	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header"></h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-12 pt-4">
				<div class="panel panel-default">
					<div class="panel-heading">LOGINCHART
				
					</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div id="donutchart" style="width: 900px; height: 500px;"></div>
					</div>
					<!-- .panel-body -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-6 -->

		</div>
		<!-- /#page-wrapper -->

	</div>



<%@ include file="/common/admin_footer.jsp" %>