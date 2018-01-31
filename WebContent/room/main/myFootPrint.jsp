<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    
<%@ include file="/common/header.jsp"%>

	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Template by FREEHTML5.CO" />
	<meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
	<meta name="author" content="FREEHTML5.CO" />
	
	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">	
	<!-- Animate.css -->
	<link rel="stylesheet" href="css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="css/icomoon.css">	
	<!-- Magnific Popup -->
	<link rel="stylesheet" href="css/magnific-popup.css">
	<!-- Salvattore -->
	<link rel="stylesheet" href="css/salvattore.css">	
	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	
    <style>

			#fh5co-main {
			  padding-top: 5em;
			}
			
			#fh5co-board .item {
			  margin: 10px 10px 20px 10px;
			  background: #fff;
			  -webkit-border-radius: 4px;
			  -moz-border-radius: 4px;
			  -ms-border-radius: 4px;
			  border-radius: 4px;
			  overflow: hidden;
			  -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, 0.07);
			  -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, 0.07);
			  box-shadow: 0 1px 2px rgba(0, 0, 0, 0.07);
			}
			#fh5co-board .item a {
			  display: block;
			}
			#fh5co-board .item .fh5co-desc {
			  padding: 20px;
			  float: left;
			  line-height: 24px;
			}
			#fh5co-board .item .fh5co-item-title {
			  font-family: "Montserrat", arial, sans-serif;
			  font-size: 17px;
			  line-height: 24px;
			  margin: 0;
			  padding: 0;
			}
			#fh5co-board .item img {
			  max-width: 100%;
			  -webkit-transition: 0.2s;
			  -o-transition: 0.2s;
			  transition: 0.2s;
			}
			#fh5co-board .item .fh5co-board-img {
			  border-top-left-radius: 4px;
			  border-top-right-radius: 4px;
			  border-bottom-left-radius: 4px;
			  border-bottom-right-radius: 4px;
			  overflow: hidden;
			}
			#fh5co-board .item .image-popup:hover img {
			  opacity: .5;
			  
			  
			}
			 a:link { color: black; text-decoration: none;}
			 a:visited { color: black; text-decoration: none;}
			 a:hover { color: blue; text-decoration: underline;}


    </style>
  </head>
<%
	String name = "5";
%>

