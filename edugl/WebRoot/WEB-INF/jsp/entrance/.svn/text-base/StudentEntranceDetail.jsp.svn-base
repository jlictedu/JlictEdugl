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
    <script src="js/jquery/jquery.form.js" type="text/javascript"></script>
    <script src="js/ligerUI/js/ligerui.min.js" type="text/javascript" charset="utf-8"></script> 
    <script src="js/json2.js" type="text/javascript"></script>
    <script src="js/common.js" type="text/javascript"></script>
    <script type="text/javascript">		
		var $gbMemberGrided;
    	var $gbMemberGridfl;
    	var $gbMemberGridwk;
    	var $gbMemberGridtr;
    	var edData=new Object();
    	edData.Rows=new Array();
    	edData.Total=0;
    	var flData=new Object();
    	flData.Rows=new Array();
    	flData.Total=0;
    	var wkData=new Object();
    	wkData.Rows=new Array();
    	wkData.Total=0;
    	var trData=new Object();
    	trData.Rows=new Array();
    	trData.Total=0;
			//初始化教育信息界面
		$(function()
        {
       		
       		showgbMemberGrided();
       		loaded();
       		showgbMemberGridfl();
       		loadfl();
       	
			//显示性别
			$('#SEX').val('${data.Employee.sex}');	
			
			
        });
		function showgbMemberGrided(){
			$gbMemberGrided = $("#gbMemberGrided").ligerGrid({
				columns:[
					         {display:"学历",name:"EDUCATIONAL",width:70,editor:{ type: "text" } },
					         {display:"经历",name:"EXPERIENCE",width:270,editor:{ type: "text" }},
					         {display:"开始时间", width: 100, name: "START_DATE",editor:{type:"date"}},
					         {display:"结束时间",name:"END_DATE",width:100,editor:{ type: "date" }}
						],
				url: "",
				delayLoad:false,
				width: "100%",  
                height: "100%",
				pageSize: 10,
				rownumbers:true,
				root :"Rows",
				loadData: loaded,                          
				record:"Total",                        
				pageParmName :"pageIndex",               
				pagesizeParmName:"pageSize",
				onSuccess:function(data){
					if (typeof data.errcode != "undefined")
					{
					   window.location.href="/NoLoginOrSessionOut.jsp";
					} 
				},
				onReload:function(){
					return false;
				},
				onError:function(){
					ajaxError();
				},
				enabledEdit: false,
				isScroll:false
			});
		}
		 //初始化家庭信息界面
		   function showgbMemberGridfl(){
			$gbMemberGridfl = $("#gbMemberGridfl").ligerGrid({
				columns:[
					         {display:"关系",name:"RELATION",width:70,editor:{ type: "text" } },
					         {display:"姓名",name:"FL_NAME",width:100,editor:{ type: "text" }},
					         {display:"工作",name:"TEL",width:200,editor:{ type: "text" }}
						],
				url: "",
				delayLoad:false,
				width: "100%",  
                height: "100%",
				pageSize: 10,
				rownumbers:true,
				root :"Rows",
				loadData: loadfl,                          
				record:"Total",                        
				pageParmName :"pageIndex",               
				pagesizeParmName:"pageSize",
				onSuccess:function(data){
					if (typeof data.errcode != "undefined")
					{
					   window.location.href="/NoLoginOrSessionOut.jsp";
					} 
				},
				onReload:function(){
					return false;
				},
				onError:function(){
					ajaxError();
				},
				enabledEdit: false,
				isScroll:false
			});
		}
		
			function loaded(){
        	<c:forEach var="v" items="${data.education}">
				var gb = new Object();
				gb.EDUCATIONAL = "<c:out value='${v["EDUCATIONAL"]}' />";
				gb.EXPERIENCE = "<c:out value='${v["EXPERIENCE"]}' />";
		        gb.START_DATE ="<c:out value='${v["START_DATE"]}' />";
		        gb.END_DATE="<c:out value='${v["END_DATE"]}' />";
        		edData.Rows.push(gb);
        		edData.Total++;   
        	</c:forEach>
        	$gbMemberGrided.loadData(edData);
			}
            function loadfl(){
        	<c:forEach var="v" items="${data.family}">
        	var gb = new Object();
				gb.FL_NAME = "<c:out value='${v["FL_NAME"]}' />";
				gb.RELATION = "<c:out value='${v["RELATION"]}' />";
		        gb.TEL ="<c:out value='${v["TEL"]}' />"
        	    flData.Rows.push(gb);
        		flData.Total++;
        	</c:forEach>
        	$gbMemberGridfl.loadData(flData);
        }
            
  
    </script>
  </head>
  <body style="padding:10px">
    <form name="form1" method="post"  id="form1">
    	
    	<table align="center" class="editView" cellspacing="1"  border="1">
 			<tr>
			   <td colspan="6" ><div align="center" class="editView td_div">学生信息表</div></td>
			</tr>
			 	  <tr>
				    <td width="100px"  class="editView_td_style"  align="center">所在学院</td>
				    <td width="120" class="editView_td_style" align="center" >所在系</td>
				    <td width="100" class="editView_td_style" align="center" >所在班级</td>
				     <td width="100" class="editView_td_style" align="center" >学生姓名</td>
				     <td width="100" class="editView_td_style" align="center" >学生性别</td>   
				    <td width="80" class="editView_td_style" align="center">学生身份证号码</td>
			
				  </tr> 
				  
 				 <tr>
 				 
				    <td  align="center" id="school"> 
				        ${data.Student.school_name}
				        </td>
				    <td  align="center" id="dept">
				        ${data.Student.dept_name}
				    </td>
				    <td  align="center" id="class">
				        ${data.Student.class_name}
                    </td>
					
				  	<td  align="center" id="name">
				  	    ${data.Student.name}
				  	</td>
				    <td  align="center" id="sex">
				        ${data.Student.sex}
				    </td>
				    <td  align="center" id="emergency_contact_tel" > 
				        ${data.Student.credential_number}
				    </td>	
                </tr>	
				<tr>
				<td width="120" class="editView_td_style" align="center" >学生民族</td>
				  
				    <td width="100"  class="editView_td_style" align="center">学生出生日期</td>
				    <td width="120" class="editView_td_style" align="center" >学生出生地</td>
				    <td width="100" class="editView_td_style" align="center" >学生户籍</td>
				    <td width="100" class="editView_td_style" align="center">入学时间</td>
				     <td width="120" class="editView_td_style" align="center" >紧急联系人姓名</td>
				    
				 </tr> 
				  
 				 <tr>
				    <td  align="center" >
				        ${data.Student.nation}
				    </td>
				    <td  align="center" >
				        ${data.Student.born_date}
				    </td>
				    <td  align="center" >
				        ${data.Student.birth_place}
				    </td>
				    <td  align="center" >
				        ${data.Student.house_registe}
				    </td>
				    <td  align="center" >
				        ${data.Student.join_date}
				    </td>
				    <td  align="center" >
				        ${data.Student.emergency_contact_person}
				    </td>
				 </tr>				 
				 <tr>
				   <td width="120" class="editView_td_style" align="center" >紧急联系人电话</td>
	               <td width="120" class="editView_td_style" align="center" >政治面貌</td>
				   <td width="120" class="editView_td_style" align="center" >岗位</td>
				    <td width="120" class="editView_td_style" align="center" >学号</td>
				   </tr>
				    <tr>	
				    <td align="center" id="emergency_contact_tel"  title="紧急联系人">
                		${data.Student.emergency_contact_tel}
                	</td>
                		
				    <td align="center" id="political_appearance"  title="政治面貌">
                		${data.Student.political_appearance}
                	</td>
                	
                	<td align="center" id="station"  title="岗位">
                		${data.Student.station}
                	</td>
                	<td align="center" id="student_number"  title="学号">
                		${data.Student.student_number}
                	</td>
				  
				   </tr>
				  <tr>
				    <td width="100px">学生教育情况 </td>
				    <td colspan="5" style="padding: 5px;" >
				    	<div id="gbMemberGrided" style="width:460px;">				    		
				    	</div>
				    </td>
				  </tr>
				   <tr>
				    <td width="100px">学生家庭成员情况 </td>
				    <td colspan="5" style="padding: 5px;" >
				    	<div id="gbMemberGridfl" style="width:460px;">				    		
				    	</div>
				    </td>
				  </tr>
	
             </table>
         </form>
  </body>
</html>
