<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title></title>
		<link href="<%=path%>/css/common.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/js/ligerUI/skins/Aqua/css/ligerui-all.css"
			rel="stylesheet" type="text/css" />
		<script src="<%=path%>/js/jquery/jquery-1.5.2.min.js"
			type="text/javascript"></script>
		<script src="<%=path%>/js/jquery/jquery.form.js"
			type="text/javascript"></script>
		<script src="<%=path%>/js/ligerUI/js/core/base.js"
			type="text/javascript"></script>
		<script src="<%=path%>/js/ligerUI/js/plugins/ligerGrid.js"
			type="text/javascript"></script>
		<script src="<%=path%>/js/ligerUI/js/plugins/ligerDialog.js"
			type="text/javascript"></script>
		<script src="<%=path%>/js/ligerUI/js/plugins/ligerResizable.js"
			type="text/javascript"></script>
		<script src="<%=path%>/js/common.js" type="text/javascript"></script>
		<script type="text/javascript"><!--
	//表格控件
    	var $_grid;
        $(function ()
        {	
            $("#read").click(read);
            $("#add").click(add);
            $("#refresh").click(refresh);
            $("#del").click(del);
			
            //表格初始化
            $_grid = $("#maingrid").ligerGrid({
               
                columns: [ 
                { display: 'ID', name: 'id',hide:true},
				{ display: 'DEPT_ID', name: 'deptid',hide:true},
				{ display: '院系名称',name: 'deptname',width : 150},
                { display: '入学年份',name: 'year', width: 150}
                ],
                url: 'foster.do?m=query', 
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
					openRead(row);
				}				
            });
        });
        
        //阅读窗口
        var readWin;
        
        //阅读按钮的处理
        function read(){
        	if($_grid==null){
        		$.ligerDialog.warn('请选择要阅读的信息！'); return; 
        	}
        	var rows = $_grid.getSelectedRows();
            if (0==rows.length) { 
            	$.ligerDialog.warn('请选择要阅读的信息！'); return; 
            }
            if(rows.length>1){ 
            	$.ligerDialog.warn('只能选择一条信息阅读！'); return; 
            }
            openRead(rows[0]);
        }
        
        //打开阅读窗口
		function openRead(row) {
		readWin = $.ligerDialog.open( {
			title : "培养方案管理",
			url : 'foster.do?m=queryup&deptid=' + row.deptid+'&id='+row.id,
			width : 1150,
			height : 540,
			isResize : true,
			isHidden : false,
			slide : true,
			allowClose : true
		});
		}
		
        function add() {
		$.ligerDialog.open( {
			title : "添加年份",
			url : 'foster.do?m=addall',
			width : 650,
			height : 400,
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
		$.ligerDialog.confirm("确认删除" + row.deptname + row.year +'年基本信息', function(result) {
			if (!result) {
				return;

			} else {
				var data={deptid:row.deptid, id:row.id};
				wait = $.ligerDialog.waitting("正在提交，请稍后...");
				$.ajax({url:'foster.do?m=deleteall',data:data,type:"post",async : false,success : function(result) {
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
	--></script>
	</head>

	<body>
		<div class="button_panel">
			<input type="button" name="refresh" id="refresh" value="刷新" />
			<input type="button" name="add" id="add" value="添加年份" />
			<input type="button" name="read" id="read" value="详细信息" />
			<input type="button" name="del" id="del" value="删除" />
		</div>
		

		<div id="maingrid"></div>
		
	</body>
</html>
