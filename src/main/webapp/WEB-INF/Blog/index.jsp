<%--
  Created by IntelliJ IDEA.
  User: tianmeng
  Date: 2017/8/1
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title id="t">主页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/blog/css/home.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/blog/js/jquery.js"></script>
    <script type="text/javascript">
        $(function(){
            //点击分类栏目
            $('.articleClass a').click(function(){
                //设置该隐藏项目为0，为了以后分页识别
                //因为分页是公用的，不知道分页调用哪个链接，是进行全部文章分页还是分类文章分页
                //所以可以根据这个的值判断分页应该调用哪个链接进行分页
                $('#isArticleClass').val("0");
                var isa = $('#isArticleClass').val();
                $('#contentShow').load('articleClass.action?articleClass=' + $(this).attr('articleClass'));
            });
        });
    </script>
</head>
<body>
<%@ include file="head.jsp"%>
<input hidden id="isArticleClass" value="1"/>
<div id="home">
    <div class="mytitle">
        <h1>Override</h1>
        <h3>Coding</h3>
    </div>
    <div class="main_content">
        <div class="main_left">
            <ul class="list-group new-group">
                <li class="list-group-item new-item">
                    <ul class="list-group">
                        <li href="#" class="list-group-item first">推荐博主</li>
                        <c:forEach items="${users}" var="user">
                            <li href="javascript:;" class="list-group-item">
                                <div class="list_user">
                                    <div class="list_user_img">
                                        <img userId="${user.userId}" class="user_img userinfo" src="${user.userImg}">
                                    </div>
                                    <div class="list_user_name">
                                        <a href="myBlogView.action?userId=${user.userId}">${user.userNickname}</a>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </li>
                <li class="list-group-item new-item">
                    <ul class="list-group articleClass">
                        <li class="list-group-item first">博文分类</li>
                        <li class="list-group-item"><a articleClass="0" href="javascript:;">移动开发</a></li>
                        <li class="list-group-item"><a articleClass="1" href="javascript:;">web前端</a></li>
                        <li class="list-group-item"><a articleClass="2" href="javascript:;">架构设计</a></li>
                        <li class="list-group-item"><a articleClass="3" href="javascript:;">编程语言</a></li>
                        <li class="list-group-item"><a articleClass="4" href="javascript:;">互联网</a></li>
                        <li class="list-group-item"><a articleClass="5" href="javascript:;">数据库</a></li>
                        <li class="list-group-item"><a articleClass="6" href="javascript:;">系统运维</a></li>
                        <li class="list-group-item"><a articleClass="7" href="javascript:;">云计算</a></li>
                        <li class="list-group-item"><a articleClass="8" href="javascript:;">研发管理</a></li>
                        <li class="list-group-item"><a articleClass="9" href="javascript:;">综合</a></li>
                    </ul>
                </li>
                <li class="list-group-item new item">
                    <ul class="list-group">
                        <li class="list-group-item first">推荐网站</li>
                        <li class="list-group-item"><a href="https://github.com/OverrideRe" target="_blank">github</a></li>
                        <li class="list-group-item"><a href="http://blog.csdn.net/" target="_blank">CSDN</a></li>
                        <li class="list-group-item"><a href="http://www.cnblogs.com/" target="_blank">博客园</a></li>
                    </ul>
                </li>
                <li class="list-group-item new-item">
                    <ul class = "list-group">
                        <li class="list-group-item first">联系我们</li>
                        <li class="list-group-item">电话:13228535990</li>
                        <li class="list-group-item">微信:Aa1655970872</li>
                        <li class="list-group-item">邮箱:1655970872@qq.com</li>
                        <li class="list-group-item">qq:727691961</li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="main-right" id="contentShow">
            <%@ include file="blogList.jsp"%>
        </div>
    </div>
</div>
<%@ include file="tail.jsp"%>
</body>
</html>
