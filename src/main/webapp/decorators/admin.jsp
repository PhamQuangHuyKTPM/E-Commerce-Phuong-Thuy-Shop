<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
	<title><dec:title default="Trang chủ" /></title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
   <!--  <link rel="stylesheet" href="venobox/venobox.min.css" media="screen"> -->
    <link rel="stylesheet" href="<c:url value='./template/admin/style.css' />">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">	
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
	
    <div class="container-fluid">
        <div class="column-main column-left nav flex-column text-white">

            <!-- Vertical menu  -->
            <%@include file="/common/admin/vertical_menu.jsp" %>
            <!-- End vertical menu -->
        </div>
        <div class="column-main column-right">

            <!-- Header -->
            <%@include file="/common/admin/header.jsp" %>
            <!-- End header -->
            <div class="content-main m-4">

                <dec:body />

            </div>
        </div>
    </div>

</html>