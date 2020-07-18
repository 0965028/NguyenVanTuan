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
<h4><i class="fa fa-angle-right"></i> Quản lý người dùng</h4>
		<a style="text-decoration: none; color: red;">${message}</a>
				<div>
					<table border="1" class="user">
						<tr>
							<th>Tên Đăng Nhập</th>
							<th>Mật Khẩu</th>
							<th>Họ Tên</th>
							<th>Vai Trò</th>
							<th>Cập Nhật</th>
							<th>Xóa</th>
						</tr>
						<c:forEach var="u" items="${users}">
							<tr>
								<td>${u.username}</td>
								<td>${u.password}</td>
								<td>${u.fullname}</td>
								<td>${u.role}</td>
								<td><a href="admin/user/update/${u.username}.htm" id="btnupdate">Update</a></td>
								<td><a href="admin/user/delete/${u.username}.htm" id="delete">Xóa</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
	
</body>
</html>