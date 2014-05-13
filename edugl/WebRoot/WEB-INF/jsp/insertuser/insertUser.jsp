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
	function insertUser()	 {
		var id = $("#id").val();
		var name = $("#name").val();
		var age = $("#age").val();
		var para = {id: id, name: name, age: age};
		
		$.ajax({url:"insertuser.do?m=insertUser",type:"POST",data:para,dataType:"json",async:false,success:loadData});
	}
	
	function loadData(data) {
		if(data.resultCode == 1) {
			$.ligerDialog.success("OK");
		}
		else {
			$.ligerDialog.warn("FAILED");
		}
	}
	
	</script>
</head>
	
<body>
	<div class="table_container">
		<input id="id"></input>
		<input id="name"></input>
		<input id="age"></input>
		
		
		<input id="insert" type="button" onClick="insertUser()" value="添加"/>
	</div>
	<!--startprint-->
	<div id="maingrid"></div>
	<!--endprint-->
</body>
</html>