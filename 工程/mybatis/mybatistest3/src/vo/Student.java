package vo;

public class Student {
int id;
String sno,sname,sex;
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
@Override
public String toString() {
	return "Student [id=" + id + ", sno=" + sno + ", sname=" + sname + ", sex=" + sex + "]";
}

}
