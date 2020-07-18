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
				style="width: 584px; height: 495px; margin-top: 40px; margin-left: 320px;">
				<div class="row">
					<div class="col-lg-12">
						<div class="login-title">
							<h3>THÊM ĐÁNH GIÁ</h3>
						</div>
					</div>
				</div>
				<a style="text-decoration: none; color: red;">${message}</a>
				<form:form action="admin/record/insertRecord.htm"
					modelAttribute="record">
					<label>Tên Nhân Viên:</label>
					<form:select path="Staff.Name" cssClass="form-control"
						items="${listStaff}" itemValue="Id" itemLabel="Name" />
					<label>Loại kỷ luật:</label>
					<br>
					<div class="custom-control custom-radio custom-control-inline">
						<form:radiobutton class="custom-control-input" id="customRadio1"
							path="Type" value="true" />
						<label class="custom-control-label" for="customRadio1">Khen thưởng</label>
					</div>
					<div class="custom-control custom-radio custom-control-inline">
						<form:radiobutton class="custom-control-input" id="customRadio2"
							path="Type" value="false" />
						<label class="custom-control-label" for="customRadio2">Kỷ luật</label>
					</div>
					<label>Ghi chú:</label>
					<form:input path="Reason" cssClass="form-control" />
					<label>Ngày Đánh Giá:</label>
					<form:input type="date" path="Date" cssClass="form-control" />
					<div class="row">
						<div class="col-lg-4"></div>
						<div class="col-lg-8">
							<div class="login-button-pro">
								<button type="submit" name="_type"
									class="login-button login-button-lg">Thêm Người Dùng</button>
							</div>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>