var alertDialog=$.ligerDialog;
var message="数据验证失败：";

//注册按钮样式
$(function(){
	$("input[type=button]").addClass("btn_mouseout");
	$("input[type=button]").mouseover(function(){
		$(this).addClass("btn_mouseover");
	}).mouseout(function(){
		$(this).removeClass("btn_mouseover");
	})
	
	$("input[type=submit]").addClass("btn_mouseout");
	$("input[type=submit]").mouseover(function(){
		$(this).addClass("btn_mouseover");
	}).mouseout(function(){
		$(this).removeClass("btn_mouseover");
	})
	
	$("input[type=reset]").addClass("btn_mouseout");
	$("input[type=reset]").mouseover(function(){
		$(this).addClass("btn_mouseover");
	}).mouseout(function(){
		$(this).removeClass("btn_mouseover");
	})
	
});

//让元素的宽度和高度自设置为父元素宽度
function widthAutoFit(object){
	object.width(object.parent().width()-2);
	object.height(object.parent().height()-2);
}


//得到请求url中的参数
function getUrlParam(name) {  
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");  
	var r = location.search.substr(1).match(reg);  
	if (r != null)  
	return unescape(r[2]);  
	return null;  
}

//发送信息
function sendMessage(option){
	var url='outbox.do?m=sendInit';
	if(option&&option.userId){
		url=url+'&userId='+option.userId;		
	}
	
	return $.ligerDialog.open({ title:"消息发送", url:url,
		width: 650,height:450, isResize: true,
		isHidden: false,slide: true,allowClose: true
	});
}

function departmentSelect(_input){
	var input
	if(undefined==_input.jquery){
		input = $(_input);
	}else{
		input = _input;
	}
	var url = 'user.do?m=dept';
	if(input.val()!=''&&input.val()!=null){
		url += '&id='+input.val();
	}
	$.ligerDialog.open({title:'选择部门',url:url,isResize: true,
		isHidden: false,slide: true,allowClose: true,onClose:function(){
			if(this.frame.returnValue!=undefined){
				input.empty();
				input.append($('<option>',{text:this.frame.returnValue.name,value:this.frame.returnValue.id,selected:true}));
			}
		}
	});
}

//关闭窗口 type=1 提示  type=2 不提示
function closeWin(type){
	if(type==1){
		if(window.confirm("是否关闭窗口？")){
			this.window.opener=null;
			window.close();
		}	
	}else{
		this.window.opener=null;
		window.close();
	}
}
//使用ajax时服务器停止时
function ajaxError(){
	if(wait){
		wait.close();
	}
	$.ligerDialog.error('系统错误或与服务器断开连接，请重新登录！');
}
//错误消息
function ajaxErrorMsg(msg){
	
	$.ligerDialog.error('错误消息：'+msg);
	
}

//字符串去除空格
String.prototype.trim=function(){
    return this.replace(/(^\s*)|(\s*$)/g, "");
 }
 String.prototype.ltrim=function(){
    return this.replace(/(^\s*)/g,"");
 }
 String.prototype.rtrim=function(){
    return this.replace(/(\s*$)/g,"");
 }

