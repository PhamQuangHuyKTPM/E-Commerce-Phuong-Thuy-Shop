<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>admin</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!--  <link rel="stylesheet" href="venobox/venobox.min.css" media="screen"> -->
<link rel="stylesheet"
	href="<c:url value='./template/admin/style.css' />">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>

	<div class="container-fluid">
		<div class="column-main column-left nav flex-column text-white">

			<!-- Vertical menu  -->
			<%@include file="/common/admin/vertical_menu.jsp"%>
			<!-- End vertical menu -->
		</div>
		<div class="column-main column-right">

			<!-- Header -->
			<%@include file="/common/admin/header.jsp"%>
			<!-- End header -->

			<div class="container mt-5" style="width: 70%">
				<h2 align="center">Đổi mật khẩu</h2>
				
				<c:if test="${passwordFalse == true }">
					<div class="alert alert-danger">
						<strong>Lỗi!</strong> Mật khẩu không đúng, yêu cầu nhập lại
					</div>
				</c:if>
				<c:if test="${confirmFalse == true }">
					<div class="alert alert-danger">
						<strong>Lỗi!</strong> Mật khẩu mới và mật khẩu xác nhận phải trùng nhau, yêu cầu nhập lại
					</div>
				</c:if>
				<c:if test="${passwordSuccess == true }">
					<div class="alert alert-info">
						<strong>Thành công!</strong> Bạn đã đổi mật khẩu thành công
					</div>
				</c:if>
				<form action="crud?status=doimk" method="post" class="mt-5">
					<input type="hidden" value="${manager.id_user }" name="id" />
					<div class="form-floating mb-3 mt-3">
						<input type="text" class="form-control" id="email"
							placeholder="Enter email" name="username"
							value="${manager.hoten }" disabled> <label for="email">Họ tên</label>
					</div>
					<div class="form-floating mb-3 mt-3">
						<input type="text" class="form-control" id="email"
							placeholder="Enter email" name="username"
							value="${manager.username }" disabled> <label for="email">Username</label>
					</div>
					<div class="form-floating mt-3 mb-3">
						<input type="text" class="form-control" id="pwd"
							placeholder="Enter password" name="password"> <label
							for="pwd">Password</label>
					</div>
					<div class="form-floating mt-3 mb-3">
						<input type="text" class="form-control" id="pwd"
							placeholder="Enter password" name="password-new"> <label
							for="pwd">New password</label>
					</div>
					<div class="form-floating mt-3 mb-3">
						<input type="text" class="form-control" id="pwd"
							placeholder="Enter password" name="confirm"> <label
							for="pwd">Confirm password</label>
					</div>
					<button type="submit" class="btn btn-primary">Lưu</button>
				</form>
			</div>

		</div>
	</div>
</html>