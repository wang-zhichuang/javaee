import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.BjDao;
import util.SqlSessionFactoryUtil;
import vo.Student;

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
	public void testfindByIdWithStudents() {
		
		List<Student> students=bjDao.findByIdWithStudents(1).getStudents();
		for(Student student:students) {
			System.out.println(student);
		}
	}
}
