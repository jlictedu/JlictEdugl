<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title></title>
		<link href="<%=path%>/css/common.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/js/ligerUI/skins/Aqua/css/ligerui-all.css"
			rel="stylesheet" type="text/css" />
		<script src="<%=path%>/js/jquery/jquery-1.5.2.min.js"
			type="text/javascript"></script>
		<script src="<%=path%>/js/jquery/jquery.form.js"
			type="text/javascript"></script>
		<script src="<%=path%>/js/ligerUI/js/core/base.js"
			type="text/javascript"></script>
		<script src="<%=path%>/js/ligerUI/js/plugins/ligerGrid.js"
			type="text/javascript"></script>
		<script src="<%=path%>/js/ligerUI/js/plugins/ligerDialog.js"
			type="text/javascript"></script>
		<script src="<%=path%>/js/ligerUI/js/plugins/ligerResizable.js"
			type="text/javascript"></script>
		<script src="<%=path%>/js/common.js" type="text/javascript"></script>
		<script type="text/javascript">
		$(function () {
			document.getElementById('id').innerHTML = '${data.id}';
			document.getElementById('rebuild').innerHTML = '${data.rebuild}';
			document.getElementById('resit').innerHTML = '${data.resit}';
			document.getElementById('examination').innerHTML = '${data.examination}';
			document.getElementById('atonic').innerHTML = '${data.atonic}';
			
		})
		</script>
	</head>

	<body>
		<table>
		<tr>
		<td>ID:</td><td id='id'></td>
		<td>Rebuild:</td><td id='rebuild'></td>
		<td>Resit:</td><td id='resit'></td>
		<td>Examination:</td><td id='examination'></td>
		<td>Atonic:</td><td id='atonic'></td>	
		</tr>
		</table>
	</body>
</html>
