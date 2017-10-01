<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>My JSP 'createSubscriptionDtl-1.jsp' starting page</title>

  <script type="text/javascript" src="${pageContext.request.contextPath }/js/calendar.js"></script>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/style.css"></link>
  <style type="text/css">
    div.submit{
  	  text-align:center;
  	  margin-top: 15px;
  	  border: solid 1px #ffffff;
  	}
  	
  	label{
  	  float: left;
  	  width: 80px;
  	  text-align: left;
  	}
  	/hotel/subscriptionDetail-0" forward="/WEB-INF/hotel/subscriptionDetail.jsp"></action
  	fieldset{
  	  position:relative;
      width:300px;
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
  	
  	div.column{
  	}
  	
	  #content p{
	    text-align: center;
	    margin-top: 20px;
	  }
	  
  </style>
  <title>预定客房</title>
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
      <p>请输入您要预定的房间类型以及预订的起始日期，系统会显示可用的房间并供您选择。</p>
      <form action="${pageContext.request.contextPath }/CreateSubscriptionDtl-2.do">
        <fieldset>
          <div class="row">
            <div class="column">
              <label for="rootType">客房类型</label>
              <select name="rootType" id="rootType">
                <option value="1">单人间</option>
                <option value="2">标准间</option>
                <option value="3">豪华标准间</option>
              </select>
            </div>
          </div>
          
          <div class="row">
            <div class="column">
              <label for="bookType">预定方式</label>
              <select name="bookType" id="bookType">
                <option value="1">单个床位</option>
                <option value="2">整个房间</option>
              </select>
            </div>
          </div>
         
          <div class="row">
            <div class="column">
              <label for="startDate">开始日期</label>
              <input type="text" name="startDate" id="startDate" readonly="readonly"
                  onclick="new Calendar().show(this)"/>
            </div>
          </div>
          <div class="row">
            <div class="column">
              <label for="endDate">结束日期</label>
              <input type="text" name="endDate" id="endDate" readonly="readonly"
                  onclick="new Calendar().show(this)"/>
            </div>
          </div>
        </fieldset>
        <div class="submit">
          <input type="button" value="返回" onclick="location='${pageContext.request.contextPath }/hotel/subscriptionDetail-0.do'"/>
          <input type="submit" value="下一步" />
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
