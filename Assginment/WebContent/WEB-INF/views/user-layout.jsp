<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.servletContext.contextPath}/">
<meta charset="utf-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<title>Assigment - Java5</title>
<!-- Favicons -->
<link href="img/favicon.png" rel="icon">
<link href="img/apple-touch-icon.png" rel="apple-touch-icon">
<!-- Bootstrap core CSS -->
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!--external css-->
<link href="lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" href="lib/xchart/xcharts.css">
<!-- Custom styles for this template -->
<link href="css/style-responsive.css" rel="stylesheet">
<link href="css/style2.css" rel="stylesheet">
<link href="css/style3.css" rel="stylesheet">
<script src="js/jquery-1.10.2.min.js"></script>
</head>
<body>
<section id="container">
		<header class="header black-bg">
			<div class="sidebar-toggle-box">
				<div class="fa fa-bars tooltips" data-placement="right"
					data-original-title="Toggle Navigation"></div>
			</div>
			<!--logo start-->
			<a href="admin/top10/showtop10.htm" class="logo"><b>JAVA<span>5</span></b></a>
			<div class="top-menu">
				<ul class="nav pull-right top-menu">
					<li><a class="logout" href="home/index/login.htm"  id="logout">Logout</a></li>
				</ul>
			</div>
			<div class="top-menu">
				<ul class="nav pull-right top-menu">
					<li><a class="logout" href="home/index/login.htm"  id="login">Login</a></li>
				</ul>
			</div>			
		</header>		
		
		<article>
                    <jsp:include page="${param.view}"/>
		</article>
		
	</section>
	<script src="lib/jquery/jquery.min.js"></script>
	<script src="lib/bootstrap/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="lib/jquery.dcjqaccordion.2.7.js"></script>
	<script src="lib/jquery.scrollTo.min.js"></script>
	<script src="lib/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="lib/common-scripts.js"></script>
	</div>
</body>
</html>
