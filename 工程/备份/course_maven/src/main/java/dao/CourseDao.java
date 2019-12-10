package dao;

import entity.Course;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {
   //向数据库中添加用户记录的方法add()
  
   //查询全部用户的方法QueryAll()
   public List<Course> queryByPageNo(String condition,int pageNo,int pageSize) throws Exception{
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	List<Course> courseList=new ArrayList<Course>();
	try {
		conn = JdbcUtil.getConnection();
		String sql = "select * from course "+condition+" limit ?,?";
		ps=conn.prepareStatement(sql);
		ps.setInt(1, pageSize*(pageNo-1));
		ps.setInt(2, pageSize);
		rs=ps.executeQuery();
		while(rs.next()){
		   Course course=new Course();
		   course.setId(rs.getInt(1));
		  course.setXy(rs.getString("xy"));
		  course.setKxh(rs.getString("kxh"));
		  
		  course.setKch(rs.getString("kch"));
		  course.setKcm(rs.getString("kcm"));
		  course.setRkjs1(rs.getString("rkjs1"));
		  course.setSksj(rs.getString("sksj"));
		  course.setSkzc(rs.getString("skzc"));
		  course.setSkdd(rs.getString("skdd"));
		  course.setBj(rs.getString("bj"));
		  course.setXq(rs.getString("xq"));
		  course.setNj(rs.getString("nj"));
		   courseList.add(course);
		}
	}finally {
        JdbcUtil.free(rs, ps, conn);}
	return courseList;
   }
   public void delete(String[] ids) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;		
		try {
			conn = JdbcUtil.getConnection();
			String sql = "delete from course where id=?";
			ps=conn.prepareStatement(sql);
			for(String id:ids){
				ps.setInt(1,Integer.parseInt(id));
				ps.addBatch();
			}
			ps.executeBatch();
			
		}finally {
            JdbcUtil.free(null, ps, conn);}
		
	   }
   public int recordCount(String condition) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;	
		int recordCount=0;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select count(*) from course "+condition;
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			rs.next();
			recordCount=rs.getInt(1);
		}
		finally {
            JdbcUtil.free(null, ps, conn);}
		return recordCount;
	   }
}
