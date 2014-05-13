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
	$(function () {
		var para={id:getUrlParam('id')};
		$.ajax({url:'material.do?m=readApply',data:para,type:'post',dataType:'json',success:loadData});
	});
	
	function loadData(data) {
		document.getElementById("applyDate").innerHTML = data.applyDate;
		if(data.courseProperty == "1") {
			document.getElementById("courseProperty").innerHTML = "必修";
		}
		else {
			document.getElementById("courseProperty").innerHTML = "选修";
		}
		document.getElementById("materialName").innerHTML = data.materialName;
		document.getElementById("useClass").innerHTML = data.useClass;
		document.getElementById("isbn").innerHTML = data.isbn;
		document.getElementById("editor").innerHTML = data.editor;
		document.getElementById("revision").innerHTML = data.revision;
		document.getElementById("press").innerHTML = data.press;
		document.getElementById("tel").innerHTML = data.tel;
		document.getElementById("studentCount").innerHTML = data.studentCount;
		document.getElementById("teacherCount").innerHTML = data.teacherCount;
		if(data.applyResult == "0") {
			document.getElementById("applyResult").innerHTML = "未采购";
		}
		else {
			document.getElementById("applyResult").innerHTML = "已采购";
		}
	}
	</script>
</head>
	
<body>
	<div class="table_container">
		<table cellspacing="0" cellpadding="0"  border="0" class="editViewNoBorder">
			<tr >
				<td class="editView_td_style">申请时间</td>
				<td id="applyDate" align="center"></td>
				<td class="editView_td_style">课程属性</td>
				<td id="courseProperty" align="center"></td>
			</tr>
		</table>
	</div>
	
	<div class="table_container">
		<table class="editView" style="margin-top: 20px">
		<tr>
		<td class="editView_td_style" width="10%">课程名称</td><td align="center" colspan="5" id="courseName"></td>
		</tr>
		
		<tr>
		<td class="editView_td_style">教材名称</td><td align="center" colspan="5" id="materialName"></td>
		</tr>
		
		<tr>
		<td class="editView_td_style">使用班级</td><td align="center" colspan="5" id="useClass"></td>
		</tr>
		
		<tr>
		<td class="editView_td_style">ISBN号</td><td align="center" width="15%" id="isbn"></td>
		<td class="editView_td_style" width="10%">编者</td><td align="center" colspan="3" id="editor"></td>
		</tr>
		
		<tr>
		<td class="editView_td_style">版次</td><td align="center" id="revision"></td>
		<td class="editView_td_style">出版社</td><td align="center" id="press" width="15%"></td>
		<td class="editView_td_style" width="10%">联系人电话</td><td align="center" id="tel"></td>
		</tr>
		
		<tr>
		<td class="editView_td_style">学生数量</td><td align="center" id="studentCount"></td>
		<td class="editView_td_style">教师数量</td><td align="center" id="teacherCount"></td>
		<td class="editView_td_style">是否已采购</td><td align="center" id="applyResult"></td>
		</tr>
		</table>
	</div>
</body>
</html>