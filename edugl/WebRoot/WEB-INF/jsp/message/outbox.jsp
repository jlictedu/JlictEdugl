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
    	//表格控件
    	var $_grid;
        $(function ()
        {	
            $("#read").click(read);
            $("#send").click(send);
            $("#refresh").click(refresh);
            
            //表格初始化
            $_grid = $("#maingrid").ligerGrid({
               
                columns: [
                { display: 'ID', name: 'id',hide:true},
                { display: '阅读状态', name: 'readFlag', width: 150, render:function (row){return row.readFlag=='0'?'未被读取':'已被读取'}},
                { display: '主题', name: 'title', width: 200},
                { display: '收件人', name: 'receiver', width: 100},
                { display: '发送时间', name: 'sendDate', width: 150, render:function (row){return row.sendDate.substring(0,row.sendDate.length-2)} }                              
                ],
                url: 'outbox.do?m=query', 
                delayLoad: false,
                checkbox : true,
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
        		$.ligerDialog.warn('请选择要阅读的消息！'); return; 
        	}
        	var rows = $_grid.getSelectedRows();
            if (0==rows.length) { 
            	$.ligerDialog.warn('请选择要阅读的消息！'); return; 
            }
            if(rows.length>1){ 
            	$.ligerDialog.warn('只能选择一条消息阅读！'); return; 
            }
            openRead(rows[0]);
        }
        
        //打开阅读窗口
        function openRead(row){        	
            readWin=$.ligerDialog.open({ title:"消息阅读", url: 'outbox.do?m=read&id='+row.id, width: 650,height:450, isResize: true, isHidden: false,slide: true,allowClose: true});
            
        }
        
        //发送窗口
        var sendWin
        function send(){
        	sendWin = sendMessage();
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
			<input type="button" name="read" id="read" value="阅读" />
			<input type="button" name="send" id="send" value="发信" />
		</div>


		<div id="maingrid"></div>
	</body>
</html>
