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
<script type="text/javascript" src="<%=basePath %>js/categoryList.js"></script>
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
					<div class="titlebt">商品分类信息</div></td>
				<td width="16" valign="top"
					background="<%=basePath%>images/mail_rightbg.gif"><img
					src="<%=basePath%>images/nav-right-bg.gif" width="16" height="29" />
				</td>
			</tr>
		</table>
	</div>
	<div id="context" style="background-color:#EEF2FB;height: 100%">
		 <form action="categoryAction!query.action?page.localPage=1"
			method="post">
			<table>
				<tr>
					<td>商品分类编号 ：</td>
					<td>
						<input type = "text" name = "category.categoryCode"/>
					</td>
					<td>商品分类名称 ：</td>
					<td>
						<input type = "text" name = "category.categoryName"/>
					</td>  
					<td><input type="submit" class="button" id="submit" value="查询">
					</td>
				</tr>
			</table>
		</form>
		<button  id = "updateCategory" name = "updateCategory">修改</button>
		<button  id = "delete" name = "delete">删除</button>
		<a href="<%=basePath %>jsp/category/addCategory.jsp">新增</a>
		<table id="tablelist" style="width:1600px;"cellspacing="0" cellpadding="0" >
			<tr bgcolor="#FFFFFF">
				<td width="15px"><input type="checkbox" id = "checkAll" value="0"/></td>
				<td width="200px"><b>商品分类编号</b></td>
				<td width="200px"><b>商品分类名称</b></td>
				<td width="400px"><b>上级商品分类编号</b></td>
			</tr>
			<s:iterator value="categories" id="cate">
				<tr align="left">
					<td><input type="checkbox" name= "checkbox" value="${cate.id}"/></td>
					<td >${cate.categoryCode}</td>
					<td >${cate.categoryName}</td>
					<td >${cate.parentCode}</td>
				</tr>
			</s:iterator>
		</table>
		<div align="right" style="width:1600px;">
			<s:if test ="message == 'success'">
				<s:if test="page.totalPage == 1">
					<a >首页&nbsp上一页&nbsp下一页&nbsp最末页</a>
				</s:if>
				<s:else>
					<a href="categoryAction!query.action?page.localPage=1">首页</a>&nbsp
			  		<s:if test="page.localPage < page.totalPage&&page.localPage == 1">
			  			上一页&nbsp<a href="categoryAction!query.action?page.localPage=${page.localPage + 1}">下一页</a>&nbsp
			    	</s:if>
					<s:elseif test="page.localPage == page.totalPage">
						<a href="categoryAction!query.action?page.localPage=${page.localPage - 1}">上一页</a>&nbsp下一页&nbsp
			    	</s:elseif>
			    	<s:else>
			    		<a href="categoryAction!query.action?page.localPage=${page.localPage - 1}">上一页</a>&nbsp
			    		<a href="categoryAction!query.action?page.localPage=${page.localPage + 1}">下一页</a>&nbsp
			    	</s:else>
					<a href="categoryAction!query.action?page.localPage=${page.totalPage}">最末页</a>
				</s:else>
			</s:if>
			<s:else>
				<a>首页&nbsp上一页&nbsp下一页&nbsp最末页</a>
			</s:else>
			<a>共有${page.total}条记录，共${page.totalPage}页,当前页为第${page.localPage}页</a>
		</div>
	</div>
</body>
</html>