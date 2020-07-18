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
<h4><i class="fa fa-angle-right"></i> Quản lý phòng ban</h4>
<a style="text-decoration: none; color: red;">${message}</a>
	<table border="1" class="user">
					<tr>
						<th>ID</th>
						<th>Tên Phòng Ban</th>
						<th>Cập Nhật</th>
						<th>Xóa</th>
					</tr>
					<c:forEach var="d" items="${departs}">
						<tr>
							<td>${d.id}</td>
							<td>${d.name}</td>
							<td><a href="admin/depart/updatedepart/${d.id}.htm">Update</a></td>
							<td><a href="admin/depart/deletedepart/${d.id}.htm" id="delete">Xóa</a></td>
						</tr>
					</c:forEach>
				</table>
</body>
</html>