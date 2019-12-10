package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import vo.Article;

@Repository
public class ArticleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 查
    public Article find(int id) {
        final String sql = "select * from article where id=?";
       Article ac = jdbcTemplate.queryForObject(sql, new Object[] { id },new BeanPropertyRowMapper<Article>(Article.class));     
       return ac;
    }

    // 改
    public boolean update(Article a) {
        final String sql = "update article set title=?,content=? where id=?";
        //int rc = jdbcTemplate.update(sql, new Object[] { a.getTitle(), a.getContent(), a.getId() });
        int rc = jdbcTemplate.update(sql, a.getTitle(), a.getContent(), a.getId());
        return 1 == rc;
    }

    // 删
    public boolean delete(int id) {
        final String sql = "delete from article where id=?";
       // int rc = jdbcTemplate.update(sql, new Object[] { id });
        int rc = jdbcTemplate.update(sql, id);
        return 1 == rc;
    }

    // 增
    public int add(Article a) {
        KeyHolder holder = new GeneratedKeyHolder();
        final String sql = "insert into article(title,content) values(?,?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, a.getTitle());
                ps.setString(2, a.getContent());
                return ps;
            }
        }, holder);
        return holder.getKey().intValue();
    }

    //根据开始和限定条数查询多条
    public List<Article> list(int begin, int limit) {
        final String sql = "select * from article limit ?,?";
        return jdbcTemplate.query(sql, new Object[] { begin, limit },
                new BeanPropertyRowMapper<Article>(Article.class));
    }
   
}
