<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="WEB-INF/page/header.jsp" %>
<html>
<head>
    <title>tx 音乐是生活的调味剂</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>


    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>
<div class="login-logo">
    <img src="${pageContext.servletContext.contextPath}/images/logo.png" width="147" height="33"/>
</div>

<div class="widget">
    <div class="login-content">
        <div class="widget-content" style="padding-bottom:0;">
            <form method="POST" action="${pageContext.servletContext.contextPath}/user/login.go" class="no-margin"/>
            <h3 class="form-title">Login to your account ${requestScope.info!=null?requestScope.info:""}</h3>

            <fieldset>
                <div class="form-group no-margin">
                    <label for="email">Email</label>

                    <div class="input-group input-group-lg">
                                <span class="input-group-addon">
                                    <i class="icon-user"></i>
                                </span>
                        <input type="email" placeholder="Your Email" class="form-control input-lg" id="EMAIL"
                               name="EMAIL"/>
                    </div>

                </div>

                <div class="form-group">
                    <label for="password">Password</label>

                    <div class="input-group input-group-lg">
                                <span class="input-group-addon">
                                    <i class="icon-lock"></i>
                                </span>
                        <input type="password" placeholder="Your Password" class="form-control input-lg" id="PASSWORD"
                               name="PASSWORD"/>
                    </div>

                </div>
            </fieldset>
            <div class="form-actions">
                <label class="checkbox">
                    <div class="checker"><span><input type="checkbox" value="1" name="remember"/></span></div>
                    Remember me
                </label>
                <button class="btn btn-warning pull-right" type="submit">
                    Login <i class="m-icon-swapright m-icon-white"></i>
                </button>
                <div class="forgot"><a href="#" class="forgot">Forgot Username or Password?</a></div>
            </div>


            </form>


        </div>
        <h4 style="color:red;" id="h4_error">${requestScope.error!=null?requestScope.error:""}</h4>
    </div>
</div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/console/js/jquery.js"></script>
<script src="/console/js/bootstrap.min.js"></script>


</body>
</html>
