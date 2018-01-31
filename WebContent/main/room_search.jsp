<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String root = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>스터디룸 검색</title>
<style type="text/css">
html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
      #map {
        height: 100%;
        width: 100%;
      }
       .controls {
       margin-top: 10px;
        border: 1px solid transparent;
        border-radius: 2px 0 0 2px;
        box-sizing: border-box;
        -moz-box-sizing: border-box;
        height: 32px;
        outline: none;
        box-shadow: 0 2px 6px rgba(0, 0, 0, 0.3);
      }

      #pac-input {
        background-color: #fff;
        font-family: Roboto;
        font-size: 15px;
        font-weight: 300;
        margin-left: 12px;
        padding: 0 11px 0 13px;
        text-overflow: ellipsis;
        width: 200px;
      }
      
      #person {
        background-color: #fff;
        font-family: Roboto;
        font-size: 15px;
        font-weight: 300;
        margin-left: 12px;
        padding: 0 11px 0 13px;
      }
      
      #rbutton {
        background-color: #fff;
        font-family: Roboto;
        font-size: 15px;
        font-weight: 300;
        margin-left: 12px;
        padding: 0 11px 0 13px;
        width: 50px;
      }
	 #rbutton:focus {
        border-color: #4d90fe;
      }
      #pac-input:focus {
        border-color: #4d90fe;
      }

     
