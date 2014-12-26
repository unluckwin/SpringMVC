package com.net.spring.controll;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.net.spring.po.Emp;
import com.net.spring.service.EmpService;

public class AddEmpController extends AbstractCommandController {

	@Override
	protected ModelAndView handle(HttpServletRequest req,
			HttpServletResponse res, Object command, BindException arg3)
			throws Exception {
		// TODO Auto-generated method stub
		Emp emp=(Emp)command;
		EmpService es=new EmpService();
		es.addemp(emp);
		return new ModelAndView("query");
	}

}
