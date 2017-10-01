<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="entity.Order"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'orderList.jsp' starting page</title>
  </head>
  <body>
  
    	<h1>历史订单</h1>
    	<hr/>
    	<table border="1">
    		<tr>
    			<th>序号</th>
    			<th>订单号</th>
    			<th>生成时间</th>
    			<th>操作</th>
    		</tr>
			<c:forEach items="${orders}" var="order" varStatus="s">
	    		<tr>
	    			<td>${s.count }</td>
	    			<td>
	    				<a href="${pageContext.request.contextPath }/detorder.do?no=${order.no }">
	    					${order.no }
	    				</a>
	    			</td>
	    			<%--<td><my:date date="${order.createTime}" format="yyyy-MM-dd"/>|${fun:dateFormat(order.createTime,"yyyy年MM月dd日 hh时mm分ss秒") }</td> --%>
	    			<td><fmt:formatDate value="${order.createTime}" pattern="yyyy年MM月dd日 hh时mm分ss秒"/></td>
	    			<td>
	    				<a href="${pageContext.request.contextPath }/removeorder.do?id=${order.id }">删除</a>
	    			</td>
	    		</tr>
    		</c:forEach>
    		
    	</table>
    	<a href="${pageContext.request.contextPath }/showIndex.do">返回</a>
  </body>
</html>
