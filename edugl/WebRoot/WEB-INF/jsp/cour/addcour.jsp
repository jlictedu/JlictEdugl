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
			var wait;
			$(function (){	
        		$("#save").click(save);
        	});
			function save(){			
				var data={coding:$('#coding').val(), name:$('#name').val(), attribute:$('#attribute').val(), sort:$('#sort').val(), term:$('#term').val(), exam:$('#exam').val(), prelect:$('#prelect').val(), experiment:$('#experiment').val(), computer:$('#computer').val() };
				wait = $.ligerDialog.waitting("正在提交，请稍后...");
				$.ajax({url:'cour.do?m=addteach',data:data,type:'post',async:false,
				success:function(result){					
					if (result.resultCode == '0'){
						$.ligerDialog.success('修改成功');
						window.parent.refresh();
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
    
		<div class="table_container">

			<table class="editView" cellspacing="0" border="1">
				<tr height="30px">
					<td class="editView_td_style" width="30%">课程编码</td>
					<td width="70%"><input type="text" name="coding" id="coding" value="${up.coding}" size="70px" readonly="readonly"></td>
				</tr>
				<tr height="30px">
					<td class="editView_td_style" width="30%">课程名称</td>
					<td width="70%"><input type="text" name="name" id="name" value="${up.name}" size="70px" readonly="readonly"></td>
				</tr>
				<tr height="30px">
					<td class="editView_td_style" width="30%">主讲教师</td>
					<td width="70%"><input type="text" value="${up.first}" size="70px" readonly="readonly"></td>
				</tr>
				<tr height="30px">
					<td class="editView_td_style" width="30%">助教教师</td>
					<td width="70%"><input type="text" value="${up.secend}" size="70px" readonly="readonly"></td>
				</tr>
				
				
			</table>
			<input type="hidden" name="sort" id="sort" value="${up.teachid1}"/>
			<input type="hidden" name="sort" id="sort" value="${up.teachid2}"/>
		</div>
		<div class="button_panel">
			<input type="button" value="保存" id="save" />
		</div>
  </body>
</html>