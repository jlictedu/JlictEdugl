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
    $(function(){
    	var date =  $('#senddate').text();
    	date = date.substring(0,date.length-2);
    	$('#senddate').text(date);
    	$('#content').width($(".button_panel").width());
    	$('#reply').click(reply);
    });
    
    function reply(){
    	window.parent.reply('${message.senderId}');
    }
    </script>

	</head>

	<body>

		<div class="button_panel">
			<input type="button" value="回复" id="reply" />
		</div>
		<div class="table_container">

			<table class="editView" cellspacing="0" border="1">
				<tr>
					<th colspan="4">
						<div align="center" class="editView td_div">
							${message.title}
						</div>
					</th>
				</tr>

				<tr>
					<td align="right" class="editView_td_style" width="25%">
						发件人
					</td>
					<td width="25%">
						${message.sender}
					</td>
					<td align="right" class="editView_td_style" width="25%">
						发送时间
					</td>
					<td id='senddate' width="25%">${message.sendDate}</td>
				</tr>
				<tr>
					<td colspan="4" style="text-align: left;">
						<div id="content" style="word-wrap:break-word">${message.text}</div>
					</td>
				</tr>

			</table>
		</div>
	</body>
	
</html>
