package com.net.spring.controll;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class ParamController extends MultiActionController {

	public ModelAndView to_add(HttpServletRequest request,
			HttpServletResponse response){
		String str=request.getParameter("name");
		System.out.println("�������to_add����,����ǣ�" + str);
		return null;
	}
}
