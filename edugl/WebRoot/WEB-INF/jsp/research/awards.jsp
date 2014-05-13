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
			document.getElementById('title').innerHTML = '${data.title}';
			document.getElementById('periodical').innerHTML = '${data.periodical}';
			document.getElementById('postTime').innerHTML = '${data.postTime}';
			document.getElementById('role').innerHTML = '${data.role}';
			document.getElementById('level').innerHTML = '${data.level}';
			document.getElementById('name').innerHTML = '${data.name}';
		})
		</script>
	</head>

	<body>
		<div class="table_container">

			<table class="editView" cellspacing="0" border="1">
				<tr>
					<td class="editView_td_style" width="30%">论文题目</td>
					<td><input title="论文题目" type="text" id="title" name="title" value="${thesis.title}" width="70%"></td>
				</tr>
				<tr>
					<td class="editView_td_style" width="30%">上级部门</td>
					<td width="70%"><select name="bossId" id="bossId">
							<option value="">-请选择部门-</option></select>						
					</td>					
				</tr>
			</table>
		</div>
	</body>
</html>
