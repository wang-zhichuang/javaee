package com.sdau.example.springboot1.vo;

import java.util.List;

public class Bj {
int id;
String bjname;
List<Student> students;
public Bj() {
	super();
}
public Bj(String bjname) {
	
	this.bjname = bjname;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getBjname() {
	return bjname;
}
public void setBjname(String bjname) {
	this.bjname = bjname;
}

public List<Student> getStudents() {
	return students;
}
public void setStudents(List<Student> students) {
	this.students = students;
}
@Override
public String toString() {
	return "Bj [id=" + id + ", bjname=" + bjname + "]";
}


}
