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
		var sendData = {};
		
		$(function () {
			$.ligerDialog.warn("提交修改申请，将重新审批，之前通过的审批将作废！");
			loadData();
		});
		
		function loadData() {
			document.getElementById("applyDate").innerHTML = "${data.applyDate}";
			$("#applyDate").val("${data.applyDate}");
			$("#courseProperty").val("${data.courseProperty}");
			$("#courseName").val("${data.courseName}");
			$("#materialName").val("${data.materialName}");
			$("#useClass").val("${data.useClass}");
			$("#isbn").val("${data.isbn}");
			$("#editor").val("${data.editor}");
			$("#revision").val("${data.revision}");
			$("#press").val("${data.press}");
			$("#tel").val("${data.tel}");
			$("#studentCount").val("${data.studentCount}");
			$("#teacherCount").val("${data.teacherCount}");
			switch("${data.director}") {
			case "0":
				document.getElementById("director").innerHTML = "未通过";
				break;
			case "1":
				document.getElementById("director").innerHTML = "通过";
				break;
			case "2":
				document.getElementById("director").innerHTML = "未处理";
				break;
			}
			switch("${data.dean}") {
			case "0":
				document.getElementById("dean").innerHTML = "未通过";
				break;
			case "1":
				document.getElementById("dean").innerHTML = "通过";
				break;
			case "2":
				document.getElementById("dean").innerHTML = "未处理";
				break;
			}
			if("${data.applyResult}" == "0") {
				document.getElementById("applyResult").innerHTML = "未采购";
			}
			else {
				document.getElementById("applyResult").innerHTML = "已采购";
			}
		}
		
		function checkedCourseProperty() {
			var courseProperty = $("#courseProperty").val();
			
			if(courseProperty == 0) {
				$.ligerDialog.error("请选择课程属性。");
				return false;
			}
			
			sendData["courseProperty"] = courseProperty;
			return true;
		}
		
		function checkedCourseName() {
			var course = $("#courseName").val();
			
			if(course == "") {
				$.ligerDialog.error("请填写课程名称。");
				return false;
			}
			
			sendData["courseName"] = course;
			return true;
		}
		
		function checkedMaterialName() {
			var materialName = $("#materialName").val();
			
			if(materialName == "") {
				$.ligerDialog.error("请填写教材名称。");
				return false;
			}
			
			sendData["materialName"] = materialName;
			return true;
		}
		
		function checkedUseClass() {
			var useClass = $("#useClass").val();
			
			if(useClass == "") {
				$.ligerDialog.error("请填写使用班级。");
				return false;
			}
			
			sendData["useClass"] = useClass;
			return true;
		}
		
		function checkedISBN() {
			var isbn = $("#isbn").val();
			
			if(isbn == "") {
				$.ligerDialog.error("请填写ISBN号。");
				return false;
			}
			
			sendData["isbn"] = isbn;
			return true;
		}
		
		function checkedEditor() {
			var editor = $("#editor").val();
			
			if(editor == "") {
				$.ligerDialog.error("请填写编者。");
				return false;
			}
			
			sendData["editor"] = editor;
			return true;
		}
			
		function checkedRevision() {
			var revision = $("#revision").val();
			
			if(revision == "") {
				$.ligerDialog.error("请填写版次。");
				return false;
			}
			
			sendData["revision"] = revision;
			return true;
		}
		
		function checkedPress() {
			var press = $("#press").val();
			
			if(press == "") {
				$.ligerDialog.error("请填写出版社。");
				return false;
			}
			
			sendData["press"] = press;
			return true;
		}
		
		function checkedTel() {
			var tel = $("#tel").val();
			
			if(tel == "") {
				$.ligerDialog.error("请填写联系人电话。");
				return false;
			}
			
			sendData["tel"] = tel;
			return true;
		}
		
		function checkedStudentCount() {
			var count = $("#studentCount").val();
			
			if(count == "") {
				$.ligerDialog.error("请填写学生需要教材数量。");
				return false;
			}
			
			if(isNaN(count)) {
				$.ligerDialog.error("请填写正确学生需要教材数量。");
				return false;
			}
			
			sendData["studentCount"] = count;
			return true;
		}
		
		function checkedTeacherCount() {
			var count = $("#teacherCount").val();
			
			if(count == "") {
				$.ligerDialog.error("请填写教师需要教材数量。");
				return false;
			}
			
			if(isNaN(count)) {
				$.ligerDialog.error("请填写正确教师需要教材数量。");
				return false;
			}
			
			sendData["teacherCount"] = count;
			return true;
		}
		
		function checkedData() {
			if(!checkedCourseProperty()) return false;
			if(!checkedCourseName()) return false;
			if(!checkedMaterialName()) return false;
			if(!checkedUseClass()) return false;
			if(!checkedISBN()) return false;
			if(!checkedEditor()) return false;
			if(!checkedRevision()) return false;
			if(!checkedPress()) return false;
			if(!checkedTel()) return false;
			if(!checkedStudentCount()) return false;
			if(!checkedTeacherCount()) return false;
			
			return true;
		}
		
		function assignSendData() {
			if(!checkedData()) return false;
			
			return true;
		}
		
		function updateApply() {
			if(!assignSendData()) return;
			sendData["id"] = "${data.id}";
			
			$.ajax({url:"materialFirst.do?m=updateApply",type:"POST",data:sendData,dataType:"json",async:false,success:updateApplyCallback});
		}
		
		function updateApplyCallback(result) {
			if(result.resultCode == 1) {
				$.ligerDialog.success("首次教材征订修改成功，请等待结果。");
				document.getElementById("add").disabled = true;
				window.parent.refrushGrid();
			}
			else {
				$.ligerDialog.error("首次教材征订修改失败。");
			}
		}
	</script>
