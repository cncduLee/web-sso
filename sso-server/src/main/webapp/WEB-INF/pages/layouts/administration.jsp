<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<body >
        <div id="wrapper">
            <%@include file="/WEB-INF/pages/include/menu.jsp" %>
            <sitemesh:body/>
        </div>
        <%@include file="/WEB-INF/pages/include/footer.jsp" %>
    </body>
</html>