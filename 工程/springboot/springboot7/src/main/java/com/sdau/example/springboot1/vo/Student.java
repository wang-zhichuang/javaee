package com.sdau.example.springboot1.vo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {
int id;
String sno,sname,sex;
Bj bj;
@Id
@GeneratedValue
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getSno() {
	return sno;
}
public void setSno(String sno) {
	this.sno = sno;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
@ManyToOne
@JoinColumn(name="bjid")
public Bj getBj() {
	return bj;
}
@Override
public String toString() {
	return "Student [id=" + id + ", sno=" + sno + ", sname=" + sname + ", sex=" + sex + ", bj=" + bj + "]";
}
public void setBj(Bj bj) {
	this.bj = bj;
}


}
