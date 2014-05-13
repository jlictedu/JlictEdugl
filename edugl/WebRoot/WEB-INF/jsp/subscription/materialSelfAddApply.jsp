<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title></title>
	<link href="<%=path %>/css/common.css" rel="stylesheet"
		type="text/css" />
	<link href="<%=path %>/js/ligerUI/skins/Aqua/css/ligerui-all.css"
		rel="stylesheet" type="text/css" />
	<script src="<%=path %>/js/jquery/jquery-1.5.2.min.js"
		type="text/javascript"></script>
	<script src="<%=path %>/js/jquery/jquery.form.js"
		type="text/javascript"></script>
	<script src="<%=path %>/js/ligerUI/js/core/base.js"
		type="text/javascript"></script>
	<script src="<%=path %>/js/ligerUI/js/plugins/ligerGrid.js"
		type="text/javascript"></script>
	<script src="<%=path %>/js/ligerUI/js/plugins/ligerDialog.js"
		type="text/javascript"></script>
	<script src="<%=path %>/js/ligerUI/js/plugins/ligerResizable.js"
		type="text/javascript"></script>
	<script src="<%=path %>/js/common.js" type="text/javascript"></script>
	<script type="text/javascript">
		var sendData = {};
		
		function checkedMaterialName() {
			var materialName = $("#materialName").val();
			
			if(materialName == "") {
				$.ligerDialog.error("请填写教材名称。");
				return false;
			}
			
			sendData["materialName"] = materialName;
			return true;
		}
		
		function checkedUseClass() {
			var useClass = $("#useClass").val();
			
			if(useClass == "") {
				$.ligerDialog.error("请填写使用班级。");
				return false;
			}
			
			sendData["useClass"] = useClass;
			return true;
		}
		
		function checkedISBN() {
			var isbn = $("#isbn").val();
			
			if(isbn == "") {
				$.ligerDialog.error("请填写ISBN号。");
				return false;
			}
			
			sendData["isbn"] = isbn;
			return true;
		}
		
		function checkedEditor() {
			var editor = $("#editor").val();
			
			if(editor == "") {
				$.ligerDialog.error("请填写编者。");
				return false;
			}
			
			sendData["editor"] = editor;
			return true;
		}
		
		function checkedPrice() {
			var price = $("#price").val();
			
			if(price == "") {
				$.ligerDialog.error("请填写价格。");
				return false;
			}
			
			sendData["price"] = price;
			return true;
		} 
		
		function checkedPress() {
			var press = $("#press").val();
			
			if(press == "") {
				$.ligerDialog.error("请填写出版社。");
				return false;
			}
			
			sendData["press"] = press;
			return true;
		}
		
		function checkedCount() {
			var count = $("#count").val();
			
			if(count == "") {
				$.ligerDialog.error("请填写需要教材数量。");
				return false;
			}
			
			if(isNaN(count)) {
				$.ligerDialog.error("请填写正确需要教材数量。");
				return false;
			}
			
			sendData["count"] = count;
			return true;
		}
		
		function checkedData() {
			if(!checkedMaterialName()) return false;
			if(!checkedUseClass()) return false;
			if(!checkedISBN()) return false;
			if(!checkedEditor()) return false;
			if(!checkedPrice()) return false;
			if(!checkedPress()) return false;
			if(!checkedCount()) return false;
			
			return true;
		}
		
		function assignSendData() {
			if(!checkedData()) return false;
			
			return true;
		}
		
		function addApply() {
			if(!assignSendData()) return;
			
			$.ajax({url:"materialSelf.do?m=addSubmit",type:"POST",data:sendData,dataType:"json",async:false,success:addCallback});
		}
		
		function addCallback(result) {
			if(result.resultCode == 1) {
				$.ligerDialog.success("自编教材征订添加成功，请等待结果。");
				document.getElementById("addApply").disabled = true;
				window.parent.refrushGrid();
			}
			else {
				$.ligerDialog.error("自编教材征订添加失败。");
			}
		}
	</script>
</head>
	
<body>
	<div class="table_container">
		<table cellspacing="0" cellpadding="0"  border="0" class="editViewNoBorder">
			<tr >
				<td>
					<div class="button_panel">
						<input type="button" name="addApply" id="addApply" value="提交" onClick="addApply()" />
					</div>
				</td>
			</tr>
		</table>
	</div>
	
	<div class="table_container">
		<table class="editView" style="margin-top: 20px">
		<tr>
		<td class="editView_td_style">教材名称</td><td align="center" colspan="5"><input id="materialName" style="text-align:center;width:100%;height: 25px;" /></td>
		</tr>
		
		<tr>
		<td class="editView_td_style">使用班级</td><td align="center" colspan="5"><input id="useClass" style="text-align:center;width:100%;height: 25px;" /></td>
		</tr>
		
		<tr>
		<td class="editView_td_style">ISBN号</td><td align="center"><input id="isbn" style="text-align:center;width:100%;height: 25px;" /></td>
		<td class="editView_td_style">编者</td><td align="center" colspan="3"><input id="editor" style="text-align:center;width:100%;height: 25px;" /></td>
		</tr>
		
		<tr>
		<td class="editView_td_style">单价（元）</td><td align="center"><input id="price" style="text-align:center;width:100%;height: 25px;" /></td>
		<td class="editView_td_style">出版社</td><td align="center"><input id="press" style="text-align:center;width:100%;height: 25px;" /></td>
		<td class="editView_td_style">数量</td><td align="center"><input id="count" style="text-align:center;width:100%;height: 25px;" /></td>
		</tr>
		</table>
	</div>
</body>
</html>