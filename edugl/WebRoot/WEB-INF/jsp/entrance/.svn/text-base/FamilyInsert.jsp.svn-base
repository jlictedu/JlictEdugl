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
     	        "#fl_relation":['required:true'],
     	        "#fl_fl_name":['required:true','maxlength:10'],
	   			"#fl_tel":['required:true','maxlength:11']	   			
		}
        $(function (){
              	$("#close").click(function(){close();});
              	$("#save").click(function(){save();});
              
        }); 
        
        
        
		function close(){
			if(!flag){
				$.ligerDialog.confirm("您还有未保存的信息，确定退出？",function(result){
					if(!result){
						return;
					}
				});
			}
			window.parent.createflClose(flag);
		}
		
        
        //保存
		function save(){
			if(!checkValidate(array)){
				return false;
			}			
				var gb = new Object();
				gb.RELATION =$("#fl_relation").val();
				gb.FL_NAME = $("#fl_fl_name").val();
		        gb.TEL =$("#fl_tel").val();
	
				window.parent.addfl(gb);
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
				    <th colspan="6" ><div align="center" class="editView td_div">家庭信息登记</div></th>
 				 </tr>
 				 <tr>
				    
				    <td width="20%" align="right" class="editView_td_style">关系：</td>
				    <td> <select id="fl_relation" name="fl_relation" title="关系" >
                   <option value="">-与员工的关系-</option>
                    <option value="父亲">父亲</option> 
                   <option value="母亲">母亲</option> 
                   <option value="儿子">儿子</option> 
                   <option value="女儿">女儿</option> 
                   <option value="妻子">妻子</option> 
                  
                    </select> </td>
				    				
				  </tr>
				  <tr>
				    <td width="20%" align="right" class="editView_td_style">姓名：</td>
				    <td width="20%" ><input  class="Wdate" type="text"  id="fl_fl_name" name="fl_fl_name" title="姓名"  /></td>
		
				    
				  </tr>
				  <tr>
				   <td width="10%" align="right" class="editView_td_style">电话：</td>
				   <td width="10%" ><input class="Wdate" type="text" id="fl_tel" name="fl_tel"  title ="电话"   /></td>
				  </tr>
				  
			
		</table>
		</form>
	   
</body>
</html>
