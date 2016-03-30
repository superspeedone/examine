/**
 * 作者：yww
 * 全局函数对象调用初始化表格 调用方式 $.MyTable.init(tableID, dataURL, paramIDs, setParams, rownums);
 * @param tableID  表格table的id属性值
 * @param dataURL  请求获取数据地址
 * @param paramIDs   传入参数对应网页元素id属性值
 * @param setParams   表格显示设置参数，格式{height:460px,striped:true} 如果为空，设置为默认表格样式
 * @param rownums   表头
 * @returns 返回表格对象
 */
;
(function($) {
	$.extend({
			MyTable : {
				"create" : function(tableID, dataURL, paramIDs, setParams, columns) {
					this.oTableInit.Init(tableID, dataURL, paramIDs, setParams, columns);
					$(window).resize(function() {
						$('#' + tableID).bootstrapTable('resetView');
					});
					return $('#' + tableID);
				},
				"oTableInit" : {
					"Init" : function(tableID, dataURL, paramIDs, setParams, columns) {
						// 获取设置参数值,如果为空，设置成默认值
						var pStriped = (setParams.striped == undefined ? true : setParams.striped); // 隔行换色
						var pCache = (setParams.cache == undefined ? false : setParams.cache); // 缓存
						var pPageSize = (setParams.pageSize == undefined ? 10 : setParams.pageSize); // 每页显示多少行
						var pPagination = (setParams.pagination == undefined ? true : setParams.pagination); // 分页
						var pHeight = (setParams.height == undefined ? 460 : setParams.height); // 高度
						// 初始化table
						$('#' + tableID).bootstrapTable({
							url : dataURL, // 请求后台的URL（*）
							method : 'get', // 请求方式（*）
							dataType : "json", //数据类型
							// contentType: 'application/x-www-form-urlencoded',
							// 如果是post方式，必须添加contentType，否则没法传递参数
							toolbar : '#toolbar', // 工具按钮用哪个容器
							striped : pStriped, // 是否显示行间隔色
							cache : pCache, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
							pageSize : pPageSize, //每页显示多少行
							pageList : [ 10, 20, 30 ], // 可供选择的每页的行数（*）
							pageNumber : 1, // 初始化加载第一页，默认第一页
							pagination : pPagination, // 是否显示分页（*）
							clickToSelect : true, // 是否启用点击选中行
							maintainSelected : true,
							sortable : true, // 是否启用排序
							sortOrder : "asc", // 排序方式
							sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
							queryParams : queryParams, // 传递参数（*）
							queryParamsType : "limit",
							smartDisplay : true,
							paginationPreText : "上一页",
							paginationNextText : "下一页",
							height : pHeight, // 行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
							uniqueId : "id", // 每一行的唯一标识，一般为主键列
							cardView : false, // 是否显示详细视图
							detailView : false, // 是否显示父子表
							undefinedText : '-', //未定义的变量显示为"-"
							columns : columns, //列定义
							formatLoadingMessage : function() { // 加载显示文字
								return "请稍等，正在拼命加载中...";
							},
							formatNoMatches : function() { // 没有匹配的结果显示文字
								return '无符合条件的记录';
							}
						});
	                    //查询参数
						function queryParams(params) {
							var tempParams = {
								maxrows : params.limit,
								offset : params.offset,
								page : params.offset / params.limit + 1,
								sort : params.sort, // 排序列名
								sortOrder : params.order, // （desc，asc）
							};
							// 遍历自定义参数ID属性名称
							$.each(paramIDs, function(index, value) {
								tempParams[value] = $("#" + value).val();
							});
							return tempParams;
						}
					}
				}
			}
	});
})(jQuery);