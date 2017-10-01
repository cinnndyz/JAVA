<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>My JSP 'memberCenter.jsp' starting page</title>
  <script type="text/javascript" src="../js/calendar.js"></script>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/style.css"></link>
  <style type="text/css">
    
  	table{
  	  margin:auto;
  	  margin-top:0;
  	  border-collapse:collapse;
  	  width: 90%;
  	}
  	
  	th,td{
  	  border:solid 1px #000000;
  	}
  	
  	th{
  	  padding:6px 1px;
  	}
  	
  	td{
  	  padding:8px 1px;
  	}
  	
  	td div{
  	  text-align: center;
  	}
  	
  	.date{
  	  width: 50px;
  	  text-align:center;
  	}
  	
  	#content div.button{
  	  text-align:center;
  	  padding-top:15px;
  	}
  	
  	#content p{
  	  margin: 20px 0;
  	  text-indent: 2em;
  	  line-height: 1.5em;
  	  text-align: center;
  	}
  </style>
  <title>会员中心</title>
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
      <p>
        下面是尚未确认的预定信息，您可以增加、修改或删除订单信息。
      </p>
      <table align="center">
        <colgroup>
          <col class="datetime" />
          <col class="no" />
          <col />
          <col />
          <col />
          <col />
        </colgroup>
        <tr>
          <th>创建时间</th>
          <th>订单号</th>
          <th>联系人</th>
          <th>联系电话</th>
          <th>电子邮件</th>
          <th>操作</th>
        </tr>
        <c:forEach items="${subscriptions}" var="subscription" varStatus="s">
        <tr>
          <td><div><fmt:formatDate value="${subscription.cretime}" pattern="yyyy年MM月dd日 hh时mm分ss秒"/></div></td>
          <td><div><a href="#">${subscription.no}</a></div></td>
          <td><div>${subscription.linkman}</div></td>
          <td>${subscription.phone}</td>
          <td>${subscription.email}</td>
          <td>
            <div>
              <a href="${pageContext.request.contextPath }/Delete02.do?id=${subscription.id}" onclick="return confirm('真的要删除该订单及其明细信息吗？')">删除</a>
              <a href="${pageContext.request.contextPath }/hotel/editSubscription.do?id=${subscription.id}">联系人信息</a>
              <a href="${pageContext.request.contextPath }/hotel/subscriptionDetail.do?id=${subscription.id}">客房信息</a>
            </div>
          </td>
        </tr>
		</c:forEach>
      </table>
      <div class="button">
        <input type="button" value="新建订单" onclick="location='${pageContext.request.contextPath }/hotel/newSubscription.do'"/>
      </div>
    </div>
  </div>
  <hr />
  <div id="footer">
    <p>本系统做为Java Web教学设计使用。未经允许，不得做为它用，版权所有Allan<br />联系方式：javamedia@live.cn</p>
  </div>
</div>
  </body>
</html>
