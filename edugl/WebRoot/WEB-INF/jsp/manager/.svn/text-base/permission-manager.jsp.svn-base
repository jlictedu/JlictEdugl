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
	var $_grid;
	var wait;
	//表格的初始化
	$(function() {
		$("#create").click(create);
		$("#delete").click(del);
		$("#query").click(query);
		widthAutoFit($('#departmentName'));
		widthAutoFit($('#stationName'));
		widthAutoFit($('#roleName'));
		$_grid = $("#maingrid").ligerGrid( {columns : [ 
		{display : 'DEPARTMENT_ID',	name : 'departmentId',hide : true}, 
		{display : '部门名称',name : 'departmentName',width : 200},
		{display : 'STATION_ID',	name : 'stationId',hide : true}, 
		{display : '岗位名称',name : 'stationName',width : 150},
		{display : 'ROLE_ID',	name : 'roleId',hide : true}, 
		{display : '权限角色',name : 'roleName',width : 300}
		],
		url : 'permission.do?m=query',
			delayLoad : true,			
			width : '99.8%',
			height : '99%',
			pageSize : 20,
			rownumbers : true,
			enabledSort : false,
			root : 'rows',
			record : 'total',
			pageParmName : 'pageIndex',
			pagesizeParmName : 'pageSize',
			onError : function() {
				ajaxError();
			},
			onDblClickRow : function(row) {
				modifyDepartment(row);
			}
		});
		query();
	});
	function create(){
		$.ligerDialog.open( {
			title : "添加权限",
			url : 'permission.do?m=createInit',
			width : 650,
			height : 350,
			isHidden : false,
			slide : true,
			allowClose : true
		});
	}
	function del(){
		if ($_grid == null) {
			$.ligerDialog.warn('请选择要删除的授权！');
			return;
		}
		var row = $_grid.getSelectedRows()[0];
			if (!row) {
				$.ligerDialog.warn('请选择要删除的授权！');
				return;
			}
		$.ligerDialog.confirm("确认删除" + row.departmentName + row.stationName +'的'+ row.roleName, function(result) {
			if (!result) {
				return;

			} else {
				var data={departmentId:row.departmentId, stationId:row.stationId ,roleId:row.roleId};
				wait = $.ligerDialog.waitting("正在提交，请稍后...");
				$.ajax({url:'permission.do?m=delete',data:data,type:"post",async : false,success : function(result) {
					if (result.resultCode == '0') {
						$.ligerDialog.success('删除成功');
						query();
					} else {
						$.ligerDialog.error('删除失败'+result.text);
					}
					wait.close();
				}});
			}
		});		
	}	
	
	function query(){
		var para = new Object();
		if($('#departmentName').val().trim()!=''){
			para.departmentName=$('#departmentName').val().trim();
		}
		if($('#stationName').val().trim()!=''){
			para.stationName=$('#stationName').val().trim();
		}
		if($('#roleName').val().trim()!=''){
			para.roleName=$('#roleName').val().trim();
		}
		$_grid.set({parms:para});
		$_grid.loadData();
	}
</script>



	</head>

	<body>
		<div class="table_container">
		<table cellspacing="0" cellpadding="0"  border="0" class="editView" >
		<tr style="height:30px;">
			<td width="100" class="editView_td_style" >部门名称</td>
	        <td width="150" ><input type="text" id="departmentName" name="departmentName" value=""/></td>
	        <td width="100" class="editView_td_style">岗位名称</td>
	        <td width="150" ><input type="text" id="stationName" name="stationName" value=""/></td>
	        <td width="100" class="editView_td_style">权限名称</td>
	        <td width="200" ><input type="text" id="roleName" name="roleName" value=""/></td>
			<td><div class="button_panel">
			<input type="button" name="query" id="query" value="查询" />
			<input type="button" name="create" id="create" value="添加" />
			<input type="button" name="delete" id="delete" value="删除" />
			</div></td>
		</tr>
		</table>
		</div>

		<div id="maingrid"></div>
	</body>
</html>
