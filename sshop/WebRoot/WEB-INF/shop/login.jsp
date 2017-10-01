<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'login.jsp' starting page</title>
  </head>
  
  <body>
    	<h1>用户登录</h1>
    	<hr/>
    	<form action="${pageContext.request.contextPath }/login.do" method="post">
    		用户名：<input type="text" name="username"/><br/>
    		密码：<input type="password" name="password"/><br/>
    		<input type="submit" value="登录"/>
    	</form>
    	<a href="${pageContext.request.contextPath}/showIndex.do">返回</a><br/>
    	<%
    		String message=(String)request.getAttribute("message");
    	/*	if(message!=null){
    			out.print("<span style='color:red;'>"+message+"</span>");
    		}*/
    	 %>
    	 <c:choose>
    	 	<c:when test="${!empty message}">
    	 			${message }
    	 	</c:when>
    	 </c:choose>
  </body>
</html>
