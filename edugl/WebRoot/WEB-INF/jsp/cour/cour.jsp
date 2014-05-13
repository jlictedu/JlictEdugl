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
        $(function ()
        {	
        	$("#refresh").click(refresh);
        	$("#add").click(add);
            $("#update").click(update);
            $("#del").click(del);
            $("#ask").click(ask);
			
            //表格初始化
            $_grid = $("#maingrid").ligerGrid({
               
                columns: [ 
				{ display: 'ID', name: 'id',hide:true},
				{ display: '课程编码',name: 'coding',width : 70},
				{ display: '课程名称',name: 'name',width : 100},
                { display: '课程性质',name: 'attribute', width: 50, render:function (row){return row.attribute=='1'?'必修':'限选'}},
				{ display: '课程类别',name: 'sort',width : 100},
				{ display: '开课院系',name: 'boss',width : 100},
				{ display: '开课教研室',name:'dep',width : 100},
				{ display: '上课班级',name: 'Ban',width : 70},
				{ display: '上课人数',name: 'Number',width : 50},
				{ display: '教学周数',name: 'week',width : 50},
				{ display: '周学时数',name: 'weekTtime',width : 50},
                { display: '课程学分',name: 'credit', width: 50},                        
				{ display: '总学时数',name: 'allperiod', width: 50},
				{ display: '讲课学时',name: 'prelect', width: 50},
				{ display: '实验学时',name: 'experiment', width: 50},
                { display: '上机学时',name: 'computer', width:50},
				{ display: '考核方式',name: 'exam', width: 70, render:function (row){return row.exam=='1'?'考试':'考查'}}
                ],
                url: 'cour.do?m=querydown', 
                delayLoad: false,
                checkbox : false,
                width: '99.8%',  
                height: '99%',
				pageSize: 20,
				rownumbers:true,
				enabledSort:false,
				root :'rows',                          
				record:'total',                        
				pageParmName :'pageIndex',               
				pagesizeParmName:'pageSize',				
				onError:function(){
					ajaxError();
				},
				onDblClickRow: function(row){
					openupdate(row);
				}				
            });
        });
        
  		function add() {
		$.ligerDialog.open({
			title : "添加课程",
			url : 'cour.do?m=addcour',
			width : 650,
			height : 400,
			isHidden : false,
			slide : true,
			allowClose : true
		});
		}
        
        function ask() {
		$.ligerDialog.open( {
			title : "查询",
			url : 'cour.do?m=ask',
			width : 650,
			height : 270,
			isHidden : false,
			slide : true,
			allowClose : true
		});
		}
        
        //阅读窗口
        var readWin;
        
        //阅读按钮的处理
        function update(){
        	if($_grid==null){
        		$.ligerDialog.warn('请选择要修改的信息！'); return; 
        	}
        	var rows = $_grid.getSelectedRows();
            if (0==rows.length) { 
            	$.ligerDialog.warn('请选择要修改的信息！'); return; 
            }
            if(rows.length>1){ 
            	$.ligerDialog.warn('只能选择一条信息修改！'); return; 
            }
            openupdate(rows[0]);
        }
        
        //打开阅读窗口
		function openupdate(row) {
		readWin = $.ligerDialog.open( {
			title : "教学任务书",
			url : 'cour.do?m=update&id='+row.id,
			width : 650,
			height : 400,
			isResize : true,
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
		$.ligerDialog.confirm("确认删除" + row.name + '课程信息', function(result) {
			if (!result) {
				return;

			} else {
				var data={id:row.id};
				wait = $.ligerDialog.waitting("正在提交，请稍后...");
				$.ajax({url:'cour.do?m=deletecour',data:data,type:"post",async : false,success : function(result) {
					if (result.resultCode == '0') {
						$.ligerDialog.success('删除成功');
						refresh();
					} else {
						$.ligerDialog.error('删除失败'+result.text);
					}
					wait.close();
				}});
			}
		});		
	}
        
        //刷新表格
        function refresh(){
        	$_grid.loadData();
        }
   
    </script>

	</head>

	<body>
		<div class="button_panel">
			<input type="button" name="refresh" id="refresh" value="刷新" />
			<input type="button" name="add" id="add" value="添加" />
			<input type="button" name="update" id="update" value="修改" />
			<input type="button" name="del" id="del" value="删除" />
			<input type="button" name="ask" id="ask" value="查询" />
			
			
			
		</div>			
		<div align="center">
			<h2>${up.deptname}教学任务书</h2>					
		</div>
		<div>
					
		</div>
		
				

		
		<div id="maingrid"></div>
	</body>

</html>