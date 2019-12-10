
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import po.Student;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure();
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sessionFactory = new MetadataSources(ssr).buildMetadata().buildSessionFactory();
		Session session = null;
		Transaction tx = null;
		session = sessionFactory.openSession();

		tx = session.beginTransaction();
		Student student=new Student();
		student.setSno("20171234");
        student.setSname("ÀîËÄ");
        student.setSex("Å®");
        session.save(student);
		tx.commit();
		session.close();

	}

}
