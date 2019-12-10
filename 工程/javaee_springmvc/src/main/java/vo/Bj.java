package main.java.vo;

public class Bj {
int id;
String bjname;
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
public Bj(int id, String bjname) {
	super();
	this.id = id;
	this.bjname = bjname;
}
public Bj() {
	super();
}

}
