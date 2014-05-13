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
			var array={
        		"#name":['required:true','maxlength:20']        	
        	};
			$(function(){
				$('#modify').click(modify);
				widthAutoFit($('#name'));
			});
			function modify(){
				if(!checkValidate(array)){
					return;
				}
				var data={name:$('#name').val(),id:getUrlParam('id')};
				wait = $.ligerDialog.waitting("正在提交，请稍后...");
				$.ajax({url:'station.do?m=modify',data:data,type:'post',async:false,
				success:function(result){
					if (result.resultCode == '0'){
						$.ligerDialog.success('修改成功');
						window.parent.query();
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

			<table class="editView" cellspacing="0" border="1">
				<tr>
					<td class="editView_td_style" width="30%">岗位名称</td>
					<td><input type="text" id="name" name="name" value="${station.name}" width="70%"></td>
				</tr>
			</table>
		</div>
  </body>
</html>