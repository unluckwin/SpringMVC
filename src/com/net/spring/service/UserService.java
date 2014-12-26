package com.net.spring.service;

import com.net.spring.dao.UserDao;

public class UserService {

	public String login(String username,String password)
	{
		UserDao ud=new UserDao();
		String result=ud.checklogin(username);
		String results="Ê§°Ü";
		if(password.equals(result))
		{
			results="³É¹¦ba";
		}
		return results;
	}
}
