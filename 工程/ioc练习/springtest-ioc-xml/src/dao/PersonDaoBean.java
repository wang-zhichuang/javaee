package dao;

public class PersonDaoBean implements PersonDao {
	public PersonDaoBean() {
		System.out.println("PersonDaoBean构造方法执行");
	}
public void save(){
      System.out.println("执行PersonDaoBean的save()方法"); 
 }

}