</style>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript" src="<%= root %>/js/httpRequest.js"></script>
<script type="text/javascript">
	
    var autocomplete;
    var marker=[];
    var place = [];
    var cnt = 0;
    var result = [];
    var cog = [];
    var person = 2;
    var map;
    var service;
    var caldi;
   function initMap(){
	   service = new google.maps.DistanceMatrixService;
      map = new google.maps.Map(document.getElementById('map'), {
    	  mapTypeControl: false,
    	  center: {lat : 37.570,lng : 126.977 },
          zoom: 13
        });     	
      var input = document.getElementById('pac-input');
      var select = document.getElementById('person');
      var button = document.getElementById('rbutton');
      map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);
      map.controls[google.maps.ControlPosition.TOP_LEFT].push(select);
      map.controls[google.maps.ControlPosition.TOP_LEFT].push(button);
      autocomplete = new google.maps.places.Autocomplete(document.getElementById('pac-input'));        
        autocomplete.addListener('place_changed', function(){
         placeChang();
      });
       
   }
   
   function refreshPage() {
	   location.reload();
   }
   
   function selectvalue() {
	 person = document.getElementById("person").value;
   } 
 
   
   function placeChang() {
	  
      place[cnt] = autocomplete.getPlace();     
      map.panTo(place[cnt].geometry.location);
      marker[cnt] = new google.maps.Marker({
         map: map,
         icon: 'http://maps.google.com/mapfiles/kml/pal3/icon56.png',
         position: place[cnt].geometry.location
      });      
      result[cnt] = marker[cnt].getPosition();
      cnt++;
      if(cnt == person) {
       draw(result);
       center(result);       
       cdraw(result,cog);
       addresslist();       
      }
   }
   function center(result) {
	   var lat = 0;
	   var lng = 0;
	   var size = result.length;
	   for(var i=0; i < size; i++) {
	   		lat += result[i].lat();
	   		lng += result[i].lng();
	   }
	   lat = lat/size;
	   cog[0] = lat;
	   lng = lng/size;
	   cog[1] = lng;
	   marker = new google.maps.Marker({
	         map: map, 
	         position: {lat : lat,lng : lng  },
	         icon: 'http://maps.google.com/mapfiles/kml/pal2/icon13.png',
	         animation: google.maps.Animation.DROP
	      });
   }
   
   
   function draw(result) {
	   
	   
	   var triangleCoords = [];
	   for(var i=0; i < result.length; i++) {
		   triangleCoords[i] = {lat: result[i].lat(), lng: result[i].lng()};  
	   }

	     var bermudaTriangle = new google.maps.Polygon({
	       paths: triangleCoords,
	       strokeColor: '#000000',
	       strokeOpacity: 0.8, // border 투명도
	       strokeWeight: 3, //막혀있는 공간 border 두께
	       fillColor: '#000000', // 막혀있는 공간 색깔
	       fillOpacity: 0.35 // 막혀있는 공간 투명도
	     });
	     bermudaTriangle.setMap(map);
	     
	}
   function cdraw(origin, cog) {

       			var bounds = new google.maps.LatLngBounds;
       			var geocoder = new google.maps.Geocoder;
       			var distance = 0;
       			for(var i=0; i< origin.length; i++) {
       			distance += caldistance(cog[0],cog[1],origin[i].lat(),origin[i].lng());       			
       			}
       			caldi = distance/origin.length/13*4.5;
       			alert("center : " + distance/origin.length);
		          var circle = new google.maps.Circle({
		              strokeColor: '#FF0000',
		              strokeOpacity: 0.8,
		              strokeWeight: 2,
		              fillColor: '#FF0000',
		              fillOpacity: 0.35,
		              map: map,
		              center: {lat : cog[0],lng : cog[1]  },
		              radius: Math.sqrt(30) * distance/origin.length/13
		            });		      
	   
   }
   
   var address = [];
   function addresslist() {
   	var params = "act=addresslist";
   	sendRequest("<%= root%>/admin", params, viewlist, "GET");
   }
   function viewlist() {
   	if(httpRequest.readyState == 4) {
   		if(httpRequest.status == 200) {
   			var listxml = httpRequest.responseXML; // mlist받아옴
   			makelist(listxml);
   		}
   	}
   }
   function makelist(listxml) {
   	var len = listxml.getElementsByTagName("address").length;
   	for(var i=0; i<len; i++) {
   		var marker = makemarker(listxml.getElementsByTagName("address")[i]);
   	}
   }
   function caldistance(lat1,lon1,lat2,lon2) {
       
       var theta = lon1 - lon2;
       var dist = Math.sin(lat1 * Math.PI / 180.0) * Math.sin(lat2 * Math.PI / 180.0) + Math.cos(lat1 * Math.PI / 180.0) * Math.cos(lat2 * Math.PI / 180.0) * Math.cos(theta * Math.PI / 180.0);
       dist = Math.acos(dist);
       dist = dist * 180 / Math.PI;
       dist = dist * 60 * 1.1515;
       dist = dist * 1609.344;
       
       return Math.round(dist);
   }
   
   function makemarker(address) {
   	var spno = address.getElementsByTagName("spno")[0].firstChild.data
   	var dong = address.getElementsByTagName("dong")[0].firstChild.data;
   	var name = address.getElementsByTagName("name")[0].firstChild.data;
   	var scontent = address.getElementsByTagName("scontent")[0].firstChild.data;
   	var tag = address.getElementsByTagName("tag")[0].firstChild.data;
   	var geo = address.getElementsByTagName("geo")[0].firstChild.data;
   	geo = geo.replace("(", "") ;  	
   	geo = geo.replace(")", "");
   	var geos = geo.split(",");
   	alert(name +cog[0]+ " " +cog[1]+ " " + geos[0]+ " " +geos[1]);
    var bounds = new google.maps.LatLngBounds;
    var geocoder = new google.maps.Geocoder;
    var distance = caldistance(cog[0],cog[1],geos[0],geos[1]);
    alert(distance + " caldi " + caldi);
    if(distance < caldi ){
            var a = '<a href=\"javascript:mov('+ spno +');\">해당 스터디룸으로 가기</a>';
           	var str = "공간명 : " + name +"<br>" + "간단한 소개 : " + scontent+ "<br>" + "태그 : " + tag +"<br>" + a;
           	        var marker = new google.maps.Marker({
           	          map: map,
           	          position: {lat: parseFloat(geos[0]), lng: parseFloat(geos[1])}
           	        });
           	     	marker.addListener('click', function() {
                     infowindow.open(map, marker);
                   });
           	     	var infowindow = new google.maps.InfoWindow({
                     content: str
                   }); 
     }
       
   	}

   function mov(spno) {
	   opener.document.location.href = "<%=root %>/studyroom?act=mvrsv&spno=" + spno;
   }
  
   
</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCIWw8j5GzhBYcn27RxKAAZhD2VhOl8MiA&libraries=places&callback=initMap"
        async defer></script>

</head>
<body>
<div id="map"></div>
<input id="pac-input" class="controls" type="text" size="30">
<select id="person" class="controls" name="person" onchange="javascript:selectvalue();">
<option value="2" selected>2명</option>
<option value="3">3명</option>
<option value="4">4명</option>
<option value="5">5명</option> 
</select>
<button id="rbutton" class="controls" onclick="javascript:refreshPage();"><i class="fa fa-refresh fa-spin" style="font-size:24px"></i></button>
<div id="output"></div>
</body>

</html>