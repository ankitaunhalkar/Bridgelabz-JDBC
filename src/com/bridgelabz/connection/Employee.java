package com.bridgelabz.connection;

public class Employee {
private int eid;
private String ename;
private String email;
private String elocation;
private long ephoneno;

public void setEid(int eid) {
	this.eid = eid;
}
public int getEid() {
	return eid;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getElocation() {
	return elocation;
}
public void setElocation(String elocation) {
	this.elocation = elocation;
}
public long getEphoneno() {
	return ephoneno;
}
public void setEphoneno(long ephoneno) {
	this.ephoneno = ephoneno;
}
public String toString() {
	return "Employee [eid=" + eid + ", ename=" + ename + ", email=" + email
			+ ", elocation=" + elocation + ", ephoneno=" + ephoneno + "]";
}

}
