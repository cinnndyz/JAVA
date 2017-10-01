<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>My JSP 'createSubscriptionDtl-2.jsp' starting page</title>

  <script type="text/javascript" src="js/calendar.js"></script>
  <link rel="stylesheet" type="text/css" href="style/style.css"></link>
  <style type="text/css">
    div.submit{
  	  text-align:center;
  	  margin-top: 15px;
  	  border: solid 1px #ffffff;
  	}
  	
  	table{
  	  margin:auto;
  	  margin-top:3px;
  	  width:600px;
  	  border-collapse:collapse;
  	}
  	
  	td{
  	  border:solid 1px #ffffff;
  	  padding:6px 1px;
  	  text-align:center;
  	}
  	
  	fieldset{
  	  border: 0;
  	}
  	
  	#content p{
  	  text-align: center;
  	  margin-top: 20px;
  	}	  
	  
  </style>
  <title>预定客房</title>
  </head>
  <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.1.min.js"></script>
  <script type="text/javascript">
  		$(function(){
  			$("#rm").click(function(){
  				var flag=false;
  				$("td input[type='checkbox']").each(function(){
  					if($(this).attr("checked")==true){
		  				flag=true;
  					}
  				});
  				
  				if(flag==false){
		  				alert("请选择房间");
		  				return false;
  				}  				 				  				  				
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
      <p>下面是满足您预订条件的房间，请选择一个或多个然后点击完成按钮，点击上一步可以更改预定条件。</p>
      <form action="${pageContext.request.contextPath }/CreateSubscriptionDtl-3.do" >
        <fieldset>
          <table>
          	<c:forEach items="${rooms}" var="room" varStatus="s">
            <tr>            
              <td>
                <label for="${room.no}">${room.no}</label>
                <input type="checkbox" name="room" value="${room.no}" id="${s.count}" />
              </td>             
            </tr>
             </c:forEach>           
          </table>
        </fieldset>
        
        <div class="submit">
          <input type="button" value="上一步" onclick="location='${pageContext.request.contextPath }/hotel/createSubscriptionDtl-1.do'"/>
          <input type="submit" value="完成" id="rm"/>                  
        </div>
      </form>
    </div>
  </div>
  <hr />
  <div id="footer">
    <p>本系统为Java Web教学而设计，不得作为它用，版权所有Allan<br />联系方式：javamedia@live.cn</p>
  </div>
</div>
  </body>
</html>
