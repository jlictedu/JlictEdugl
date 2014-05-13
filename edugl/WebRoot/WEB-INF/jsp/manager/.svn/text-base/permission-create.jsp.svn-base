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
			var stationSel; 
			var roleSel;
			var wait;
			$(function(){
				$('#create').click(create);
				//widthAutoFit($('#station'));
				//widthAutoFit($('#permission'));
				//$.ajax({url:'permission.do?m=queryDepartment',type:'post',dataType:'json'});
				departmentSel = $('#department').ligerComboBox({url:'permission.do?m=queryDepartment',
				valueField:'id',
				textField:'name',
				width: $('#department').parent().width()-2,
				selectBoxWidth:$('#department').parent().width()-2
				});
				stationSel = $('#station').ligerComboBox({url:'permission.do?m=queryStation',
				valueField:'id',
				textField:'name',
				width: $('#station').parent().width()-2,
				selectBoxWidth:$('#station').parent().width()-2
				});
				roleSel = $('#role').ligerComboBox({url:'permission.do?m=queryRole',
				valueField:'id',
				textField:'name',
				width: $('#role').parent().width()-2,
				selectBoxWidth:$('#role').parent().width()-2
				});
			});
			
			function create(){
				if(departmentSel.getValue()==''){
					$.ligerDialog.warn('部门不能为空');
					return;
				}
				if(roleSel.getValue()==''){
					$.ligerDialog.warn('权限角色不能为空');
					return;
				}
				if(stationSel.getValue()==''){
					$.ligerDialog.warn('岗位不能为空');
					return;
				}
				var data={departmentId:departmentSel.getValue(),stationId:stationSel.getValue(),roleId:roleSel.getValue()};
				wait = $.ligerDialog.waitting("正在提交，请稍后...");
				$.ajax({url:'permission.do?m=create',data:data,type:'post',async:false,
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
			<input type="button" value="添加" id="create" />
		</div>
		<div class="table_container">

			<table class="editView" cellspacing="0" border="1">
				<tr height="30px">
					<td class="editView_td_style" width="30%">部门名称</td>
					<td width="70%"><select name="department" id="department"></select></td>
				</tr>
				<tr height="30px">
					<td class="editView_td_style" width="30%">岗位名称</td>
					<td width="70%"><select name="station" id="station"></select></td>
				</tr>
				<tr height="30px">
					<td class="editView_td_style" width="30%">权限角色</td>
					<td width="70%"><select name="role" id="role"></select></td>
				</tr>
			</table>
		</div>
  </body>
</html>
