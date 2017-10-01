<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>My JSP 'login.jsp' starting page</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/style.css"></link>
  <style type="text/css">
    
    #content div{
  	  margin: 10px 0px;
  	}
  	
  	div.submit{
  	  text-align:center;
  	}
  	
  	label{
  	  width:80px;
  	  display:block;
  	  float:left;
  	}
  	
  	fieldset{
      width:300px;
      margin:auto;
      margin-top:20px;
      display:block;
  	}
  	
  	fieldset select{
  	  width:120px;
  	}
  	
  	fieldset input{
  	  width:120px;
  	}  
  	
  </style>
  <title>登录</title>
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
     <c:if test="${empty member}">
      <a href="${pageContext.request.contextPath }/hotel/login.do">会员中心</a>
       </c:if>
       <c:if test="${!empty member}">
       <a href="${pageContext.request.contextPath }/hotel/memberCenter.do">会员中心</a>
        </c:if>
    </ul>
  </div>
  <div id="content">
  <form action="${pageContext.request.contextPath }/LoginMember.do">
    <fieldset>
      <legend>登录信息</legend>
      <div>
        <label for="username">用户名</label>
        <input type="text" name="username" id="username" />
      </div>
      <div>
        <label for="password">密码</label>
        <input type="password" name="password" id="password" />
      </div>
    </fieldset>
    <div class="submit">
      <input type="submit" value="登录" />
      <p>如果您还没注册，请<a href="${pageContext.request.contextPath }/hotel/regist-1.do">点击这里注册</a>成为会员。</p>
    </div>
  </form>
  <h:errors/>
  </div>
  <hr />
  <div id="footer">
    <p>本系统做为Java Web教学设计使用。未经允许，不得做为它用，版权所有Allan<br />联系方式：javamedia@live.cn</p>
  </div>
</div>
  </body>
</html>
