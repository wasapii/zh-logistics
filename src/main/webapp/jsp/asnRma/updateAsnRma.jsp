<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>退货单修改界面</title>
<link href="images/skin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/asnList.js"></script>
<script type="text/javascript" src="<%=basePath %>js/ui.js"></script>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" height="29" valign="top" background="images/mail_leftbg.gif"><img src="images/left-top-right.gif" width="17" height="29" /></td>
    <td width="935" height="29" valign="top" background="images/content-bg.gif">
    <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
	    <tr>
	       <td height="31"><div class="titlebt">基础信息</div></td><td align="right"><button id="deleteTableRow">删除一行</button></td>
	    </tr>
    </table></td>
    <td width="16" valign="top" background="images/mail_rightbg.gif"><img src="images/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
  <tr>
    <td height="71" valign="middle" background="images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9">
	<form name="updateAsnRma" method="post" action="asnRmaAction!updateAsnRma.action">
	<input type="hidden" name="invoice.id" value="${invoice.id}">
	<input type="hidden" name="invoice.invoiceDate" value="${invoice.invoiceDate}">
	<input type="hidden" name="invoice.invoiceTime" value="${invoice.invoiceTime}">
	<input type="hidden" name="invoice.warehouseCode" value="${invoice.warehouseCode}">
	<input type="hidden" name="invoice.invoiceType" value="${invoice.invoiceType}">
    <table width="100%" height="138" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="13" valign="top" >&nbsp;</td>
      </tr>
      <tr>
        <td valign="top">
        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td class="left_txt">当前位置：退货单修改</td>
          </tr>
          <tr>
            <td height="20"><table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
              <tr>
                <td></td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="nowtable">
              <tr>
                <td class="left_bt2">&nbsp;&nbsp;&nbsp;&nbsp;退货单设置</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td>
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="20%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">单位名称：</td>
                <td width="3%" bgcolor="#f2f2f2">&nbsp;</td>
                <td width="32%" height="30" bgcolor="#f2f2f2"><input name="invoice.company" type="text" size="30" value="${invoice.company}"/></td>
              </tr>
              <tr>
                <td height="30" align="right" class="left_txt2">职员名称：</td>
                <td>&nbsp;</td>
                <td height="30"><input type="text" name="invoice.operator" size="30" value="${invoice.operator}"/></td>
              </tr>
              <tr>
                <td height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">单据编号：</td>
                <td bgcolor="#f2f2f2">&nbsp;</td>
                <td height="30" bgcolor="#f2f2f2"><input type="text" name="invoice.invoiceNum" size="30" value="${invoice.invoiceNum}" /></td>
              </tr>
              <tr>
                <td height="17" colspan="4" align="right" >&nbsp;</td>
              </tr>              
            </table></td>
          </tr>
          <tr><td>
          	<table id = "addTableDeail" width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="20%" height="30" align="left" bgcolor="#f2f2f2" class="left_txt2">进货单详情设置：</td>
              </tr>
			  <tr>
				<td width="15px"><input type="checkbox" id = "checkAll" value="0"/></td>
                <td height="30" align="left" bgcolor="#f2f2f2" class="left_txt2">商品编号</td>
 				<td height="30" align="left" bgcolor="#f2f2f2" class="left_txt2">商品名称</td>
                <td height="30" align="left" bgcolor="#f2f2f2" class="left_txt2">数量</td>
 				<td height="30" align="left" bgcolor="#f2f2f2" class="left_txt2">单位</td>
                <td height="30" align="left" bgcolor="#f2f2f2" class="left_txt2">单价</td>
 				<td height="30" align="left" bgcolor="#f2f2f2" class="left_txt2">金额</td>
 				<td height="30" align="left" bgcolor="#f2f2f2" class="left_txt2">备注</td>
              </tr>
			  <s:iterator value="invoice.invoiceDetails" id="inv" status="L">
			  <input type="hidden" name = "invoice.invoiceDetails[${L.index}].id" value="${inv.id}"/>
			  <tr>
				<td><input type="checkbox" name= "checkbox" value="${inv.id}"/></td>
                <td height="30" align="left" bgcolor="#f2f2f2" class="left_txt2">
					<input type="text" name = "invoice.invoiceDetails[${L.index}].goodsCode" value="${inv.goodsCode}"/>
				</td>
				<td height="30" align="left" bgcolor="#f2f2f2" class="left_txt2">
					<input type="text" name = "invoice.invoiceDetails[${L.index}].goodsName" value="${inv.goodsName}"/>
				</td>
				<td height="30" align="left" bgcolor="#f2f2f2" class="left_txt2">
					<input type="text" name = "invoice.invoiceDetails[${L.index}].goodsNum" value="${inv.goodsNum}"/>
				</td>
				<td height="30" align="left" bgcolor="#f2f2f2" class="left_txt2">
					<input type="text" name = "invoice.invoiceDetails[${L.index}].goodsUnit" value="${inv.goodsUnit}"/>
				</td>
				<td height="30" align="left" bgcolor="#f2f2f2" class="left_txt2">
					<input type="text" name = "invoice.invoiceDetails[${L.index}].goodsUnitPrice" value="${inv.goodsUnitPrice}"/>
				</td>
				<td height="30" align="left" bgcolor="#f2f2f2" class="left_txt2">
					<input type="text" name = "invoice.invoiceDetails[${L.index}].goodsSumPrice" value="${inv.goodsSumPrice}"/>
				</td>
				<td height="30" align="left" bgcolor="#f2f2f2" class="left_txt2">
					<input type="text" name = "invoice.invoiceDetails[${L.index}].memo" value="${inv.memo}"/>
				</td>
              </tr>
          	</s:iterator>
          	</table>
          	</td>
          </tr>
        </table>
          <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="30" colspan="3">&nbsp;</td>
            </tr>
            <tr>
              <td width="50%" height="30" align="right"><input id="submit" type="submit" value="保存" name="B1"/></td>
              <td width="6%" height="30" align="right">&nbsp;</td>
              <td width="44%" height="30"><input type="reset" value="取消" name="B12" /></td>
            </tr>
            <tr>
              <td height="30" colspan="3">&nbsp;</td>
            </tr>
          </table></td>
      </tr>
    </table>
    </form>
    </td>
    <td background="images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <tr>
    <td valign="middle" background="images/mail_leftbg.gif"><img src="images/buttom_left2.gif" width="17" height="17" /></td>
      <td height="17" valign="top" background="images/buttom_bgs.gif"><img src="images/buttom_bgs.gif" width="17" height="17" /></td>
    <td background="images/mail_rightbg.gif"><img src="images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
</table>
</body>

</html>
