<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR" import="java.util.*,com.st.studyroom.model.*"%>


<%@ include file="/common/header.jsp"%>
<%
   List<Map<String, String>> list = (List<Map<String, String>>) request.getAttribute("reservationList");
%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Free HTML5 Template by FREEHTML5.CO" />
<meta name="keywords"
   content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
<meta name="author" content="FREEHTML5.CO" />

<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
<link rel="shortcut icon" href="favicon.ico">
<!-- Animate.css -->
<link rel="stylesheet" href="<%=root%>/room/main/css/animate.css">
<!-- Icomoon Icon Fonts-->
<link rel="stylesheet" href="<%=root%>/room/main/css/icomoon.css">
<!-- Magnific Popup -->
<link rel="stylesheet" href="<%=root%>/room/main/css/magnific-popup.css">
<!-- Salvattore -->
<link rel="stylesheet" href="<%=root%>/room/main/css/salvattore.css">
<!-- Modernizr JS -->
<script src="<%=root%>/room/main/js/modernizr-2.6.2.min.js"></script>

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

a:link {
   color: black;
   text-decoration: none;
}

a:visited {
   color: black;
   text-decoration: none;
}

a:hover {
   color: blue;
   text-decoration: underline;
}
</style>
<%
   String name = "6";
%>

<div id="fh5co-main" style="margin-top: 3%; margin-bottom: 5%">

   <div class="container">
      <div class="row" style="margin-bottom: 4%">
         <div class="col-12" align=center>
            <h3 class="display-3">
               <strong>My Reservation</strong>
               </h1>
         </div>
      </div>
      <%
         int size = list.size();
            if (size != 0) {
      %>

      <div class="row">
         <div id="fh5co-board" data-columns>
            <%
               int i = 0;
                     for (Map<String, String> map : list) {
            %>
            <div class="item">
               <div class="animate-box">
                  <a href="<%=root%>/room/upload/<%=map.get("sp_img")%>"
                     class="image-popup fh5co-board-img" title="이미지 타이틀이 들어갈 자리">
                     <img src="<%=root%>/room/upload/<%=map.get("sp_img")%>"
                     alt="Free HTML5 Bootstrap template">
                  </a>
               </div>
               <a
                  href="<%=root%>/mypage?act=myReservationDetail&rmrno=<%=map.get("rmrno")%>">
                  <div class="fh5co-desc">
                     <%=map.get("sp_name")%>- [<%=map.get("rm_name")%>]<br>
                     가격 :<%=map.get("rmr_price")%>원<br> 사용일자 :<%=map.get("rmr_date_in")%><br>
                     
                  </div>
               </a>
            </div>
            <%
               }
            %>
         </div>
      </div>
      <%
         } else {
      %>
      <div class="row" style="margin-bottom: 4%">
         <div class="col-12">
            <div class="card" width="100%" height="30%">
               <img class="card-img-top" src="<%=root%>/img/unable.jpg"
                  style="width: 100%">
               <div class="card-body" align=center>
                  <h1 class="card-title" align=center>
                     <strong>조회할 수 있는 예약내역이 없습니다</strong>
                  </h1>
               </div>
            </div>
         </div>
      </div>

      <%
         }
      %>
   </div>
</div>

<!-- jQuery -->
<script src="<%=root%>/room/main/js/jquery.min.js"></script>
<!-- jQuery Easing -->
<script src="<%=root%>/room/main/js/jquery.easing.1.3.js"></script>
<!-- Waypoints -->
<script src="<%=root%>/room/main/js/jquery.waypoints.min.js"></script>
<!-- Magnific Popup -->
<script src="<%=root%>/room/main/js/jquery.magnific-popup.min.js"></script>
<!-- Salvattore -->
<script src="<%=root%>/room/main/js/salvattore.min.js"></script>
<!-- Main JS -->
<script src="<%=root%>/room/main/js/main.js"></script>

<%@ include file="/common/footer.jsp"%>