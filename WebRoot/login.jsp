<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>考试系统登录页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="考试系统" content="考试系统">
	<meta http-equiv="keyword" content="考试系统">
	
	<!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-reset.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet" />

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body class="login-body">

    <div class="container">

      <form class="form-signin" action="index.jsp">
        <h2 class="form-signin-heading">考试系统登录</h2>
        <div class="login-wrap">
            <dl>
                <dt>
                    <span>用户名：</span>
                     <input id="username" type="text" class="form-control" placeholder="登录名" autofocus minlength="1" required="">
                </dt>
                <dt>
                    <span>用户名：</span>
                     <input id="password" type="password" class="form-control" placeholder="密码" minlength="1" required="" >
                </dt>
                <dt>
                    <span>验证码：</span>
                    <input id="verifycode" type="text" class="form-control" maxlength="4" required="" >
                    <img id="verifyimg" class="verifycode" alt="验证码" src="servlet/SecurityCode"/>
                </dt>
            </dl>
            <label class="checkbox">
                 <input type="checkbox" value="remember-me"> 记住密码
	              <span class="pull-right"> <a href="#"> 忘记密码?</a></span>
	        </label>
            <button class="btn btn-lg btn-login btn-block" type="submit">登  录</button>
        </div>
      </form>
    </div>
    <script src="js/jquery.js"></script>
    <script src="js/exam.js"></script>
  </body>
</html>
