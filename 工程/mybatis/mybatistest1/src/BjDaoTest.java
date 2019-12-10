import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.BjDao;
import util.SqlSessionFactoryUtil;
import vo.Bj;

public class BjDaoTest {
	private SqlSession sqlSession=null;
	private BjDao bjDao=null;
	@Before
	public void setUp() throws Exception {
		sqlSession=SqlSessionFactoryUtil.openSession();
		bjDao=sqlSession.getMapper(BjDao.class);
	}

	@After
	public void tearDown() throws Exception {
		sqlSession.close();
	}

	@Test
	public void testAdd() {
		Bj bj=new Bj("开发1班");
		bjDao.add(bj);
		sqlSession.commit();
	}
	@Test
	public void testUpdate() {
		Bj bj=new Bj("计开发1班");
		bj.setId(2);
		bjDao.update(bj);
		sqlSession.commit();
	}
	@Test
	public void testDelete() {
		
		bjDao.delete(2);
		sqlSession.commit();
	}
	@Test
	public void testFindById() {
		
		Bj bj=bjDao.findById(1);
		System.out.println(bj.getBjname());
	}
	@Test
	public void testQueryAll() {
		
		List<Bj> bjList=bjDao.queryAll();
		for(Bj bj:bjList) {
			System.out.println(bj);
		}
	}

}
