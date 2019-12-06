<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
<link href="css/css.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
</head>
<body>
	<a href="add.jsp"><input type="button" value="添加"></a>
	<table>
		<thead>
			<tr>
				<th>商品名称</th>
				<th>英文名称</th>
				<th>品牌</th>
				<th>种类</th>
				<th>尺寸</th>
				<th>价格（元）</th>
				<th>数量</th>
				<th>标签</th>
				<th>图片</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list}" var="g">
				<tr>
					<th>${g.gname}</th>
					<th>${g.yname}</th>
					<th>${g.bname}</th>
					<th>${g.kname}</th>
					<th>${g.size}</th>
					<th>${g.price}</th>
					<th>${g.num}</th>
					<th>${g.label}</th>
					<th>
						<img alt="xxx" src="${g.picurl}">
					</th>
					<th>操作</th>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<th colspan="10">
					<a href="?pageNum=1"><input type="button" value="首页"></a>
					<a href="?pageNum=${page.pageNum-1 <1 ? page.pageNum : page.pageNum-1}"><input type="button" value="上一页"></a>
					<a href="?pageNum=${page.pageNum+1 >page.pages ? page.pageNum : page.pageNum+1}"><input type="button" value="下一页"></a>
					<a href="?pageNum=${page.pages}"><input type="button" value="尾页"></a>
				</th>
			</tr>
		</tfoot>
	</table>
</body>
</html>