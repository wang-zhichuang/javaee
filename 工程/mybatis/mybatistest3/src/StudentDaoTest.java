import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
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
	public void testSearchStudents1() {
		
		Map<String,Object> map=new HashMap<String,Object>();
		
		map.put("sname", "%李%");
	
		List<Student> studentList=studentDao.searchStudents1(map);
		for(Student student:studentList){
			System.out.println(student);
		}
	}
	
	@Test
	public void testSearchStudents2() {
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("searchBy", "sname");
		map.put("searchValue","%李%");
	
		List<Student> studentList=studentDao.searchStudents2(map);
		for(Student student:studentList){
			System.out.println(student);
		}
	}

	@Test
	public void testSearchStudents3() {
		
		Map<String,Object> map=new HashMap<String,Object>();
		
		map.put("sname", "%李%");
		
		List<Student> studentList=studentDao.searchStudents3(map);
		for(Student student:studentList){
			System.out.println(student);
		}
	}
	@Test
	public void testSearchStudents4() {
		
		Map<String,Object> map=new HashMap<String,Object>();
	
		 map.put("sname", "%李%");
		
		List<Student> studentList=studentDao.searchStudents4(map);
		for(Student student:studentList){
			System.out.println(student);
		}
	}
	
	@Test
	public void testsearchStudents5(){
		
		
		List<Integer> ids=new ArrayList<Integer>();
		
		ids.add(1);ids.add(2);
		
		List<Student> studentList=studentDao.searchStudents5(ids);
		for(Student student:studentList){
			System.out.println(student);
		}
	}
	@Test
	public void testsearchStudents6(){
		
		List<Student> studentList=studentDao.searchStudents6("%李%","男");
		for(Student student:studentList){
			System.out.println(student);
		}
	}
	@Test
	public void testsearchStudents7(){
		int offset=0,limit=3;
		RowBounds rowBounds=new RowBounds(offset,limit);
		List<Student> studentList=studentDao.searchStudents7(rowBounds);
		for(Student student:studentList){
			System.out.println(student);
		}
	}
	
	@Test
	public void testsearchStudents8(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("start", 0);
		map.put("size", 3);
		List<Student> studentList=studentDao.searchStudents8(map);
		for(Student student:studentList){
			System.out.println(student);
		}
	}
	@Test
	public void testupdateStudent(){
		
		Student student=new Student();
		student.setId(1);
		student.setSno("001");
		student.setSname("张三");
		studentDao.updateStudent(student);
		sqlSession.commit();
	}

}
