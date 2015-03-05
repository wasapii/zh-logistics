<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">                                                                      
<link href="<%=basePath%>css/skin.css" rel="stylesheet" type="text/css">
<link href="<%=basePath%>css/fox.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>layer/layer.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/ui.js"></script>
<script type="text/javascript" src="<%=basePath %>js/asnList.js"></script>
<script type="text/javascript" src="<%=basePath %>My97DatePicker/WdatePicker.js"></script>

</head>

<body>
	<div style="background-color:#EEF2FB;">
		<table style="width:100% ;border: 0;">
			<tr>
				<td width="17" height="29" valign="top"
					background="<%=basePath%>images/mail_leftbg.gif"><img
					src="<%=basePath%>images/left-top-right.gif" width="17" height="29" />
				</td>
				<td width="100%" height="29" valign="top"
					background="<%=basePath%>images/content-bg.gif">
					<div class="titlebt">进货单列表</div></td>
				<td width="16" valign="top"
					background="<%=basePath%>images/mail_rightbg.gif"><img
					src="<%=basePath%>images/nav-right-bg.gif" width="16" height="29" />
				</td>
			</tr>
		</table>
	</div>
	<div id="context" style="background-color:#EEF2FB;height: 100%">
		<DIV style="height: 400px">
		<form action="asnAction!query.action?page.localPage=1"
			method="post">
			<table>
				<tr>
					<td>日期 ：</td>
					<td><input type="text" name="invoice.startDate"size="20" onClick="WdatePicker()">
					</td> <td> 至 </td>
					<td><input type="text" name="invoice.endDate"size="20" onClick="WdatePicker()">
					</td>
					<td>单据编号 ：</td>
					<td><input type="text" name="invoice.invoiceNum"size="20" >
					</td>
					<td>单位名称 ：</td>
					<td><input type="text" name="invoice.company"size="20" >
					</td>
					<td><input type="submit" class="button" id="submit" value="查询">
					</td>
				</tr>
			</table>
		</form>
		<button  id = "updateAsn" name = "updateAsn">修改</button>
		<button  id = "delete" name = "delete">删除</button>
		<a href="<%=basePath %>jsp/asn/addAsn.jsp">新增</a>
		<table id="tablelist" style="width:1600px;"cellspacing="0" cellpadding="0" >
			<tr bgcolor="#FFFFFF">
				<td width="15px"><input type="checkbox" id = "checkAll" value="0"/></td>
				<td width="200px"><b>单据编号</b></td>
				<td width="200px"><b>日期</b></td>
				<td width="200px"><b>制单时间</b></td>
				<td width="500px"><b>单据类型</b></td>
				<td width="150px"><b>单位名称</b></td>
				<td width="150px"><b>职员名称</b></td>
				<td width="300px"><b>备注</b></td>
			</tr>
			<s:iterator value="invoiceList" id="inv">
				<tr align="left" id = "${inv.id}" ondblclick="showDetail(this)">
					<td><input type="checkbox" name= "checkbox" value="${inv.id}"/></td>
					<td >${inv.invoiceNum}</td>
					<td >${inv.invoiceFormatDate}</td>
					<td >${inv.invoiceFormatTime}</td>
					<td >${inv.invoiceTypeName}</td>
					<td >${inv.company}</td>
					<td >${inv.operator}</td>
					<td >${inv.memo}</td>
				</tr>
			</s:iterator>
		</table>
		</DIV>
		<div align="right" style="width:1600px;height: 50px">
			<s:if test="page.totalPage == 1">
				<a class="page">首页&nbsp上一页&nbsp下一页&nbsp最末页</a>
			</s:if>
			<s:else>
				<a href="asnAction!query.action?page.localPage=1&invoice.startDate=${invoice.startDate}&invoice.endDate=${invoice.endDate}">首页</a>&nbsp
		  		<s:if test="page.localPage < page.totalPage&&page.localPage == 1">
		  			上一页&nbsp<a href="asnAction!query.action?page.localPage=${page.localPage + 1}&invoice.startDate=${invoice.startDate}&invoice.endDate=${invoice.endDate}">下一页</a>&nbsp
		    	</s:if>
				<s:elseif test="page.localPage == page.totalPage">
					<a href="asnAction!query.action?page.localPage=${page.localPage - 1}&invoice.startDate=${invoice.startDate}&invoice.endDate=${invoice.endDate}">上一页</a>&nbsp下一页&nbsp
		    	</s:elseif>
		    	<s:else>
		    		<a href="asnAction!query.action?page.localPage=${page.localPage - 1}&invoice.startDate=${invoice.startDate}&invoice.endDate=${invoice.endDate}">上一页</a>&nbsp
		    		<a href="asnAction!query.action?page.localPage=${page.localPage + 1}&invoice.startDate=${invoice.startDate}&invoice.endDate=${invoice.endDate}">下一页</a>&nbsp
		    	</s:else>
				<a href="asnAction!query.action?page.localPage=${page.totalPage}&invoice.startDate=${invoice.startDate}&invoice.endDate=${invoice.endDate}">最末页</a>
			</s:else>
			<a>共有${page.total}条记录，共${page.totalPage}页,当前页为第${page.localPage}页</a>
		</div>
		<div >
		<table id="tableDetail" style="width:1600px;"cellspacing="0" cellpadding="0" >
			<tr bgcolor="#f2f2f2">
				<td width="25px"><b>序号</b></td>
				<td width="200px"><b>商品编号</b></td>
				<td width="200px"><b>商品名称</b></td>
				<td width="150px"><b>数量</b></td>
				<td width="150px"><b>单位</b></td>
				<td width="150px"><b>单价</b></td>
				<td width="300px"><b>金额</b></td>
				<td width="300px"><b>备注</b></td>
			</tr>
		</table>
	</div>
	</div>
</body>
</html>