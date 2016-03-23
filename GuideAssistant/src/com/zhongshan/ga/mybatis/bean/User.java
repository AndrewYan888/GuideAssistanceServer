package com.zhongshan.ga.mybatis.bean;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5035526758143100240L;
	public User() {
		
	}
	
	public User(int id, String userName, int userAge, String userAddress){
		this.id = id;
		this.userName = userName;
		this.userAge = userAge;
		this.userAddress = userAddress;
	}

	// 实体类的属性和表的字段名称一一对应
	private int id;
	private String userName;
	private int userAge;
	private String userAddress;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	
	
	
}
