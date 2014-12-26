package com.net.spring.controll;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.net.spring.po.Emp;

public class CommandController extends AbstractCommandController {

	@Override
	protected ModelAndView handle(HttpServletRequest req,
			HttpServletResponse res, Object command, BindException exception)
			throws Exception {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		Emp emp = (Emp) command;
		System.out.println(emp);
		return null;
	}

	@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd"), true));
	}

}
