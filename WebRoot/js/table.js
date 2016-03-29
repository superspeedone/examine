$(function() {
	// 1.初始化Table
	var oTable = new TableInit();
	oTable.Init();
	//2.初始化Button的点击事件
    // var oButtonInit = new ButtonInit();
    //oButtonInit.Init();
	$(window).resize(function () {
    	$('#oplist').bootstrapTable('resetView');
  	});
});
var TableInit = function() {
	var oTableInit = new Object();
	oTableInit.Init = function() {
		$('#oplist').bootstrapTable({
			url : 'manage/op/list!query.action',  //请求后台的URL（*）
			method : 'get',  //请求方式（*）
			dataType: "json",
			//contentType: 'application/x-www-form-urlencoded',   //如果是post方式，必须添加contentType，否则没法传递参数
			toolbar : '#toolbar',  //工具按钮用哪个容器
			striped : true,  //是否显示行间隔色
			cache : false,  //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pageSize: 10, 
			pageList: [10, 20, 30],    //可供选择的每页的行数（*）
			pageNumber : 1,  //初始化加载第一页，默认第一页
			pagination : true,  //是否显示分页（*）
			clickToSelect : true,  //是否启用点击选中行
			maintainSelected: true,
			sortable : true,  //是否启用排序
			sortOrder : "asc",  //排序方式
			sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*）
			queryParams : oTableInit.queryParams,  //传递参数（*）
			queryParamsType: "limit",
			smartDisplay : true,
			paginationPreText : "上一页",
			paginationNextText : "下一页",
			height : 460,  //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
			uniqueId : "id",  //每一行的唯一标识，一般为主键列
			cardView : false,  //是否显示详细视图
			detailView : false,  //是否显示父子表
			undefinedText: '-',
			columns : [ {
				field : 'rownum',
				title : '序号'
				//checkbox: true
			}, {
				field : 'id',
				title : 'id',
				visible : false
			}, {
				field : 'login_name',
				title : '登陆名',
				sortable: true
			}, {
				field : 'real_name',
				title : '姓名',
				sortable: true
			}, {
				field : 'op_type',
				title : '类别',
				sortable: true
			}, {
				field : 'create_time',
				title : '创建时间',
				sortable: true
			}, {
                title: '操作',
                field: 'operation',
                align: 'center',
                formatter:function(value, row, index){  
	              var e = '<a class="btn btn-primary btn-sm"  href="manage/op/list!editUI.action?id='
	            	     + row.id + '"><i class="icon-edit "></i> 编辑</a> ';  
	              var d = '<a class="btn btn-danger btn-sm" href="javascript:del(\'oplist\',' + row.id
	                   + ',\'manage/op/list!delete.action\')"><i class="icon-trash "></i> 删除</a>';  
	                return e+d;  
	             } 
            }],
            formatLoadingMessage: function () {
                return "请稍等，正在拼命加载中...";
              },
              formatNoMatches: function () {  //没有匹配的结果
                return '无符合条件的用户信息';
              }
		});
	};
    
	 //得到查询的参数
	oTableInit.queryParams = function(params) {
		var temp = { 
			maxrows : params.limit,
		    offset : params.offset,
		    page : params.offset/ params.limit + 1,
			sort: params.sort,  //排序列名
		    sortOrder: params.order,  //（desc，asc）
			real_name: $("#real_name").val(),
			qm: $("#qm").val(),
			qt: $("#qt").val(),
			qs: $("#qs").val()
		};
		return temp;
	};
	return oTableInit;
};