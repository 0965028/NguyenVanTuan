<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
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
		Top 10 nhân viên ưu tú
	</h4>
	<p>${message}</p>
	<div>
		<table border="1" class="user">
			<tr>
				<th>Họ Và Tên</th>
				<th>Ảnh</th>
				<th>Phòng Ban</th>
			</tr>
			<c:forEach var="s" items="${staffs}">
				<tr>
					<td>${s.name}</td>
					<td><img src="img/${s.photo}"
						style="height: 50px; width: 50px;"></td>
					<td>${s.depart.name}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>