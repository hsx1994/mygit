<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <title>登录</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Oleo+Script:400,700'>
        <link rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="../../css/style.css">

    </head>

    <body>

        <div class="header">
            <div class="container">
                <div class="row">
                    <div class="logo span4">
                        <h1><a href="index.jsp">CBD登录 <span class="red">.</span></a></h1>
                    </div>
                    <div class="links span8">
                        <a class="home" href="" rel="tooltip" data-placement="bottom" data-original-title="Home"></a>
                        <a class="blog" href="" rel="tooltip" data-placement="bottom" data-original-title="Blog"></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="copyrights">Collect from <a href="http://www.woxiuxy.com"  title="蜗牛学院">蜗牛学院</a></div>

        <div class="register-container container">
            <div class="row">
                <div class="iphone span5">
                    <img src="" alt="">
                </div>
                <div class="register span6">
                    <form action="/CBDSystem/userLogin.do" method="post">
                        <h2>登录<span class="red"><strong>CBD</strong></span></h2>
                        <label for="username">用户名</label>
                        <input type="text" id="username" name="name" placeholder="请输入用户名...">
                        <label for="password">密码</label>
                        <input type="password" id="password" name="password" placeholder="请输入密码 ...">
                        <label for="code">验证码</label>
                        <input type="text" id="code" name="checkcode" placeholder="验证码 ...">
                        <button type="submit">登录</button>
                    </form>
                </div>
            </div>
        </div>

        <!-- Javascript -->
        <script src="../../js/public/jquery.1.9.1.js"></script>
        <script src="../../bootstrap/js/bootstrap.min.js"></script>
        <script src="../../js/public/jquery.backstretch.min.js"></script>
        <script src="../../js/scripts.js"></script>

    </body>

</html>

