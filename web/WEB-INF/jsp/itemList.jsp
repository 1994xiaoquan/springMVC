<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
</head>
<body> 
<form action="${pageContext.request.contextPath }/item/queryitem.action" method="post">
查询条件：
<table width="100%" border=1>
<tr>
<td><input type="submit" value="查询"/></td>
</tr>
</table>
</form>
<%--
<form action="${pageContext.request.contextPath }/item/deleteItems.action" method="post">
--%>
	<form action="${pageContext.request.contextPath }/item/updatesItems.action" method="post">
商品列表：
<table width="100%" border=1>
<tr>
	<td><input name = "ids" type="checkbox" value = ""></td>
	<td style="display:none">商品ID</td>
	<td>商品名称</td>
	<td>商品价格</td>
	<td>生产日期</td>
	<td>商品描述</td>
	<td>操作</td>
</tr>
<c:forEach items="${itemList }" var="item" varStatus="s">
<tr>
	<td><input name = "ids" type="checkbox" value = "${item.id}"></td>
	<td style="display:none"><input name = "itemsList[${s.index}].id" type="hidden" value = "${item.id}"></td>
	<td><input name = "itemsList[${s.index}].name" type="text" value = "${item.name }"> </td>
	<td><input name = "itemsList[${s.index}].price" type="text" value = "${item.price }"></td>
	<td><input name = "itemsList[${s.index}].createtime" type="text" value = "<fmt:formatDate  value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"></td>
	<td><input name = "itemsList[${s.index}].detail" type="text" value = "${item.detail }"></td>
	
	<td><a href="${pageContext.request.contextPath }/item/itemEdit.action?id=${item.id}">修改</a></td>

</tr>
</c:forEach>

</table>
	<tr>
		<td><input type="submit" value="删除"  /></td>
	</tr>
	<tr>
	<td><input type="submit" value="修改"  /></td>
	</tr>
</form>
</body>

</html>