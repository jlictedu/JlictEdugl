<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<link rel="shortcut icon" href="favicon.ico" />
		<title>欢迎使用系统</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script language="javascript" src="<%=path %>/js/jquery/jquery-1.5.2.min.js"></script>
		<script language="javascript" src="<%=path %>/js/jquery/jquery.form.js"></script>
		<script type="text/javascript">
			//登录系统
			function loginsystem(){
				if(document.getElementById("userName").value==""){
					alert("请输入用户名！");
					$("#userName").focus();
					return;
				}
				if(document.getElementById("password").value==""){
					alert("请输入密码！");
					$("#password").focus();
					return;
				}
				
				poststr=$('#loginForm').formSerialize();
			
				$.ajax({url:"login.do",data:poststr,success:logincallback,async:false});
			}
			//登录结果回调
			function logincallback(ResText)
			{
				
				if(ResText.resultCode!="0" )
				{
					alert("错误信息:"+ResText.text);
				}else {
					self.location="mainFrame.do";
				}
			}
			//清空输入
			function clearwindow(){
				document.getElementById("userName").value="";
				document.getElementById("password").value="";
				document.getElementById("userName").focus();
			}
			
			function defaultOnKeyDown(keyCode) {
				if(keyCode == 13) {
					document.getElementById("btnsave1").click();
				}
			}
			
			$(function(){
				var height=($(document.body).height()-600)/2+"px";
				$(".div").css({"margin-top":height});
			});
		</script>
		<style type="text/css">
			*{
				margin:0px;
				padding:0px;
			}
		</style>
	</head>
	<body onkeydown="defaultOnKeyDown(event.keyCode)">
	<div style="width:1000px;margin:auto;background-color: #fff;">
 
		<form id="loginForm" action="login.do" method="post">
				<table id="login" cellpadding="0" cellspacing="0" border="0"
					style="position: absolute; top: 240px; left: 550px;height:auto;">
					<tr style="border:1px solid red;width:250px;height:80px;">
						<td width="80" style="color:black;text-align:center;text-valigin:meddle;">用户名:</td>
						<td width="80" height="30" style="vertical-align: center;">
							<input type="text" name="userName" id="userName" value=""
								style="height: 20px; width: 215px; padding-top: 5px; font-size: 16px; background: #BDD3EF; border: 0px; color: #0c4a93;" />
						</td>
					</tr>
					<tr>
						<td style="color:black;text-align:center;text-valigin:meddle;width:50px;">密&nbsp&nbsp&nbsp码:</td>
						<td style="vertical-align: top;">
							<input type="password" name="password" id="password" value=""
								style="height: 20px; width: 215px; padding-top: 5px; font-size: 16px; background: #BDD3EF; border: 0px; color: #0c4a93;" />
						</td>
					</tr>
					<tr>
						<td height="45" colspan="2"
							style="vertical-align: middle; padding-left: 1px;">
							<input type="button" id="btnsave1" name="btnsave"
								onclick="javascript:loginsystem();" value="登录(C)"
								style="cursor: pointer;left:65px;top:120px; position:absolute;border:1px;width:72px;height:28px;" onkeydown="if(event.keyCode == 13) {loginsystem();}"/>
							<input type="button" id="btncancel1" name="btncancel"
								onclick="javascript:clearwindow();" value="取消"
								style="cursor: pointer;left:150px;top:120px; position:absolute;border:1px;width:72px;height:28px;" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>