<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>教学质量评估-学生</title>
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
		var evaluationSettingId = "${evaluationSettingId}";
		var evaluationIds;
		var currentEvaluationId;
		var currentIndex;
		var wait;
		
		$(function () {
			initEvaluationIds();
		});
		
		function initEvaluationIds() {
			var para = {evaluationSettingId: evaluationSettingId};
			$.ajax({url:"teacherOfEvaluation.do?m=getEvaluationIds", type:"POST",data:para,dataType:"json",async:false,success:loadEvaluationIds});
		}
		
		function loadEvaluationIds(data) {
			if(data.length != 0) {
				evaluationIds = data;
				currentEvaluationId = evaluationIds[0];
				currentIndex = 0;
				
				loadData();
			}
			else {
				$.ligerDialog.warn("该课程暂时没有评估！", "提示", closeEvaluation);
			}
		}
		
		function loadData() {
			wait = $.ligerDialog.waitting("正在加载数据，请稍后...");
			loadHeadData();
			
			var para = {evaluationId: currentEvaluationId};
			$.ajax({url:"teacherOfEvaluation.do?m=initData", type:"POST",data:para,dataType:"json",async:false,success:loadDataCallback});
			wait.close();
		}
		
		function loadDataCallback(data) {
			if(data == null) return;
			
			fillData(getIndex(data.taEi1), "teachAttitude1");
			fillData(getIndex(data.taEi2), "teachAttitude2");
			fillData(getIndex(data.tcEi1), "teachContent1");
			fillData(getIndex(data.tcEi2), "teachContent2");
			fillData(getIndex(data.tcEi3), "teachContent3");
			fillData(getIndex(data.tcEi4), "teachContent4");
			fillData(getIndex(data.tcEi5), "teachContent5");
			fillData(getIndex(data.tmEi1), "teachMethod1");
			fillData(getIndex(data.tmEi2), "teachMethod2");
			fillData(getIndex(data.tmEi3), "teachMethod3");
			fillData(getIndex(data.teEi1), "teachEffect1");
			
			document.getElementById("teachSum").innerHTML = getSum(data);
			
			if(data.idea != null) {
				$("#ideaContent").val(data.idea);
			}
		}
		
		function getIndex(data) {
			if(data == 10) {
				return 0;
			}
			if(data == 8) {
				return 1;
			}
			if(data == 6) {
				return 2;
			}
			if(data == 2) {
				return 3;
			}
			if(data == 0) {
				return 4;
			}
		}
		
		function fillData(index, target) {
			var element = document.getElementById(target +( index + 1));
			
			element.innerHTML = "√";
		}
		
		function getSum(data) {
			var sum = 0;
			
			sum += data.taEi1;
			sum += data.taEi2;
			sum += data.tcEi1;
			sum += data.tcEi2;
			sum += data.tcEi3;
			sum += data.tcEi4;
			sum += data.tcEi5;
			sum += data.tmEi1;
			sum += data.tmEi2;
			sum += data.tmEi3;
			
			return sum;
		}
		
		function loadHeadData() {
			var para = {evaluationId: currentEvaluationId};
			$.ajax({url:"teacherOfEvaluation.do?m=initHeadInfo",type:"POST",data:para,dataType:"json",async:false,success:loadHeadDataCallback});
		}
		
		function loadHeadDataCallback(data) {
			document.getElementById("dept").innerHTML = data.educationCollege;
			document.getElementById("teacher").innerHTML = data.teacherName;
			document.getElementById("clazz").innerHTML = data.attendClass;
			document.getElementById("course").innerHTML = data.courseName;
		}
		
		function prevEvaluation() {
			if(currentIndex == 0) {
				$.ligerDialog.warn("该页已是第一条信息！");
				return;
			}
			
			currentIndex -= 1;
			currentEvaluationId = evaluationIds[currentIndex];
			loadData();
		}
		
		function nextEvaluation(){
			if(currentIndex == evaluationIds.length - 1) {
				$.ligerDialog.warn("该页已是最后一条信息！");
				return;
			}
			
			currentIndex += 1;
			currentEvaluationId = evaluationIds[currentIndex];
			loadData();
		}
		
		function closeEvaluation() {
			window.parent.closeReadWin();
		}
	</script>
</head>
	
