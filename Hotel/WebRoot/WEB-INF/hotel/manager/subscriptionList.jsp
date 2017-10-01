<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>My JSP 'subscriptionList.jsp' starting page</title>
  <script type="text/javascript" src="${pageContext.request.contextPath }/js/calendar.js"></script>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/style.css"></link>
  <style type="text/css">
    
    #content div{
  	  margin: 10px 0px;
  	}
  	
  	table{
  	  margin:auto;
  	  margin-top:20px;
  	  width:700px;
  	  border-collapse:collapse;
  	}
  	
  	th,td{
  	  border:solid 1px #000000;
  	  padding:6px 1px;
  	}
  	
  	.index{
  	  width: 50px;
  	  text-align:center;
  	}
  	
  	.no{
  	  text-align:center;
  	}
  	
  	.shortname{
  	  text-align:center;
  	}
  	
  	.phone{
  	}
  	
  	.email{
  	}
  	
  	.status{
  	}
  	
  	.opt{
  	  text-align:center;
  	}
  	
  	#content div{
  	  text-align:center;
  	  margin:0;
  	  padding:0;
  	}
  	
  	#content div.button{
  	  text-align:center;
  	  padding-top:15px;
  	}
  	
  </style>
  <title>订单列表</title>
  </head>
  
  <body>
<div id="container">
  <div id="header">
    <ul>
      <li><a href="login.html">退出</a></li>
    </ul>
  </div>
  <div id="menu">
    <ul>
      <li><a href="#">客房管理</a></li>
      <li><a href="#">会员管理</a></li>
      <li><a href="${pageContext.request.contextPath }/manager/subscriptionQuery.do">订单管理</a></li>
    </ul>
  </div>
  <div id="content">
    <table>
      <colgroup>
        <col class="index" />
        <col class="no" />
        <col class="shortname" />
        <col class="phone" />
        <col class="email" />
        <col class="status" />
        <col class="opt" />
      </colgroup>
      <tr>
        <th>序号</th>
        <th>订单号</th>
        <th>联系人</th>
        <th>联系电话</th>
        <th>电子邮件</th>
        <th>状态</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${Subscriptions}" var="subscription" varStatus="s">
      <tr>
        <td><div>${s.count}</div></td>
        <td><div><a href="${pageContext.request.contextPath }/manager/subscriptionDetailAction.do?id=${subscription.id}&mid=${subscription.mid}">${subscription.no}</a></div></td>
        <td><div>${subscription.linkman}</div></td>
        <td>${subscription.phone}</td>
        <td>${subscription.email}</td>
        <td>
        <c:if test="${subscription.status==1}"><div>待确定</div></c:if>
        <c:if test="${subscription.status==2}"><div>已确定</div></c:if>
        <c:if test="${subscription.status==3}"><div>已取消</div></c:if>
        </td>
        <td>
          <div>
          	<c:if test="${subscription.status==3}"><a href="${pageContext.request.contextPath }/manager/SubscriptionListDetele.do?id=${subscription.id}" onclick="return confirm('真的要删除该订单及其明细信息吗？')">删除</a></c:if>
            
          </div>
        </td>
      </tr>
      </c:forEach>   
    </table>
    <div class="button">
      <input type="button" value="重新查询" onclick="location='${pageContext.request.contextPath }/manager/subscriptionQuery.do'"/>
    </div>
  </div>
  <hr />
  <div id="footer">
    <p>本系统做为Java Web教学设计使用。未经允许，不得做为它用，版权所有Allan<br />联系方式：javamedia@live.cn</p>
  </div>
</div>
  </body>
</html>
