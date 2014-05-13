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
			document.getElementById('projectName').innerHTML = '${data.ptojectName}';
			document.getElementById('projectSources').innerHTML = '${data.projectSources}';
			document.getElementById('beginendTime').innerHTML = '${data.beginendTime}';
			document.getElementById('funds').innerHTML = '${data.funds}';
			document.getElementById('fundsAvaliable').innerHTML = '${data.fundsAvaliable}';
			document.getElementById('performance').innerHTML = '${data.performance}';
			document.getElementById('role').innerHTML = '${data.role}';
		})
		</script>
	</head>

	<body>
		<div class="table_container">

			<table class="editView" cellspacing="0" border="1">
				<tr>
					<td class="editView_td_style" width="30%">项目名称</td>
					<td><input title="项目名称" type="text" id="projectName" name="projectName" value="${thesis.title}" width="70%"></td>
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
