<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
                          <li class="active">账户管理</li>
                      </ul>
                      <!--breadcrumbs end -->
                  </div>
              </div>
              <!-- navigation end-->
              <!-- page start-->
              <div class="row">
                  <div class="col-lg-12">
                      <section class="panel">
                          <div id="sample_1_wrapper" class="dataTables_wrapper form-inline" role="grid">
	                          <div class="row">
				                 <div class="col-sm-12">
				                   <div class="dataTables_filter" id="manageOpbasic_search">
				                          <input type="text" aria-controls="sample_1" class="form-control">
				                    </div>
				                    <div class="dataTables_filter" id="manageOpbasic_search">
				                          <button type="button" class="btn btn-success"><i class="icon-eye-open"></i>  查询</button>
				                          <lable>${msg }</lable>
				                    </div>     
				                    <div class="dataTables_records" id="manageOpbasic_records" >
				                        <span class="label label-primary">
				                            共 ${pageView.totalpage} 页 - ${pageView.totalrecord} 条记录</span>
				                    </div> 
				                    <div class="dataTables_records" id="manageOpbasic_records" >
				                        <a href="manage/users!addUI.action"><span class="label label-success">添加用户</span></a>
				                    </div> 
				                 </div>
				              </div>
	                          <table class="table table-bordered table-striped table-advance table-hover">
                              <thead>
                              <tr>
                                  <th> 登陆名</th>
                                  <th > 姓名</th>
                                  <th> 类别</th>
                                  <th> 创建时间</th>
                                  <th></th>
                              </tr>
                              </thead>
                              <tbody>
                              <c:forEach items="${pageView.records}" var="opBasic">
                              <tr>
                                  <td><c:out value="${opBasic.login_name}" /></td>
                                  <td><c:out value="${opBasic.real_name}" /></td>
                                  <td><c:if test="${opBasic.op_type=='0'}"> 管理员</c:if>
                                  <c:if test="${opBasic.op_type=='1'}">教师</c:if>
                                  <c:if test="${opBasic.op_type=='2'}">学生</c:if></td>
                                  <td><c:out value="${opBasic.create_time}" /></td>
                                  <td>
                                      <a class="btn btn-primary btn-sm"  href="manage/users!editUI.action?id=${opBasic.id}">
                                      <i class="icon-edit "></i> 编辑</a>
                                      <a class="btn btn-danger btn-sm" href="javascript:deluser(${opBasic.id})">
                                      <i class="icon-trash "></i> 删除</a>
                                  </td>
                              </tr>
                              </c:forEach>
                              </tbody>
                          </table>
                              <div class="row">
	                              <div class="col-sm-12">
	                                   <div>
	                                      <ul class="pagination pull-right">
	                                          <c:choose> 
												   <c:when test="${pageView.currentpage==1}">
												     <li><a class="disabled">首页</a></li>
												     <li><a class="disabled">上一页</a></li>  
												   </c:when>  
												   <c:otherwise> 
                                                         <li><a href="manage/users.action?page=1">首页</a></li>
												         <li><a href="manage/users.action?page=${pageView.currentpage-1}">上一页</a></li>
												   </c:otherwise>  
											  </c:choose>  
											  <c:forEach begin="${pageView.pageindex.startindex}" end="${pageView.pageindex.endindex}" var="index">
		                                            <c:choose> 
														   <c:when test="${index==pageView.currentpage}">
														     <li><a class="disabled" href="manage/users.action?page=${index}">${index}</a></li>
														   </c:when>  
														   <c:otherwise>
														          <li><a href="manage/users.action?page=${index}">${index}</a></li>
														   </c:otherwise>  
													  </c:choose>
		                                      </c:forEach>
		                                      <c:choose> 
												   <c:when test="${pageView.currentpage==pageView.totalpage}">
												     <li><a class="disabled">下一页</a></li>
												     <li><a class="disabled">尾页</a></li>  
												   </c:when>  
												   <c:otherwise>
												          <li><a href="manage/users.action?page=${pageView.currentpage+1}">下一页</a></li>
		                                                 <li><a href="manage/users.action?page=${pageView.totalpage}">尾页</a></li>
												   </c:otherwise>  
											  </c:choose>
		                                      
		                                  </ul>
	                                   </div>
	                               </div>
	                           </div>    
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
