package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JdbcUtil;
import vo.Bj;
import vo.Student;
public class StudentDao {

   public  void add(Student student) throws Exception{
	 Connection conn = null;
	 PreparedStatement ps = null;
	 try {
		 conn = JdbcUtil.getConnection();
		 String sql = "insert into student  values (null,?,?,?,?) ";
		 ps = conn.prepareStatement(sql);
		 ps.setString(1, student.getSno());
		 ps.setString(2,student.getSname());
		 ps.setString(3,student.getSex());
		 ps.setInt(4, student.getBj().getId());
		 ps.executeUpdate();
	 }finally {JdbcUtil.free(null,ps, conn);}
   }

   public void update(Student student) throws Exception{
	Connection conn = null;
	PreparedStatement ps = null;
	try {
		conn = JdbcUtil.getConnection();
		String sql = "update student set sno=?,sname=?,sex=?,bjid=? where id=? ";
		ps = conn.prepareStatement(sql);
		ps.setString(1,student.getSno());
		ps.setString(2,student.getSname());
		ps.setString(3, student.getSex());
		ps.setInt(4,student.getBj().getId());
		ps.setInt(5,student.getId());
		ps.executeUpdate();
	}finally {JdbcUtil.free(null,ps, conn);}
   }
   public void delete(int id) throws Exception{
	 Connection conn = null;
	 PreparedStatement ps = null;
	 try {
		conn = JdbcUtil.getConnection();
		String sql = "delete from student where id=?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1,id);
		ps.executeUpdate();
	}finally {JdbcUtil.free( null,ps, conn);}
   }
   public Student findStudentById(int id) throws Exception{
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Student student=null;
	try {
		conn = JdbcUtil.getConnection();
		String sql = "select student.id,sno,sname,sex,bjid,bj.bjname"
				+ " from student,bj where student.id=? and student.bjid=bj.id ";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		rs=ps.executeQuery();
		if(rs.next()){
		   student=new Student();
		   student.setId(rs.getInt(1));
		   student.setSno(rs.getString(2));
		   student.setSname(rs.getString(3));
		   student.setSex(rs.getString(4));
		   student.setBj(new Bj(rs.getInt(5),rs.getString(6)));
		}
	}finally {JdbcUtil.free(rs, ps, conn);}
	return student;
   }

   public List<Student> queryAll() throws Exception{
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	List<Student> studentList=new ArrayList<Student>();
	try {
		conn = JdbcUtil.getConnection();
		String sql = "select student.id,sno,sname,sex,bjid,bjname"
				+ " from student,bj where  student.bjid=bj.id ";
		ps=conn.prepareStatement(sql);
		rs=ps.executeQuery();
		while(rs.next()){
			   Student student=new Student();
			   student.setId(rs.getInt(1));
			   student.setSno(rs.getString(2));
			   student.setSname(rs.getString(3));
			   student.setSex(rs.getString(4));
			   student.setBj(new Bj(rs.getInt(5),rs.getString(6)));
		   studentList.add(student);
		}
	}finally {JdbcUtil.free(rs, ps, conn);}
	return studentList;
   }
}
