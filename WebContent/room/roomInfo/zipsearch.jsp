<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.List,com.st.studyroom.model.*"%>
<%
	String root = request.getContextPath();

	String dong = (String) request.getAttribute("sdong");
//System.out.println("zipsearch.jsp >>>> " + dong);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>�����ȣ�˻�</title>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript" src="<%= root %>/js/httpRequest.js"></script>
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCIWw8j5GzhBYcn27RxKAAZhD2VhOl8MiA&callback=initMap"></script>
<script type="text/javascript">

function zipsearch() {
	if(document.zipform.dong.value == "") {
		return;
	} else {
		document.zipform.action = "<%=root%>/studyroom";
		
		document.zipform.submit();
	}
}
var geocoder;
function selectzip(address ,si , gugun ,dong, bunji) {
	opener.document.sp_registerform.addr1.value = address;	
	opener.document.sp_registerform.si.value = si;
	opener.document.sp_registerform.gugun.value = gugun;
	opener.document.sp_registerform.dong.value = dong;
    geocodeAddress(geocoder,dong,bunji);
	opener.document.sp_registerform.bunji.value = bunji;
}


function initMap() {
	geocoder = new google.maps.Geocoder();
  }




function geocodeAddress(geocoder,dong,bunji) {
	var address ="";
	var pattern = /[^(0-9)]/gi;   // �����ܴ̿� ����
		if(pattern.test(bunji)){
			bunji = bunji.replace(pattern,"#");
		}
		var num = bunji.indexOf("#");
		address = dong + bunji.substr(0,num);
		alert(address);

    geocoder.geocode({'address': address}, function(results,status) {
			if (status === 'OK') {            
            alert(results[0].geometry.location);
            opener.document.sp_registerform.geo.value = results[0].geometry.location;
          } else {
            alert('Geocode was not successful for the following reason: ' + status);
          }
    });
  }

</script>

</head>
<body>
<form name="zipform" method="get" action="" onsubmit="return false;">
<input type="hidden" id="act" name="act" value="zipsearch">
<div class="container" align="center">
	<div align="center" style="width:500px; border:1px solid #cccccc; padding:20px; margin-top:30px">
		<h4>�ּ�(��з�)�˻�</h4>
		<hr />
		<div class="form-inline" style="margin-bottom:5px">
			<label style="width:80px">�ּ��Է�</label>
			<input id="dong" name="dong" type="text" class="form-control" placeholder="���� �Է��ϼ���." onkeypress="javascript:if(event.keyCode == 13) {zipsearch();}"/>
			<input type="button" class="btn btn-success" value="�˻�" onclick="javascript:zipsearch();"/>
		</div>
		<hr />
<%
if(dong == null) {//�˻������� �ִٸ�..
%>		
		<div>
		�˻� �Ͻ� ���� ��Ȯ�� �Է��ϼ���.<br>
		��) �Ｚ, ����
		</div>
<%
} else {//�˻������� ���ٸ�..
	List<ZipDto> list = (List<ZipDto>)request.getAttribute("ziplist");
	int size = list.size();
	if(size != 0) {
		for(int i=0;i<size;i++) {
			ZipDto zipDto = list.get(i);
%>	
		<div>
		<a href="javascript:selectzip('<%=zipDto.getSI() %> <%=zipDto.getGUGUN()%> <%=zipDto.getDONG()%> <%=zipDto.getBUNJI()%>','<%=zipDto.getSI() %>','<%=zipDto.getGUGUN()%>','<%=zipDto.getDONG()%>','<%=zipDto.getBUNJI()%>');">
		<%=zipDto.getZIPCODE() %>
		<%=zipDto.getSI() %> <%=zipDto.getGUGUN()%> <%=zipDto.getDONG()%> <%=zipDto.getBUNJI()%>
		</a>
		</div>
<%
		}
	} else {
%>		
		<div>
		�˻��Ͻ� <%=dong %>�� �����ϴ�.	
		</div>
<%
	}
}
%>
	</div>
</div>
</form>
</body>
</html>