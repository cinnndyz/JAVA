<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="entity.User"%>
<%@page import="entity.Product"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>My JSP 'list.jsp' starting page</title>
  </head>
  <body>
 
  		<h1>商品列表</h1>
  			<c:if test="${empty user}">
  				<a href="${pageContext.request.contextPath}/showLogin.do">登陆</a>
  				<a href="${pageContext.request.contextPath}/showRegist.do">注册</a>
  			</c:if>
  			<c:if test="${!empty sessionScope.user}">
  				${user.username}用户
  				<a href="${pageContext.request.contextPath}/logout.do">注销</a>
  				<a href="${pageContext.request.contextPath}/showAll.do">历史订单</a>
  			</c:if>
  		<hr/>
    	<table border="1">
    		<tr>
    			<th>序号</th>
    			<th>商品</th>
    			<th>价格</th>
    			<th>操作</th>
    		</tr>
    		<c:forEach items="${products}" var="product" varStatus="s">
    			<tr>
    				<td>${s.count}</td>
    				<td>${product.name}</td>
    				<td>${product.price}</td>
    				<td>
    					<a href="${pageContext.request.contextPath }/add.do?productId=${product.id}">加入购物车</a>
    				</td>
    			</tr>
    		</c:forEach>
  		</table>
  		<a href="${pageContext.request.contextPath}/showCart.do">查看购物车</a>
  		
  		
  </body>
</html>
