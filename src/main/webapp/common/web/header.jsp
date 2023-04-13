<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Topbar Start -->
<div class="container-fluid">
	
	<div class="row align-items-center py-3 px-xl-5">
		<div class="col-lg-3 d-none d-lg-block">
			<a href="" class="text-decoration-none">
				<h1 class="m-0 display-5 font-weight-semi-bold">
					<img alt="" src="./template/web/img/1111.png" style="width : 160px; height : 160px; margin-left : 30px">
				</h1>
			</a>
		</div>
		<div class="col-lg-6 col-6 text-left">
			<form action="search?">
				<div class="input-group">
					<input type="text" class="form-control"
						placeholder="Tìm kiếm tên sản phẩm" name="name">
					<a type="submit" class="input-group-append">
						<span class="input-group-text bg-transparent text-primary">
							<i class="fa fa-search"></i>
						</span>
					</a>
				</div>
			</form>
		</div>
		<div class="col-lg-3 col-6 text-right">
			<a href="cart" class="btn border"> <i
				class="fas fa-heart text-primary"></i> <span class="badge rounded-pill">0</span>
			</a> <a href="cart" class="btn border"> <i
				class="fas fa-shopping-cart text-primary"></i> <span class="badge">0</span>
			</a>
		</div>
	</div>
</div>
<!-- Topbar End -->