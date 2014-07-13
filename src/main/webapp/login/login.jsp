<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="zh-cn">
	<head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible"content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" href="/favicon.ico">

		<title>中电支付登录</title>

        <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="/resources/css/signin.css" rel="stylesheet">
	</head>

	<body>
    <div class="container">

        <form class="form-signin" role="form" method="POST" action="/login/login.do">
        
            <h2 class="form-signin-heading">登录中电支付</h2>
            
            <input type="text" class="form-control" placeholder="邮箱地址/手机号码" id="userName" name="userName" required autofocus>
            
            <input type="password" class="form-control" id="password" name="password" placeholder="登录密码" required>
            
            <div class="checkbox">
                <label>
                    <input type="checkbox" value="remember-me">记住
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-default btn-block" type="submit">登录</button>
        </form>

    </div>

        <script src="/resources/jquery/jquery-1.11.1.min.js"></script>
        <script src="/resources/bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="/resources/jquery-validation/jquery.validate.min.js"></script>
	</body>
</html>
