<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>仓库信息新增界面</title>
<link href="images/skin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>layer/layer.min.js"></script>
<script type="text/javascript">
/* $(document).ready(function(){
	$("#submitWarehouse").click(function(){
		$.post("execWare!addWarehouse.action",$("#addWarehouse").serialize(),function(data){
			alert("回调函数");
			alert(data);
		}); 
		$.ajax({
			type : "post",
            dataType : "text", // 接收数据格式
			//url : $("#addWarehouse").attr("action"),
			url : "execWare!addWarehouse.action",
			data : $("#addWarehouse").serialize(),
			timeout:20000,
			success : function(data) {
                alert(data);
			},
			error: function () {//请求失败时调用函数。
                 alert("请求失败");
            },  
			
			beforeSend: function(formData, jqForm, options) {  
               alert("正在保存，请稍后...");  
            }  
            //async: true
		}); 
	});
}); */
</script>
</head>
<body>
<form id="addWarehouse" name="addWarehouse" method="post" action="warehouseAction!addWarehouse.action">
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
            <td class="left_txt">当前位置：仓库信息新增</td>
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
                <td class="left_bt2">&nbsp;&nbsp;&nbsp;&nbsp;仓库信息设置</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td>
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="20%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">仓库编号：</td>
                <td width="3%" bgcolor="#f2f2f2">&nbsp;</td>
                <td width="32%" height="30" bgcolor="#f2f2f2"><input name="warehouse.warehouseCode" type="text" id="warehouse.warehouseCode" size="30" /></td>
              </tr>
              <tr>
                <td height="30" align="right" class="left_txt2">仓库名称：</td>
                <td>&nbsp;</td>
                <td height="30"><input type="text" id="warehouse.warehouseName" name="warehouse.warehouseName" size="30" /></td>
              </tr>
              <tr>
                <td height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">联系地址：</td>
                <td bgcolor="#f2f2f2">&nbsp;</td>
                <td height="30" bgcolor="#f2f2f2"><input type="text" id="warehouse.address" name="warehouse.address" size="30" /></td>
              </tr>
              <tr>
                <td height="30" align="right" class="left_txt2">联系电话： </td>
                <td>&nbsp;</td>
                <td height="30"><input type="text" id="warehouse.tel" name="warehouse.tel" size="30" /></td>
              </tr>
              <tr>
                <td height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">联系人：</td>
                <td bgcolor="#f2f2f2">&nbsp;</td>
                <td height="30" bgcolor="#f2f2f2"><input type="text" id="warehouse.contacts" name="warehouse.contacts" size="30" /></td>
              </tr>
              <tr>
                <td height="30" align="right" bgcolor="#F7F8F9" class="left_txt2">仓库备注：</td>
                <td bgcolor="#F7F8F9">&nbsp;</td>
                <td height="30" bgcolor="#F7F8F9"><input type="text" id="warehouse.memo" name="warehouse.memo" size="30" /></td>
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
              <td width="50%" height="30" align="right"><input id="submitWarehouse" type="submit" value="保存" name="B1"/></td>
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