<div id="fh5co-main">
		
		<div class="container" style = "margin-top: 3%;margin-bottom: 5%" >
		<div class = "row" style = "margin-bottom: 3%" >
			<button type="button" class="btn btn-primary btn-lg" >지역</button>
			<form class="form-inline my-2 my-lg-0" style = " margin-left : 5%">
                  <input class="form-control form-control-lg" type="text" id="inputLarge">
		      <!-- <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button> 얜 나중에 엔터로 처리할 거-->
			</form>

		</div>
			<div align = "center"><h1><b>STUDIUM</b></h1></div>
			<br>
			<br>
			<div class="row">

        <div id="fh5co-board" data-columns>
             	<div class="item">
		        		<div class="animate-box">		        		
					        	<a href="../images/img_1.jpg" class="image-popup fh5co-board-img" title="이미지 타이틀이 들어갈 자리">
					        		<img src="../images/img_1.jpg" alt="Free HTML5 Bootstrap template">				        			
					        	</a>
			        	</div>
			        	<a href="<%=root %>/room/reservation/roomReservation.jsp">			        	
			        	<div class="fh5co-desc">
			        		이미지 설명이 들어가야 합니다 여기다 링크도 걸 거임
		        		</div>  
		        		</a>
	        		    		   
        		</div> 
        	
        	<div class="item">
        		<div class="animate-box">
	        		<a href="../images/img_2.jpg" class="image-popup fh5co-board-img" title="Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?">
	        		<img src="../images/img_2.jpg" alt="Free HTML5 Bootstrap template">
	        		</a>
        		</div>
        		<div align="right" style = "margin-right : 2%;"><button type="button" class="btn btn-sm btn-link"><i class="material-icons" style="font-size:25px; color : red">pets</i></button></div>
        		<div class="fh5co-desc col-9">발자국은 이런식으로</div>
        	</div>
        	
        	<div class="item">
        		<div class="animate-box">
	        		<a href="../images/img_3.jpg" class="image-popup fh5co-board-img" title="Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?">
	        		<img src="../images/img_3.jpg" alt="Free HTML5 Bootstrap template">
	        		</a>
        		</div>
        		<div class="fh5co-desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?</div>
        	</div>
        	
        	<div class="item">
        		<div class="animate-box">
	        		<a href="../images/img_4.jpg" class="image-popup fh5co-board-img" title="Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?">
	        		<img src="../images/img_4.jpg" alt="Free HTML5 Bootstrap template">
	        		</a>
        		</div>
        		<div class="fh5co-desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?</div>
        	</div>
        	
        	<div class="item">
        		<div class="animate-box">
	        		<a href="../images/img_5.jpg" class="image-popup fh5co-board-img" title="Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?">
	        		<img src="../images/img_5.jpg" alt="Free HTML5 Bootstrap template">
	        		</a>
        		</div>
        		<div class="fh5co-desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?</div>
        	</div>
        	
        	<div class="item">
        		<div class="animate-box">
	        		<a href="../images/img_6.jpg" class="image-popup fh5co-board-img" title="Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?">
	        		<img src="../images/img_6.jpg" alt="Free HTML5 Bootstrap template">
	        		</a>
        		</div>
        		<div class="fh5co-desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?</div>
        	</div>
        	
        	<div class="item">
        		<div class="animate-box">
	        		<a href="../images/img_7.jpg" class="image-popup fh5co-board-img" title="Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?">
	        		<img src="../images/img_7.jpg" alt="Free HTML5 Bootstrap template">
	        		</a>
        		</div>
        		<div class="fh5co-desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?</div>
        	</div>
        	
        	<div class="item">
        		<div class="animate-box">
	        		<a href="../images/img_8.jpg" class="image-popup fh5co-board-img" title="Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?">
	        		<img src="../images/img_8.jpg" alt="Free HTML5 Bootstrap template">
	        		</a>
        		</div>
        		<div class="fh5co-desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?</div>
        	</div>
        	<div class="item">
        		<div class="animate-box">
	        		<a href="../images/img_9.jpg" class="image-popup fh5co-board-img" title="Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?">
	        		<img src="../images/img_9.jpg" alt="Free HTML5 Bootstrap template">
	        		</a>
        		</div>
        		<div class="fh5co-desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?</div>
        	</div>
        	<div class="item">
        		<div class="animate-box">
	        		<a href="../images/img_10.jpg" class="image-popup fh5co-board-img" title="Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?">
	        		<img src="../images/img_10.jpg" alt="Free HTML5 Bootstrap template">
	        		</a>
        		</div>
        		<div class="fh5co-desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?</div>
        	</div>
        	<div class="item">
        		<div class="animate-box">
	        		<a href="../images/img_11.jpg" class="image-popup fh5co-board-img" title="Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?">
	        		<img src="../images/img_11.jpg" alt="Free HTML5 Bootstrap template">
	        		</a>
        		</div>
        		<div class="fh5co-desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?</div>
        	</div>
        	<div class="item">
        		<div class="animate-box">
	        		<a href="../images/img_12.jpg" class="image-popup fh5co-board-img" title="Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?">
	        		<img src="../images/img_12.jpg" alt="Free HTML5 Bootstrap template">
	        		</a>
        		</div>
        		<div class="fh5co-desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?</div>
        	</div>
        	<div class="item">
        		<div class="animate-box">
	        		<a href="../images/img_13.jpg" class="image-popup fh5co-board-img" title="Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?">
	        		<img src="../images/img_13.jpg" alt="Free HTML5 Bootstrap template">
	        		</a>
        		</div>
        		<div class="fh5co-desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?</div>
        	</div>
        	<div class="item">
        		<div class="animate-box">
	        		<a href="../images/img_14.jpg" class="image-popup fh5co-board-img" title="Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?">
	        		<img src="../images/img_14.jpg" alt="Free HTML5 Bootstrap template">
	        		</a>
        		</div>
        		<div class="fh5co-desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?</div>
        	</div>

        	<div class="item">
        		<div class="animate-box">
	        		<a href="../images/img_1.jpg" class="image-popup fh5co-board-img" title="Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?">
	        		<img src="../images/img_1.jpg" alt="Free HTML5 Bootstrap template">
	        		</a>
        		</div>
        		<div class="fh5co-desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?</div>
        	</div>
        	
        	<div class="item">
        		<div class="animate-box">
	        		<a href="../images/img_2.jpg" class="image-popup fh5co-board-img" title="Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?">
	        		<img src="../images/img_2.jpg" alt="Free HTML5 Bootstrap template">
	        		</a>
        		</div>
        		<div class="fh5co-desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?</div>
        	</div>
        	
        	<div class="item">
        		<div class="animate-box">
	        		<a href="../images/img_3.jpg" class="image-popup fh5co-board-img" title="Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?">
	        		<img src="../images/img_3.jpg" alt="Free HTML5 Bootstrap template">
	        		</a>
        		</div>
        		<div class="fh5co-desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?</div>
        	</div>
        	
        	<div class="item">
        		<div class="animate-box">
	        		<a href="../images/img_4.jpg" class="image-popup fh5co-board-img" title="Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?">
	        		<img src="../images/img_4.jpg" alt="Free HTML5 Bootstrap template">
	        		</a>
        		</div>
        		<div class="fh5co-desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?</div>
        	</div>
        	
        	<div class="item">
        		<div class="animate-box">
	        		<a href="../images/img_5.jpg" class="image-popup fh5co-board-img" title="Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?">
	        		<img src="../images/img_5.jpg" alt="Free HTML5 Bootstrap template">
	        		</a>
        		</div>
        		<div class="fh5co-desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?</div>
        	</div>
        	
        	<div class="item">
        		<div class="animate-box">
	        		<a href="../images/img_6.jpg" class="image-popup fh5co-board-img" title="Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?">
	        		<img src="../images/img_6.jpg" alt="Free HTML5 Bootstrap template">
	        		</a>
        		</div>
        		<div class="fh5co-desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?</div>
        	</div>
        	
        	<div class="item">
        		<div class="animate-box">
	        		<a href="../images/img_7.jpg" class="image-popup fh5co-board-img" title="Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?">
	        		<img src="../images/img_7.jpg" alt="Free HTML5 Bootstrap template">
	        		</a>
        		</div>
        		<div class="fh5co-desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?</div>
        	</div>
        	
        	<div class="item">
        		<div class="animate-box">
	        		<a href="../images/img_8.jpg" class="image-popup fh5co-board-img" title="Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?">
	        		<img src="../images/img_8.jpg" alt="Free HTML5 Bootstrap template">
	        		</a>
        		</div>
        		<div class="fh5co-desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?</div>
        	</div>
        	<div class="item">
        		<div class="animate-box">
	        		<a href="../images/img_9.jpg" class="image-popup fh5co-board-img" title="Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?">
	        		<img src="../images/img_9.jpg" alt="Free HTML5 Bootstrap template">
	        		</a>
        		</div>
        		<div class="fh5co-desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?</div>
        	</div>
        	<div class="item">
        		<div class="animate-box">
	        		<a href="../images/img_10.jpg" class="image-popup fh5co-board-img" title="Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?">
	        		<img src="../images/img_10.jpg" alt="Free HTML5 Bootstrap template">
	        		</a>
        		</div>
        		<div class="fh5co-desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?</div>
        	</div>
        	<div class="item">
        		<div class="animate-box">
	        		<a href="../images/img_11.jpg" class="image-popup fh5co-board-img" title="Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?">
	        		<img src="../images/img_11.jpg" alt="Free HTML5 Bootstrap template">
	        		</a>
        		</div>
        		<div class="fh5co-desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?</div>
        	</div>
        	<div class="item">
        		<div class="animate-box">
	        		<a href="../images/img_12.jpg" class="image-popup fh5co-board-img" title="Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?">
	        		<img src="../images/img_12.jpg" alt="Free HTML5 Bootstrap template">
	        		</a>
        		</div>
        		<div class="fh5co-desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?</div>
        	</div>
        	<div class="item">
        		<div class="animate-box">
	        		<a href="../images/img_13.jpg" class="image-popup fh5co-board-img" title="Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?">
	        		<img src="../images/img_13.jpg" alt="Free HTML5 Bootstrap template">
	        		</a>
        		</div>
        		<div class="fh5co-desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?</div>
        	</div>
        	<div class="item">
        		<div class="animate-box">
	        		<a href="../images/img_14.jpg" class="image-popup fh5co-board-img" title="Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?">
	        		<img src="../images/img_14.jpg" alt="Free HTML5 Bootstrap template">
	        		</a>
        		</div>
        		<div class="fh5co-desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?</div>
        	</div>
 
        </div>
        </div>
       </div>
	</div>
	
	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Magnific Popup -->
	<script src="js/jquery.magnific-popup.min.js"></script>
	<!-- Salvattore -->
	<script src="js/salvattore.min.js"></script>
	<!-- Main JS -->
	<script src="js/main.js"></script>
	
<%@ include file="/common/footer.jsp"%>