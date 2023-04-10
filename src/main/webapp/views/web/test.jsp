<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test</title>
</head>
<body>
	${text } 
	<c:forEach var="list" items="${list }">
		<p>${list.maGioHang }</p>
	</c:forEach>
</body>
</html>