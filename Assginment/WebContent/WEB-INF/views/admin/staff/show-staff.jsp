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
	<h4>
		<i class="fa fa-angle-right"></i> Quản lý Nhân Viên
	</h4>
	<a style="text-decoration: none; color: red;">${message}</a>
	
	<div>
		<table border="1" class="user">
			<tr>
				<th>ID</th>
				<th>Họ Và Tên</th>
				<th>Giới Tính</th>
				<th>Ngày Sinh</th>
				<th>Ảnh</th>
				<th>Email</th>
				<th>Số Điện Thoại</th>
				<th>Lương</th>
				<th>Ghi Chú</th>
				<th>Phòng Ban</th>
				<th>Cập Nhật</th>
				<th>Xóa</th>
			</tr>
			<c:forEach var="s" items="${staffs}">
				<tr>
					<td>${s.id} <input type="hidden" id="txtid"
								value="${s.id}"></td>
					<td>${s.name}</td>
					<td>${s.gender?'Nam':'Nữ'}</td>
					<td>${s.birthday}</td>
					<td><img src="img/${s.photo}"
						style="height: 50px; width: 50px;"></td>
					<td>${s.email}</td>
					<td>${s.phone}</td>
					<td>${s.salary}</td>
					<td>${s.notes}</td>
					<td>${s.depart.name}</td>
					<td><a href="admin/staff/update/${s.id}.htm" id="btnupdate">Update</a></td>
					<td><a href="admin/staff/delete/${s.id}.htm" id="delete">Xóa</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>