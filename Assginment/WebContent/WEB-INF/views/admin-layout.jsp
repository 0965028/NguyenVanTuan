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
<title>Trang Quản Lý</title>
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
				<ul class="nav pull-left top-menu">
					<li><a href="#" data-lang="en" class="logo"
						style="margin-left: 78px; color: white;">English</a></li>
				</ul>
			</div>
			<div class="top-menu">
				<ul class="nav pull-left top-menu">
					<li><a href="#" data-lang="vi" class="logo"
						style="color: white;">Tiếng Việt</a></li>
				</ul>
			</div>
			<div class="top-menu">
				<ul class="nav pull-right top-menu">
					<li><a class="logout" href="home/index/login.htm" id="logout">Logout</a></li>
				</ul>
			</div>
			<div class="top-menu">
				<ul class="nav pull-right top-menu">
					<li><a class="logout" href="home/index/login.htm" id="login">Login</a></li>
				</ul>
			</div>			
		</header>		
		<aside>
			<div id="sidebar" class="nav-collapse ">
				<!-- sidebar menu start-->
				<ul class="sidebar-menu" id="nav-accordion">
					<p class="centered">
						<a href="#"><img src="img/logo.jpg"
							class="img-circle" width="80"></a>
					</p>
					<h5 class="centered">NVT</h5>
					<li class="sub-menu"><a href="admin/top10/showtop10.htm"> <i
							class="fa fa-desktop"></i> <span><s:message code="global.menu.company"/></span>
					</a>

					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-tasks"></i> <span><s:message code="global.menu.acc"/></span>
					</a>
						<ul class="sub">
							<li><a href="admin/user/show.htm">Quản Lý Người Dùng</a></li>
							<li><a href="admin/user/adduser.htm">Thêm Mới Người Dùng</a></li>					
						</ul></li>
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-tasks"></i> <span id="nhanvien"><s:message code="global.menu.staff"/></span>
					</a>
						<ul class="sub">
							<li><a href="admin/staff/showstaff.htm" id="quanlynv">Quản Lý Nhân
									Viên</a></li>
							<li><a href="admin/staff/addstaff.htm">Thêm Mới Nhân
									Viên</a></li>
						</ul></li>
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-tasks"></i> <span><s:message code="global.menu.dep"/></span>
					</a>
						<ul class="sub">
							<li><a href="admin/depart/showdepart.htm">Quản Lý Phòng
									Ban</a></li>
							<li><a href="admin/depart/adddepart.htm">Thêm Mới
									Phòng Ban</a></li>
						</ul></li>
					<li><a id="mail" href="admin/mailer/form.htm"> <i
							class="fa fa-envelope"></i> <span>Mail </span> <span
							class="label label-theme pull-right mail-info">3</span>
					</a></li>
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-comments-o"></i> <span><s:message code="global.menu.a&d"/></span>
					</a>
						<ul class="sub">
							<li><a href="admin/record/showrecord.htm">Quản Lý Đánh
									Giá</a></li>
							<li><a href="admin/record/addrecord.htm">Thêm Mới Đánh Giá</a></li>
						</ul></li>
					<li class="sub-menu"><a href="javascript:;"> <i
							class=" fa fa-bar-chart-o"></i> <span><s:message code="global.menu.sta"/></span>
					</a>
						<ul class="sub">
							<li><a href="admin/thongke/CaNhan.htm">Tổng hợp thành
									tích cá nhân</a></li>
							<li><a href="admin/thongke/CaPhong.htm">Tổng hợp thành
									tích room</a></li>
						</ul></li>
				</ul>
			</div>		
		</aside>
		<section id="main-content">		
			<section class="wrapper site-min-height">
				<!-- page start-->
				<div class="row " style="padding: 20px;">
					<div>
						<jsp:include page="${param.view}" />
					</div>

				</div>
			</section>
		</section>
		<footer class="site-footer">
			<div class="text-center">
				<p>
					&copy; Copyrights <strong>Java5</strong>. All Rights Reserved
				</p>
				<div class="credits">
					Created with Dashio template by <a href="#">TemplateMag</a>
				</div>
				<a href="xchart.html#" class="go-top"> <i class="fa fa-angle-up"></i>
				</a>
			</div>
		</footer>
	</section>
	<script src="lib/jquery/jquery.min.js"></script>
	<script src="lib/bootstrap/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="lib/jquery.dcjqaccordion.2.7.js"></script>
	<script src="lib/jquery.scrollTo.min.js"></script>
	<script src="lib/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="lib/common-scripts.js"></script>
</body>
<script>
$(function(){
	$("a[data-lang]").click(function(){
		var lang = $(this).attr("data-lang");
		$.get("home/index.htm?language="+ lang, function(){
			location.reload();
		});
		return false;
	});
});
</script>
</html>
