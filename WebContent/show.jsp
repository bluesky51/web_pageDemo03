<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
input[type='button'] {
	border: 1px solid gray;
	background: white;
	width: 60px;
	height: 30px;
}

a {
	border: 1px solid gray;
	background: white;
	padding: 5px 10px 5px 10px;
	width: 60px;
	height: 30px;
	text-decoration: none;
}

input[type='text'] {
	border: 1px solid gray;
	background: white;
	width: 30px;
	height: 25px;
}
</style>
<script type="text/javascript">
	function JumpPage() {
		var inputPage = document.getElementById("inputPage");
		window.location.href = "http://localhost:8080/web_pageDemo03/ShowPageDataServlet?pageNo="
				+ inputPage.value + "&pageSize=10";
	}
</script>
</head>
<body>

	<center>
		<h1>分页效果示例：第${shopBean.pageNo}页/共${shopBean.totalPage}页</h1>
		<table border='1' width='70%'>
			<tr>
				<td>编号</td>
				<td>名称</td>
				<td>价格</td>
				<td>分类</td>
			</tr>
			<c:forEach items="${shopBean.list}" var="shop">
				<tr>
					<td>${shop.id }</td>
					<td>${shop.name }</td>
					<td>${shop.price }</td>
					<td>${shop.category }</td>
				</tr>
			</c:forEach>

		</table>
		<br>
		<a
			href="${pageContext.request.contextPath}/ShowPageDataServlet?pageNo=1&pageSize=10">首页</a>
		
		<c:forEach var="i" begin="${shopBean.startPos }" end="${shopBean.endPos}">
		<c:if test="${i==shopBean.pageNo}">
		 <a href="${pageContext.request.contextPath}/ShowPageDataServlet?pageNo=${i}&pageSize=10" style="color: red;">${i}</a>
		</c:if>
		<c:if test="${i!=shopBean.pageNo}">
		 <a href="${pageContext.request.contextPath}/ShowPageDataServlet?pageNo=${i}&pageSize=10" style="color: black;">${i}</a>
		</c:if>
		   
		</c:forEach>
		<a
			href="${pageContext.request.contextPath}/ShowPageDataServlet?pageNo=${shopBean.totalPage}&pageSize=10">尾页</a>
		跳转到 <input type="text" name="inputPage" id="inputPage"
			placeHolder="${shopBean.pageNo}" style="text-align: center;" />页 <a
			href="javascript:JumpPage()">确定</a>
	</center>

</body>
</html>