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
<h4><i class="fa fa-angle-right"></i> Tổng hợp thành tích cả phòng</h4>
			<div>
				<table border="1" class="user">
					<tr>
						<th>Phòng</th>
						<th>Tổng thành tích</th>
						<th>Tổng kỷ luật</th>
						<th>Tổng kết</th>
					</tr>
					<c:forEach var="a" items="${cp}">
						<tr>
							<td>${a[0]}</td>
							<td>${a[1] }</td>
							<td>${a[2]}</td>
							<td>${a[1] - b[2]}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
</body>
</html>