package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import vo.Bj;

public interface BjDao {
	
	void add(Bj bj);

	public void update(Bj bj);

	public void delete(int id);

	public Bj findById(int id);

	public List<Bj> queryAll();

}
