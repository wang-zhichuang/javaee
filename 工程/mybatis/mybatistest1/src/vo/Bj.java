package vo;

public class Bj {
int id;
String bjname;

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
@Override
public String toString() {
	return "Bj [id=" + id + ", bjname=" + bjname + "]";
}


}
