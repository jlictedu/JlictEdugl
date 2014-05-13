<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
  
  <link href="js/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <link href="css/common.css" rel="stylesheet" type="text/css" /> 
    <script src="js/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>
    <script src="js/map.js" type="text/javascript"></script>   
    <script src="js/jquery/jquery.form.js" type="text/javascript"></script>
    <script src="js/ligerUI/js/ligerui.min.js" type="text/javascript" charset="utf-8"></script> 
    <script src="js/json2.js" type="text/javascript"></script>
    <script src="js/common.js" type="text/javascript"></script>
  
    <script type="text/javascript">
        var $_grid;
		var schoolSel;
		var departmentSel;
		var classSel;
		var sexsel;
        $(function ()
        {	
            
            sexsel=$('#sex').ligerComboBox({         
            width: $('#sex').parent().width()-2,
			selectBoxWidth:$('#sex').parent().width()-2
			});
			//显示学院
            departmentSel=$('#dp2').ligerComboBox({ width: $('#dp2').parent().width()-2,
			selectBoxWidth:$('#dp2').parent().width()-2});
            classSel=$('#dp3').ligerComboBox({width: $('#dp3').parent().width()-2,
			selectBoxWidth:$('#dp3').parent().width()-2});
			schoolSel = $('#dp1').ligerComboBox({url:'studententrance.do?m=getdp',
			valueField:'id',
			textField:'name',
			width: $('#dp1').parent().width()-2,
			selectBoxWidth:$('#dp1').parent().width()-2,
			//根据学院显示系部
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
					},
					//根据系部显示班级
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
					}
					
				});	
			}
				});	
			}
			});
			
            $("#query").click(query);
            $("#insert").click(insert);
            $("#edit").click(edit);
            $("#detail").click(detail);
            $("select").each(function(index,element){
				widthAutoFit($('#'+element.id));
			})
			$("input[type=text]").each(function(index,element){
				widthAutoFit($('#'+element.id));
			})
            $_grid = $("#maingrid").ligerGrid({
               
                columns: [
                { display: '学生ID',name: 'id',width: 150,hide:true},
                { display: '学生工号',name: 'student_number',width: 150},
                { display: '姓名', name: 'name', width: 150 },
                { display: '性别', name: 'sex', width: 100},
                { display: '政治面貌', name: 'political_appearance', width: 150 },
                { display: '名族', name: 'nation', width: 100},
                { display: '生日', name: 'born_date', width: 150 },
                { display: '入学时间', name: 'join_date', width: 150 },
                { display: '户籍', name: 'house_registe', width: 100 }               
                ],
                url: 'studententrance.do?m=query', 
                delayLoad: true,
                width: '99.8%',  
                height: '99%',
				pageSize: 20,
				rownumbers:true,
				enabledSort : false,
				root :'rows',                          
				record:'total',                        
				pageParmName :'pageIndex',               
				pagesizeParmName:'pageSize',
				
				onSuccess:function(data){
					if (typeof data.errcode != "undefined")
					{
					   window.location.href="NoLoginOrSessionOut.jsp";
					} 
				},
				onError:function(){
					ajaxError();
				},
				onReload:function(){
					return false;
				},
				onDblClickRow: function(row){
					edit();
				}
				
				
            });
            
            
        });
        
      //详细
        function detail(){
        	if($_grid==null){
        		$.ligerDialog.warn('请选择一行数据！'); return; 
        	}
        	var row = $_grid.getSelectedRow();
            if (!row) { 
            	$.ligerDialog.warn('请选择一行数据！'); return; 
            }
        	$.ligerDialog.open({ title:"学生信息详情", url: 'studententrance.do?m=detailInit&id='+row.id, width: 950,height:450, showMax: true,
        	 showToggle: false, isResize: true, isHidden: false,slide: false});
        }
        
        
        //查询
        function query(){         
 //设置数据参数
			var parms = new Object();
			if(schoolSel.getValue().trim()!=''){
				parms.dp1=schoolSel.getValue().trim();
			}
	
			if(departmentSel.getValue().trim()!=''){
				parms.dp2=departmentSel.getValue().trim();
			
			}
		
			if(classSel.getValue().trim()!=''){
				parms.dp3=classSel.getValue().trim();
			
			}
			if($("#sex").val().trim()!=''){				
				parms.sex=$("#sex").val().trim();
			}
			if($("#name").val().trim()!=''){
				parms.name=$("#name").val().trim();
			}
	
			if($("#studentNumber").val().trim()!=''){
				if(!checkValidate({"#studentNumber":['digits:true','length:8']	})){
					return;
				}
				parms.studentNumber=$("#studentNumber").val().trim();
			}
        	$_grid.set({ parms: parms });
            $_grid.loadData();//加载数据
        }
        
        
        
		
        function shClose(flag){
        	if(flag){
        		query();
        	}
        	shWin.hide();
        }
        
        //登记窗口
        var djWin;
        function insert(){
            djWin=$.ligerDialog.open({ title:"学生信息登记表", url: 'studententrance.do?m=insertInit',width: 1000,height:500, showMax: true, showToggle: false, isResize: true, isHidden: false,slide: false,allowClose: false});

        }
        function insertClose(flag){
        	if(flag){
        		query();
        	}
        	
        	djWin.hide();
        }
        
        // 修改
        var editWin;
        function edit(){
        	if($_grid==null){
        		$.ligerDialog.warn('请选择一行数据！'); return; 
        	}
        	var row = $_grid.getSelectedRow();
            if (!row) { 
            	$.ligerDialog.warn('请选择一行数据！'); return; 
            }
            editWin = $.ligerDialog.open({ title:"学生信息修改", url: 'studententrance.do?m=editInit&id='+row.id, width: 950,height:450, showMax: true, showToggle: false, isResize: true, isHidden: false,slide: false,allowClose: false});
        }
        function editClose(flag){
        	if(flag){
        		query();
        	}
        
        	editWin.hide();
        }
