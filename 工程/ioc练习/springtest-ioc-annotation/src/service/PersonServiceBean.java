package service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.PersonDao;
@Service
public class PersonServiceBean implements PersonService {
	@Resource(name="personDaoBean")
	 PersonDao personDao ;
	
	 
	public PersonServiceBean() {
		System.out.println("PersonServiceBean构造方法执行");
	}

	

	public void save(){
         personDao.save();
  }


}
