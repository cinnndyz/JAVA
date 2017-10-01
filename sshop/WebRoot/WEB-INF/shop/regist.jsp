<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'regist.jsp' starting page</title>
  </head>
  <body>
  		<%
  			String message=(String)request.getAttribute("message");
  		 %>
    	<h1>用户注册</h1>
    	<hr/>
    	<form action="<%=request.getContextPath() %>/regist.do" method="post">
    		用户名：<input type="text" name="username"/><br/>
    		密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password"/><br/>
    		电&nbsp;&nbsp;&nbsp;话：<input type="text" name="phone"><br/>
    		地&nbsp;&nbsp;&nbsp;址：<input type="text" name="address"/><br/><!--
    		验证码：<input type="text"/><br/>
    		<a href="javascript:;">
    			<img src="#">
    		</a>
    		<a href="javascript:;">看不清</a><br/>
    		-->
    		<input type="submit" value="注册"/>
    	</form>
    	<a href="<%=request.getContextPath() %>/showIndex.do">返回</a>
    	<%
    		if(message!=null){
    				out.print("<span sytle='color:red'>"+message+"</span>");
    		}
    	 %>
  </body>
</html>
