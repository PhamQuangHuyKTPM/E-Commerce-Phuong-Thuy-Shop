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
<title>Thông tin cá nhân</title>
</head>
<body>
	<%@include file="/common/web/header.jsp"%>

	<%@include file="/common/web/nav-menu.jsp"%>

	<div class="container mt-5">
		<form action="thong-tin-ca-nhan" method="get">

			<h3 align="center">Thông tin cá nhân</h3>
			<input value="update" name="status" type="hidden" />
			<c:if test="${passIsTrue == true}">
				<div class="alert alert-success">
					<strong>Thành công !</strong> Cập nhật thông tin cá nhân thành công
				</div>
			</c:if>
			<c:if test="${passIsTrue == false}">
				<div class="alert alert-danger">
					<strong>Mật khẩu xác nhận không chính xác !</strong> Yêu cầu nhập lại
				</div>
			</c:if>
			<div class="form-group">
				<input type="hidden" class="form-control border-1 py-4"
					placeholder="Your Name" name="id_user" value=${manager.id_user }>
			</div>
			<div class="form-group">
				<input type="text" class="form-control border-1 py-4"
					placeholder="Họ tên" required="required" value="${manager.hoten }" name="hoten">
			</div>
			<div class="form-group">
				<input type="text" class="form-control border-1 py-4"
					placeholder="Địa chỉ" required="required"
					value="${manager.diachi }" name="diachi">
			</div>
			<div class="form-group">
				<input type="text" class="form-control border-1 py-4"
					placeholder="SĐT" required="required" value="${manager.sdt }" name="sdt">
			</div>
			<div class="form-group">
				<input type="date" class="form-control border-1 py-4"
					placeholder="Ngày sinh" required="required"
					value=${manager.ngaysinh } name="ngaysinh">
			</div>
			<div class="form-group">
				<input type="email" class="form-control border-1 py-4"
					placeholder="Email" required="required" value="${manager.email }" name="email">
			</div>
			<div class="form-group">
				<input type="text" class="form-control border-1 py-4"
					placeholder="Username" required="required"
					value="${manager.username }" name="username">
			</div>
			<div class="form-group">
				<input type="password" class="form-control border-1 py-4"
					placeholder="Nhập mật khẩu xác nhận " required="required" name="password" />
			</div>
			<div>
				<button class="btn btn-primary btn-block border-0 py-2"
					type="submit">Lưu</button>
			</div>
		</form>
	</div>

	<%@include file="/common/web/footer.jsp"%>

	<%@include file="/common/web/js-library.jsp"%>
</body>
</html>