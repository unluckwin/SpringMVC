<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  
  <body>
  <form action="addemp.view" method="post">
    <div align="center"><h1>在这个页面你可以添加员工的个人信息，请认真添写</h1><br>
      <br/>
    <table width="335" border="0">
      <tr>
        <td width="53" height="32">姓名:</td>
        <td width="184"><input type="text" name="name"/></td>
        <td width="76">&nbsp;</td>
      </tr>
      <tr>
        <td height="31">年龄:</td>
        <td><input type="text" name="age"/></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="31">性别: </td>
        <td><select name="sex">
          <option value="boy">男</option>
          <option value="girl">女</option>
        </select></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="31">入职:</td>
        <td><input type="text" name="entrytime"/></td>
        <td><div align="center">
          <input type="submit" name="b1" value="提交"/>
        </div></td>
      </tr>
    </table>
    <br/>
    <br/>
    </div>
  </form>
  </body>
</html>
