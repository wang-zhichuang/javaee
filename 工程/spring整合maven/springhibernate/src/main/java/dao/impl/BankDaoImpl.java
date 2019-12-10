package dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import dao.BankDao;
import entity.Count;
@Repository(value="bankDao")
public class BankDaoImpl implements BankDao{
@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public void inMoney(int money, int id)  {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();	
		Count count=(Count)session.get(Count.class,id);
		count.setCount(count.getCount()+money);
		sessionFactory.getCurrentSession().update(count);
		
	}

	@Override
	public void outMoney(int money, int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Count count=(Count)session.get(Count.class,id);
		count.setCount(count.getCount()-money);
		sessionFactory.getCurrentSession().update(count);
	}

}
