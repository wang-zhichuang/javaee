package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.BjDao;
import vo.Bj;
@Service
public class BjService implements IBjService {

	@Resource
	BjDao bjDao;
	public void add(Bj bj) {
		// TODO Auto-generated method stub
bjDao.add(bj);
	}

	@Override
	public void update(Bj bj) {
		// TODO Auto-generated method stub
bjDao.update(bj);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
bjDao.delete(id);
	}

	@Override
	public Bj findById(int id) {
		// TODO Auto-generated method stub
		return bjDao.findById(id);
	}

	@Override
	public List<Bj> queryAll() {
		// TODO Auto-generated method stub
		return bjDao.queryAll();
	}

}
