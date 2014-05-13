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
		<script src="<%=path %>/js/ligerUI/js/ligerui.min.js"
			type="text/javascript" charset="utf-8"></script>
		<script src="<%=path %>/js/jquery-validation/jquery.validate.min.js"
			type="text/javascript" charset="utf-8"></script>
		<script src="<%=path %>/js/common.js" type="text/javascript"></script>
		<script type="text/javascript">
    var user=new Object();
    var sendSuccess=false;
    var wait;
    $(function()
    {
    	
    	$('#send').click(send);
    	widthAutoFit($('#title'));
    	widthAutoFit($('#jobNumber'));
    	widthAutoFit($('#name'));
    	widthAutoFit($('#content'));
    	$('#userId').blur(function(){
    	$.ajax({url:'user.do?m=userId&'+'userId='+$('#userId').val(),type:"post",success:loadUser});    	
    	});
    	//如果链接里有收件人工号，填入工号
    	var userId=getUrlParam('userId');
    	if(userId!=null){
    		$('#userId').val(userId);
    		$('#userId').trigger('blur');
    		return;
    	}
    	
    });
    //把收件人工号转换成收件人id，并取得收件人名字
    function loadUser(data){
    	if(data.id==undefined){
    		$.ligerDialog.warn("无效的id");
    		user=new Object();
    		$('#name').val('');
    		return;
    	}
    	user.id=data.id;
    	$('#name').val(data.name);
    }
    //发送按钮的处理
    function send(){
    
    	if(user.id==undefined||user.id==null){
    		$.ligerDialog.warn("无效的id");
    		return;
    	}
    	wait = $.ligerDialog.waitting("正在提交，请稍后...");
    	var para={receiverId:user.id,title:$('#title').val(),content:$('#content').val()}
    	$.ajax({url:'outbox.do?m=send',data:para,type:"post",success:sendCallback});
    }
    
    //发送回调
    function sendCallback(result){
    	if(0==result.resultCode){
    		$.ligerDialog.success("发送成功");
    		$('#send').attr("disabled","disabled");
    		window.parent.refresh();
    		sendScuuess=true;
    	}
    	else{
    		$.ligerDialog.error("发送失败");
    	}
    	wait.close();
    }
    </script>

	</head>

	<body>

		<div class="button_panel">
			<input type="button" value="发送" id="send" />			
		</div>
		
		<div class="table_container">

			<table class="editView" cellspacing="0" border="1">
				<tr>
					<td class="editView_td_style" width="25%">
						收件人id
					</td>					
					<td width="25%">
						<input id="userId" type="text" />
					</td>
					<td class="editView_td_style" width="25%">
						收件人姓名
					</td>
					<td width="25%">
						<input id="name" readonly="readonly" type="text" />
					</td>
				</tr>

				<tr>
					<td class="editView_td_style" width="25%">
						标题
					</td>
					<td colspan="3" width="75%">
						<input id="title" type="text" maxlength="40" />
					</td>
				</tr>
				<tr>
					<td class="editView_td_style" width="25%">
						正文
					</td>
					<td colspan="3" width="75%">
						<textarea rows="10" name="content" id="content" ></textarea>
					</td>
				</tr>
			</table>
		</div>
		
	</body>
	
</html>
