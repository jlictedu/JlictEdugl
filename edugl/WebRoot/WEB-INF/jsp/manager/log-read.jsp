<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>系统操作日志</title>
<style type="text/css">
<!--
body, table {font-family: '宋体',arial,sans-serif; font-size: 12px;}
th {background: #336699; color: #FFFFFF; text-align: left;}
.break {word-break: break-all; word-wrap:break-word;}
-->
</style>
</head>
<body bgcolor="#FFFFFF" topmargin="6" leftmargin="6">
<table cellspacing="0" cellpadding="4" border="1" bordercolor="#224466" width="100%">
<tr style="height:50px;">
<th style="width:60px;text-align:center;">执行时间</th>
<th style="width:30px;text-align:center;">级别</th>
<th style="text-align:center;">信息</th>
<th style="width:50px;text-align:center;">操作人</th>
<th style="width:70px;text-align:center;">操作人工号</th>
</tr>
  	<jsp:include page="../../../log/${file}"></jsp:include>
  </table>
  </body>
</html>
