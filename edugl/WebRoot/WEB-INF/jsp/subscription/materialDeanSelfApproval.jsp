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
			loadData();
		});
		
		function loadData() {
			document.getElementById("applyDate").innerHTML = "${data.applyDate}";
			document.getElementById("materialName").innerHTML = "${data.materialName}";
			document.getElementById("useClass").innerHTML = "${data.useClass}";
			document.getElementById("isbn").innerHTML = "${data.isbn}";
			document.getElementById("editor").innerHTML = "${data.editor}";
			document.getElementById("price").innerHTML = "${data.price}";
			document.getElementById("press").innerHTML = "${data.press}";
			document.getElementById("count").innerHTML = "${data.count}";
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
		}
		
		function approval() {
			var approvalAction =  $("#approvalAction").val();
			
			if(approvalAction == 0) {
				$.ligerDialog.error("请选择审批操作。");
				return;
			}
			approvalAction = approvalAction == 1 ? "1" : "0";
			
			var para = {id:getUrlParam('id'), approvalAction : approvalAction};
			
			$.ajax({url:"materialDeanSelf.do?m=approval",type:"POST",data:para,dataType:"json",async:false,success:approvalCallback});
		}
		
		function approvalCallback(data) {
			if(data.resultCode == 1) {
				$.ligerDialog.success("自编教材审批成功。");
				document.getElementById("approval").disabled = true;
				window.parent.refreshGrid();
			}
			else {
				$.ligerDialog.error("自编教材审批失败。");
			}
		}
	</script>
</head>
	
<body>
	<div class="table_container">
		<table cellspacing="0" cellpadding="0"  border="0" class="editViewNoBorder">
			<tr >
				<td class="editView_td_style">审批操作</td>
				<td align="center">
					<select id="approvalAction">
						<option value="0">请选择审批操作</option>
						<option value="1">通过</option>
						<option value="2">不通过</option>
					</select>
				</td>
				<td>
					<div class="button_panel">
						<input type="button" name="approval" id="approval" value="提交" onClick="approval()" />
					</div>
				</td>
			</tr>
		</table>
	</div>
	
	<div class="table_container">
		<table class="editView" style="margin-top: 20px">
			<tr >
				<td class="editView_td_style">申请时间</td>
				<td id="applyDate" align="center"></td>
				<td class="editView_td_style">系审批结果</td><td id="director"  align="center"></td>
				<td class="editView_td_style" width="20%">教学院审批结果</td><td id="dean" align="center"></td>
			</tr>
			
			<tr>
				<td class="editView_td_style">教材名称</td><td id="materialName" align="center" colspan="5"></td>
			</tr>
			
			<tr>
				<td class="editView_td_style">使用班级</td><td id="useClass" align="center" colspan="5"></td>
			</tr>
			
			<tr>
				<td class="editView_td_style" width="15%">ISBN号</td><td id="isbn" align="center" width="15%"></td>
				<td class="editView_td_style" width="15%">编者</td><td id="editor" align="center" colspan="3"></td>
			</tr>
			
			<tr>
				<td class="editView_td_style">单价（元）</td><td id="price" align="center"></td>
				<td class="editView_td_style">出版社</td><td id="press" align="center" width="20%"></td>
				<td class="editView_td_style">数量</td><td id="count" align="center"></td>
			</tr>
		</table>
	</div>
</body>
</html>