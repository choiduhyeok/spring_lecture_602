package com.spring.dto;

import java.util.Date;

public class LoginDataVO {
	private String id;
	private String name;
	private String email;
	private String ip;
	private Date indate;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getIndate() {
		return indate;
	}
	public void setIndate(Date indate) {
		this.indate = indate;
	}
	@Override
	public String toString() {
		return "LogDataVO [id=" + id + ", name=" + name + ", email=" + email + ", ip=" + ip + ", indate=" + indate
				+ "]";
	}
	
	
}
