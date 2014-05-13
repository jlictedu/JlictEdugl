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
	
	$(function() {
		$("#query").click(query);
		$("#read").click(readLog);
		//表格的初始化
		$_grid = $("#maingrid").ligerGrid( {columns : [ 
		{display : '日志文件名',name : 'name',width : 200}
		],
		url : 'log.do?m=query',
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
				read(row);
			}
		});
		query();
	});
	
	function query(){		
		$_grid.loadData();
	}
	
	function readLog(){
        	if($_grid==null){
        		$.ligerDialog.warn('请选择要阅读的日志！'); return; 
        	}
        	var rows = $_grid.getSelectedRows();
            if (0==rows.length) { 
            	$.ligerDialog.warn('请选择要阅读的日志！'); return; 
            }
            if(rows.length>1){ 
            	$.ligerDialog.warn('只能选择一条日志阅读！'); return; 
            }
            read(rows[0]);
        }
	
	function read(row){
		
		$.ligerDialog.open( {
			title : "阅读日志",
			url : 'log.do?m=read&name='+row.name,
			width : 950,
			height : 600,
			isHidden : false,
			slide : true
		});
	}
	</script>



	</head>

	<body>
		<div class="button_panel">
			<input type="button" name="query" id="query" value="查询" />
			<input type="button" name="read" id="read" value="查看" />
		</div>
	
	<div id="maingrid"></div>
	
	</body>
</html>