</script>

</head>
<body> 
	<div id="container">
		<form name="form1" method="post"  id="form1">
			<table cellspacing="0" cellpadding="0"  border="0" class="editView" >
	             <tr style="height:30px;">
	             	<td align="right" width="100"  class="editView_td_style" >所属院部:</td>
	                 <td  ><select id="dp1" name="dp1" title="部门">
                		<option value="">-请选择院部-</option></select>
                	</td>
	             	<td align="right" width="100" class="editView_td_style">所属系部:</td>
	                <td> <select id="dp2" name="dp2">
                    <option value="">-请选择系部-</option>
                   </select></td>
	                <td align="right" width="100"  class="editView_td_style">所属班级：</td>
	                <td> <select id="dp3" name="dp3">
                    <option value="">-请选择班级-</option>
                   </select></td>
					<td rowspan="2" align="right" >
	                	<input  type="button" name="query" id="query" value="查 询"/>
	                	<input  type="button" name="edit" id="edit" value="修 改"/>
	                	<input  type="button" name="detail" id="detail" value="详 细"/>
	                	<input  type="button" name="insert" id="insert" value="登 记"/>
	                </td>
					</tr>
					<tr>
	                <td align="right" width="100" class="editView_td_style">姓名:</td>
	                <td align="left"  width="200"><input title="姓名" type="text" id="name" name="name" value=""  style="width:100px;"/></td>
					<td align="right" width="100" class="editView_td_style">性别:</td>
	                <td align="left"  width="200"><select title="性别"  id="sex" name="sex" v  style="width:100px;">
	                <option value="">-请选择性别-</option>
	                <option value="男">男</option>
	                <option value="女">女</option>
	                </select></td>
					<td align="right" width="100" class="editView_td_style">学号:</td>
	                <td align="left"  width="200"><input title="学号" type="text" id="studentNumber" name="studentNumber" value=""  style="width:100px;"/></td>
	             </tr>
	            
	        </table>
	    </form>
    </div>
     
    <div id="maingrid"></div> 
  
    
   
</body>
</html>

