<div class="nav-menu text-white top-menu">
	
	<div class="top-menu-items">
		<p>Xin chào! ${manager.hoten} </p>
	</div>
	<div class="top-menu-items menu-items-logout">
		<a href="<c:url value='/home?status=logout' />" id="btnExit">Thoat <i class="fa fa-arrow-right" aria-hidden="true"></i></a>
	</div>
</div>

<style>

.top-menu{
	display : flex;
	align-items : center;
	justify-content : flex-end;
}

.top-menu-items{

	padding : 18px 18px;
}

.top-menu p{
	margin : 0;
}

.top-menu a, .top-menu a:hover{
	text-decoration : none;
	color : white;
}

.menu-items-logout{
	background-color : red;
}

.top-menu-items i{
	margin-left : 5px;
}


</style>

<script>

</script>