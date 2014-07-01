<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>登录页</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please Sign In</h3>
                </div>
                <div class="panel-body">
                    <form role="form" id="loginForm" action="${ctx}/login.htm" method="post">
                        <fieldset>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="登录名" id="username" name="username" maxlength="50" value="${loginName}" autofocus/>
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" placeholder="密码" id="password" name="password" maxlength="50"  class="required input-medium"/>

                            </div>
                            <div class="checkbox">
                                <label>
                                    <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                </label>
                            </div>
                            <!-- Change this to a button or input when using this as a form -->
                            <input id="submit" class="btn btn-lg btn-success btn-block" type="submit" value="登 录"/>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>