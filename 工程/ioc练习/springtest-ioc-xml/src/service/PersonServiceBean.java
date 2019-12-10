package service;

import dao.PersonDao;

public class PersonServiceBean implements PersonService {
	 PersonDao personDao ;
	
	 
	public PersonServiceBean() {
		System.out.println("PersonServiceBean构造方法执行");
	}

	public PersonDao getPersonDao() {
		return personDao;
	}

	//利用set方法注入依赖对象
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	public void save(){
         personDao.save();
  }


}
