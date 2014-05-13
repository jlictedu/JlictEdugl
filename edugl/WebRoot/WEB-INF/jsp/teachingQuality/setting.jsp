<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>评估管理</title>
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
		var $_grade;
		
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
								if(row.status == null) {
									return row.status = '未开启';
								}
								
								if(row.status == '0') {
									return row.status = '关闭';
								}
								
								if(row.status == '1') {
									return row.status = '开启';
								}
							}}
						],
						url : "evaluateSetting.do?m=queryCourses",
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
		});
		
		function queryCourses() {
			var grade = $("#gradeAction").val();
			var para = {grade : grade};
			
			if(grade == 0) {
				$.ligerDialog.warn('请选择要查询的年级！');
				return;
			}
			$_grade = grade;
			
			$_grid.set({parms:para});
			$_grid.loadData();
		}
		
		function loadData(data) {
			$_grid.loadData(data);
		}
		
		function selectRowCheck(content) {
			if ($_grid == null) {
				$.ligerDialog.warn("请选择要" + content + "的评估！");
				return null;
			}
			
			var rows = $_grid.getSelectedRows();
			
			if (rows.length == 0) {
				$.ligerDialog.warn("请选择要" + content + "的评估！");
				return null;
			}
			
			if (rows.length > 1) {
				$.ligerDialog.warn("只能" + content + "一个评估！");
				return null;
			}
			
			return rows[0];
		}
		
		function refreshGrid() {
			var para = {grade: $_grade};
			
			$.ajax({url:"evaluateSetting.do?m=queryCourses",type:"POST",data:para,dataType:"json",async:false,success:loadData});
		}
		
		function openStatus() {
			//var grade = $("#gradeAction").val();
			var row = selectRowCheck("开启");
			
			if(row == null) {
				return;
			}
			
			if(row[5] == "开启") {
				$.ligerDialog.warn('该评估已开启！');
				return;
			}
			
			var para = {evaluationId: row['evaluationId']};
			
			$.ligerDialog.confirm('是否确认开启', function (yes) {
				if(yes == true) {
					$.ajax({url:"evaluateSetting.do?m=openStatus",data:para,dataType:"json",type:"post",async:false,success:openStatusCallback});
				}
			});
		}
		
		function closeStatus() {
			//var grade = $("#gradeAction").val();
			var row = selectRowCheck("关闭");
			
			if(row == null) {
				return;
			}
			
			if(row[5] == "关闭") {
				$.ligerDialog.warn('该评估已关闭！');
				return;
			}
			
			var para = {evaluationId: row['evaluationId']};
			
			$.ligerDialog.confirm('是否确认关闭', function (yes) {
				if(yes == true) {
					$.ajax({url:"evaluateSetting.do?m=closeStatus",data:para,dataType:"json",type:"post",async:false,success:closeStatusCallback});
				}
			});
		}
		
		function clearStatus() {
			//var grade = $("#gradeAction").val();
			var row = selectRowCheck("清除");
			
			if(row == null) {
				return;
			}
			
			if(row[5] == "已清除") {
				$.ligerDialog.warn('该评估已清除！');
				return;
			}
			
			var para = {evaluationId: row['evaluationId']};
			$.ligerDialog.confirm('是否确认关闭', function (yes) {
				if(yes == true) {
					$.ajax({url:"evaluateSetting.do?m=clearStatus",data:para,dataType:"json",type:"post",async:false,success:clearStatusCallback});
				}
			});
		}
		
		function openStatusCallback(result) {
			if(result.resultCode == 0) {
				$.ligerDialog.error("评估开启失败！");
				return;
			}
			
			$.ligerDialog.success("评估开启成功！");
			$_grid.loadData();
		}
		
		function closeStatusCallback(result) {
			if(result.resultCode == 0) {
				$.ligerDialog.error("评估关闭失败！");
				return;
			}
			
			$.ligerDialog.success("评估关闭成功！");
			$_grid.loadData();
		}
		
		function clearStatusCallback(result) {
			if(result.resultCode == 0) {
				$.ligerDialog.error("评估清除失败！");
				return;
			}
			
			$.ligerDialog.success("评估清除成功！");
			$_grid.loadData();
		}
	</script>
</head>
	
<body>
	<div class="table_container">
		<table cellspacing="0" cellpadding="0"  border="0" class="editViewNoBorder">
		<tr style="height:30px;">
		<td width="100" class="editView_td_style" >年级</td>
		<td width="150" class="combox_td_style">
			<select id="gradeAction">
		 		<option value="0">请选择年级</option>
		 		<option value="1">大学一年级</option>
		 		<option value="2">大学二年级</option>
		 		<option value="3">大学三年级</option>
		 		<option value="4">大学四年级</option>
 			</select>
		</td>
		<td>
		<div class="button_panel">
			<input type="button" name="queryCourses" id="queryCourses" value="查询" onClick="queryCourses()" />
			<input type="button" name="openStatus" id="openStatus" value="开启" onClick="openStatus()" />
			<input type="button" name="closeStatus" id="closeStatus" value="关闭" onClick="closeStatus()" />
			<input type="button" name="clearStatus" id="clearStatus" value="清除" onClick="clearStatus()" />
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