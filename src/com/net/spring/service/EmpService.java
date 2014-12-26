package com.net.spring.service;

import com.net.spring.dao.EmpDao;
import com.net.spring.dao.impl.EmpDaoImpl;
import com.net.spring.po.Emp;

public class EmpService {
     
	public void addemp(Emp emp)
      {
    	  EmpDao ed=new EmpDaoImpl();
    	  ed.addemp(emp);
      }
	public void updata(String str,Emp emp)
	{
		 EmpDao ed=new EmpDaoImpl();
   	     ed.updataemp(str, emp);
	}
	public void delete(String flag)
	{
		 EmpDao ed=new EmpDaoImpl();
		 ed.deleteemp(flag);
   	     
	}
}
