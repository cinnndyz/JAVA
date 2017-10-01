<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>My JSP 'subscriptionDetail.jsp' starting page</title>
  <script type="text/javascript" src="../js/calendar.js"></script>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/style.css"></link>
  <style type="text/css">
    h1{
      text-align: center;
      font-size: 1em;
      padding: 0.3em 0;
      margin-top: 20px;
    }    
   
  	div.submit{
  	  text-align:center;
  	  margin-top: 15px;
  	  border: solid 1px #ffffff;
  	}
  	
  	table{
  	  margin:auto;
  	  margin-top:5px;
  	  width:720px;
  	  border-collapse:collapse;
  	}
  	
  	th,td{
  	  border:solid 1px #000000;
  	  padding:6px 1px;
  	}
  	
  	.category{
  	  text-align:center;
  	}
  	
  	.date{
  	  text-align:center;
  	}
  	
  	.opt{..
  	  text-align:center;
  	}
  	
  	td div{
  	  text-align: center;
  	  margin: 0;
  	  padding: 0;
  	}
  	
  	.text{
  	  width:390px;
  	}
  	
  </style>
  <title>订单明细信息</title>
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
      <h1>订单明细信息管理</h1>
      <table>
        <colgroup>
          <col class="category" />
          <col class="no" />
          <col />
          <col />
          <col span="2" class="date" />
          <col class="opt" />
        </colgroup>
        <tr>
          <th>房间类型</th>
          <th>房间号</th>
          <th>预定方式</th>
          <th>单价</th>
          <th>入住日期</th>
          <th>退房日期</th>
          <th>操作</th>
        </tr>
        <c:forEach items="${Subscription_dtls}" var="Subscription_dtl" varStatus="s">
        <tr>
          <td>
          <c:if test="${Subscription_dtl.rid<10}"><div>普通双人间</div></c:if>
          <c:if test="${Subscription_dtl.rid>=10&&Subscription_dtl.rid<19}"><div>舒适双人间</div></c:if>
          <c:if test="${Subscription_dtl.rid>=19&&Subscription_dtl.rid<28}"><div>豪华双人间</div></c:if>
          </td>
          <td>
          <c:if test="${Subscription_dtl.rid<10}"><div>${Subscription_dtl.rid+100}</div></c:if>
          <c:if test="${Subscription_dtl.rid>=10&&Subscription_dtl.rid<19}"><div>${Subscription_dtl.rid+191}</div></c:if>
          <c:if test="${Subscription_dtl.rid>=19&&Subscription_dtl.rid<28}"><div>${Subscription_dtl.rid+282}</div></c:if>
          </td>
          <td>
          <c:if test="${Subscription_dtl.residetype==1}"><div>单个床位</div></c:if>
          <c:if test="${Subscription_dtl.residetype==2}"><div>整个房间</div></c:if>
          </td>
          <td><div>${Subscription_dtl.price}</div></td>
          <td>${Subscription_dtl.sdate}</td>
          <td>${Subscription_dtl.edate}</td>
          <td>
            <div>
              <a href="${pageContext.request.contextPath }/Delete01.do?id=${Subscription_dtl.id}" onclick="return confirm('真的要删除该预定细信息吗？')">删除</a>
            </div>
          </td>
        </tr>
        </c:forEach>
      </table>
      <div class="submit">
        <input type="button" value="返回" onclick="location='${pageContext.request.contextPath }/hotel/memberCenter.do'"/>
        <input type="button" value="新增预定" onclick="location='${pageContext.request.contextPath }/hotel/createSubscriptionDtl-1.do'"/>
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
