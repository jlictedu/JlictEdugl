<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP 'EntranceEdit.jsp' starting page</title>
    
	<link href="js/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <link href="css/common.css" rel="stylesheet" type="text/css" /> 
    <script src="js/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>
    <script src="js/map.js" type="text/javascript"></script>   
    <script src="js/ligerUI/js/ligerui.min.js" type="text/javascript" charset="utf-8"></script> 
    <script src="js/json2.js" type="text/javascript"></script>
 <script src="js/common.js" type="text/javascript"></script>
 <script type="text/javascript">
        var flag = false;
        var array={
     	        "#tr_tr_experience":['required:true','maxlength:50'],
	   			"#tr_tr_start_date":['required:true'],
	   			"#tr_tr_end_date":['required:true']
	   		
	   			
		}
        $(function (){
              	$("#close").click(function(){close();});
              	$("#save").click(function(){save();});
              		$("#tr_tr_start_date").ligerDateEditor();
              	$("#tr_tr_end_date").ligerDateEditor();
              
        }); 
        
        
        
		function close(){
			if(!flag){
				$.ligerDialog.confirm("您还有未保存的信息，确定退出？",function(result){
					if(!result){
						return;
					}
				});
			}
			window.parent.createtrClose(flag);
		}
		
        
        //保存
		function save(){
				if(!checkValidate(array)){
				return false;
			}							   
			
				var gb = new Object();
				gb.TR_EXPERIENCE =$("#tr_tr_experience").val();
				gb.TR_START_DATE = $("#tr_tr_start_date").val();
		        gb.TR_END_DATE =$("#tr_tr_end_date").val();
	
				window.parent.addtr(gb);
				flag = true;
				$.ligerDialog.success("保存成功！");							
		}
		
		function saveCallback(resText,status)
		{
			if(status == "success" && resText.errcode == "0"){
				$.ligerDialog.success("存盘成功！");
				flag=true;
			}else{
				$.ligerDialog.error("添加失败！"+resText.errmsg);
			}
			$("#save").attr("disabled","");
			return;
		}
		
		
		
        
    </script>
  </head>
 <body style="padding:10px">
    
    	<div align="right">
        	<input type="button" accesskey='S' id="save" name="save" value="保 存"/>&nbsp;<input type="button" value="关 闭" id="close" />
        </div>
        <form id="gbForm" method="post">
    	 	<table class="editView" cellspacing="0"  border="1">
                 <tr>
				    <th colspan="6" ><div align="center" class="editView td_div">员工培训经历信息登记</div></th>
 				 </tr>
 				 <tr>
				    
				    <td width="20%" align="right" class="editView_td_style">经历：</td>
				   <td width="20%" ><input  type="text"  id="tr_tr_experience" SIZE="90" name="tr_tr_experience"  title="经历"  /></td>
				  </tr>
				  <tr>
				    <td width="20%" align="right" class="editView_td_style">开始时间：</td>
				    <td width="20%" ><input  type="text"  id="tr_tr_start_date" name="tr_tr_start_date" title="开始时间"  /></td>
		
				  </tr>
				  <tr>
				   <td width="10%" align="right" class="editView_td_style">结束时间：</td>
				   <td width="10%" ><input class="Wdate" type="text" id="tr_tr_end_date" name="tr_tr_end_date"  title="结束时间"  /></td>
				  </tr>
				  
			
		</table>
		</form>
	   
</body>
</html>