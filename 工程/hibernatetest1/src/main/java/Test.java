
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import po.User;

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
		User user = new User();
		user.setName("ÕÅÈý123");
		user.setSex("ÄÐ");
		session.save(user);

		tx.commit();
		session.close();

	}

}
