<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Emp Page</title>

</head>
<body>
	<div class="container">
		<h1>Welcome to Empress Page</h1>
		<!-- 表单框架-->
		<form:form action="add" method="post" modelAttribute="emp">
			<div class="form-grop">
				<label>员工编号</label>
				<form:input path="empno" />
			</div>
			<div class="form-grop">
				<label>员工姓名</label>
				<form:input path="ename" />
			</div>
			<div class="form-grop">
				<label>职位</label>
				<form:input path="job" />
			</div>
			<div class="form-grop">
				<label>上级ID</label>
				<form:input path="mgr" />
			</div>
			<div class="form-grop">
				<label>入职时间</label>
				<form:input path="hiredate" />
			</div>
			<div class="form-grop">
				<label>工资</label>
				<form:input path="sal" />
			</div>
			<div class="form-grop">
				<label>部门ID</label>
				<form:input path="deptno" />
			</div>
			
			<form:button>添加员工</form:button>
		</form:form>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
			integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"
			integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
			crossorigin="anonymous"></script>
		<script type="text/javascript">
			
		