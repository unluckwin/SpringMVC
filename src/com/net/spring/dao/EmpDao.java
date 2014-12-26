package com.net.spring.dao;

import java.util.List;

import com.net.spring.po.Emp;
import com.net.spring.po.SplitPage;

public interface EmpDao {
     
	public void addemp(Emp emp);
	public Emp queryemp(String str);
	public void updataemp(String str,Emp emp);
	public void deleteemp(String flag);
	public int getRows();
	public List<Emp> allemploy(SplitPage sp);
}
