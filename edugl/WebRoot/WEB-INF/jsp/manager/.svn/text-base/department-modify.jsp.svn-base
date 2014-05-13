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
			var wait;
			var array={
        		"#name":['required:true','maxlength:20']        	
        	};

			$(function(){
				$('#modify').click(modify);
				widthAutoFit($('#name'));
				widthAutoFit($('#bossId'));				
				$('#bossId').click(function(){
					departmentSelect($('#bossId'));
					return false;
				});
				
			});
			function modify(){
				if(!checkValidate(array)){
					return;
				}
				var data={name:$('#name').val(),id:getUrlParam('id'),bossId:$('#bossId').val()};
				wait = $.ligerDialog.waitting("正在提交，请稍后...");
				$.ajax({url:'department.do?m=modify',data:data,type:'post',async:false,
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
		--></script>
  </head>
  
  <body>
    <div class="button_panel">
			<input type="button" value="修改" id="modify" />
		</div>
		<div class="table_container">

			<table class="editView" cellspacing="0" border="1">
				<tr>
					<td class="editView_td_style" width="30%">部门名称</td>
					<td><input title="部门名称" type="text" id="name" name="name" value="${department.name}" width="70%"></td>
				</tr>
				<tr>
					<td class="editView_td_style" width="30%">上级部门</td>
					<td width="70%"><select name="bossId" id="bossId">
							<option value="${department.bossId}"><c:if test="${department.bossName==null}">-请选择部门-</c:if>${department.bossName}</option></select>						
					</td>					
				</tr>
			</table>
		</div>
  </body>
</html>
