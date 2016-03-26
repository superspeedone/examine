//登陆验证码
$("#verifyimg").click(function() {
	var time = new Date().getTime();
	this.src = "servlet/SecurityCode?time=" + time;
});

// 通用查询删除操作
function delOpt(id, url) {
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
					if (data.message == 'success') {
						$(".modal-body").text("删除成功");
						$("#tipDlg").modal('show');
					} else if (data.message == 'falure') {
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
		window.location.reload();
	});
}

//通用删除
function del(url, id) {
	delOpt(url, id);
	$(".modal-body input:eq(0)").val(id);
	$(".modal-body p").text("确定要删除吗？");
	$(".modal-footer button:eq(0)").show();
	$(".modal-footer button:eq(1)").hide();
	$("#tipDlg").modal('show');
}

//通用分类查询
function setQueryParam(id1, id2, me) {
	if ($(me).next().val() == "Y") {
		$(me).next().val("N");
	} else if ($(me).next().val() == "N") {
		$(me).next().val("Y");
	}
	$("#" + id1).val("N");
	$("#" + id2).val("N");
	$("form").submit();
}
