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
			//表格的初始化
			$_grid = $("#maingrid").ligerGrid(
					{
						columns : [ 
							{display : 'ID',name : 'id',hide : true},
							{display : 'ID',name : 'coding',hide : true},
							{display : 'ID',name : 'year',hide : true},
							{display : 'ID',name : 'teacherId',hide : true},
							{display : 'ID',name : 'evaluationId',hide : true},
							{display : 'ID',name : 'term',hide : true},
							{display : 'ID',name : 'deptId',hide : true},
							{display : '课程名称',name : 'name',width : 200},
							{display : '任课老师',name : 'teacherName',width : 200},
							{display : '上课班级',name : 'attendClass',width : 200},
							{display : '课程性质',name : 'attribute',width : 200},
							{display : '状态',name : 'status',width : 200,render: function(row) {
									return row.status = '开启';
							}}
						],
						url : 'studentOfEvaluation.do?m=initCourses',
						delayLoad : false,
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
		
		function initEvaluation()
		{
			if ($_grid == null) {
				$.ligerDialog.warn('请选择要评估的课程！');
				return;
			}
			
			var rows = $_grid.getSelectedRows();
			
			if (rows.length == 0) {
				$.ligerDialog.warn('请选择要评估的课程！');
				return;
			}
			
			if (rows.length > 1) {
				$.ligerDialog.warn('只能选择一个评估课程！');
				return;
			}
			
			var row = rows[0];
			
			initEvaluationByRow(row);
		}
		
		function initEvaluationByRow(row)
		{
			readWin = $.ligerDialog.open(
			{
				title : "课堂教学质量评估-" + row.course,
				url : 'studentOfEvaluation.do?m=initEvaluation&evaluationId=' + row.evaluationId,
				width : 960,
				height : 600,
				isResize : true,
				isHidden : false,
				slide : true,
				modal : true,
				allowClose : true
			});
		}
		
		function refreshGrid() {
			$_grid.loadData();
		}
	</script>
</head>
	
<body>
	<div class="table_container">
		<table cellspacing="0" cellpadding="0"  border="0" class="editViewNoBorder">
		<tr style="height:30px;">
		<td>
		<div class="button_panel">
			<input type="button" name="evaluate" id="evaluate" value="评估" onClick="initEvaluation()" />
			<input type="button" name="evaluate" id="evaluate" value="刷新" onClick="refreshGrid()" />
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