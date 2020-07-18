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
				style="width: 584px; height: 770px; margin-top: 40px; margin-left: 320px;">
				<div class="row">
					<div class="col-lg-12">
						<div class="login-title">
							<h3>Sửa Thông Tin Người Dùng</h3>
						</div>
					</div>
				</div>
				<a style="text-decoration: none; color: red;">${message}</a>
				<form:form action="admin/staff/updatestaff.htm"
					modelAttribute="staff" method="post">
					<label>ID:</label>
					<form:input path="Id" cssClass="form-control" />
					<label>Tên</label>
					<form:input path="Name" cssClass="form-control"
						style="width=1000px;" id="name"/>
					<label>Giới tính:</label>
					<br>
					<div class="custom-control custom-radio custom-control-inline">
						<form:radiobutton class="custom-control-input" id="customRadio1"
							path="Gender" value="true" />
						<label class="custom-control-label" for="customRadio1">Nam</label>
					</div>
					<div class="custom-control custom-radio custom-control-inline">
						<form:radiobutton class="custom-control-input" id="customRadio2"
							path="Gender" value="false" />
						<label class="custom-control-label" for="customRadio2">Nữ</label>
					</div>
					<label>Ảnh:</label>
					<form:input type="file" path="Photo" id="images"/>
					<label>Ngày sinh:</label>
					<form:input type="date" path="Birthday" cssClass="form-control" id="birthday"/>
					<label>Email:</label>
					<form:input path="Email" cssClass="form-control" id="email"/>
					<label>SĐT:</label>
					<form:input path="Phone" cssClass="form-control" id="phone"/>
					<label>Lương:</label>
					<form:input path="Salary" cssClass="form-control" id="salary"/>
					<label>Ghi chú:</label>
					<form:input path="Notes" cssClass="form-control" id="notes"/>
					<label>Phòng ban:</label>
					<form:select path="depart.Id" cssClass="form-control"
						items="${listdepart}" itemValue="Id" itemLabel="Name"  id="depart"/>
					<button type="submit" class="btn btn-primary"
						style="margin-left: 600px; margin-top: 30px" id="save">Lưu</button>
				</form:form>
			</div>
		</div>
	</div>

</body>
</html>