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
		<script type="text/javascript">
			var wait;
			var array={
        		"#name":['required:true','maxlength:20']        	
        	};
        	var departmentSel;
			$(function(){
				$('#create').click(create);
				widthAutoFit($('#name'));
				widthAutoFit($('#bossId'));
				$('#bossId').click(function(){
					departmentSelect($('#bossId'));
					return false;
				});
			});
			function create(){
				if(!checkValidate(array)){
					return;
				}
				var data={name:$('#name').val()};
				if($('#bossId').val()!=''){
					data.bossId = $('#bossId').val();
				}
				wait = $.ligerDialog.waitting("正在提交，请稍后...");
				$.ajax({url:'department.do?m=create',data:data,type:'post',async:false,
				success:function(result){
					if (result.resultCode == '0'){
						$.ligerDialog.success('添加成功');
						window.parent.query();
					}
					else{
						$.ligerDialog.error('添加失败'+result.text);
					}
					wait.close();
				}
				});
			}
		</script>
  </head>
  
  <body>
    <div class="button_panel">
			<input type="button" value="创建" id="create" />
		</div>
		<div class="table_container">

			<table class="editView" cellspacing="0" border="1">
				<tr>
					<td class="editView_td_style" width="30%">部门名称</td>
					<td width="70%"><input title="部门名称" type="text" name="name" id="name" /></td>					
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
