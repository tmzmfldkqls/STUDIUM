<%@page import="com.st.util.PageMove"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
		<!-- The content of your page would go here. -->
<%
} else {
	PageMove.redirect(request, response, "/main/login.jsp");
}
%>	

		<footer class="footer-distributed">

			<div class="footer-left">

				<h3>STUDIUM</h3>

				<p class="footer-links">
					<a href="#">Home</a>
					¡¤
					<a href="#">Pricing</a>
					¡¤
					<a href="#">About</a>
					¡¤
					<a href="#">Contact</a>
				</p>

				<p class="footer-company-name">STUDIUM &copy; 2017</p>

				<div class="footer-icons">

					<a href="#"><i class="fa fa-facebook"></i></a>
					<a href="#"><i class="fa fa-twitter"></i></a>
					<a href="#"><i class="fa fa-linkedin"></i></a>
					<a href="#"><i class="fa fa-github"></i></a>

				</div>

			</div>

			<div class="footer-right">

				<p>Contact Us</p>

        			<iframe width="100%" height="300" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://www.google.com/maps/embed/v1/place?q=place_id:ChIJgQ9QxjqefDUReiLiaf40Emk&key=AIzaSyBHZOxnko-vcXIzz7KmWTJ0n9_dtQGBSks"></iframe>
    	</div>
 
		</footer>

	</body>

</html>
