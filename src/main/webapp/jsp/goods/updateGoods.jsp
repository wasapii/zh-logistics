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

<title>商品信息修改界面</title>
<link href="images/skin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
$("#option").click(function(){
		var id = $("#select").val();
				$.ajax({
					url : "goodsJson!getCata.action",
					type : "post",
					data : id,
					dataType : "json",
					success : function(data) {
						var i = $("#select option").length;
						var category = eval("(" + data + ")");
						if(category.length > i){//若list的长度大于option的长度则说明option尚未添加则为首次触发，否则为二次触发
							$.each(category,function(idx,obj){
								 $("#select").append("<option value="+ obj.categoryCode +">" + obj.categoryName + "</option>");
							});
						}
						}, 
					error : function() {
						alert("error");
					}
				});
	});

});

</script>
</head>
<body>
<form id="updateGoods" name="updateGoods" method="post" action="goodsAction!updateGoods.action">
<input type = "hidden" name="goods.id" value="${goods.id}"/>
<input type = "hidden" name="goods.goodsCode" value="${goods.goodsCode}"/>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" height="29" valign="top" background="images/mail_leftbg.gif"><img src="images/left-top-right.gif" width="17" height="29" /></td>
    <td width="935" height="29" valign="top" background="images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">基础信息</div></td>
      </tr>
    </table></td>
    <td width="16" valign="top" background="images/mail_rightbg.gif"><img src="images/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
  <tr>
    <td height="71" valign="middle" background="images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9"><table width="100%" height="138" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="13" valign="top">&nbsp;</td>
      </tr>
      <tr>
        <td valign="top"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td class="left_txt">当前位置：商品信息修改</td>
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
                <td class="left_bt2">&nbsp;&nbsp;&nbsp;&nbsp;商品信息设置</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td>
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
 			 <tr>
                <td width="20%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">商品序号：</td>
                <td width="3%" bgcolor="#f2f2f2">&nbsp;</td>
                <td width="32%" height="30" bgcolor="#f2f2f2"><input name="goods.id" type="text" id="goods.id" size="30" value="${goods.id}" disabled="disabled"/></td>
              </tr>             <tr>
                <td width="20%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">商品编号：</td>
                <td width="3%" bgcolor="#f2f2f2">&nbsp;</td>
                <td width="32%" height="30" bgcolor="#f2f2f2"><input name="goods.goodsCode" type="text" id="goods.goodsCode" size="30" value="${goods.goodsCode}" disabled="disabled"/></td>
              </tr>
              <tr>
                <td height="30" align="right" class="left_txt2">商品类别：</td>
                <td>&nbsp;</td>
                <td>
                	<select id = "select" name = "goods.category">
                		<option id = "option">${goods.categoryName}</option>
                	</select>
                </td>
              </tr>
              <tr>
                <td height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">商品名称：</td>
                <td bgcolor="#f2f2f2">&nbsp;</td>
                <td height="30" bgcolor="#f2f2f2"><input type="text" name="goods.goodsName" value="${goods.goodsName}" size="30" /></td>
              </tr>
              <tr>
                <td height="30" align="right" class="left_txt2">条码： </td>
                <td>&nbsp;</td>
                <td height="30"><input type="text" name="goods.barCode" value="${goods.barCode}" size="30" /></td>
              </tr>
              <tr>
                <td height="30" align="right" bgcolor="#F7F8F9" class="left_txt2">单位：</td>
                <td bgcolor="#F7F8F9">&nbsp;</td>
                <td height="30" bgcolor="#F7F8F9"><input type="text" name="goods.unit" value="${goods.unit}" size="30" /></td>
              </tr>
              <tr>
                <td height="30" align="right" class="left_txt2">商品规格： </td>
                <td>&nbsp;</td>
                <td height="30"><input type="text" name="goods.specifications" value="${goods.specifications}" size="30" /></td>
              </tr>
              <tr>
              <tr>
                <td height="30" align="right" class="left_txt2">备注： </td>
                <td>&nbsp;</td>
                <td height="30"><input type="text" name="goods.memo" value="${goods.memo}" size="30" /></td>
              </tr>
              <tr>
                <td height="17" colspan="4" align="right" >&nbsp;</td>
              </tr>              
            </table></td>
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
    </table></td>
    <td background="images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <tr>
    <td valign="middle" background="images/mail_leftbg.gif"><img src="images/buttom_left2.gif" width="17" height="17" /></td>
      <td height="17" valign="top" background="images/buttom_bgs.gif"><img src="images/buttom_bgs.gif" width="17" height="17" /></td>
    <td background="images/mail_rightbg.gif"><img src="images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
</table>
</form>
</body>

</html>
