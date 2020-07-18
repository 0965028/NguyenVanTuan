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
<h4><i class="fa fa-angle-right"></i> Quản lý đánh giá</h4>
	<a style="text-decoration: none; color: red;">${message}</a>
	<div>
		<table border="1" class="user">
			<tr>
				<th>ID</th>
				<th>Tên nhân viên</th>
				<th>Loại</th>
				<th>Lí do</th>
				<th>Ngày ghi nhận</th>
				<th>Cập nhật</th>
				<th>Xóa</th>
			</tr>
			<c:forEach var="r" items="${records}">
				<tr>
					<td>${r.id}</td>
					<td>${r.staff.name}</td>
					<td>${r.type}</td>
					<td>${r.reason}</td>
					<td>${r.date}</td>
					<td><a href="admin/record/updaterecord/${r.id}.htm">Update</a></td>
					<td><a href="admin/record/delete/${r.id}.htm">Xóa</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>