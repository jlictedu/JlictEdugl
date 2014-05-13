<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>教学质量评估-主任</title>
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
		var evaluationSettingId;
		
		$(function () {
			evaluationSettingId = "${evaluationSettingId}";
			loadHeadData();
			initData();
		});
		
		function loadHeadData() {
			var para = {evaluationSettingId: evaluationSettingId};
			$.ajax({url:"directorOfHistory.do?m=initHeadInfoByDirector",type:"POST",data:para,dataType:"json",async:false,success:loadHeadDataCallback});
		}
		
		function loadHeadDataCallback(data) {
			document.getElementById("dept").innerHTML = data.educationCollege;
			document.getElementById("teacher").innerHTML = data.teacherName;
			document.getElementById("clazz").innerHTML = data.attendClass;
			document.getElementById("course").innerHTML = data.courseName;
		}
		
		function initData() {
			var para = {evaluationSettingId: evaluationSettingId};
			$.ajax({url:"directorOfHistory.do?m=initDataByDirector", type:"POST",data:para,dataType:"json",async:false,success:loadInitData});
		}
		
		function loadInitData(data) {
			if(data == null) {
				$.ligerDialog.warn("该课程暂时没有评估！", "提示", closeEvaluation);
			}
			
			fillData(getIndex(data.total), "evaluationTotal");
			
			if(data.idea != null) {
				$("#ideaContent").val(data.idea);
			}
		}
		
		function getIndex(data) {
			if(data == 10) {
				return 0;
			}
			if(data == 8) {
				return 1;
			}
			if(data == 6) {
				return 2;
			}
			if(data == 2) {
				return 3;
			}
			if(data == 0) {
				return 4;
			}
		}
		
		function fillData(index, target) {
			var element = document.getElementById(target +( index + 1));
			
			element.innerHTML = "√";
		}
		
		function closeEvaluation() {
			window.parent.closeReadWin();
		}
	</script>
</head>
	
<body>
	<div class ="table_container">
		<div class ="button_panel">
			<input type ="button" name ="evaluationSubmit" id ="evaluationSubmit" value ="提交" onClick = "evaluationSubmit()" />
			<input type ="button" name ="closeEvaluation" id ="closeEvaluation" value ="关闭" onClick = "closeEvaluation()" />
		</div>
		
		<table class ="editView">
			<tr>
			<td class="editView_td_style">所在教学院：</td><td id="dept"></td>
			<td class="editView_td_style">班级：</td><td  id="clazz"></td>
			<td class="editView_td_style">课程：</td><td  id="course"></td>
			<td class="editView_td_style">被评教师：</td><td  id="teacher"></td>
			</tr>
		</table>
	</div>
	
	<div class="table_container">
		<table class ="editView">
		<tr>
		<td class="editView_td_style">项目</td>
		<td class="editView_td_style">评估指标</td>
		<td class="editView_td_style" colspan ='5'>等级</td>
		</tr>
		
		<tr>
		<td class="editView_td_style" rowspan ='2'>教学效果</td>
		<td class="editView_td_style" rowspan = '2'>对授课教师教学情况的总体满意度</td>
		<td class="editView_td_style">很好</td>
		<td class="editView_td_style">较好</td>
		<td class="editView_td_style">一般</td>
		<td class="editView_td_style" width="58px">差</td>
		<td class="editView_td_style">较差</td>
		</tr>
		<tr>
		<td height=25 id="evaluationTotal1"></td>
		<td id="evaluationTotal2"></td>
		<td id="evaluationTotal3"></td>
		<td id="evaluationTotal4"></td>
		<td id="evaluationTotal5"></td>
		</tr>
		<tr>
		<td  class="editView_td_style">
			<p>意见及建议</p>
			<p>限500字以内</p>
		</td>
		<td colspan='6'><textarea id="ideaContent"  style="resize:none;width:100%;height:200px;"></textarea></td>
		</tr>
		</table>
	</div>
</body>
</html>