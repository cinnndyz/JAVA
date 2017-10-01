<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>My JSP 'subscriptionDetail.jsp' starting page</title>
  <script type="text/javascript" src="${pageContext.request.contextPath }/js/calendar.js"></script>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/style.css"></link>
  <style type="text/css">
    div.heading{
      border-bottom:solid 1px #000000;
      border-top:solid 1px #ffffff;
      margin-bottom:10px;
    }
    
    div.heading p{
      padding:0;
      margin-bottom:10px;
      text-align:center;
    }
    
  	div.submit{
  	  text-align:center;
  	  margin-top: 15px;
  	  border: solid 1px #ffffff;
  	}
  	
  	fieldset{
  	  position:relative;
      width:450px;
      margin:auto;
      margin-top:20px;
  	}
  	
  	fieldset select{
  	  width:120px;
  	}
  	
  	fieldset input{
  	  width:120px;
  	}
  	
  	div.row{
  	  position: relative;
  	  padding:8px 0;
  	  margin-bottom:10px;
  	}
  	
  	div.column1{
  	  width:25%;
  	  position:relative;
  	  float: left;
  	  margin: 0;
  	}
  	
  	div.column2{
  	  width:25%;
  	  margin: 0;
  	  float:left;
  	}

    div.column3{
      width:25%;
  	  margin: 0;
  	  float:left;
  	}
  	
  	div.column4{
  	  margin-left:675px;
  	  width:180px;
  	}
  	  	
  	.column_1{
  	  float:left;
  	}

   	.column_2{
   	  margin-left:50px;
   	  width:150;
  	}
  	
  	.column_2 span{
  	  border-bottom: dashed 1px #000000;
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
  	
  	.category{
  	  text-align:center;
  	}
  	
  	.date{
  	  text-align:center;
  	}
  	
  	.opt{
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
  <title>查询明细信息</title>
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
  <div id="content" style="border:solid 1px #ffffff;width:90%;margin:auto;padding-top:10px">
    <form action="${pageContext.request.contextPath }/manager/subscriptionDetailUpdate.do">
        <div class="heading">
          <p>订单基本信息</p>
        </div>      
        <div class="row">
          <div class="column1">
            <div class="column_1">
              <span>订单号:</span>
            </div>
            <div class="column_2">
              <span>${Subscription.no}</span>
            </div>
          </div>
          
          <div class="column2">
            <div class="column_1">
              <span>创建时间:</span>
            </div>
            <div class="column_2">
              <span><fmt:formatDate value="${Subscription.cretime}" pattern="yyyy年MM月dd日 hh时mm分ss秒"/></span>
            </div>
          </div>
          
          <div class="column3">
            <div class="column_1">
              <span>会员名:</span>
            </div>
            <div class="column_2">
              <span>${Member.username}</span>
            </div>            
          </div>
          
          <div class="column4">
            <div class="column_1">
              <span>状态:</span>
            </div>
            <div class="column_2">
              <select name="status" id="status">
                <option value="1">待确认</option>
                <option value="2">已确认</option>
                <option value="3">已取消</option>
              </select>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="column1">
            <div class="column_1">
              <span>联系人:</span>
            </div>
            <div class="column_2">
              <span>${Subscription.linkman}</span>
            </div>
          </div>
          
          <div class="column2">
            <div class="column_1">
              <span>联系电话:</span>
            </div>
            <div class="column_2">
              <span>${Subscription.phone}</span>
            </div>
          </div>
          
          <div class="column3">
            <div class="column_1">
              <span>电子邮件:</span>
            </div>
            <div class="column_2">
              <span>${Subscription.email}</span>
            </div>            
          </div>
          <div class="column4">
            <span>&nbsp;</span>
          </div>
        </div>
        
        <div class="row">
          <label for="remark">备注</label>
          <input type="text" class="text" name="remark" id="remark" /> 
          <input type="submit" value="保存" />
        </div>
      </form>
      <div class="heading">
        <p>订单明细信息</p>
      </div>
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
            <a href="${pageContext.request.contextPath }/manager/subscriptionDetailDelete.do?id=${Subscription_dtl.id}" onclick="return confirm('真的要删除该预定细信息吗？')">删除</a>
          </div>
        </td>
      </tr>
       </c:forEach>  
    </table>
    <div class="submit">
      <input type="button" value="返回" onclick="location='${pageContext.request.contextPath }/manager/subscriptionQuery.do'"/>
    </div>
  </div>
  <hr />
  <div id="footer">
    <p>本系统做为Java Web教学设计使用。未经允许，不得做为它用，版权所有Allan<br />联系方式：javamedia@live.cn</p>
  </div>
</div>
  </body>
</html>
