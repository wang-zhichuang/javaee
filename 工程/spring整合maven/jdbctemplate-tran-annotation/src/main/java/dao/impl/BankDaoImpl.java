package dao.impl;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.BankDao;
@Repository(value="bankDao")
public class BankDaoImpl implements BankDao{
@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	
	
	@Override
	public void inMoney(int money, int userId) {
		// TODO Auto-generated method stub
		String sql="update t_count2 set count=count+? where userId=?";
		jdbcTemplate.update(sql,money,userId);
	}

	@Override
	public void outMoney(int money, int userId) {
		// TODO Auto-generated method stub
		String sql="update t_count set count=count-? where userId=?";
		jdbcTemplate.update(sql,money,userId);
	}

}
