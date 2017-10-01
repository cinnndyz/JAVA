<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>My JSP 'index.jsp' starting page</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/style.css"></link>
  <style type="text/css">
    img{
  	  margin-right:5px;
  	  margin-bottom:5px;
  	  border:0;
  	  float:right;
  	}
  	
    p{
      margin:0;
      padding:0;
      padding-top:15px;
      border:solid 1px #ffffff;
    }  	
    
    table{
      padding: 0;
      margin:0;
    }
    
    td{
      padding: 3px 1px;
      border: solid 1px #ffffff;
    }
    
    form{
      margin:0;
      padding:0;
    }
    
    label{
      width: 70px;
    }
    
    input.field{
      width:90px;
    }
    
    div.buttons{
      padding: 5px 0;
      text-align:center;
      border:solid 1px #ffffff;
    }
    
    div.login{
      width:160px;
      border:dashed 1px #00FFCC;
      float:left;
      margin: 15px 8px 5px 0;
    }
	
  </style>
  <title>腾达宾馆</title>
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
      <li>
      <c:if test="${empty member}">
      <a href="${pageContext.request.contextPath }/hotel/login.do">会员中心</a>
       </c:if>
       <c:if test="${!empty member}">
       <a href="${pageContext.request.contextPath }/hotel/memberCenter.do">会员中心</a>
        </c:if>
      </li>
    </ul>
  </div>
  <div id="content">  
    <div class="login">
    <c:if test="${empty member}">
      <form action="${pageContext.request.contextPath }/LoginMember.do">
        <table>
          <tr>
            <td>
              <label for="username">用户名</label>
            </td>
            <td>
              <input type="text" name="username" id="username" class="field"/>
            </td>
          </tr>
          <tr>
            <td>
              <label for="password">密码</label>
            </td>
            <td>
              <input type="password" name="password" id="password"  class="field"/>
            </td>
          </tr>
        </table>
        <div class="buttons">
          <input type="submit" value="登录" />
          <input type="button" value="注册" onclick="location='${pageContext.request.contextPath }/hotel/regist-1.do'"/>
        </div>
      </form>
       </c:if>
       <c:if test="${!empty member}">
    	${member.username }用户
    	<a href="${pageContext.request.contextPath }/logout.do">注销</a>
   	   </c:if>
    </div>   
    <p>
      腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区，　腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区
      腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区，　腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区
    </p>
    <img src="${pageContext.request.contextPath }/images/hotel001.jpg" />
    <p>
      腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区，　腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区
      腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区，　腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区
      腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区，　腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区
      腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区，　腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区
      腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区，　腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区
      腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区，　腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区
      腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区，　腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区
      腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区，　腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区
      腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区，　腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区
    </p>
  </div>
  <hr />
  <div id="footer">
    <p>本系统为Java Web教学而设计，不得作为它用，版权所有Allan<br />联系方式：javamedia@live.cn</p>
  </div>
</div>
  </body>
</html>
