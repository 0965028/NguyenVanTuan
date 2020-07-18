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
				style="width: 584px; height: 430px; margin-top: 40px; margin-left: 320px;">
				<div class="row">
					<div class="col-lg-12">
						<div class="login-title">
							<h3>THÊM NGƯỜI DÙNG</h3>
						</div>
					</div>
				</div>
				<p>${message}</p>
				<form:form action="admin/user/update.htm" modelAttribute="user">
					<div class="row">
						<div class="col-lg-4">
							<div class="login-input-head">
								<p>Tên Tài Khoản</p>
							</div>
						</div>
						<div class="col-lg-8">
							<div class="login-input-area">
								<form:input type="text" path="Username" />
								<i class="fa fa-user login-user" aria-hidden="true"></i>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-4">
							<div class="login-input-head">
								<p>Mật Khẩu</p>
							</div>
						</div>
						<div class="col-lg-8">
							<div class="login-input-area">
								<form:input type="text" path="Password" />
								<i class="fa fa-user login-user" aria-hidden="true"></i>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-4">
							<div class="login-input-head">
								<p>Họ Tên</p>
							</div>
						</div>
						<div class="col-lg-8">
							<div class="login-input-area">
								<form:input type="text" path="Fullname" />
								<i class="fa fa-user login-user" aria-hidden="true"></i>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-4">
							<div class="login-input-head">
								<p>Vai trò</p>
							</div>
						</div>
						<div class="custom-control custom-radio custom-control-inline">
							<form:radiobutton class="custom-control-input" id="customRadio1"
								path="role" value="admin" style="margin-left: 14px;" />
							<label class="custom-control-label" for="customRadio1">Admin</label>
						</div>
						<div class="custom-control custom-radio custom-control-inline">
							<form:radiobutton class="custom-control-input" id="customRadio2"
								path="role" value="user" style="margin-left: 14px; " />
							<label class="custom-control-label" for="customRadio2">User</label>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-4"></div>
						<div class="col-lg-8">
							<div class="login-button-pro">
								<button type="submit" name="_type"
									class="login-button login-button-lg">Cập Nhật</button>
							</div>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>