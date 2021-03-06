<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title>My JSP 'login.jsp' starting page</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/style.css"></link>
  <style type="text/css">
    
    #content div{
  	  margin: 10px 0px;
  	}
  	
  	form{
  	  margin-top: 20px;
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
  	}
  	
  	fieldset select{
  	  width:120px;
  	}
  	
  	fieldset input{
  	  width:120px;
  	}  
  	
  </style>
  <title>管理员登录</title>
  </head>
  
  <body>
 <div id="container">
  <div id="header">
  </div>
  <div id="menu">
  </div>
  <div id="content">
    <form action="${pageContext.request.contextPath }/LoginManager.do">
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
      </div>
    </form>
  </div>
  <hr />
  <div id="footer">
    <p>本系统做为Java Web教学设计使用。未经允许，不得做为它用，版权所有Allan<br />联系方式：javamedia@live.cn</p>
  </div>
</div>
  </body>
</html>
