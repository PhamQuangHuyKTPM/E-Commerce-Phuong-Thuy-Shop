<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Quản lý danh mục</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
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

			<div class="content-main m-4">

				<div class="container mt-3">
					<h2 align="center">Quản lý danh mục sản phẩm</h2>
					<a href="category?status=add"><button type="button"
							class="btn btn-primary mt-3">Thêm danh mục sản phẩm mới</button></a>
					<table class="table table-striped table-bordered mt-2">
						<thead>
							<tr>
								<th>Mã danh mục</th>
								<th>Ảnh danh mục</th>
								<th>Tên danh mục</th>
								<th>Options</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="categories" items="${categories }">
								<tr>
									<td>${ categories.id}</td>
									<td align="center">
										<img alt="" src="${ categories.image}" height="150px" width="250px">
									</td>
									<td>${categories.ten}</td>
									<td style=""><a href="category?status=update&id=${categories.id }"><i
											class="fa fa-pencil-square-o" id="update-options"
											aria-hidden="true" style="font-size: 22px; color: orange"></i></a>
										<a href="#"  data-bs-toggle="modal" data-bs-target="#sp_${categories.id }"> <i class="fa fa-trash"
											aria-hidden="true"
											style="font-size: 22px; color: red; margin-left: 5px"></i>
									</a>
									 <!-- The Modal -->
										<div class="modal" id="sp_${categories.id }">
											<div class="modal-dialog">
												<div class="modal-content">

													<!-- Modal Header -->
													<div class="modal-header">
														<h4 class="modal-title">Có chắc chắn Xóa?</h4>
														<button type="button" class="btn-close"
															data-bs-dismiss="modal"></button>
													</div>

													<!-- Modal body -->
													<div class="modal-body">${categories.ten }</div>

													<!-- Modal footer -->
													<div class="modal-footer">
														<button type="button" class="btn btn-light" data-bs-dismiss="modal">Hủy</button>
														<a href="category?status=delete&id=${categories.id }"><button type="button" class="btn btn-danger">Xóa</button></a>
													</div>

												</div>
											</div>
										</div></td>


								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</html>