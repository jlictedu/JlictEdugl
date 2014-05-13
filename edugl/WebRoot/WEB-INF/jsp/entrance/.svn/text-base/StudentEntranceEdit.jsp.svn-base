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
		var wait;
    	var flag=false;
       	var schoolSel;
		var departmentSel;
		var classSel;
		var sexsel;
		var stationSel;
    	var $dialog=$.ligerDialog;
    	var $gbMemberGrided;
    	var $gbMemberGridfl;
  
     	var changeFlag=false;
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
     	var array={
     	        
     	        "#NAME":['required:true','maxlength:10'],
	   			"#SEX":['required:true'],
	   			"#CREDENTIAL_NUMBER":['required:true','length:18'],
	   			"#NATION":['required:true','maxlength:5'],
	   			"#EMERGENCY_CONTACT_TEL":['required:true','digits:true','maxlength:20'],
	   			"#EMERGENCY_CONTACT_PERSON":['required:true','maxlength:20'],
	   			"#BIRTH_PLACE":['required:true','maxlength:100'],
	   			"#HOUSE_REGISTE":['required:true','maxlength:10'],	   		
	   		    "#BORN_DATE":['required:true'],
	        	"#JOIN_DATE":['required:true'],
	        	"#WORK_DATE":['required:true']
	   			
		};
        $(function()
        {
       		$("#close").click(function(){close();});
       		$("#save").click(function(){save();});
       		$("#newrow").click(function(){create();});  
       		$("#BORN_DATE").ligerDateEditor();
          	$("#WORK_DATE").ligerDateEditor();  
          	$("#JOIN_DATE").ligerDateEditor();
            $("select").each(function(index,element){
				widthAutoFit($('#'+element.id));
			})  		
       		showgbMemberGrided();
       		loaded();
       		showgbMemberGridfl();
       		loadfl();
       	
			//显示性别
			$('#SEX').val('${data.Student.sex}');
       		//显示部门
       		
            sexsel=$('#SEX').ligerComboBox({width: $('#SEX').parent().width()-2,
			selectBoxWidth:$('#SEX').parent().width()-2});
            departmentSel=$('#dp2').ligerComboBox({ width: $('#dp2').parent().width()-2,
			selectBoxWidth:$('#dp2').parent().width()-2});
            classSel=$('#dp3').ligerComboBox({width: $('#dp3').parent().width()-2,
			selectBoxWidth:$('#dp3').parent().width()-2});
       		
       		
       		 stationSel=$('#station').ligerComboBox({url:'studententrance.do?m=getst',
			valueField:'id',
			textField:'name',                 
            width: $('#station').parent().width()-2,
			selectBoxWidth:$('#station').parent().width()-2,
			onSuccess:function(data){
					stationSel.selectValue('${data.Student.stationid}');
				}
			});
       	schoolSel = $('#dp1').ligerComboBox({url:'studententrance.do?m=getdp',
			valueField:'id',
			textField:'name',
			width: $('#dp1').parent().width()-2,
			selectBoxWidth:$('#dp1').parent().width()-2,
			//根据部门显示人员
			onSelected: function (newvalue)
			{
				departmentSel  = $('#dp2').ligerComboBox({url:'studententrance.do?m=dpid&'+'dpid='+newvalue,
					valueField:'id',
					textField:'name',
					width: $('#dp2').parent().width()-2,
					selectBoxWidth:$('#dp2').parent().width()-2,
					onSuccess :function(data){
						if(data.length==0){
							departmentSel.clear();
							departmentSel.clearContent();
									
						}
						else 
						departmentSel.selectValue('${data.Student.dept_id}');
					},
					onSelected: function (newvalue)
			{
				classSel  = $('#dp3').ligerComboBox({url:'studententrance.do?m=dpid1&'+'dpid1='+newvalue,
					valueField:'id',
					textField:'name',
					width: $('#dp3').parent().width()-2,
					selectBoxWidth:$('#dp3').parent().width()-2,
					onSuccess :function(data){
						if(data.length==0){
							classSel.clear();
							classSel.clearContent();						
						}
						else
						classSel.selectValue('${data.Student.class_id}');
						
					}
					
					
				});	
			}
			
				});	
			},
			onSuccess:function(data){
					schoolSel.selectValue('${data.Student.school_id}');
				}
			
			});
       });
        function close(){
			if(changeFlag&&!flag){
				$.ligerDialog.confirm("您还有未保存的信息，确定退出？",function(result){
					if(!result){
						return ;
					}
					else{
						window.parent.editClose(false);
					}
				});
				return ;
			}
			window.parent.editClose(true);
		}
		function hasChange(){
			changeFlag=true;
		}
        
        
         function added(gb){
        
        	
			edData.Rows.push(gb);
			edData.Total++;
			hasChange();
			$gbMemberGrided.loadData(edData);
				
        } 
            function addfl(gb){
            
        	flData.Rows.push(gb);
			flData.Total++;
			hasChange();
			$gbMemberGridfl.loadData(flData);
			
					
        } 
            
        
        //显示添加教育信息窗口
        var createWined;
        function createed(){
            createWined=$.ligerDialog.open({ title:"学生教育信息登记", url: "studententrance.do?m=insertInited",timeParmName:"r", width: 750,height:500, showMax: true, showToggle: false, isResize: true, isHidden: false,slide: false,allowClose: false});
        }
        function createedClose(flag){       	
        		createWined.hide();        	
        }
        //显示添加家庭信息窗口
        var createWinfl;
        function createfl(){
            createWinfl=$.ligerDialog.open({ title:"学生教育信息登记", url: "studententrance.do?m=insertInitfl",timeParmName:"r", width: 750,height:500, showMax: true, showToggle: false, isResize: true, isHidden: false,slide: false,allowClose: false});
        }
        function createflClose(flag){       	
        		createWinfl.hide();        	
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
           
        
    
        
        //初始化教育信息界面
        function showgbMemberGrided(){
			$gbMemberGrided = $("#gbMemberGrided").ligerGrid({
				columns:[
					         {display:"学历",name:"EDUCATIONAL",width:70,editor:{ type: "text" } },
					         {display:"经历",name:"EXPERIENCE",width:270,editor:{ type: "text" }},
					         {display:"开始时间", width: 100, name: "START_DATE",editor:{type:"date"}},
					         {display:"结束时间",name:"END_DATE",width:100,editor:{ type: "date" }},
					         {display:"操作", isSort: false, width: 80, render:function (row){return "<a style='text-decoration:underline;' href='javascript:deleteed(\"" + row.EDUCATIONAL + "\")'>删除</a> ";}}
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
				toolbar: { 
					items: [
				                  { text: "增   加  记 录", click: createed, icon: "add" }
				                
				                 
				                 
				           ]
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
					         {display:"电话",name:"TEL",width:200,editor:{ type: "text" }},
					         {display:"操作", isSort: false, width: 80, render:function (row){return "<a style='text-decoration:underline;' href='javascript:deletefl(\"" + row.RELATION + "\")'>删除</a> ";}}
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
				toolbar: { 
					items: [
				                  { text: "增   加  记 录", click: createfl, icon: "add" }
				                 
				                 
				                 
				           ]
				},
				enabledEdit: false,
				isScroll:false
			});
		}
		 
		//删除一行教育信息
		function deleteed(){
			$.ligerDialog.confirm("是否删除选择【"+$gbMemberGrided.selected[0].EDUCATIONAL+"】?",function(result){
					if(result){
					
						var index=$gbMemberGrided.selected[0].__index+($gbMemberGrided.options.page-1)*$gbMemberGrided.options.pageSize;
						edData.Rows.splice(index,1);
						hasChange();
						$gbMemberGrided.loadData(edData);
						$.ligerDialog.success("删除成功！");
					}
				}
			);
		}
		//删除一行家庭信息
		
		function deletefl(){
			$.ligerDialog.confirm("是否删除选择【"+$gbMemberGridfl.selected[0].RELATION+"】?",function(result){
					if(result){
					
						var index=$gbMemberGridfl.selected[0].__index+($gbMemberGridfl.options.page-1)*$gbMemberGridfl.options.pageSize;
						flData.Rows.splice(index,1);
						hasChange();
						$gbMemberGridfl.loadData(flData);
						$.ligerDialog.success("删除成功！");
					}
				}
			);
		}
		//删除一行工作信息
		function deletewk(){
			$.ligerDialog.confirm("是否删除选择【"+$gbMemberGridwk.selected[0].WK_EXPERIENCE+"】?",function(result){
					if(result){
					
						var index=$gbMemberGridwk.selected[0].__index+($gbMemberGridwk.options.page-1)*$gbMemberGridwk.options.pageSize;
						wkData.Rows.splice(index,1);
						hasChange();
						$gbMemberGridwk.loadData(wkData);
						$.ligerDialog.success("删除成功！");
					}
				}
			);
		}
		//删除一行培训信息
        function deletetr(){
			$.ligerDialog.confirm("是否删除选择【"+$gbMemberGridtr.selected[0].TR_EXPERIENCE+"】?",function(result){
					if(result){
					
						var index=$gbMemberGridtr.selected[0].__index+($gbMemberGridtr.options.page-1)*$gbMemberGridtr.options.pageSize;
						trData.Rows.splice(index,1);
						hasChange();
						$gbMemberGridtr.loadData(trData);
						$.ligerDialog.success("删除成功！");
					}
				}
			);
		}
        //保存
		function save(){
		if(!checkValidate(array)){
			return false;
		}
		var dataed = $gbMemberGrided.getData();
			if(dataed.length<1){
				$.ligerDialog.error('至少需要添加一个学历信息');
				
				return false;
			}
	
			
		poststred1=new Object();
		poststred1.departmentId=departmentSel.getValue();
		poststred1.ID='<c:out value='${data.Student.id}'/>';
		poststred1.classId=classSel.getValue();
		poststred1.schoolId=schoolSel.getValue();
		poststred1.NAME=$("#NAME").val();
		poststred1.SEX=$("#SEX").val();
		poststred1.CREDENTIAL_NUMBER=$("#CREDENTIAL_NUMBER").val();
		poststred1.NATION=$("#NATION").val();
		poststred1.EMERGENCY_CONTACT_TEL=$("#EMERGENCY_CONTACT_TEL").val();
		poststred1.BORN_DATE=$("#BORN_DATE").val();
		poststred1.BIRTH_PLACE=$("#BIRTH_PLACE").val();
		poststred1.HOUSE_REGISTE=$("#HOUSE_REGISTE").val();
		poststred1.JOIN_DATE=$("#JOIN_DATE").val();
		poststred1.POLITICAL_APPEARANCE=$("#POLITICAL_APPEARANCE").val();
		poststred1.EMERGENCY_CONTACT_PERSON=$("#EMERGENCY_CONTACT_PERSON").val();
		poststred1.stationId=stationSel.getValue();
		
		poststred1.EDUCATIONAL=new Array();
		poststred1.EXPERIENCE=new Array();
		poststred1.START_DATE=new Array();
		poststred1.END_DATE=new Array();
		poststred1.RELATION=new Array();
		poststred1.FL_NAME=new Array();
		poststred1.TEL=new Array();
		
		
			$.each(dataed,function(i){
				switch(dataed[i].EDUCATIONAL){
					case "小学":
						poststred1.EDUCATIONAL.push('1');
						break;
					case "初中":
						poststred1.EDUCATIONAL.push('2');
						break;
					case "高中":
						poststred1.EDUCATIONAL.push('3');
						break;
					case "中专":
						poststred1.EDUCATIONAL.push('4');
						break;
					case "大专":
						poststred1.EDUCATIONAL.push('5');
						break;
					case "本科":
						poststred1.EDUCATIONAL.push('6');
						break;
					case "硕士":
						poststred1.EDUCATIONAL.push('7');
						break;
					case "博士":
						poststred1.EDUCATIONAL.push('8');
						break;
				}
				
			poststred1.EXPERIENCE.push(dataed[i].EXPERIENCE);
			poststred1.START_DATE.push(dataed[i].START_DATE);
			poststred1.END_DATE.push(dataed[i].END_DATE);
			
			});
			var datafl = $gbMemberGridfl.getData();
			if(datafl.length<1){
				$.ligerDialog.error('至少需要添加一个家庭信息');
				
				return false;
			}
				$.each(datafl,function(i){
				
				if (datafl[i].RELATION=="父亲")	
				datafl[i].RELATION="1";
			if (datafl[i].RELATION=="母亲")		
				datafl[i].RELATION="2";
			if (datafl[i].RELATION=="儿子")		
				datafl[i].RELATION="3";
			if (datafl[i].RELATION=="女儿")	
				datafl[i].RELATION="4";
			if (datafl[i].RELATION=="妻子")		
				datafl[i].RELATION="5";
				
				poststred1.RELATION.push(datafl[i].RELATION);
			poststred1.FL_NAME.push(datafl[i].FL_NAME);
			poststred1.TEL.push(datafl[i].TEL);
		
			
			});
			
			
			var poststred=$('#form1').formSerialize();
		
			wait = $.ligerDialog.waitting("正在提交，请稍后...");
			$.ajax({
						url:"studententrance.do?m=update",
						type:"post",
						dataType:"json",
						data:poststred1,
						cache:false,
						success:saveCallback,
						async:false,
						error:ajaxError
				 });
		}
		
		// 	保存回调
		function saveCallback(result){
			if (result.resultCode == '0'){
				$.ligerDialog.success('添加成功');
				flag=true;
			}
			else{
				$.ligerDialog.error('添加失败'+result.text);				
			}
			wait.close();
		}
		        	
		
    </script>
  </head>
  <body style="padding:10px">
    <form name="form1" method="post"  id="form1">
    	<div align="right">&nbsp; 
        	<input type="button" value="保 存" id="save"/>&nbsp;<input type="button" value="关 闭" id="close" />
        </div>
    	<table align="center" class="editView" cellspacing="1"  border="1">
 			<tr>
			   <td colspan="6" ><div align="center" class="editView td_div">学生入职信息表</div></td>
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
 				 
				     <td align="center" ><select id="dp1" name="dp1" title="学院">
                		<option value="<c:out value='${data.Student.school_id}'/>"> <c:out value='${data.Student.school_name}'/> </option></select>
				    </td>
				    <td align="center" ><select id="dp2" name="dp2" title="系部">
                		<option value="<c:out value='${data.Student.dept_id}'/>">  <c:out value='${data.Student.dept_name}'/>  </option></select>
                	</td>
                	
                	<td align="center" ><select id="dp3" name="dp3" title="班级">
                		<option value="<c:out value='${data.Student.class_id}'/>"> <c:out value='${data.Student.class_name}'/> </option></select>
                	</td>
                   
					
				  <td  align="center" ><input   type="text" name="NAME" id="NAME" title="学生姓名"  value="<c:out value='${data.Student.name}'/>"/></td>
				    <td  align="center" ><select id="SEX" title="学生性别" name="SEX"   style="width:173px;"/>
				    <option value="男">男</option>
                    <option value="女">女</option>
				    </select>
				    </td>
				    <td  align="center" ><input  type="text" name="CREDENTIAL_NUMBER" id="CREDENTIAL_NUMBER" title="学生身份证号码"  value="<c:out value='${data.Student.credential_number}'/>"/></td>
				   	
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
 				 <td  align="center" ><input  type="text" name="NATION" id="NATION" title="员工民族"  value="<c:out value='${data.Student.nation}'/>"/></td>
				    <td  align="center" ><input  type="text" name="BORN_DATE" id="BORN_DATE" title="学生出生日期"  value="<c:out value='${data.Student.born_date}'/>"/></td>
				    <td  align="center" ><input  type="text" name="BIRTH_PLACE" id="BIRTH_PLACE" title="学生出生地"  value="<c:out value='${data.Student.birth_place}'/>"/></td>
				    <td  align="center" ><input type="text" id="HOUSE_REGISTE" title="学生户籍" name="HOUSE_REGISTE" value="<c:out value='${data.Student.house_registe}'/>" /></td>
				    <td  align="center" ><input type="text" name="JOIN_DATE" id="JOIN_DATE" title="入学时间"  value="<c:out value='${data.Student.join_date}'/>"/></td>
				    <td  align="center" ><input  type="text" name="EMERGENCY_CONTACT_PERSON" id="EMERGENCY_CONTACT_PERSON" title="紧急联系人姓名"  value="<c:out value='${data.Student.emergency_contact_person}'/>"/></td>
				</tr>				 
				<tr>
			    <td width="120" class="editView_td_style" align="center" >紧急联系人电话</td>
	               <td width="120" class="editView_td_style" align="center" >政治面貌</td>
				   <td width="120" class="editView_td_style" align="center" >岗位</td>
				 
				    </tr>
				    <tr>	
				   <td  align="center" ><input  type="text" name="EMERGENCY_CONTACT_TEL" id="EMERGENCY_CONTACT_TEL" title="紧急联系人电话"  value="<c:out value='${data.Student.emergency_contact_tel}'/>"/></td>
				  <td  align="center" ><input  type="text" name="POLITICAL_APPEARANCE" id="POLITICAL_APPEARANCE" title="政治面貌 "  value="<c:out value='${data.Student.political_appearance}'/>"/></td>
                	
                	<td align="center" ><select id="station" name="station" title="岗位">
                		<option value="<c:out value='${data.Student.stationid}'/>"> <c:out value='${data.Student.station}'/> </option></select>
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
