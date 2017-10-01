<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>My JSP 'subscriptionQuery.jsp' starting page</title>
  <script type="text/javascript" src="${pageContext.request.contextPath }/js/calendar.js"></script>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/style.css"></link>
  <style type="text/css">
  	div.submit{
  	  text-align:center;
  	  margin-top: 15px;
  	  border: solid 1px #ffffff;
  	}
  	
  	form{
  	  margin-top: 20px;
  	}
  	
  	label{
  	  width:70px;
  	  display:block;
  	  float:left;
  	  text-align: center;
  	  padding: 3px 0;
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
  	  border: solid 1px #ffffff;
  	}
  	
  	div.column1{
  	  float: left;
  	}
  	
  	div.column2{
  	  margin-left:210px;
  	}
  </style>
  <title>订单查询</title>
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
    <form action="${pageContext.request.contextPath }/manager/SubscriptionListAction.do">
      <fieldset>
        <legend>查询条件</legend>
        <div class="row">
          <div class="column1">
            <label for="rootType">客房类型</label>
            <select name="rootType" id="rootType">
              <option value="0">不限</option>
              <option value="1">单人间</option>
              <option value="2">标准间</option>
              <option value="3">豪华标准间</option>
            </select>
          </div>
          <div class="column2">
            <label for="status">状态</label>
            <select name="status" id="status">
              <option value="0">不限</option>
              <option value="1">待确认</option>
              <option value="2">已确认</option>
              <option value="3">已取消</option>
            </select>
          </div>
        </div>
       
        <div class="row">
          <div class="column1">
            <label for="startDate">开始日期</label>
            <input type="text" name="startDate" id="startDate" readonly="readonly"
                onclick="new Calendar().show(this)"/>
          </div>
          <div class="column2">
            <label for="endDate">结束日期</label>
            <input type="text" name="endDate" id="endDate" readonly="readonly"
                onclick="new Calendar().show(this)"/>
          </div>
        </div>
        <div class="row">
          <div class="column1">
            <label for="no">订单号</label>
            <input type="text" name="no" id="no" />
          </div>
          <div class="column2">
            <label for="username">会员名</label>
            <input type="text" name="username" id="username" />
          </div>
        </div>
      </fieldset>
      <div class="submit">
        <input type="submit" value="查询" />
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
