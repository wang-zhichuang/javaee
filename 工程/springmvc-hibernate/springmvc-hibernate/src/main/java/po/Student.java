package po;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
	@Id
	private int id;
	private String sno,sname,sex;

	@ManyToOne(targetEntity = Bj.class)
			@JoinColumn(name = "bjid")
	private Bj bj;

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

	public Bj getBj() {
		return bj;
	}
	public void setBj(Bj bj) {
		this.bj = bj;
	}


}
