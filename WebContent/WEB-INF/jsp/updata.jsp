<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.net.spring.po.*,com.net.spring.dao.*,com.net.spring.dao.impl.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index2.jsp' starting page</title>
    
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
  <% request.setCharacterEncoding("utf-8");
     String str=request.getParameter("flag");
    
     EmpDao ed=new EmpDaoImpl();
     Emp e=ed.queryemp(str);
     request.setAttribute("Eo",e);
   %>
  <h1 align="center">欢迎进入修改界面</h1> 
   <br>
   <form action="updataemp.view" method="post">
     <div align="center">
       <table>
         <tr> <td width="168"><div align="center">姓名：</div></td> 
      <td width="172">性别：</td>
      <td width="172">年龄</td>
      <td width="172">入职时间：</td>
      <td width="62"> 操作</td>
      </tr>
         <tr>&nbsp;<td><input type="text" value=${Eo.name } name="name"/></td>
      <td>&nbsp;<input type="text" value=${Eo.sex } name="sex"/></td>
      <td>&nbsp;<input type="text" value=${Eo.age } name="age"/></td>
      <td>&nbsp;<input type="text" value=${Eo.entrytime } name="entrytime"/></td>
      <td><input name="submit" type="submit" value="提交"/></td>
        </tr>
         <tr> 
           <td>&nbsp;
         <input type="hidden" value="<%=str %>" name="id"/></td></tr>
        </table>
     </div>
   </form>
  </body>
</html>
