<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'success.jsp' starting page</title>
  </head>
  
  <body>
    	<h1>生成订单</h1>
    	<hr/>
    	<h1>订单生成成功，订单号：${sessionScope.no }</h1>
    	<a href="<%=request.getContextPath() %>/goshopping.do">继续购物</a>
  </body>
</html>
