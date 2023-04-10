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
				<h2 align="center">Chỉnh sửa danh mục sản phẩm</h2>

				<form action="category?status=update" method="post" class="mt-5">
					<div class="form-floating mb-3 mt-3">
						<input type="hidden" class="form-control" id="email"
							placeholder="Enter email" value="${category.id }" name="id"> <label
							for="email">Mã sản phẩm</label>
					</div>
					<div class="form-floating mb-3 mt-3">
						<input type="text" class="form-control" id="email"
							placeholder="Enter email" value="${category.image }" name="image"> <label
							for="email">Ảnh danh mục</label>
					</div>
					<div class="form-floating mt-3 mb-3">
						<input type="text" class="form-control" id="pwd"
							placeholder="Enter password" name="ten" value="${category.ten }"> <label
							for="pwd">Tên danh mục</label>
					</div>
					<button type="submit" class="btn btn-primary">Chỉnh sửa</button>
				</form>
			</div>

		</div>
	</div>
</html>