<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Person Page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
	<!-- 引入 ECharts 文件 -->
<script src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Welcome to Japan_Person Page</h1>
		
		<table class="table table-bordered">
			<thead>
				<tr>
					
					<th scope="col">地区编号</th>
					<th scope="col">地区名称</th>
					<th scope="col">罗马音</th>
					<th scope="col">总人口</th>
					<th scope="col">未满15岁人口</th>
					<th scope="col">15-64岁人口</th>
					<th scope="col">65岁以上人口</th>
					<th scope="col">外国人人口</th>
					<th scope="col">人口集中地区人口</th>
					<th scope="col">出生数</th>
					<th scope="col">死亡数</th>
					<th scope="col">入籍者</th>
					<th scope="col">出籍者</th>
					<th scope="col">白天人口</th>
					<th scope="col">总户数</th>
					<th scope="col">一般户数</th>
					<th scope="col">核家族户数</th>
					<th scope="col">单独户</th>
					<th scope="col">65岁以上核家族</th>
					<th scope="col">高龄夫妇家庭</th>
					<th scope="col">独居老人户</th>
					<th scope="col">结婚总数</th>
					<th scope="col">离婚总数</th>
				</tr>
			</thead>	
			<tbody id="person_tbody">
				<!-- 我们要在这里用jsrender模板啦！ -->
			</tbody>
		</table>

		<nav aria-label="...">
			<ul class="pagination" id="page">
				<li class="page-item disabled" id="page_pre"><a
					class="page-link" href="index?pageIndex=${pageIndex-1}&pageSize=${pageSize}" tabindex="-1" aria-disabled="true">Previous</a></li>
				<li class="page-item" id="page_next"><a class="page-link"
					href="index?pageIndex=${pageIndex+1}&pageSize=${pageSize}">Next</a></li>
			</ul>
		</nav>
		
		
		 
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
		
	<!-- Load JsRender latest version, from www.jsviews.com: -->
	<script src="https://www.jsviews.com/download/jsrender.js"></script>
		
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
	<script type="text/javascript">
		window.onload = function() {//页面加载后调用
			
			var pageIndex = ${pageIndex};
			var pageSize = ${pageSize};
			
			//http://localhost:8080/edu0425_new/person/page?pageIndex=1&pageSize=10
			//ajax 可以去请求服务端接口，并且接收返回值, 修改页面数据
			$.ajax({
				url : "page?pageIndex="+pageIndex+"&pageSize="+pageSize,
				success : function(result){
					//ajax成功返回result
					var totalCountPage = result.pagination.totalCountPage;
					initPage(pageIndex, pageSize, totalCountPage);
					
					//1.获取模板
					jsRenderTpl = $.templates('#person_table');
					//2.模板与数据融合
					finalTpl = jsRenderTpl(result);
					//3.加载到HTML里
					$("#person_tbody").html(finalTpl);
				}
				
			});
			
		
		}
		
		function initPage(pageIndex, pageSize, totalCountPage){
			//alert("总页数："+totalCountPage);
			var page_num = "";
		
			var i = 1;
			var j = totalCountPage;
			
			if(pageIndex > 5){
				i = pageIndex - 4;
			}
			
			if(pageIndex + 4 < totalCountPage) {// 如果超出范围就用...代替
				$("#page_next").before("...");
				j = pageIndex + 5;
			}
			
			for (; i <= j; i++) {
				if(i == pageIndex){
					page_num = page_num + '<li class="page-item active" aria-current="page"><a class="page-link" href="index?pageIndex='+i+'&pageSize='+pageSize+'">'+i+'<span class="sr-only">(current)</span></a></li>';
				}else{
					page_num = page_num + '<li class="page-item"><a class="page-link" href="index?pageIndex='+i+'&pageSize='+pageSize+'">'+i+'</a></li>';
				}
			}
			
			$("#page_pre").after(page_num);
			
			if(pageIndex > 5){ // 如果超出范围就用...代替
				$("#page_pre").after("...");
			}
			
			if(pageIndex == 1){//如果是第一页，上一页按钮置灰
				$("#page_pre").addClass("disabled");
			}else{
				$("#page_pre").removeClass("disabled");
			}
			
			if(pageIndex == totalCountPage){//如果是最后一页，下一页按钮置灰
				$("#page_next").addClass("disabled");
			}else{
				$("#page_next").removeClass("disabled");
			}
		}
	</script>
	
	<script type="text/x-jsrender" id="person_table">
		{{for pageData}}
			<tr>
				<td>{{:lid}}</td>
				<td>{{:lname}}</td>
				<td>{{:municipalities}}</td>
				<td>{{:totalPopulation}}</td>
				<td>{{:population_14}}</td>
				<td>{{:population_64}}</td>
				<td>{{:population_65}}</td>
				<td>{{:foreigners}}</td>
				<td>{{:inhabitedPopulation}}</td>
				<td>{{:liveBirths}}</td>
				<td>{{:deaths}}</td>
				<td>{{:imigrants_in}}</td>
				<td>{{:imigrants_out}}</td>
				<td>{{:daytimePopulation}}</td>
				<td>{{:households}}</td>
				<td>{{:privateHouseholds}}</td>
				<td>{{:nuclearFamilies}}</td>
				<td>{{:onepersonHouseholds}}</td>
				<td>{{:nuclearFamily_65}}</td>
				<td>{{:agedCouple}}</td>
				<td>{{:singleAgedCouple}}</td>
				<td>{{:marriages}}</td>
				<td>{{:divorces}}</td>				
			</tr>
		{{/for}}
	</script>
	
	
</body>
</html>