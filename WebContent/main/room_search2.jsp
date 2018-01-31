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

      #pac-input:focus {
        border-color: #4d90fe;
      }

     
</style>
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
   function initMap(){
	   service = new google.maps.DistanceMatrixService;
      map = new google.maps.Map(document.getElementById('map'), {
    	  mapTypeControl: false,
    	  center: {lat : 37.570,lng : 126.977 },
          zoom: 13
        });     	
      var input = document.getElementById('pac-input');
      var select = document.getElementById('person');
      map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);
      map.controls[google.maps.ControlPosition.TOP_LEFT].push(select);
      autocomplete = new google.maps.places.Autocomplete(document.getElementById('pac-input'));        
        autocomplete.addListener('place_changed', function(){
         placeChang();
      });
       
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
	   			service.getDistanceMatrix({
		      origins: origin,
		      destinations: [{lat : cog[0], lng : cog[1]}],
		      travelMode: 'TRANSIT',
		      unitSystem: google.maps.UnitSystem.METRIC,
		      avoidHighways: false,
		      avoidTolls: false
		    }, function(response, status) {
		      if (status !== 'OK') {
		        alert('Error was: ' + status);
		      } else {
		    	  
		        var originList = response.originAddresses; // origin값 위에서 받아오기
		        var destinationList = response.destinationAddresses;
		        var outputDiv = document.getElementById('output');
		        outputDiv.innerHTML = '';

		        var showGeocodedAddressOnMap = function(asDestination) {
		          return function(results, status) {
		            if (status === 'OK') {
		              map.fitBounds(bounds.extend(results[0].geometry.location));	                 
		            } else {
		              alert('Geocode was not successful due to: ' + status);
		            }
		          };
		         };	            
		          for (var i = 0; i < originList.length; i++) {
		              var results = response.rows[i].elements;
		              geocoder.geocode({'address': originList[i]},
		                  showGeocodedAddressOnMap(false));
		              for (var j = 0; j < results.length; j++) {
		                geocoder.geocode({'address': destinationList[j]},
		                    showGeocodedAddressOnMap(false));
		                outputDiv.innerHTML += originList[i] + ' to ' + destinationList[j] +
		                    ': ' + results[j].distance.text + ' in ' + results[j].duration.text + '<br>';
		              }
		            }
		          var circle = new google.maps.Circle({
		              strokeColor: '#FF0000',
		              strokeOpacity: 0.8,
		              strokeWeight: 2,
		              fillColor: '#FF0000',
		              fillOpacity: 0.35,
		              map: map,
		              center: {lat : cog[0],lng : cog[1]  },
		              radius: Math.sqrt(30) * results[0].distance.value/20
		            });
		      }
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
    service.getDistanceMatrix({
      origins: [{lat : cog[0], lng : cog[1]}],
      destinations: [{lat: parseFloat(geos[0]), lng: parseFloat(geos[1])}],
      travelMode: 'TRANSIT',
      unitSystem: google.maps.UnitSystem.METRIC,
      avoidHighways: false,
      avoidTolls: false
    }, function(response, status) {
      if (status !== 'OK') {
        alert('Error was: ' + status);
      } else {
    	  
        var originList = response.originAddresses; // origin값 위에서 받아오기
        var destinationList = response.destinationAddresses;
        var outputDiv = document.getElementById('output');
        outputDiv.innerHTML = '';

        var showGeocodedAddressOnMap = function(asDestination) {
          return function(results, status) {
            if (status === 'OK') {
              map.fitBounds(bounds.extend(results[0].geometry.location));	                 
            } else {
              alert('Geocode was not successful due to: ' + status);
            }
          };
         };	            
          var results = response.rows[0].elements;
          alert(name + " " + results[0].distance.value);
          if(results[0].distance.value < 1000) {
       
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
    });     
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
<div id="output"></div>
</body>

</html>