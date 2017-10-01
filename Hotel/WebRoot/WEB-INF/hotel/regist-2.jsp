<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>My JSP 'regist-2.jsp' starting page</title>
  <script type="text/javascript" src="js/calendar.js"></script>
  <link rel="stylesheet" type="text/css" href="style/style.css"></link>
  <style type="text/css">
  	#content p{
  	  text-align: center;
  	  margin-top: 20px;
  	}	  
	  
  </style>
  <title>预定客房</title>    
  </head>
  
  <body>
<div id="container">
  <div id="header">
    <ul>
      <li><a href="#">帮助</a></li>
    </ul>
  </div>
  <div id="menu">
    <ul>
      <li><a href="${pageContext.request.contextPath }/hotel/index.do">首页</a></li>
      <li><a href="${pageContext.request.contextPath }/hotel/roomPrice.do">设施与价格</a></li>
      <li><a href="${pageContext.request.contextPath }/hotel/login.do">会员中心</a></li>
    </ul>
  </div>
  <div id="content">
    <p>恭喜你，注册成功，请<a href="${pageContext.request.contextPath }/hotel/login.do">登录</a>。</p>
  </div>
  <hr />
  <div id="footer">
    <p>本系统为Java Web教学而设计，不得作为它用，版权所有Allan<br />联系方式：javamedia@live.cn</p>
  </div>
</div>
  </body>
</html>
