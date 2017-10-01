<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'newSubscription.jsp' starting page</title>
  <script type="text/javascript" src="../js/calendar.js"></script>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/style.css"></link>
  <style type="text/css">
    form{
      margin: 15px 0;
    }
    
    fieldset{
      padding: 0 1em 1em 1em;
      margin: auto;      
      width: 400px;
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
    
    fieldset div input{
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
  		 function checkName(){
  			var u=document.getElementById("name");
  			var umsg=document.getElementById("nameMessage");
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
  		 
  		function checkPhone(){
  			var u=document.getElementById("phone");
  			var umsg=document.getElementById("phoneMessage");
  			var uval=u.value;
//  			alert(uval);
			if(uval==""){
				u.className="textbc";
				umsg.innerHTML="号码不能为空";
				umsg.style.color="red";
				return false;
			}
			return true;
  		}
  		
  		  function checkEmai(){
  			var u=document.getElementById("email");
  			var umsg=document.getElementById("emailMessage");
  			var uval=u.value;
//  			alert(uval);
			if(uval==""){
				u.className="textbc";
				umsg.innerHTML="电子邮箱不能为空";
				umsg.style.color="red";
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
  			if(checkName()&&checkPhone()&&checkEmail()){
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
    <div class="submenu">
      <ul>
        <li><a href="${pageContext.request.contextPath }/hotel/memberCenter.do">客房预订</a></li>
        <li><a href="${pageContext.request.contextPath }/hotel/historySubscription.do">历史订单</a></li>
        <li><a href="${pageContext.request.contextPath }/hotel/editMember.do">修改信息</a></li>
        <li><a href="${pageContext.request.contextPath }/hotel/editPassword.do">修改密码</a></li>
        <li><a href="${pageContext.request.contextPath }/logout.do">退出系统</a></li>
      </ul>
    </div>
    <div class="subcontent">
      <form action="${pageContext.request.contextPath }/NewSubscription.do" method="post" onsubmit="return checkAll();">
        <fieldset>
          <legend>联系人信息</legend>
          <div>
          	<input type="hidden" name="subscription.mid" id="id" value="${member.id}"/>
            <label for="name">联系人</label>
            <input type="text" name="subscription.linkman" id="name" onblur="checkName();" onfocus="onf('name');"/><span id="nameMessage"></span>
          </div>
          <div>
            <label for="phone">联系电话</label>
            <input type="text" name="subscription.phone" id="phone" onblur="checkPhone();" onfocus="onf('phone');"/><span id="phoneMessage"></span>
          </div>
          <div>
            <label for="email">电子邮件</label>
            <input type="text" name="subscription.email" id="email" onblur="checkEmai();" onfocus="onf('email');"/><span id="emailMessage"></span>
          </div>
        </fieldset>
        <fieldset class="buttons">
          <input type="submit" value="创建" />
        </fieldset>
      </form>
    </div>
  </div>
  <hr />
  <div id="footer">
    <p>本系统做为Java Web教学设计使用。未经允许，不得做为它用，版权所有Allan<br />联系方式：javamedia@live.cn</p>
  </div>
</div>
  </body>
</html>
