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
		<script src="<%=path %>/js/ligerUI/js/ligerui.min.js"
			type="text/javascript"></script>
		<script src="<%=path %>/js/ligerUI/js/plugins/ligerGrid.js"
			type="text/javascript"></script>
		<script src="<%=path %>/js/ligerUI/js/plugins/ligerDialog.js"
			type="text/javascript"></script>
		<script src="<%=path %>/js/ligerUI/js/plugins/ligerResizable.js"
			type="text/javascript"></script>
		<script src="<%=path %>/js/common.js" type="text/javascript"></script>
		<script type="text/javascript">
			var departmentSel;
			var wait;
			$(function(){
				$('#save').click(save);
				departmentSel = $('#department').ligerComboBox({url:'foster.do?m=queryDepartment',
				valueField:'id',
				textField:'name',
				width: $('#department').parent().width()-2,
				selectBoxWidth:$('#department').parent().width()-2
				});
			});
			
			function save(){
				if(departmentSel.getValue()==''){
					$.ligerDialog.warn('院系不能为空');
					return;
				}
				if($('#year').val()==''){
					$.ligerDialog.warn('入学年份不能为空');
					return;
				}
				if($('#year').val()>9999||$('#year').val()<1000){
					$.ligerDialog.warn('入学年份为四位数字');
					return;
				}
				
				var data={departmentId:departmentSel.getValue(),year:$('#year').val()};
				wait = $.ligerDialog.waitting("正在提交，请稍后...");
				$.ajax({url:'foster.do?m=saveall',data:data,type:'post',async:false,
				success:function(result){					
					if (result.resultCode == '0'){
						$.ligerDialog.success('添加成功');
						window.parent.refresh();
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
			<input type="button" value="添加" id="save" />
		</div>
		<div class="table_container">

			<table class="editView" cellspacing="0" border="1">
				<tr height="30px">
					<td class="editView_td_style" width="30%">院系名称</td>
					<td width="70%"><select name="department" id="department"></select></td>
				</tr>
				<tr height="30px">
					<td class="editView_td_style" width="30%">入学年份</td>
					<td width="70%"><input type="text" name="year" id="year" size="70px"></td>
				</tr>
			</table>
		</div>
  </body>
</html>