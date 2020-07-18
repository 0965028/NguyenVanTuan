<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.servletContext.contextPath}/">
	<meta charset="utf-8" />
	<title>Java5</title>
</head>
<body>
<a style="text-decoration: none; color: red;">${message}</a>
	<form action="admin/mailer/send.htm" method="post">
		<table>
			<tr>
				<td>Người gửi: </td>
				<td><input name="from" placeholder="From" size="25"></td>
			</tr>
			<tr>
				<td>Người Nhận: </td>
				<td><input name="to" placeholder="To" size="25"></td>
			</tr>
			<tr>
				<td>Tiêu đề: </td>
				<td><input name="subject" placeholder="Subject" size="25"></td>
			</tr>
			<tr>
				<td>Nội dung:</td>
				<td><textarea name="body" placeholder="Body" rows="3" cols="30"></textarea></td>
			</tr>
		</table>
		<br>
		<button name="send">Send</button>
	</form>
</body>
</html>