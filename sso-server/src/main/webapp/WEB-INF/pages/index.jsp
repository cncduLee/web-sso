<%--
  Created by IntelliJ IDEA.
  User: wylipengming
  Date: 14-6-13
  Time: 下午2:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/pages/include/taglib.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/static"/>

<html>
<head>
    <title>管理主页</title>
</head>
<body>
<div id="main" class="container-fluid">
    <div id="header" class="row-fluid">
        <div id="title">
				<span class="pull-right">
                    您好,
			    	<shiro:user>
                        <a href="${ctx}/sys/user/info" target="mainFrame">
                            <shiro:principal property="name"/></a>
                    </shiro:user>
                    <shiro:guest>
                        请<a href="${ctx}/login">登录</a>!
                    </shiro:guest>
					<shiro:user> |
                        <a href="${ctx}/logout">退出</a>
                    </shiro:user> |
					&nbsp;&nbsp;&nbsp;
				</span>
        </div>
    </div>
    <div id="content" class="row-fluid">
        <div id="left">
            <iframe id="menuFrame" name="menuFrame" src="${ctx}/sys/menu/tree?parentId=${firstMenuId}" style="overflow:visible;"
                    scrolling="yes" frameborder="no" width="100%" height="650"></iframe>
        </div>
        <div id="openClose" class="close">&nbsp;</div>
        <div id="right">
            <iframe id="mainFrame" name="mainFrame" src="${ctx}/sys/user/info" style="overflow:visible;"
                    scrolling="yes" frameborder="no" width="100%" height="650"></iframe>
        </div>
    </div>
    <div id="footer" class="row-fluid">
        Copyright &copy; 2014 <a href="mailto:shouli1990@gmail.com">百墨</a> - Powered By <a href="https://github.com/cncduLee/web-sso">WEB-SSO</a> V0.01
    </div>
</div>
<script type="text/javascript">
    var lw = "14.89%", rw = "82.97%"; // 左侧窗口展开大小
    var lwClose = "0%", rwClose = "97.58%"; // 左侧窗口折叠大小
    function wSize(){
        var strs=getWindowSize().toString().split(",");
        if(strs[0]<550){
            $("#main").css("height",550);
            $("#openClose").height(strs[0]);
        }else{
            $("#menuFrame, #mainFrame, #openClose").height(strs[0]-$("#header").height() - $("#footer").height() - 80);
            $("#openClose").height($("#openClose").height()-6);
        }
        if(strs[1]<980){
            $("#main").css("width",970);
            $("html").css("overflow-x","auto");
        }else{
            $("#main").css("width","auto");
            $("html").css("overflow-x","hidden");
        }
    }
</script>
<script src="${ctxStatic}/wsize.js" type="text/javascript"></script>
</body>
</html>