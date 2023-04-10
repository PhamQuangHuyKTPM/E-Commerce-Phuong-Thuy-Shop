<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Thêm mới sản phẩm</title>
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
				<h2 align="center">Thêm mới sản phẩm</h2>

				<form action="crud?status=add" method="post" class="mt-5">
					<div class="form-floating mt-3 mb-3">
						<input type="text" class="form-control" id="pwd"
							placeholder="Enter password" name="tensp"> <label
							for="pwd">Tên sản phẩm</label>
					</div>
					<div class="form-floating mt-3 mb-3">
						<input type="text" class="form-control" id="pwd"
							placeholder="Enter password" name="image" value="${p.image }"> <label
							for="pwd">Ảnh</label>
					</div>
					<div class="form-floating mt-3 mb-3">
						<input type="text" class="form-control" id="pwd"
							placeholder="Enter password" name="mota" > <label
							for="pwd">Mô tả</label>
					</div>
					<div class="form-floating mt-3 mb-3">
						<input type="text" class="form-control" id="pwd"
							placeholder="Enter password" name="dongia"> <label
							for="pwd" >Đơn giá</label>
					</div>
					<select class="form-select" name="danhmuc">
						<c:forEach var="categories" items="${categories }">
						<option>${categories.ten }</option>
						</c:forEach>
					</select>
					<div class="form-floating mt-3 mb-3">
						<input type="number" class="form-control" id="pwd"
							placeholder="Enter password" name="soluong" min=1> <label
							for="pwd">Số lượng</label>
					</div>
					<button type="submit" class="btn btn-primary">Thêm mới</button>
				</form>
			</div>

		</div>
	</div>
</html>