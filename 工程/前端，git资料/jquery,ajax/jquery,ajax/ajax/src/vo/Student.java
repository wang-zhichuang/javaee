package vo;
public class Student{
	String sno,sname,sex;   
	
	public Student() {
		super();
	}

	public Student(String sno, String sname, String sex) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sex = sex;
	}
    
	public String toString(){
		return "学号："+sno+",姓名："+sname+",性别："+sex;
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
	
}