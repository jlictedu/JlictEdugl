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
	var wait;
	//表格的初始化
	$(function() {
		
		$("#backup").click(backData);
		$("#download").click(downData);
		$("#query").click(query);
		$("#delete").click(delData);
		//表格的初始化
		$_grid = $("#maingrid").ligerGrid( {columns : [ 
		{display : '存档试卷 ',name : 'name',width : 200}
		],
		url : 'document.do?m=query',
			delayLoad :true,			
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
				download(row);
			}
		});
		query();
	});
	
	function download(){
	}
	
	function query(){		
		$_grid.loadData();
	}
	
	function backData(){
		wait = $.ligerDialog.waitting("正在备份，生成备份可能需要一段时间，请稍后...");
				$.ajax({url:'document.do?m=backup',type:"post",success : function(result) {
					if (result.resultCode == '0') {
						$.ligerDialog.success('备份成功');
						query();
					} else {
						$.ligerDialog.error('备份失败'+result.text);
					}
					wait.close();
				}});
	}
	
	function downData(){
		if ($_grid == null) {
			$.ligerDialog.warn('请选择要下载的备份！');
			return;
		}
		var row = $_grid.getSelectedRows()[0];
			if (!row) {
				$.ligerDialog.warn('请选择要下载的备份！');
				return;
			}
		download(row);
	}
	
	function delData(){
		if ($_grid == null) {
			$.ligerDialog.warn('请选择要删除的备份！');
			return;
		}
		var row = $_grid.getSelectedRows()[0];
			if (!row) {
				$.ligerDialog.warn('请选择要删除的备份！');
				return;
			}
			wait = $.ligerDialog.waitting("正在删除，请稍后...");
			var data = {file:row.name}
				$.ajax({url:'document.do?m=delete',type:"post",data:data,success : function(result) {
					if (result.resultCode == '0') {
						$.ligerDialog.success('删除成功');
					} else {
						$.ligerDialog.error('删除失败');
					}
					query();
					wait.close();
				}});
	}
	
	function download(row){
				window.open('document.do?m=download&file='+row.name);
	}
		
	</script>
	
  </head>
  
  <body>
  	<div class="button_panel">
    <input type="button" name="backup'" id="backup" value="备份" />
    <input type="button" name="delete" id="delete" value="删除" />
    </div>
    <div id="maingrid"></div>
  </body>
</html>