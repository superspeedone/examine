<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/sharepage/taglibs.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>教师信息管理</title>
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
  
 <body>

  <section id="container" class="">
      <!--header start-->
      <header class="header white-bg">
          <div class="sidebar-toggle-box">
              <div data-original-title="隐藏菜单" data-placement="right" class="icon-reorder tooltips"></div>
          </div>
          <!--logo start-->
          <a href="ManageOpBasic.jsp" class="logo" ><span>跨境考试管理后台</span></a>
          <!--logo end-->
          <div class="top-nav ">
              <ul class="nav pull-right top-menu">
                  <li>
                      <input type="text" class="form-control search" placeholder="Search">
                  </li>
                  <!-- user login dropdown start-->
                  <li class="dropdown">
                      <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                          <img alt="" src="img/avatar1_small.jpg">
                          <span class="username">Jhon Doue</span>
                          <b class="caret"></b>
                      </a>
                      <ul class="dropdown-menu extended logout">
                          <div class="log-arrow-up"></div>
                          <li><a href="#"><i class=" icon-suitcase"></i>Profile</a></li>
                          <li><a href="#"><i class="icon-cog"></i> Settings</a></li>
                          <li><a href="#"><i class="icon-bell-alt"></i> Notification</a></li>
                          <li><a href="login.html"><i class="icon-key"></i> Log Out</a></li>
                      </ul>
                  </li>
                  <!-- user login dropdown end -->
              </ul>
          </div>
      </header>
      <!--header end-->
      <!--sidebar start-->
      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu">
                  <li class="sub-menu">
                      <a href="javascript:;" class="">
                          <i class="i icon-user-md"></i>
                          <span>基础信息管理</span>
                          <span class="arrow"></span>
                      </a>
                      <ul class="sub">
                          <li><a class="" href="#">教师信息管理</a></li>
                          <li><a class="" href="#">班级管理</a></li>
                          <li><a class="" href="#">学生管理</a></li>
                          <li><a class="" href="#">课程管理</a></li>
                          <li><a class="" href="#">题库管理</a></li>
                          <li><a class="" href="#">公司管理</a></li>
                          <li><a class="" href="#">岗位管理</a></li>
                          <li><a class="" href="#">公告管理</a></li>
                      </ul>
                  </li>
                  
                  <li class="sub-menu open">
                      <a href="javascript:;" class="">
                          <i class="icon-cogs"></i>
                          <span>系统管理</span>
                          <span class="arrow open"></span>
                      </a>
                      <ul class="sub">
                          <li class="active"><a class="" href="manage/users.action">账户管理</a></li>
                          <li><a class="" href="#">角色管理</a></li>
                          <li><a class="" href="#">参数管理</a></li>
                          <li><a class="" href="3">日志管理</a></li>
                      </ul>
                  </li>
              </ul>
              <!-- sidebar menu end-->
          </div>
      </aside>
      <!--sidebar end-->
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
              <!-- navigation start-->
              <div class="row">
                  <div class="col-lg-12">
                      <!--breadcrumbs start -->
                      <ul class="breadcrumb">
                          <li><i class="icon-home"></i> 主页</li>
                          <li>系统管理</li>
                          <li><a href="manage/users.action">账户管理</a></li>
                          <li class="active">账户添加</li>
                      </ul>
                      <!--breadcrumbs end -->
                  </div>
              </div>
              <!-- navigation end-->
              <!-- page start-->
              <div class="row">
                  <div class="col-lg-12">
                      <section class="panel">
	                          <div class="row">
				                 <div class="col-lg-12">
		                              <section class="panel">
		                                  <header class="panel-heading">
		                                      用户添加
		                                  </header>
		                                  <div class="panel-body">
				                              <form action="manage/users!add.action"  method="post"  class="form-horizontal" role="form">
				                                  <div class="form-group">
				                                      <label for="inputLoginname" class="col-lg-1 control-label">账号</label>
				                                      <div class="col-lg-3">
				                                          <input type="text" class="form-control" id="inputLoginname" name="login_name" placeholder="最大长度30" maxlength="30" required="">
				                                      </div>
				                                  </div>
				                                  <div class="form-group">
				                                      <label for="inputRealname" class="col-lg-1 control-label">账号名</label>
				                                      <div class="col-lg-3">
				                                          <input type="text" class="form-control" id="inputRealname" name="real_name" placeholder="" maxlength="30" required="">
				                                      </div>
				                                  </div>
				                                  <div class="form-group">
				                                      <label for="inputPassword1" class="col-lg-1 control-label">密码</label>
				                                      <div class="col-lg-3">
				                                          <input type="password" class="form-control" id="inputPassword1" name="password" placeholder="" required="">
				                                      </div>
				                                  </div>
				                                  <div class="form-group">
				                                      <label for="inputPassword2" class="col-lg-1 control-label">密码确认</label>
				                                      <div class="col-lg-3">
				                                          <input type="password" class="form-control" id="inputPassword2" placeholder="" required="">
				                                      </div>
				                                  </div>
				                                  <div class="form-group">
				                                      <label for="inputoptype" class="col-lg-1 control-label">用户类型</label>
				                                      <div class="col-lg-3">
				                                          <select class="form-control m-bot6" name="op_type" required="">
				                                              <option value="0">管理员</option>
				                                              <option value="1">教师</option>
				                                              <option value="2">学生</option>
				                                          </select>
				                                      </div>
				                                  </div>
				                                  <div class="form-group">
				                                      <div class="col-lg-offset-1 col-lg-6">
				                                          <button type="submit" class="btn btn-info" style="width:100px;">添加</button>
				                                          <a class="btn btn-info" href="manage/users.action" style="width:100px;">返回</a>
				                                          <label style="color:green;font-size:14px;margin-left:15px;"><strong>${message}</strong></label>
				                                      </div>
				                                  </div>
				                              </form>
				                          </div>
		                                </section>
                                     </div>
                                     <!-- user add from end -->
				              </div>
                      </section>
                  </div>
              </div>
              <!-- page end-->
          </section>
      </section>
      <!--main content end-->
  </section>
  
  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title">提示</h4>
                </div>
                <div class="modal-body"></div>
                <div class="modal-footer">
                    <button id="btnOK" data-dismiss="modal" class="btn btn-default" type="button">确定</button>
                </div>
            </div>
        </div>
    </div>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.scrollTo.min.js"></script>
    <script src="js/jquery.nicescroll.js" type="text/javascript"></script>


    <!--common script for all pages-->
    <script src="js/common-scripts.js"></script>
    <script src="js/exam.js"></script>
  </body>
</html>
