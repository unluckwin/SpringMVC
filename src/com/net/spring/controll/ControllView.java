package com.net.spring.controll;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ControllView implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("�һ���������Ҫ��ҳ����ȥ");
		return new ModelAndView("/WEB-INF/jsp/start.jsp");
	}

}
