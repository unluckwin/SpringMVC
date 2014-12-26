package com.net.spring.po;

public class Emp {

	private Integer id;
	private String name;
	private Integer age;
	private String entrytime;
	private String sex;

	public String getName() {
		return name;
	}

	public String getEntrytime() {
		return entrytime;
	}

	public void setEntrytime(String entrytime) {
		this.entrytime = entrytime;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String toString() {
		return name + "," + age + "," + sex + "," + entrytime;

		// return name + "," + age + "," + new
		// SimpleDateFormat("yyyy-MM-dd").format(entrytime);
	}
}
