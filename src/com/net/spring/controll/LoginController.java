package com.net.spring.controll;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.net.spring.po.User;
import com.net.spring.service.UserService;

public class LoginController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		User u=new User();
		UserService us=new UserService();
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		String result=us.login(username,password);
		String tiao="fail";
		if(result.equals("³É¹¦"))
		{
			//tiao="success";
			tiao="addemp";
		}
		
		// TODO Auto-generated method stub
		return new ModelAndView(tiao);
	}

}
