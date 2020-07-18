<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.servletContext.contextPath}/">
<meta charset="utf-8" />
<title>Login</title>
</head>
<body>
	<div id="row">
		<div class="row">
			<div class="login-bg"
				style="width: 584px; height: 322px; margin-top: 90px; margin-left: 500px;">
				<div class="row">
					<div class="col-lg-12">
						<div class="login-title">
							<h3>LOGIN</h3>
						</div>
					</div>
				</div>
				${message}
				<form action="home/index/loginuser.htm" method="post">
				<div class="row">
					<div class="col-lg-4">
						<div class="login-input-head">
							<p>Tên Tài Khoản</p>
						</div>
					</div>
					<div class="col-lg-8">
						<div class="login-input-area">
							<input type="text" name="txtUser" id="user_login" />
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
							<input type="password" name="txtPass" id="user_pass"/>
							<i class="fa fa-user login-user" aria-hidden="true"></i>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4"></div>
					<div class="col-lg-8">
						<div class="login-button-pro">
							<button type="submit" name="btnLogin"
								class="login-button login-button-lg" id="submitBtn">LOGIN</button>
						</div>
					</div>
				</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>