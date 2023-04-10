  <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <div class="container-fluid">
        <div class="row border-top px-xl-5">
            <div class="col-lg-3 d-none d-lg-block">
                <a class="btn shadow-none d-flex align-items-center justify-content-between bg-primary text-white w-100" data-toggle="collapse" href="#navbar-vertical" style="height: 65px; margin-top: -1px; padding: 0 30px;">
                    <h6 class="m-0">Danh mục sản phẩm</h6>
                    <i class="fa fa-angle-down text-dark"></i>
                </a>
                <nav class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0 bg-light" id="navbar-vertical" style="width: calc(100% - 30px); z-index: 1;">
                    <div class="navbar-nav w-100 overflow-hidden" style="height: 410px">
                       
                        <c:forEach var="categories" items="${categories }">
                        	<a href="categoryWeb?id=${categories.id }&name=${categories.ten}" class="nav-item nav-link">${categories.ten }</a>
                        </c:forEach>
                    </div>
                </nav>
            </div>
            <div class="col-lg-9">
                <nav class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
                    <a href="" class="text-decoration-none d-block d-lg-none">
                        <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">E</span>Shopper</h1>
                    </a>
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                        <div class="navbar-nav mr-auto py-0">
                            <a href="home" class="nav-item nav-link active">Trang chủ</a>
                            <a href="san-pham" class="nav-item nav-link">Sản phẩm</a>
                            <a href="detail.html" class="nav-item nav-link">Chi tiết sản phẩm</a>
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Pages</a>
                                <div class="dropdown-menu rounded-0 m-0">
                                    <a href="cart.html" class="dropdown-item">Giỏ hàng</a>
                                    <a href="checkout.html" class="dropdown-item">Thanh toán</a>
                                </div>
                            </div>
                            <a href="contact.html" class="nav-item nav-link">Liên hệ</a>
                        </div>
                        <div class="navbar-nav ml-auto py-0">
                         <c:if test="${manager.hoten == null }">
                            <a href="login" class="nav-item nav-link">Đăng nhập</a>
                            <a href="login?status=register" class="nav-item nav-link">Đăng ký</a>
                         </c:if>
                         <c:if test="${manager.hoten != null }">
                            <a href="thong-tin-ca-nhan" class="nav-item nav-link">Xin chào ${manager.hoten } !</a>
                            <a href="home?status=logout" class="nav-item nav-link">Đăng xuất</a>
                         </c:if>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
    </div>
    <!-- Navbar End -->