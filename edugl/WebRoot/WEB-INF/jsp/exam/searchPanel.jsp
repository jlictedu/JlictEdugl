<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title></title>
		<link href="<%=path %>/css/common.css" rel="stylesheet"
			type="text/css" />
		<link href="<%=path %>/js/ligerUI/skins/Aqua/css/ligerui-all.css"
			rel="stylesheet" type="text/css" />
		<script src="<%=path %>/js/jquery/jquery-1.5.2.min.js"
			type="text/javascript"></script>
		<script src="<%=path %>/js/jquery/jquery.form.js"
			type="text/javascript"></script>
		<script src="<%=path %>/js/ligerUI/js/core/base.js"
			type="text/javascript"></script>
		<script src="<%=path %>/js/ligerUI/js/plugins/ligerGrid.js"
			type="text/javascript"></script>
		<script src="<%=path %>/js/ligerUI/js/plugins/ligerDialog.js"
			type="text/javascript"></script>
		<script src="<%=path %>/js/ligerUI/js/plugins/ligerResizable.js"
			type="text/javascript"></script>
		<script src="<%=path %>/js/common.js" type="text/javascript"></script>
		<script type="text/javascript">
	
var $_grid;
	//表格的初始化
	$(function() {
		$("#read").click(read);
		$("#delete").click(del);
		$("#refresh").click(refresh);

		$_grid = $("#maingrid").ligerGrid( {
	
			url : 'grade.do?m=query',
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
			$.ligerDialog.warn();
			return;
		}
		var rows = $_grid.getSelectedRows();
		if (0 == rows.length) {
			$.ligerDialog.warn();
			return;
		}
		if (rows.length > 1) {
			$.ligerDialog.warn();
			return;
		}
		openRead(rows[0]);
	}

	//打开阅读窗口
	function openRead(row) {
		readWin = $.ligerDialog.open( {
			title : "通知阅读",
			url :  'grade.do?m=readSearch&id=' + row.id,
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
		sendMessage({studentId:id});
	}
	
	//删除按钮的处理
	function del() {

		if ($_grid == null) {
			$.ligerDialog.warn();
			return;
		}
		var rows = $_grid.getSelectedRows();
		if (!rows) {
			$.ligerDialog.warn();
			return;
		}

		$.ligerDialog.confirm(function(result) {
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
					$.ligerDialog.success();
					refresh();
				}
				if (succesCount != rows.length) {
					$.ligerDialog.error((rows.length - succesCount));
				}
			}
		});
	}
	//刷新表格
	function refresh() {
		$_grid.loadData();
	}
</script>



	</head>

	<body>
		<div class="table_container">
		<table cellspacing="0" cellpadding="0"  border="0" class="editView" >
		<tr style="height:30px;">
			<td width="" class="editView_td_style" >学号</td>
	        <td width="150" ><input type="text" id="departmentName" name="departmentName" value=""/></td>
	        <td width="" class="editView_td_style">姓名</td>
	        <td width="150" ><input type="text" id="stationName" name="stationName" value=""/></td>
	        <td width="" class="editView_td_style">专业</td>
	        <td width="150" ><input type="text" id="roleName" name="roleName" value=""/></td>
			<td><div class="button_panel">
			<input type="button" name="query" id="query" value="查询" />			
			</div></td>
		</tr>
		</table>
		</div>
		<div id="maingrid"></div>
	</body>
</html>
