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
			var sortSel;
			var wait;
			$(function(){
				$('#save').click(save);
				sortSel = $('#sort').ligerComboBox({url:'foster.do?m=querySort',
				valueField:'id',
				textField:'name',
				width: $('#sort').parent().width()-2,
				selectBoxWidth:$('#sort').parent().width()-2
				});
			});
			
			function save(){
				if($('#coding').val()==''){
					$.ligerDialog.warn('课程编码不能为空');
					return;
				}
				if($('#name').val()==''){
					$.ligerDialog.warn('课程名称不能为空');
					return;
				}
				if($('#attribute').val()==''){
					$.ligerDialog.warn('课程性质不能为空');
					return;
				}
				if(sortSel.getValue()==''){
					$.ligerDialog.warn('课程类别不能为空');
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
				if($('#weeks').val()==''){
					$.ligerDialog.warn('教学周数不能为空');
					return;
				}
				if($('#weekcla').val()==''){
					$.ligerDialog.warn('周学时数不能为空');
					return;
				}
				var data={coding:$('#coding').val(), name:$('#name').val(), attribute:$('#attribute').val(), sort:sortSel.getValue(), term:$('#term').val(), exam:$('#exam').val(), prelect:$('#prelect').val(), experiment:$('#experiment').val(), computer:$('#computer').val() ,weeks:$('#weeks').val(), weekcla:$('#weekcla').val()};
				wait = $.ligerDialog.waitting("正在提交，请稍后...");
				$.ajax({url:'foster.do?m=savefoster',data:data,type:'post',async:false,
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
    
		<div class="table_container">

			<table class="editView" cellspacing="0" border="1">
				<tr height="30px">
					<td class="editView_td_style" width="30%">课程编码</td>
					<td width="70%"><input type="text" name="coding" id="coding" size="70px"></td>
				</tr>
				<tr height="30px">
					<td class="editView_td_style" width="30%">课程名称</td>
					<td width="70%"><input type="text" name="name" id="name" size="70px"></td>
				</tr>
				<tr height="30px">
					<td class="editView_td_style" width="30%">课程性质</td>
					<td width="70%"><select name="attribute" id="attribute" style="width:96%">
						<option value="1">必修</option>
						<option value="2">限选</option>
					</select></td>
				</tr>
				<tr height="30px">
					<td class="editView_td_style" width="30%">课程类别</td>
					<td width="70%"><select name="sort" id="sort"></select></td>
				</tr>
				<tr height="30px">
					<td class="editView_td_style" width="30%">开课学期</td>
					<td width="70%"><input type="text" name="term" id="term" size="70px"></td>
				</tr>
				<tr height="30px">
					<td class="editView_td_style" width="30%">考核方式</td>
					<td width="70%"><select name="exam" id="exam" style="width:96%">
						<option value="1">考试</option>
						<option value="2">考查</option>
					</select></td>
				</tr>
				<tr height="30px">
					<td class="editView_td_style" width="30%">讲课学时</td>
					<td width="70%"><input type="text" name="prelect" id="prelect" size="70px"></td>
				</tr>
				<tr height="30px">
					<td class="editView_td_style" width="30%">实验学时</td>
					<td width="70%"><input type="text" name="experiment" id="experiment" size="70px"></td>
				</tr>
				<tr height="30px">
					<td class="editView_td_style" width="30%">上机学时</td>
					<td width="70%"><input type="text" name="computer" id="computer" size="70px"></td>
				</tr>
				<tr height="30px">
					<td class="editView_td_style" width="30%">教学周数</td>
					<td width="70%"><input type="text" name="weeks" id="weeks" size="70px"></td>
				</tr>
				<tr height="30px">
					<td class="editView_td_style" width="30%">周学时数</td>
					<td width="70%"><input type="text" name="weekcla" id="weekcla" size="70px"></td>
				</tr>
			</table>
		</div>
		<div class="button_panel">
			<input type="button" value="保存" id="save" />
		</div>
  </body>
</html>