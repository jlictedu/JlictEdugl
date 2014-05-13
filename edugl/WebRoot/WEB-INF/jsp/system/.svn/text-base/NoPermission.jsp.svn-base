<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="shortcut icon" href="favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
<link type="text/css" rel="stylesheet" href="css/css.css" />
<link type="text/css" rel="stylesheet" href="css/loginError.css" />
<script type="text/javascript" src="js/jquery/jquery-1.5.2.min.js"></script> 
<script type="text/javascript" src="js/common.js" ></script> 
<style type="text/css">
html, body {
    width: 100%;
    height: 100%;
    margin: 0px;
    padding: 0px;
}
div.bcg-img{
	width:410px;
	height:40px;
	overflow: hidden;
}
#container{
	display:block;
	width:410px;
	height:200px;
}
#te{
	display:block;
	width:410px;
	height:60px;
	padding-left:130px;
	overflow:hidden;
}
#text p{
	font-size:20px;
}
#information{
	width:400px;
	height:200px;
}
#content{
	display:block;
	width:410px;
	height:75px;
	padding-left:15px;
}
#content p{
	font-size:24px;
}
#back{
	display:block;
	width:250px;
	height:50px;
	padding-left:160px;
	padding-top:10px;
}
</style>  
<script type="text/javascript">
$(
	function(){
		var screenWidth = document.body.clientWidth;
		var screenHeight = document.body.clientHeight;
		var popupHeight = $("#container").height();
		var popupWidth = $("#container").width();
		$("#container,#information").css({
   		 "position": "absolute",
    	 "top": (screenHeight-popupHeight)/2,
   		 "left": (screenWidth-popupWidth)/2
		}); 
	}
);



function closeWin(){ 
	// 可能存在frame页面,所以要引用top窗口. 
	var win = parent.window; 
	try{ 
		if(win.opener) win.opener.focus(); 
		win.opener = null; 
	}catch(ex){ 
		// 防止opener被关闭时代码异常。 
	}finally{ 
	win.close(); 
	} 
} 

// 刷新opener窗口后关闭自己。 
function refreshOpenerAndCloseMe(){ 
	try{
		var win = window.opener.parent;
		win.location=("./");
		window.close(); 
	}catch(ex){ 
		try{
			var win = parent.window; 
			//alert("2");
			if(win.opener){
				//alert("3");
				win.location=("./");
			}else{
				//alert("6");
				try{
					var obj = window.dialogArguments;
					try{
						//alert("7");
						var win = obj.opener.parent
						win.location=("./");
						self.close();
					}catch(ex){
						//alert("78");
						obj.parent.location.reload("./");
						self.close();
					}
					
				}catch(ex){
					//win.location=("./");
					window.parent.top.location=("./");
					//alert("8");
				}			
			}
		}catch(ex){ 
			//alert("10");
			window.location=("./");
		} 
	} 
} 
</script>
</head>
<body>
<div id="container">
	<div class="bcg-img">
		<img src="image/loginError_01.jpg"/>
	</div>
	<div class="bcg-img">
		<img src="image/loginError_02.jpg"/>
	</div>
	<div class="bcg-img">
		<img src="image/loginError_03.jpg"/>
	</div>
	<div class="bcg-img">
		<img src="image/loginError_04.jpg"/>
	</div>
	<div class="bcg-img">
		<img src="image/loginError_05.jpg"/>	
	</div>
</div>
<div id="information">
	<div id="te">
		<h1>错误信息：</h1>
	</div>
	<div id="content">
		<p style="font-size:20px;">非法访问，用户没有权限访问此功能！！！<br/>请重新登录系统</p>
	</div>
	<div id="back">
			<input type="button" accesskey="C" name="ButtonClose" value=" 登录(C) " onclick="javascript:refreshOpenerAndCloseMe();"/>
	</div>	
</div>
</body>
</html>
