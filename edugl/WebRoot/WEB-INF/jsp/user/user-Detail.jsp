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
       		$('#password').click(password);
       		showgbMemberGrided();
       		loaded();
       		showgbMemberGridfl();
       		loadfl();
       		showgbMemberGridwk();
       		loadwk();
       		showgbMemberGridtr();
       		loadtr();
			//显示性别
			$('#SEX').val('${data.Employee.sex}');	
			
			
        });
        
        function password(){
        	$.ligerDialog.open({ title:"修改密码", url: 'user.do?m=password', width: 450,height:450,
        	 showToggle: false, isHidden: false,slide: false});
        }
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
					         {display:"工作",name:"WORK",width:200,editor:{ type: "text" }}
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
		 //初始化工作信息界面
		
			   function showgbMemberGridwk(){
			$gbMemberGridwk = $("#gbMemberGridwk").ligerGrid({
				columns:[
					         {display:"经历",name:"WK_EXPERIENCE",width:270,editor:{ type: "text" } },
					         {display:"开始时间", width: 100, name: "WK_START_DATE",editor:{type:"date"}},
					         {display:"结束时间",name:"WK_END_DATE",width:100,editor:{ type: "date" }}
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
		 //初始化培训信息界面
			   function showgbMemberGridtr(){
			$gbMemberGridtr = $("#gbMemberGridtr").ligerGrid({
				columns:[
					         {display:"经历",name:"TR_EXPERIENCE",width:270,editor:{ type: "text" } },
					         {display:"开始时间", width: 100, name: "TR_START_DATE",editor:{type:"date"}},
					         {display:"结束时间",name:"TR_END_DATE",width:100,editor:{ type: "date" }}					         
						],
				url: "",
				delayLoad:false,
				width: "100%",  
                height: "100%",
				pageSize: 10,
				rownumbers:true,
				root :"Rows",
				loadData: loadtr,                          
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
		        gb.WORK ="<c:out value='${v["WORK"]}' />"
        	    flData.Rows.push(gb);
        		flData.Total++;
        	</c:forEach>
        	$gbMemberGridfl.loadData(flData);
        }
            function loadwk(){
        	<c:forEach var="v" items="${data.work}">
        	var gb = new Object();
				gb.WK_EXPERIENCE = "<c:out value='${v["WK_EXPERIENCE"]}' />";
				gb.WK_START_DATE = "<c:out value='${v["WK_START_DATE"]}' />";
		        gb.WK_END_DATE ="<c:out value='${v["WK_END_DATE"]}' />"
        	    wkData.Rows.push(gb);
        		wkData.Total++;
        	</c:forEach>
        	$gbMemberGridwk.loadData(wkData)
        }
            function loadtr(){
        	<c:forEach var="v" items="${data.train}">
        	var gb = new Object();
				gb.TR_EXPERIENCE = "<c:out value='${v["TR_EXPERIENCE"]}' />";
				gb.TR_START_DATE = "<c:out value='${v["TR_START_DATE"]}' />";
		        gb.TR_END_DATE ="<c:out value='${v["TR_END_DATE"]}' />"
        	  trData.Rows.push(gb);
        		trData.Total++;
        	</c:forEach>
        	$gbMemberGridtr.loadData(trData)
        }
  
    </script>
  </head>
  <body style="padding:10px">
    <form name="form1" method="post"  id="form1">
    	<div align="right">&nbsp; 
        	<input type="button" value="修改密码" id="password"/>
        </div>
    	<table align="center" class="editView" cellspacing="1"  border="1">
 			<tr>
			   <td colspan="6" ><div align="center" class="editView td_div">员工入职信息表</div></td>
			</tr>
			 	  <tr>
				    <td width="100px"  class="editView_td_style"  align="center">员工工号</td>
				    <td width="120" class="editView_td_style" align="center" >员工姓名</td>
				    <td width="100" class="editView_td_style" align="center" >员工性别</td>
				     
				    <td width="80" class="editView_td_style" align="center">员工身份证号码</td>
				    <td width="120" class="editView_td_style" align="center" >员工民族</td>
				  <td width="100" class="editView_td_style" align="center">紧急联系人电话</td>
				  </tr> 
				  
 				 <tr>
 				 
				    <td  align="center" id="jobNumber"> 
				        ${data.Employee.jobNumber}
				        </td>
				    <td  align="center" id="name">
				        ${data.Employee.name}
				    </td>
				    <td  align="center" id="sex">
				        ${data.Employee.sex}
                    </td>
					
				  	<td  align="center" id="credentialNumber">
				  	    ${data.Employee.credentialNumber}
				  	</td>
				    <td  align="center" id="nation">
				        ${data.Employee.nation}
				    </td>
				    <td  align="center" id="emergencyContactTel"> 
				        ${data.Employee.emergencyContactTel}
				    </td>	
                </tr>	
				<tr>
				    <td width="100"  class="editView_td_style" align="center">员工出生日期</td>
				    <td width="120" class="editView_td_style" align="center" >员工出生地</td>
				    <td width="100" class="editView_td_style" align="center" >员工户籍</td>
				    <td width="100" class="editView_td_style" align="center">加入公司时间</td>
				    <td width="80" class="editView_td_style" align="center">参加工作日期</td>
				    <td width="120" class="editView_td_style" align="center" >紧急联系人姓名</td>
				 </tr> 
				  
 				 <tr>
				    <td  align="center" >
				        ${data.Employee.bornDate}
				    </td>
				    <td  align="center" >
				        ${data.Employee.birthPlace}
				    </td>
				    <td  align="center" >
				        ${data.Employee.houseRegiste}
				    </td>
				    <td  align="center" >
				        ${data.Employee.joinDate}
				    </td>
				    <td  align="center" >
				        ${data.Employee.workDate}
				    </td>
				    <td  align="center" >
				        ${data.Employee.emergencyContactPerson}
				    </td>
				 </tr>				 
				 <tr>
			       <td width="100"  class="editView_td_style"  align="center">部门</td>
				   <td width="120" class="editView_td_style" align="center" >员工岗位</td>
				   <td width="120" class="editView_td_style" align="center" >员工上级</td>   
				   </tr>
				    <tr>	
				    <td align="center" id="dp"  title="部门">
                		${data.Employee.departmentName}
                	</td>
                		
				    <td align="center" id="st"  title="员工岗位">
                		${data.Employee.st_name}
                	</td>
                	
                	<td align="center" id="boss2"  title="员工上级">
                		${data.Employee.bossName}
                	</td>
				  
				   </tr>
				  <tr>
				    <td width="100px">员工教育情况 </td>
				    <td colspan="5" style="padding: 5px;" >
				    	<div id="gbMemberGrided" style="width:460px;">				    		
				    	</div>
				    </td>
				  </tr>
				   <tr>
				    <td width="100px">员工家庭成员情况 </td>
				    <td colspan="5" style="padding: 5px;" >
				    	<div id="gbMemberGridfl" style="width:460px;">				    		
				    	</div>
				    </td>
				  </tr>
				   <tr>
				    <td width="100px">员工工作经历情况 </td>
				    <td colspan="5" style="padding: 5px;" >
				    	<div id="gbMemberGridwk" style="width:460px;">				    		
				    	</div>
				    </td>
				  </tr>
				  <tr>
				    <td width="100px">员工培训经历情况 </td>
				    <td colspan="5" style="padding: 5px;" >
				    	<div id="gbMemberGridtr" style="width:460px;">				    		
				    	</div>
				    </td>
				  </tr>
             </table>
         </form>
  </body>
</html>
