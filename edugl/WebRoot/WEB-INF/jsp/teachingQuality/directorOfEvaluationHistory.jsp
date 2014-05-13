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
			$_grid = $("#maingrid").ligerGrid({
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
						if(row.status == '0') {
							return row.status = '关闭';
						}
							
						if(row.status == '1') {
							return row.status = '开启';
						}
					}}
				],
				url : 'directorOfHistory.do?m=getEvaluations',
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
					readEvaluationsByRow(row);
				}
			});
			
			initYears();
		});
		
		function initYears() {
			$.ajax({url:"directorOfHistory.do?m=getYears",type:"POST",dataType:"json",async:false,success:loadYears});
		}
		
		function loadYears(data) {
			var selectObj = document.getElementById("yearAction");
			
			selectObj.options.length = 0;
			selectObj.options[0] = new Option("请选择年份", 0);
			for(var i=0; i<data.length; i++) {
				selectObj.options[selectObj.length] = new Option(data[i], i + 1);
			}
		}
		
		function queryEvaluations() {
			var year, term, grade;
			
			year =  $("#yearAction").val();
			if(year == 0) {
				return $.ligerDialog.warn("请选择教学年份!");
			}
			
			term = $("#termAction").val(); 
			if(term == 0) {
				return $.ligerDialog.warn("请选择学期!");
			}
			
			grade = $("#gradeAction").val();
			if(grade == 0) {
				return $.ligerDialog.warn("请选择年级!");
			}
			
			var selectObj = document.getElementById("yearAction");
			
			year = parseInt(selectObj.options[selectObj.selectedIndex].text.substring(6)) - grade;
			term = (grade - 1) * 2 + parseInt(term);
			$_grid.set({parms:{year: year, term: term}});
			$_grid.loadData();
		}
		
		function readEvaluations() {
			if ($_grid == null) {
				$.ligerDialog.warn('请选择要查看的课程评估！');
				return;
			}
			
			var rows = $_grid.getSelectedRows();
			
			if (rows.length == 0) {
				$.ligerDialog.warn('请选择要查看的课程评估！');
				return;
			}
			
			if (rows.length > 1) {
				$.ligerDialog.warn('只能选择一个评估课程！');
				return;
			}
			
			var row = rows[0];
			
			readEvaluationsByRow(row);
		}
		
		function readEvaluationsByRow(row) {
			if($("#categoryAction").val() == 1) {
				readWin = $.ligerDialog.open({
					title : "课堂教学质量评估-" + row.course,
					url : 'directorOfHistory.do?m=readEvaluations&evaluationSettingId=' + row.evaluationId,
					width : 960,
					height : 560,
					isResize : true,
					isHidden : false,
					slide : true,
					modal : true,
					allowClose : true
				});
			}
			else {
				readWin = $.ligerDialog.open({
					title : "课堂教学质量评估-" + row.course,
					url : 'directorOfHistory.do?m=readEvaluation&evaluationSettingId=' + row.evaluationId,
					width : 960,
					height : 560,
					isResize : true,
					isHidden : false,
					slide : true,
					modal : true,
					allowClose : true
				});
			}
		}
		
		function refreshGrid() {
			$_grid.loadData();
		}
		
		function closeReadWin() {
			readWin.close();
		}
	</script>
</head>
	
<body>
	<div class="table_container">
		<table cellspacing="0" cellpadding="0"  border="0" class="editViewNoBorder">
		<tr style="height:30px;">
		<td width="100" class="editView_td_style"> 教学年份：</td>
		<td width="150" class="combox_td_style">
			<select id="yearAction"></select>
		</td>
		<td width="100" class="editView_td_style" >学期：</td>
		<td width="150" class="combox_td_style">
			<select id="termAction">
		 		<option value="0">请选择学期</option>
		 		<option value="1">第一学期</option>
		 		<option value="2">第二学期</option>
 			</select>
		</td>
		<td width="100" class="editView_td_style" >年级：</td>
		<td width="150" class="combox_td_style">
			<select id="gradeAction">
		 		<option value="0">请选择年级</option>
		 		<option value="1">大学一年级</option>
		 		<option value="2">大学二年级</option>
		 		<option value="3">大学三年级</option>
		 		<option value="4">大学四年级</option>
 			</select>
		</td>
		<td width="100" class="editView_td_style" >评估类别：</td>
		<td width="150" class="combox_td_style">
			<select id="categoryAction">
				<option value=1>学生评估</option>
				<option value=2>主任评估</option>
 			</select>
		</td>
		<td>
		<div class="button_panel">
			<input type="button" name="readEvaluation" id="readEvaluation" value="查询" onClick="queryEvaluations()" />
			<input type="button" name="readEvaluation" id="readEvaluation" value="阅读" onClick="readEvaluations()" />
			<input type="button" name="refreshGrid" id="refreshGrid" value="刷新" onClick="refreshGrid()" />
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