package com.petpet.bean;

public class LoginBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private String memberid;
	private String email;
	private String password;
	private String firstname;
	private String lastname;
	private String gender;
	private String birthday;
	private String mobile;
	
	public String getMemberid() {  return memberid;  }
	public String getEmail() {  return email;  }
	public String getPassword() {  return password;  }
	public String getFirstname() {  return firstname;  }
	public String getLastname() {  return lastname;  }
	public String getGender() {  return gender;  }
	public String getBirthday() {  return birthday;  }
	public String getMobile() {  return mobile;  }
	
	public void setMemberid(String memberid) {  this.memberid = memberid;  }
	public void setEmail(String email) {  this.email = email;  }
	public void setPassword(String password) {  this.password = password;  }
	public void setFirstname(String firstname) {  this.firstname= firstname;  }
	public void setLastname(String lastname) {  this.lastname = lastname;  }
	public void setGender(String gender) {  this.gender= gender;	}
	public void setBirthday(String birthday) {  this.birthday= birthday;	}
	public void setMobile(String mobile) {  this.mobile= mobile;	}
	
}
