package com.net.spring.controll;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.net.spring.po.Emp;

public class MultiController extends MultiActionController {


	public ModelAndView to_add(HttpServletRequest request,
			HttpServletResponse response){
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("add_emp");
		System.out.println("����õ���to_add����");
		return null;
	}
	public ModelAndView add_emp(HttpServletRequest request,
			HttpServletResponse response,Emp emp){
		
		System.out.println("����õ���add_emp����");
		System.out.println(emp);
		return null;
		
	}
	

}
