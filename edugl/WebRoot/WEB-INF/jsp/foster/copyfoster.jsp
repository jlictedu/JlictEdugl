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
			var yearSel;
			var wait;
			$(function(){
				$('#save').click(save);
				yearSel = $('#year').ligerComboBox({url:'foster.do?m=queryYear',
				valueField:'id',
				textField:'name',
				width: $('#year').parent().width()-2,
				selectBoxWidth:$('#year').parent().width()-2
				});
			});
			
			function save(){
				if(yearSel.getValue()==''){
					$.ligerDialog.warn('年份不能为空');
					return;
				}				
				var data={year:yearSel.getValue()};
				wait = $.ligerDialog.waitting("正在提交，请稍后...");
				$.ajax({url:'foster.do?m=copyfoster',data:data,type:'post',async:false,
				success:function(result){					
					if (result.resultCode == '0'){
						$.ligerDialog.success('复制成功');
						window.parent.refresh();
					}
					else{
						$.ligerDialog.error('复制失败'+result.text);
					}
					wait.close();
				}
				});
			}
		</script>
  </head>
  
  <body>
    <div class="button_panel">
			<input type="button" value="复制" id="save" />
		</div>
		<div class="table_container">

			<table class="editView" cellspacing="0" border="1">
				<tr height="30px">
				<td class="editView_td_style" width="30%">请选择欲将此培养方案<br>复制到的入学年份</td>
					<td width="70%"><select name="year" id="year" style="width:30%"></select></td>
				</tr>
			</table>
		</div>
  </body>
</html>