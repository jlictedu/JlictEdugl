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
       		showgbMemberGridwk();
       		loadwk();
       	
			//显示性别
			$('#SEX').val('${data.Teacher.sex}');	
			
			
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
		function showgbMemberGridwk(){
			$gbMemberGridwk = $("#gbMemberGridwk").ligerGrid({
				columns:[
					         {display:"经历",name:"EXPERIENCE",width:270,editor:{ type: "text" } },
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
				loadData: loadwk,                          
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
         function loadwk(){
        	<c:forEach var="v" items="${data.work}">
        	var gb = new Object();
				gb.EXPERIENCE = "<c:out value='${v["EXPERIENCE"]}' />";
				gb.START_DATE = "<c:out value='${v["START_DATE"]}' />";
		        gb.END_DATE ="<c:out value='${v["END_DATE"]}' />"
        	    wkData.Rows.push(gb);
        		wkData.Total++;
        	</c:forEach>
        	$gbMemberGridwk.loadData(wkData)
        }
            
  
    </script>
  </head>
  <body style="padding:10px">
    <form name="form1" method="post"  id="form1">
    	
    	<table align="center" class="editView" cellspacing="1"  border="1">
 			<tr>
			   <td colspan="6" ><div align="center" class="editView td_div">教职工信息表</div></td>
			</tr>
			 	  <tr>
				    <td width="100px"  class="editView_td_style"  align="center">所在学院</td>
				    <td width="120" class="editView_td_style" align="center" >所在系</td>
				    <td width="100" class="editView_td_style" align="center" >职称</td>
				     <td width="100" class="editView_td_style" align="center" >教职工姓名</td>
				     <td width="100" class="editView_td_style" align="center" >教职工性别</td>   
				    <td width="80" class="editView_td_style" align="center">教职工身份证号码</td>
			
				  </tr> 
				  
 				 <tr>
 				 
				    <td  align="center" id="school"> 
				        ${data.Teacher.school_name}
				        </td>
				    <td  align="center" id="dept">
				        ${data.Teacher.dept_name}
				    </td>
				    <td  align="center" id="class">
				        ${data.Teacher.professional}
                    </td>
					
				  	<td  align="center" id="name">
				  	    ${data.Teacher.name}
				  	</td>
				    <td  align="center" id="sex">
				        ${data.Teacher.sex}
				    </td>
				    <td  align="center" id="emergency_contact_tel" > 
				        ${data.Teacher.credential_number}
				    </td>	
                </tr>	
				<tr>
				<td width="120" class="editView_td_style" align="center" >教职工民族</td>
				  
				    <td width="100"  class="editView_td_style" align="center">教职工出生日期</td>
				    <td width="120" class="editView_td_style" align="center" >教职工出生地</td>
				    <td width="100" class="editView_td_style" align="center" >教职工户籍</td>
				    <td width="100" class="editView_td_style" align="center">入学时间</td>
				     <td width="120" class="editView_td_style" align="center" >紧急联系人姓名</td>
				    
				 </tr> 
				  
 				 <tr>
				    <td  align="center" >
				        ${data.Teacher.nation}
				    </td>
				    <td  align="center" >
				        ${data.Teacher.born_date}
				    </td>
				    <td  align="center" >
				        ${data.Teacher.birth_place}
				    </td>
				    <td  align="center" >
				        ${data.Teacher.house_registe}
				    </td>
				    <td  align="center" >
				        ${data.Teacher.join_date}
				    </td>
				    <td  align="center" >
				        ${data.Teacher.emergency_contact_person}
				    </td>
				 </tr>				 
				 <tr>
				   <td width="120" class="editView_td_style" align="center" >紧急联系人电话</td>
	               <td width="120" class="editView_td_style" align="center" >政治面貌</td>
				   <td width="120" class="editView_td_style" align="center" >岗位</td>
			
				   </tr>
				    <tr>	
				    <td align="center" id="emergency_contact_tel"  title="紧急联系人">
                		${data.Teacher.emergency_contact_tel}
                	</td>
                		
				    <td align="center" id="political_appearance"  title="政治面貌">
                		${data.Teacher.political_appearance}
                	</td>
                	
                	<td align="center" id="station"  title="岗位">
                		${data.Teacher.station}
                	</td>
                
				  
				   </tr>
				  <tr>
				    <td width="100px">教职工教育情况 </td>
				    <td colspan="5" style="padding: 5px;" >
				    	<div id="gbMemberGrided" style="width:460px;">				    		
				    	</div>
				    </td>
				  </tr>
				   <tr>
				    <td width="100px">教职工家庭成员情况 </td>
				    <td colspan="5" style="padding: 5px;" >
				    	<div id="gbMemberGridfl" style="width:460px;">				    		
				    	</div>
				    </td>
				  </tr>
				  <tr>
				    <td width="100px">教职工作经历情况 </td>
				    <td colspan="5" style="padding: 5px;" >
				    	<div id="gbMemberGridwk" style="width:460px;">				    		
				    	</div>
				    </td>
				  </tr>
	
             </table>
         </form>
  </body>
</html>
