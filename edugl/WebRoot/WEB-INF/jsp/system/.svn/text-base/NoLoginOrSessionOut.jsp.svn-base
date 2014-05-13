<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="shortcut icon" href="favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
<link type="text/css" rel="stylesheet" href="css/css.css" />
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
#information{
	width:400px;
	height:200px;
}
#container{
	display:block;
	width:410px;
	height:200px;
}
#content{
	display:block;
	width:410px;
	height:70px;
	padding-left:55px;
}
#content p{
	font-size:24px;
}
#back{
	display:block;
	width:250px;
	height:50px;
	padding-left:60px;
	padding-top:10px;
}
#te{
	display:block;
	width:410px;
	height:60px;
	padding-left:130px;
	overflow:hidden;
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
	<p>用户没有登录，或登录超时<br/>请重新登录</p>
</div>
<div id="back" align="center">
		<input type="button" accesskey="C" name="ButtonClose" value="登录(C)" onclick="refreshOpenerAndCloseMe();"/>
</div>	
</div>
</body>
</html>