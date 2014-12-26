package com.net.spring.controll;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.net.spring.po.Emp;
import com.net.spring.service.EmpService;

public class AutoAllController extends MultiActionController {

	public ModelAndView next(HttpServletRequest request,
			HttpServletResponse response) {
		String str = request.getParameter("flag");
		System.out.println("你调用了to_add方法,结果是：" + str);
		return new ModelAndView("query");
	}

	public ModelAndView updata(HttpServletRequest request,
			HttpServletResponse response) {

		return new ModelAndView("updata");
	}
	public ModelAndView updataemp(HttpServletRequest request,
			HttpServletResponse response) {
		Emp emp=new Emp();
		EmpService es=new EmpService();
		String id=request.getParameter("id");
        String name=request.getParameter("name");
        String sex=request.getParameter("sex");
        String age=request.getParameter("age");
        String entrytime=request.getParameter("entrytime");
        emp.setName(name);
        emp.setSex(sex);
        emp.setAge(Integer.parseInt(age));
        emp.setEntrytime(entrytime);
        es.updata(id,emp);  
		return new ModelAndView("query");
	}
	public ModelAndView deleteemp(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		String flag=request.getParameter("flag");
		System.out.println(flag);
		EmpService es=new EmpService();
		es.delete(flag);
		
	    try {
		PrintWriter out = response.getWriter();
		out.println("<html><body><script lanaguage='javascript'>alert('删除 成功');location.href='query.view'</script></body></html>");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
