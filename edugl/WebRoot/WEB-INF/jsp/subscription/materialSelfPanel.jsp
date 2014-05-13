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
		var readWin;
		var addWin;
		
		$(function() {
			//表格的初始化
			$_grid = $("#maingrid").ligerGrid({
					columns : [
						{display : 'ID',name : 'id',hide : true},
						{display : '教材名称',name : 'materialName',width : 200},
						{display : '使用班级',name : 'useClass',width : 200},
						{display : '征订数量',name : 'count',width : 80},
						{display : '系意见',name : 'director',width : 80,render : function(row) {
							if(row.director == "2") {
								return row.direct = "未处理";
							}
							else {
								return row.direct == "0" ? "未通过" : "通过";
							}
						}},
						{display : '教学院意见',name : 'dean',width : 80,render : function(row) {
							if(row.dean == "2") {
								return row.dean = "未处理";
							}
							else {
								return row.dean == "0" ? "未通过" : "通过";
							}
						}},
						{display : '是否已采购',name : 'applyResult',width : 80,render : function(row) {
							return row.applyResult = row.applyResult == '0' ? '未采购' : '已采购';
						}}
					],
					url : 'materialSelf.do?m=queryApplys',
					delayLoad : true,
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
						initEvaluationByRow(row);
					}
				});
		});
		
		function queryApplys() {
			var year = $("#year").val();
			
			if(year == "") {
				$.ligerDialog.warn("请填写年份！");
				return;
			}
			
			if(isNaN(year)) {
				$.ligerDialog.warn("请填写正确的年份！");
				return;
			}
			
			var para = {year: year};
			$_grid.set({parms:para});
			$_grid.loadData();
		}
		
		function readApply() {
			if ($_grid == null) {
				$.ligerDialog.warn('请选择要阅读的申请！');
				return;
			}
			
			var rows = $_grid.getSelectedRows();
			
			if (rows.length == 0) {
				$.ligerDialog.warn('请选择要阅读的申请！');
				return;
			}
			
			if (rows.length > 1) {
				$.ligerDialog.warn('只能选择一个阅读申请！');
				return;
			}
			
			var row = rows[0];
			readApplyByRow(row);
		}
		
		function readApplyByRow(row) {
			readWin = $.ligerDialog.open({
				title : "教材征订-阅读",
				url : 'materialSelf.do?m=initReadApply&id=' + row.id,
				width : 960,
				height : 280,
				isResize : true,
				isHidden : false,
				slide : true,
				modal : true,
				allowClose : true
			});
		}
		
		function updateApply() {
			if ($_grid == null) {
				$.ligerDialog.warn('请选择要修改的申请！');
				return;
			}
			
			var rows = $_grid.getSelectedRows();
			
			if (rows.length == 0) {
				$.ligerDialog.warn('请选择要修改的申请！');
				return;
			}
			
			if (rows.length > 1) {
				$.ligerDialog.warn('只能修改一个申请！');
				return;
			}
			
			var row = rows[0];
			updateApplyByRow(row);
		}
		
		function updateApplyByRow(row) {
			readWin = $.ligerDialog.open({
				title : "教材征订-修改",
				url : 'materialSelf.do?m=initUpdateApply&id=' + row.id,
				width : 960,
				height : 260,
				isResize : true,
				isHidden : false,
				slide : true,
				modal : true,
				allowClose : true
			});
		}
		
		function addApply() {
			addWin = $.ligerDialog.open({
				title : "自编教材征订-申请",
				url : 'materialSelf.do?m=addApply',
				width : 640,
				height : 240,
				isResize : true,
				isHidden : false,
				slide : true,
				modal : true,
				allowClose : true
			});
		}
		
		function deleteApply() {
			if ($_grid == null) {
				$.ligerDialog.warn('请选择要删除的申请！');
				return;
			}
			
			var rows = $_grid.getSelectedRows();
			
			if (rows.length == 0) {
				$.ligerDialog.warn('请选择要删除的申请！');
				return;
			}
			
			if (rows.length > 1) {
				$.ligerDialog.warn('只能删除一个申请！');
				return;
			}
			
			var row = rows[0];
			
			deleteApplyByRow(row);
		}
		
		function deleteApplyByRow(row) {
			var id = row.id;
			
			if(row.result == "已采购") {
				$.ligerDialog.warn("对不起，该申请已经完成采购，无法撤销！");
				return;
			}
			
			var para = {id: id};
			$.ajax({url:"materialSelf.do?m=deleteApply",type:"POST",data:para,dataType:"json",async:false,success:deleteCallback});
		}
		
		function deleteCallback(data) {
			if(data.resultCode == 1) {
				$.ligerDialog.success("申请撤销成功！");
				$_grid.loadData();
				return;
			}
			
			$.ligerDialog.error("申请撤销失败！");
		}
		
		function refrushGrid() {
			$_grid.loadData();
		}
	</script>
</head>
	
<body>
	<div class="table_container">
		<table cellspacing="0" cellpadding="0"  border="0" class="editViewNoBorder">
		<tr style="height:30px;">
		<td class="editView_td_style">年份</td>
		<td><input id="year" style="text-align:center;width:20%;height: 25px;margin-left: 10px;" /></td>
		<td>
		<div class="button_panel">
			<input type="button" name="queryApplys" id="queryApplys" value="查询" onClick="queryApplys()" />
			<input type="button" name="addApply" id="addApply" value="申请" onClick="addApply()" />
			<input type="button" name="readApply" id="readApply" value="阅读" onClick="readApply()" />
			<input type="button" name="updateApply" id="updateApply" value="修改" onClick="updateApply()" />
			<input type="button" name="deleteApply" id="deleteApply" value="删除" onClick="deleteApply()" />
		</div>
		</td>
		</tr>
		</table>
	</div>
	<!--startprint-->
	<div id="maingrid"></div>
	<!--endprint-->
</body>
</html>