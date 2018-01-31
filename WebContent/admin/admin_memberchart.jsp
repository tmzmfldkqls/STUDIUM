<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/admin_header.jsp"%>
<script type="text/javascript" src="<%=root%>/js/httpRequest.js"></script>
<link rel="stylesheet" href="<%=root%>/css/sb-admin-2.css">
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
window.onload = function() {
	membercount();	
}

function membercount() {	
	var url = "<%= root%>/admin";
	var params = "act=memberchart";	
	sendRequest(url, params, drawChart, "GET");
}

google.charts.load('current', {'packages':['bar']});
google.charts.setOnLoadCallback(drawChart);

function drawChart() {
	var data ;
	if(httpRequest.readyState == 4) {
		if(httpRequest.status == 200) {
			data = google.visualization.arrayToDataTable($.parseJSON(JSON.parse(JSON.stringify(httpRequest.responseText))));
		}
	}   

  var options = {
    chart: {
      title: '년도별 회원가입수'
    },
    bars: 'horizontal' // Required for Material Bar Charts.
  };

  var chart = new google.charts.Bar(document.getElementById('barchart_material'));

  chart.draw(data, google.charts.Bar.convertOptions(options));
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
					<div class="panel-heading">CHART
				
					</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div id="barchart_material"></div>
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