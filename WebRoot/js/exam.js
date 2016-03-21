$(".modal-footer button:eq(0)").click(function() {
	$("#myModal").modal('hide');
	$(".modal-footer button:eq(0)").hide();
	$(".modal-footer button:eq(1)").show();
	$.ajax({
		type : "POST",
		url : "manage/users!delete.action",
		data : {
			"id" : $(".modal-body input:eq(0)").val()
		},
		dataType : "json",
		success : function(data, textStatus) {
			if (data) {
				if (data.message == 'success') {
					$(".modal-body").text("删除成功");
					$("#myModal").modal('show');
				} else if (data.message == 'falure') {
					$(".modal-body").text("删除失败");
					$("#myModal").modal('show');
				}
			}
		},
		error : function(XmlHttpRequest, textStatus, errorThrown) {
			$(".modal-body").text("删除失败");
			$("#myModal").modal('show');
		}
	});
});

$(".modal-footer button:eq(1)").click(function() {
	$("#myModal").modal('hide');
	window.location.reload();
});

function deluser(id) {
	$(".modal-body input:eq(0)").val(id);
	$(".modal-body p").text("确定要删除吗？");
	$(".modal-footer button:eq(0)").show();
	$(".modal-footer button:eq(1)").hide();
	$("#myModal").modal('show');
}
