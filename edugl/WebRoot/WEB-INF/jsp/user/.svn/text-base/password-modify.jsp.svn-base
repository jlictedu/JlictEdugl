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
			var wait;
			$(function(){
				$('#modify').click(modify);
				widthAutoFit($('#old'));
				widthAutoFit($('#new'));
				widthAutoFit($('#confirm'));
			});
			function modify(){
				var data=$('#passwordForm').formSerialize();
				wait = $.ligerDialog.waitting("正在提交，请稍后...");
				$.ajax({url:'user.do?m=modifyPassword',data:data,type:'post',async:false,
				success:function(result){
					if (result.resultCode == '0'){
						$.ligerDialog.success('修改成功');
					}
					else{
						$.ligerDialog.error('修改失败'+result.text);
					}
					wait.close();
				}
				});
			}
		</script>
  </head>
  
  <body>
    <div class="button_panel">
			<input type="button" value="修改" id="modify" />
		</div>
		<div class="table_container">
			<form action="user.do?m=modifyPassword" method="post" id="passwordForm">
			<table class="editView" cellspacing="0" border="1">
				<tr>
					<td class="editView_td_style" width="30%">原密码</td>
					<td><input type="text" id="old" name="old" width="70%"></td>
				</tr>
				<tr>
					<td class="editView_td_style" width="30%">新密码</td>
					<td><input type="text" id="new" name="new" width="70%"></td>
				</tr>
				<tr>
					<td class="editView_td_style" width="30%">新密码确认</td>
					<td><input type="text" id="confirm" name="confirm" width="70%"></td>
				</tr>
			</table>
			</form>
		</div>
  </body>
</html>
