package dao;

import java.util.List;

import vo.Bj;
import vo.Student;

public interface BjDao {
	
	void add(Bj bj);

	public void update(Bj bj);

	public void delete(int id);

	public Bj findById(int id);

	public List<Bj> queryAll();
	
	public Bj findByIdWithStudents(int id);

}
