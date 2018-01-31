<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.st.member.model.MemberDto,com.st.util.PageMove"%>

<%@ include file="/common/header.jsp" %>
<style>
body {
  padding-top: 54px;
}

@media (min-width: 992px) {
  body {
    padding-top: 56px;
  }
}

.carousel-item {
  height: 65vh;
  min-height: 300px;
  background: no-repeat center center scroll;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}

</style>
<%
 String status = request.getParameter("status");
%>
<script type="text/javascript">
function roomSearch() {
	window.open("<%=root%>/member?act=mvroomsearch", "roomsearchform", "width=800, height=500, top=200, left=200, location=no, status=no, titlebar=no, toolbar=no, resizable=no, scrollbars=yes");
}
</script>
  <div class="text-center opaque-overlay" >
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
         
         <div class="carousel-inner" role="listbox" style="height:100%">
         
          <!-- Slide One - Set the background image for this slide in the line below -->
          <div class="carousel-item active" style="background-image: url('<%= root %>/img/study.jpg'); background-size: 1900px 500px;">
            <div class="carousel-caption d-none d-md-block"></div>
          </div>          
         
          <!-- Slide Two - Set the background image for this slide in the line below -->
          <div class="carousel-item" style="background-image: url('<%= root %>/img/study2.jpg'); background-size: 1900px 500px;">
            <div class="carousel-caption d-none d-md-block">
            </div>
          </div>
          
          <!-- Slide Three - Set the background image for this slide in the line below -->
          <div class="carousel-item" style="background-image: url('<%= root %>/img/study2.jpg'); background-size: 1900px 500px;">
            <div class="carousel-caption d-none d-md-block"></div>          
          </div>
          
        </div>
          <h3 style="color:#000000;">저희 STUDIUM에서는</h3>
          <p style="color:#000000;">전국의 스터디룸을 한눈에 보실수 있습니다. </p>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>
  </div>
    <div class="row p-4 m-4 justify-content-lg-center">
        <div class="col-lg-3 col-sm-6 portfolio-item">
          <div class="card h-100">
            <div>
            <a href="#"><img class="card-img-top" src="<%= root	%>/img/reservation.jpg" alt="" ></a>
            </div>
            <div class="card-body">
            <div>
              <h4 class="card-title">
              	스터디룸 예약
              </h4>            
              <p class="card-text">모든 스터디룸을 보시려면 ENTER를 누르세요!</p>               
              <p class="card-text" ">구성원의 주소를 통해서 가장 합리적인 스터디룸을 검색하고 싶다면 검색을 누르세요!</p>
              </div>
              <div style="margin-top:10px;" align="center">
              <a href="<%= root %>/studyroom?act=rmain"><button type="button" class="btn btn-secondary">ENTER</button></a>
              <button type="button" class="btn btn-secondary" onclick="javascript:roomSearch();">검색</button>
              </div>
            </div>
          </div>
        </div>
        <div class="col-lg-3 col-sm-6 portfolio-item">
          <div class="card h-100">
          <div>
          <a href="#"><img class="card-img-top" src="<%= root%>/img/roomregi.JPG" alt="" style="height:250px;"></a>
          </div>
          <div>
            <div class="card-body">
              <h4 class="card-title">
                               스터디룸 등록
              </h4>
              <p class="card-text">스터디룸을 등록하시려면 ENTER를 누르세요!</p>
              <p class="card-text">저희 STUDIUM의 예약시스템도 이용하실 수 있습니다.</p>
              </div>
            
              <div style="margin:12px;" align="center">
              <a href="<%= root %>/studyroom?act=mvroomrgst"><button type="button" class="btn btn-secondary">ENTER</button></a>
           	</div>
            </div>
          </div>
        </div>
        <div class="col-lg-3 col-sm-6 portfolio-item">
          <div class="card h-100">
          <div>
            <a href="#"><img class="card-img-top " src="<%= root%>/img/studygroup.jpg" alt=""></a>
            </div>
            <div class="card-body">
              <div>
              <h4 class="card-title">
               	스터디그룹
              </h4>
              <p class="card-text">스터디그룹에 어서오세요~</p>
              <p class="card-text">다양한 스터디그룹을 HASHTAG로 손쉽게 볼 수 있습니다.</p>
               </div>
               <div style="margin-top:45px;" align="center">
               <a href="<%=root%>/stgcontroll?act=mvgroup&pg=1"><button type="button" class="btn btn-secondary">ENTER</button></a>
            </div>
            </div>
          </div>
        </div>
      </div>  

  
<%@ include file="/common/footer.jsp" %>