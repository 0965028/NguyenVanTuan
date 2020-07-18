<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.servletContext.contextPath}/">
<meta charset="utf-8" />
<title>Java5</title>
</head>
<body>
	<div id="row">
		<div class="row">
			<div class="login-bg"
				style="width: 584px; height: 300px; margin-top: 40px; margin-left: 320px;">
				<div class="row">
					<div class="col-lg-12">
						<div class="login-title">
							<h3>THÊM PHÒNG BAN</h3>
						</div>
					</div>
				</div>
				<a style="text-decoration: none; color: red;">${message}</a>
				<form:form action="admin/depart/insertdepart.htm"
					modelAttribute="depart">
					<div class="row">
						<div class="col-lg-4">
							<div class="login-input-head">
								<p>Tên Phòng Ban</p>
							</div>
						</div>
						<div class="col-lg-8">
							<div class="login-input-area">
								<form:input type="text" path="Name" />
								<i class="fa fa-user login-user" aria-hidden="true"></i>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-4"></div>
						<div class="col-lg-8">
							<div class="login-button-pro">
								<button type="submit" name="_type"
									class="login-button login-button-lg">Thêm Phòng Ban</button>
							</div>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>