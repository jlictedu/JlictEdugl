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
	var validate={"#people":['digits:true']};
	
	$(function() {
		$("#create").click(create);
		$("#delete").click(del);
		$("#modify").click(modify);
		$("#query").click(query);
		widthAutoFit($('#name'));
		widthAutoFit($('#people'));
		//表格的初始化
		$_grid = $("#maingrid").ligerGrid( {columns : [ 
		{display : 'ID',	name : 'id',hide : true}, 
		{display : '部门名称',name : 'name',width : 200},
		{display : '上级部门名称',name : 'bossName',width : 200},
		{display : '现有员工人数',name : 'people',width : 100}
		],
		url : 'department.do?m=query',
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
			title : "创建部门",
			url : 'department.do?m=createInit',
			width : 350,
			height : 350,
			isHidden : false,
			slide : true,
			allowClose : true
		});
	}
	function del(){
		if ($_grid == null) {
			$.ligerDialog.warn('请选择要解散的部门！');
			return;
		}
		var row = $_grid.getSelectedRows()[0];
			if (!row) {
				$.ligerDialog.warn('请选择要解散的部门！');
				return;
			}
		if(row.people>0){
			$.ligerDialog.warn('该部门还拥有员工，不能解散！');
			return;
		}

		$.ligerDialog.confirm("确认解散" + row.name + "部门?", function(result) {
			if (!result) {
				return;

			} else {
				wait = $.ligerDialog.waitting("正在提交，请稍后...");
				$.ajax({url:'department.do?m=delete&id='+row.id,type:"post",async : false,success : function(result) {
				if (result.resultCode == '0') {
					$.ligerDialog.success('解散成功');
					query();
				} else {
					$.ligerDialog.error('解散失败'+result.text);
				}
				wait.close();
			}});
			}

		});
		
	}
	
	function modify(){
		if ($_grid == null) {
			$.ligerDialog.warn('请选择要修改的部门！');
			return;
		}
		var row = $_grid.getSelectedRows()[0];
			if (!row) {
				$.ligerDialog.warn('请选择要修改的部门！');
				return;
			}
		modifyDepartment(row);
	}
	
	function modifyDepartment(row){
		$.ligerDialog.open( {
			title : "修改部门",
			url : 'department.do?m=modifyInit&id='+row.id,
			width : 350,
			height : 350,
			isHidden : false,
			slide : true,
			allowClose : true
		});
	}
	
	function query(){
		var para = new Object();
		if($('#name').val().trim()!=''){
			para.name=$('#name').val();
		}
		if($('#people').val().trim()!=''){
			if(!checkValidate(validate)){
				return;
			}
			para.people=$('#people').val();
		}
		else{
			para.people=0;
		}
		$_grid.set({parms:para});
		$_grid.loadData();
	}
</script>



	</head>

	<body>
	<div class="table_container">
		<form id="form">
		<table cellspacing="0" cellpadding="0"  border="0" class="editView" >
		<tr style="height:30px;">
			<td width="100" class="editView_td_style" >部门名称</td>
	        <td width="200" ><input type="text" id="name" name="name" value=""/></td>
	        <td width="100" class="editView_td_style">最少在职人数</td>
	        <td width="200" ><input title="最少在职人数" type="text" id="people" name="people" value=""/></td>
			<td><div class="button_panel">
			<input type="button" name="query" id="query" value="查询" />
			<input type="button" name="create" id="create" value="创建" />
			<input type="button" name="modify" id="modify" value="修改" />
			<input type="button" name="delete" id="delete" value="解散" />
			</div></td>
		</tr>
		</table>
		</form>

	</div>
	<div id="maingrid"></div>
	
	</body>
</html>
