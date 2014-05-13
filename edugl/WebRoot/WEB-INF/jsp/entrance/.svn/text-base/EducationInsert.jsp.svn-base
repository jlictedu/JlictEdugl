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
     	        "#ed_EDUCATIONAL":['required:true'],
     	        "#ed_EXPERIENCE":['required:true','maxlength:50'],
	   			"#ed_START_DATE":['required:true'],
	   			"#ed_END_DATE":['required:true']	   			
		}
        $(function (){
              	$("#close").click(function(){close();});
              	$("#save").click(function(){save();});
              	$("#ed_START_DATE").ligerDateEditor();
              	$("#ed_END_DATE").ligerDateEditor();
        }); 
        
        
        
		function close(){
			if(!flag){
				$.ligerDialog.confirm("您还有未保存的信息，确定退出？",function(result){
					if(!result){
						return;
					}
				});
			}
			window.parent.createedClose(flag);
		}
		
        
        //保存
		function save(){
			if(!checkValidate(array)){
				return false;
			}		
				var gb = new Object();
				gb.EDUCATIONAL =$("#ed_EDUCATIONAL").val();
				gb.EXPERIENCE = $("#ed_EXPERIENCE").val();
		        gb.START_DATE =$("#ed_START_DATE").val();
		        gb.END_DATE=$("#ed_END_DATE").val();
				window.parent.added(gb);
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
				    <th colspan="6" ><div align="center" class="editView td_div">教育信息登记</div></th>
 				 </tr>
 				 <tr>
				    
				    <td width="20%" align="right" class="editView_td_style">学历：</td>
				    <td > <select id="ed_EDUCATIONAL" name="ed_EDUCATIONAL" title="学历">
                   <option value="">-请选择学历-</option>
                    <option value="博士">博士</option> 
                   <option value="硕士">硕士</option> 
                   <option value="本科">本科</option> 
                   <option value="大专">大专</option> 
                   <option value="高中">高中</option> 
                   <option value="中专">中专</option> 
                   <option value="初中">初中</option>
                   <option value="小学">小学</option>
                    </select> </td>
				    				
				  </tr>
				  <tr>
				    <td width="20%" align="right" class="editView_td_style">教育经历：</td>
				    <td width="20%" ><input  type="text" size="100" id="ed_EXPERIENCE" name="ed_EXPERIENCE"   value="" title="教育经历"  /></td>
		
				    
				  </tr>
				  <tr>
				   <td width="10%" align="right" class="editView_td_style">起始时间：</td>
				   <td width="10%" ><input class="Wdate" type="text" id="ed_START_DATE" name="ed_START_DATE" value=""    title="起始时间"   /></td>
				  </tr>
				  
			<tr>
				<td width="10%" align="right" class="editView_td_style">结束时间：</td>
				   <td width="10%" ><input class="Wdate" type="text" id="ed_END_DATE" name="ed_END_DATE" value=""   title="结束时间"  /></td>
				  </tr>
		</table>
		</form>
	   
</body>
</html>