//校验
function checkValidate(array){
	var flag=true;
	$.each(array,function(i){
		var id=i;
		var validates=array[i];
		$.each(validates,function(v){
			var vv=validates[v].split(":");
			if(vv[0]=="required"){
				if(!requiredValidate(id,vv[1])){
					flag=false;
					return false;
				}
			}else if(vv[0]=="email"){
				if(!emailValidate(id,vv[1])){
					flag=false;
					return false;
				}
			}else if(vv[0]=="url"){
				if(!urlValidate(id,vv[1])){
					flag=false;
					return false;
				}
			}else if(vv[0]=="maxlength"){
				if(!maxlengthValidate(id,vv[1])){
					flag=false;
					return false;
				}
			}else if(vv[0]=="minlength"){
				if(!minlengthValidate(id,vv[1])){
					flag=false;
					return false;
				}
			}else if(vv[0]=="date"){
				if(!dateValidate(id,vv[1])){
					flag=false;
					return false;
				}
			}else if(vv[0]=="number"){
				if(!numberValidate(id,vv[1])){
					flag=false;
					return false;
				}
			}else if(vv[0]=="digits"){
				if(!digitsValidate(id,vv[1])){
					flag=false;
					return false;
				}
			}else if(vv[0]=="equalTo"){
				if(!equalToValidate(id,vv[1])){
					flag=false;
					return false;
				}
			}
			else if(vv[0]=="length"){
				if(!lengthValidate(id,vv[1])){
					flag=false;
					return false;
				}
			}else if(vv[0]=="less"){
				if(!less(id,vv[1])){
					flag=false;
					return false;
				}
			}else if(vv[0]=="more"){
				if(!more(id,vv[1])){
					flag=false;
					return false;
				}
			}
			else{
				flag=true;
			}
		})
		if(!flag){
			return flag;
		}
	})
	
	return flag;
}
//校验空
function requiredValidate(id,value){
	if(value){
		var msg="字段不能为空！";
		var obj=$(id);
		if(obj.val()==""){
				commonAlert(id,"【"+obj.attr("title")+"】"+msg);
			return false;
		}
	}
	return true;
}
//校验邮箱
function emailValidate(id,value){
	if(value){
		var msg="请输入正确格式的电子邮件！";
		var obj=$(id);
		if(obj.val().length>0){
			if(!/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i.test(obj.val())){
				commonAlert(id,"【"+obj.attr("title")+"】"+msg);
				return false;
			}
		}
	}
	return true;
}
//校验url
function urlValidate(id,value){
	if(value){
		var msg="请输入合法的网址！";
		var obj=$(id);
		if(obj.val().length>0){
			if(!/^(https?|ftp):\/\/(((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(\#((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/i.test(obj.val())){
				commonAlert(id,"【"+obj.attr("title")+"】"+msg);
				return false;
			}
		}
	}
	return true;
}
//校验最大长度
function maxlengthValidate(id,value){
	var msg="只能输入最大长度为"+value+"的字符串！";
	var obj=$(id);
	if(obj.val().length>0){
		if(obj.val().length>parseInt(value)){
			commonAlert(id,"【"+obj.attr("title")+"】"+msg);
			return false;
		}
	}
	return true;
}
//校验最小长度
function minlengthValidate(id,value){
	var msg="只能输入最小长度为"+value+"的字符串！";
	var obj=$(id);
	if(obj.val().length>0){
		if(parseInt(value)>obj.val().length){
			commonAlert(id,"【"+obj.attr("title")+"】"+msg);
			return false;
		}
	}
	return true;
}
//校验长度
function lengthValidate(id,value){
	var msg="只能输入长度为"+value+"的字符串！";
	var obj=$(id);
	if(obj.val().length>0){
		if(parseInt(value)!=obj.val().length){
			commonAlert(id,"【"+obj.attr("title")+"】"+msg);
			return false;
		}
	}
	return true;
}
//校验时间
function dateValidate(id,value){
	var msg="请输入合法的日期格式，格式："+value;
	var obj=$(id);
	if(obj.val().length>0){
		if(!dateCheck(obj.val(),value)){
			commonAlert(id,"【"+obj.attr("title")+"】"+msg);
			return false;
		}
	}
	return true;
}
//校验数字
function numberValidate(id,value){
	if(value){
		var msg="请输入合法的数字！";
		var obj=$(id);
		if(obj.val().length>0){
			if(!/^-?(?:\d+|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/.test(obj.val())){
				commonAlert(id,"【"+obj.attr("title")+"】"+msg);
				return false;
			}
		}
	}
	return true;
}
//校验整数
function digitsValidate(id,value){
	if(value){
		var msg="只能输入整数！";
		var obj=$(id);
		if(obj.val().length>0){
			if(!/^\d+$/.test(obj.val())){
				commonAlert(id,"【"+obj.attr("title")+"】"+msg);
				return false;
			}
		}
	}
	return true;
}
//校验相等
function equalToValidate(id,value){
	if(value){
		var msg="值必须相同！";
		var obj=$(id);
		var obj1=$(value);
		if(obj.val().length>0||obj1.val().length>0){
			if(obj.val()!=obj1.val()){
				commonAlert(id,"【"+obj1.attr("title")+"】与【"+obj.attr("title")+"】"+msg);
				return false;
			}
		}
	}
	return true;
}

//校验小于
function less(id,value){
	if(value){
		var msg="的值必须小于！"+value;
		var obj=$(id);
		if(obj.val()>=value){			
			commonAlert(id,"【"+obj1.attr("title")+"】"+msg);
			return false;	s		
		}
	}
	return true;
}

//校验大于
function more(id,value){
	if(value){
		var msg="的值必须小于！"+value;
		var obj=$(id);
		if(obj.val()<=value){			
			commonAlert(id,"【"+obj1.attr("title")+"】"+msg);
			return false;	s		
		}
	}
	return true;
}

//日期格式：YYYY-MM-DD 或 YYYY/MM/DD
function dateCheck(str,dateformat){
	var reg1="^([0-9]{4})[.-]{1}([0-9]{1,2})[.-]{1}([0-9]{1,2})$";
	var reg2="^([0-9]{4})[./]{1}([0-9]{1,2})[./]{1}([0-9]{1,2})$";
	var reg3="^([0-9]{4})$";
	var re;
	if(dateformat=="YYYY-MM-DD"){
		re = new RegExp(reg1);
	}else if(dateformat=="YYYY/MM/DD"){
		re = new RegExp(reg2);
	}else if(dateformat=="YYYY"){
		re = new RegExp(reg3);
	}
	
    var ar;
    var res = true;
    
    if ((ar = re.exec(str)) != null){
        var i;
        i = parseFloat(ar[2]);
        // verify mm
        if (i <= 0 || i > 12){
            res = false;
        }
        i = parseFloat(ar[3]);
        // verify dd
        if (i <= 0 || i > 31){
            res = false;
        }
    }else{
        res = false;
    }
    if (!res){
        return false;
    }
    return res;
}
//公共提示校验消息
function commonAlert(id,content){
	var obj=$(id);
	alertDialog.warn("<div style='color:red;'>"+message+"<br/>"+content+"</div>", "错误提示", function(){
		obj.focus();
		return true;
	});
}
//新建
function add(){
	window.location = document.location ;
}
//jquery扩展函数回车事件
jQuery.fn.onEnter = function(code,callback){
	var flag = false;
	if(code==13){
		flag=true;
	}
	if(flag){
		if (callback){
			callback();
		}
	}
}