<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!--定义在此处，避免变量重新定义多次-->
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/static"/>


<!DOCTYPE html>
<html style="overflow-x:hidden;overflow-y:auto;">
	<head>
		<title><sitemesh:title/> - 百墨</title>
		<%@include file="/WEB-INF/pages/include/head.jsp" %>
		<sitemesh:head/>
	</head>
	<body>
		<sitemesh:body/>
	</body>
</html>