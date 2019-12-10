package cn.oneseek.studentspringboot.dao;

import cn.oneseek.studentspringboot.vo.Bj;

import java.util.List;

public interface BjDao {
	
	void add(Bj bj);

	public void update(Bj bj);

	public void delete(int id);

	public Bj findById(int id);

	public List<Bj> queryAll();

}
