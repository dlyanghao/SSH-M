package com.yanghao.bean;

import java.io.Serializable;

/**
 * 工具类
 * @author YanoHao
 *
 */
public class Actor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer aid;
	private String name;
	private String age;
	private String birthday;
	private String area;
	
	public Actor() {

	}

	
	public Integer getAid() {
		return aid;
	}


	public void setAid(Integer aid) {
		this.aid = aid;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}


	@Override
	public String toString() {
		return "Actor [aid=" + aid + ", name=" + name + ", age=" + age + ", birthday=" + birthday + ", area=" + area
				+ "]";
	}

}
