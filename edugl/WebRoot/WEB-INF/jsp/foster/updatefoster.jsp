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
				if($('#attribute').val()==''){
					$.ligerDialog.warn('课程性质不能为空');
					return;
				}
				if($('#term').val()==''){
					$.ligerDialog.warn('开课学期不能为空');
					return;
				}
				if($('#exam').val()==''){
					$.ligerDialog.warn('考核方式不能为空');
					return;
				}
				if($('#prelect').val()==''){
					$.ligerDialog.warn('讲课学时不能为空');
					return;
				}
				
				var data={coding:$('#coding').val(), name:$('#name').val(), attribute:$('#attribute').val(), sort:$('#sort').val(), term:$('#term').val(), exam:$('#exam').val(), prelect:$('#prelect').val(), experiment:$('#experiment').val(), computer:$('#computer').val() ,weeks:$('#weeks').val(), weekcla:$('#weekcla').val() };
				wait = $.ligerDialog.waitting("正在提交，请稍后...");
				$.ajax({url:'foster.do?m=updatefoster',data:data,type:'post',async:false,
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
					<td class="editView_td_style" width="30%">课程类别</td>
					<td width="70%"><input type="text" value="${up.sort}" size="70px" readonly="readonly"></td>
				</tr>
				<tr height="30px">
					<td class="editView_td_style" width="30%">课程性质</td>
					<td width="70%"><select name="attribute" id="attribute" style="width:96%">
						<option value="1" selected="${up.attribute}">必修</option>
						<option value="2" selected="${up.attribute}">限选</option>
					</select></td>
				</tr>
				<tr height="30px">
					<td class="editView_td_style" width="30%">开课学期</td>
					<td width="70%"><input type="text" name="term" id="term" value="${up.term}" size="70px"></td>
				</tr>
				<tr height="30px">
					<td class="editView_td_style" width="30%">考核方式</td>
					<td width="70%"><select name="exam" id="exam"  style="width:96%">
						<option value="1" selected="${up.exam}">考试</option>
						<option value="2" selected="${up.exam}">考查</option>
					</select></td>
				</tr>
				<tr height="30px">
					<td class="editView_td_style" width="30%">教学周数</td>
					<td width="70%"><input type="text" name="weeks" id="weeks" value="${up.weeks}" size="70px"></td>
				</tr>
				<tr height="30px">
					<td class="editView_td_style" width="30%">周学时数</td>
					<td width="70%"><input type="text" name="weekcla" id="weekcla" value="${up.weekcla}" size="70px"></td>
				</tr>
				<tr height="30px">
					<td class="editView_td_style" width="30%">讲课学时</td>
					<td width="70%"><input type="text" name="prelect" id="prelect" value="${up.prelect}" size="70px"></td>
				</tr>
				<tr height="30px">
					<td class="editView_td_style" width="30%">实验学时</td>
					<td width="70%"><input type="text" name="experiment" id="experiment" value="${up.experiment}" size="70px"></td>
				</tr>
				<tr height="30px">
					<td class="editView_td_style" width="30%">上机学时</td>
					<td width="70%"><input type="text" name="computer" id="computer" value="${up.computer}" size="70px"></td>
				</tr>
			</table>
			<input type="hidden" name="sort" id="sort" value="${up.sortid}"/>
		</div>
		<div class="button_panel">
			<input type="button" value="保存" id="save" />
		</div>
  </body>
</html>