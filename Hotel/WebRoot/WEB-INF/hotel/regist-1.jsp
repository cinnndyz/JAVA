<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>My JSP 'regist-1.jsp' starting page</title>
  <script type="text/javascript" src="../js/calendar.js"></script>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/style.css"></link>
  <style type="text/css">
    form{
      margin: 5px 0;
    }
    
    fieldset{
      padding: 0 1em 1em 1em;
      margin: auto;      
      width: 400px;
      display: block;
    }
    
    fieldset div{
      margin: 5px 0;
    }
    
    legend {
  		padding: 1em;
  	}
	
    label{
      float: left;
      width: 100px;
    }
    
    #content div input{
      width: 200px;
    }
    
    fieldset.buttons{
      border: solid 1px #ffffff;
      text-align: center;
      display:block;
      margin-top: 20px;
    }
  	
  </style>
  <title>新建订单</title>    
  </head>
  <script type="text/javascript">
//  	用户名校验
  		function checkUsername(){
  			var u=document.getElementById("username");
  			var umsg=document.getElementById("usernameMessage");
  			var uval=u.value;
//  			alert(uval);
			if(uval==""){
				u.className="textbc";
				umsg.innerHTML="用户名不能为空";
				umsg.style.color="red";
				return false;
			}
			return true;
  		}
//  	密码校验
  		function checkPassword(){
  			var p=document.getElementById("password");
  			var pmsg=document.getElementById("passwordMessage");
  			var pval=p.value;
  			
  			if(pval.length<2||pval.length>6){
  				p.className="textbc";
  				pmsg.innerHTML="密码长度必须在2~6位之间";
  				pmsg.style.color="red";
  				return false;
  			}
  			return true;
  		}
//  	确认密码校验
  		function checkRePassword(){
  			var p=document.getElementById("password");
  			var rep=document.getElementById("repassword");
  			var repmsg=document.getElementById("repasswordMessage");
  			var pval=p.value;
  			var repval=rep.value;
  			
  			if(pval!=repval){
  				rep.className="textbc";
  				repmsg.innerHTML="密码不一致";
  				repmsg.style.color="red";
  				return false;
  			}
  			return true;
  		}
  
  
  
  
//  	清除高亮显示与错误信息
  		function onf(obj){
  			var u=document.getElementById(obj);
  			var umsg=document.getElementById(obj+"Message");
  			u.className="";
  			umsg.innerHTML="";
  		}
//  	提交校验
  		function checkAll(){
  			if(checkUsername()&&checkPassword()&&checkRePassword()){
  				return true;
  			}
  			return false;
  		}
  </script>
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
    <form action="${pageContext.request.contextPath }/RegistMember.do" method="post" onsubmit="return checkAll();">
      <fieldset>
        <legend>登录信息[必选]</legend>
        <div>
          <label for="username">用户名</label>
          <input type="text" name="member.username" id="username" onblur="checkUsername();" onfocus="onf('username');"/><span id="usernameMessage"></span>
        </div>
        <div>
          <label for="password">密码</label>
          <input type="password" name="member.pwd" id="password" onblur="checkPassword();" onfocus="onf('password');"/><span id="passwordMessage"></span>
        </div>
        <div>
          <label for="repassword">重复密码</label>
          <input type="password" name="repassword" id="repassword" onblur="checkRePassword();" onfocus="onf('repassword');"/><span id="repasswordMessage"></span>
        </div>
      </fieldset>
      <fieldset>
        <legend>联系信息[可选]</legend>
        <div>
          <label for="name">联系人</label>
          <input type="text" name="member.name" id="name"/>
        </div>
        <div>
          <label for="phone">联系电话</label>
          <input type="text" name="member.phone" id="phone"/>
        </div>
        <div>
          <label for="email">电子邮件</label>
          <input type="text" name="member.email" id="email"/>
        </div>
      </fieldset>
      <fieldset class="buttons">
        <input type="submit" value="注册" />
      </fieldset>
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
