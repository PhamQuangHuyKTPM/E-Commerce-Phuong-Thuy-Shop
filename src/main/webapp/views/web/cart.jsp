<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="Free HTML Templates" name="keywords">
<meta content="Free HTML Templates" name="description">

<!-- Favicon -->
<link href="<c:url value='./template/web/img/favicon.ico' />" rel="icon">
<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"
	rel="stylesheet">

<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<%-- <link href= "<c:url value='./template/web/lib/owlcarousel/assets/owl.carousel.min.css' />" rel="stylesheet"> --%>
<link href="./template/web/lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">

<!-- Customized Bootstrap Stylesheet -->
<!--<link href="<c:url value='./template/web/css/style.css' />" rel="stylesheet">  -->
<link href="./template/web/css/style.css" rel="stylesheet">
<title>Giỏ hàng</title>
</head>
<body>
	<%@include file="/common/web/header.jsp"%>

	<%@include file="/common/web/nav-menu.jsp"%>
	<!-- Cart Start -->
	<div class="container-fluid pt-5">
		<div class="row px-xl-5">
			<div class="col-lg-8 table-responsive mb-5">
				<table class="table table-bordered text-center mb-0">
					<thead class="bg-secondary text-dark">
						<tr>
							<th>Ảnh</th>
							<th>Tên sản phẩm</th>
							<th>Đơn giá</th>
							<th>Số lượng</th>
							<th>Tổng tiền</th>
							<th>Xóa khỏi giỏ hàng</th>
						</tr>
					</thead>
					<tbody class="align-middle">
						<c:forEach var="carts" items="${cartProduct }">

							<tr>
								<td class="align-middle"><img src="${carts.image }" alt=""
									style="width: 70px;"></td>
								<td class="align-middle">${carts.ten }</td>
								<td class="align-middle">${carts.dongia } VND</td>
								<td class="align-middle">
									<div class="input-group quantity mx-auto" style="width: 100px;">
										<div class="input-group-btn">
											<button class="btn btn-sm btn-primary btn-minus">
												<i class="fa fa-minus"></i>
											</button>
										</div>
										<input type="text"
											class="form-control form-control-sm bg-secondary text-center"
											value="${carts.totalCart }">
										<div class="input-group-btn">
											<button class="btn btn-sm btn-primary btn-plus">
												<i class="fa fa-plus"></i>
											</button>
										</div>
									</div>
								</td>
								<td class="align-middle">${carts.tongtien } VND</td>
								<td class="align-middle"><a href="cart?status=delete&id=${carts.maGioHang }"
										class="btn btn-sm btn-primary">
										<i class="fa fa-times"></i>
									</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-lg-4">
				<form class="mb-5" action="">
					<div class="input-group">
						<input type="text" class="form-control p-4"
							placeholder="Coupon Code">
						<div class="input-group-append">
							<button class="btn btn-primary">Apply Coupon</button>
						</div>
					</div>
				</form>
				<div class="card border-secondary mb-5">
					<div class="card-header bg-secondary border-0">
						<h4 class="font-weight-semi-bold m-0">Cart Summary</h4>
					</div>
					<div class="card-body">
						<div class="d-flex justify-content-between mb-3 pt-1">
							<h6 class="font-weight-medium">Subtotal</h6>
							<h6 class="font-weight-medium">$150</h6>
						</div>
						<div class="d-flex justify-content-between">
							<h6 class="font-weight-medium">Shipping</h6>
							<h6 class="font-weight-medium">$10</h6>
						</div>
					</div>
					<div class="card-footer border-secondary bg-transparent">
						<div class="d-flex justify-content-between mt-2">
							<h5 class="font-weight-bold">Total</h5>
							<h5 class="font-weight-bold">$160</h5>
						</div>
						<button class="btn btn-block btn-primary my-3 py-3">Proceed
							To Checkout</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Cart End -->



	<%@include file="/common/web/footer.jsp"%>

	<%@include file="/common/web/js-library.jsp"%>
</body>
</html>