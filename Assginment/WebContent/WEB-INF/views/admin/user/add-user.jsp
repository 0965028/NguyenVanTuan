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
				<form:form action="admin/user/insert.htm" modelAttribute="user">
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
								<form:input type="text" path="Fullname" id="name"/>
								<i class="fa fa-user login-user" aria-hidden="true"></i>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-4">
							<div class="login-input-head">
								<p>Vai Trò</p>
							</div>
						</div>
						<div class="col-lg-8">
							<div class="interested-input-area">
								<form:select path="role">
									<option value="none" selected="" disabled="" id="role">Vai Trò</option>
									<option value="admin" id="admin">Admin</option>
									<option value="user"  id="users">User</option>
								</form:select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-4"></div>
						<div class="col-lg-8">
							<div class="login-button-pro">
								<button type="submit" name="_type"
									class="login-button login-button-lg" id="btnadd">Thêm Người Dùng</button>
							</div>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>

</body>
</html>