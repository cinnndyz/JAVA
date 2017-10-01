<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="entity.User"%>
<%@page import="entity.Cart"%>
<%@page import="entity.Item"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'order.jsp' starting page</title>
  </head>
  
  <body>
  		<%
  			User user=(User)session.getAttribute("user");
  			
  			Cart cart=(Cart)session.getAttribute("cart");
  			List<Item> items=cart.getItems();
  		 %>
  
    	<h1>确认订单</h1>
    	<hr/>
    	用户名：<%=user.getUsername() %><br/>
    	电话：<%=user.getPhone() %><br/>
    	地址：<%=user.getAddress() %><br/>
    	<table border="1">
    		<tr>
    			<th>序号</th>
    			<th>商品</th>
    			<th>数量</th>
    			<th>价格</th>

			<%
				int i=1;
				for(Item item:items){
			 %>
    		<tr>
    			<td><%=i++ %></td>
    			<td><%=item.getProduct().getName() %></td>
    			<td><%=item.getNum() %></td>
    			<td><%=item.getPrice() %></td>
    		</tr>
    		<%
    			}
    		 %>
    		
    	</table>
    	<hr/>
    	总计：<%=cart.getPrice() %>元<br/>
    	<a href="<%=request.getContextPath() %>/createOrder.do">生成订单</a>
    	<a href="<%=request.getContextPath() %>/backcart.do">返回</a>
  </body>
</html>
