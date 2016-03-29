<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/sharepage/taglibs.jsp" %>
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
    <link href="assets/bootstrap-table/dist/bootstrap-table.min.css" rel="stylesheet" />
    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet" />
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
                          <div id="sample_1_wrapper" class="dataTables_wrapper form-inline" >
	                          <div id="toolbar" class="row">
				                 <div class="col-lg-10">
				                    <div class="dataTables_filter" id="manageOpbasic_search">
				                          <input id="real_name" name="real_name" value="${real_name}" type="text" placeholder="输入姓名查询" class="form-control"/>
				                    </div>
				                    <div class="dataTables_filter" id="searchbtn">
				                          <button id="query" name="query" type="button" class="btn btn-success"><i class="icon-eye-open"></i>  查询</button>
				                    </div> 
				                     <div class="dataTables_filter">
				                          <h4 class="query-by-stragetory" >分类</h4>
				                    </div>
				                    <div class="dataTables_filter" >
				                           <button name="qmanager" type="button" class="btn btn-warning" 
				                                  onclick="javascript:setQueryParam('oplist','qt','qs',this)">
				                                  <c:if test="${qm=='Y'}">
						                                  <i class="icon-ok" style="display:line;"></i>
						                          </c:if>
						                          <c:if test="${qm=='N'}">
						                                  <i class="icon-ok" style="display:none;"></i>
						                          </c:if>管理员</button>
				                          <input id="qm" name="qm" type="hidden" value="${qm}" />
				                    </div> 
				                    <div class="dataTables_filter">
				                          <button name="qteacher" type="button" class="btn btn-danger" 
				                               onclick="javascript:setQueryParam('oplist','qm','qs',this)">
						                           <c:if test="${qt=='Y'}">
						                                  <i class="icon-ok" style="display:line;"></i>
						                          </c:if>
						                          <c:if test="${qt=='N'}">
						                                  <i class="icon-ok" style="display:none;"></i>
						                          </c:if>教师</button>
				                          <input id="qt" name="qt" type="hidden" value="${qt}" />
				                    </div> 
				                    <div class="dataTables_filter" >
				                          <button name="qstudent" type="button" class="btn btn-success" 
				                               onclick="javascript:setQueryParam('oplist','qm','qt',this)">
				                                   <c:if test="${qs=='Y'}">
						                                  <i class="icon-ok" style="display:line;"></i>
						                          </c:if>
						                          <c:if test="${qs=='N'}">
						                                  <i class="icon-ok" style="display:none;"></i>
						                          </c:if>学生</button>
				                          <input id="qs" name="qs" type="hidden" value="${qs}" />
				                    </div>   
				                 </div>
				                 <div class="col-lg-2">
				                        <div class="dataTables_records" >
				                        <a href="manage/op/list!addUI.action"><span class="label label-info"><i class=" icon-user"></i> 添加用户</span></a>
				                    </div> 
				                 </div>
				              </div>
                              <!-- oplist table -->
                              <div class="row">
	                              <div class="col-sm-12">
		                               <table id="oplist"></table>
		                          </div>
	                          </div>
	                          <!-- oplist table -->
                          </div>
                      </section>
                  </div>
              </div>
              <!-- page end-->
          </section>
      </section>
      <!--main content end-->
  </section>
  
  <div class="modal fade" id="tipDlg" tabindex="-1" role="dialog" aria-labelledby="tipDlgLabel" aria-hidden="true" style="display: none;">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title">提示</h4>
                </div>
                <div class="modal-body"><input id="id" type="hidden" value=""><p></p></div>
                <div class="modal-footer">
                    <button id="btnOK" data-dismiss="modal" class="btn btn-default" type="button">确定</button>
                    <button id="btnOK" data-dismiss="modal" class="btn btn-default" type="button" >确定</button>
                </div>
            </div>
        </div>
    </div>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="assets/bootstrap-table/dist/bootstrap-table.min.js"></script>
    <script src="assets/bootstrap-table/dist/locale/bootstrap-table-zh-CN.js"></script>
    <script src="js/jquery.scrollTo.min.js"></script>
    <script src="js/jquery.nicescroll.js" type="text/javascript"></script>

    <!--common script for all pages-->
    <script src="js/common-scripts.js"></script>
    <script src="js/exam.js"></script>
    <script src="js/table.js"></script>
    <script type="text/javascript">
      $("#query").click(function(){
          $("#oplist").bootstrapTable('refresh');
      });
    </script>
  </body>
</html>
