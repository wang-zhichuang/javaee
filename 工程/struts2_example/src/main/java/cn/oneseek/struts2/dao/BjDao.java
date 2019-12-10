package cn.oneseek.struts2.dao;


import cn.oneseek.struts2.util.JdbcUtil;
import cn.oneseek.struts2.vo.Bj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BjDao {
   //向数据库中添加用户记录的方法add()
   public void add(Bj bj) throws Exception {
	 Connection conn = null;
	 PreparedStatement ps = null;
	 try {
		 conn = JdbcUtil.getConnection();
		 String sql = "insert into bj  values (null,?) ";
		 ps = conn.prepareStatement(sql);
		
		 ps.setString(1, bj.getBjname());		
		 ps.executeUpdate();
	 }finally {JdbcUtil.free(null,ps, conn);}
   }
   //修改数据库用户记录的方法update()
   public void update(Bj bj) throws Exception {
	Connection conn = null;
	PreparedStatement ps = null;
	try {
		conn = JdbcUtil.getConnection();
		String sql = "update bj set bjname=? where id=? ";
		ps = conn.prepareStatement(sql);
		ps.setString(1,bj.getBjname());
		ps.setInt(2,bj.getId());		
		ps.executeUpdate();
	}finally {JdbcUtil.free(null,ps, conn);}
   }
   //删除数据库用户记录的方法delete()
   public void delete(int id) throws Exception {
	 Connection conn = null;
	 PreparedStatement ps = null;
	 try {
		conn = JdbcUtil.getConnection();
		String sql = "delete from bj where id=?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1,id);
		ps.executeUpdate();
	}finally {JdbcUtil.free( null,ps, conn);}
   }
   //根据id查询用户的方法findBjById()
   public Bj findBjById(int id) throws Exception {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Bj bj=null;
	try {
		conn = JdbcUtil.getConnection();
		String sql = "select * from bj where id=? ";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		rs=ps.executeQuery();
		if(rs.next()){
		   bj=new Bj();
		   bj.setId(rs.getInt(1));
		   bj.setBjname(rs.getString(2));		  
		}
	}finally {JdbcUtil.free(rs, ps, conn);}
	return bj;
   }
   //查询全部用户的方法QueryAll()
   public List<Bj> queryAll() throws Exception {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	List<Bj> bjList=new ArrayList<Bj>();
	try {
		conn = JdbcUtil.getConnection();
		String sql = "select * from bj ";
		ps=conn.prepareStatement(sql);
		rs=ps.executeQuery();
		while(rs.next()){
		   Bj bj=new Bj();
		   bj.setId(rs.getInt(1));
		   bj.setBjname(rs.getString(2));
		   bjList.add(bj);
		}
	}finally {
		JdbcUtil.free(rs, ps, conn);
	}
	return bjList;
   }
}
