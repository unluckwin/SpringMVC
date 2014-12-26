<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>系统登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
  <style type="text/css">
<!--
.STYLE1 {
	color: #000099;
	font-weight: bold;
}
-->
  </style>
  <script type="text/javascript">
	    function gao()
	    {
		    var username=document.getElementById("uid").value;
		    var password=document.getElementById("pwd").value;
		  
		    if(username==""||password=="")
		    {
			    alert("用户名或密码不能为空");
			    return false;
		    }
		    return true;
	    }
	
	</script>
  </head>
  
  <body>
  <form name="form1" method="post" action="checklogin.view">
    <table width="1047" border="0" align="center" cellpadding="0" cellspacing="0" background="image/122.jpg">
      <tr>
        <td width="384" height="99">&nbsp;</td>
        <td width="336">&nbsp;</td>
        <td width="357">&nbsp;</td>
      </tr>
      <tr>
        <td height="255">&nbsp;</td>
        <td>
		   
    <table width="309" border="0" align="center" height="237">
      <tr>
        <td height="80" colspan="3" align="center"><h1 class="STYLE1">管理员登录</h1></td>
      </tr>
      <tr>
        <td width="114" height="41" align="center"><h3>用户名:</h3></td>
        <td colspan="2"><input name="username" type="text" id="uid" size="20"></td>
      </tr>
      <tr>
        <td height="44" align="center"><h3>用户密码：</h3></td>
        <td colspan="2"><input name="password" type="password" id="pwd" size="20"></td>
      </tr>
      <tr>
        <td height="60" colspan="2" align="center">          <input type="submit" name="button" id="button" value="登录" onclick="return gao();">        </td>
        <td width="142" align="center"><label for="Submit"></label>
          <h1>
            <input type="button" name="Submit" value="退出" id="Submit" onclick="javascript:self.close()">
          </h1></td>
      </tr>
    </table>

		   
		</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="229">&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table>
  </form>
  
  </body>
</html>
