package com.saeyan.javabeans;

public class MemberBean {
    private String name;
    private String userid;
    private String pwd;
    private String email;
    private String phone;
    private String admin;
    
    
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "MemberBean [name = " + name + ", userid = " + userid + "]";
	}
	public MemberBean(String name, String userid) {
		this.name = name;
		this.userid = userid;
	}
	public MemberBean() {
	}
    
}
