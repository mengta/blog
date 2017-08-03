<%--
  Created by IntelliJ IDEA.
  User: tianmeng
  Date: 2017/8/1
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title id="title">登录</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/blog/frame/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/blog/frame/bootstrapValidator/bootstrapValidator.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/blog/frame/Font-Awesome-3.2.1/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/blog/css/login.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/blog/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/blog/frame/bootstrapValidator/bootstrapValidator.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/blog/frame/bootstrapValidator/zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/blog/frame/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/blog/js/login.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="login_regist">
            <ul id="myTab" class="nav nav-tabs">
                <li class="active"><a href="#logindiv" data-toggle="tab">用户登录</a> </li>
                <li><a href="#registdiv" title="注册" data-toggle="tab">用户注册</a> </li>
            </ul>
            <div id="myTabContent" class="tab-content">
                <div class="tab-pane fade in active" id="logindiv">
                    <form class="form-horizontal" id="loginForm">
                        <div class="form-group">
                            <input name="user.userName" type="text" class="form-control"
                                   placeholder="用户名" value="${cookie.userName.value}"/>
                            <i class="login-icon icon-user"></i>
                        </div>
                        <div class="form-group help">
                            <input name="user.password" type="password" class="form-control" placeholder="密 码" value="${cookie.password.value}">
                            <i class="login-icon icon-lock"></i>
                        </div>
                        <div class="form-group">
                            <div class="main-checkbox">
                                <input type="checkbox" ${cookie.userName.value!=''?'checked':''} id="checkbox1" name="remember"/>
                                <label for="checkbox1"></label>
                            </div>
                            <span class="text">记住我</span>
                            <button id="loginSubmit" type="submit" class="btn btn-default submit">登录</button>
                        </div>
                    </form>
                </div>
                <div class="tab-pane fade" id="registdiv">
                    <form id="registForm" class="form-horizontal">
                        <div class="form-group">
                            <label class="col-lg-3 control-label">用户名</label>
                            <div class="col-lg-8">
                                <input name="user.userName" id="userName" type="text" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 control-label">密码</label>
                            <div class="col-lg-8">
                                <input name="user.password" id="password" type="password" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 control-label">邮箱</label>
                            <div class="col-lg-8">
                                <input name="user.email" id="email" type="email" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 control-label">验证码</label>
                            <div class="col-lg-5">
                                <input name="validateCode" id="validateCode" type="validateCode" class="form-control"/>
                            </div>
                            <button class="btn btn-default" id="sendMail">发送验证码</button>
                        </div>
                        <div class="form-group">
                            <button id="registSubmit" type="submit" class="btn btn-default submit">注册</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
