<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<title>管理页面</title>

<script src="<%=basePath %>js/prototype.lite.js" type="text/javascript"></script>
<script src="<%=basePath %>js/moo.fx.js" type="text/javascript"></script>
<script src="<%=basePath %>js/moo.fx.pack.js" type="text/javascript"></script>
<link href="<%=basePath%>css/skin.css" rel="stylesheet" type="text/css">
<link href="<%=basePath%>css/fox.css" rel="stylesheet" type="text/css">
<style>
body {
	font:12px Arial, Helvetica, sans-serif;
	color: #000;
	background-color: #EEF2FB;
	margin: 0px;
}
#container {
	width: 182px;
}
.content{
	width: 182px;
	height: 26px;
	
}
</style>
</head>
<body>
<table width="100%" height="280" border="0" cellpadding="0" cellspacing="0" bgcolor="#EEF2FB">
  <tr>
    <td width="182" valign="top"><div id="container">
      <h1 class="type"><a href="javascript:void(0)">基础信息管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="<%=basePath %>images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="warehouseAction!queryAll.action" target="main">仓库信息</a></li>
          <li><a href="companyAction!queryAll.action" target="main">单位信息</a></li>
          <li><a href="accountsAction!queryAll.action" target="main">结算账户信息</a></li>
          <li><a href="goodsAction!queryAll.action" target="main">商品信息</a></li>
          <li><a href="categoryAction!queryAll.action" target="main">类别信息</a></li>
        </ul>
      </div>
      <h1 class="type"><a href="javascript:void(0)">业务录入</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="<%=basePath %>images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="<%=basePath%>jsp/asn/asnList.jsp" target="main">进货单</a></li>
          <li><a href="<%=basePath%>jsp/asnRma/asnRmaList.jsp" target="main">进货退货单</a></li>
          <li><a href="http://www.mycodes.net" target="main">零售单</a></li>
          <li><a href="http://www.mycodes.net" target="main">进货单</a></li>
          <li><a target="main" href="http://www.mycodes.net">销售退货单</a></li>
          <li><a href="http://www.mycodes.net" target="main">收款单</a></li>
          <li><a href="http://www.mycodes.net" target="main">付款单</a></li>
        </ul>
      </div>
      <h1 class="type"><a href="javascript:void(0)">报表查询</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="<%=basePath %>images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
		  <li><a href="http://www.mycodes.net" target="main">销售排行</a></li>
          <li><a href="http://www.mycodes.net" target="main">零售查询</a></li>
          <li><a href="http://www.mycodes.net" target="main">进货统计</a></li>
          <li><a href="http://www.mycodes.net" target="main">销售分析</a></li>
          <li><a href="http://www.mycodes.net" target="main">利润统计</a></li>
          <li><a href="http://www.mycodes.net" target="main">往来分析</a></li>
          <li><a href="http://www.mycodes.net" target="main">收支项目统计</a></li>
          <li><a href="http://www.mycodes.net" target="main">回款统计</a></li>
          <li><a href="http://www.mycodes.net" target="main">结算账户查询</a></li>
          <li><a href="http://www.mycodes.net" target="main">其它出入库统计</a></li>
        </ul>
      </div>
    </div>
        <script type="text/javascript">
		var contents = document.getElementsByClassName('content');
		var toggles = document.getElementsByClassName('type');
	
		var myAccordion = new fx.Accordion(
			toggles, contents, {opacity: true, duration: 400}
		);
		myAccordion.showThisHideOpen(contents[0]);
	</script>
        </td>
  </tr>
</table>
</body>
</html>