<body>
	<div class ="table_container">
		<div class ="button_panel">
			<input type ="button" name ="submit" id ="submit" value ="上一条" onClick = "prevEvaluation()" />
			<input type ="button" name ="submit" id ="submit" value ="下一条" onClick = "nextEvaluation()" />
			<input type ="button" name ="submit" id ="submit" value ="关闭" onClick = "closeEvaluation()" />
		</div>
		
		<table class ="editView">
			<tr>
			<td class="editView_td_style">学生所在教学院：</td><td id="dept"></td>
			<td class="editView_td_style">班级：</td><td  id="clazz"></td>
			<td class="editView_td_style">课程：</td><td  id="course"></td>
			<td class="editView_td_style">被评教师：</td><td  id="teacher"></td>
			</tr>
		</table>
	</div>
	
	<div class="table_container">
		<table class ="editView">
		<tr>
		<td class="editView_td_style" rowspan ='2'>项目</td>
		<td class="editView_td_style" rowspan ='2'>序号</td>
		<td class="editView_td_style" rowspan ='2'>评估指标</td>
		<td class="editView_td_style" rowspan ='2'>满分100</td>
		<td class="editView_td_style" colspan ='5'>等级</td>
		</tr>
		<tr>
		<td class="editView_td_style" width = 60>很好10</td>
		<td class="editView_td_style" width = 60>较好8</td>
		<td class="editView_td_style" width = 60>一般6</td>
		<td class="editView_td_style" width = 60>差2</td>
		<td class="editView_td_style" width = 60>较差0</td>
		</tr>
		<tr>
		<td class="editView_td_style" rowspan ='2'>教学态度</td>
		<td class="editView_td_style">1</td>
		<td class="editView_td_style">举止得体，仪态端庄，讲课有热情,精神饱满，富有感染力，能吸引学生注意力。</td>
		<td class="editView_td_style">10</td>
		<td id = "teachAttitude11"></td>
		<td id = "teachAttitude12"></td>
		<td id = "teachAttitude13" ></td>
		<td id = "teachAttitude14" ></td>
		<td id = "teachAttitude15"></td>
		</tr>
		<tr>
		<td class="editView_td_style">2</td>
		<td class="editView_td_style">注重并善于同学生的沟通和交流，平易近人，亦师亦友。</td>
		<td class="editView_td_style">10</td>
		<td id = "teachAttitude21"></td>
		<td id = "teachAttitude22"></td>
		<td id = "teachAttitude23"></td>
		<td id = "teachAttitude24"></td>
		<td id = "teachAttitude25"></td>
		</tr>
		<tr>
		<td class="editView_td_style" rowspan ='5'>教学内容</td>
		<td class="editView_td_style">3</td>
		<td class="editView_td_style">对问题的阐述深入浅出，有启发性。</td>
		<td class="editView_td_style">10</td>
		<td id = "teachContent11"></td>
		<td id = "teachContent12"></td>
		<td id = "teachContent13"></td>
		<td id = "teachContent14"></td>
		<td id = "teachContent15"></td>
		</tr>
		<tr>
		<td class="editView_td_style">4</td>
		<td class="editView_td_style">阐述问题简练准确，重点突出,思路清晰。</td>
		<td class="editView_td_style">10</td>
		<td id = "teachContent21"></td>
		<td id = "teachContent22"></td>
		<td id = "teachContent23"></td>
		<td id = "teachContent24"></td>
		<td id = "teachContent25"></td>
		</tr>
		<tr>
		<td class="editView_td_style">5</td>
		<td class="editView_td_style">对课程内容娴熟，运用自如，轻松自然。</td>
		<td class="editView_td_style">10</td>
		<td id = "teachContent31"></td>
		<td id = "teachContent32"></td>
		<td id = "teachContent33"></td>
		<td id = "teachContent34"></td>
		<td id = "teachContent35"></td>
		</tr>
		<tr>
		<td class="editView_td_style">6</td>
		<td class="editView_td_style">讲述内容充实，信息量适中。</td>
		<td class="editView_td_style">10</td>
		<td id = "teachContent41"></td>
		<td id = "teachContent42"></td>
		<td id = "teachContent43"></td>
		<td id = "teachContent44"></td>
		<td id = "teachContent45"></td>
		</tr>
		<tr>
		<td class="editView_td_style">7</td>
		<td class="editView_td_style">教学内容能反映或联系学科的新思想、新概念、新成果。</td>
		<td class="editView_td_style">10</td>
		<td id = "teachContent51"></td>
		<td id = "teachContent52"></td>
		<td id = "teachContent53"></td>
		<td id = "teachContent54"></td>
		<td id = "teachContent55"></td>
		</tr>
		<tr>
		<td class="editView_td_style" rowspan ='3'>教学方法</td>
		<td class="editView_td_style">8</td>
		<td class="editView_td_style">能给予学生思考、联想、创新的启迪。</td>
		<td class="editView_td_style">10</td>
		<td id = "teachMethod11"></td>
		<td id = "teachMethod12"></td>
		<td id = "teachMethod13" ></td>
		<td id = "teachMethod14" ></td>
		<td id = "teachMethod15"></td>
		</tr>
		<tr>
		<td class="editView_td_style">9</td>
		<td class="editView_td_style">注重教与学的互动，能调控课堂秩序和学生情绪，课堂气氛活跃。</td>
		<td class="editView_td_style">10</td>
		<td id = "teachMethod21"></td>
		<td id = "teachMethod22"></td>
		<td id = "teachMethod23" ></td>
		<td id = "teachMethod24" ></td>
		<td id = "teachMethod25"></td>
		</tr>
		<tr>
		<td class="editView_td_style">10</td>
		<td class="editView_td_style">能有效地利用各种教学媒体与教具。</td>
		<td class="editView_td_style">10</td>
		<td id = "teachMethod31"></td>
		<td id = "teachMethod32"></td>
		<td id = "teachMethod33" ></td>
		<td id = "teachMethod34" ></td>
		<td id = "teachMethod35"></td>
		</tr>
		<tr>
		<td class="editView_td_style" colspan ='3'>合计得分</td>	
		<td id = "teachSum" colspan ='6'>0</td>
		</tr>
		<tr>
		<td class="editView_td_style" rowspan ='2' colspan ='2'>教学效果</td>
		<td class="editView_td_style" rowspan ='2' colspan ='2'>对授课教师教学情况的总体满意度</td>
		<td class="editView_td_style">很好</td>
		<td class="editView_td_style">较好</td>
		<td class="editView_td_style">一般</td>
		<td class="editView_td_style">差</td>
		<td class="editView_td_style">较差</td>
		</tr>
		<tr>
		<td height=25></td>
		<td id = "teachEffect11"></td>
		<td id = "teachEffect12"></td>
		<td id = "teachEffect13" ></td>
		<td id = "teachEffect14" ></td>
		<td id = "teachEffect15"></td>
		</tr>
		<tr>
		<td  class="editView_td_style" colspan = "2">
			<p>意见及建议</p>
			<p>限500字以内</p>
		</td>
		<td colspan='7'><textarea id="ideaContent"  style="resize:none;width:100%;height:200px;"></textarea></td>
		</tr>
		</table>
	</div>
</body>
</html>