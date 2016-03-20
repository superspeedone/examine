$("#btnOK").click(function(){
	window.location.reload();
});

function deluser(id){
	$.ajax({
		type : "POST",
		url : "manage/users!delete.action",
		data : {"id": id},
		dataType : "json",
		success : function(data, textStatus) {
			if(data){
				if(data.message=='success'){
					$(".modal-body").text("删除成功");
					$("#myModal").modal('show');
				}else if (data.message=='falure'){
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
}
