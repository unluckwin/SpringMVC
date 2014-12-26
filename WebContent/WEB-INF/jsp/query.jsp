<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.net.spring.po.*,com.net.spring.dao.*,com.net.spring.dao.impl.*" %>
<jsp:useBean id="spage" class="com.net.spring.po.SplitPage" scope="session"></jsp:useBean> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript"> 
         function go(){ 
                     var goPage=document.all.selectpage.value; 
                     alert("我们将去页面:query.view?flag="+goPage); 
                     document.open("query.view?flag="+goPage,"_self",""); 
         } 
 </script>
  </head>
  
  <body>
   <% 
    EmpDao ed=new EmpDaoImpl();
  //翻页时的方向值,即SplitPage中请求标识参数 
   String flag=request.getParameter("flag"); 
   int totalRows=ed.getRows();
   spage.setTotalRows(totalRows);
   int currentPage=spage.confirmPage(flag);
   //System.out.println("currentPage=="+currentPage);
   ArrayList<Emp> bl=(ArrayList<Emp>)ed.allemploy(spage);
     %>
    <h1 align="center"> 你好，你可以看到所有的在职员工！</h1> 
    <div align="center"><br>
    </div>
    <h3 align="center">同时你可以进行修改和删除操作了，请放心操作。</h3>
    <form action="querybook" method="post">
      <div align="center">
        <table width="585">
          <tr>
            <td width="103"><div align="center">姓名：</div></td>
            <td width="90"><div align="center">性别：</div></td>
            <td width="87"><div align="center">年龄：</div></td>
            <td width="117"><div align="center">入职时间：</div></td>
            <td colspan="2"><div align="center">操作</div></td>
	      </tr>
          <% for(Emp b:bl)
      {  session.setAttribute("B",b);
         
       %>
          <tr>
            <td><div align="center">${B.name }</div></td>
            <td><div align="center">${B.sex }</div></td>
            <td><div align="center">${B.age }</div></td>
            <td><div align="center">${B.entrytime }</div></td>
            <td width="88"><div align="center"><a href="updata.view?flag=${B.id }">修改</a></div></td>
            <td width="72"><div align="center"><a href="deleteemp.view?flag=${B.id }">删除</a></div></td>
          </tr>
          <%} %>
          <tr>
            <td>&nbsp;</td>
            <td></td>
          </tr>
          <tr>
            <td colspan="3" align="center">【 <a href="query.view?flag=<%=SplitPage.FIRSTPAGE%>">首页</a> <a href="query.view?flag=<%=SplitPage.PREVIOUSEPAGE %>">上一页</a> <a href="query.view?flag=<%=SplitPage.NEXTPAGE %>">下一页</a> <a href="query.view?flag=<%=SplitPage.LASTPAGE %>">最后页</a>
              <select id="selectpage" name="goPage" onChange="javascript:go();">
                <%  for(int i=1;i<=spage.getTotalPages();i++){ 
                                %>
                <option value="<%=i%>" <%=(spage.getCurrentPage()==i)?"selected='selected'":"" %>><%=i%>/<%=spage.getTotalPages()%>
                <%}%>
                </option>
                </select>
              】</td>
			  <td><div align="center">
			    <input name="button" type="button" onClick="javascript:history.back()" value="返回"/>
		      </div></td>
          </tr>
        </table>
      </div>
    </form>
    
  </body>
</html>
