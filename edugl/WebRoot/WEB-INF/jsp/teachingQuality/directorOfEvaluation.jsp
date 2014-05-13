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
		var sendData = {};
		var ideaContent = "意见及建议（希望主任认真填写，多提宝贵意见，以便于我们及时改进，非常感谢您的支持）：";
		var evaluationSettingId, personEvaluationId;
		var radioSelected = false;
		var radioSelectedValue;
		
		$(function () {
			evaluationSettingId = "${evaluationSettingId}";
			document.getElementById("ideaContent").value = ideaContent;
			loadHeadData();
			initData();
		});
		
		function loadHeadData() {
			var para = {evaluationSettingId: evaluationSettingId};
			$.ajax({url:"directorOfEvaluation.do?m=getHeadInfo",type:"POST",data:para,dataType:"json",async:false,success:loadHeadDataCallback});
		}
		
		function loadHeadDataCallback(data) {
			document.getElementById("dept").innerHTML = data.educationCollege;
			document.getElementById("teacher").innerHTML = data.teacherName;
			document.getElementById("clazz").innerHTML = data.attendClass;
			document.getElementById("course").innerHTML = data.courseName;
		}
		
		function initData() {
			var para = {evaluationSettingId: evaluationSettingId};
			$.ajax({url:"directorOfEvaluation.do?m=initData", type:"POST",data:para,dataType:"json",async:false,success:loadInitData});
		}
		
		function loadInitData(data) {
			if(data == null) return;
			$.ligerDialog.warn("你现在正在修改评估，如提交之前的评估将作废。");
			personEvaluationId = data.id;
			
			var radioObjs = document.getElementsByName("evaluationTotal");
			radioObjs[getIndex(data.total)].checked = true;
			
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
		
		function evaluationTotalChecked() {
			if(radioSelected) {
				return true;
			}
			
			$.ligerDialog.warn( "教学效果有未评估选项！");
			return false;
		}
		
		function radioOnClick() {
			radioSelected = true;
		}
		
		function assignSendData() {
			var radios = document.getElementsByName("evaluationTotal");
			
			for(var index in radios) {
				if(radios[index].checked) {
					radioSelectedValue = parseInt(radios[index].value);
				}
			}
			sendData["evaluationTotal"] = radioSelectedValue;
			
			if(document.getElementById("ideaContent").value != ideaContent)
				sendData["ideaContent"] = document.getElementById("ideaContent").value;
			else
				sendData["ideaContent"] = "";
			
			sendData["evaluationSettingId"] = evaluationSettingId;
			sendData["personEvaluationId"] = personEvaluationId;
		}
		
		function evaluationSubmit() {
			if(!evaluationTotalChecked()) return;
			
			assignSendData();
			$.ajax({url:"directorOfEvaluation.do?m=evaluationSubmit",type:"POST",data:sendData,dataType:"json",async:false,success:evaluationSubmitCallback});
		}
		
		function evaluationSubmitCallback(data) {
			if(data.resultCode == 1) {
				$.ligerDialog.success(data.text);
				document.getElementById("evaluationSubmit").disabled=true;
				return;
			}
			
			$.ligerDialog.error(data.text);
		}
		
		function ideaContentOnFocus() {
			var content = document.getElementById("ideaContent").value;
			
			if(content == ideaContent) {
				document.getElementById("ideaContent").value = "";
			}
		}
		
		function ideaContentOnBlur() {
			var content = document.getElementById("ideaContent").value;
			
			if(content == "") {
				document.getElementById("ideaContent").value = ideaContent;
			}
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
		<td class="editView_td_style">差</td>
		<td class="editView_td_style">较差</td>
		</tr>
		<tr>
		<td height=25><input type='radio' id = 'evaluationTotal' name='evaluationTotal' value=10 onClick="radioOnClick()" /></td>
		<td><input type='radio' id = 'evaluationTotal' name='evaluationTotal' value=8 onClick="radioOnClick()" /></td>
		<td><input type='radio' id = 'evaluationTotal' name='evaluationTotal' value=6 onClick="radioOnClick()" /></td>
		<td><input type='radio' id = 'evaluationTotal' name='evaluationTotal' value=2 onClick="radioOnClick()" /></td>
		<td><input type='radio' id = 'evaluationTotal' name='evaluationTotal' value=0 onClick="radioOnClick()" /></td>
		</tr>
		<tr>
		<td  class="editView_td_style">
			<p>意见及建议</p>
			<p>限500字以内</p>
		</td>
		<td colspan='6'><textarea id="ideaContent"  style="resize:none;width:100%;height:200px;" onfocus='ideaContentOnFocus()' onblur="ideaContentOnBlur()"></textarea></td>
		</tr>
		</table>
	</div>
</body>
</html>