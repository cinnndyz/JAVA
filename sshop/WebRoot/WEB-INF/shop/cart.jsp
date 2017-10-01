<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'cart.jsp' starting page</title>
  </head>
  <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.4.1.min.js"></script>
  <script type="text/javascript">
  	$(function(){
  			
  			$("th input").click(function(){
  				if($(this).attr("checked")==true){
  					$("td input[type='checkbox']").attr("checked",true);
  				}else{
  					$("td input[type='checkbox']").attr("checked",false);
  				}
  			});
  		
  			$("#rm").click(function(){
  				var flag=false;
  				$("td input[type='checkbox']").each(function(){
  					if($(this).attr("checked")==true){
		  				flag=true;
  					}
  				});
  				
  				if(flag){
		  				$("form").submit();
  				}else{
	  				alert("请选择要删除的商品");
  				}
  				
  				
  			});
  			
  			$("td a[href='javascript:;']").click(function(){
				var productId=$("input[type='checkbox']",$(this).parent().parent()).val();
				var num=$("input[type='text']",$(this).parent().parent()).val();
//				alert(productId+" "+num);
				$(this).attr("href","${pageContext.request.contextPath}/cartmodify.do?productId="+productId+"&num="+num);

			});
  		
  		
  		});
  </script>
  <body>
  	
    	<h1>我的购物车</h1>
    	<hr/>
    	<form action="${pageContext.request.contextPath}/removeIds.do" method="post">
	    	<table border="1">
	    		<tr>
	    			<th>
	    				<input type="checkbox"/>全选
	    			</th>
	    			<th>序号</th>
	    			<th>商品</th>
	    			<th>数量</th>
	    			<th>价格</th>
	    			<th>操作</th>
	    		</tr>
	    		
	    		<c:forEach items="${cart.items}" var="item" varStatus="s">
	    		
	    		<tr>
	    			<td>
	    				<input name="productId" value="${item.product.id}"type="checkbox"/>
	    			</td>
	    			<td>${s.count}</td>
	    			<td>${item.product.name}</td>
	    			<td>
	    				<input type="text" value="${item.num }" style="width: 50px;border: 0;"/>
	    				
	    			</td>
	    			<td>${item.price}</td>
	    			
	    			<td>
	    				<a href="<%=request.getContextPath() %>/removeId.do?productId=${item.product.id} ">删除</a>
	    				<a href="javascript:;">修改</a>
	    			</td>
	    		</tr>
	    		</c:forEach>
	    	</table>
    	</form>
    	<hr/>
    	总计：${cart.price }元<br/>
    	<a id="rm" href="javascript:;">删除选中项</a>
    	<a href="<%=request.getContextPath() %>/clear.do">清空购物车</a>
    	<a href="<%=request.getContextPath() %>/backlist.do">继续购物</a>
    	<a href="<%=request.getContextPath() %>/showOrder.do">结算</a>
  </body>
</html>