</head>
	
<body>
	<div class="table_container">
		<table cellspacing="0" cellpadding="0"  border="0" class="editViewNoBorder">
			<tr >
				<td class="editView_td_style">申请时间</td>
				<td align="center" id="applyDate"></td>
				<td class="editView_td_style">课程属性</td>
				<td align="center">
					<select id="courseProperty">
						<option value="0">请选择课程属性</option>
						<option value="1">必修</option>
						<option value="2">考查</option>
					</select>
				</td>
				<td>
					<div class="button_panel">
						<input type="button" name="updateApply" id="updateApply" value="提交" onClick="updateApply()" />
					</div>
				</td>
			</tr>
		</table>
	</div>
	
	<div class="table_container">
		<table class="editView" style="margin-top: 20px">
		<tr>
		<td class="editView_td_style">课程名称</td><td align="center" colspan="5"><input id="courseName" style="text-align:center;width:100%;height: 25px;" /></td>
		</tr>
		
		<tr>
		<td class="editView_td_style">教材名称</td><td align="center" colspan="5"><input id="materialName" style="text-align:center;width:100%;height: 25px;" /></td>
		</tr>
		
		<tr>
		<td class="editView_td_style">使用班级</td><td align="center" colspan="5"><input id="useClass" style="text-align:center;width:100%;height: 25px;" /></td>
		</tr>
		
		<tr>
		<td class="editView_td_style">ISBN号</td><td align="center"><input id="isbn" style="text-align:center;width:100%;height: 25px;" /></td>
		<td class="editView_td_style">编者</td><td align="center" colspan="3"><input id="editor" style="text-align:center;width:100%;height: 25px;" /></td>
		</tr>
		
		<tr>
		<td class="editView_td_style">版次</td><td align="center"><input id="revision" style="text-align:center;width:100%;height: 25px;" /></td>
		<td class="editView_td_style">出版社</td><td align="center"><input id="press" style="text-align:center;width:100%;height: 25px;" /></td>
		<td class="editView_td_style">联系人电话</td><td align="center"><input id="tel" style="text-align:center;width:100%;height: 25px;" /></td>
		</tr>
		
		<tr>
		<td class="editView_td_style">学生数量</td><td align="center"><input id="studentCount" style="text-align:center;width:100%;height: 25px;" /></td>
		<td class="editView_td_style">教师数量</td><td align="center"><input id="teacherCount" style="text-align:center;width:100%;height: 25px;" /></td>
		</tr>
		
		<tr>
			<td class="editView_td_style">系审批结果</td><td id="director"  align="center"></td>
			<td class="editView_td_style">教学院审批结果</td><td id="dean" align="center"></td>
			<td class="editView_td_style">是否已采购</td><td id="applyResult" align="center"></td>
		</tr>
		</table>
	</div>
</body>
</html>