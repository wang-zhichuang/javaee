import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.StudentDao;
import util.SqlSessionFactoryUtil;
import vo.Student;

public class StudentDaoTest {
	private SqlSession sqlSession=null;
	private StudentDao studentDao=null;
	@Before
	public void setUp() throws Exception {
		sqlSession=SqlSessionFactoryUtil.openSession();
		studentDao=sqlSession.getMapper(StudentDao.class);
	}

	@After
	public void tearDown() throws Exception {
		sqlSession.close();
	}

	
	@Test
	public void testQueryAll() {
		
		List<Student> studentList=studentDao.queryAll();
		for(Student student:studentList) {
			System.out.println(student);
		}
	}
	@Test
	public void testqueryAllWithBj() {
		
		List<Student> studentList=studentDao.queryAllWithBj();
		for(Student student:studentList) {
			System.out.println(student);
		}
	}

}
