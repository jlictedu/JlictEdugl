<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>人力资源管理系统主页</title>
    <link rel="shortcut icon" href="favicon.ico" />
    <link href="js/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <link href="css/common.css" rel="stylesheet" type="text/css" /> 
    <script src="js/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>
    <script src="js/map.js" type="text/javascript"></script>   
    <script src="js/ligerUI/js/ligerui.min.js" type="text/javascript" charset="utf-8"></script> 
    <script src="js/json2.js" type="text/javascript"></script>
        <script type="text/javascript">
        	var num=2;
            var tab = null;
            var accordion = null;
            var tree = null;
            $(function ()
            {

                //布局
                $("#layout1").ligerLayout({ leftWidth: 205, height: '100%',space:4, onHeightChanged: f_heightChanged });

                var height = $(".l-layout-center").height();

                //Tab
                $("#framecenter").ligerTab({ 
                height: height,
                onBeforeAddTabItem: function(targettabid)
                {
                	if(tab.isTabItemExist(targettabid) )
                        {
                        	tab.selectTabItem(targettabid);
                        	return;
                        }
                }
                });

                //菜单面板
                $("#accordion").ligerAccordion({ height: height - 24, speed: null });

                $(".l-link").hover(function ()
                {
                    $(this).addClass("l-link-over");
                }, function ()
                {
                    $(this).removeClass("l-link-over");
                });
                
				
                tab = $("#framecenter").ligerGetTabManager();
                accordion = $("#accordion").ligerGetAccordionManager();
                $("#pageloading").hide();
                
                tab =$("#framecenter").ligerTab({ 
                	onClickSelectTableItem: function (tabid)
			        {
			            tab.reload(tabid);
			        }
		        });
		        getmenuData();
		       
		        

            });
            
            //获取系统菜单数据
            function getmenuData()
            {
            	$.ajax({url:'menuData.do?r='+Math.random(),dataType:"json",success:createMenuTree});
            }
            //生成菜单树
            function createMenuTree(result)
            {            	
            	var data = result;
            	var rootArray = new Array();
            	var map = new Map();
            	var nodeMap = new Map();
            	var i;
            	//将节点数据组装成树结构
            	for(i in data)
            	{
            		var node = data[i];
            		if(node.isLeaf=='0')
            		{
            			node.children = new Array();
            		}
            		else
            		{
            			node.children = null;
            		}
            		nodeMap.put(node.id,node);
            		if (node.parentId==null||node.id==node.parentId)
            		{
            			rootArray.push(node);            			
            		}
            		else
            		{
            			map.put(node.id,node.parentId);            			
            		}
            	}
            	
            	for(i in data)
            	{
            		var node = data[i];
            		
            		var parent = nodeMap.get(map.get(node.id));
            		if(parent!=null)
            		{
            			parent.children.push(node);
            		}
            	}
            	
				//生成树
				tab.removeAll();
                tree=$("#tree").ligerTree({
                	data : rootArray,                	
                    checkbox: false,
                    slide: true,
                    nodeWidth: 120,                    
                    cache: false,
                    btnClickToToggleOnly:false,
                    onSelect: function (node)
                    {
                        if (node.data.url==null) return;
                        var tabid = node.data.id;
                        
                        f_addTab(tabid, node.data.text, node.data.url);
                    }                    
                });
                tree.collapseAll();
                $("#pageloading").hide();
            }
            
            //面板高度变化回调
            function f_heightChanged(options)
            {
                if (tab)
                    tab.addHeight(options.diff);
                if (accordion && options.middleHeight - 24 > 0)
                    accordion.setHeight(options.middleHeight - 24);
            }
            
            //添加一个新页面
            function f_addTab(tabid,text, url)
            { 
                tab.addTabItem({ tabid : tabid,text: text, url: url });
            } 
            
            //退出系统
            function loginOut()
            {
				if (confirm("您确定要退出系统吗？"))
				{
					top.location = 'loginOut.do';
				}
				return false;
			}
			
			//打开收件箱
			function readMessage()
			{
				f_addTab('990100','收件箱','inbox.do');
				$("#newMessage").text('0');
				return false;
			}
			
			
     </script> 
<style type="text/css"> 
    body,html{height:100%;}
    body{ padding:0px; margin:0;   overflow:hidden;}  
    .l-link{ display:block; height:26px; line-height:26px; padding-left:10px; text-decoration:underline; color:#333;}
    .l-link2{text-decoration:underline; color:white; margin-left:2px;margin-right:2px;}
    .l-layout-top{background:#102A49; color:White;}
    .l-layout-bottom{ background:#E5EDEF; text-align:center;}
    #pageloading{position:absolute; left:0px; top:0px; background:white url('image/loading.gif') no-repeat center; width:100%; height:100%;z-index:99999;}
    .l-link{ display:block; line-height:22px; height:22px; padding-left:16px;border:1px solid white; margin:4px;}
    .l-link-over{ background:#FFEEAC; border:1px solid #DB9F00;} 
    .l-winbar{ background:#2B5A76; height:30px; position:absolute; left:0px; bottom:0px; width:100%; z-index:99999;}
    .space{ color:#E7E7E7;}
    /* 顶部 */ 
    .l-topmenu{ margin:0; padding:0;height:35px; position:relative; border-top:1px solid #1D438B;  }
    .l-topmenu-logo{ color:#000000; line-height:35px; }
    .l-topmenu-welcome{  position:absolute; height:24px; line-height:24px;  right:30px; top:2px;color:#000000;}
    .l-topmenu-welcome a{ color:#000000; text-decoration:underline} 
 </style>
</head>
<body style="padding:0px;background:#EAEEF5;">  
<div id="pageloading"></div>  
<div id="topmenu" class="l-topmenu">
    <!--<div class="l-topmenu-logo"><img src="<%=path %>/js/images/logo.jpg" border="0"/></div>-->
    <div class="l-topmenu-welcome">
        
		欢迎： ${data.userName} 
		新信息 
		<a href="#" style="color:#f00;" onclick="return readMessage();" id="newMessage">${data.newMessageCount}</a>
    	
    	<a href="#" target="_parent" onclick="return loginOut();">退出</a>
    </div> 
</div>
  <div id="layout1" style="width:99.2%; margin:0 auto; margin-top:4px; "> 
        <div position="left"  title="主要菜单" id="accordion"> 
             <div title="功能列表" class="l-scroll">                 
           		 <ul id="tree" style="margin-top:3px;"></ul>
            </div>            
        </div>
        <div position="center" id="framecenter"> 
            <div tabid="home" title="我的主页" style="height:300px" >
                <iframe frameborder="0" name="home" id="home" src="welcome.jsp"></iframe>
            </div> 
        </div> 
    </div>
    <div class="l-layout-bottom">
			<div style="height:26px;color:Blue;line-height:30px;">
				Copyright @ 吉林化工学院-dreamstyle工作室
			</div>
		</div>
</body>
</html>
