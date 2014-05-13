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
	
	function insertUser() {
		var name = $("#name").val();
		var age = $("#age").val();
		var para = {name: name, age: age};
		
		$.ajax({url:"insertuser.do?m=insertuser",type:"POST",data:para,dataType:"json",async:false,success:loadData});
	}
	
	function loadData(data) {
		if(data == true) {
			$.ligerDialog.success('添加成功');
		}
	}
	</script>
</head>
	
<body>
	<div class="table_container">
		<table class="editView" style="margin-top: 30px;">
			<tr>
			<td>姓名：</td>
			<td><input id="name" type="text" /></td>
			</tr>
			
			<tr>
			<td>年龄：</td>
			<td><input id="age" type="text" /></td>
			</tr>
			<tr>
			<td><input id="submit" type="button" value="提交" onClick="insertUser()" /></td>
			</tr>
		</table>
	</div>
</body>
</html>