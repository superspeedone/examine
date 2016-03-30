//登陆验证码
$("#verifyimg").click(function() {
	var time = new Date().getTime();
	this.src = "servlet/SecurityCode?time=" + time;
});

// 通用查询删除操作
function delOpt(table, id, url) {
	$(".modal-footer button:eq(0)").click(function() {
		$("#tipDlg").modal('hide');
		$(".modal-footer button:eq(0)").hide();
		$(".modal-footer button:eq(1)").show();
		$.ajax({
			type : "POST",
			url : url,
			data : { "id" : id },
			dataType : "json",
			success : function(data, textStatus) {
				if (data) {
					if (data.eMessage == 'success') {
						$(".modal-body").text("删除成功");
						$("#tipDlg").modal('show');
					} else if (data.eMessage == 'failed') {
						$(".modal-body").text("删除失败");
						$("#tipDlg").modal('show');
					}
				}
			},
			error : function(XmlHttpRequest, textStatus, errorThrown) {
				$(".modal-body").text("删除失败");
				$("#tipDlg").modal('show');
			}
		});
	});

	$(".modal-footer button:eq(1)").click(function() {
		$("#tipDlg").modal('hide');
		//$("#" + table).bootstrapTable('refresh');
	});
}

//通用删除
function del(table, url, id) {
	delOpt(table, url, id);
	$(".modal-body input:eq(0)").val(id);
	$(".modal-body p").text("确定要删除吗？");
	$(".modal-footer button:eq(0)").show();
	$(".modal-footer button:eq(1)").hide();
	$("#tipDlg").modal('show');
}

//通用分类查询
function setQueryParam(table, id1, id2, me) {
	if ($(me).next().val() == "Y") {
		$(me).next().val("N");
		$(me).find("i").hide();
	} else if ($(me).next().val() == "N") {
		$(me).next().val("Y").children().show();
		$(me).find("i").show();
	}
	$("#" + id1).val("N");
	$("#" + id1).prev().find("i").hide();
	$("#" + id2).val("N");
	$("#" + id2).prev().find("i").hide();
	
	//刷新table
	$("#" + table).bootstrapTable('refresh');
}

//查询
$("#query").click(function(){
    $("#oplist").bootstrapTable('refresh');
});

//账户管理查询页面
function queryOp(){
	$.MyTable.create('oplist', 'manage/op/list!query.action',[ 'real_name', 'qm', 'qt', 'qs'], {},
	      [ {field : 'rownum', title : '序号' }, { field : 'id', title : 'id', visible : false}, 
	        { field : 'login_name', title : '登陆名',	sortable: true}, { field : 'real_name', title : '姓名', sortable: true }, 
	        { field : 'op_type', title : '类别', sortable: true	}, { field : 'create_time', title : '创建时间', sortable: true },
            { title: '操作', field: 'operation', align: 'center',
	          formatter:function(value, row, index){  
	              var e = '<a class="btn btn-primary btn-sm"  href="manage/op/list!editUI.action?id='
	                + row.id + '"><i class="icon-edit "></i> 编辑</a> ';  
	              var d = '<a class="btn btn-danger btn-sm" href="javascript:del(\'oplist\',' + row.id
	                + ',\'manage/op/list!delete.action\')"><i class="icon-trash "></i> 删除</a>';  
		          return e + d;
		       } 
	      }]
	 );
}
