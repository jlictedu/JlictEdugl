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
	    <script src="js/ligerUI/js/ligerui.min.js" type="text/javascript" charset="utf-8"></script> 
		<script src="<%=path %>/js/common.js" type="text/javascript"></script>
		<script type="text/javascript"><!--
	$(function() {
		$.ajax( {
			url : 'user.do?m=dept&r=' + Math.random(),
			dataType : "json",
			success : createDeptTree,
			type:'post'
		});
		$('#sure').click(function(){
			window.returnValue = returnObject;
		});
	});
	var tree;
	var returnObject = new Object();
	//生成树
	function createDeptTree(result) {
		var data = result;		

		//生成树

		tree = $("#tree").ligerTree( {
			data : data,
			checkbox : false,
			slide : true,
			cache : false,
			idFieldName:'id',
			textFieldName :'name',	
			parentIDFieldName :'bossId',
			onSelect:function(node){
				returnObject.id = node.data.id;
				returnObject.name = node.data.name;
			}
		});
	}
--></script>
	</head>

	<body>
		<button id="sure" >确定</button>
		<div id="tree"></div>
	</body>
</html>
