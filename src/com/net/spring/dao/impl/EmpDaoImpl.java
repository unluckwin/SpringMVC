package com.net.spring.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.net.spring.dao.EmpDao;
import com.net.spring.po.Emp;
import com.net.spring.po.SplitPage;

public class EmpDaoImpl implements EmpDao {

	//获取第几页中数据
	public int getRows() {
		int sum = 0;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
							"spring", "spring");
			stat = conn.prepareStatement("select * from emp_employ");
			rs = stat.executeQuery();
			while (rs.next()) {
				sum++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sum;
	}

	//添加员工的后台代码
	public void addemp(Emp emp) {

		String sql = "insert into emp_employ values ((select nvl(max(id),0)+1 from emp_employ),?,?,?,?)";
		Connection conn = null;
		PreparedStatement stat = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date date = null;
		try {
			date = sdf.parse(emp.getEntrytime());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		java.sql.Date time = new java.sql.Date(date.getTime());
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
							"spring", "spring");
			stat = conn.prepareStatement(sql);
			stat.setString(1, emp.getName());
			stat.setInt(2, emp.getAge());
			stat.setString(3, emp.getSex());
			stat.setDate(4, time);
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}
   //根据id号来查询员工的信息
	public Emp queryemp(String str) {
		// TODO Auto-generated method stub

		int i = Integer.parseInt(str);
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		Emp emp = new Emp();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
							"spring", "spring");
			stat = conn.prepareStatement("select * from emp_employ where id=?");
			stat.setInt(1, i);
			rs = stat.executeQuery();
			if (rs.next()) {
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setAge(rs.getInt("age"));
				emp.setSex(rs.getString("sex"));
				emp.setEntrytime(new SimpleDateFormat("yyyy-MM-dd").format(rs
						.getDate("entrytime")));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}
 
	//根据id号来更新员工的信息
	public void updataemp(String str, Emp emp) {
		// TODO Auto-generated method stub
		int i = Integer.parseInt(str);
		Connection conn = null;
		PreparedStatement stat = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date date = null;
		try {
			date = sdf.parse(emp.getEntrytime());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		java.sql.Date time = new java.sql.Date(date.getTime());
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
							"spring", "spring");
			stat = conn
					.prepareStatement("update emp_employ set name=?,age=?,sex=?,entrytime=? where id=?");
			stat.setString(1, emp.getName());
			stat.setInt(2, emp.getAge());
			stat.setString(3, emp.getSex());
			stat.setDate(4, new java.sql.Date(date.getTime()));
			stat.setInt(5, i);
			stat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//根据id号来删除员工的信息
	public void deleteemp(String flag) {
		// TODO Auto-generated method stub
		int i = Integer.parseInt(flag);
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
							"spring", "spring");
			stat = conn.prepareStatement("delete from emp_employ where id=?");
			stat.setInt(1, i);
			stat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//获取数据库中的所有员工信息
	public List<Emp> allemploy(SplitPage sp) {
		// TODO Auto-generated method stub
		String sql = "select t2.* from (select rownum r,t1.* from (select * from emp_employ) t1 where rownum<="
				+ sp.getPageRows()
				* sp.getCurrentPage()
				+ ") t2 where t2.r>"
				+ (sp.getCurrentPage() - 1) * sp.getPageRows() + "";
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		List<Emp> list = new ArrayList<Emp>();
		Emp emp = new Emp();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
							"spring", "spring");
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			while (rs.next()) {
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setAge(rs.getInt("age"));
				emp.setSex(rs.getString("sex"));
				emp.setEntrytime(new SimpleDateFormat("yyyy-MM-dd").format(rs
						.getDate("entrytime")));
				list.add(emp);
				emp = new Emp();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

}
