package com.net.spring.service;

import com.net.spring.dao.UserDao;

public class UserService {

	public String login(String username,String password)
	{
		UserDao ud=new UserDao();
		String result=ud.checklogin(username);
		String results="ʧ��";
		if(password.equals(result))
		{
			results="�ɹ�ba";
		}
		return results;
	}
}
