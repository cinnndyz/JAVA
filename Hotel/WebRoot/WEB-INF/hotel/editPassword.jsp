<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>My JSP 'editPassword.jsp' starting page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/style.css"></link>
  <style type="text/css">
    
  	form{
      margin: 10px 0;
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
  <title>修改密码</title>  
  </head>
  <script type="text/javascript">
  //  	密码校验
  		function checkPassword(){
  			var p=document.getElementById("newPassword");
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
  			var p=document.getElementById("newPassword");
  			var rep=document.getElementById("reNewPassword");
  			var repmsg=document.getElementById("reNewPasswordMessage");
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
  			if(checkPassword()&&checkRePassword()){
  				return true;
  			}
  			return false;
  		}
  </script>

  <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.1.min.js"></script>
  <script type="text/javascript">
  	$(function(){
		$("#password").blur(function(){
			$.getJSON(
				"${pageContext.request.contextPath}/hotel/validatePassword.do",
				{"pwd":$(this).val()},
				function(ajaxResult){
					if(ajaxResult.name=="success"){
							  		$("#passwordMessage").css("color","green");							  		
							  	}else{
							  		$("#passwordMessage").css("color","red");							  		
							  	}
							  	$("#passwordMessage").text(ajaxResult.data);					
				});														
		});  		 		
  	});
       
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
      <li><a href="${pageContext.request.contextPath }/hotel/memberCenter.do">会员中心</a></li>
    </ul>
  </div>
  <div id="content" style="width:98%;position:relative">
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
      <form action="${pageContext.request.contextPath }/ModifyPwd.do" method="post">        
        <fieldset>
          <legend>密码信息</legend>
          <div>
          	<input type="hidden" name="member.id" id="id" value="${member.id}"/>
            <label for="password">原密码</label>            
            <input type="password" name="password" id="password" /><span id="passwordMessage"></span>
          </div>
          <div>
            <label for="newPassword">新密码</label>
            <input type="password" name="member.pwd" id="newPassword" onblur="checkPassword();" onfocus="onf('newPassword');"/><span id="newPasswordMessage"></span>
          </div>
          <div>
            <label for="reNewPassword">重复新密码</label>
            <input type="password" name="reNewPassword" id="reNewPassword" onblur="checkRePassword();" onfocus="onf('reNewPassword');"/><span id="reNewPasswordMessage"></span>
          </div>
        </fieldset>
        <fieldset class="buttons">
          <input type="submit" value="保存" />
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
