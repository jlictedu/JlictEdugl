<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title></title>
		<link href="<%=path%>/css/common.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/js/ligerUI/skins/Aqua/css/ligerui-all.css"
			rel="stylesheet" type="text/css" />
		<script src="<%=path%>/js/jquery/jquery-1.5.2.min.js"
			type="text/javascript"></script>
		<script src="<%=path%>/js/jquery/jquery.form.js"
			type="text/javascript"></script>
		<script src="<%=path%>/js/ligerUI/js/core/base.js"
			type="text/javascript"></script>
		<script src="<%=path%>/js/ligerUI/js/plugins/ligerGrid.js"
			type="text/javascript"></script>
		<script src="<%=path%>/js/ligerUI/js/plugins/ligerDialog.js"
			type="text/javascript"></script>
		<script src="<%=path%>/js/ligerUI/js/plugins/ligerResizable.js"
			type="text/javascript"></script>
		<script src="<%=path%>/js/common.js" type="text/javascript"></script>
		<script type="text/javascript">
	var $_grid;
	//表格的初始化
	$(function() {
		$("#read").click(read);
		$("#delete").click(del);
		$("#refresh").click(refresh);

		$_grid = $("#maingrid").ligerGrid( {

			columns : [ {
				display : 'ID',
				name : 'id',
				hide : false
			}, {
				display : '教师姓名',
				name : 'name',
				width : 100
			}, {
				display : '职称',
				name : 'jobTitle',
				width : 200
			}, {
				display : '提交内容',
				name : 'message',
				width : 200
			}, {
				display : '提交期限',
				name : 'sumbitTime',
				width : 200
			}, {
				display : '提交情况',
				name : 'completing',
				width : 200
			}],
			url : 'sumbit.do?m=query',
			delayLoad : false,
			checkbox : true,
			width : '99.8%',
			height : '99%',
			pageSize : 20,
			rownumbers : true,
			enabledSort : false,
			root : 'rows',
			record : 'total',
			pageParmName : 'pageIndex',
			pagesizeParmName : 'pageSize',
			onError : function() {
				ajaxError();
			},
			onDblClickRow : function(row) {
				openRead(row);
			}
		});
	});

	//阅读窗口
	var readWin;

	//阅读按钮的处理
	function read() {
		if ($_grid == null) {
			$.ligerDialog.warn('请选择要阅读的通知！');
			return;
		}
		var rows = $_grid.getSelectedRows();
		if (0 == rows.length) {
			$.ligerDialog.warn('请选择要阅读的通知！');
			return;
		}
		if (rows.length > 1) {
			$.ligerDialog.warn('只能选择一条通知阅读！');
			return;
		}
		openRead(rows[0]);
	}

	//打开阅读窗口
	function openRead(row) {
		readWin = $.ligerDialog.open( {
			title : "通知阅读",
			url : 'sumbit.do?m=readSumbit&id=' + row.id,
			width : 650,
			height : 450,
			isResize : true,
			isHidden : false,
			slide : true,
			allowClose : true
		});
		$_grid.updateCell('readFlag', true, row);
	}
	
	//打开回复窗口
	function reply(id){
		sendMessage({userId:id});
	}
	
	//删除按钮的处理
	function del() {

		if ($_grid == null) {
			$.ligerDialog.warn('请选择要删除的通知！');
			return;
		}
		var rows = $_grid.getSelectedRows();
		if (!rows) {
			$.ligerDialog.warn('请选择要删除的通知！');
			return;
		}

		$.ligerDialog.confirm("确认删除" + rows.length + "条通知?", function(result) {
			if (!result) {
				return;

			} else {
			//确认删除
				var succesCount = 0;
				for (i in rows) {
					if (deleteMessage(rows[i].id)) {
						succesCount++;
					}
				}
				//统计删除结果
				if (succesCount > 0) {
					$.ligerDialog.success('成功删除了' + succesCount + '条通知');
					refresh();
				}
				if (succesCount != rows.length) {
					$.ligerDialog.error((rows.length - succesCount) + '条通知删除失败');
				}

			}

		});

	}

	//删除一条通知
	function deleteMessage(id) {
		var re;
		$.ajax( {
			url : 'inbox.do?m=delete&id=' + id,
			type : "get",
			success : function(result) {
				if (result.resultCode == '0') {
					re = true;
				} else {
					re = false;
				}
			},
			async : false
		});
		return re;
	}
	
	

	//刷新表格
	function refresh() {
		$_grid.loadData();
	}
</script>

	</head>

	<body>
		<div class="button_panel">
			<input type="button" name="refresh" id="refresh" value="刷新" />
			<input type="button" name="read" id="read" value="阅读" />
			<input type="button" name="edit" id="edit" value="添加" />
			<input type="button" name="delete" id="delete" value="删除" />
		</div>


		<div id="maingrid"></div>
	</body>
</html>
