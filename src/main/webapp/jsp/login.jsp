<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"/>
    <title>进销存系统----系统登录</title>
    <style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #1D3647;
}
-->
</style>
<script src="<%=basePath%>js/jquery-1.9.1.min.js"></script> 
<script src="<%=basePath%>js/jquery-1.9.1.js"></script> 



<link href="<%=basePath%>css/skin.css" rel="stylesheet" type="text/css">
<link href="<%=basePath%>css/fox.css" rel="stylesheet" type="text/css">
  </head>
  <script src="js/jquery-1.9.1.min.js"></script>
<script language="JavaScript">
	$(document).ready(function() {
		$("#submit").click(function() {
			var params = $("#loginForm").serialize();
			$.ajax({
				url	: "user!login.action",
				type :"post",
				dataType: "json",
				data : params,
				timeout : 20000,
				success	: function(data){
					//var dataObj=eval(data);
					alert(data);
					if(data != "success"){
						return;
					}
					$("#msg").html("登陆成功");
                    window.location.href ="index.jsp";  
                },
				error	: function(){
					alert("请求失败");
				},
				beforeSend :function(){
					$("#msg").html("正在验证，请稍后...");
				}
			});
		});
	});
</script>
  <body>
  <form id = "loginForm" >
  <table width="100%" height="166" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="42" valign="top">
    <table width="100%" height="42" border="0" cellpadding="0" cellspacing="0" class="login_top_bg">
      <tr>
        <td width="1%" height="21">&nbsp;</td>
        <td height="42">&nbsp;</td>
        <td width="17%">&nbsp;</td>
      </tr>
    </table>
    </td>
  </tr>
  <tr>
    <td valign="top"><table width="100%" height="532" border="0" cellpadding="0" cellspacing="0"  class="login_bg">
      <tr>
        <td width="49%" align="right"><table width="91%" height="532" border="0" cellpadding="0" cellspacing="0" class="login_bg2">
            <tr>
              <td height="138" valign="top"><table width="89%" height="427" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td height="149">&nbsp;</td>
                </tr>
                <tr>
                  <td height="80" align="right" valign="top"><img src="<%=basePath%>images/logo.png" width="279" height="68"></td>
                </tr>
                <tr>
                  <td height="198" align="right" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="35%">&nbsp;</td>
                      <td height="25" colspan="2" class="left_txt"><p>1- 地区商家信息网门户站建立的首选方案...</p></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td height="25" colspan="2" class="left_txt"><p>2- 一站通式的整合方式，方便用户使用...</p></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td height="25" colspan="2" class="left_txt"><p>3- 强大的后台系统，管理内容易如反掌...</p></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td width="30%" height="40"><img src="<%=basePath%>images/icon-demo.gif" width="16" height="16"><a href="http://www.mycodes.net" target="_blank" class="left_txt3"> 使用说明</a> </td>
                      <td width="35%"><img src="<%=basePath%>images/icon-login-seaver.gif" width="16" height="16"><a href="http://www.mycodes.net" class="left_txt3"> 在线客服</a></td>
                    </tr>
                  </table></td>
                </tr>
              </table></td>
            </tr>
            
        </table></td>
        <td width="1%" >&nbsp;</td>
        <td width="50%" valign="bottom"><table width="100%" height="59" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
              <td width="4%">&nbsp;</td>
              <td width="96%" height="38"><span class="login_txt_bt">登陆信息网后台管理</span></td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td height="21"><table cellSpacing="0" cellPadding="0" width="100%" border="0" id="table211" height="328">
                  <tr>
                    <td height="164" colspan="2" align="middle">
                    <form action="userAction!login.action" method="post">
                        <table cellSpacing="0" cellPadding="0" width="100%" border="0" height="143" id="table212">
                          <tr>
                            <td width="13%" height="38" class="top_hui_text"><span class="login_txt">会员名：&nbsp;&nbsp; </span></td>
                            <td height="38" colspan="2" class="top_hui_text"><input id="user.userName" name="user.userName" class="editbox4" size="20">                            </td>
                          </tr>
                          <tr>
                            <td width="13%" height="35" class="top_hui_text"><span class="login_txt"> 密 码： &nbsp;&nbsp; </span></td>
                            <td height="35" colspan="2" class="top_hui_text"><input id="user.password" name="user.password" class="editbox4" type="password" size="20">
                              <img src="<%=basePath%>images/luck.gif" width="19" height="18"> </td>
                          </tr>
                          <tr>
                            <td width="13%" height="35" ><span class="login_txt">验证码：</span></td>
                            <td height="35" colspan="2" class="top_hui_text">
                              </td>
                          </tr>
                          <tr>
                          	<td>
                          		<div id="msg"></div>
                          	</td>
                          </tr>
                          <tr><td><div id="con"></div></td>
                          </tr>
                          <tr>
                            <td height="35" >&nbsp;</td>
                            <td width="20%" height="35" >
                            <input  name="submit" type="submit" class="submit" id="submit" value="登 陆"> </td>
                            <td width="67%" class="top_hui_text">
                            <input name="cs" type="button" class="button" id="cs" value="取 消"></td>
                          </tr>
                        </table>
                        </form>
                        <br>
                    </td>
                  </tr>
                  <tr>
                    <td width="433" height="164" align="right" valign="bottom"><img src="<%=basePath %>images/login-wel.gif" width="242" height="138"></td>
                    <td width="57" align="right" valign="bottom">&nbsp;</td>
                  </tr>
              </table></td>
            </tr>
          </table>
          </td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="20"><table width="100%" border="0" cellspacing="0" cellpadding="0" class="login-buttom-bg">
      <tr>
        <td align="center"><span class="login-buttom-txt">Copyright &copy; 2009-2010 www.mycodes.net</span></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
</body>
</html>
