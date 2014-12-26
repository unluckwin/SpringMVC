package com.net.spring.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.net.spring.po.User;

public class UserDao {
	
	 public String checklogin(String username)
	 {
		    User u=new User();
		    Connection conn=null;
	    	PreparedStatement stat=null;
	    	ResultSet rs=null;
	    	try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","spring","spring");
				stat=conn.prepareStatement("select * from emp_user where username=?");
				stat.setString(1, username);
				rs=stat.executeQuery();
				if(rs.next())
				{
					u.setUsername(username);
					u.setPassword(rs.getString("password"));
				}
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    		
		 return u.getPassword();
	 }

}
